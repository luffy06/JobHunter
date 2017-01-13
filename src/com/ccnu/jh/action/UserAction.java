package com.ccnu.jh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.CompanyDaoImpl;
import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.dao.impl.UserDaoImpl;
import com.ccnu.jh.model.Company;
import com.ccnu.jh.model.Dict;
import com.ccnu.jh.model.EduExp;
import com.ccnu.jh.model.User;
import com.ccnu.jh.model.WorkPp;
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
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		boolean exist = false;
		UserDaoImpl udi = new UserDaoImpl();
		
		if (udi.getByEmail(session, user.getEmail()) != null)
			exist = true;
		
		act.put("exist", exist);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	/*
	 * 注册
	 */
	public String register() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		UserDaoImpl udi = new UserDaoImpl();
		
		user.setId(user.getEmail().hashCode());
		udi.save(session, user);
				
		session.close();
		sf.close();
		return SUCCESS;
	}

	/*
	 * 登录
	 */
	public String login() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		UserDaoImpl udi = new UserDaoImpl();
		if (udi.check(session, user)) {
			user = udi.getByEmail(session, user.getEmail());
			user.setPassword("");
			
			act.getSession().put("user", user);
			
			session.close();
			sf.close();
			return SUCCESS;
		}
		
		act.put("url", "index");
		session.close();
		sf.close();
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
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User suser = (User)act.getSession().get("user");
		
		UserDaoImpl udi = new UserDaoImpl();
		
		user.setId(suser.getId());
		user.setPassword(suser.getPassword());
		user.setEmail(suser.getEmail());
		udi.update(session, user);
		
		act.getSession().put("user", user);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String updatePassword() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		UserDaoImpl udi = new UserDaoImpl();
		
		user.setPassword(opwd);
		
		if (udi.check(session, user)) {
			user.setPassword(npwd);
			udi.update(session, user);
			session.close();
			sf.close();
			return SUCCESS;
		}
		
		act.put("url", "getupdatepwd");
		session.close();
		sf.close();
		return ERROR;
	}
	
	public String getOxerList() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		
		ArrayList<Integer> slist = new ArrayList<>();
		ArrayList<Integer> elist = new ArrayList<>();
		ArrayList<Integer> dlist = new ArrayList<>();
		List<User> oxerlist = new ArrayList<>();
		ArrayList<Company> company = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		ArrayList<String> ej = new ArrayList<>();
		ArrayList<Integer> md = new ArrayList<>();
		
		DictDaoImpl ddi = new DictDaoImpl();
		CompanyDaoImpl cdi = new CompanyDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		
		List<Dict> tmp = ddi.getAllByTypeId(session, 2);
		for (int i = 0; i < tmp.size(); i++) {
			int key = tmp.get(i).getDictitemid();
			slist.add(key);
			if (!map.containsKey(key))
				map.put(key, tmp.get(i).getName());
		}
		
		tmp = ddi.getAllByTypeId(session, 3);
		for (int i = 0; i < tmp.size(); i++) {
			int key = tmp.get(i).getDictitemid();
			elist.add(key);
			if (!map.containsKey(key))
				map.put(key, tmp.get(i).getName());
		}
		
		tmp = ddi.getAllByTypeId(session, 4);
		for (int i = 0; i < tmp.size(); i++) {
			int key = tmp.get(i).getDictitemid();
			dlist.add(key);
			if (!map.containsKey(key))
				map.put(key, tmp.get(i).getName());
		}
		
		oxerlist = udi.getAll(session);
		
		count.add(0);
		int index = 0;
		for (User user : oxerlist) {
			List<WorkPp> wlist = new ArrayList<>();
			if (user.getResume() != null)
				wlist.addAll(user.getResume().getWorkpp());
			for (WorkPp wp : wlist)
				ej.add(ddi.get(session, wp.getSkillid()).getName());
			count.add(index + wlist.size());
			index += wlist.size();
			
			List<EduExp> eelist = new ArrayList<>();
			int maxdiploma = -1;
			if (user.getResume() != null)
				eelist.addAll(user.getResume().getEduexp());
			for (EduExp ep : eelist)
				maxdiploma = Math.max(maxdiploma, ep.getDiplomaid());
			md.add(maxdiploma);
			if (maxdiploma != -1 && !map.containsKey(maxdiploma))
				map.put(maxdiploma, ddi.get(session, maxdiploma).getName());
		}
		
		act.put("slist", slist);
		act.put("elist", elist);
		act.put("dlist", dlist);
		act.put("oxerlist", oxerlist);
		act.put("count", count);
		act.put("ej", ej);
		act.put("company", company);
		act.put("maxdiploma", md);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
}
