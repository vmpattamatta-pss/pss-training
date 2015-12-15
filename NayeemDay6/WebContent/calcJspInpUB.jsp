<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator JSP</title>
</head>
<body>
	<form action="calcJspResUB.jsp">
		<table border="1">
			<tr>
				<td>Input A</td>
				<td><input name="inpA" /></td>
			</tr>
			<tr>
				<td>Input B</td>
				<td><input name="inpB" /></td>
			</tr>
			<tr>
				<td>Operation</td>
				<td><input name="op" type="radio" value="1">Add<br />
					<input name="op" type="radio" value="2">Sub<br /> <input
					name="op" type="radio" value="3">Mul<br /> <input
					name="op" type="radio" value="4">Div<br /> <input
					name="op" type="radio" value="5">Mod</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Calculate"></td>
			</tr>
		</table>
	</form>
</body>
</html>