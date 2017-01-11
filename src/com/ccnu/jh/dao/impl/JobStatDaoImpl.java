package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.JobStatDao;
import com.ccnu.jh.model.JobStat;

public class JobStatDaoImpl implements JobStatDao {
	public void browse(int jobid) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		JobStat js = (JobStat)session.get(JobStat.class, jobid);
		js.setBrowsecount(js.getBrowsecount() + 1);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void save(JobStat t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void update(JobStat t) {
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
		
		String hql = "delete jobstatistics js where js.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public JobStat get(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		JobStat js = session.get(JobStat.class, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return js;
	}
	
	public List<JobStat> getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from jobstatistics js";
		List<JobStat> jslist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return jslist;
	}

}
