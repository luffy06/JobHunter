package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.DictDao;
import com.ccnu.jh.model.Dict;

public class DictDaoImpl implements DictDao {
	public void save(Dict t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void update(Dict t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void delete(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "delete dictionary d where d.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public Dict get(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dict d = session.get(Dict.class, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return d;
	}
	
	public Dict getByTypeId(int typeid) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "select distinct d.description from Dict d where d.dicttypeid=?";
		Dict d = (Dict)session.createQuery(hql).setParameter(0, typeid).list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return d;
	}
	
	public List<Dict> getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from dictionary d";
		List<Dict> dlist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return dlist;
	}
	
	public List<Dict> getAllByTypeId(int typeid) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from dictionary d where d.dicttypeid=?";
		List<Dict> dlist = session.createQuery(hql).setParameter(0, typeid).list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return dlist;
	}

}
