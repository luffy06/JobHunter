/*
 * 主题：字典
 * 文件名：Dictionary.java
 * 作者：吴尚宇
 * 版权：版权所有2015-2016 华中师范大学
 * 创建日期：2017-01-10
 * 描述：
 */
package com.ccnu.jh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dictionary")
public class Dict {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
