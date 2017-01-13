package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.dao.EduExpDao;
import com.ccnu.jh.model.EduExp;

public class EduExpDaoImpl implements EduExpDao {
	public void save(Session session, EduExp t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, EduExp t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete educationexperience ee where ee.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public EduExp get(Session session, int id) {
		session.beginTransaction();
		
		EduExp ee = session.get(EduExp.class, id);
		
		session.getTransaction().commit();
		return ee;
	}
	
	public List<EduExp> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from educationexperience ee";
		List<EduExp> eelist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return eelist;
	}

}
