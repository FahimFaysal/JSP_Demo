<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student club</title>
</head>
<body>
	<h1>Welcome to Student club</h1>

	<form action="LoginManagerURL" method="post" >
		User Id: <input type="text" name="userId"> <br>
		Password: <input type="password" name="passWord"> <br> 
		<input type="submit">
	</form>
	<% 
	if(request.getParameter("error_message")!=null){
	
	out.print(request.getParameter("error_message"));
	//System.out.println("print me"+(request.getParameter("error_message")));
	}
	%>
	
<br>
<a href='/Student_Club/registration.jsp'>Reistration now</a>

</body>
</html>