package com.ccnu.jh.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {
	
	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<Integer, String> map = new HashMap<>();
		act.getApplication().put("m", map);
		return SUCCESS;
	}
}
