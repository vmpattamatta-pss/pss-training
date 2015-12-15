<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.sample.training.Calculator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculation Result</title>
</head>
<body>
	<form action="#">
		<table border="1">
			<tr>
				<td>First Operand</td>
				<td><%=request.getAttribute("inpA")%></td>
			</tr>
			<tr>
				<td>Second Operand</td>
				<td><%=request.getAttribute("inpB")%></td>
			</tr>
			<tr>
				<td>Operation</td>
				<td><%=request.getAttribute("opStr")%></td>
			</tr>
			<tr>
				<td>Result</td>
				<td><%=request.getAttribute("result")%></td>
			</tr>
		</table>
		Click <a href="/NayeemDay6/calcInp.jsp">Here</a> to Go Back
	</form>
</body>
</html>