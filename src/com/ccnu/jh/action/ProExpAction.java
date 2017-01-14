package com.ccnu.jh.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.ProExpDaoImpl;
import com.ccnu.jh.dao.impl.ResumeDaoImpl;
import com.ccnu.jh.model.ProExp;
import com.ccnu.jh.model.Resume;
import com.ccnu.jh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProExpAction extends ActionSupport {
	private ProExp proexp;

	public ProExp getProexp() {
		return proexp;
	}

	public void setProexp(ProExp proexp) {
		this.proexp = proexp;
	}
	
	public String saveProExp() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		
		ResumeDaoImpl rdi = new ResumeDaoImpl();
		ProExpDaoImpl pedi = new ProExpDaoImpl();
		
		Resume resume = rdi.get(session, user.getId());
		if (resume == null) {
			resume = new Resume();
			resume.setId(user.getId());
			rdi.save(session, resume);
		}
		
		proexp.setResume(resume);
		pedi.save(session, proexp);
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
