package com.navigate.treat.api;

import com.navigate.treat.io.show.request.ShowsReq;

public interface IShowsServiceFront {

	Object publishShows(ShowsReq showsReq);

	Object getHomeShowsList(ShowsReq showsReq);

	Object delShows(ShowsReq showsReq);

	Object showPraise(ShowsReq showsReq);

	Object getShowsPaiseRank(ShowsReq showsReq);

	Object cheakedActStatus(ShowsReq showsReq);

	Object invitation(ShowsReq showsReq);

	Object getShowList4UserId(ShowsReq showsReq);

}
