package com.ccnu.jh.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.ResumeDaoImpl;
import com.ccnu.jh.dao.impl.WorkPpDaoImpl;
import com.ccnu.jh.model.Resume;
import com.ccnu.jh.model.User;
import com.ccnu.jh.model.WorkPp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WorkPpAction extends ActionSupport {
	private WorkPp workpp;

	public WorkPp getWorkpp() {
		return workpp;
	}

	public void setWorkpp(WorkPp workpp) {
		this.workpp = workpp;
	}
	
	public String saveWorkPp() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		
		ResumeDaoImpl rdi = new ResumeDaoImpl();
		WorkPpDaoImpl wpdi = new WorkPpDaoImpl();
		
		Resume resume = rdi.get(session, user.getId());
		if (resume == null) {
			resume = new Resume();
			resume.setId(user.getId());
			rdi.save(session, resume);
		}
		
		workpp.setResume(resume);
		wpdi.save(session, workpp);
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
