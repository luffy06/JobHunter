package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.JobStat;

public interface JobStatDao extends BaseDao<JobStat> {
	public void save(JobStat t);
	
	public void update(JobStat t);
	
	public void delete(int id);
	
	public JobStat get(int id);
	
	public List<JobStat> getAll();

}
