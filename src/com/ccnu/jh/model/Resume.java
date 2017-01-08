package com.ccnu.jh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="resume")
public class Resume {
	@Id
	private int id;
	private String realname;
	private String birthday;
	private String advantage;
	private String homepage;
	private int statusid;
	private boolean ishide;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	@OneToMany(mappedBy="resume")
	private Set<EduExp> eduexp = new HashSet<EduExp>();
	
	@OneToMany(mappedBy="resume")
	private Set<ProExp> proexp = new HashSet<ProExp>();
	
	@OneToMany(mappedBy="resume")
	private Set<WorkEp> workep = new HashSet<WorkEp>();
	
	@OneToMany(mappedBy="resume")
	private Set<WorkPp> workpp = new HashSet<WorkPp>();
		
	@OneToMany(mappedBy="resume")
	private Set<ApplyDetail> applydetail = new HashSet<ApplyDetail>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAdvantage() {
		return advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public boolean isIshide() {
		return ishide;
	}

	public void setIshide(boolean ishide) {
		this.ishide = ishide;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<EduExp> getEduexp() {
		return eduexp;
	}

	public void setEduexp(Set<EduExp> eduexp) {
		this.eduexp = eduexp;
	}

	public Set<ProExp> getProexp() {
		return proexp;
	}

	public void setProexp(Set<ProExp> proexp) {
		this.proexp = proexp;
	}

	public Set<WorkEp> getWorkep() {
		return workep;
	}

	public void setWorkep(Set<WorkEp> workep) {
		this.workep = workep;
	}

	public Set<WorkPp> getWorkpp() {
		return workpp;
	}

	public void setWorkpp(Set<WorkPp> workpp) {
		this.workpp = workpp;
	}

	public Set<ApplyDetail> getApplydetail() {
		return applydetail;
	}

	public void setApplydetail(Set<ApplyDetail> applydetail) {
		this.applydetail = applydetail;
	}
	
}
