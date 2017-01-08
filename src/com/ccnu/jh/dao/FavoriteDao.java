package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.Favorite;

public interface FavoriteDao extends BaseDao<Favorite> {
	public void save(Favorite t);
	
	public void update(Favorite t);
	
	public void delete(int id);
	
	public Favorite get(int id);
	
	public List<Favorite> getAll();

}
