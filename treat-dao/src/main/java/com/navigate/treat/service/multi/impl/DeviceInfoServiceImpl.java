/*
 * DeviceInfoMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.multi.impl;

import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.multi.DeviceInfo;
import com.navigate.treat.beans.multi.DeviceInfoQueryHelper;
import com.navigate.treat.dao.multi.DeviceInfoMapper;
import com.navigate.treat.service.multi.IDeviceInfoService;

@Service
public class DeviceInfoServiceImpl extends BaseServiceImp<DeviceInfo, DeviceInfoQueryHelper>
		implements IDeviceInfoService {
	DeviceInfoMapper deviceInfoMapper;

	//@Autowired
	public void setDeviceInfoMapper(DeviceInfoMapper deviceInfoMapper) {
		this.deviceInfoMapper = deviceInfoMapper;
		this.setBaseMapper(deviceInfoMapper);
	}
}
