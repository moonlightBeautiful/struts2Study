package com.java1234.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class FileDownloadAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private String fileName;// �ļ���
    private String downloadPath;// ���ص�·��
    private String contentType;// �����ļ�������

    public String getFileName() throws Exception {
        fileName = new String(fileName.getBytes(), "ISO8859-1");
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public InputStream getInputStream() throws Exception {
        InputStream inputStream = ServletActionContext.getServletContext()
                .getResourceAsStream("/"+downloadPath);
        // System.out.println(inputStream);���inputStream�����Ϊnull��ʾ·������
        return inputStream;
    }

    @Override
    public String execute() {
        // TODO Auto-generated method stub
        downloadPath = ServletActionContext.getRequest().getParameter(
                "download");
        int position = downloadPath.lastIndexOf("/");// ����lastIndexOf����������������ҵ�һ��/
        if (position > 0) {
            fileName = downloadPath.substring(position + 1);// �õ��ļ�������(ȫ��������׺)
        } else {
            fileName = downloadPath;
        }
        contentType = "application/msword";// ָ���������ļ�������
        return SUCCESS;
    }
}
