package com.navigate.treat.util;



public final class DistanceUtil {

	/**
	 * 计算距离杭州的距离  杭州(120.2E ,30.3N)
	 * @param lat1 （对方的经度）
	 * @param lat2（杭州的经度）
	 * @param lon1（对方的维度）
	 * @param lon2（杭州的维度）
	 * @return
	 */
	public static double getDistatce(double lat1, double lat2, double lon1,    double lon2) {
        double R = 6371;//半径千米
        double distance = 0.0;
        double dLat = (lat2 - lat1) * Math.PI / 180;
        double dLon = (lon2 - lon1) * Math.PI / 180;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1 * Math.PI / 180)
                * Math.cos(lat2 * Math.PI / 180) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        distance = (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))) * R;
        return distance;
    }
}
