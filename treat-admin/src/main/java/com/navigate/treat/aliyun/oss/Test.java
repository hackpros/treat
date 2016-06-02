package com.navigate.treat.aliyun.oss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class Test {
	//测试
//	public static final String accessKeyId = "DqwykEBhPftelss7";
//	public static final String accessKeySecret = "Ckl1RTerReXIhlRBMru9PIQaCe3vZ0";
//	public static final String bucketName = "hzzh";
	//风清扬的
	public static final String accessKeyId = "fe9GVuknMSE5JYRn";
	public static final String accessKeySecret = "3AaZ1OtXVZ5ahuHyrzdGwUlhsX8Zp6";
	public static final String bucketName = "fengqingyang";
	
	public static final String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
	
	public static void main(String[] args) {
		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		
//		createBucket(client);
		//打印Bucket
//		getBucket(client);
		
		//上传文件  
//		String filePath = "D:\\123.gif";
//		try {
//			putObject(filePath);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//列出所有Object
//		listObjects();
		
		//获取文件
		try {
			getObject("123.gif");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createBucket(OSSClient client){
		String bucketName = "fengqingyang";
		Bucket bucket = client.createBucket(bucketName);
		System.out.println(bucket.getName());
	}
	
	private static void getBucket(OSSClient client){
		// 获取用户的Bucket列表
		List<Bucket> buckets = client.listBuckets();

		// 遍历Bucket
		for (Bucket bucket : buckets) {
		    System.out.println(bucket.getName());
		}
	}
	
	public static void putObject(String filePath) throws FileNotFoundException {
	    // 初始化OSSClient
	    OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

	    // 获取指定文件的输入流
	    File file = new File(filePath);
	    System.out.println(file.getName());
	    InputStream content = new FileInputStream(file);

	    // 创建上传Object的Metadata
	    ObjectMetadata meta = new ObjectMetadata();

	    // 必须设置ContentLength
	    meta.setContentLength(file.length());

	    // 上传Object.
	    PutObjectResult result = client.putObject(bucketName, file.getName(), content, meta);
	   
	    // 打印ETag
	    System.out.println(result.getETag());//EF9534615174BDA150522D9B6645E797
	}
	
	public static void listObjects() {

	    // 初始化OSSClient
	    OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

	    // 获取指定bucket下的所有Object信息
	    ObjectListing listing = client.listObjects(bucketName);

	    // 遍历所有Object
	    for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
	        System.out.println(objectSummary.getKey());
	    }
	}
	
	public static void getObject(String key) throws IOException {
	    // 初始化OSSClient
		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

	    // 获取Object，返回结果为OSSObject对象
	    OSSObject object = client.getObject(bucketName, key);

	    // 获取ObjectMeta
	    ObjectMetadata meta = object.getObjectMetadata();

	    // 获取Object的输入流
	    InputStream objectContent = object.getObjectContent();

	    // 处理Object
	    FileOutputStream fos =  new FileOutputStream("E:\\123.gif");  
	    int ch = 0;  
	    try {  
	        while((ch=objectContent.read()) != -1){  
	            fos.write(ch);  
	        }  
	    } catch (IOException e1) {  
	        e1.printStackTrace();  
	    } finally{  
	        //关闭输入流等（略）  
	        fos.close();  
	    }  

	    // 关闭流
	    objectContent.close();
	}
}
