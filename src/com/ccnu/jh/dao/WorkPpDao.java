package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.WorkPp;

public interface WorkPpDao extends BaseDao<WorkPp> {
	public void save(WorkPp t);
	
	public void update(WorkPp t);
	
	public void delete(int id);
	
	public WorkPp get(int id);
	
	public List<WorkPp> getAll();

}
