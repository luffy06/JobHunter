package com.ccnu.jh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.FavoriteDao;
import com.ccnu.jh.model.Favorite;

public class FavoriteDaoImpl implements FavoriteDao {
	public int countByCompanyId(int companyid) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		int res = 0;
		String hql = "select count(*) from Favorite f where f.type=2 and f.id="+companyid;
		Long q = (Long)session.createQuery(hql).uniqueResult();
		if (q != null) {
			res = q.intValue();
		}
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return res;
	}
	
	public void save(Favorite t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public void update(Favorite t) {
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
		
		String hql = "delete favorite f where f.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	public Favorite get(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Favorite f = session.get(Favorite.class, id);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return f;
	}
	
	public List<Favorite> getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "from favorite f";
		List<Favorite> flist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		return flist;
	}

}
