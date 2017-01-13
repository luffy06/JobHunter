/*
 * 主题：用户信息
 * 文件名：User.java
 * 作者：吴尚宇
 * 版权：版权所有2015-2016 华中师范大学
 * 创建日期：2017-01-10
 * 描述：
 */
package com.ccnu.jh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private int sex;
	private String wechat;
	private String email;
	private String telnumber;
	private String portrait;
	private String workingtime;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Resume resume;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Company company;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Set<Favorite> favorite = new HashSet<Favorite>();
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Set<Job> job = new HashSet<Job>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getWorkingtime() {
		return workingtime;
	}

	public void setWorkingtime(String workingtime) {
		this.workingtime = workingtime;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Favorite> getFavorite() {
		return favorite;
	}

	public void setFavorite(Set<Favorite> favorite) {
		this.favorite = favorite;
	}

	public Set<Job> getJob() {
		return job;
	}

	public void setJob(Set<Job> job) {
		this.job = job;
	}
}
