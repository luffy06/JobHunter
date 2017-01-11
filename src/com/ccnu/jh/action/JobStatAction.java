package com.ccnu.jh.action;

import org.apache.struts2.ServletActionContext;

import com.ccnu.jh.dao.impl.JobStatDaoImpl;
import com.ccnu.jh.model.JobStat;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JobStatAction extends ActionSupport {
	public String addZan() throws Exception {
		ActionContext act = ActionContext.getContext();
		int jobid = new Integer(ServletActionContext.getRequest().getParameter("jobid"));
		
		JobStatDaoImpl jsdi = new JobStatDaoImpl();
		JobStat js = jsdi.get(jobid);
		js.setSharecount(js.getSharecount() + 1);
		jsdi.update(js);
		
		act.put("jobid", jobid);
		return SUCCESS;
	}
}
