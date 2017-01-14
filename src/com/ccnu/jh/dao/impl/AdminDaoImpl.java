package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.dao.AdminDao;
import com.ccnu.jh.model.Admin;

public class AdminDaoImpl implements AdminDao {
	public void save(Session session, Admin t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, Admin t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete Admin a where a.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public Admin get(Session session, int id) {
		session.beginTransaction();
		
		Admin admin = session.get(Admin.class, id);
		
		session.getTransaction().commit();
		return admin;
	}
	
	public List<Admin> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from Admin a";
		List<Admin> adminlist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return adminlist;
	}

}
