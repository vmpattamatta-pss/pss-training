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
		<jsp:useBean id="cal" class="com.sample.training.Calculator" />
		<jsp:setProperty property="intA" name="cal"
			value='<%=Integer.parseInt(request.getParameter("inpA"))%>' />
		<jsp:setProperty property="intB" name="cal"
			value='<%=Integer.parseInt(request.getParameter("inpB"))%>' />
		<jsp:setProperty property="op" name="cal"
			value='<%=Integer.parseInt(request.getParameter("op"))%>' />
		<table border="1">
			<tr>
				<td>First Operand</td>
				<td><jsp:getProperty property="intA" name="cal" /></td>
			</tr>
			<tr>
				<td>Second Operand</td>
				<td><jsp:getProperty property="intB" name="cal" /></td>
			</tr>
			<tr>
				<td>Operation</td>
				<td><jsp:getProperty property="op" name="cal" /></td>
			</tr>
			<tr>
				<td>Result</td>
				<td><%=cal.calculate()%></td>
			</tr>
		</table>
		Click <a href="/NayeemDay6/calcJspInpUB.jsp">Here</a> to Go Back
	</form>
</body>
</html>