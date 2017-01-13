/*
 * 主题：岗位统计信息
 * 文件名：JobStat.java
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_jobstatistics")
public class JobStat {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int browsecount;
	private int sharecount;
			
	@OneToOne(mappedBy="jobstat")
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
