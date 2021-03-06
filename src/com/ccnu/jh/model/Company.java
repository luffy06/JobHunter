/*
 * 主题：公司
 * 文件名：Company.java
 * 作者：吴尚宇
 * 版权：版权所有2015-2016 华中师范大学
 * 创建日期：2017-01-10
 * 描述：
 */
package com.ccnu.jh.model;

import javax.persistence.*;

@Entity
@Table(name="t_company")
public class Company {
	@Id
	private int id;
	private String fullname;
	private String shortname;
	private int industryid;
	private int scaleid;
	private int finanacestageid;
	private String homepage;
	private String logo;
	private String description;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	
	public int getIndustryid() {
		return industryid;
	}

	public void setIndustryid(int industryid) {
		this.industryid = industryid;
	}

	public int getScaleid() {
		return scaleid;
	}

	public void setScaleid(int scaleid) {
		this.scaleid = scaleid;
	}

	public int getFinanacestageid() {
		return finanacestageid;
	}

	public void setFinanacestageid(int finanacestageid) {
		this.finanacestageid = finanacestageid;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
