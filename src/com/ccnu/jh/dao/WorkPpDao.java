package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.WorkPp;

public interface WorkPpDao extends BaseDao<WorkPp> {
	public void save(Session session, WorkPp t);
	
	public void update(Session session, WorkPp t);
	
	public void delete(Session session, int id);
	
	public WorkPp get(Session session, int id);
	
	public List<WorkPp> getAll(Session session);

}
