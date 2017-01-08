package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.EduExp;

public interface EduExpDao extends BaseDao<EduExp> {
	public void save(EduExp t);
	
	public void update(EduExp t);
	
	public void delete(int id);
	
	public EduExp get(int id);
	
	public List<EduExp> getAll();

}
