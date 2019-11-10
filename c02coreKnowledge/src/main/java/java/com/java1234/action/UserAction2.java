package java.com.java1234.action;


import java.com.java1234.model.User;
import java.com.java1234.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction2 extends ActionSupport implements ModelDriven<User> {

    private static final long serialVersionUID = 1L;

    private UserService userService = new UserService();

    private User user = new User();

    @Override
    public String execute() throws Exception {
        System.out.println("执行了UserAction2的默认方法");
        if (userService.login(user)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    @Override
    public User getModel() {
        // TODO Auto-generated method stub
        return user;
    }

}
