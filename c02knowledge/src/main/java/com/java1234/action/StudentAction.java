package com.java1234.action;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport{

	public String list()throws Exception{
		System.out.println("学生查找");
		return SUCCESS;
	}
	
	public String add()throws Exception{
		System.out.println("学生添加");
		return SUCCESS;
	}
	
	public String update()throws Exception{
		System.out.println("学生修改");
		return SUCCESS;
	}
	
	public String delete()throws Exception{
		System.out.println("学生删除");
		return SUCCESS;
	}

	
}
