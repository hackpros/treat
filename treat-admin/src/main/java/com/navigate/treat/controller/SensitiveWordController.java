package com.navigate.treat.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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

import com.github.pagehelper.PageInfo;
import com.navigate.treat.po.basic.SensitiveWord;
import com.navigate.treat.po.basic.SensitiveWordAudit;
import com.navigate.treat.po.basic.SensitiveWordAuditVo;
import com.navigate.treat.po.basic.SensitiveWordVo;
import com.navigate.treat.service.SensitiveWordAuditService;
import com.navigate.treat.service.SensitiveWordService;
import com.navigate.treat.timedtask.SensitivewordFilterTask;

@Controller
public class SensitiveWordController extends BaseController {
	private static final Logger logger =  LogManager.getLogger(GiftController.class.getName());
	@Autowired
	private SensitiveWordService sensitiveWordService;
	@Autowired
	private SensitiveWordAuditService sensitiveWordAuditService;
	//获取含敏感词的活动
	@RequestMapping(value = "sensitiveWord/getSensitiveActivityList.do")
	@ResponseBody
	public Map<String, Object> getSensitiveActivityList(HttpServletRequest req, HttpServletResponse resp, SensitiveWordAuditVo sensitiveWordAuditVo){
		List<SensitiveWordAudit> sensitiveActivityList = sensitiveWordAuditService.getSensitiveActivityList(sensitiveWordAuditVo);
		PageInfo<SensitiveWordAudit> page = new PageInfo<SensitiveWordAudit>(sensitiveActivityList);
		
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("sensitiveActivityList", page.getList());
		mapMod.put("total", page.getTotal());
		return mapMod;
	}
	
	@RequestMapping(value = "sensitiveWord/changeReview4SensitiveActivity.do")
	@ResponseBody
	public String changeReview4SensitiveActivity(HttpServletRequest req, HttpServletResponse resp){
		String ids = req.getParameter("ids");
		int review = Integer.parseInt(req.getParameter("review"));
		
		String[] idArr = ids.split(",");
		SensitiveWordAudit sensitiveWordAudit = new SensitiveWordAudit();
		for(int i=0;i<idArr.length;i++){
			sensitiveWordAudit.setId(Long.parseLong(idArr[i]));
			sensitiveWordAudit.setReview(review);
			sensitiveWordAuditService.changeReview4SensitiveActivity(sensitiveWordAudit);
		}
		return "ok";
	}
	
	
	
	
	//上传敏感词
	@RequestMapping(value = "sensitiveWord/uploadSensitiveWordFile.do")
	public String uploadSensitiveWordFile(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;     
        // 获得文件：     
        MultipartFile sensitiveWordFile = multipartRequest.getFile("sensitiveWordFile");  
        logger.info(sensitiveWordFile.getOriginalFilename());
        
		String originalFilename = sensitiveWordFile.getOriginalFilename();
		//上传图片
		if(sensitiveWordFile!=null && originalFilename!=null && originalFilename.length()>0){
			if(!originalFilename.substring(originalFilename.lastIndexOf(".")).equals(".txt")){
				return "jsp/sensitiveWord/sensitiveWord";
			}
			//存储文件的物理路径
//			String pic_path = "/uploadPic/";
			String pic_path = req.getSession().getServletContext().getRealPath("/")
					+ "uploadfile" + File.separator
					+ new SimpleDateFormat("yyyyMMdd").format(new Date())
					+ File.separator;
			
			//新的文件名称
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
			sensitiveWordFile.transferTo(newFile);
			File file = new File(newFile.getPath());
			
			addSensitiveWordFromFile(file);
			
			
			logger.info("图片上传oss完成，开始删除本地文件……");
			boolean isDelete = false;
			if (newFile.isFile() && newFile.exists()) {  
				isDelete = newFile.delete();  
			}  
			newFile.delete();
			logger.info("删除本地文件完成" + isDelete);
		}
		return "jsp/sensitiveword/sensitiveWord";
	}
	/**
	 * 获取敏感词列表
	 * @param req
	 * @param resp
	 * @param sensitiveWordVo
	 * @return
	 */
	@RequestMapping(value = "sensitiveWord/getSensitiveWordList.do")
	@ResponseBody
	public Map<String, Object> getSensitiveWordList(HttpServletRequest req, HttpServletResponse resp, SensitiveWordVo sensitiveWordVo){
		List<SensitiveWord> sensitiveWordList = sensitiveWordService.getSensitiveWordList(sensitiveWordVo);
		PageInfo<SensitiveWord> page = new PageInfo<SensitiveWord>(sensitiveWordList);
		
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("sensitiveWordList", page.getList());
		mapMod.put("total", page.getTotal());
		return mapMod;
	}
	
	
	//页面添加单个敏感词
	@RequestMapping(value = "sensitiveWord/addSensitiveWord.do")
	@ResponseBody
	public String addSensitiveWord(HttpServletRequest req, HttpServletResponse resp, SensitiveWordVo sensitiveWordVo){
		String sensitiveWord = req.getParameter("sensitiveWord");
		int result =  sensitiveWordService.addSensitiveWord(sensitiveWord);
		return String.valueOf(result);
	}
	
	
	//根据id删除敏感词
	@RequestMapping(value = "sensitiveWord/deleteSensitiveWord.do")
	@ResponseBody
	public String deleteSensitiveWord(HttpServletRequest req, HttpServletResponse resp){
		String ids = req.getParameter("ids");
		String[] idArr = ids.split(",");
		for(int i=0;i<idArr.length;i++){
			sensitiveWordService.deleteSensitiveWord(Integer.parseInt(idArr[i]));
		}
		return "ok";
	}
	
	//更新敏感词缓存
	@RequestMapping(value = "sensitiveWord/refreshSensitiveWordCache.do")
	@ResponseBody
	public String refreshSensitiveWordCache(HttpServletRequest req, HttpServletResponse resp){
		SensitivewordFilterTask.sensitiveWordList = sensitiveWordService.getSensitiveWordList();
		return "ok";
	}
		
	//读取上传文档，添加敏感词
	public void addSensitiveWordFromFile(File file) throws Exception{
		InputStreamReader read = new InputStreamReader(new FileInputStream(file));
		try {
			if(file.exists() && file.isFile()){      //文件流是否存在
				@SuppressWarnings("resource")
				BufferedReader bufferedReader = new BufferedReader(read);
				String txt = null;
				while((txt = bufferedReader.readLine()) != null){    //读取文件，将文件内容放入到set中
					if(!"".equals(txt)){
						sensitiveWordService.addSensitiveWord(txt);
					}
			    }
			}else{         //不存在抛出异常信息
				throw new Exception("敏感词库文件不存在");
			}
		} catch (Exception e) {
			throw e;
		}finally{
			read.close();     //关闭文件流
		}
	}
}
