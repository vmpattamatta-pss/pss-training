package com.cmsEdge.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
@Service
public class MyDbPdfView {
	public JRResultSetDataSource readDbLogs(HttpServletResponse response, HttpSession session) throws ServletException,Exception {
		Connection con=null;
		Statement st=null;
		Map params=null;
		JRResultSetDataSource rsdt=null;
		String logName = (String) session.getAttribute("logname");
		String tableName=logName;
		//response.setContentType("application/x-pdf");
		//response.setHeader("Content-Disposition", "attachment; filename=ErrorLogReport.pdf");
		try {
			ServletOutputStream sos = response.getOutputStream();
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loganalyzer", "root", "root");
			st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT *  FROM "+tableName+";");
			  rsdt=new JRResultSetDataSource(rs);
			JasperDesign design = JRXmlLoader.load(
					"E:/work/git/pss-training1/LogAnalyserSpring testing/src/main/java/com/cmsEdge/config/test1.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(design);
			 params = new HashMap();
			params.put("rsdt","rsdt");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, rsdt);
			byte[] pdfbytes = JasperExportManager.exportReportToPdf(jasperPrint);
			sos.write(pdfbytes);
			sos.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		finally {
			if (con != null) {
				try { con.close(); 
				} 
				catch (Exception e) {}
			}
			
		}
		return rsdt;
	}

}
