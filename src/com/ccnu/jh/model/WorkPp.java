/*
 * 主题：工作意向
 * 文件名：WorkPp.java
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
@Table(name="t_workpurpose")
public class WorkPp {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int skillid;
	private int industryid;
	private int cityid;
	private int salaryid;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSkillid() {
		return skillid;
	}

	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

	public int getIndustryid() {
		return industryid;
	}

	public void setIndustryid(int industryid) {
		this.industryid = industryid;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public int getSalaryid() {
		return salaryid;
	}

	public void setSalaryid(int salaryid) {
		this.salaryid = salaryid;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
}
