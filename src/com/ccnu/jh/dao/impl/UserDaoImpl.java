package com.ccnu.jh.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import com.ccnu.jh.dao.UserDao;
import com.ccnu.jh.model.User;

public class UserDaoImpl implements UserDao {
	
	@Override
	public boolean check(Session session, User user) {
		session.beginTransaction();
		
		boolean success = false;
		String hql = "from User u where u.email=? and u.password=?";
		Query q = session.createQuery(hql).setParameter(0, user.getEmail()).setParameter(1, user.getPassword());
		if (q.list().size() != 0)
			success = true;
				
		session.getTransaction().commit();
		return success;
	}
	
	@Override
	public void save(Session session, User user) {
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
	}
	
	@Override
	public void update(Session session, User user) {
		session.beginTransaction();
		
		session.update(user);
		
		session.getTransaction().commit();
	}
	
	@Override
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete User u where u.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	@Override
	public User get(Session session, int id) {
		session.beginTransaction();
		
		User user = session.get(User.class, id);
		
		session.getTransaction().commit();
		return user;
	}
	
	@Override
	public User getByEmail(Session session, String email) {
		session.beginTransaction();
		
		String hql = "from User u where u.email=:email";
		User user = (User)session.createQuery(hql).setString("email", email).uniqueResult();
		
		session.getTransaction().commit();
		return user;
	}
	
	@Override
	public List<User> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from User u"; 
		Query q = session.createQuery(hql);
		List<User> ul = q.list();
		
		session.getTransaction().commit();
		return ul;
	}
}
