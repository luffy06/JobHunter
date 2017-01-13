package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.JobStat;

public interface JobStatDao extends BaseDao<JobStat> {
	public void save(Session session, JobStat t);
	
	public void update(Session session, JobStat t);
	
	public void delete(Session session, int id);
	
	public JobStat get(Session session, int id);
	
	public List<JobStat> getAll(Session session);

}
