package com.cmsEdge.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class MyExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map tokenList, HSSFWorkbook wb, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ArrayList<String> tokens = (ArrayList<String>) tokenList.get("tokentlist");
		Sheet sheet = wb.createSheet();
		Row r1 = sheet.createRow(0);
		Cell c1 = r1.createCell(0);
		c1.setCellValue("Date Time");
		Cell c2 = r1.createCell(1);
		c2.setCellValue("Level");
		Cell c3 = r1.createCell(2);
		c3.setCellValue("Location");
		Cell c4 = r1.createCell(3);
		c4.setCellValue("");
		Cell c5 = r1.createCell(4);
		c5.setCellValue("Error Description");
		int counter = 1;
		int a=0;
		String output1="";String output2="";String output3="";String output4="";String output5="";
		
		Iterator itr = tokens.iterator();
		while (itr.hasNext()) {
			HSSFRow row = (HSSFRow) sheet.createRow(counter++);
			String value = (String) itr.next();
			int e=tokens.size();
			try {
				if(tokens.size()>a){
				row.createCell(0).setCellValue(output1=tokens.get(a));
				String output=tokens.get(a++);
				  row.createCell(1).setCellValue(output2=tokens.get(a++));
				  row.createCell(2).setCellValue(output3=tokens.get(a++));
				  row.createCell(3).setCellValue(output4=tokens.get(a++));
				  row.createCell(3).setCellValue(output5=tokens.get(a++));
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}

	}

}