package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ccnu.jh.dao.JobDao;
import com.ccnu.jh.model.Job;

public class JobDaoImpl implements JobDao {
	
	
	public void save(Session session, Job job) {
		session.beginTransaction();
		
		session.save(job);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, Job job) {
		session.beginTransaction();
		
		session.update(job);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete from Job j where j.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public Job get(Session session, int id) {
		session.beginTransaction();
		
		Job job = session.get(Job.class, id);
		
		session.getTransaction().commit();
		return job;
	}
	
	public List<Job> getByJobName(Session session, String jobname) {
		session.beginTransaction();
		
		String hql = "from Job j where j.jobname=?";
		Query q = session.createQuery(hql).setParameter(0, jobname);
		List<Job> joblist = q.list();
		
		session.getTransaction().commit();
		return joblist;
	}
	
	public List<Job> getBySkillId(Session session, int skillid) {
		session.beginTransaction();
		
		String hql = "from Job j where j.skillid=?";
		Query q = session.createQuery(hql).setParameter(0, skillid);
		List<Job> joblist = q.list();
		
		session.getTransaction().commit();
		return joblist;
	}
	
	public List<Job> getByUserId(Session session, int userid) {
		session.beginTransaction();
		
		String hql = "from Job j where j.user.id=?";
		Query q = session.createQuery(hql).setParameter(0, userid);
		List<Job> joblist = q.list();
		
		session.getTransaction().commit();
		return joblist;
	}
	
	public List<Job> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from Job j";
		Query q = session.createQuery(hql);
		List<Job> joblist = q.list();
		
		session.getTransaction().commit();
		return joblist;
	}
}
