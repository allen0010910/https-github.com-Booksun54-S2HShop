package main.com.ssh.shop.util;

import main.com.ssh.shop.entity.FileImage;
import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.UUID;

//文件上传工具类具体实现
@Component("fileUpload")
public class FileUploadUtil implements FileUpload {

    private String filePath;

    @Value("#{prop.filePath}")
    //@Value表示去beans.xml文件中找id="prop"的bean，它是通过注解的方式读取properties配置文件的，然后去相应的配置文件中读取key=filePath的值
    public void setFilePath(String filePath) {
        System.out.println(filePath);
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    //1. 通过文件名获取扩展名
    private String getFileExt(String fileName) {
        return FilenameUtils.getExtension(fileName);
    }

    //2. 生成UUID随机数，作为新的文件名
    private String newFileName(String fileName) {
        String ext = getFileExt(fileName);
        return UUID.randomUUID().toString() + "." + ext;
    }

    //实现文件上传的功能，返回上传后新的文件名称
    @Override
    public String uploadFile(FileImage fileImage) {
        //获取新唯一文件名
        String pic = newFileName(fileImage.getFilename());
        System.out.println("图片路径:" + filePath);
        try {
            File file = new File(filePath, pic);
            System.out.println(file.getAbsolutePath());
            FileUtil.copyFile(fileImage.getFile(), file);//第一个参数是上传的文件，第二个参数是将文件拷贝到新路径下
            return pic;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fileImage.getFile().delete();
        }
    }
}