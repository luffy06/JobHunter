package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.User;

public interface UserDao extends BaseDao<User> {
	
	public boolean check(User user);
	
	@Override
	public void save(User user);
	
	@Override
	public void update(User user);
	
	@Override
	public void delete(int id);
	
	@Override
	public User get(int id);
	
	public User getByEmail(String email);
	
	@Override
	public List<User> getAll();
}
