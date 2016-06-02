package com.navigate.treat.h5.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Application {

	@Value("#{configProperties['app.service.url']}")
	private String appServiceUrl;

	@Value("#{configProperties['app.service.version']}")
	private String appServiceVersion;
	// 签名密钥
	@Value("#{configProperties['app.service.secret']}")
	private String appServiceSecret;

	@Value("#{configProperties['h5.mav']}")
	private String H5mav;

	@Value("#{configProperties['h5.mimei']}")
	private String H5Mimei;

	public String getAppServiceUrl() {
		return appServiceUrl;
	}

	public void setAppServiceUrl(String appServiceUrl) {
		this.appServiceUrl = appServiceUrl;
	}

	public String getAppServiceVersion() {
		return appServiceVersion;
	}

	public void setAppServiceVersion(String appServiceVersion) {
		this.appServiceVersion = appServiceVersion;
	}

	public String getH5mav() {
		return H5mav;
	}

	public void setH5mav(String h5mav) {
		H5mav = h5mav;
	}

	public String getH5Mimei() {
		return H5Mimei;
	}

	public void setH5Mimei(String h5Mimei) {
		H5Mimei = h5Mimei;
	}

	public String getAppServiceSecret() {
		return appServiceSecret;
	}

	public void setAppServiceSecret(String appServiceSecret) {
		this.appServiceSecret = appServiceSecret;
	}

}
