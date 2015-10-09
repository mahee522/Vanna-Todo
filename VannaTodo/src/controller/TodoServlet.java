package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.transaction.TodoTrxAction;
import com.vanna.excp.DAOException;
import com.vanna.excp.VannaBusinessException;

public class TodoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doPost(request, response);
		System.out.println("Enterd into get method");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException 
	{
			
try{
			
			java.util.Enumeration _enum = request.getParameterNames();
			while (_enum.hasMoreElements())
			{
				String name = (String) _enum.nextElement();
				System.out.println("Parameter "+name + " " + request.getParameter(name));
			}
			String _cat = (String) request.getParameter("_action");
			String _action = (String) request.getParameter("category");
			
			
			if((_action != null && _action.equalsIgnoreCase("loginAction") )|| _action == null){	
				
				 if (new TodoLoginAction().validateUser(request.getParameter("userId"), request.getParameter("password"))) {
				    
				    System.out.println("Hello your authorized user...");
				    HttpSession session=request.getSession(true);
				    session.setAttribute("userId", request.getParameter("userId"));
				    session.setMaxInactiveInterval(10*60);
				    
				    new TodoTrxAction().process(request, response);
				    
				    
				    request.getRequestDispatcher("NewHome.jsp").forward(request, response);
				   } else {   	   
					   (request.getRequestDispatcher("LoginFialure.jsp")).forward(request, response);
				   }
			
			} else if(new TodoLoginAction().isUserAutorized((String) request.getSession().getAttribute("userId"), _action)){
						new TodoTrxAction().process(request, response);
						request.getRequestDispatcher("NewHome.jsp").forward(request, response);
			}
			
		}catch(VannaBusinessException vbx){
			throw new ServletException(vbx);
		}catch(DAOException vdx){
			throw new ServletException(vdx);
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
