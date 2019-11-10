package com.java1234.interceptor;

import com.java1234.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class GirlAuthorityInterceptor implements Interceptor {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String result = null;
        result = invocation.invoke();
        ActionContext actionContext = invocation.getInvocationContext();
        Map<String, Object> session = actionContext.getSession();
        User currentUser = (User)session.get("currentUser");
        if (currentUser.getUserName().equals("java1234")) {
            System.out.println("给与看美女的权限！");
        }
        return result;
    }

}
