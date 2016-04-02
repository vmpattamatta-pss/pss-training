<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="/LogAnalyserSpring/css/mystyle.css">
<script src="https://code.jquery.com/jquery-3.0.0-alpha1.js"></script>
<script>
	window.jQuery
			|| document.write("<script src='/com/cmsEdge/config/jquery-2.1.4.min.js'><\/script>");
</script>

<script type="text/javascript" src="/LogAnalyserSpring/js/jqueryUtils.js">
	
</script>
</head>
<body>
	<h2>Log Analyzer</h2>
	<p>${error}</p>
	<form action="LogProccess.cms" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Select a File</td><td>
				<input id="file" name="uploadFile" type="file"
					required="required" />
				</td>

			</tr>
			<tr>
				<td>Select Date of a Uploading File</td>
				<td><input id="date" name="dtUploadFile" type="date" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input id="submit" type="submit" value="Upload Log Details" /></td>
			</tr>
		</table>
	</form>
</body>
</html>