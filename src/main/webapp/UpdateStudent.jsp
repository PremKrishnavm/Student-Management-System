<%@page import="student.Dto.Student"%>
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
<body align="center" bgcolor="aquamarine">
	<% Student student =(Student) request.getAttribute("students"); %>
	
	<form action="saveUpdatedStudent" method="post">
	<div class="container" align="center">
	<h1>Update Student Details</h1>
	<input name="studentId" value="<%= student.getStudentId()%>"
	readonly="readonly" type="text"> <br> <br>
	<input name="studentName" value="<%= student.getStudentName() %>"
	type ="text" placeholder="Enter Your Name"> <br> <br>
	<label class="gen">Male</label>  
	<input name="studentGender" value="<%=student.getStudentGender() %>"
	type="radio">
	<label class="gen">Female</label>
	<input name="studentGender" value="<%=student.getStudentGender() %>"
	type="radio"> <br> <br>
	<input name="studentPhoneNumber" value="<%= student.getStudentPh_no()%>"
	type="text" placeholder="Enter Your Ph_no"> <br> <br>
	<input name="studentEmail" value="<%= student.getStudentEmail()%>"
	type="email" placeholder="Enter Your Email"> <br> <br>
	<input name="studentFee" value="<%=student.getStudentFee()%>"
	type="text" readonly="readonly"> <br> <br>
	<input type="submit" value="Save" class="btn">
	</div>
	</form>
</body>
</html>