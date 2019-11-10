package java.com.java1234.action;

import com.opensymphony.xwork2.Action;

/**
 * @author gaoxu
 * 测试每次请求的action是不是同一个
 */
public class HelloAction2 implements Action {

    private String name2;

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    @Override
    public String execute() throws Exception {
        this.name2 = "你好啊";
        return SUCCESS;
    }
}
