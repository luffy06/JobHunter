package com.ccnu.jh.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ccnu.jh.dao.impl.JobDaoImpl;
import com.ccnu.jh.model.Job;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JobAction extends ActionSupport {
	public String getJobList() throws Exception {
		ActionContext act = ActionContext.getContext();
		String jobname = ServletActionContext.getRequest().getParameter("jobname");
		
		JobDaoImpl jdi = new JobDaoImpl();
		List<Job> jl = new ArrayList<Job>(); 
		
		if (jobname == null) {
			jl = jdi.getAll();
		}
		else {
			jl = jdi.getByJobName(jobname);
		}
		
		
		
		act.put("joblist", jl);
		return SUCCESS;
	}
}
