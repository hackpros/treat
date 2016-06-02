package com.navigate.treat.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class PackageScan {

	public static List<File> getClassName(String packageName) {
		List<File> classNames = new ArrayList<File>();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			String resourceName = packageName.replaceAll("\\.", "/");
			URL url = loader.getResource(resourceName);
			File urlFile = new File(url.toURI());
			File[] files = urlFile.listFiles();
			for (File f : files)
				getClassName(f, classNames);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return classNames;
	}

	private static void getClassName(File packageFile, List<File> list) {
		if (packageFile.isFile()) {
			list.add(packageFile);
		} else {
			File[] files = packageFile.listFiles();
			for (File f : files) {
				getClassName(f, list);
			}
		}
	}
}
