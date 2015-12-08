package com.sample.training;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {

	public static void main(String[] args) throws Exception {
		FileCopy copy = new FileCopy();
		copy.copyFileBlock("C:\\Java\\io\\filesrc.txt", "C:\\Java\\io\\filedest.txt");
	}

	public void copyFileStream(String src, String dest) throws Exception {
		File srcFile = new File(src);
		if (!srcFile.exists()) {
			System.out.println("Source file does not exist");
			System.out.println("Run Syntax: java FileCopy <SRC_FILE> <DEST_FILE>");
		} else {
			File destFile = new File(dest);
			if (!destFile.exists()) {
				destFile.createNewFile();
			}
			FileInputStream fis = new FileInputStream(srcFile);
			FileOutputStream fos = new FileOutputStream(destFile);
			byte[] buff = new byte[1];
			while (true) {
				int currPos = fis.read(buff);
				if (currPos <= 0)
					break;
				fos.write(buff);
			}
			fis.close();
			fos.close();
		}
	}

 	public void copyFileBlock(String src, String dest) throws Exception {
		File srcFile = new File(src);
		if (!srcFile.exists()) {
			System.out.println("Source file does not exist");
			System.out.println("Run Syntax: java FileCopy <SRC_FILE> <DEST_FILE>");
		} else {
			File destFile = new File(dest);
			if (!destFile.exists()) {
				destFile.createNewFile();
			}
			FileReader fr = new FileReader(srcFile);
			FileWriter fw = new FileWriter(destFile);
			char[] buff = new char[1];
			while (true) {
				int i = 0;
				int currPos = fr.read(buff);
				if (currPos <= 0)
					break;
				fw.write(buff);
				if (i % 2 == 0)
					fw.flush();
				i++;
			}
			fr.close();
			fw.close();
		}

	}
}
