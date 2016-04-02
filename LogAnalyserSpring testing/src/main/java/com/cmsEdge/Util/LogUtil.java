package com.cmsEdge.Util;

import com.cmsEdge.Beans.LogBean;

public class LogUtil {

	private static LogBean logBean;

	public static synchronized LogBean getLogBean() {

		if (logBean == null) {
			logBean = new LogBean();
		}
		return logBean;
	}
}
