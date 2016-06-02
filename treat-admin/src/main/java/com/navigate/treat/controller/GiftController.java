package com.navigate.treat.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.github.pagehelper.PageInfo;
import com.navigate.treat.aliyun.oss.OSSObjectSample;
import com.navigate.treat.aliyun.sts.StsService;
import com.navigate.treat.po.basic.Gift;
import com.navigate.treat.po.basic.GiftVo;
import com.navigate.treat.po.basic.SysGift;
import com.navigate.treat.po.basic.SysGiftVo;
import com.navigate.treat.service.GiftService;
import com.navigate.treat.service.SysGiftService;
import com.navigate.treat.util.Config;


@Controller
public class GiftController extends BaseController {
	private static final Logger logger =  LogManager.getLogger(GiftController.class.getName());
	@Autowired
	private GiftService giftService;
	@Autowired
	private SysGiftService sysGiftService;
	
	/**
	 * 获取礼物列表
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	
	@RequestMapping(value = "gift/getGiftList.do")
	@ResponseBody
	public Map<String, Object> getGiftList(HttpServletRequest req, HttpServletResponse resp, GiftVo giftVo) {
		List<Gift> giftList = giftService.getGiftList(giftVo);
		String aliyuncs = Config.getString("aliyuncs").trim();
		
		if(giftList != null && giftList.size()>0){
			for(int i=0;i<giftList.size();i++){
				if(giftList.get(i).getImageUrl() != null){
					giftList.get(i).setImageUrl(aliyuncs + giftList.get(i).getImageUrl());
				}
			}
		}
		PageInfo<Gift> page = new PageInfo<Gift>(giftList);
		
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("giftList", page.getList());
		mapMod.put("total", page.getTotal());
		
		logger.info(page.getList().toString());
		return mapMod;
	}
	/**
	 * 获取礼物信息
	 * @param req
	 * @param resp
	 * @param giftVo
	 * @return
	 */
	@RequestMapping(value = "gift/getGiftInfo.do")
	@ResponseBody
	public Gift getGiftInfo(HttpServletRequest req, HttpServletResponse resp, GiftVo giftVo) {
		Gift gift = giftService.getGiftInfoById(giftVo);
		if(gift != null){
			gift.setImageUrl(Config.getString("aliyuncs").trim() + gift.getImageUrl());
//			Config.getString("aliyuncs");
		}
		return gift;
	}
	/**
	 * 更新礼物信息
	 * @param req
	 * @param resp
	 * @param gift
	 * @return
	 */
	@RequestMapping(value = "gift/updateGiftInfo.do")
	@ResponseBody
	public String updateGiftInfo(HttpServletRequest req, HttpServletResponse resp, Gift gift) {
		logger.info(gift.toString());
		giftService.updateGiftInfo(gift);
		return "ok";
	}
	/**
	 * 添加礼物
	 * @param req
	 * @param resp
	 * @param gift
	 * @return
	 */
	@RequestMapping(value = "gift/addGift.do")
	@ResponseBody
	public String addGift(HttpServletRequest req, HttpServletResponse resp, Gift gift) {
		gift.setStatus(1);
		gift.setCtime(new Date());
		gift.setMtime(new Date());
		int result = giftService.addGift(gift);
		return String.valueOf(result);
	}
	/**
	 * 删除礼物
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "gift/deleteGift.do")
	@ResponseBody
	public String deleteGift(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		String[] idArr = ids.split(",");
		for(int i=0;i<idArr.length;i++){
			giftService.deleteGift(Long.parseLong(idArr[i]));
		}
		return "ok";
	}
	/**
	 * 更改礼物状态
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "gift/changeGiftStatus.do")
	@ResponseBody
	public String changeGiftStatus(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		String status = req.getParameter("status");
		String[] idArr = ids.split(",");
		Gift gift = new Gift();
		for(int i=0;i<idArr.length;i++){
			gift.setId(Long.parseLong(idArr[i]));
			gift.setStatus(Integer.parseInt(status));
			giftService.changeGiftStatus(gift);
		}
		return "ok";
	}
//	@RequestMapping(value = "gift/uploadGiftPic.do")
//	public void uploadGiftPic(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		String id = req.getParameter("id");
//		
//		String path = req.getSession().getServletContext().getRealPath("/")
//				+ "uploadfile" + File.separator
//				+ new SimpleDateFormat("yyyyMMdd").format(new Date())
//				+ File.separator;
//		File file = new File(path);
//		file.mkdirs();
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
//		factory.setRepository(tempPathFile);// 设置缓冲区目录
//		ServletFileUpload upload = new ServletFileUpload(factory);
//		upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB
//		List<FileItem> items = upload.parseRequest(req);// 得到所有的文件
//		Iterator<FileItem> iter = items.iterator();
//		String newfileName ="";
//		while (iter.hasNext()) {
//			FileItem fi = (FileItem) iter.next();
//			String fileName = fi.getName();
//			if (fileName != null) {
//				String firstname = fileName.substring(0,
//						fileName.lastIndexOf("."));// 获取原文件名称
//				fileName = fileName.replace(firstname, new SimpleDateFormat(
//						"yyyyMMddHHmmss").format(new Date()));
//				newfileName = fileName;
//				File fullFile = new File(fileName);
//				File savedFile = new File(path, fullFile.getName());
//				fi.write(savedFile);
//			}
//		}
//	}
	
//	@RequestMapping(value = "gift/goEditPic.do")
//	public ModelAndView goEditPic(Model model, HttpServletRequest req, HttpServletResponse resp){
//		String id = req.getParameter("id");
//		GiftVo giftVo = new GiftVo();
//		giftVo.setId(Long.parseLong(id));
//		Gift gift = giftService.getGiftInfoById(giftVo);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("gift", gift);
//		modelAndView.setViewName("jsp/gift/uploadPicture");
//
////		req.setAttribute("gift", gift);
//		return modelAndView;
//	}
	/**
	 * 上传礼物图片
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "gift/uploadGiftPic1.do")
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
			String filepath = Config.getString("giftFilepath").trim();
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
			Gift gift= new Gift();
			gift.setId(Long.parseLong(id));
			gift.setImageUrl(filepath + newFile.getName());
			giftService.updateGiftInfo(gift);
			
			logger.info("图片上传oss完成，开始删除本地文件……");
			boolean isDelete = false;
			if (newFile.isFile() && newFile.exists()) {  
				isDelete = newFile.delete();  
			}  
			newFile.delete();
			logger.info("删除本地文件完成" + isDelete);
		}
		req.setAttribute("id", id);
		return "jsp/gift/uploadPicture";
	}
	
	/**
	 * 获取系统礼物列表
	 * @param req
	 * @param resp
	 * @param sysGiftVo
	 * @return
	 */
	@RequestMapping(value = "gift/getSysGiftList.do")
	@ResponseBody
	public Map<String, Object> getSysGiftList(HttpServletRequest req, HttpServletResponse resp, SysGiftVo sysGiftVo) {
		List<SysGift> sysGiftList = sysGiftService.getSysGiftList(sysGiftVo);
		String aliyuncs = Config.getString("aliyuncs").trim();
		
		if(sysGiftList != null && sysGiftList.size()>0){
			for(int i=0;i<sysGiftList.size();i++){
				if(sysGiftList.get(i).getBizImage() != null){
					sysGiftList.get(i).setBizImage(aliyuncs + sysGiftList.get(i).getBizImage());
				}
			}
		}
		PageInfo<SysGift> page = new PageInfo<SysGift>(sysGiftList);
		
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("sysGiftList", page.getList());
		mapMod.put("total", page.getTotal());
		
		logger.info(page.getList().toString());
		return mapMod;
	}
	/**
	 * 添加系统礼物
	 * @param req
	 * @param resp
	 * @param sysGift
	 * @return
	 */
	@RequestMapping(value = "gift/addSysGift.do")
	@ResponseBody
	public String addSysGift(HttpServletRequest req, HttpServletResponse resp, SysGift sysGift) {
		sysGift.setStatus(1);
		sysGift.setCtime(new Date());
		sysGift.setMtime(new Date());
		if(sysGift.getBizImage() != null){
			sysGift.setBizImage(sysGift.getBizImage().replaceAll(Config.getString("aliyuncs").trim(), "")); 
		}
		int result = sysGiftService.addSysGift(sysGift);
		return String.valueOf(result);
	}
	/**
	 * 获取系统礼物信息
	 * @param req
	 * @param resp
	 * @param sysGiftVo
	 * @return
	 */
	@RequestMapping(value = "gift/getSysGiftInfo.do")
	@ResponseBody
	public SysGift getSysGiftInfo(HttpServletRequest req, HttpServletResponse resp, SysGiftVo sysGiftVo) {
		SysGift sysGift = sysGiftService.getSysGiftInfoById(sysGiftVo);
		if(sysGift != null){
			sysGift.setBizImage(Config.getString("aliyuncs").trim() + sysGift.getBizImage());
//			Config.getString("aliyuncs");
		}
		return sysGift;
	}
	/**
	 * 更新系统礼物
	 * @param req
	 * @param resp
	 * @param sysGift
	 * @return
	 */
	@RequestMapping(value = "gift/updateSysGiftInfo.do")
	@ResponseBody
	public String updateSysGiftInfo(HttpServletRequest req, HttpServletResponse resp, SysGift sysGift) {
		logger.info(sysGift.toString());
//		sysGift.setMtime(new Date());
		if(sysGift.getBizImage() != null){
			sysGift.setBizImage(sysGift.getBizImage().replaceAll(Config.getString("aliyuncs").trim(), "")); 
		}
		sysGiftService.updateGiftInfo(sysGift);
		return "ok";
	}
	/**
	 * 删除系统礼物
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "gift/deleteSysGift.do")
	@ResponseBody
	public String deleteSysGift(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		String[] idArr = ids.split(",");
		for(int i=0;i<idArr.length;i++){
			sysGiftService.deleteGift(Long.parseLong(idArr[i]));
		}
		return "ok";
	}
	/**
	 * 更改系统礼物状态
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "gift/changeSysGiftStatus.do")
	@ResponseBody
	public String changeSysGiftStatus(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		String status = req.getParameter("status");
		String[] idArr = ids.split(",");
		SysGift sysGift = new SysGift();
		for(int i=0;i<idArr.length;i++){
			sysGift.setId(Long.parseLong(idArr[i]));
			sysGift.setStatus(Integer.parseInt(status));
			sysGiftService.changeGiftStatus(sysGift);
		}
		return "ok";
	}
	
}
