package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.ResumeDao;
import com.ccnu.jh.model.Resume;

public class ResumeDaoImpl implements ResumeDao {
	public void save(Resume t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void update(Resume t) {
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
		
		String hql = "delete resume r where r.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public Resume get(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Resume r = session.get(Resume.class, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return r;
	}
	
	public List<Resume> getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from resume r";
		List<Resume> rlist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return rlist;
	}

}
