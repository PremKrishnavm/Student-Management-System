<%@page import="student.Dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-Management-System</title>
<style>
body 
{
  font-family:Arial; 
  background: -webkit-linear-gradient(to right, #155799, #159957); 
  background: linear-gradient(to right, #155799, #159957); 
  color:whitesmoke;
  padding: 14px 20px;
}
h1{
   text-decoration: underline;
   color: black;
   }
.btn{
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  width: 100px;
  border-radius: 50px;
   }
.res{
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  width: 100px;
  border-radius: 50px;
}
.container{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  max-width: 430px;
  width: 100%;
  background: #fff;
  border-radius: 7px;
}
.gen{
color: black;
}
</style>
</head>
<body align="center" bgcolor="aqua">
	<%
		Admin admin = (Admin) session.getAttribute("admin");
	if(admin!=null){
	%>
	<form method="post" action="save">
		<div class="container" align="center">
		<h1>Enter Student Details</h1>
		<input name="studentName" type="text" placeholder="Enter Your Name:"> <br> <br> 
		<label class="gen">Male</label> 
		<input name="studentGender" type="radio" value="Male"> 
		<label class="gen">Female</label> 
		<input name="studentGender" type="radio" value="Female"> <br> <br> 
		<input name="studentPh_no" type="text" placeholder="Enter Your Ph_no"> <br> <br> 
		<input name="studentEmail" type="email" placeholder="Enter Your Email"> <br> <br> 
		<input type="reset" class="res"> 
		<input type="submit" value="Save" class="btn">
		</div>
	</form>
	<%}else{
		response.sendRedirect("AdminLogin.jsp");
	} %>
	
</body>
</html>