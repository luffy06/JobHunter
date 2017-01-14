package com.ccnu.jh.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.ccnu.jh.dao.impl.ResumeDaoImpl;
import com.ccnu.jh.model.ApplyDetail;
import com.ccnu.jh.model.Dict;
import com.ccnu.jh.model.EduExp;
import com.ccnu.jh.model.ProExp;
import com.ccnu.jh.model.Resume;
import com.ccnu.jh.model.User;
import com.ccnu.jh.model.WorkEp;
import com.ccnu.jh.model.WorkPp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ResumeAction extends ActionSupport {
	
	private Resume resume;
	
	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public String getUserResume() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		Map<Integer, String> map = (HashMap<Integer, String>)act.getApplication().get("m");
		
		ArrayList<Integer> status = new ArrayList<>();
		ArrayList<Integer> wep = new ArrayList<>();
		ArrayList<Integer> jt = new ArrayList<>();
		ArrayList<String> jtn = new ArrayList<>();
		ArrayList<Integer> skill = new ArrayList<>();
		ArrayList<Integer> salary = new ArrayList<>();
		ArrayList<Integer> industry = new ArrayList<>();
		ArrayList<Integer> city = new ArrayList<>();
		ArrayList<Integer> school = new ArrayList<>();
		ArrayList<Integer> diploma = new ArrayList<>();
		ArrayList<WorkPp> wp = new ArrayList<>();
		ArrayList<WorkEp> we = new ArrayList<>();
		ArrayList<EduExp> ee = new ArrayList<>();
		ArrayList<ProExp> pe = new ArrayList<>();
		Resume resume = null;
		
		DictDaoImpl ddi = new DictDaoImpl();
		ResumeDaoImpl rdi = new ResumeDaoImpl();
		
//		5 求职状态
		List<Dict> tmp = ddi.getAllByTypeId(session, 5);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			status.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}
		
//		3 工作经验
		tmp = ddi.getAllByTypeId(session, 3);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			wep.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}
		
//		7-18 skill jobtype
		for (int j = 7; j <= 18; j++) {
			tmp = ddi.getAllByTypeId(session, j);
			jt.add(tmp.get(0).getDicttypeid());
			jtn.add(tmp.get(0).getDescription());
			for (int i = 0; i < tmp.size(); i++) {
				Dict d = tmp.get(i);
				skill.add(d.getDictitemid());
				if (!map.containsKey(d.getDictitemid())) {
					map.put(d.getDictitemid(), d.getName());
				}
			}
		}
		
//		2 工资
		tmp = ddi.getAllByTypeId(session, 2);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			salary.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}
		
//		21 公司行业
		tmp = ddi.getAllByTypeId(session, 21);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			industry.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}
		
//		1 城市
		tmp = ddi.getAllByTypeId(session, 1);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			city.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}
		
//		19 学校
		tmp = ddi.getAllByTypeId(session, 19);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			school.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}
		
//		4 学历
		tmp = ddi.getAllByTypeId(session, 4);
		for (int i = 0; i < tmp.size(); i++) {
			Dict d = tmp.get(i);
			diploma.add(d.getDictitemid());
			if (!map.containsKey(d.getDictitemid())) {
				map.put(d.getDictitemid(), d.getName());
			}
		}
		
		resume = rdi.get(session, user.getId());
		if (resume != null) {		
			wp.addAll(resume.getWorkpp());
			we.addAll(resume.getWorkep());
			ee.addAll(resume.getEduexp());
			pe.addAll(resume.getProexp());
		}
		
		act.put("resume", resume);
		act.put("status", status);
		act.put("workexperience", wep);
		act.put("jobtype", jt);
		act.put("jobtypename", jtn);
		act.put("skill", skill);
		act.put("salary", salary);
		act.put("industry", industry);
		act.put("city", city);
		act.put("school", school);
		act.put("diploma", diploma);
		act.put("workpp", wp);
		act.put("workep", we);
		act.put("eduexp", ee);
		act.put("proexp", pe);
		act.getApplication().put("m", map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String saveResume() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		String item = ServletActionContext.getRequest().getParameter("item");
		
		ResumeDaoImpl rdi = new ResumeDaoImpl();
		
		Resume dbresume = rdi.get(session, user.getId());
		if (dbresume == null) {
			resume.setId(user.getId());
			rdi.save(session, resume);
		}
		else {
			if (item.equals("status"))
				dbresume.setStatusid(resume.getStatusid());
			else if (item.equals("wep"))
				dbresume.setWorkexperience(resume.getWorkexperience());
			else if (item.equals("advantage"))
				dbresume.setAdvantage(resume.getAdvantage());
			else if (item.equals("url"))
				dbresume.setHomepage(resume.getHomepage());
			rdi.update(session, dbresume);
		}
		
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String postResume() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		int userid = (Integer)act.getSession().get("userid");
		int jobid = new Integer(ServletActionContext.getRequest().getParameter("jobid"));
		
		ApplyDetail ad = new ApplyDetail();
		ApplyDetailDaoImpl addi = new ApplyDetailDaoImpl();
		JobDaoImpl jdi = new JobDaoImpl();
		ResumeDaoImpl rdi = new ResumeDaoImpl();
		String nowtime = (String) new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
		
		ad.setPass(0);
		ad.setJob(jdi.get(session, jobid));
		ad.setResume(rdi.get(session, userid));
		ad.setCreatetime(nowtime);
		addi.save(session, ad);
		
		act.put("jobid", jobid);
		session.close();
		sf.close();
		return SUCCESS;
	}
}
