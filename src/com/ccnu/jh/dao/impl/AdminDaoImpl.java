package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.AdminDao;
import com.ccnu.jh.model.Admin;

public class AdminDaoImpl implements AdminDao {
	public void save(Admin t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void update(Admin t) {
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
		
		String hql = "delete admin a where a.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public Admin get(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Admin admin = session.get(Admin.class, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return admin;
	}
	
	public List<Admin> getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from admin a";
		List<Admin> adminlist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return adminlist;
	}

}
