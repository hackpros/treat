
var Utils = function(){

	var appraiseType={"101":"秀气","102":"绅士","103":"豪爽","104":"憨厚","105":"幽默","106":"稳重","107":"土豪","108":"博学","109":"阳光","110":"洋气","201":"漂亮","202":"温柔","203":"灵气","204":"直率","205":"气质","206":"女神","207":"腼典","208":"善良","209":"时尚","210":"优雅","301":"屌丝","302":"装逼","303":"变态","304":"无聊","305":"炫耀","306":"神经","307":"木讷","308":"极端","309":"闷骚","310":"无礼","401":"委婉","402":"木讷","403":"无礼","404":"高冷","405":"傲慢","406":"虚荣","407":"傲娇","408":"俗气","409":"肤浅","410":"憔悴"};

	var interest= {"life":["阅读","美食","茶道","旅行","美妆","园艺","宠物","时尚","手工","烹饪","养生","收藏","星座","生活","户外","数码","",""],
		"sport":["健身","瑜伽","游泳","轮滑","极限运动","篮球","足球","羽毛球","台球","","",""],
		"ent":["KTV","酒吧","游戏","电影","电视剧","动漫","桌游","棋牌","明星","综艺","","","",""],
		"art":["文学","雕塑","音乐","舞蹈","绘画","书法","单反","","",""]
	};


	function getbirthday(time){
		var d = new Date(time);
		return d.getMonth()+1+"月"+ d.getDay()+"日";

	}
	function getAstro(time){

		var d = new Date(time);
		var month = d.getMonth()+1;
		var day = d.getDay()
		var s="魔羯水瓶双鱼牡羊金牛双子巨蟹狮子处女天秤天蝎射手魔羯";
		var arr=[20,19,21,21,21,22,23,23,23,23,22,22];
		return s.substr(month*2-(day<arr[month-1]?2:0),2);
	}
	function getAppraise(type){

		return appraiseType[type]||""
	}
	function getAges(time)
	{
		var d=new Date(time);
		var year=d.getFullYear();
		var day=d.getDate();
		var month=+d.getMonth()+1;
		var str=year+"-"+month+"-"+day;
		var   r   =   str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
		if(r==null)return   false;
		var   d=   new   Date(r[1],   r[3]-1,   r[4]);
		if   (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4])
		{
			var   Y   =   new   Date().getFullYear();
			return("年龄   =   "+   (Y-r[1])   +"   周岁");
		}
		return("输入的日期格式错误！");
	}

	function getSpacingTime(time){
		var nowTime = new Date().getTime();
		var dt = parseInt((nowTime - time)/1000);
		var res = ""
		if(dt<60){
			res = "刚刚";
		}else if(dt<60*60){
			res =  parseInt(dt/60)+"分钟前";
		}else if(dt<60*60*12){
			res =  parseInt(dt/(60*12))+"小时前";
		}else if(dt<60*60*12*30){
			res =  parseInt(dt/(60*60*12))+"天前";
		}else if(dt<60*60*12*30*12){
			res =  parseInt(dt/(60*60*12*30))+"月前";
		}else{
			res =  parseInt(dt/(60*60*12*30*12))+"年前";
		}
		return res;
	}
	return {
		getbirthday:getbirthday,/*获取生日*/
		getAstro:getAstro,/*获取星座*/
		getAges:getAges,/*获取年龄*/
		getSpacingTime:getSpacingTime,/*获取时间间距*/
		getAppraise:getAppraise/*获取评价*/
	}
}

