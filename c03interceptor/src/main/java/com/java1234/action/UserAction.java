package com.java1234.action;

import java.util.Map;

import com.java1234.model.User;
import com.java1234.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private UserService userService = new UserService();
    private User user;
    private String error;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String execute() throws Exception {
        if (userService.login(user)) {
            ActionContext actionContext = ActionContext.getContext();
            Map<String, Object> session = actionContext.getSession();
            session.put("currentUser", user);
            System.out.println("登陆成功！");
            return SUCCESS;
        } else {
            this.error = "用户名或密码错误";
            return "error";
        }
    }


}
