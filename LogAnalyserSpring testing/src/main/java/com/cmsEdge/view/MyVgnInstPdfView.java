package com.cmsEdge.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class MyVgnInstPdfView extends AbstractPdfView {
	@Override
	protected void buildPdfDocument(Map tokenList, Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<String> tokens = (ArrayList<String>) tokenList.get("tokentlist");
		Table table = new Table(5);
		PdfPCell cell = new PdfPCell();
		cell.setFixedHeight(30f);
		table.addCell("Date&Time");
		table.addCell("Level");
		table.addCell("Location");
		table.addCell("");
		table.addCell("Error Description");
		float[] columnWidths = new float[] { 17f, 3.09f, 25f, 0.1f, 54f };
		table.setWidths(columnWidths);
		Iterator itr = tokens.iterator();
		while (itr.hasNext()) {
			String value = (String) itr.next();
			table.addCell(value);
		}
		doc.add(table);
	}


}
