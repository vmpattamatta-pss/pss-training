<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="/RohithDay2/listOfDatabases.jsp" method="post">
		<table>
			<tr>
				<td>UserName<input type="text" name="uName" /></td>
			</tr>
			<tr>
				<td>Password <input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>

		</table>
	</form>

</body>
</html>