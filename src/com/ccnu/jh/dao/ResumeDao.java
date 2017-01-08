package com.ccnu.jh.dao;

import java.util.List;

import com.ccnu.jh.model.Resume;

public interface ResumeDao extends BaseDao<Resume> {
	public void save(Resume t);
	
	public void update(Resume t);
	
	public void delete(int id);
	
	public Resume get(int id);
	
	public List<Resume> getAll();

}
