<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>table data</title>
</head>
<body>
	<%
		String tableName = request.getParameter("myselect");
		out.println("Details of " + tableName + " table");
		String db = (String) session.getAttribute("dbName");
	%>
	<br>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db,
				(String) session.getAttribute("User"), (String) session.getAttribute("password"));
		Statement st = con.createStatement();
		DatabaseMetaData metaData = con.getMetaData();
		ResultSet rsmd = metaData.getColumns(null, null, tableName, null);
		ArrayList<String> columnList = new ArrayList<String>();
		while (rsmd.next()) {
			columnList.add(rsmd.getString("COLUMN_NAME"));
		}
		session.setAttribute("columnList", columnList);

		String query = "select * from " + tableName + ";";
		ResultSet rs = st.executeQuery(query);
	%>
	<TABLE border="1" style="width: 40%">
		<TR>
			<c:forEach items="${columnList}" var="item">
				<TH><c:out value="${item }" /></TH>
			</c:forEach>
		</TR>
		<%
			while (rs.next()) {
		%>

		<TR>

			<%
				for (int j = 0; j < columnList.size(); j++) {
			%>
			<TD>
				<%
					out.println(rs.getString(columnList.get(j).toString()));
				%>
			</TD>
			<%
				}
			%>
		</TR>
		<%
			}
		%>
	</TABLE>
</body>
</html>