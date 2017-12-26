package main.com.ssh.shop.util;

import main.com.ssh.shop.entity.FileImage;

public interface FileUpload {

    //实现文件上传的功能，返回上传后新的文件名称
    public abstract String uploadFile(FileImage fileImage);
}
