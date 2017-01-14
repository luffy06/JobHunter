package com.ccnu.jh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.ApplyDetailDaoImpl;
import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.dao.impl.JobDaoImpl;
import com.ccnu.jh.model.ApplyDetail;
import com.ccnu.jh.model.Job;
import com.ccnu.jh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ApplyDetailAction extends ActionSupport {
	public String getUserCenter() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		
		ApplyDetailDaoImpl addi = new ApplyDetailDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		
		List<ApplyDetail> adlist = addi.getByUserId(session, user.getId());
		Job posted = null;
		Job offer = null;
		ArrayList<Integer> keylist = new ArrayList<>();
		
		for (ApplyDetail ad : adlist) {
			if (posted == null && ad.getPass() == 0) {
				posted = ad.getJob();
				keylist.add(ad.getJob().getCityid());
				keylist.add(ad.getJob().getSalaryid());
				keylist.add(ad.getJob().getDiplomaid());
				keylist.add(ad.getJob().getExperienceid());
				keylist.add(ad.getJob().getSkillid());
			}
			if (offer == null && ad.getPass() == 1) {
				offer = ad.getJob();
				keylist.add(ad.getJob().getCityid());
				keylist.add(ad.getJob().getSalaryid());
				keylist.add(ad.getJob().getDiplomaid());
				keylist.add(ad.getJob().getExperienceid());
				keylist.add(ad.getJob().getSkillid());
			}
			if (offer != null && posted != null)
				break;
		}
		
		for (int i = 0; i < keylist.size(); i++) {
			int key = keylist.get(i);
			if (!map.containsKey(key))
				map.put(key, ddi.get(session, key).getName());
		}
		
		act.put("posted", posted);
		act.put("offer", offer);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getUserPosted() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		Integer pass = null;
		if (ServletActionContext.getRequest().getParameter("pass") != null)
			pass = new Integer(ServletActionContext.getRequest().getParameter("pass"));
		
		ApplyDetailDaoImpl addi = new ApplyDetailDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		
		List<ApplyDetail> adlist = addi.getByUserId(session, user.getId());
		ArrayList<Job> posted = new ArrayList<>();
		ArrayList<Integer> keylist = new ArrayList<>();
		
		for (ApplyDetail ad : adlist) {
			if ((pass != null && ad.getPass() == pass) || pass == null) {
				posted.add(ad.getJob());
				keylist.add(ad.getJob().getCityid());
				keylist.add(ad.getJob().getSalaryid());
				keylist.add(ad.getJob().getDiplomaid());
				keylist.add(ad.getJob().getExperienceid());
				keylist.add(ad.getJob().getSkillid());
			}
		}
		
		for (int i = 0; i < keylist.size(); i++) {
			int key = keylist.get(i);
			if (!map.containsKey(key))
				map.put(key, ddi.get(session, key).getName());
		}
		
		act.put("pass", pass);
		act.put("userposted", posted);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
//	getOffer
}
