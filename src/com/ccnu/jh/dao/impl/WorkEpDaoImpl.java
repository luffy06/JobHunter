package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.dao.WorkEpDao;
import com.ccnu.jh.model.WorkEp;

public class WorkEpDaoImpl implements WorkEpDao {
	public void save(Session session, WorkEp t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, WorkEp t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete workexperience we where we.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public WorkEp get(Session session, int id) {
		session.beginTransaction();
		
		WorkEp we = session.get(WorkEp.class, id);
		
		session.getTransaction().commit();
		return we;
	}
	
	public List<WorkEp> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from workexperience we";
		List<WorkEp> welist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return welist;
	}

}
