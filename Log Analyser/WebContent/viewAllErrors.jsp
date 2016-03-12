<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.regex.Pattern" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Errors</title>
<style type="text/css">
table {
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
}
td {
    vertical-align: top;
    text-align: left;
}
</style>
</head>
<body>
	<h2> Error log</h2>
	<table border ="1">
		<tr><td>Date Time</td><td>Level</td><td>Location</td><td>Id</td><td>Error Description</td><td>Error Details
	
	<%
	String line = null;
	String filePath = request.getParameter("logFile");
	filePath = "e:\\" + filePath;
	try {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		while ((line = bufferedReader.readLine()) != null) {
			String currentLine = line;
			if (line.indexOf('|') != -1) {
				%>
				</td></tr><tr><td>
				<%
				for (String token : line.split(Pattern.quote("|"))) {
					out.print(token);
					 %>
					 </td><td>
					 <%
				}
			} 
			else {
				out.println(line);
			}
		}
		bufferedReader.close();
	} catch (FileNotFoundException ex) {
		System.out.println("Unable to open file '" + filePath + "'");
	} catch (IOException ex) {
		System.out.println("Error reading file '" + filePath + "'");
		ex.printStackTrace();
	}

	%>
	</td></tr>
	</table>
</body>
</html>