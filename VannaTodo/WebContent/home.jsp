<%@page import="domain.TodoTask"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.TodoCategory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.transaction.TodoTrxAction"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function addTask() {
		alert("Hi...I am here ...11111");
		myform.elements["action"].value = 'addTask';
		var _taskName = document.createElement("input");
		_taskName.type = 'hidden';
		_taskName.name = "task";
		_taskName.value = 'java';
		myform.appendChild(_taskName);

		alert("Hi...I am here ...2222");
		var _categoryName = document.createElement("input");
		_categoryName.type = 'hidden';
		_categoryName.name = "category";
		_categoryName.value = 'storys';
		myform.appendChild(_categoryName);

		alert("Hi...I am here ...3333");
		var _iscomplete = document.createElement("input");
		_iscomplete.type = 'hidden';
		_iscomplete.name = "isTaskCompleted";
		_iscomplete.value = 'yes';
		myform.appendChild(_iscomplete);
		myform.submit();

	}
	function addCategory() {

		alert("Hi...I am here ...11111");
		myform.elements["action"].value = 'addCategory';

		var _catName = document.createElement("input");
		_catName.type = 'hidden';
		_catName.name = "category";
		_catName.value = 'Work';
		myform.appendChild(_catName);

		alert("Hi...I am here ...3333");

		var _catDesc = document.createElement("input");
		_catDesc.type = 'hidden';
		_catDesc.name = 'categoryDesc';
		_catDesc.value = 'My Work related Tasks';
		myform.appendChild(_catDesc);

		var _uid = document.createElement("input");
		_uid.type = 'hidden';
		_uid.name = 'userId';
		_uid.value = 'aaa';
		myform.appendChild(_uid);

		alert("Hi...I am submitting form");

		myform.submit();

	}
	function listAllCategorys() {
		alert("Hi...I am here ...11111");
		myform.elements["action"].value = 'listAllCategorys';

		var _uid = document.createElement("input");
		_uid.type = 'hidden';
		_uid.name = 'userId';
		_uid.value = 'aaa';
		myform.appendChild(_uid);
	}

	function listAllTasks() {
		alert("hi...i am here ...111111")

		myform.elements["action"].value = 'listAllTasks';

		var _cname = document.createElement("input");
		_cname.type = 'hidden';
		_cname.name = 'category';
		_cname.value = 'mobiles';
		myfom.appendChild(_cname);

	}
</script>

</head>
<body>
	<form name='myform' action='TodoServlet' method="POST">
		<button onClick="addCategory()">Add Category</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onClick="delCategory()">Delete Category</button>
		<button onClick="deleteAllCategorys()">Delete All Category's</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onClick="listAllCategorys()">List All Category</button>
		<button onClick="getTasksByCategory()">GetTasks By Category</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onClick="addTask()">Add Task</button>
		<button onClick="deleteTask()">DeleteTask</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onClick="updateTask()">Update Task</button>
		<button onClick="deleteAllTasks()">Delete all Tasks</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onClick="listAllTasks()">ListAllTasks</button>

		<input type="hidden" name="action" /> <BR>

		<%
			if (request.getParameter("action") != null) {

				String _action = (String) request.getParameter("action");

				if (_action.equalsIgnoreCase("listAllCategorys")) {
					ArrayList<TodoCategory> list = (ArrayList<TodoCategory>) request.getAttribute("categoryList");
		%>
		<table border="1" align="center">
			<tr>
				<td><b>CategoryID</b></td>
				<td><b>CategoryName</b></td>
			</tr>

			<%
				for (TodoCategory _todocategory : list) {
			%>
			<tr>
				<td>
					<%
						out.println(_todocategory.getCategoryId());
					%>
				</td>
				<td>
					<%
						out.println(_todocategory.getCategory());
					%>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else if (_action.equalsIgnoreCase("addCategory")) {

					TodoCategory _category = (TodoCategory) request.getAttribute("result");
					out.println("<h4>Congrats.....CategoryId: " + _category.getCategoryId() + "</h4>");
					out.println("<h4>Category Name: " + _category.getCategory() + "</h4>");
					out.println("<h4>Category Description: " + _category.getCategoryDesc() + "<h4>");

				}
			else if (_action.equalsIgnoreCase("addTask")) {
					TodoTask _Task = (TodoTask) request.getAttribute("_task");
					out.println("<h4> congrats your task is addded</h4>");
					out.print("<h4> Task name is: </h4>" + _Task.getTask() + "<h4> Task Id is: </h4>"
							+ _Task.getTaskId() + "<h4>Is Task completed: </h4>" + _Task.getIsTaskCompleted());
				} 
			else if (_action.equalsIgnoreCase("listAllTasks")) 
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

			}
		%>


	</form>
</body>
</html>