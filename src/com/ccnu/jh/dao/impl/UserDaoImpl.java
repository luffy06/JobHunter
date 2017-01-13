package com.ccnu.jh.dao.impl;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.UserDao;
import com.ccnu.jh.model.User;

public class UserDaoImpl implements UserDao {
	
	public int countByCompanyId(int companyid) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		int res = 0;
		String hql = "select count(*) from User u where u.companyid="+companyid;
		Long q = (Long)session.createQuery(hql).uniqueResult();
		if (q != null) {
			res = q.intValue();
		}
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return res;
	}
	
	@Override
	public boolean check(User user) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		boolean success = false;
		String hql = "from User u where u.email=? and u.password=?";
		Query q = session.createQuery(hql).setParameter(0, user.getEmail()).setParameter(1, user.getPassword());
		if (q.list().size() != 0)
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
		
		String hql = "delete User u where u.id=?";
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
		
		String hql = "from User u where u.email=:email";
		User user = (User)session.createQuery(hql).setString("email", email).uniqueResult();
		
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
		
		String hql = "from User u"; 
		Query q = session.createQuery(hql);
		List<User> ul = q.list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return ul;
	}
}
