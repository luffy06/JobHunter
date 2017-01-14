package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.dao.ProExpDao;
import com.ccnu.jh.model.ProExp;

public class ProExpDaoImpl implements ProExpDao {
	public void save(Session session, ProExp t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, ProExp t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete ProExp pe where pe.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public ProExp get(Session session, int id) {
		session.beginTransaction();
		
		ProExp pe = session.get(ProExp.class, id);
		
		session.getTransaction().commit();
		return pe;
	}
	
	public List<ProExp> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from ProExp pe";
		List<ProExp> pelist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return pelist;
	}

}
