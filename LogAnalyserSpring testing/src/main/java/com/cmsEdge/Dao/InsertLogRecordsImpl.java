package com.cmsEdge.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.cmsEdge.Beans.Pojo;
import com.cmsEdge.Util.SFUtil;

@Repository
public class InsertLogRecordsImpl implements InsertLogRecords {
	private SFUtil sfUtil;

	public void insertLog(ArrayList<String> records) {
		Session session = sfUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Iterator itr = records.iterator();
			int a = 0;
			while (itr.hasNext()) {
				Pojo p = new Pojo();
				p.setDate(records.get(a));
				records.get(a++);
				p.setLevel(records.get(a++));
				p.setLocation(records.get(a++));
				p.setBlnk(records.get(a++));
				p.setErrordesc(records.get(a++));
				p.setRecordsList(records);
				session.save(p);
				if (a % 5 == 0) {
					session.flush();
					session.clear();
				}
				if (records.size() == a)
					break;

			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public List readLogs() {
		Session session = sfUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List list=null;
		try {
			transaction = session.beginTransaction();
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
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;

	}

}
