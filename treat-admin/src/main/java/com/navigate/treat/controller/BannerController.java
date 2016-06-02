package com.navigate.treat.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.github.pagehelper.PageInfo;
import com.navigate.treat.aliyun.oss.OSSObjectSample;
import com.navigate.treat.aliyun.sts.StsService;
import com.navigate.treat.api.IActivitysServiceFront;
import com.navigate.treat.util.Config;


@Controller
public class BannerController extends BaseController {
	private static final Logger logger =  LogManager.getLogger(BannerController.class.getName());
    
	@Resource
	IActivitysServiceFront activitysServiceFront;	
	/**
	 * 获取banner列表
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	
	@RequestMapping(value = "banner/getBannerList.do")
	@ResponseBody
	public Map<String, Object> getBannerList(HttpServletRequest req, HttpServletResponse resp, BennerVo bennerVo) {
		List<Benner> bannerList = bannerService.getBannerList(bennerVo);
		String aliyuncs = Config.getString("aliyuncs").trim();
		
		if(bannerList != null && bannerList.size()>0){
			for(int i=0;i<bannerList.size();i++){
				if(bannerList.get(i).getImgUrl() != null){
					bannerList.get(i).setImgUrl(aliyuncs + bannerList.get(i).getImgUrl());
				}
			}
		}
		PageInfo<Benner> page = new PageInfo<Benner>(bannerList);
		
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("bannerList", page.getList());
		mapMod.put("total", page.getTotal());
		
		logger.info(page.getList().toString());
		return mapMod;
	}
	/**
	 * 获取banner信息
	 * @param req
	 * @param resp
	 * @param bennerVo
	 * @return
	 */
	@RequestMapping(value = "banner/getBannerInfo.do")
	@ResponseBody
	public Benner getBannerInfo(HttpServletRequest req, HttpServletResponse resp, BennerVo bennerVo) {
		Benner benner = bannerService.getBannerInfoById(bennerVo);
		if(benner != null){
			benner.setImgUrl(Config.getString("aliyuncs").trim() + benner.getImgUrl());
		}
		return benner;
	}
	/**
	 * 更新banner信息
	 * @param req
	 * @param resp
	 * @param benner
	 * @return
	 */
	@RequestMapping(value = "banner/updateBannerInfo.do")
	@ResponseBody
	public String updateBannerInfo(HttpServletRequest req, HttpServletResponse resp, Benner benner) {
		bannerService.updateBannerInfo(benner);
		return "ok";
	}
	/**
	 * 添加banner
	 * @param req
	 * @param resp
	 * @param benner
	 * @return
	 */
	@RequestMapping(value = "banner/addBanner.do")
	@ResponseBody
	public String addBanner(HttpServletRequest req, HttpServletResponse resp, Benner benner) {
		benner.setType(2);
		benner.setCtime(new Date());
		int result = bannerService.addBanner(benner);
		return String.valueOf(result);
	}
	/**
	 * 删除banner
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "banner/deleteBanner.do")
	@ResponseBody
	public String deleteBanner(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		String[] idArr = ids.split(",");
		for(int i=0;i<idArr.length;i++){
			bannerService.deleteBanner(Long.parseLong(idArr[i]));
		}
		return "ok";
	}
	/**
	 * 更改banner状态
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "banner/changeBannerStatus.do")
	@ResponseBody
	public String changeBannerStatus(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		String status = req.getParameter("status");
		String[] idArr = ids.split(",");
		Benner gift = new Benner();
		for(int i=0;i<idArr.length;i++){
			gift.setId(Long.parseLong(idArr[i]));
			gift.setType(Integer.parseInt(status));
			bannerService.changeBannerStatus(gift);
		}
		return "ok";
	}
	/**
	 * 上传banner图片
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "banner/uploadBannerPic.do")
	public String uploadGiftPic1(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("id");
		// 转型为MultipartHttpRequest：     
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;     
        // 获得文件：     
        MultipartFile img = multipartRequest.getFile("img");  
        logger.info(img.getOriginalFilename());
        
		String originalFilename = img.getOriginalFilename();
		//上传图片
		if(img!=null && originalFilename!=null && originalFilename.length()>0){
			//存储图片的物理路径
//			String pic_path = "/uploadPic/";
			String pic_path = req.getSession().getServletContext().getRealPath("/")
					+ "uploadfile" + File.separator
					+ new SimpleDateFormat("yyyyMMdd").format(new Date())
					+ File.separator;
			
			//新的图片名称
//			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			String newFileName = new Date().getTime() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(pic_path+newFileName);
			logger.info(newFile.getName());
			logger.info(newFile.getPath());
			if(!newFile.exists()){
				newFile.mkdirs();
			}
			//将内存中的数据写入磁盘
			img.transferTo(newFile);
			AssumeRoleResponse AssumeRole = StsService.getAssumeRoleInfo();
			String bucketName = Config.getString("giftBucket").trim();
			String filepath = Config.getString("bannerFilepath").trim();
			try {
				OSSObjectSample.putObject(bucketName, 
						filepath, 
						AssumeRole.getCredentials().getAccessKeyId(), 
						AssumeRole.getCredentials().getAccessKeySecret(), 
						AssumeRole.getCredentials().getSecurityToken(),
						"http://oss-cn-hangzhou.aliyuncs.com",
						newFile.getPath());
				logger.info("图片上传完成");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//保存数据
			Benner benner= new Benner();
			benner.setId(Long.parseLong(id));
			benner.setImgUrl(filepath + newFile.getName());
			bannerService.updateBannerInfo(benner);
			
			logger.info("图片上传oss完成，开始删除本地文件……");
			boolean isDelete = false;
			if (newFile.isFile() && newFile.exists()) {  
				isDelete = newFile.delete();  
			}  
			newFile.delete();
			logger.info("删除本地文件完成" + isDelete);
		}
		req.setAttribute("id", id);
		return "jsp/banner/uploadBannerPicture";
	}
	
	
	
}
