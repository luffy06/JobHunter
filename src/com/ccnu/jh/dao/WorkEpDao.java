package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.WorkEp;

public interface WorkEpDao extends BaseDao<WorkEp> {
	public void save(WorkEp t);
	
	public void update(WorkEp t);
	
	public void delete(int id);
	
	public WorkEp get(int id);
	
	public List<WorkEp> getAll();

}
