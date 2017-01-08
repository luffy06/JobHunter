package com.ccnu.jh.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dictionary")
public class Dictionary {
	@Id
	private int dictitemid;
	private int dicttypeid;
	private String name;
	private String description;
	
	public int getDictitemid() {
		return dictitemid;
	}
	public void setDictitemid(int dictitemid) {
		this.dictitemid = dictitemid;
	}
	public int getDicttypeid() {
		return dicttypeid;
	}
	public void setDicttypeid(int dicttypeid) {
		this.dicttypeid = dicttypeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
