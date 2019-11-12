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
 * ����ֵջ������ֵջ������OGNLȡֵ
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
        // ��ȡ����ֵջValueStack����������ֵջValueStack������ֵ
        ValueStack valueStack = actionContext.getValueStack();
        valueStack.set("name", "����(valueStack)");
        valueStack.set("age", 11);
        //session����ֵ
        Map<String, Object> session = actionContext.getSession();
        session.put("name", "����(session)");
        session.put("age", 13);
        //application����ֵ
        Map<String, Object> application = actionContext.getApplication();
        application.put("name", "����(application)");
        application.put("age", 14);

        //javabean
        student = new Student("С��", 12);

        students = new ArrayList<Student>();
        students.add(new Student("�Ͼ�", 13));
        students.add(new Student("��ʮ", 14));

        studentMap = new HashMap<String, Student>();
        studentMap.put("goodStudent", new Student("ѧ��", 20));
        studentMap.put("badStudent", new Student("ѧ��", 19));
        return SUCCESS;
    }


}
