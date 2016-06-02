/*package com.navigate.treat.up;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;


import com.navigate.treat.up.AbstractUploadFile;

*//**
 * author huangshiping
 * 
 * @date:Aug 29, 201510:21:16 AM
 * @version:1.0
 * 
 *//*

public class FileUploadService extends AbstractUploadFile {

	private static FileUploadService instance = null;

	public static synchronized FileUploadService getInstance() {
		if (instance == null) {
			
			instance = new FileUploadService();
		}
		return instance;
	}

	private static final Logger logger = LogManager.getLogger("FileUploadService");

	*//**
	 * 正方形图片
	 * 
	 * @param relativePath
	 * @param realpath
	 *//*
	private void createSquare(String relativePath, String realpath) {
		try {
			if (realpath != null) {
				realpath = realpath.substring(0, realpath.lastIndexOf("/"));
			}
			File f = new File(relativePath);
			Image img = ImageIO.read(f);
			int wid = img.getWidth(null);
			int heig = img.getHeight(null);
			UploadPathObj pathObj = null;
			if (wid > heig) {
				pathObj = super.createCutImg(f, (wid - heig) / 2, 0, heig, heig, realpath);
			} else {
				pathObj = super.createCutImg(f, 0, (heig - wid) / 2, wid, wid, realpath);
			}
			resizeSquare(pathObj.getRealPath(), 340, 340, true, realpath);
			resizeSquare(pathObj.getRealPath(), 103, 103, true, realpath);
			resizeSquare(pathObj.getRealPath(), 173, 173, true, realpath);
			File file = new File(realpath + "/cut/cut.jpg");
			if (file.exists()) {
				file.delete();
			}
			
		} catch (IOException e) {
			logger.debug("catch IOException:" + e.getMessage());
			e.getStackTrace();
		}

	}

	public void resizeSquare(String filePath, int height, int width, boolean bubai, String realpath) {
		try {
			double ratio = 0; // 缩放比例
			File f = new File(filePath);
			BufferedImage bi = ImageIO.read(f);
			Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
			// 计算比例
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue() / bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			if (bubai) {
				BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);
				g.dispose();
				itemp = image;
			}
			if (width == 340) {
				width = 230;
				height = 230;
			}
			FileOutputStream out = new FileOutputStream(realpath + "/" + width + "_" + height + ".jpg");
			ImageIO.write((BufferedImage) itemp, "jpg", out);
		} catch (IOException e) {
			logger.debug("catch IOException:" + e.getMessage());
			e.getStackTrace();
		}
	}

	public UploadObj uploadImgFile_new(CommonsMultipartFile multipartFile, String model_path) throws IOException {
		String ext = getFileExt(multipartFile.getOriginalFilename());
		UploadObj obj = null;
		if (super.isImg(ext)) {
			obj = super.uploadFile(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), model_path);
			// 压缩多套图
			File f = new File(obj.getPath());
			UploadPathObj pathObj = super.createSmallImg(f, 173, 173, 1, obj.getRelativePath());
			obj.setSmall_img_path(pathObj.getRealPath());
			obj.setRelativeSmallImgPath(pathObj.getRelativePath());
			String realpath = pathObj.getRealPath();
			createSquare(obj.getPath(), realpath);

		}
		return obj;
	}
}
*/