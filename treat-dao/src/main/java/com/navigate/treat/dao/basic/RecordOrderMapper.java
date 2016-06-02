/*
 * RecordOrderMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-06 Created
 */
package com.navigate.treat.dao.basic;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.navigate.treat.base.mapper.single.BaseMapper;
import com.navigate.treat.beans.basic.RecordOrder;
import com.navigate.treat.beans.basic.RecordOrderQueryHelper;
import com.navigate.treat.io.pay.response.RecordOrderRes;

public interface RecordOrderMapper extends BaseMapper<RecordOrder, RecordOrderQueryHelper> {
	
	@Select("select id,userId,type,amount from record_order where orderId = #{0} and payStatus = 0")
	List<RecordOrderRes> getOrderNum(String out_trade_no);
	
	@Update("update record_order set payStatus=#{status} where ordernum in (select ordernum  from activitys_reg where actid=#{id}) ")
	int updateStatusByFollower(@Param(value = "id") Long id, @Param(value = "status") int status);
	
	@Update("update record_order set payStatus=#{status} where orderNum=#{orderNum} ")
	int updateStatus(@Param(value = "orderNum") String orderNum, @Param(value = "status") int status);
	
}
