package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.ApplyDetail;

public interface ApplyDetailDao extends BaseDao<ApplyDetail> {
	public void save(ApplyDetail t);
	
	public void update(ApplyDetail t);
	
	public void delete(int id);
	
	public ApplyDetail get(int id);
	
	public List<ApplyDetail> getAll();

}
