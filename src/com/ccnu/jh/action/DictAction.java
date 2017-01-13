package com.ccnu.jh.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.model.Dict;
import com.ccnu.jh.util.FileFunc;
import com.opensymphony.xwork2.ActionSupport;

public class DictAction extends ActionSupport {
	
	public String loadDictionary() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/classes/com/ccnu/jh/util/");
		path += "dictionary.xml";
		
		ArrayList<Dict> dlist = FileFunc.readDictXml(path);
		DictDaoImpl ddi = new DictDaoImpl();
		for (int i = 0; i < dlist.size(); i++) {
			ddi.save(session, dlist.get(i));
		}
		session.close();
		sf.close();
		return SUCCESS;
	}
}
