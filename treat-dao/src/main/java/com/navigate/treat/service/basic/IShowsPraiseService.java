package com.navigate.treat.service.basic;

import java.util.List;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.basic.ShowsPraise;
import com.navigate.treat.beans.basic.ShowsPraiseQueryHelper;
import com.navigate.treat.io.show.response.ShowsPraiseRes;

public interface IShowsPraiseService extends IBaseService<ShowsPraise, ShowsPraiseQueryHelper> {

	List<ShowsPraiseRes> getPraiseRankList();
}
