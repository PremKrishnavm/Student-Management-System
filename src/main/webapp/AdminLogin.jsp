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
h2{
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
</style>
</head>
<body>
	<form action="login" method="post">
	<div class="container" align="center">
	<h2>Admin Login</h2>
	<input name="AdminEmail" placeholder="Enter Your Email" type="email"> <br> <br>
	<input name="AdminPassword" placeholder="Enter Your Password" type="password"> <br> <br>
	<input type="submit" class="btn" value="Login">	
	</div>
	</form>
</body>
</html>