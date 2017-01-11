package com.ccnu.jh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ccnu.jh.dao.impl.CompanyDaoImpl;
import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.dao.impl.JobDaoImpl;
import com.ccnu.jh.dao.impl.JobStatDaoImpl;
import com.ccnu.jh.dao.impl.UserDaoImpl;
import com.ccnu.jh.model.Company;
import com.ccnu.jh.model.Dict;
import com.ccnu.jh.model.Job;
import com.ccnu.jh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JobAction extends ActionSupport {
	public String getJobList() throws Exception {
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
		ArrayList<String> hrname = new ArrayList<>();
		ArrayList<String> hrcname = new ArrayList<>();
		
		// 获取岗位列表
		if (jobname != null) {
			jl = jdi.getByJobName(jobname);
		}
		else if (sid != null) {
			jl = jdi.getBySkillId(new Integer(sid));
		}
		else {
			jl = jdi.getAll();
		}
		
		// 获取岗位一级分类
		// 获取岗位二级分类
		jobtypecount.add(0);
		for (int i = 7; i <= 18; i++) {
			Dict d = ddi.getByTypeId(i);
			jobtypelist.add(d.getDescription());
			List<Dict> skill = ddi.getAllByTypeId(i);
			int last = jobtypecount.get(jobtypecount.size() - 1);
			jobtypecount.add(last + skill.size());
			for (int j = 0; j < skill.size(); j++) {
				skilllist.add(skill.get(j).getName());
				skillid.add(skill.get(i).getDictitemid());
			}
		}
		
		// 获取映射表
		for (int i = 0; i < jl.size(); i++) {
			Job job = jl.get(i);
			if (!map.containsKey(job.getCityid())) {
				map.put(job.getCityid(), ddi.get(job.getCityid()).getName());
			}
			if (!map.containsKey(job.getDiplomaid())) {
				map.put(job.getDiplomaid(), ddi.get(job.getDiplomaid()).getName());
			}
			if (!map.containsKey(job.getExperienceid())) {
				map.put(job.getExperienceid(), ddi.get(job.getExperienceid()).getName());
			}
			if (!map.containsKey(job.getSalaryid())) {
				map.put(job.getSalaryid(), ddi.get(job.getSalaryid()).getName());
			}
		}
		
		// 获取hr名字及hr公司名字
		for (int i = 0; i < jl.size(); i++) {
			Job job = jl.get(i);
			hrname.add(job.getUser().getUsername());
			hrcname.add(job.getUser().getCompany().getShortname());
		}
		
		act.put("jobtypelist", jobtypelist);
		act.put("jobtypecount", jobtypecount);
		act.put("skilllist", skilllist);
		act.put("skillid", skillid);
		act.put("joblist", jl);
		act.put("hr", hrname);
		act.put("hrc", hrcname);
		act.getApplication().put("m", map);
		return SUCCESS;
	}
	
	public String getJobInfo() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		Integer jobid = new Integer(ServletActionContext.getRequest().getParameter("jobid"));
		
		JobDaoImpl jdi = new JobDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		JobStatDaoImpl jsdi = new JobStatDaoImpl();
		
		Job job = jdi.get(jobid);
		User hr = job.getUser();
		Company company = hr.getCompany();
		
		jsdi.browse(jobid);
		
		List<Integer> keylist = new ArrayList<>();
		
		keylist.add(job.getCityid());
		keylist.add(job.getDiplomaid());
		keylist.add(job.getExperienceid());
		keylist.add(job.getJobtypeid());
		keylist.add(job.getSalaryid());
		keylist.add(job.getSkillid());
		
		if (company != null) {
			keylist.add(company.getFinanacestageid());
			keylist.add(company.getIndustryid());
			keylist.add(company.getScaleid());
		}
		
		for (int i = 0; i < keylist.size(); i++) {
			if (!map.containsKey(keylist.get(i))) {
				map.put(keylist.get(i), ddi.get(keylist.get(i)).getName());
			}
		}
		
		act.put("job", job);
		act.put("company", company);
		act.put("hr", hr);
		act.getApplication().put("m", map);
		return SUCCESS;
	}
}
