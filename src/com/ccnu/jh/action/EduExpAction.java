package com.ccnu.jh.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.EduExpDaoImpl;
import com.ccnu.jh.dao.impl.ResumeDaoImpl;
import com.ccnu.jh.model.EduExp;
import com.ccnu.jh.model.Resume;
import com.ccnu.jh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EduExpAction extends ActionSupport {
	private EduExp eduexp;

	public EduExp getEduexp() {
		return eduexp;
	}

	public void setEduexp(EduExp eduexp) {
		this.eduexp = eduexp;
	}
	
	public String saveEduExp() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		
		ResumeDaoImpl rdi = new ResumeDaoImpl();
		EduExpDaoImpl eedi = new EduExpDaoImpl();
		
		Resume resume = rdi.get(session, user.getId());
		if (resume == null) {
			resume = new Resume();
			resume.setId(user.getId());
			rdi.save(session, resume);
		}
		
		eduexp.setResume(resume);
		eedi.save(session, eduexp);
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
