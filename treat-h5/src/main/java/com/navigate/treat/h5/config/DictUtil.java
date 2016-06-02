package com.navigate.treat.h5.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;

/**
 * 系统常量类
 * 
 * @author Administrator
 *
 */
public class DictUtil extends VelocityContext {
	public static Interest interests =new DictUtil().new Interest();
	// 活动评价类型
	public final static Map<Integer, String> USER_APPRAISE = new HashMap<Integer, String>();

	static {
		USER_APPRAISE.put(101, "秀气");
		USER_APPRAISE.put(102, "绅士");
		USER_APPRAISE.put(103, "豪爽");
		USER_APPRAISE.put(104, "憨厚");
		USER_APPRAISE.put(105, "幽默");
		USER_APPRAISE.put(106, "稳重");
		USER_APPRAISE.put(107, "土豪");
		USER_APPRAISE.put(108, "博学");
		USER_APPRAISE.put(109, "阳光");
		USER_APPRAISE.put(110, "洋气");
		USER_APPRAISE.put(301, "屌丝");
		USER_APPRAISE.put(302, "装逼");
		USER_APPRAISE.put(303, "变态");
		USER_APPRAISE.put(304, "无聊");
		USER_APPRAISE.put(305, "炫耀");
		USER_APPRAISE.put(306, "神经");
		USER_APPRAISE.put(307, "木讷");
		USER_APPRAISE.put(308, "极端");
		USER_APPRAISE.put(309, "闷骚");
		USER_APPRAISE.put(310, "无礼");
		USER_APPRAISE.put(201, "漂亮");
		USER_APPRAISE.put(202, "温柔");
		USER_APPRAISE.put(203, "灵气");
		USER_APPRAISE.put(204, "直率");
		USER_APPRAISE.put(205, "气质");
		USER_APPRAISE.put(206, "女神");
		USER_APPRAISE.put(207, "腼典");
		USER_APPRAISE.put(208, "善良");
		USER_APPRAISE.put(209, "时尚");
		USER_APPRAISE.put(210, "优雅");
		USER_APPRAISE.put(401, "委婉");
		USER_APPRAISE.put(402, "木讷");
		USER_APPRAISE.put(403, "无礼");
		USER_APPRAISE.put(404, "高冷");
		USER_APPRAISE.put(405, "傲慢");
		USER_APPRAISE.put(406, "虚荣");
		USER_APPRAISE.put(407, "傲娇");
		USER_APPRAISE.put(408, "俗气");
		USER_APPRAISE.put(409, "肤浅");
		USER_APPRAISE.put(410, "憔悴");

		interests.setLife(Arrays.asList("阅读", "美食", "茶道", "旅行", "美妆", "园艺", "宠物", "时尚", "手工", "烹饪", "养生", "收藏", "星座",
				"生活", "户外", "数码", "", ""));
		interests.setSport(Arrays.asList("健身", "瑜伽", "游泳", "轮滑", "极限运动", "篮球", "足球", "羽毛球", "台球", "", "", ""));
		interests.setEnt(Arrays.asList("KTV", "酒吧", "游戏", "电影", "电视剧", "动漫", "桌游", "棋牌", "明星", "综艺", "", "", "", ""));
		interests.setArt(Arrays.asList("文学", "雕塑", "音乐", "舞蹈", "绘画", "书法", "单反", "", "", ""));

	}

	/**
	 * 获取评价
	 * 
	 * @param key
	 * @return
	 */
	public static String getAppRaise(int key) {
		return USER_APPRAISE.get(key);
	}

	public String getInterest(long interest) {

		HashMap<Long, String> itemMap = interests.getInterestName();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (long v = 1; v != 0 && interest >= v; v = v << 1) {
			if ((interest & v) == v) {
				count++;
				if (count == 5) {
					break;
				}
				sb.append(itemMap.get(v)).append("/");
			}
		}
		return sb.substring(0, sb.length() - 1) + (count == 5 ? "..." : "");
	}

	/**
	 * 兴趣内部类
	 * 
	 * @author Administrator
	 *
	 */
	public class Interest {
		public Interest(){
		}
		private List<String> life = new ArrayList<String>();
		private List<String> sport = new ArrayList<String>();
		private List<String> ent = new ArrayList<String>();
		private List<String> art = new ArrayList<String>();

		public List<String> getLife() {
			return life;
		}

		public void setLife(List<String> life) {
			this.life = life;
		}

		public List<String> getSport() {
			return sport;
		}

		public void setSport(List<String> sport) {
			this.sport = sport;
		}

		public List<String> getEnt() {
			return ent;
		}

		public void setEnt(List<String> ent) {
			this.ent = ent;
		}

		public List<String> getArt() {
			return art;
		}

		public void setArt(List<String> art) {
			this.art = art;
		}

		public HashMap<Long, String> getInterestName() {
			HashMap<Long, String> interests = new HashMap<>();
			ArrayList<String> itemList = new ArrayList<>();
			itemList.addAll(life);
			itemList.addAll(sport);
			itemList.addAll(ent);
			itemList.addAll(art);
			int size = itemList.size();
			for (int i = 0; i < size; i++) {
				interests.put(1l << i, itemList.get(i));
			}
			return interests;
		}

	}
}
