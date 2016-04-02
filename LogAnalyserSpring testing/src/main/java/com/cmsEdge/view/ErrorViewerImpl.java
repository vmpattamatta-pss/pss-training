package com.cmsEdge.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.cmsEdge.Util.LogUtil;

@Service
public class ErrorViewerImpl implements ErrorViewer {

	public ArrayList<String> execute() {
		String line = null;
		ArrayList<String> tokens = new ArrayList<String>();
		String filePath = LogUtil.getLogBean().getFilePath();
		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				if (line.indexOf('|') != -1) {
					for (String token : line.split(Pattern.quote("|"))) {
						tokens.add(token);
					}
				} 
			}
			bufferedReader.close();
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
