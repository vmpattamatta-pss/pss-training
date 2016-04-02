<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View All Errors</title>
<script src="https://code.jquery.com/jquery-3.0.0-alpha1.js"></script>
<script>
	window.jQuery||document.write("<script src='jquery-2.1.4.min.js'><\/script>");
</script>
<script src="/LogAnalyserSpring/js/jqueryUtils.js">
</script>
<link rel="stylesheet" type="text/css" href="/LogAnalyserSpring/css/mystyle.css">
</head>
<body>
 <p>Error file " ${errFile} " is created successfully.<br>
To store errors into the database click below button 
 <form action="insert.cms">
 <input id="submit" type="submit" name="insert" value="Insert Error Records" >
 </form>
 
 <p>To view result in different formats click below links</p> 
<a href="pdf.cms">PDF Download</a>
<a href="excel.cms">Excel Download</a>

</body>
</html>