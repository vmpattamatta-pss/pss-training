package com.cmsEdge.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.cmsEdge.Util.LogUtil;

@Service
public class ErrorViewerImpl implements ErrorViewer {

	public ArrayList<String> execute(HttpSession session) {
		String line = null;
		ArrayList<String> tokens = new ArrayList<String>();
		String filePath = LogUtil.getLogBean().getFilePath();
		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String logName = (String) session.getAttribute("logname");
			if (logName.equalsIgnoreCase("VgnVCMruntime") || logName.equalsIgnoreCase("JEVgnVCMruntime")) {
				while ((line = bufferedReader.readLine()) != null) {
					if (line.indexOf('|') != -1) {
						for (String token : line.split(Pattern.quote("|"))) {
							tokens.add(token);
						}
					}
				}
			} else if (logName.equalsIgnoreCase("vgninstruntime")) {
				while ((line = bufferedReader.readLine()) != null) {
					 Scanner scanner = new Scanner(line); 
					 while (scanner.hasNext()) {
						 
						 String word=scanner.next();
						/* if (word==scanner.next(Pattern.compile("([com.vignette.search.solr.SolrClient])"))) {
							 word.split(Pattern.quote("]"));
							
						}*/
						 tokens.add(word);
						
					}
					
					
					
					/*if (line.indexOf('|') != -1) {
						for (String token : line.split(Pattern.quote("|"))) {
							tokens.add(token);
						}
					}*/
				}

			} else if (logName.equalsIgnoreCase("proddelruntime")) {
				while ((line = bufferedReader.readLine()) != null) {
					if (line.indexOf('|') != -1) {
						for (String token : line.split(Pattern.quote("|"))) {
							tokens.add(token);
						}
					}
				}
			} else if (logName.equalsIgnoreCase("Appsvcsruntime")) {
				while ((line = bufferedReader.readLine()) != null) {
					if (line.indexOf('|') != -1) {
						for (String token : line.split(Pattern.quote("|"))) {
							tokens.add(token);
						}
					}
				}
			}
			//bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + filePath + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + filePath + "'");
			ex.printStackTrace();
		}
		LogUtil.getLogBean().setTokens(tokens);
		return tokens;
	}

}
