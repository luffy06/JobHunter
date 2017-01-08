package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.Job;

public interface JobDao extends BaseDao<Job> {
	public void save(Job t);
	
	public void update(Job t);
	
	public void delete(int id);
	
	public Job get(int id);
	
	public List<Job> getAll();
}
