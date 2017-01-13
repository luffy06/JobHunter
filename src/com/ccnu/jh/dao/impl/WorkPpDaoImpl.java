package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.dao.WorkPpDao;
import com.ccnu.jh.model.WorkPp;

public class WorkPpDaoImpl implements WorkPpDao {
	public void save(Session session, WorkPp t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, WorkPp t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete workpurpose wp where wp.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public WorkPp get(Session session, int id) {
		session.beginTransaction();
		
		WorkPp wp = session.get(WorkPp.class, id);
		
		session.getTransaction().commit();
		return wp;
	}
	
	public List<WorkPp> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from workpurpose wp";
		List<WorkPp> wplist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return wplist;
	}

}
