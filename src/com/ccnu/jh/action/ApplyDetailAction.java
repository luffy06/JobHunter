package com.ccnu.jh.action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.ApplyDetailDaoImpl;
import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.dao.impl.UserDaoImpl;
import com.ccnu.jh.model.ApplyDetail;
import com.ccnu.jh.model.Company;
import com.ccnu.jh.model.Dict;
import com.ccnu.jh.model.EduExp;
import com.ccnu.jh.model.Job;
import com.ccnu.jh.model.User;
import com.ccnu.jh.model.WorkPp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ApplyDetailAction extends ActionSupport {
	private final String[] STATUS = {"未通过", "已通过", "待审核"};
	
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
		String status = "";
		
		adlist.sort(new Comparator<ApplyDetail>() {
			@Override
			public int compare(ApplyDetail o1, ApplyDetail o2) {
				// TODO Auto-generated method stub
				return o1.getPass() - o2.getPass();
			}
		});
		
		for (ApplyDetail ad : adlist) {
			if (posted == null) {
				posted = ad.getJob();
				status = STATUS[ad.getPass()];
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
		
		
		act.put("status", status);
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
		ArrayList<String> status = new ArrayList<>();
		
		for (ApplyDetail ad : adlist) {
			if ((pass != null && ad.getPass() == pass) || pass == null) {
				posted.add(ad.getJob());
				status.add(STATUS[ad.getPass()]);
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
		
		act.put("status", status);
		act.put("pass", pass);
		act.put("userposted", posted);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getCandidate() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		String type = ServletActionContext.getRequest().getParameter("type");
		User hr = (User)act.getSession().get("user");
		
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
		ArrayList<Job> postedjob = new ArrayList<>();
		ArrayList<Job> job = new ArrayList<>();
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
		
		session.refresh(hr);
		postedjob.addAll(hr.getJob());
		for (int i = 0; i < postedjob.size(); i++) {
			Job j = postedjob.get(i);
			List<ApplyDetail> adlist = new ArrayList<>(j.getApplydetail());
			for (int k = 0; k < adlist.size(); k++) {
				System.out.println("pass: " + adlist.get(k).getPass());
				if (adlist.get(k).getPass() == 2) {
					oxerlist.add(adlist.get(k).getResume().getUser());
					job.add(adlist.get(k).getJob());
				}
			}
		}
		
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
			if (wep != -1 && !map.containsKey(wep))
				map.put(wep, ddi.get(session, wep).getName());
			int bestcity = -1;
			for (WorkPp wp : wlist) {
				ej.add(ddi.get(session, wp.getSkillid()).getName());
				bestcity = wp.getCityid();
			}
			bc.add(bestcity);
			if (bestcity != -1 && !map.containsKey(bestcity))
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
			if (maxdiploma != -1 && !map.containsKey(maxdiploma))
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
		act.put("job", job);
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
	
	public String judgeApplyDetail() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Integer pass = new Integer(ServletActionContext.getRequest().getParameter("pass"));
		Integer userid = new Integer(ServletActionContext.getRequest().getParameter("oxerid"));
		Integer jobid = new Integer(ServletActionContext.getRequest().getParameter("jobid"));
		
		ApplyDetailDaoImpl addi = new ApplyDetailDaoImpl();
		
		ApplyDetail ad = addi.getByUserIdAndJobId(session, userid, jobid);
		ad.setPass(pass);
		addi.update(session, ad);
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
