package com.java1234.action;


import com.java1234.model.Student;
import com.java1234.model.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * 自动set和get：属性驱动
 * 基本数据类型：前台表单元素name=Action类属性名
 * 数组：前台表单元素name相同多个表单元素，比如checkbox
 * bean类型：前台表单元素name=Action类bean属性名.bean类属性名
 * List<bean>类型：前台表单元素name=Action类bean属性名[index].bean类属性名
 */
public class UserAction1 extends ActionSupport {

    private static final long serialVersionUID = 1L;

    //基本数据类型
    private String name;
    private int age;
    //基本数据类型数组
    private String[] hobby;
    //bean类型
    private User user;
    //List<bean>类型
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    @Override
    public String execute() throws Exception {
        System.out.println("执行了UserAction的默认方法");
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        if (hobby != null) {
            for (String s : hobby) {
                System.out.println("爱好：" + s);
            }
        }
        System.out.println("用户：" + user);
        for (Student student : students) {
            System.out.println("学生：" + student);
        }
        return "success";
    }

}
