/*
 * 主题：教育经历
 * 文件名：EduExp.java
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_educationexperience")
public class EduExp {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String starttime;
	private String endtime;
	private int schoolid;
	private String major;
	private int diplomaid;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getDiplomaid() {
		return diplomaid;
	}

	public void setDiplomaid(int diplomaid) {
		this.diplomaid = diplomaid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
}
