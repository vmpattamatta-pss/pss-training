package com.cmsEdge.view;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public interface ErrorViewer {
	public ArrayList<String> execute(HttpSession session);

}
