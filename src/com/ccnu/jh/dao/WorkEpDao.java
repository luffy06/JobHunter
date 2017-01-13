package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.WorkEp;

public interface WorkEpDao extends BaseDao<WorkEp> {
	public void save(Session session, WorkEp t);
	
	public void update(Session session, WorkEp t);
	
	public void delete(Session session, int id);
	
	public WorkEp get(Session session, int id);
	
	public List<WorkEp> getAll(Session session);

}
