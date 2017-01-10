package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.Dict;

public interface DictDao extends BaseDao<Dict> {
	public void save(Dict t);
	
	public void update(Dict t);
	
	public void delete(int id);
	
	public Dict get(int id);
	
	public List<Dict> getAll();

}
