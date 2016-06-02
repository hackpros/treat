package com.navigate.treat.util;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

public class IOSBuilderUtil {
	public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
		List<File> list = PackageScan.getClassName("com.navigate.treat");
		for (File bean : list) {
			if (bean.getName().endsWith("Res.class") || bean.getName().endsWith("Req.class")
					|| bean.getName().endsWith("DTO.class") ||
					bean.getName().equalsIgnoreCase("BaseRequest.class") ||
					bean.getName().equalsIgnoreCase("Pages.class") 
					) {
				
				
				

				// 去掉后缀.class
				String classFullName = bean.getParent();
				int packageIndex = classFullName.indexOf("com");
				if (packageIndex == -1) {
					continue;
				}
				classFullName = classFullName.substring(packageIndex);
				classFullName = classFullName.replace("\\", ".");

				// 去掉后缀.class
				String className = bean.getName().replace(".class", "");
				// Class<?> myclass = myClassLoader.loadClass(className);

				StringBuilder head = new StringBuilder();
				StringBuilder body = new StringBuilder();
				StringBuilder propertys = new StringBuilder();

				head.append("#import <Foundation/Foundation.h>");

				// 打印类名
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~打印类名:~~~~~~~~~~~~~~~~~~~~~~~~~" + className);

				// 得到类中包含的属性
				// Field[]
				// fields=oFandM.getClassDeclaredFields(className);
				Class<?> clazz = Class.forName(classFullName + "." + className);
				// 根据class对象获得属性
				Field[] fields = clazz.getDeclaredFields();
				body.append("\r\n{");
				{
					for (Field f1 : fields) {

						if ((f1.getModifiers() & java.lang.reflect.Modifier.STATIC) == java.lang.reflect.Modifier.STATIC) {
							continue;
						}
						Class<?> fieldType = f1.getType();
						String isoType = "";
						if (fieldType.equals(int.class) || fieldType.equals(Integer.class)
								|| fieldType.equals(short.class) || fieldType.equals(Short.class)
								|| fieldType.equals(long.class) || fieldType.equals(Long.class)
								|| fieldType.equals(float.class) || fieldType.equals(Float.class)
								|| fieldType.equals(double.class) || fieldType.equals(Double.class)) {
							isoType = "NSNumber*";
						} else if (fieldType.equals(String.class)) {
							isoType = "NSString*";
						} else if (fieldType.equals(Date.class)) {
							isoType = "NSDate*";
						} else if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {
							isoType = "Boolean";
						} else if (fieldType.equals(BigDecimal.class)) {
							isoType = "NSNumber*";
						} else {
							isoType = fieldType.getSimpleName() + "*";
							head.append("\r\n#import ").append("\"").append(fieldType.getSimpleName()).append(".h\";");
						}

						String prop = isoType + " " + f1.getName() + ";";
						body.append("\r\n\t").append(prop);

						propertys.append("\r\n@property (nonatomic)" + prop);
					}
					body.append("\r\n}");
					propertys.append("\r\n@end");

					String path = IOSBuilderUtil.class.getClassLoader().getResource("") + clazz.getName();

					path = path.replace(".", "//").replace("bin", "ios") + ".h";
					path = path.substring(6);
					//String fileName = path;
					//File file = new File(fileName);

					//StringBuilder fileContent = head.append(body.toString()).append(propertys.toString());
					/*try {
						if (!file.exists()) {
							// file.mkdir();
							// CreateFolders(file.getPath());
						}
						org.apache.commons.io.FileUtils.writeStringToFile(file, fileContent.toString(), "UTF-8", false);

					} catch (IOException e) {
						e.printStackTrace();
					}*/

				}
			}
		}
	}
}
