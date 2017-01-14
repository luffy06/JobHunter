package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.dao.FavoriteDao;
import com.ccnu.jh.model.Favorite;

public class FavoriteDaoImpl implements FavoriteDao {
	public int countByCompanyId(Session session, int companyid) {
		session.beginTransaction();
		
		int res = 0;
		String hql = "select count(*) from Favorite f where f.type=2 and f.id="+companyid;
		Long q = (Long)session.createQuery(hql).uniqueResult();
		if (q != null) {
			res = q.intValue();
		}
		
		session.getTransaction().commit();
		return res;
	}
	
	public void save(Session session, Favorite t) {
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, Favorite t) {
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete Favorite f where f.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public Favorite get(Session session, int id) {
		session.beginTransaction();
		
		Favorite f = session.get(Favorite.class, id);
		
		session.getTransaction().commit();
		return f;
	}
	
	public List<Favorite> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from Favorite f";
		List<Favorite> flist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return flist;
	}

}
