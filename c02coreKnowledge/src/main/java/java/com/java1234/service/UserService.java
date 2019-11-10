package java.com.java1234.service;

import java.com.java1234.model.User;

public class UserService {

    public boolean login(User user) {
        if ("java1234".equals(user.getUserName()) && "1234".equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
