package com.ccnu.jh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ccnu.jh.dao.impl.DictDaoImpl;
import com.ccnu.jh.model.Dict;
import com.ccnu.jh.util.FileFunc;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {
	
	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = new HashMap<>();
		
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/classes/com/ccnu/jh/util/");
		path += "dictionary.xml";
		
//		ArrayList<Dict> dlist = FileFunc.readDictXml(path);
//		DictDaoImpl ddi = new DictDaoImpl();
//		for (int i = 0; i < dlist.size(); i++) {
//			ddi.save(dlist.get(i));
//		}
		
		
		act.getApplication().put("m", map);
		return SUCCESS;
	}
}
