package com.ccnu.jh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ccnu.jh.dao.impl.CompanyDaoImpl;
import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.dao.impl.JobDaoImpl;
import com.ccnu.jh.dao.impl.UserDaoImpl;
import com.ccnu.jh.model.Dict;
import com.ccnu.jh.model.Job;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JobAction extends ActionSupport {
	public String getJobList() throws Exception {
		ActionContext act = ActionContext.getContext();
		String jobname = ServletActionContext.getRequest().getParameter("jobname");
		
		JobDaoImpl jdi = new JobDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		CompanyDaoImpl cdi = new CompanyDaoImpl();
		
		List<Job> jl = new ArrayList<Job>();
		ArrayList<String> skilllist = new ArrayList<>();
		ArrayList<String> jobtypelist = new ArrayList<>();
		ArrayList<Integer> jobtypecount = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		ArrayList<String> hrname = new ArrayList<>();
		ArrayList<String> hrcname = new ArrayList<>();
		
		// 获取岗位列表
		if (jobname == null) {
			jl = jdi.getAll();
		}
		else {
			jl = jdi.getByJobName(jobname);
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
			for (int j = 0; j < skill.size(); j++)
				skilllist.add(skill.get(j).getName());
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
			hrname.add(udi.get(job.getCompany().getId()).getUsername());
			hrcname.add(job.getCompany().getShortname());
		}
		
		act.put("jobtypelist", jobtypelist);
		act.put("jobtypecount", jobtypecount);
		act.put("skilllist", skilllist);
		act.put("joblist", jl);
		act.put("m", map);
		act.put("hr", hrname);
		act.put("hrc", hrcname);
		return SUCCESS;
	}
}
