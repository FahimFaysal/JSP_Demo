<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

<h1>Please fill the form</h1>

<br>
	<% 
	if(request.getParameter("error_message")!=null){
	out.print("Error : "+request.getParameter("error_message"));
	}
	%>
<br>
<br>


		<form  action="CreateMemberManagerURL" method="post">

		First Name: <input name="firstName" />  <br>
		Second Name: <input name="secondName" /> <br>
		
		E-mail : <input name="mail" /> <br> 	
		Password : <input type="password" name="pass" /> <br>
		
		Date of Birth(MM/dd/yyyy): <input name="dob"><br>
		
		Gender: 
		<input type="radio" name="gender" value="Male"/>Male</inpur> 
		<input type="radio" name="gender" value="Female">Female</inpur>
		<input type="radio" name="gender" value="Other">Other</inpur>
		<br>
		<br>				
		Skill:
		<select  name="skill" multiple size="multiple">
		
		<option value="JAVA">JAVA</option>
		<option value="php">php</option>
		<option value="c">c</option>
		<option value="c#">c#</option>
		<option value=".net">.Net</option>
		<option value="jsp">jsp</option>
		<option value="jsf">jsf</option>
		<option value="Andriod">Andriod</option>
		<option value="IOS">IOS</option>
		<option value="J2ME">J2ME</option>
		<option value="JEE">JEE</option>
		<option value="spring">spring</option>
		<option value="hibernate">hibernate</option>
		<option value="eclipiseLike">eclipiseLike</option>

		</select>						
			
		<br><br><input type="submit" />
		</form>
</body>
</html>