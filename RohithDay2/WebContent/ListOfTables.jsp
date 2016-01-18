<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentication</title>
</head>
<body>
	<%
		String dbName = request.getParameter("dbselect");
		session.setAttribute("dbName", dbName);
	%>
	<%
		ArrayList<String> tables = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName,
					(String) session.getAttribute("User"), (String) session.getAttribute("password"));
			DatabaseMetaData md = con.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			tables = new ArrayList<String>();
			out.print("select any table form the list");
			while (rs.next()) {
				tables.add(rs.getString(3));
			}
			session.setAttribute("tables", tables);
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>

	<form action="results.jsp" method="post">
		<select name="myselect">
			<option value="-1">Please Select</option>
			<c:forEach items="${tables}" var="item">
				<option value='<c:out value="${item }"/>'>
					<c:out value="${item }" />
				</option>
			</c:forEach>
		</select> <input type="submit" value="select" />
	</form>


</body>
</html>