<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.regex.Pattern"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>processing VgnVCM runtime log file</title>
</head>
<body>
	<%
		String vgnVcmLogPath = "e:\\";
		String dtUploadFile = request.getParameter("dtvgnVcm");
		out.println(dtUploadFile);
		out.println();
		String uploadFile = request.getParameter("vgnVcm");
		String vgnVcmLogAPath = vgnVcmLogPath + uploadFile;
		out.println(vgnVcmLogAPath);
		String line = null;
		String errFile = null;
		boolean newErrorLog = false;
		try {
			FileReader fileReader = new FileReader(vgnVcmLogAPath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			DateFormat df = new SimpleDateFormat("hh-mm-ss");
			String timeStamp = df.format(new java.util.Date());
			String strFileName = "err_" + timeStamp + uploadFile;
			File errLog = new File(vgnVcmLogPath + strFileName);
			if (!errLog.exists())
				errLog.createNewFile();
			errFile = strFileName;
			FileWriter fileWriter = new FileWriter(errLog.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fileWriter);
			ArrayList<String> log = new ArrayList<String>();
			StringBuffer sf = new StringBuffer();
			while ((line = bufferedReader.readLine()) != null) {
				if (line.indexOf('|') != -1) {
					if (!sf.toString().equals(""))
						log.add(sf.toString());
					sf = new StringBuffer();
					for (String token : line.split(Pattern.quote("|"))) {
						if (token.trim().equals("ERROR")) {
							sf.append(line);
							break;
						}
					}
				} else {
					if (!sf.toString().equals("")) {
						sf.append("\n");
						sf.append(line);
					}
				}
			}
			for (String s : log) {
				bw.write(s);
				bw.flush();
			}
			/*while ((line = bufferedReader.readLine()) != null) {
				String currentLine = line;
				if (line.indexOf('|') != -1) {
					for (String token : line.split(Pattern.quote("|"))) {
						if (token.trim().equals("ERROR")) {
							newErrorLog = true;
							bw.write(currentLine);
							bw.newLine();
							bw.flush();
							break;
						} 
					}
				} 
				else {
					bw.write(currentLine);
					bw.newLine();
					bw.flush();
				}
			}*/
			bufferedReader.close();
			bw.close();
			out.println("\nyou can view all Errors in AllErrorsVgnVcmRuntimeLog.txt");
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + vgnVcmLogAPath + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + vgnVcmLogAPath + "'");
			ex.printStackTrace();
		}
	%>
	<form action="viewAllErrors.jsp">
		<input type="hidden" name="logFile" value=<%=errFile%> /> <input
			type="submit" value="View All Errors" />
	</form>
</body>
</html>