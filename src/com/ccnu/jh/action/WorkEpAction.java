package com.ccnu.jh.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.ResumeDaoImpl;
import com.ccnu.jh.dao.impl.WorkEpDaoImpl;
import com.ccnu.jh.model.Resume;
import com.ccnu.jh.model.User;
import com.ccnu.jh.model.WorkEp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WorkEpAction extends ActionSupport {
	private WorkEp workep;

	public WorkEp getWorkep() {
		return workep;
	}

	public void setWorkep(WorkEp workep) {
		this.workep = workep;
	}
	
	public String saveWorkEp() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		
		ResumeDaoImpl rdi = new ResumeDaoImpl();
		WorkEpDaoImpl wedi = new WorkEpDaoImpl();
		
		Resume resume = rdi.get(session, user.getId());
		if (resume == null) {
			resume = new Resume();
			resume.setId(user.getId());
			rdi.save(session, resume);
		}
		
		workep.setResume(resume);
		wedi.save(session, workep);
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
