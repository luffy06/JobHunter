package com.ccnu.jh.action;

import org.apache.struts2.ServletActionContext;

import com.ccnu.jh.dao.impl.CompanyDaoImpl;
import com.ccnu.jh.dao.impl.UserDaoImpl;
import com.ccnu.jh.model.Company;
import com.ccnu.jh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user;
	private String opwd;
	private String npwd;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getOpwd() {
		return opwd;
	}

	public void setOpwd(String opwd) {
		this.opwd = opwd;
	}

	public String getNpwd() {
		return npwd;
	}

	public void setNpwd(String npwd) {
		this.npwd = npwd;
	}

	/*
	 * 检查邮箱是否存在
	 */
	public String checkEmail() throws Exception {
		ActionContext act = ActionContext.getContext();
		boolean exist = false;
		UserDaoImpl udi = new UserDaoImpl();
		
		if (udi.getByEmail(user.getEmail()) != null)
			exist = true;
		
		act.put("exist", exist);
		return SUCCESS;
	}
	
	/*
	 * 注册
	 */
	public String register() throws Exception {
		UserDaoImpl udi = new UserDaoImpl();
		
		user.setId(user.getEmail().hashCode());
		udi.save(user);
				
		return SUCCESS;
	}

	/*
	 * 登录
	 */
	public String login() throws Exception {
		ActionContext act = ActionContext.getContext();
		UserDaoImpl udi = new UserDaoImpl();
		if (udi.check(user)) {
			user = udi.getByEmail(user.getEmail());
			user.setPassword("");
			
			act.getSession().put("user", user);
			return SUCCESS;
		}
		
		act.put("url", "index");
		return ERROR;
	}
	
	/*
	 * 登出
	 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
	
	public String updateUserInfo() throws Exception {
		ActionContext act = ActionContext.getContext();
		User suser = (User)act.getSession().get("user");
		
		UserDaoImpl udi = new UserDaoImpl();
		
		user.setId(suser.getId());
		user.setPassword(suser.getPassword());
		user.setEmail(suser.getEmail());
		udi.update(user);
		
		act.getSession().put("user", user);
		return SUCCESS;
	}
	
	public String updatePassword() throws Exception {
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		UserDaoImpl udi = new UserDaoImpl();
		
		user.setPassword(opwd);
		
		if (udi.check(user)) {
			user.setPassword(npwd);
			udi.update(user);
			return SUCCESS;
		}
		
		act.put("url", "getupdatepwd");
		return ERROR;
	}
}
