package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.Admin;

public interface AdminDao extends BaseDao<Admin> {
	public void save(Admin t);
	
	public void update(Admin t);
	
	public void delete(int id);
	
	public Admin get(int id);
	
	public List<Admin> getAll();

}
