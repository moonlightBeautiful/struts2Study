package java.com.java1234.action;

import com.opensymphony.xwork2.Action;

/**
 * @author gaoxu
 * 测试每次请求的action是不是同一个
 */
public class HelloAction implements Action {
    private String name;
    private String error;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HelloAction() {

        System.out.println(this);
    }

    @Override
    public String execute() throws Exception {
        if(name==null || "".equals(name)){
            this.error="name是空";
            return ERROR;
        }
        return SUCCESS;
    }

    public String r()throws Exception{
        return "r";
    }

    public String c()throws Exception{
        return "c";
    }

    public String ra()throws Exception{
        return "ra";
    }
}
