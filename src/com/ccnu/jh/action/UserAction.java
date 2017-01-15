package com.ccnu.jh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.dao.impl.ResumeDaoImpl;
import com.ccnu.jh.dao.impl.UserDaoImpl;
import com.ccnu.jh.model.Company;
import com.ccnu.jh.model.Dict;
import com.ccnu.jh.model.EduExp;
import com.ccnu.jh.model.ProExp;
import com.ccnu.jh.model.Resume;
import com.ccnu.jh.model.User;
import com.ccnu.jh.model.WorkEp;
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
			User dbuser = udi.get(session, user.getId());
			dbuser.setPassword(npwd);
			udi.update(session, dbuser);
			
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
		String type = ServletActionContext.getRequest().getParameter("type");
		
		ArrayList<Integer> slist = new ArrayList<>();
		ArrayList<Integer> elist = new ArrayList<>();
		ArrayList<Integer> dlist = new ArrayList<>();
		List<User> oxerlist = new ArrayList<>();
		ArrayList<Company> company = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		ArrayList<String> ej = new ArrayList<>();
		ArrayList<Integer> md = new ArrayList<>();
		ArrayList<Integer> bc = new ArrayList<>();
		ArrayList<Integer> workexp = new ArrayList<>();
		Integer sal_id = null;
		Integer exp_id = null;
		Integer dip_id = null;
		if (ServletActionContext.getRequest().getParameter("salary_id") != null)
			sal_id = new Integer(ServletActionContext.getRequest().getParameter("salary_id"));
		else
			sal_id = (Integer)act.getSession().get("salary_id");
		if (ServletActionContext.getRequest().getParameter("experience_id") != null)
			exp_id = new Integer(ServletActionContext.getRequest().getParameter("experience_id"));
		else
			exp_id = (Integer)act.getSession().get("experience_id");
		if (ServletActionContext.getRequest().getParameter("diploma_id") != null)
			dip_id = new Integer(ServletActionContext.getRequest().getParameter("diploma_id"));
		else
			dip_id = (Integer)act.getSession().get("diploma_id");
		
		DictDaoImpl ddi = new DictDaoImpl();
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
//		筛选牛人
		if (type != null) {
			if (type.equals("deletedip")) {
				dip_id = null;
			}
			else if (type.equals("deleteexp")) {
				exp_id = null;
			}
			else if (type.equals("deletesal")) {
				sal_id = null;
			}
			for (int i = 0; i < oxerlist.size(); i++) {
				User user = oxerlist.get(i);
				boolean deleted = true;
				if (user.getResume() != null) {
					if (dip_id != null) {
						List<EduExp> eelist = new ArrayList<>(user.getResume().getEduexp());
						for (EduExp ee : eelist) {
							if (dip_id == ee.getDiplomaid()) {
								deleted = false;
								break;
							}
						}
					}
					if (sal_id != null) {
						List<WorkPp> wplist = new ArrayList<>(user.getResume().getWorkpp());
						for (WorkPp wp : wplist) {
							if (sal_id == wp.getSalaryid()) {
								deleted = false;
								break;
							}
						}
					}
					if (exp_id != null) {
						if (user.getResume().getWorkexperience() == exp_id) {
							deleted = false;
						}
					}
				}
				if ((exp_id != null || sal_id != null || dip_id != null) && deleted) {
					oxerlist.remove(i);
					i--;
				}
			}
		}
		
		count.add(0);
		int index = 0;
		for (User user : oxerlist) {
			List<WorkPp> wlist = new ArrayList<>();
			int wep = -1;
			if (user.getResume() != null) {
				wlist.addAll(user.getResume().getWorkpp());
				wep = user.getResume().getWorkexperience();
			}
			workexp.add(wep);
			if (wep > 0 && !map.containsKey(wep))
				map.put(wep, ddi.get(session, wep).getName());
			int bestcity = -1;
			for (WorkPp wp : wlist) {
				ej.add(ddi.get(session, wp.getSkillid()).getName());
				bestcity = wp.getCityid();
			}
			bc.add(bestcity);
			if (bestcity > 0 && !map.containsKey(bestcity))
				map.put(bestcity, ddi.get(session, bestcity).getName());
			count.add(index + wlist.size());
			index += wlist.size();
			
			List<EduExp> eelist = new ArrayList<>();
			int maxdiploma = -1;
			if (user.getResume() != null)
				eelist.addAll(user.getResume().getEduexp());
			for (EduExp ep : eelist)
				maxdiploma = Math.max(maxdiploma, ep.getDiplomaid());
			md.add(maxdiploma);
			if (maxdiploma > 0 && !map.containsKey(maxdiploma))
				map.put(maxdiploma, ddi.get(session, maxdiploma).getName());
		}
		
		if (sal_id != null) {
			act.put("salary", ddi.get(session, sal_id).getName());
			act.getSession().put("salary_id", sal_id);
		}
		else {
			act.getSession().remove("salary_id");
		}
		if (exp_id != null) {
			act.put("experience", ddi.get(session, exp_id).getName());
			act.getSession().put("experience_id", exp_id);
		}
		else {
			act.getSession().remove("experience_id");
		}
		if (dip_id != null) {
			act.put("education", ddi.get(session, dip_id).getName());
			act.getSession().put("diploma_id", dip_id);
		}
		else {
			act.getSession().remove("diploma_id");
		}
		act.put("slist", slist);
		act.put("elist", elist);
		act.put("dlist", dlist);
		act.put("oxerlist", oxerlist);
		act.put("count", count);
		act.put("ej", ej);
		act.put("company", company);
		act.put("maxdiploma", md);
		act.put("bestcity", bc);
		act.put("workexp", workexp);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getOxerInfo() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		int userid = new Integer(ServletActionContext.getRequest().getParameter("userid"));
		
		UserDaoImpl udi = new UserDaoImpl();
		ResumeDaoImpl rdi = new ResumeDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		
		ArrayList<WorkPp> workpp = new ArrayList<>();
		ArrayList<WorkEp> workep = new ArrayList<>();
		ArrayList<ProExp> proexp = new ArrayList<>();
		ArrayList<EduExp> eduexp = new ArrayList<>();
		User oxer = udi.get(session, userid);
		Resume resume = rdi.get(session, userid);
		if (resume != null) {
			workpp.addAll(resume.getWorkpp());
			workep.addAll(resume.getWorkep());
			proexp.addAll(resume.getProexp());
			eduexp.addAll(resume.getEduexp());
		}
		
		ArrayList<Integer> keylist = new ArrayList<>();
		for (WorkPp wp : workpp) {
			keylist.add(wp.getCityid());
			keylist.add(wp.getIndustryid());
			keylist.add(wp.getSkillid());
			keylist.add(wp.getSalaryid());
		}
		
		for (WorkEp we : workep) {
			keylist.add(we.getCityid());
			keylist.add(we.getIndustryid());
		}
		
		for (EduExp ee : eduexp) {
			keylist.add(ee.getDiplomaid());
			keylist.add(ee.getSchoolid());
		}
		
		for (int i = 0; i < keylist.size(); i++) {
			int key = keylist.get(i);
			if (!map.containsKey(key)) {
				map.put(key, ddi.get(session, key).getName());
			}
		}
		act.put("oxer", oxer);
		act.put("resume", resume);
		act.put("workpp", workpp);
		act.put("workep", workep);
		act.put("proexp", proexp);
		act.put("eduexp", eduexp);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
}
