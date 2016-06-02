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
import com.navigate.treat.po.basic.Benner;
import com.navigate.treat.po.basic.SysGiftSpread;
import com.navigate.treat.po.basic.SysGiftSpreadVo;
import com.navigate.treat.service.BannerService;
import com.navigate.treat.service.SysGiftSpreadService;
import com.navigate.treat.util.Config;
@Controller
public class SysGiftSpreadController extends BaseController {
	private static final Logger logger = LogManager.getLogger(SysGiftSpreadController.class.getName());
	@Autowired
	private SysGiftSpreadService sysGiftSpreadService;
	@Autowired
	private BannerService bannerService;

	/**
	 * 获取礼物列表
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "sysGiftSpread/getSysGiftSpreadList.do")
	@ResponseBody
	public Map<String, Object> getSysGiftSpreadList(HttpServletRequest req, HttpServletResponse resp,
			SysGiftSpreadVo sysGiftSpreadVo) {
		List<SysGiftSpread> sysGiftSpreadList = sysGiftSpreadService.getSysGiftSpreadList(sysGiftSpreadVo);
		String aliyuncs = Config.getString("aliyuncs").trim();
		if (sysGiftSpreadList != null && sysGiftSpreadList.size() > 0) {
			for (int i = 0; i < sysGiftSpreadList.size(); i++) {
				if (sysGiftSpreadList.get(i).getBigImg() != null) {
					sysGiftSpreadList.get(i).setBigImg(aliyuncs + sysGiftSpreadList.get(i).getBigImg());
				}
				if (sysGiftSpreadList.get(i).getCoverImg() != null) {
					sysGiftSpreadList.get(i).setCoverImg(aliyuncs + sysGiftSpreadList.get(i).getCoverImg());
				}
			}
		}
		PageInfo<SysGiftSpread> page = new PageInfo<SysGiftSpread>(sysGiftSpreadList);
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("sysGiftSpreadList", page.getList());
		mapMod.put("total", page.getTotal());
		logger.info(page.getList().toString());
		return mapMod;
	}
	@RequestMapping(value = "sysGiftSpread/getSysGiftSpreadInfo.do")
	@ResponseBody
	public SysGiftSpread getSysGiftSpreadInfo(HttpServletRequest req, HttpServletResponse resp,
			SysGiftSpreadVo sysGiftSpreadVo) {
		SysGiftSpread sysGiftSpread = sysGiftSpreadService.getsysGiftSpreadVoInfoById(sysGiftSpreadVo);
		if (sysGiftSpread != null) {
			sysGiftSpread.setBigImg(Config.getString("aliyuncs").trim() + sysGiftSpread.getBigImg());
			sysGiftSpread.setCoverImg(Config.getString("aliyuncs").trim() + sysGiftSpread.getCoverImg());
		}
		return sysGiftSpread;
	}
	@RequestMapping(value = "sysGiftSpread/updateSysGiftSpreadInfo.do")
	@ResponseBody
	public String updateSysGiftSpreadInfo(HttpServletRequest req, HttpServletResponse resp,
			SysGiftSpread sysGiftSpread) {
		// 根据id更新传递的参数
		sysGiftSpreadService.updateSysGiftSpreadInfo(sysGiftSpread);
		return "ok";
	}
	@RequestMapping(value = "sysGiftSpread/addSysGiftSpread.do")
	@ResponseBody
	public String addSysGiftSpread(HttpServletRequest req, HttpServletResponse resp, SysGiftSpread sysGiftSpread) {
		sysGiftSpread.setStatus(2);
		sysGiftSpread.setCtime(new Date());
		int result = sysGiftSpreadService.addSysGiftSpread(sysGiftSpread);
		return String.valueOf(result);
	}
	@RequestMapping(value = "sysGiftSpread/saveSysGiftSpreadBody.do")
	@ResponseBody
	public String saveSysGiftSpreadBody(HttpServletRequest req, HttpServletResponse resp) {
		long id = Long.parseLong(req.getParameter("id"));
		String body = req.getParameter("body");
		SysGiftSpread sysGiftSpread = new SysGiftSpread();
		sysGiftSpread.setId(id);
		sysGiftSpread.setBody(body);
		sysGiftSpreadService.updateSysGiftSpreadInfo(sysGiftSpread);
		System.out.println(body);
		return "ok";
	}
	@RequestMapping(value = "sysGiftSpread/deleteSysGiftSpread.do")
	@ResponseBody
	public String deleteSysGiftSpread(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		String[] idArr = ids.split(",");
		// SysGiftSpreadVo sysGiftSpreadVo = new SysGiftSpreadVo();
		for (int i = 0; i < idArr.length; i++) {
			// sysGiftSpreadVo.setId(Long.parseLong(idArr[i]));;
			// SysGiftSpread sysGiftSpread =
			// sysGiftSpreadService.getsysGiftSpreadVoInfoById(sysGiftSpreadVo);
			// //如果同步到了banner，就先删除banner的
			// if(sysGiftSpread.getBannerImg() != null &&
			// Long.parseLong(sysGiftSpread.getBannerImg())>0){
			// bannerService.deleteBanner(Long.parseLong(sysGiftSpread.getBannerImg()));
			// }
			sysGiftSpreadService.deleteSysGiftSpread(Long.parseLong(idArr[i]));
		}
		return "ok";
	}
	@RequestMapping(value = "sysGiftSpread/changeSysGiftSpreadStatus.do")
	@ResponseBody
	public String changeSysGiftSpreadStatus(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		String status = req.getParameter("status");
		String[] idArr = ids.split(",");
		SysGiftSpread sysGiftSpread = new SysGiftSpread();
		//SysGiftSpreadVo sysGiftSpreadVo = new SysGiftSpreadVo();
		for (int i = 0; i < idArr.length; i++) {
			// 如果是下架，那么先判断是否同步到了banner，是的话先删除banner
			// if("2".equals(status)){
			// sysGiftSpreadVo.setId(Long.parseLong(idArr[i]));;
			// SysGiftSpread sysGiftSpreadResult =
			// sysGiftSpreadService.getsysGiftSpreadVoInfoById(sysGiftSpreadVo);
			// //如果同步到了banner，就先删除banner的
			// if(sysGiftSpreadResult.getBannerImg() != null &&
			// Long.parseLong(sysGiftSpreadResult.getBannerImg())>0){
			// bannerService.deleteBanner(Long.parseLong(sysGiftSpreadResult.getBannerImg()));
			// }
			// sysGiftSpread.setBannerImg("0");
			// }
			sysGiftSpread.setId(Long.parseLong(idArr[i]));
			sysGiftSpread.setStatus(Integer.parseInt(status));
			sysGiftSpreadService.changeBannerStatus(sysGiftSpread);
		}
		return "ok";
	}
	/**
	 * 预览富文本内容
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "sysGiftSpread/previewBody.do")
	public String previewTheme(HttpServletRequest req, HttpServletResponse resp) {
		long id = Long.parseLong(req.getParameter("id"));
		String body = sysGiftSpreadService.getBodyById(id);
		req.setAttribute("body", body);
		return "jsp/sysGiftSpread/body";
	}
	@RequestMapping(value = "sysGiftSpread/getBody.do")
	@ResponseBody
	public SysGiftSpread getTheme(HttpServletRequest req, HttpServletResponse resp) {
		long id = Long.parseLong(req.getParameter("id"));
		String body = sysGiftSpreadService.getBodyById(id);
		SysGiftSpread sysGiftSpread = new SysGiftSpread();
		sysGiftSpread.setBody(body);
		return sysGiftSpread;
	}
	/**
	 * 同步礼物
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "sysGiftSpread/synchronize.do")
	@ResponseBody
	public SysGiftSpread synchronize(HttpServletRequest req, HttpServletResponse resp) {
		long id = Long.parseLong(req.getParameter("id"));
		SysGiftSpreadVo sysGiftSpreadVo = new SysGiftSpreadVo();
		sysGiftSpreadVo.setId(id);
		SysGiftSpread sysGiftSpread = sysGiftSpreadService.getsysGiftSpreadVoInfoById(sysGiftSpreadVo);
		if (sysGiftSpread.getBannerImg() == null || "0".endsWith(sysGiftSpread.getBannerImg())) {
			Benner benner = new Benner();
			benner.setSend_url(sysGiftSpread.getSpreadUrl());
			benner.setTitle(sysGiftSpread.getTheme());
			benner.setImgUrl(sysGiftSpread.getBigImg());
			benner.setType(1);
			benner.setPosition(1);
			benner.setCtime(new Date());
			bannerService.addBanner(benner);
			sysGiftSpread.setBannerImg(benner.getId() + "");
			sysGiftSpreadService.updateSysGiftSpreadInfo(sysGiftSpread);
		} else {
			long bannerId = Long.parseLong(sysGiftSpread.getBannerImg());
			bannerService.deleteBanner(bannerId);
			sysGiftSpread.setBannerImg("0");
			sysGiftSpreadService.updateSysGiftSpreadInfo(sysGiftSpread);
		}
		return sysGiftSpread;
	}
	@RequestMapping(value = "sysGiftSpread/uploadSysGiftSpreadPic.do")
	public String uploadSysGiftSpreadPic(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("id");
		String picType = req.getParameter("picType");
		// 转型为MultipartHttpRequest：
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		// 获得文件：
		MultipartFile img = multipartRequest.getFile("img");
		logger.info(img.getOriginalFilename());
		String originalFilename = img.getOriginalFilename();
		// 上传图片
		if (img != null && originalFilename != null && originalFilename.length() > 0) {
			// 存储图片的物理路径
			// String pic_path = "/uploadPic/";
			String pic_path = req.getSession().getServletContext().getRealPath("/") + "uploadfile" + File.separator
					+ new SimpleDateFormat("yyyyMMdd").format(new Date()) + File.separator;
			// 新的图片名称
			// String newFileName = UUID.randomUUID() +
			// originalFilename.substring(originalFilename.lastIndexOf("."));
			String newFileName = new Date().getTime() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 新图片
			File newFile = new File(pic_path + newFileName);
			logger.info(newFile.getName());
			logger.info(newFile.getPath());
			if (!newFile.exists()) {
				newFile.mkdirs();
			}
			// 将内存中的数据写入磁盘
			img.transferTo(newFile);
			AssumeRoleResponse AssumeRole = StsService.getAssumeRoleInfo();
			String bucketName = Config.getString("giftBucket").trim();
			String filepath = Config.getString("spreadFilepath").trim();
			try {
				OSSObjectSample.putObject(bucketName, filepath, AssumeRole.getCredentials().getAccessKeyId(),
						AssumeRole.getCredentials().getAccessKeySecret(),
						AssumeRole.getCredentials().getSecurityToken(), "http://oss-cn-hangzhou.aliyuncs.com",
						newFile.getPath());
				logger.info("图片上传完成");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 保存数据
			SysGiftSpread sysGiftSpread = new SysGiftSpread();
			sysGiftSpread.setId(Long.parseLong(id));
			if ("coverImg".equals(picType)) {
				sysGiftSpread.setCoverImg(filepath + newFile.getName());
			} else if ("bigImg".equals(picType)) {
				sysGiftSpread.setBigImg(filepath + newFile.getName());
			}
			sysGiftSpreadService.updateSysGiftSpreadInfo(sysGiftSpread);
			logger.info("图片上传oss完成，开始删除本地文件……");
			boolean isDelete = false;
			if (newFile.isFile() && newFile.exists()) {
				isDelete = newFile.delete();
			}
			newFile.delete();
			logger.info("删除本地文件完成" + isDelete);
		}
		req.setAttribute("id", id);
		return "jsp/sysGiftSpread/uploadSysGiftSpreadPicture";
	}
}
