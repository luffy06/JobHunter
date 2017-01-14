package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ccnu.jh.dao.ApplyDetailDao;
import com.ccnu.jh.model.ApplyDetail;

public class ApplyDetailDaoImpl implements ApplyDetailDao {
	
	public void save(Session session, ApplyDetail t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, ApplyDetail t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete ApplyDetail ad where ad.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public ApplyDetail getByUserIdAndJobId(Session session, int userid, int jobid) {
		session.beginTransaction();
		
		String hql = "from ApplyDetail ad where ad.job.id=? and ad.resume.id=?";
		ApplyDetail ad = (ApplyDetail)session.createQuery(hql).setParameter(0, jobid).setParameter(1, userid).uniqueResult();
		
		session.getTransaction().commit();
		return ad;
	}
		
	public ApplyDetail get(Session session, int id) {
		session.beginTransaction();
		
		ApplyDetail ad = session.get(ApplyDetail.class, id);
		
		session.getTransaction().commit();
		return ad;
	}
	
	public List<ApplyDetail> getByUserId(Session session, int userid) {
		session.beginTransaction();
		
		String hql = "from ApplyDetail ad where ad.resume.id=?";
		List<ApplyDetail> adlist = session.createQuery(hql).setParameter(0, userid).list();
		
		session.getTransaction().commit();
		return adlist;
	}
	
	public List<ApplyDetail> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from ApplyDetail ad";
		List<ApplyDetail> adlist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return adlist;
	}

}
