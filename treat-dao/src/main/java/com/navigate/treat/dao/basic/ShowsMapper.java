/*
 * ShowsMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-19 Created
 */
package com.navigate.treat.dao.basic;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.navigate.treat.base.mapper.single.BaseMapper;
import com.navigate.treat.beans.basic.Shows;
import com.navigate.treat.beans.basic.ShowsQueryHelper;
import com.navigate.treat.io.show.request.ShowsReq;
import com.navigate.treat.io.show.response.ShowsRes;

public interface ShowsMapper extends BaseMapper<Shows, ShowsQueryHelper> {

	@SelectProvider(type = SqlProvider.class, method = "findShows4Page")
	List<ShowsRes> findShows4Page(ShowsReq showsReq);

	class SqlProvider {

		public final String BASE_COLUMN_LIST = " id showId,userId,mediaType,mediaContent,lng,lat,title,ctime ";
		private static final String TABLE_NAME = "shows";

		public String findShows4Page(final ShowsReq model) {
			return new SQL() {
				{
					SELECT(BASE_COLUMN_LIST);
					FROM(TABLE_NAME);
					if (model.getSex() != null) {
						WHERE("sex = #{sex}");
					}
					WHERE("status = 0 and lat > #{lat} -1 and lat < #{lat} + 1 and lng > #{lng} -1 and lng < #{lng} + 1 ");
					ORDER_BY("ACOS(SIN((#{lat} * 3.1415) / 180) * SIN((lat * 3.1415) / 180) + COS((#{lat} * 3.1415) / 180) "
							+ "* COS((lat * 3.1415) / 180) * COS((#{lng} * 3.1415) / 180 - (lng * 3.1415) / 180)) * 6380 ASC LIMIT #{offset},#{length}");
				}
			}.toString();
		}

		public String findShowList4UserId(final ShowsReq model) {
			return new SQL() {
				{
					SELECT(BASE_COLUMN_LIST);
					FROM(TABLE_NAME);
					WHERE("status = 0 and userId = #{userId}");
					ORDER_BY("showId desc LIMIT #{offset},#{length}");
				}
			}.toString();
		}

	}

	@SelectProvider(type = SqlProvider.class, method = "findShowList4UserId")
	List<ShowsRes> findShowList4UserId(ShowsReq showsReq);
}
