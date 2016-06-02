package com.navigate.treat.api;

import com.navigate.treat.base.Pages;

public interface IRecordFundServiceFront {
	/**
	 * 资金记录列表业务
	 * @param pages
	 * @return
	 */
	Object select(Pages<?> pages);
}
