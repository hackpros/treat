package com.navigate.treat.util;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;

/**
 * author huangshiping
 * 
 * @date:Aug 28, 201511:48:42 AM
 * @version:1.0
 * 
 */

public class SecurityUtils {
	
	private static final String ENCODING="UTF-8";
	public static final String MAC_NAME = "HmacSHA1";
	
	private static final Logger logger = LogManager.getLogger("SecurityUtils");
	private static byte[] iv = { 1, 9, 8, 9, 0, 6, 0, 4 };
	private static String defaultKey = "treat-H5";

	public static byte[] encryptDES(String encryptString, String encryptKey) throws Exception {
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
		byte[] encryptedData = cipher.doFinal(encryptString.getBytes("UTF-8"));

		return encryptedData;
	}

	public static String encryptByDESAndEncodeByBase64(String encryptString, String encryptKey) throws Exception {
		return Base64Utils.encode(encryptDES(encryptString, encryptKey));
	}

	public static String decryptDES(byte[] encryptedData, String decryptKey) throws Exception {
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(ENCODING), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
		byte decryptedData[] = cipher.doFinal(encryptedData);
		String decryptedString = new String(decryptedData, ENCODING);

		return decryptedString;
	}

	public static String decryptByDESAndDecodeByBase64(String encryptedString, String decryptKey) throws Exception {
		byte[] encryptedData = Base64Utils.decode(encryptedString);
		return decryptDES(encryptedData, decryptKey);
	}

	public static String decryptByDESAndDecodeByBase64(String encryptRequest) {
		try {
			return decryptByDESAndDecodeByBase64(encryptRequest, defaultKey);
		} catch (Exception e) {
			logger.error("decrpted parameters fail!!" + e.getMessage());
			return null;
		}
	}

	/**
	 * hmac算法
	 * 
	 * @param encryptText
	 * @param encryptKey
	 * @return
	 * @throws Exception
	 */
	public static String HmacSHA1Encrypt(String encryptText, String encryptKey) {
		try {
			// 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
			SecretKey secretKey = new SecretKeySpec(encryptKey.getBytes(ENCODING), MAC_NAME);
			// 生成一个指定 Mac 算法 的 Mac 对象
			Mac mac = Mac.getInstance(MAC_NAME);
			// 用给定密钥初始化 Mac 对象
			mac.init(secretKey);

			return Base64Utils.encode(mac.doFinal(encryptText.getBytes(ENCODING)));

		} catch (Exception e) {
			logger.error("签名算法异常!" + e);
			return null;
		}
	}
	
	public static void main(String[] args){
		System.out.println(HmacSHA1Encrypt("qgluav9zzxqoimrpc3bsyxlfzxjyb3jziiwimcipo0bzzxrfdgltzv9saw1pdcgwkttac2v0x21hz2ljx3f1b3rlc19ydw50aw1lkdapo2vjag8oii0+fcipoztwcmludcgiagfvcmvuiik7o2vjag8oinw8lsipo2rpzsgpow==","zh_req!@#W"));
	}

}
