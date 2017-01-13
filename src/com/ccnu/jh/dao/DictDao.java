package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.Dict;

public interface DictDao extends BaseDao<Dict> {
	public void save(Session session, Dict t);
	
	public void update(Session session, Dict t);
	
	public void delete(Session session, int id);
	
	public Dict get(Session session, int id);
	
	public List<Dict> getAll(Session session);

}
