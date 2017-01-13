package com.ccnu.jh.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.jh.model.Resume;

public interface ResumeDao extends BaseDao<Resume> {
	public void save(Session session, Resume t);
	
	public void update(Session session, Resume t);
	
	public void delete(Session session, int id);
	
	public Resume get(Session session, int id);
	
	public List<Resume> getAll(Session session);

}
