package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.dao.CompanyDao;
import com.ccnu.jh.model.Company;

public class CompanyDaoImpl implements CompanyDao {
	
	public void save(Session session, Company t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, Company t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete Company c where c.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public Company get(Session session, int id) {
		session.beginTransaction();
		
		Company c = session.get(Company.class, id);
		
		session.getTransaction().commit();
		return c;
	}
	
	public List<Company> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from Company c";
		List<Company> clist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return clist;
	}

}
