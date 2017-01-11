package com.ccnu.jh.action;

import java.util.*;

import org.apache.struts2.ServletActionContext;

import com.ccnu.jh.dao.impl.ApplyDetailDaoImpl;
import com.ccnu.jh.dao.impl.CompanyDaoImpl;
import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.dao.impl.FavoriteDaoImpl;
import com.ccnu.jh.dao.impl.JobDaoImpl;
import com.ccnu.jh.dao.impl.UserDaoImpl;
import com.ccnu.jh.model.ApplyDetail;
import com.ccnu.jh.model.Company;
import com.ccnu.jh.model.Job;
import com.ccnu.jh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport {
	public String getCompanyList() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		
		CompanyDaoImpl cdi = new CompanyDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		
		List<Company> cl = cdi.getAll();
		ArrayList<Job> jl = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		List<Integer> keylist = new ArrayList<>();

		count.add(0);
		for (int i = 0; i < cl.size(); i++) {
			Company c = cl.get(i);
			User hr = c.getUser();
			count.add(hr.getJob().size());
			jl.addAll(hr.getJob());
			
			keylist.add(c.getFinanacestageid());
			keylist.add(c.getIndustryid());
			keylist.add(c.getScaleid());
		}
		
		for (int i = 0; i < keylist.size(); i++) {
			if (!map.containsKey(keylist.get(i))) {
				map.put(keylist.get(i), ddi.get(keylist.get(i)).getName());
			}
		}
		
		act.put("companylist", cl);
		act.put("joblist", jl);
		act.put("count", count);
		act.getApplication().put("m", map);
		return SUCCESS;
	}
	
	public String getCompanyInfo() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		Integer cid = new Integer(ServletActionContext.getRequest().getParameter("companyid"));
		int fcount = 0, jcount = 0, acount = 0;
		
		CompanyDaoImpl cdi = new CompanyDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		FavoriteDaoImpl fdi = new FavoriteDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		ApplyDetailDaoImpl addi = new ApplyDetailDaoImpl();
		
		Company c = cdi.get(cid);
		User hr = c.getUser();
		fcount = fdi.countByCompanyId(cid);
		jcount = udi.countByCompanyId(cid);
		acount = addi.countByCompanyId(cid);
		
		List<Integer> keylist = new ArrayList<Integer>();
		
		keylist.add(c.getFinanacestageid());
		keylist.add(c.getIndustryid());
		keylist.add(c.getScaleid());
		
		for (int i = 0; i < keylist.size(); i++) {
			if (!map.containsKey(keylist.get(i))) {
				map.put(keylist.get(i), ddi.get(keylist.get(i)).getName());
			}
		}
		
		act.put("fcount", fcount);
		act.put("jcount", jcount);
		act.put("acount", acount);
		act.put("company", c);
		act.put("hr", hr);
		act.getApplication().put("m", map);
		return SUCCESS;
	}
}
