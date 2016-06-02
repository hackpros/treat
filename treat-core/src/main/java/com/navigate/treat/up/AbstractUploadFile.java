/*package com.navigate.treat.up;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;


import com.navigate.treat.util.Constants;


*//**
 * author huangshiping
 * 
 * @date:Aug 29, 201510:16:12 AM
 * @version:1.0
 * 
 *//*

public class AbstractUploadFile {

	private static final Logger logger = LogManager.getLogger("AbstractUploadFile");

	*//**
	 * 截图
	 *//*
	public static final int SUB_IMG = 1;

	*//**
	 * 缩略图
	 *//*
	public static final int SMALL_IMG = 2;

	*//**
	 * 先切成正方形后再形成缩略小图
	 *//*
	public static final int CUT_SMALL_IMG = 3;

	*//**
	 * 多套缩略图模式
	 *//*
	public static final int MULTI_THUMBNAIL = 3;

	*//**
	 * 消息图片
	 *//*
	public static final int MULTI_PUSHMSG = 4;

	*//**
	 * 正式上传文件
	 * 
	 * @param input
	 *            文件流
	 * @param fileName
	 *            文件名
	 * @param model_path
	 *            模块路径
	 * @return 文件object
	 *//*
	protected UploadObj uploadFile(InputStream input, String fileName, String model_path) {
		UploadPathObj pathObj = getUploadFilePath(fileName, model_path);
		String path = pathObj.getRealPath();
		File newFile = new File(path);

		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = input;
				out = new BufferedOutputStream(new FileOutputStream(newFile));
				byte[] buffer = new byte[1024];
				logger.debug("正在上传文件 :" + fileName);
				int size = 0;
				while ((size = in.read(buffer)) != -1) {
					out.write(buffer, 0, size);
				}
			} catch (Exception e) {
				logger.debug("上传文件出错" + e.getMessage());
				e.printStackTrace();
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			logger.debug("上传文件出错" + e.getMessage());
			e.printStackTrace();
		}
		UploadObj obj = new UploadObj(fileName);
		obj.setPath(pathObj.getRealPath());
		obj.setRelativePath(pathObj.getRelativePath());
		obj.setSub_img_path(pathObj.getRelativeUrl());
		return obj;
	}

	*//**
	 * 判断是不是图片
	 * 
	 * @param fileName
	 *            文件后缀名
	 * @return
	 *//*
	protected boolean isImg(String ext) {
		boolean flag = false;
		if (ext != null && !"".equals(ext)) {
			ext = ext.toLowerCase();
			String type = ConfigUtil.getConfig(Constants.UPLOAD_SUFFIX);
			int index = type.indexOf(ext);
			if (index > 0) {
				flag = true;
			}
		}
		return flag;
	}

	*//**
	 * 创建小图(截图)
	 * 
	 * @param file
	 *            原图文件
	 * @param x
	 *            从x坐标哪个地方开始
	 * @param y
	 *            从y坐标哪个地方开始
	 * @param wid
	 *            长度
	 * @param heig
	 *            高度
	 * @return 切图路径对象
	 * @throws IOException
	 *//*
	protected UploadPathObj createCutImg(File file, int x, int y, int wid, int heig) throws IOException {
		String fileName = file.getName();
		String fileExt = "jpg";
		String[] temp = fileName.split("\\.");
		if (temp.length > 0) {
			fileExt = temp[temp.length - 1];
		}
		Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(fileExt);
		ImageReader reader = readers.next();
		InputStream source = new FileInputStream(file);
		ImageInputStream iis = ImageIO.createImageInputStream(source);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		Rectangle rect = new Rectangle(x, y, wid, heig);
		param.setSourceRegion(rect);
		BufferedImage bi = reader.read(0, param);
		File childFile = new File(file.getParentFile().getPath() + "/" + "cut");
		if (!childFile.exists()) {
			childFile.mkdir();
		}
		FileOutputStream out = new FileOutputStream(childFile.getPath() + "/" + "cut.jpg");
		ImageIO.write(bi, "jpg", out);
		out.close();
		String cutPath = childFile.getPath() + "/" + "cut.jpg";
		// String relativeCutPath =
		// cutPath.substring(Config.getString("upload.path").length()+
		// "/upload".length());
		UploadPathObj obj = new UploadPathObj();
		obj.setRealPath(cutPath);
		// /obj.setRelativePath(relativeCutPath);
		return obj;
	}

	protected UploadPathObj createCutImg(File file, int x, int y, int wid, int heig, String relpath) throws IOException {
		String fileName = file.getName();
		String fileExt = "jpg";
		String[] temp = fileName.split("\\.");
		if (temp.length > 0) {
			fileExt = temp[temp.length - 1];
		}
		Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(fileExt);
		ImageReader reader = readers.next();
		InputStream source = new FileInputStream(file);
		ImageInputStream iis = ImageIO.createImageInputStream(source);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		Rectangle rect = new Rectangle(x, y, wid, heig);
		param.setSourceRegion(rect);
		BufferedImage bi = reader.read(0, param);
		File childFile = new File(relpath + "/" + "cut");
		if (!childFile.exists()) {
			childFile.mkdir();
		}
		FileOutputStream out = new FileOutputStream(childFile.getPath() + "/" + "cut.jpg");
		ImageIO.write(bi, "jpg", out);
		out.close();
		String cutPath = childFile.getPath() + "/" + "cut.jpg";
		UploadPathObj obj = new UploadPathObj();
		obj.setRealPath(cutPath);
		return obj;
	}

	*//**
	 * 创建小图
	 * 
	 * @param file
	 *            原图文件
	 * @return 小图路径对象
	 * @throws IOException
	 *//*
	protected UploadPathObj createSmallImg(File file) throws IOException {
		Image img = ImageIO.read(file);
		int wid = img.getWidth(null);
		int heig = img.getHeight(null);
		String smallPath = createSmallImg(file.getParentFile().getPath(), img, wid / 2, heig / 2);
		String relativeSmallPath = smallPath.substring(ConfigUtil.getConfig("upload.path").length() + "/upload".length());
		UploadPathObj obj = new UploadPathObj();
		obj.setRealPath(smallPath);
		obj.setRelativePath(relativeSmallPath);
		return obj;
	}

	*//**
	 * 创建小图
	 * 
	 * @param file
	 * @param wid
	 * @param heig
	 * @return 小图路径对象
	 * @throws IOException
	 *//*
	protected UploadPathObj createSmallImg(File file, int wid, int heig) throws IOException {
		Image img = ImageIO.read(file);
		String smallPath = createSmallImg(file.getParentFile().getPath(), img, wid, heig);
		String relativeSmallPath = smallPath.substring(ConfigUtil.getConfig("upload.path").length() + "/upload".length());
		UploadPathObj obj = new UploadPathObj();
		obj.setRealPath(smallPath);
		obj.setRelativePath(relativeSmallPath);
		return obj;
	}

	protected UploadPathObj createSmallImg1(File file, int wid, int heig) throws IOException {
		Image img = ImageIO.read(file);
		String smallPath = createSmallImg1(file.getParentFile().getPath(), img, wid, heig);
		String relativeSmallPath = smallPath.substring(ConfigUtil.getConfig("upload.path").length() + "/upload".length());
		UploadPathObj obj = new UploadPathObj();
		obj.setRealPath(smallPath);
		obj.setRelativePath(relativeSmallPath);
		return obj;
	}

	*//**
	 * 根据图片尺寸等比例创建小图
	 * 
	 * @param img
	 *            图片类型文件
	 * @return 小图尺寸
	 * @throws IOException
	 * @throws ImageFormatException
	 *//*
	protected UploadPathObj createSmallImg(File file, int length) throws IOException {
		Image img = ImageIO.read(file);
		UploadPathObj obj = createSmallImg(file.getParentFile().getPath(), img, length);
		return obj;
	}

	// 多套图片专用
	protected UploadPathObj createSmallImg(File file, int wid, int heig, int flag, String smallName) throws IOException {
		Image img = ImageIO.read(file);
		String smallPath = createSmallImg(file.getParentFile().getPath(), img, wid, heig, flag, smallName, null);
		String relativeSmallPath = smallPath.substring(ConfigUtil.getConfig(Constants.UPLOAD_PATH).length() + "/upload".length());
		UploadPathObj obj = new UploadPathObj();
		obj.setRealPath(smallPath);
		obj.setRelativePath(relativeSmallPath);
		return obj;
	}

	protected UploadPathObj createMsgSmallImg(File file, int wid, int heig, int flag, String smallName) throws IOException {
		Image img = ImageIO.read(file);
		String smallPath = createSmallImg(file.getParentFile().getPath(), img, wid, heig, flag, smallName, 1);
		String relativeSmallPath = smallPath.substring(ConfigUtil.getConfig("msgImg.path").length() + "/upload".length());
		UploadPathObj obj = new UploadPathObj();
		obj.setRealPath(smallPath);
		obj.setRelativePath(relativeSmallPath);
		return obj;
	}

	*//**
	 * 根据图片尺寸等比例创建小图
	 * 
	 * @param img
	 *            图片类型文件
	 * @return 小图路径对象
	 * @throws IOException
	 * @throws ImageFormatException
	 *//*
	protected UploadPathObj createSmallImg(String path, Image img, int length) throws IOException {
		int wid = img.getWidth(null);
		int heig = img.getHeight(null);
		String smallPath = "";
		if (wid >= heig) {
			smallPath = createSmallImg(path, img, length, heig * length / wid);
		} else {
			smallPath = createSmallImg(path, img, wid * length / heig, length);
		}

		UploadPathObj obj = new UploadPathObj();
		obj.setRealPath(smallPath);
		return obj;
	}

	*//**
	 * 创建小图
	 * 
	 * @param img
	 *            图片类型文件
	 * @return 小图路径对象
	 * @throws IOException
	 * @throws ImageFormatException
	 *//*
	protected UploadPathObj createSmallImg(String path, Image img) throws IOException {
		int wid = img.getWidth(null);
		int heig = img.getHeight(null);
		String smallPath = createSmallImg(path, img, wid / 2, heig / 2);
		String relativeSmallPath = smallPath.substring(ConfigUtil.getConfig("upload.path").length() + "/upload".length());
		UploadPathObj obj = new UploadPathObj();
		obj.setRealPath(smallPath);
		obj.setRelativePath(relativeSmallPath);
		return obj;
	}

	*//**
	 * 
	 * 创建小图，需要根据设置好的长和高来创建
	 * 
	 * @param path
	 * @param img
	 *            图片类型文件
	 * @param wid
	 *            宽
	 * @param heig
	 *            高
	 * @return 创建成功与否
	 * @return 小图路径实际路径
	 * @throws IOException
	 * @throws ImageFormatException
	 *//*
	protected String createSmallImg(String path, Image img, int wid, int heig) throws IOException {
		int new_wid = wid;
		int new_heig = heig;
		if (img.getHeight(null) > img.getWidth(null)) {// /处理窄图片
			new_wid = heig;
			new_heig = wid;
		}
		BufferedImage bi = new BufferedImage(new_wid, new_heig, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bi.createGraphics();
		g2d.drawImage(img, 0, 0, new_wid, new_heig, Color.white, null);
		g2d.dispose();
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}

		String dstName = file.getPath() + "/" + "small.jpg";
		writeImg(dstName, bi);
		return dstName;
	}

	protected String createSmallImg1(String path, Image img, int wid, int heig) throws IOException {
		int new_wid = wid;
		int new_heig = heig;
		if (img.getHeight(null) > img.getWidth(null)) {// /处理窄图片
			new_wid = heig;
			new_heig = wid;
		}
		BufferedImage bi = new BufferedImage(new_wid, new_heig, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bi.createGraphics();
		g2d.drawImage(img, 0, 0, new_wid, new_heig, Color.white, null);
		g2d.dispose();
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}

		String dstName = file.getPath() + "/" + "big.jpg";
		writeImg(dstName, bi);

		file = new File(path + "/cut.jpg");
		if (file.isFile() && file.exists()) {
			file.delete();
		}
		return file.getPath() + "/" + "small.jpg";
	}

	*//**
	 * 得到后缀
	 * 
	 * @param fileName
	 *            文件名
	 * @return 后缀
	 *//*
	protected String getFileExt(String fileName) {
		int index = fileName.lastIndexOf(".");
		String ext = null;
		if (index == -1) {
			return null;
		} else {
			if (index + 1 == fileName.length()) {
				ext = null;
			} else {
				ext = fileName.substring(index + 1, fileName.length());
			}
		}
		return ext;
	}

	*//**
	 * 得到真实的文件路径
	 * 
	 * @param fileName
	 *            文件名
	 * @param model_path
	 *            模块路径
	 * @return 文件路径+新的文件名（随机生成的10位数作为名字，后缀不变）
	 *//*
	protected UploadPathObj getUploadFilePath(String fileName, String model_path) {
		UploadPathObj pathObj = getRealFilePath(model_path);
		String path = pathObj.getRealPath();
		// String relativePath = pathObj.getRelativePath();
		String newFileName = null;
		String ext = getFileExt(fileName);
		String num = getRandomNumber();
		if (null != ext) {
			newFileName = num + "." + ext;
		} else {
			newFileName = num + "";
		}

		pathObj.setRealPath(path + "/" + newFileName);
		pathObj.setRelativePath(num);
		pathObj.setRelativeUrl(pathObj.getRelativeUrl() + "/" + newFileName);
		return pathObj;
	}

	*//**
	 * 得到10位随机数
	 * 
	 * @return 10位随机数
	 *//*
	private String getRandomNumber() {
		Random random = new Random();
		// random.setSeed(9999999999l);
		Integer no = random.nextInt();
		if (no < 0) {
			no = no * -1;
		}
		String num = String.valueOf(no);
		if (num.length() < 10) {
			int i = num.length();
			for (int m = 0; m < 10 - i; m++) {
				num = "0" + num;
			}
		} else if (num.length() > 10) {
			num = num.substring(num.length() - 10, num.length());
		}
		return num;
	}

	*//**
	 * 产生不包括新文件在内的 路径
	 * 
	 * @param fileName
	 *            新文件名（10位随机数）
	 * @param realFilePath
	 *            路径
	 * @return 新的文件所在的路径
	 *//*
	protected String getMenuFilePath(String fileName, String realFilePath) {
		String path = realFilePath;
		String folder = "";
		if (fileName.length() == 10) {
			for (int index = 0; index < fileName.length(); index = index + 2) {
				folder = fileName.substring(index, index + 2);
				path = path + "/" + folder;
				File file = new File(path);
				if (!file.exists()) {
					file.mkdir();
				}
			}
		}
		return path;
	}

	*//**
	 * 得到真实的路径
	 * 
	 * @return 真实的路径
	 *//*
	protected String getRealFilePath() {
		return this.getRealFilePath(null).getRealPath();
	}

	*//**
	 * 得到真实的路径
	 * 
	 * @param model
	 *            模块路径
	 * @return 路径
	 *//*
	protected UploadPathObj getRealFilePath(String model) {
		String rootPath = null;
		String relativePath = null;

		if (null == model || "".equals(model)) {
			relativePath = "";
			rootPath = ConfigUtil.getConfig(Constants.UPLOAD_PATH) + "/" + "upload";
		} else {
			relativePath = "/" + model;
			if (model.indexOf("bg_url") != -1) {
				rootPath = ConfigUtil.getConfig("bg_url.path") + "/zh/upload/1";
			} else {
				if (model.length() > 16) {
					rootPath = ConfigUtil.getConfig("msgImg.path") + "/zh/upload/1";
				} else {
					rootPath = ConfigUtil.getConfig(Constants.UPLOAD_PATH) + "/zh/upload/1";
				}
			}
		}
		File file = new File(rootPath);
		if (!file.exists()) {
			file.mkdir();
		}
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
		file = new File(rootPath + "/" + year);
		if (!file.exists()) {
			file.mkdirs();
		}
		file = new File(rootPath + "/" + year + "/" + month);
		if (!file.exists()) {
			file.mkdirs();
		}
		file = new File(rootPath + "/" + year + "/" + month + "/" + day + "/" + hour + "/" + model);
		if (!file.exists()) {
			file.mkdirs();
		}
		UploadPathObj pathObj = new UploadPathObj();
		pathObj.setRealPath(rootPath + "/" + year + "/" + month + "/" + day + "/" + hour + "/" + model);
		pathObj.setRelativePath(relativePath + "/" + year + "/" + month + "/" + day);
		pathObj.setRelativeUrl("/" + year + "/" + month + "/" + day + "/" + hour + "/" + model);
		return pathObj;
	}

	protected String createSmallImg(String path, Image img, int wid, int heig, int flag, String smallName, Integer type) throws IOException {
		int new_wid = wid;
		int new_heig = heig;
		Boolean process_type = false;
		Boolean small_pic = false;// 宽度小于300，且高度小于200的图片
		if (wid == 300 && heig == 200) {
			process_type = true;
			// 高度小于200，且宽度小于300的图片不处理
			if ((img.getHeight(null) < new_heig && img.getWidth(null) < new_wid)) {
				small_pic = true;
			}
		}
		if (img.getHeight(null) > img.getWidth(null)) {// /处理窄图片
			new_wid = heig;
			new_heig = wid;
		}
		// 处理小图
		if (img.getHeight(null) < new_heig) {
			new_heig = img.getHeight(null);
		}
		if (img.getWidth(null) < new_wid) {
			new_wid = img.getWidth(null);
		}
		
		 * 宽度超过设定小图宽度， 高度按照宽度的等比例调整，宽度固定
		 
		if (img.getWidth(null) > new_wid && wid == 600) {
			float temp_heig = new_wid * ((float) img.getHeight(null) / img.getWidth(null));
			new_heig = (int) temp_heig;
		}

		if (process_type) {
			new_wid = 300;
			new_heig = 200;
		}

		BufferedImage bi = new BufferedImage(new_wid, new_heig, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bi.createGraphics();
		if (process_type) {
			// 设置背景色
			int co = Integer.parseInt("E6EAED", 16);
			Color color = new Color(co);
			g2d.setColor(color);
			g2d.fillRect(0, 0, 300, 200);
			if (small_pic) {
				g2d.drawImage(img.getScaledInstance(img.getWidth(null), img.getHeight(null), Image.SCALE_SMOOTH),
						(300 - img.getWidth(null)) / 2, (200 - img.getHeight(null)) / 2, img.getWidth(null), img.getHeight(null), null,
						null);
			} else {
				// 处理宽度大于高度的图片
				if (img.getWidth(null) >= img.getHeight(null)) {
					if (img.getWidth(null) < 300) {// 宽度小于300
						float raid = img.getHeight(null) / 200f;
						int temp_width = Math.round(img.getWidth(null) / raid);
						g2d.drawImage(img.getScaledInstance(temp_width, 200, Image.SCALE_SMOOTH), (300 - temp_width) / 2, 0, temp_width,
								200, null, null);
					} else {// 宽度大于300
						if (img.getHeight(null) * 1.0 / img.getWidth(null) > 2 / 3f) {
							float raid = img.getHeight(null) / 200f;
							int temp_width = Math.round(img.getWidth(null) / raid);
							g2d.drawImage(img.getScaledInstance(temp_width, 200, Image.SCALE_SMOOTH), (300 - temp_width) / 2, 0,
									temp_width, 200, null, null);
						} else {
							float raid = img.getWidth(null) / 300f;
							int temp_height = Math.round(img.getHeight(null) / raid);
							g2d.drawImage(img.getScaledInstance(300, temp_height, Image.SCALE_SMOOTH), 0, (200 - temp_height) / 2, 300,
									temp_height, null, null);
						}
					}
				} else {// 处理宽度小于高度的图片
					float raid = img.getHeight(null) / 200f;
					int temp_width = Math.round(img.getWidth(null) / raid);
					g2d.drawImage(img.getScaledInstance(temp_width, 200, Image.SCALE_SMOOTH), (300 - temp_width) / 2, 0, temp_width, 200,
							null, null);
				}
			}
		} else {
			g2d.drawImage(img.getScaledInstance(new_wid, new_heig, Image.SCALE_SMOOTH), 0, 0, null);
		}

		g2d.dispose();
		File file = new File(path + "/" + smallName);
		if (!file.exists()) {
			file.mkdir();
		}
		if (type != null) {
			String dstName = file.getPath() + "/small.jpg";
			writeImg(dstName, bi);
			return dstName;
		} else {
			String dstName = file.getPath() + "/" + wid + "_" + heig + ".jpg";
			writeImg(dstName, bi);
			return dstName;
		}

	}

	private void writeImg(String dstName, RenderedImage dstImage) throws IOException {
		String formatName = dstName.substring(dstName.lastIndexOf(".") + 1);
		ImageIO.write(dstImage, formatName, new File(dstName));
	}
}
*/