package com.cmsEdge.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public interface InsertLogRecords {
	public void insertLog(ArrayList<String> recordsList,HttpSession httpSession);
	public void readLogs();
	
	

}
