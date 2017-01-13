package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.Job;

public interface JobDao extends BaseDao<Job> {
	public void save(Session session, Job t);
	
	public void update(Session session, Job t);
	
	public void delete(Session session, int id);
	
	public Job get(Session session, int id);
	
	public List<Job> getAll(Session session);
}
