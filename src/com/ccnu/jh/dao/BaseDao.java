package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T> {
	public void save(Session session, T t);
	
	public void update(Session session, T t);
	
	public void delete(Session session, int id);
	
	public T get(Session session, int id);
	
	public List<T> getAll(Session session);
}
