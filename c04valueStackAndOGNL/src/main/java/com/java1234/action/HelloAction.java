package com.java1234.action;

import com.java1234.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 广义值栈和狭义值栈，界面OGNL取值
 */
public class HelloAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private Student student;

    private List<Student> students;

    private Map<String, Student> studentMap;

    public Map<String, Student> getStudentMap() {
        return studentMap;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public Student getStudent() {
        return student;
    }


    public void setStudent(Student student) {
        this.student = student;
    }

    public void setStudentMap(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    @Override
    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        // 获取狭义值栈ValueStack，并在狭义值栈ValueStack上设置值
        ValueStack valueStack = actionContext.getValueStack();
        valueStack.set("name", "张三(valueStack)");
        valueStack.set("age", 11);
        //session设置值
        Map<String, Object> session = actionContext.getSession();
        session.put("name", "王五(session)");
        session.put("age", 13);
        //application设置值
        Map<String, Object> application = actionContext.getApplication();
        application.put("name", "赵六(application)");
        application.put("age", 14);

        //javabean
        student = new Student("小扒", 12);

        students = new ArrayList<Student>();
        students.add(new Student("老九", 13));
        students.add(new Student("老十", 14));

        studentMap = new HashMap<String, Student>();
        studentMap.put("goodStudent", new Student("学霸", 20));
        studentMap.put("badStudent", new Student("学渣", 19));
        return SUCCESS;
    }


}
