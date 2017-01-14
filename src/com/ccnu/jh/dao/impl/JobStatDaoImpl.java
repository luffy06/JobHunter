package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.dao.JobStatDao;
import com.ccnu.jh.model.JobStat;

public class JobStatDaoImpl implements JobStatDao {
	
	public void save(Session session, JobStat t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, JobStat t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete JobStat js where js.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public JobStat get(Session session, int id) {
		session.beginTransaction();
		
		JobStat js = session.get(JobStat.class, id);
		
		session.getTransaction().commit();
		return js;
	}
	
	public List<JobStat> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from JobStat js";
		List<JobStat> jslist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return jslist;
	}

}
