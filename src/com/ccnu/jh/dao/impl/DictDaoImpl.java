package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.dao.DictDao;
import com.ccnu.jh.model.Dict;

public class DictDaoImpl implements DictDao {
	public void save(Session session, Dict t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, Dict t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete Dict d where d.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public Dict get(Session session, int id) {
		session.beginTransaction();
		
		Dict d = session.get(Dict.class, id);
		
		session.getTransaction().commit();
		return d;
	}
	
	public List<Dict> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from Dict d";
		List<Dict> dlist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return dlist;
	}
	
	public List<Dict> getAllByTypeId(Session session, int typeid) {
		session.beginTransaction();
		
		String hql = "from Dict d where d.dicttypeid=?";
		List<Dict> dlist = session.createQuery(hql).setParameter(0, typeid).list();
		
		session.getTransaction().commit();
		return dlist;
	}

}
