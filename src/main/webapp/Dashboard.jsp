<%@page import="student.Dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-Management-System</title>
</head>
<style>
body {
	height: 100vh;
	width: 100vw;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	background: -webkit-linear-gradient(to right, #155799, #159957); 
  	background: linear-gradient(to right, #155799, #159957); 
}
a{
	padding: 15px;
	font-size: 1.3rem;
	border:1px solid black;
	border-radius: 50px;
	text-decoration: none;
	color: #303030;
	margin: .5rem;
	background-color: #04AA6D;
	background-attachment: fixed;
}

h1 {
	font-size: 7rem;
	color: #565656;
}
.log{
	position: relative;
	top:40px;
	left:1px;
	padding: 500spx;
	font-size: 1.3rem;
	border-radius: 50px;
	text-decoration: none;
	color: #303030;
	margin: .5rem;

}
h3{
text-decoration: underline;
}
</style>
<body>
	<% Admin admin = (Admin) session.getAttribute("admin"); 
		if(admin!=null){
	%>
	<h1>Welcome Admin</h1>
	<h3>You can manage student data here!!</h3> <br>
	<div class="sv">
		<a href="saveStudent.jsp">Save-Student</a> 
		<a href="viewStudents">View-Students</a>
	</div>
	<%}else{
		 response.sendRedirect("AdminLogin.jsp");
	}%>
	
	<div class="log"><a href="logout">Logout</a></div>
	
</body>
</html>