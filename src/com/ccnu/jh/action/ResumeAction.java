package com.ccnu.jh.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.struts2.ServletActionContext;

import com.ccnu.jh.dao.impl.ApplyDetailDaoImpl;
import com.ccnu.jh.dao.impl.JobDaoImpl;
import com.ccnu.jh.dao.impl.ResumeDaoImpl;
import com.ccnu.jh.model.ApplyDetail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ResumeAction extends ActionSupport {
	public String postResume() throws Exception {
		ActionContext act = ActionContext.getContext();
		int userid = (Integer)act.getSession().get("userid");
		int jobid = new Integer(ServletActionContext.getRequest().getParameter("jobid"));
		
		ApplyDetail ad = new ApplyDetail();
		ApplyDetailDaoImpl addi = new ApplyDetailDaoImpl();
		JobDaoImpl jdi = new JobDaoImpl();
		ResumeDaoImpl rdi = new ResumeDaoImpl();
		String nowtime = (String) new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
		
		ad.setPass(false);
		ad.setJob(jdi.get(jobid));
		ad.setResume(rdi.get(userid));
		ad.setCreatetime(nowtime);
		addi.save(ad);
		
		act.put("jobid", jobid);
		return SUCCESS;
	}
}
