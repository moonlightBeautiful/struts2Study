package com.java1234.action;

import com.opensymphony.xwork2.ActionSupport;

public class GradeAction extends ActionSupport {

    public String list() throws Exception {
        System.out.println("班级查找");
        return SUCCESS;
    }

    public String add() throws Exception {
        System.out.println("班级添加");
        return SUCCESS;
    }

    public String update() throws Exception {
        System.out.println("班级修改");
        return SUCCESS;
    }

    public String delete() throws Exception {
        System.out.println("班级删除");
        return SUCCESS;
    }


}
