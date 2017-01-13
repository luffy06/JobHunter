package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.User;

public interface UserDao extends BaseDao<User> {
	
	public boolean check(Session session, User user);
	
	@Override
	public void save(Session session, User user);
	
	@Override
	public void update(Session session, User user);
	
	@Override
	public void delete(Session session, int id);
	
	@Override
	public User get(Session session, int id);
	
	public User getByEmail(Session session, String email);
	
	@Override
	public List<User> getAll(Session session);
}
