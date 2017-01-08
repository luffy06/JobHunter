package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.ProExp;

public interface ProExpDao extends BaseDao<ProExp> {
	public void save(ProExp t);
	
	public void update(ProExp t);
	
	public void delete(int id);
	
	public ProExp get(int id);
	
	public List<ProExp> getAll();

}
