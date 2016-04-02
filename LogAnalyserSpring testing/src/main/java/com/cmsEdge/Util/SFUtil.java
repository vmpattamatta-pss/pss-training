package com.cmsEdge.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SFUtil {

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure("/com/cmsEdge/config/LogAnalyzer.cfg.xml").buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
