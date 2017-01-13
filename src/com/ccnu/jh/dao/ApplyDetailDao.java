package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.ApplyDetail;

public interface ApplyDetailDao extends BaseDao<ApplyDetail> {
	public void save(Session session, ApplyDetail t);
	
	public void update(Session session, ApplyDetail t);
	
	public void delete(Session session, int id);
	
	public ApplyDetail get(Session session, int id);
	
	public List<ApplyDetail> getAll(Session session);

}
