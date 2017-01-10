package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.EduExpDao;
import com.ccnu.jh.model.EduExp;

public class EduExpDaoImpl implements EduExpDao {
	public void save(EduExp t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void update(EduExp t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void delete(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "delete educationexperience ee where ee.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public EduExp get(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		EduExp ee = session.get(EduExp.class, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return ee;
	}
	
	public List<EduExp> getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from educationexperience ee";
		List<EduExp> eelist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return eelist;
	}

}
