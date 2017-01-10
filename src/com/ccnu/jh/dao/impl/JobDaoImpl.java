package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.JobDao;
import com.ccnu.jh.model.Job;

public class JobDaoImpl implements JobDao {
	public void save(Job job) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(job);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void update(Job job) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.update(job);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void delete(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "delete from job j where j.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public Job get(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Job job = session.get(Job.class, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return job;
	}
	
	public List<Job> getByJobName(String jobname) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from job j where j.jobname=?";
		Query q = session.createQuery(hql).setParameter(0, jobname);
		List<Job> joblist = q.list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return joblist;
	}
	
	public List<Job> getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from job j";
		Query q = session.createQuery(hql);
		List<Job> joblist = q.list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return joblist;
	}
}
