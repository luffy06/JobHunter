package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.EduExp;

public interface EduExpDao extends BaseDao<EduExp> {
	public void save(Session session, EduExp t);
	
	public void update(Session session, EduExp t);
	
	public void delete(Session session, int id);
	
	public EduExp get(Session session, int id);
	
	public List<EduExp> getAll(Session session);

}
