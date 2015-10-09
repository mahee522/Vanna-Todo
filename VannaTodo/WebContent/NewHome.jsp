<%@page import="domain.TodoCategory"%>
<%@page import="java.util.Locale.Category"%>
<%@page import="domain.TodoTask"%>
<%@page import="java.util.ArrayList"%>
<html>
    <head>
        <title>To Do List</title>
        <style>
body,html {
	margin:0;
   padding:0;
				}	
.absolute0 {
  position: absolute;
  top: 10px;
  left: 246px;
  
}
         
.absolute {
  position: absolute;
  top: 80px;
  left: 246px;
  padding: 0px;
   margin:0;
  
}
.absolute1 {
  position: absolute;
  top: 185px;
  left: 246px;
  padding: 0px;
   margin:0;
  
}
 .absolute2 {
  position: absolute;
  top: 220px;
  left: 246px;

  
} 

a:{text-decoration: underline;
}
        </style>
    <script>       
        function loadInbox(){
        	alert('load inbox');
          	myform.elements["action"].value = 'listTasksByCategory';
        	myform.elements["category"].value = 'storys';
         
            myform.submit();
        }
        
        
        function loadTasks(_cat){
        	
          	myform.elements["_action"].value = 'listTasksByCategory';
        	myform.elements["category"].value = _cat;
         
        	alert(myform.elements["_action"].value);
        	alert(myform.elements["category"].value);
        	myform.submit();
        }
       
        
        function loadToday(){
            document.getElementById("right").innerHTML='<object data="today.html" style="width:100%;height: 100%"></object>' 
        }
        
        function loadCategorys() {
        	alert("I am here");
        	myform.elements["action"].value = 'listAllCategorys';
        	var _uid= '<%session.getAttribute("userId"); %>';
        	myform.elements["userId"].value = '_uid';
         
            myform.submit();
		}
        function addCategorys() {
			var cat="<br><form action='TodoServlet' method='Post'>";
			document.getElementById('addCategory').innerHTML=cat;
			var cat1="<input type='text' name='cname'><br><br><input type='submit' value='Add'>&nbsp;<button>Cancel</button></form>";
			document.getElementById("addcancel").innerHTML=cat1;
		}
        
    </script>       

    </head>
    <body>
        <form name='myform' action='TodoServlet' method="get">
  
        <div id="left"style="float: left;height: 100%;width: 35%;background-color: whitesmoke">
        	<div class="absolute0">
        		<a href="NewHome.jsp">
        		<img src="Vanna.png"></a>
        		<hr style="width: 220;">
        		
        	</div>   
          	
            <div class="absolute">   
            	<img alt="Inbox"  src="Download_to_Inbox_512.png" height="17px" width="20px"/>&nbsp;<a onclick="loadInbox()" href="#" style="text-decoration: none;color: gray;font-weight: bold;  font-size: 13px;font-family: Open Sans,sans-serif">Inbox</a><br><br>
               <img alt="Today" src="Mark_on_the_calendar_16 (1).png" height="17px" width="20px">&nbsp;<a onclick="loadInbox()" href="" style="text-decoration: none;color: gray;font-weight: bold; font-size: 13px;font-family: Open Sans,sans-serif">Today</a><br><br>
               <img alt="Inbox"  src="Calendar_day_7_16.png" height="17px" width="25px"/>&nbsp;<a onclick="loadInbox()" href="" style="text-decoration: none;color: gray; font-size: 13px;font-weight:bold;font-family: Open Sans,sans-serif">Next 7 days</a><br>
            
            </div>
            <div class="absolute1"><br><br>
            	<a onclick="loadCategorys()" href=""style="text-decoration: none;color: gray;font-weight: bold;font-size: 13px;font-family: Open Sans,sans-serif;" >Projects</a>&nbsp;
                 <a onclick="loadInbox()" href="" style="text-decoration: none;color: gray;font-weight: bold;font-size: 13px;font-family: Open Sans,sans-serif">Labels</a>&nbsp;
                 <a onclick="loadInbox()" href="" style="text-decoration: none;color: gray;font-weight: bold;font-size: 13px;font-family: Open Sans,sans-serif">Filters</a>
               	<hr style="width: 220">
         
                <!-- <div id="addCategory"><br>
                <a onclick="addCategorys()" href="#" style="text-decoration: none;color:#dd4b39;font-size: 13px;font-family: Open Sans,sans-serif">+ Add Project</a>
              
                </div> -->
         
                <br>
            </div>  
            <div class="absolute2" ><br>

                <br>
                 <% String _caction=request.getParameter("action");
          		ArrayList<TodoCategory> _Cats = (ArrayList<TodoCategory>) request.getAttribute("categoryList");
                 	if(null != _Cats)
                 	{
						for (TodoCategory _todoCategoty : _Cats) 
						{
				%>
               <a onclick="loadTasks('<%=_todoCategoty.getCategory()%>')" href="" style="text-decoration: none;color: gray;font-weight: bold;font-size: 13px;font-family: OpenSans,sans-serif"><%=_todoCategoty.getCategory()%></a><br><br>
               
               <% 		}
                 	}
               
               %>
               <div id="addcancel">
               
               <div id="addCategory">
               
             <a onclick="addCategorys()" href="#" style="text-decoration: none;color:#dd4b39;font-size: 13px;font-family: Open Sans,sans-serif">+ Add Project</a>
              </div>
              </div>
            </div>
      </div>
      <div id="middle" style="float: right;height: 100%;width: 14%;background-color: whitesmoke"> </div>
   
        <!-- <div id="right" align="center" style="float: right;height: 100%;width: 46%;background-color: white;margin-top: 150px;">
        	<b style="color:gray; ">No Tasks<br> Are Ready Now</b><br>
        	<img  src="rightmark.jpg"/>
        </div>  -->
     <div id="right" style="float: left;height: 100%;width:10%;background-color: white">
        <% String _taction = request.getParameter("action");
           if(null != _taction && _taction.equalsIgnoreCase("listAllTasks"))
           {
				ArrayList<TodoTask> _Tasks = (ArrayList<TodoTask>) request.getAttribute("taskList");
		%>
				<table border="1" align="center">
				<tr>
					<th>Category</th>
					<th>TaskName</th>
					<th>IsTaskCompleted</th>
				</tr>
				<%
						for (TodoTask _todoTask : _Tasks) {
				%>
				<tr>
					<td>
					<%
					out.println(_todoTask.getCategoryName());
				%>
			</td>
			<td>
				<%
					out.println(_todoTask.getTask());
				%>
			</td>
			<td>
				<%
					out.println(_todoTask.getIsTaskCompleted());
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<%      	   
           } 
        %>
        </div>      
        <input type="hidden" id="_action" name="_action"/>
        <input type="hidden" id="categoty" name="category"/>
        </form>
    </body>
</html>
