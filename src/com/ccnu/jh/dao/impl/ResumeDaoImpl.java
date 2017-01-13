package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.dao.ResumeDao;
import com.ccnu.jh.model.Resume;

public class ResumeDaoImpl implements ResumeDao {
	public void save(Session session, Resume t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, Resume t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete resume r where r.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public Resume get(Session session, int id) {
		session.beginTransaction();
		
		Resume r = session.get(Resume.class, id);
		
		session.getTransaction().commit();
		return r;
	}
	
	public List<Resume> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from resume r";
		List<Resume> rlist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return rlist;
	}

}
