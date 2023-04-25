<%@page import="student.Dto.Admin"%>
<%@page import="student.Dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-Management-System</title>
</head>
<style>
	body{
	display: flex;
	flex-direction: column;
	align-items: center;
	background: -webkit-linear-gradient(to right, #155799, #159957); 
  	background: linear-gradient(to right,aqua,white); 
	}
	h1{
	text-decoration: 5px solid black underline;
	font-family: arial,helvetica,sans-serif;
	font-style: italic;	
	}
	.hm{
  background-color: #04AA6D;
  padding: 14px 20px;
  margin: .5rem;
  border-radius: 50px;
  text-decoration: none;
	}
	table,th,td{
	border: 1px solid black;
	}
</style>
<body>
	<% 
	Admin admin = (Admin)session.getAttribute("admin");

	if(admin!=null){
	List<Student> students = (List) request.getAttribute("students"); %>
	
	<h1>Students list</h1>
	
	<table border="" cellPadding="10px" cellSpacing="0">
		<tr bgcolor="yellow">
			<th>Student_Id</th>
			<th>Student_Name</th>
			<th>Student_Gender</th>
			<th>Student_Ph_no</th>
			<th>Student_Email</th>
			<th>Student_fees</th>
			<th>Update_Student</th>
			<th>Delete_Student</th>
		</tr>
		<%for(Student student : students){ %>
		<tr>
			<td><%=student.getStudentId() %></td>
			<td><%=student.getStudentName() %></td>
			<td><%=student.getStudentGender() %></td>
			<td><%=student.getStudentPh_no() %></td>
			<td><%=student.getStudentEmail() %></td>
			<td><%=student.getStudentFee() %></td>
			<td><a href="updateStudent?studentId=<%=student.getStudentId()%>">Update</a></td>
			<td><a href="deleteStudent?studentId=<%=student.getStudentId()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
	<div class="hm">
		<a href="Dashboard.jsp">Home</a>
	</div>
	<%}else{
			
			response.sendRedirect("AdminLogin.jsp");
		}%>
</body>
</html>