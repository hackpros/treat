package com.navigate.treat.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class ExportUtils {
	/**
	 * 下载导出的文件
	 * 
	 * @discription
	 * @param response
	 * @param path
	 * @throws Exception
	 */
	public static void download(HttpServletResponse response, String path)
			throws Exception {
		ServletOutputStream output = null;
		InputStream fis = null;
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 以流的形式下载文件。
			fis = new FileInputStream(path);
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			response.reset();
			response.setContentType("application/octet-stream");
			String header = "attachment;filename="
					+ java.net.URLEncoder.encode(filename, "UTF-8");
			response.setHeader("Content-Disposition", header);
			output = response.getOutputStream();
			output.write(buffer);
		} catch (IOException e) {
			throw new Exception("下载文件时" + e);
		} finally {
			if (output != null) {
				output.flush();
				output.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
	}

}
