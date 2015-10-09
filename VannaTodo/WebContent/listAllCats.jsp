<%@page import="domain.TodoCategory"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<TodoCategory> list=(ArrayList<TodoCategory>)request.getAttribute("catageryList");


for(TodoCategory _todocategory: list)
{	
	out.println("Congrats.....CategoryId: " + _todocategory.getCategoryId() +" ; Category Name: " + _todocategory.getCategory() );
}
%>
</body>
</html>