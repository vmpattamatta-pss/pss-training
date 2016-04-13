package com.cmsEdge.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.cmsEdge.Beans.JEVgnVCMruntimeBean;
import com.cmsEdge.Beans.Pojo;
import com.cmsEdge.Util.SFUtil;

@Repository
public class InsertLogRecordsImpl implements InsertLogRecords {
	private SFUtil sfUtil;
	private static Logger logger = Logger.getLogger(InsertLogRecords.class.getName());

	public void insertLog(ArrayList<String> records, HttpSession httpSession) {
		Session session = sfUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Iterator itr = records.iterator();
			int a = 0;
			String logName = (String) httpSession.getAttribute("logname");
			if (logName.equalsIgnoreCase("VgnVCMruntime")) {
			while (itr.hasNext()) {
				Pojo p = new Pojo();
				if (a < records.size()) {
					p.setDate(records.get(a));
					if (records.size() == a) {
						break;
					}
					records.get(a++);
					if (records.size() == a) {
						break;
					}
					p.setLevel(records.get(a++));
					if (records.size() == a) {
						break;
					}
					p.setLocation(records.get(a++));
					if (records.size() == a) {
						break;
					}
					p.setBlnk(records.get(a++));
					if (records.size() == a) {
						break;
					}
					p.setErrordesc(records.get(a++));
					/*if (records.size() == a) {
						break;
					}*/
					p.setRecordsList(records);
				}
				session.saveOrUpdate(p);
				if (a % 50 == 0) {
					session.flush();
					session.clear();
				}
				if (records.size() == a) {
					break;
				}

			}
			}
			if (logName.equalsIgnoreCase("JEVgnVCMruntime")) {
				while (itr.hasNext()) {
					JEVgnVCMruntimeBean j = new JEVgnVCMruntimeBean();
					if (a < records.size()) {
						j.setDate(records.get(a));
						if (records.size() == a) {
							break;
						}
						records.get(a++);
						if (records.size() == a) {
							break;
						}
						j.setLevel(records.get(a++));
						if (records.size() == a) {
							break;
						}
						j.setLocation(records.get(a++));
						if (records.size() == a) {
							break;
						}
						j.setBlnk(records.get(a++));
						if (records.size() == a) {
							break;
						}
						j.setErrordesc(records.get(a++));
						/*if (records.size() == a) {
							break;
						}*/
						j.setRecordsList(records);
					}
					session.saveOrUpdate(j);
					if (a % 50 == 0) {
						session.flush();
						session.clear();
					}
					if (records.size() == a) {
						break;
					}

				}
				
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error("while storing records in to the database error has been occured", e);
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void readLogs() {
		Transaction transaction = null;
		List list = null;
		Session session = null;
		try {
			session = sfUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();
			// JRBeanCollectionDataSource ds = new
			// JRBeanCollectionDataSource(list);

			String hqlQuery = "from Pojo";

			Query query = session.createQuery(hqlQuery);

			list = query.list();

			Iterator iterator = list.iterator();

			while (iterator.hasNext()) {
				Pojo p = (Pojo) iterator.next();

				System.out.println(p.getLogId());
				System.out.println(p.getDate());
				System.out.println(p.getLevel());
				System.out.println(p.getLocation());
				System.out.println(p.getBlnk());
				System.out.println(p.getErrordesc());
				System.out.println("------------");
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error("while retrieving records error has been occured", e);
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
