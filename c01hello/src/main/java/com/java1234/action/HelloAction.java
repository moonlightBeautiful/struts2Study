package com.java1234.action;

import com.opensymphony.xwork2.Action;

/**
 * @author gaoxu
 * @company 北山小旭网络科技有限公司
 * @create 2019-10-31-23:48
 */
public class HelloAction implements Action {
    @Override
    public String execute() throws Exception {
        System.out.println("执行了Action的默认方法");
        return SUCCESS;
    }
}
