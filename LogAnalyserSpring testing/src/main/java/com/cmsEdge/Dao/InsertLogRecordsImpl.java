package com.cmsEdge.Dao;

import java.util.ArrayList;
import java.util.Iterator;

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
			String output1 = "";
			String output2 = "";
			String output3 = "";
			String output4 = "";
			String output5 = "";
			Iterator itr = records.iterator();
			int a = 0;
			while (itr.hasNext()) {
				Pojo p = new Pojo();
					output1 = records.get(a);
					records.get(a++);
					output2 = records.get(a++);
					output3 = records.get(a++);
					output4 = records.get(a++);
					output5 = records.get(a++);
					p.setDate(output1);
					p.setLevel(output2);
					p.setLocation(output3);
					p.setBlnk(output4);
					p.setErrordesc(output5);
					p.setRecordsList(records);
				session.save(p);
				if( a % 5 == 0 ) {
		               session.flush();
		               session.clear();
		            }
				if (records.size()==a) 
					break;
				
			}
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
