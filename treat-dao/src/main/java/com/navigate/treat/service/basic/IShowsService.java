package com.navigate.treat.service.basic;

import java.util.List;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.basic.Shows;
import com.navigate.treat.beans.basic.ShowsQueryHelper;
import com.navigate.treat.io.show.request.ShowsReq;
import com.navigate.treat.io.show.response.ShowsRes;
/**
 * 活动签到表
 * @author fwg create by  2016年4月12日 上午9:46:55
 *
 */
public interface IShowsService extends IBaseService<Shows, ShowsQueryHelper> {

	List<ShowsRes> findShows4Page(ShowsReq showsReq);

	List<ShowsRes> findShowList4UserId(ShowsReq showsReq);
}
