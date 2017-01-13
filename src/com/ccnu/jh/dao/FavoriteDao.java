package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.Favorite;

public interface FavoriteDao extends BaseDao<Favorite> {
	public void save(Session session, Favorite t);
	
	public void update(Session session, Favorite t);
	
	public void delete(Session session, int id);
	
	public Favorite get(Session session, int id);
	
	public List<Favorite> getAll(Session session);

}
