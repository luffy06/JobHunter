/*
 * 主题：岗位信息
 * 文件名：Job.java
 * 作者：吴尚宇
 * 版权：版权所有2015-2016 华中师范大学
 * 创建日期：2017-01-10
 * 描述：
 */
package com.ccnu.jh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_job")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int jobtypeid;
	private int skillid;
	private String jobname;
	private int salaryid;
	private int experienceid;
	private int diplomaid;
	private int cityid;
	private String workaddress;
	private String description;
	private int isclosed;
	
	@JoinColumn(name="user_id")
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private User user;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private JobStat jobstat;
	
	@OneToMany(mappedBy="job", fetch=FetchType.EAGER)
	private Set<ApplyDetail> applydetail = new HashSet<ApplyDetail>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobtypeid() {
		return jobtypeid;
	}

	public void setJobtypeid(int jobtypeid) {
		this.jobtypeid = jobtypeid;
	}

	public int getSkillid() {
		return skillid;
	}

	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public int getSalaryid() {
		return salaryid;
	}

	public void setSalaryid(int salaryid) {
		this.salaryid = salaryid;
	}

	public int getExperienceid() {
		return experienceid;
	}

	public void setExperienceid(int experienceid) {
		this.experienceid = experienceid;
	}

	public int getDiplomaid() {
		return diplomaid;
	}

	public void setDiplomaid(int diplomaid) {
		this.diplomaid = diplomaid;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getWorkaddress() {
		return workaddress;
	}

	public void setWorkaddress(String workaddress) {
		this.workaddress = workaddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsclosed() {
		return isclosed;
	}

	public void setIsclosed(int isclosed) {
		this.isclosed = isclosed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JobStat getJobstat() {
		return jobstat;
	}

	public void setJobstat(JobStat jobstat) {
		this.jobstat = jobstat;
	}

	public Set<ApplyDetail> getApplydetail() {
		return applydetail;
	}

	public void setApplydetail(Set<ApplyDetail> applydetail) {
		this.applydetail = applydetail;
	}
	
}
