package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.ProExp;

public interface ProExpDao extends BaseDao<ProExp> {
	public void save(Session session, ProExp t);
	
	public void update(Session session, ProExp t);
	
	public void delete(Session session, int id);
	
	public ProExp get(Session session, int id);
	
	public List<ProExp> getAll(Session session);

}
