package com.ccnu.jh.action;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.JobStatDaoImpl;
import com.ccnu.jh.model.JobStat;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JobStatAction extends ActionSupport {
	public String addZan() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		int jobid = new Integer(ServletActionContext.getRequest().getParameter("jobid"));
		
		JobStatDaoImpl jsdi = new JobStatDaoImpl();
		JobStat js = jsdi.get(session, jobid);
		js.setSharecount(js.getSharecount() + 1);
		jsdi.update(session, js);
		
		act.put("jobid", jobid);
		session.close();
		sf.close();
		return SUCCESS;
	}
}
