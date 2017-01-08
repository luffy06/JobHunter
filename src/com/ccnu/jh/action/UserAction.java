package com.ccnu.jh.action;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.UserDaoImpl;
import com.ccnu.jh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String checkEmail() throws Exception {
		ActionContext act = ActionContext.getContext();
		boolean exist = false;
		UserDaoImpl udi = new UserDaoImpl();
		
		if (udi.getByEmail(user.getEmail()) != null)
			exist = true;
		
		act.put("exist", exist);
		return SUCCESS;
	}
	
	public String register() throws Exception {
		UserDaoImpl udi = new UserDaoImpl();
		
		udi.save(user);
		
		return SUCCESS;
	}

	public String login() throws Exception {
		ActionContext act = ActionContext.getContext();
		UserDaoImpl udi = new UserDaoImpl();
		if (udi.check(user)) {
			user = udi.getByEmail(user.getEmail());
			act.getSession().put("userid", user.getId());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String logout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
}
