package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.Company;

public interface CompanyDao extends BaseDao<Company> {
	public void save(Company t);
	
	public void update(Company t);
	
	public void delete(int id);
	
	public Company get(int id);
	
	public List<Company> getAll();

}
