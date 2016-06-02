package com.navigate.treat.aliyun.oss;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class OSSObjectSample {


//    public static void main(String[] args) throws Exception {
//      String bucketName = "MyAppStorage";
//      String filepath= "/user/baymax/";
//        String accessKeyId = "<your STS AccessKeyId>";
//        String accessKeySecret = "<your STS AccessKeySecret>";
//        String securityToken = "<your STS securityToken>";
//          String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
//      String uploadFilePath = "d:/temp/photo.jpg";
//
//      OSSClient client = new OSSClient(endpoint,accessKeyId,accessKeySecret,securityToken);
//      File file = new File(uploadFilePath);
//      InputStream content = new FileInputStream(file);
//      // 创建上传Object的Metadata
//      ObjectMetadata meta = new ObjectMetadata();
//      // 必须设置ContentLength
//      meta.setContentLength(file.length());
//      String key=filepath+"photo.jpg";
//      PutObjectResult result = client.putObject(bucketName, key, content, meta);
//    }
    
    public static void putObject(String bucketName, String filepath, String accessKeyId ,String accessKeySecret, 
    		String securityToken, String endpoint, String uploadFilePath) throws Exception {
//        String bucketName = "MyAppStorage";
//        String filepath = "/user/baymax/";
//        String accessKeyId = "<your STS AccessKeyId>";
//        String accessKeySecret = "<your STS AccessKeySecret>";
//        String securityToken = "<your STS securityToken>";
//        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
//        String uploadFilePath = "d:/temp/photo.jpg";

        OSSClient client = new OSSClient(endpoint,accessKeyId,accessKeySecret,securityToken);
        File file = new File(uploadFilePath);
        InputStream content = new FileInputStream(file);
        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();
        // 必须设置ContentLength
        meta.setContentLength(file.length());
        String key= file.getName();
        PutObjectResult result = client.putObject(bucketName, filepath + key, content, meta);
        //OSSClient.putObject(String bucketName, String key, InputStream input, ObjectMetadata metadata)
//        System.out.println(result.getETag());
      }
}
