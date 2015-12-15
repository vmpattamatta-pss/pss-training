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
		<%
			Integer intA = Integer.parseInt(request.getParameter("inpA"));
			Integer intB = Integer.parseInt(request.getParameter("inpB"));
			Integer op = Integer.parseInt(request.getParameter("op"));
			Calculator cal = new Calculator(intA, intB, op);
			String opStr = "null";
			switch (op) {
			case 1:
				opStr = "Add";
				break;
			case 2:
				opStr = "Sub";
				break;
			case 3:
				opStr = "Mul";
				break;
			case 4:
				opStr = "Div";
				break;
			case 5:
				opStr = "Mod";
				break;
			}
		%>
		<table border="1">
			<tr>
				<td>First Operand</td>
				<td><%=intA%></td>
			</tr>
			<tr>
				<td>Second Operand</td>
				<td><%=intB%></td>
			</tr>
			<tr>
				<td>Operation</td>
				<td><%=opStr%></td>
			</tr>
			<tr>
				<td>Result</td>
				<td><%=cal.calculate()%></td>
			</tr>
		</table>
		Click <a href="/NayeemDay6/calcInp.jsp">Here</a> to Go Back
	</form>
</body>
</html>