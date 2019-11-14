package com.java1234.action;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.java1234.model.Student;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Student student;
	
	
	
	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public String add() throws Exception {
		System.out.println("开始添加学生："+student);
		Thread.sleep(5000);
		System.out.println(student.getName()+"添加完成");
		return SUCCESS;
	}
	
	
	

}
