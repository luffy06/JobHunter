package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.Dictionary;

public interface DictionaryDao extends BaseDao<Dictionary> {
	public void save(Dictionary t);
	
	public void update(Dictionary t);
	
	public void delete(int id);
	
	public Dictionary get(int id);
	
	public List<Dictionary> getAll();

}
