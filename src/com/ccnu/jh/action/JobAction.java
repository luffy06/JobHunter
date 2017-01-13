package com.ccnu.jh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.CompanyDaoImpl;
import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.dao.impl.JobDaoImpl;
import com.ccnu.jh.dao.impl.JobStatDaoImpl;
import com.ccnu.jh.model.Company;
import com.ccnu.jh.model.Dict;
import com.ccnu.jh.model.Job;
import com.ccnu.jh.model.JobStat;
import com.ccnu.jh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JobAction extends ActionSupport {
	private Job job;
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getJobList() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		String jobname = ServletActionContext.getRequest().getParameter("jobname");
		String sid = ServletActionContext.getRequest().getParameter("skillid");
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		
		JobDaoImpl jdi = new JobDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		
		List<Job> jl = new ArrayList<Job>();
		ArrayList<String> skilllist = new ArrayList<>();
		ArrayList<Integer> skillid = new ArrayList<>();
		ArrayList<String> jobtypelist = new ArrayList<>();
		ArrayList<Integer> jobtypecount = new ArrayList<>();
		ArrayList<String> hrp = new ArrayList<>();
		ArrayList<String> hrname = new ArrayList<>();
		ArrayList<String> hrcname = new ArrayList<>();
		
		// 获取岗位列表
		if (jobname != null) {
			jl = jdi.getByJobName(session, jobname);
		}
		else if (sid != null) {
			jl = jdi.getBySkillId(session, new Integer(sid));
		}
		else {
			jl = jdi.getAll(session);
		}
		
		// 获取岗位一级分类
		// 获取岗位二级分类
		jobtypecount.add(0);
		for (int i = 7; i <= 18; i++) {
			List<Dict> skill = ddi.getAllByTypeId(session, i);
			if (skill.size() != 0) {
				jobtypelist.add(skill.get(0).getDescription());
				int last = jobtypecount.get(jobtypecount.size() - 1);
				jobtypecount.add(last + skill.size());
				for (int j = 0; j < skill.size(); j++) {
					skilllist.add(skill.get(j).getName());
					skillid.add(skill.get(j).getDictitemid());
				}
			}
		}
		
		// 获取映射表
		for (int i = 0; i < jl.size(); i++) {
			Job job = jl.get(i);
			if (!map.containsKey(job.getCityid())) {
				map.put(job.getCityid(), ddi.get(session, job.getCityid()).getName());
			}
			if (!map.containsKey(job.getDiplomaid())) {
				map.put(job.getDiplomaid(), ddi.get(session, job.getDiplomaid()).getName());
			}
			if (!map.containsKey(job.getExperienceid())) {
				map.put(job.getExperienceid(), ddi.get(session, job.getExperienceid()).getName());
			}
			if (!map.containsKey(job.getSalaryid())) {
				map.put(job.getSalaryid(), ddi.get(session, job.getSalaryid()).getName());
			}
		}
		
		// 获取hr名字及hr公司名字
		for (int i = 0; i < jl.size(); i++) {
			Job job = jl.get(i);
			hrp.add(job.getUser().getPortrait());
			hrname.add(job.getUser().getUsername());
			hrcname.add(job.getUser().getCompany().getShortname());
		}
		
//		for (int i = 0; i < jobtypelist.size(); i++) {
//			System.out.println("type: " + jobtypelist.get(i));
//		}
		
		act.put("jobtypelist", jobtypelist);
		act.put("jobtypecount", jobtypecount);
		act.put("skilllist", skilllist);
		act.put("skillid", skillid);
		act.put("joblist", jl);
		act.put("hrportrait", hrp);
		act.put("hr", hrname);
		act.put("hrc", hrcname);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getJobInfo() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		Integer jobid = new Integer(ServletActionContext.getRequest().getParameter("jobid"));
		
		JobDaoImpl jdi = new JobDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		JobStatDaoImpl jsdi = new JobStatDaoImpl();
		
		Job job = jdi.get(session, jobid);
		User hr = job.getUser();
		Company company = hr.getCompany();
		
		JobStat js = jsdi.get(session, jobid);
		if (js == null) {
			js = new JobStat();
			js.setBrowsecount(1);
			js.setSharecount(0);
			jsdi.save(session, js);
		}
		else {
			js.setBrowsecount(js.getBrowsecount() + 1);
			jsdi.update(session, js);
		}
		
		List<Integer> keylist = new ArrayList<>();
		
		keylist.add(job.getCityid());
		keylist.add(job.getDiplomaid());
		keylist.add(job.getExperienceid());
		keylist.add(job.getSalaryid());
		keylist.add(job.getSkillid());
		
		if (company != null) {
			keylist.add(company.getFinanacestageid());
			keylist.add(company.getIndustryid());
			keylist.add(company.getScaleid());
		}
		
		for (int i = 0; i < keylist.size(); i++) {
			if (!map.containsKey(keylist.get(i))) {
				map.put(keylist.get(i), ddi.get(session, keylist.get(i)).getName());
			}
		}
		
		act.put("job", job);
		act.put("company", company);
		act.put("hr", hr);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getPostJob() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		
		CompanyDaoImpl cdi = new CompanyDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		
		ArrayList<Integer> jtil = new ArrayList<>(); // 7-18
		ArrayList<String> jtl = new ArrayList<>(); // 7-18
		ArrayList<Integer> skl = new ArrayList<>(); // 7-18
		ArrayList<Integer> cil = new ArrayList<>(); // 1
		ArrayList<Integer> sal = new ArrayList<>(); // 2
		ArrayList<Integer> exl = new ArrayList<>(); // 3
		ArrayList<Integer> dil = new ArrayList<>(); // 4
		
		Company company = cdi.get(session, user.getId());
		
		List<Dict> tmp = ddi.getAllByTypeId(session, 1);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			cil.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}
		
		tmp = ddi.getAllByTypeId(session, 2);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			sal.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}

		tmp = ddi.getAllByTypeId(session, 3);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			exl.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}
		
		tmp = ddi.getAllByTypeId(session, 4);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			dil.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}
		
		for (int k = 7; k <= 18; k++) {
			tmp = ddi.getAllByTypeId(session, k);
			if (tmp.size() != 0) {
				jtl.add(tmp.get(0).getDescription());
				jtil.add(tmp.get(0).getDicttypeid());
				for (int i = 0; i < tmp.size(); i++) {
					Dict d = tmp.get(i);
					skl.add(d.getDictitemid());
					if (!map.containsKey(d.getDictitemid())) {
						map.put(d.getDictitemid(), d.getName());
					}
				}
			}
		}
		
		act.put("jobtypelist", jtl);
		act.put("jobtypeidlist", jtil);
		act.put("citylist", cil);
		act.put("skilllist", skl);
		act.put("salarylist", sal);
		act.put("experiencelist", exl);
		act.put("diplomalist", dil);
		act.put("company", company);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String postJob() throws Exception { 
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		JobDaoImpl jdi = new JobDaoImpl();
		User user = (User)act.getSession().get("user");
		
		job.setUser(user);
		jdi.save(session, job);
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
