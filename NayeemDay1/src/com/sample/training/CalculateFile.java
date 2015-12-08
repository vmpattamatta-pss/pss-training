package com.sample.training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class CalculateFile {

	public static void main(String[] args) throws Exception {
		CalculateFile file = new CalculateFile();
		file.calculateLineItem("C:\\Java\\io\\filesrc.txt", "C:\\Java\\io\\filedest.txt");
	}

	public void calculateLineItem(String src, String dest) throws Exception {
		File srcFile = new File(src);
		if (!srcFile.exists()) {
			System.out.println("Source file does not exist");
			System.out.println("Run Syntax: java FileCopy <SRC_FILE> <DEST_FILE>");
		} else {
			File destFile = new File(dest);
			if (!destFile.exists()) {
				destFile.createNewFile();
			}
			BufferedReader buffSrc = new BufferedReader(new FileReader(srcFile));
			BufferedWriter buffDest = new BufferedWriter(new FileWriter(destFile));
			TreeMap<Integer, ArrayList<String>> entries = new TreeMap<Integer, ArrayList<String>>();
			int i = 0;
			while (true) {
				i++;
				String dataLine = buffSrc.readLine();
				if (dataLine == null || dataLine.trim().length() == 0) {
					break;
				} else {
					String[] values = dataLine.split(",");
					Integer op = Integer.parseInt(values[0]);
					if (values.length != 3) {
						String retLine = dataLine + "," + "Invalid Number of Arguments at Line No: " + i;
						ArrayList<String> entry = entries.get(-1);
						if (entry == null)
							entry = new ArrayList<String>();
						entry.add(retLine);
						entries.put(-1, entry);
						continue;
					} else if (op < 1 || op > 5) {
						String retLine = dataLine + "," + "Invalid Operation at Line No: " + i;
						ArrayList<String> entry = entries.get(-1);
						if (entry == null)
							entry = new ArrayList<String>();
						entry.add(retLine);
						entries.put(-1, entry);
						continue;
					} else if ((op == 4 || op == 5) && Integer.parseInt(values[2]) == 0) {
						String retLine = dataLine + "," + "Divide By Zero at Line No: " + i;
						ArrayList<String> entry = entries.get(-1);
						if (entry == null)
							entry = new ArrayList<String>();
						entry.add(retLine);
						entries.put(-1, entry);
						continue;
					} else {
						ArrayList<String> opArray = entries.get(op);
						if (opArray == null)
							opArray = new ArrayList<String>();
						opArray.add(values[1] + "," + values[2]);
						entries.put(op, opArray);
					}
				}
			}
			Iterator<Integer> keyIter = entries.keySet().iterator();
			while (keyIter.hasNext()) {
				Integer op = keyIter.next();
				if (op == -1) {
					ArrayList<String> opArray = entries.get(op);
					for (String string : opArray) {
						buffDest.write(string);
						buffDest.newLine();
					}
				} else {
					ArrayList<String> opArray = entries.get(op);
					for (String string : opArray) {
						String[] values = string.split(",");
						Calculator calc = new Calculator(Integer.parseInt(values[0]), Integer.parseInt(values[1]), op);
						int res = calc.calculate();
						String retLine = op + "," + string + "," + res;
						buffDest.write(retLine);
						buffDest.newLine();
					}
				}
			}
			buffSrc.close();
			buffDest.close();
		}
	}

}
