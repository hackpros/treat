package com.navigate.treat.io.gift.helper;

/**
 * 
 * @author huangshiping
 *
 */
public class GiftHelper {

	/**
	 * 
	 * 礼物来源
	 */
	public enum SourceType {
		TREAT(1), // 活动
		SHOW(2), // 秀场
		PTP(3),// 点对点
		SYSTEM(3);// 系统送礼
		
		private int index;

		private SourceType(int index) {
			this.index = index;
		}

		@Override
		public String toString() {
			return String.valueOf(this.index);

		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}
}
