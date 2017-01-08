package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.UserDao;
import com.ccnu.jh.model.User;

public class UserDaoImpl implements UserDao {
	
	@Override
	public boolean check(User user) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		boolean success = false;
		String hql = "from user where email=? and password=?";
		Query q = session.createQuery(hql);
		if (q != null)
			success = true;
				
		session.getTransaction().commit();
		session.close();
		sf.close();
		return success;
	}
	
	@Override
	public void save(User user) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	@Override
	public void update(User user) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	@Override
	public void delete(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "delete user where id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	@Override
	public User get(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		User user = session.get(User.class, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return user;
	}
	
	@Override
	public User getByEmail(String email) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from user wher email=?";
		User user = null;
		List l = session.createQuery(hql).setParameter(0, email).list();
		if (l != null)
			user = (User)l.get(0);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return user;
	}
	
	@Override
	public List<User> getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from user"; 
		Query q = session.createQuery(hql);
		List<User> ul = q.list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return ul;
	}
}
