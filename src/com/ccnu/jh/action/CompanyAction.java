package com.ccnu.jh.action;

import java.util.*;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.CompanyDaoImpl;
import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.dao.impl.FavoriteDaoImpl;
import com.ccnu.jh.model.Company;
import com.ccnu.jh.model.Dict;
import com.ccnu.jh.model.Job;
import com.ccnu.jh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport {
	private Company company;
		
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCompanyList() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		
		CompanyDaoImpl cdi = new CompanyDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		
		List<Company> cl = cdi.getAll(session);
		ArrayList<Job> jl = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		List<Integer> keylist = new ArrayList<>();

		count.add(0);
		int index = 0;
		for (int i = 0; i < cl.size(); i++) {
			Company c = cl.get(i);
			User hr = c.getUser();
			index += hr.getJob().size() - 1;
			count.add(index);
			index ++;
			jl.addAll(hr.getJob());
			
			keylist.add(c.getFinanacestageid());
			keylist.add(c.getIndustryid());
			keylist.add(c.getScaleid());
		}
		
		for (int i = 0; i < keylist.size(); i++) {
			if (!map.containsKey(keylist.get(i))) {
				map.put(keylist.get(i), ddi.get(session, keylist.get(i)).getName());
			}
		}
		
		act.put("companylist", cl);
		act.put("joblist", jl);
		act.put("count", count);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getCompanyInfo() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		Integer cid = new Integer(ServletActionContext.getRequest().getParameter("companyid"));
		int fcount = 0, jcount = 0, acount = 0;
		ArrayList<Job> jl = new ArrayList<>();
		
		CompanyDaoImpl cdi = new CompanyDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		FavoriteDaoImpl fdi = new FavoriteDaoImpl();
		
		Company c = cdi.get(session, cid);
		User hr = c.getUser();
		jl.addAll(c.getUser().getJob());
		
		fcount = fdi.countByCompanyId(session, cid);
		jcount = c.getUser().getJob().size();
		acount = 0;
		
		for (Job j : jl) {
			acount += j.getApplydetail().size();
			if (!map.containsKey(j.getCityid()))
				map.put(j.getCityid(), ddi.get(session, j.getCityid()).getName());
			if (!map.containsKey(j.getDiplomaid()));
				map.put(j.getDiplomaid(), ddi.get(session, j.getDiplomaid()).getName());
			if (!map.containsKey(j.getExperienceid()))
				map.put(j.getExperienceid(), ddi.get(session, j.getExperienceid()).getName());
			if (!map.containsKey(j.getSalaryid()))
				map.put(j.getSalaryid(), ddi.get(session, j.getSalaryid()).getName());
		}
		
		List<Integer> keylist = new ArrayList<Integer>();
		
		keylist.add(c.getFinanacestageid());
		keylist.add(c.getIndustryid());
		keylist.add(c.getScaleid());
		
		for (int i = 0; i < keylist.size(); i++) {
			if (!map.containsKey(keylist.get(i))) {
				map.put(keylist.get(i), ddi.get(session, keylist.get(i)).getName());
			}
		}
		
		act.put("fcount", fcount);
		act.put("jcount", jcount);
		act.put("acount", acount);
		act.put("company", c);
		act.put("hr", hr);
		act.put("joblist", jl);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getUserCompany() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		ArrayList<Integer> slist = new ArrayList<>();
		ArrayList<Integer> flist = new ArrayList<>();
		ArrayList<Integer> ilist = new ArrayList<>();
		
		CompanyDaoImpl cdi = new CompanyDaoImpl();
		DictDaoImpl ddi = new DictDaoImpl();
		
		Company cp = cdi.get(session, user.getId());
		
		List<Dict> tmp = ddi.getAllByTypeId(session, 6);
		for (int i = 0; i < tmp.size(); i++) {
			int key = tmp.get(i).getDictitemid();
			if (cp != null && key != cp.getScaleid())
				slist.add(key);
			else if (cp == null)
				slist.add(key);
			if (!map.containsKey(key))
				map.put(key, tmp.get(i).getName());
		}
		
		tmp = ddi.getAllByTypeId(session, 20);
		for (int i = 0; i < tmp.size(); i++) {
			int key = tmp.get(i).getDictitemid();
			if (cp != null && key != cp.getFinanacestageid())
				flist.add(key);
			else if (cp == null)
				flist.add(key);
			if (!map.containsKey(key))
				map.put(key, tmp.get(i).getName());
		}
		
		tmp = ddi.getAllByTypeId(session, 21);
		for (int i = 0; i < tmp.size(); i++) {
			int key = tmp.get(i).getDictitemid();
			if (cp != null && key != cp.getIndustryid())
				ilist.add(key);
			else if (cp == null)
				ilist.add(key);
			if (!map.containsKey(key))
				map.put(key, tmp.get(i).getName());
		}
		
		
		act.put("company", cp);
		act.put("scalelist", slist);
		act.put("finanacestagelist", flist);
		act.put("industrylist", ilist);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String updateUserCompany() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		
		CompanyDaoImpl cdi = new CompanyDaoImpl();
		
		company.setId(user.getId());
		if (cdi.get(session, user.getId()) == null) {
			cdi.save(session, company);
		}
		else {
			cdi.update(session, company);
		}
		
		session.close();
		sf.close();
		return SUCCESS;
	}
	
}
