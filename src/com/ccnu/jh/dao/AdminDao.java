package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.Admin;

public interface AdminDao extends BaseDao<Admin> {
	public void save(Session session, Admin t);
	
	public void update(Session session, Admin t);
	
	public void delete(Session session, int id);
	
	public Admin get(Session session, int id);
	
	public List<Admin> getAll(Session session);

}
