package com.ccnu.jh.action;

import org.apache.struts2.ServletActionContext;

import com.ccnu.jh.dao.impl.CompanyDaoImpl;
import com.ccnu.jh.dao.impl.UserDaoImpl;
import com.ccnu.jh.model.Company;
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
//		CompanyDaoImpl cdi = new CompanyDaoImpl();
		
		
		user.setId(user.getEmail().hashCode());
		udi.save(user);
		
//		String role = ServletActionContext.getRequest().getParameter("role");
//		if (role.equals("hr")) {
//			Company c = new Company();
//			c.setId(user.getId());
//			cdi.save(c);
//		}
		
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
			System.out.println("username: " + user.getUsername());
			
			act.getSession().put("username", user.getUsername());
			act.getSession().put("userid", user.getId());
			return SUCCESS;
		}
		return ERROR;
	}
	
	/*
	 * 登出
	 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
}
