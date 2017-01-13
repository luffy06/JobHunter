package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.Company;

public interface CompanyDao extends BaseDao<Company> {
	public void save(Session session, Company t);
	
	public void update(Session session, Company t);
	
	public void delete(Session session, int id);
	
	public Company get(Session session, int id);
	
	public List<Company> getAll(Session session);

}
