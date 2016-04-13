package com.cmsEdge.LogProccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cmsEdge.Util.LogUtil;

@Service
public class VgnVcmLogProccessImpl implements LogProccess {

	private static String errFile;
	Logger logger = Logger.getLogger(VgnVcmLogProccessImpl.class);

	public String execute(String dtUploadFile, String logName) {
		ArrayList<String> VgnVcmList = null, JEVgnVCMList = null, vgninstList = null, proddelList = null,
				AppsvcsList = null;
		LogUtil.getLogBean().setUploadFilePath("E:/upload/");
		String vgnVcmLogAPath = LogUtil.getLogBean().getUploadFilePath() + LogUtil.getLogBean().getSourceFileName();
		String line = null;
		try {
			FileReader fileReader = new FileReader(vgnVcmLogAPath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Scanner scanner = new Scanner(vgnVcmLogAPath);
			String modifiedFileName = dtUploadFile + "  " + LogUtil.getLogBean().getSourceFileName();
			String destFileName = LogUtil.getLogBean().getUploadFilePath() + modifiedFileName;
			LogUtil.getLogBean().setFilePath(destFileName);
			File errLog = new File(LogUtil.getLogBean().getUploadFilePath() + modifiedFileName);
			if (!errLog.exists())
				errLog.createNewFile();
			errFile = modifiedFileName;
			FileWriter fileWriter = new FileWriter(errLog.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fileWriter);
			
			VgnVcmList = new ArrayList<String>();
			JEVgnVCMList = new ArrayList<String>();
			vgninstList = new ArrayList<String>();
			proddelList = new ArrayList<String>();
			AppsvcsList = new ArrayList<String>();
			StringBuffer sf = new StringBuffer();
			while ((line = bufferedReader.readLine()) != null) {

				if (logName.equalsIgnoreCase("VgnVCMruntime")) {
					if (line.indexOf('|') != -1) {

						if (!sf.toString().equals("")) {
							VgnVcmList.add(sf.toString());
						}
						sf = new StringBuffer();
						for (String token : line.split(Pattern.quote("|"))) {
							if (token.trim().equalsIgnoreCase("ERROR")) {
								sf.append(line);
								break;
							}
						}
					}
				}
				if (logName.equalsIgnoreCase("JEVgnVCMruntime")) {

					if (line.indexOf('|') != -1) {
						if (!sf.toString().equals("")) {
							JEVgnVCMList.add(sf.toString());
						}
						sf = new StringBuffer();
						for (String token : line.split(Pattern.quote("|"))) {
							if (token.trim().equalsIgnoreCase("ERROR")) {
								sf.append(line);
								break;
							}
						}
					}
				}
				if (logName.equalsIgnoreCase("vgninstruntime")) {

					if (line.indexOf('|') != -1) {
						if (!sf.toString().equals("")) {
							vgninstList.add(sf.toString());
						}
						sf = new StringBuffer();
						for (String token : line.split(Pattern.quote("|"))) {
							if (token.trim().equalsIgnoreCase("ERROR")) {
								sf.append(line);
								break;
							}
						}
					}
				}
				if (logName.equalsIgnoreCase("proddelruntime")) {

					if (line.indexOf('|') != -1) {
						if (!sf.toString().equals("")) {
							proddelList.add(sf.toString());
						}
						sf = new StringBuffer();
						for (String token : line.split(Pattern.quote("|"))) {
							if (token.trim().equalsIgnoreCase("ERROR")) {
								sf.append(line);
								break;
							}
						}
					}
				}
				if (logName.equalsIgnoreCase("Appsvcsruntime")) {

					if (line.indexOf('|') != -1) {
						if (!sf.toString().equals("")) {
							AppsvcsList.add(sf.toString());
						}
						sf = new StringBuffer();
						for (String token : line.split(Pattern.quote("|"))) {
							if (token.trim().equalsIgnoreCase("WARN")) {
								sf.append(line);
								break;
							}
						}
					}
				}

				/*
				 * else if (line.indexOf('<') != -1) { if
				 * (!sf.toString().equals("")) { logDataList.add(sf.toString());
				 * } sf = new StringBuffer(); for (String token :
				 * line.split(Pattern.quote("<"))) { if (token.equals("Error>"))
				 * { sf.append(line); break; } } } else if (line.indexOf('[') !=
				 * -1) { if (!sf.toString().equals("")) {
				 * logDataList.add(sf.toString()); } sf = new StringBuffer();
				 * for (String token : line.split(Pattern.quote("["))) { if
				 * (token.trim().equals("ERROR]")) { sf.append(line); break; } }
				 * }
				 */

				else {
					if (!sf.toString().equals("")) {
						sf.append("\n");
						sf.append(line);
					}
				}
			}

			for (String s : VgnVcmList) {
				bw.write(s);
				bw.flush();
			}
			for (String s : JEVgnVCMList) {
				bw.write(s);
				bw.flush();
			}
			for (String s : vgninstList) {
				bw.write(s);
				bw.flush();
			}
			for (String s : proddelList) {
				bw.write(s);
				bw.flush();
			}
			for (String s : AppsvcsList) {
				bw.write(s);
				bw.flush();
			}
			bufferedReader.close();
			bw.close();
		} catch (FileNotFoundException ex) {
			logger.error("problem has occured in opening file '" + vgnVcmLogAPath + "'" + ex);
		} catch (Exception ex) {
			logger.error("Error in reading file '" + vgnVcmLogAPath + "'" + ex);
		}
		return errFile;
	}

}
