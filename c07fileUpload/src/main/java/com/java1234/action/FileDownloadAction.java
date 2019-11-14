package com.java1234.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class FileDownloadAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private String fileName;// 文件名
    private String downloadPath;// 下载的路径
    private String contentType;// 下载文件的类型

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
        // System.out.println(inputStream);输出inputStream，如果为null表示路径出错
        return inputStream;
    }

    @Override
    public String execute() {
        // TODO Auto-generated method stub
        downloadPath = ServletActionContext.getRequest().getParameter(
                "download");
        int position = downloadPath.lastIndexOf("/");// 借助lastIndexOf函数，从右向左查找第一个/
        if (position > 0) {
            fileName = downloadPath.substring(position + 1);// 得到文件的名字(全名，带后缀)
        } else {
            fileName = downloadPath;
        }
        contentType = "application/msword";// 指定下载问文件的类型
        return SUCCESS;
    }
}
