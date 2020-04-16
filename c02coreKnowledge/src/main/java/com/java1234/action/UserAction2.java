package com.java1234.action;


import com.java1234.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction2 extends ActionSupport implements ModelDriven<User> {

    private static final long serialVersionUID = 1L;

    private User user = new User();

    @Override
    public String execute() {
        System.out.println("执行了UserAction2的默认方法");
        System.out.println(user);
        return "success";
    }

    @Override
    public User getModel() {
        // TODO Auto-generated method stub
        return user;
    }

}
