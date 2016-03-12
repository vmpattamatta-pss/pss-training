<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

</head>
<body>
	<h2>Select a log file</h2>
	<form action="processVgnVCM.jsp" name="form1" onsubmit="return setFileValue()">
		<table>
			<tr>
				<td>select a file to upload</td>
				<td><input name="vgnVcm" id= "vgnVcm" type="file" onchange="return setFileValue()"/></td>
			</tr>
			<tr>
				<td>select date of a file to upload</td>
				<td><input name="dtvgnVcm" id= "dtvgnVcm" type="date" />	Format:dd-mm-yy</td>
			</tr>
			
			<tr>
				<td></td>

				<td><input type="submit" value="Generate & View VgnVcm runtime Log Details"/></td>

			</tr>
		</table>
	</form>
</body>
</html>