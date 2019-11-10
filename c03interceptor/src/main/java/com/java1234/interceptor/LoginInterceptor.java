package com.java1234.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("destroy");
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        System.out.println("init");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("��Actionִ��֮ǰ");
        ActionContext actionContext = invocation.getInvocationContext();
        Map<String, Object> session = actionContext.getSession();
        Object currentUser = session.get("currentUser");
        String result = null;
        if (currentUser != null) {
            result = invocation.invoke();
        } else {
            HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
            request.setAttribute("error", "���ȵ�¼��");
            result = "error";
        }
        System.out.println("��Actionִ��֮��");
        return result;
    }

}
