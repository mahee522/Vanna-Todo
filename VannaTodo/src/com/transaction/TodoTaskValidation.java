package com.transaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TodoTaskValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		
		String taskName=request.getParameter("taskName");
		String taskDesc=request.getParameter("taskDesc");
		
		if(taskName.isEmpty()||taskDesc.isEmpty())
		{
			pw.println("* columns are must entered");
		}
		
		if(taskName.length()==15)
		{
			pw.println("* the category value is exceeded");
		}
		if(taskDesc.length()==50)
		{
			pw.println("* the categoryDesc value is exceeded");
		}
		response.sendRedirect("*----URL-----*");
		
	}

}
