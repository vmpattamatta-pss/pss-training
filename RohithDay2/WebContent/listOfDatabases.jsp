<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select database</title>
</head>
<body>
	<%
		session.setAttribute("User", request.getParameter("uName"));
		session.setAttribute("password", request.getParameter("pwd"));
		ArrayList<String> dbList = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306",
					(String) session.getAttribute("User"), (String) session.getAttribute("password"));
			DatabaseMetaData md = con.getMetaData();
			ResultSet rs = md.getCatalogs();
			dbList = new ArrayList<String>();
			out.print("select any database form the list");
			while (rs.next()) {
				dbList.add(rs.getString(1));
			}
			session.setAttribute("dbList", dbList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>

	<form action="ListOfTables.jsp" method="post">
		<select name="dbselect">
			<option value="-1">Please Select</option>
			<c:forEach var="item" items="${dbList}">
				<option value='<c:out value="${item }"/>'>
					<c:out value="${item }" />
				</option>
			</c:forEach>
		</select> <input type="submit" value="select" />
	</form>
</body>
</html>