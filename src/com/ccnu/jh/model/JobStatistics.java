package com.ccnu.jh.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="jobstatistics")
public class JobStatistics {
	@Id
	private int id;
	private int browsecount;
	private int sharecount;
			
	@OneToOne
	@JoinColumn(name="jobid")
	private Job job;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrowsecount() {
		return browsecount;
	}

	public void setBrowsecount(int browsecount) {
		this.browsecount = browsecount;
	}

	public int getSharecount() {
		return sharecount;
	}

	public void setSharecount(int sharecount) {
		this.sharecount = sharecount;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
}
