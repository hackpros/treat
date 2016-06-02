package com.navigate.treat.gis;


/**
 * 更据坐标算距离
 * 
 * @author fwg create by 2015-11-19
 *
 */
public class GisUtils {

	public class LatLng {

		public double lat;
		public double lng;
		public double getLat() {
			return lat;
		}
		public void setLat(double lat) {
			this.lat = lat;
		}
		public double getLng() {
			return lng;
		}
		public void setLng(double lng) {
			this.lng = lng;
		}
		
	}

	public static float calculateLineDistance(LatLng var0, LatLng var1) {
		// double var2 = 0.01745329251994329D;
		double var4 = var0.lng;
		double var6 = var0.lat;
		double var8 = var1.lng;
		double var10 = var1.lat;
		var4 *= 0.01745329251994329D;
		var6 *= 0.01745329251994329D;
		var8 *= 0.01745329251994329D;
		var10 *= 0.01745329251994329D;
		double var12 = Math.sin(var4);
		double var14 = Math.sin(var6);
		double var16 = Math.cos(var4);
		double var18 = Math.cos(var6);
		double var20 = Math.sin(var8);
		double var22 = Math.sin(var10);
		double var24 = Math.cos(var8);
		double var26 = Math.cos(var10);
		double[] var28 = new double[3];
		double[] var29 = new double[3];
		var28[0] = var18 * var16;
		var28[1] = var18 * var12;
		var28[2] = var14;
		var29[0] = var26 * var24;
		var29[1] = var26 * var20;
		var29[2] = var22;
		double var30 = Math.sqrt((var28[0] - var29[0]) * (var28[0] - var29[0]) + (var28[1] - var29[1])
				* (var28[1] - var29[1]) + (var28[2] - var29[2]) * (var28[2] - var29[2]));
		return (float) (Math.asin(var30 / 2.0D) * 1.27420015798544E7D);
	}

	public static float calculateLineDistance(double x1, double y1, double x2, double y2) {
		// double var2 = 0.01745329251994329D;
		double var4 = x1;
		double var6 = y1;
		double var8 = x2;
		double var10 = y2;
		var4 *= 0.01745329251994329D;
		var6 *= 0.01745329251994329D;
		var8 *= 0.01745329251994329D;
		var10 *= 0.01745329251994329D;
		double var12 = Math.sin(var4);
		double var14 = Math.sin(var6);
		double var16 = Math.cos(var4);
		double var18 = Math.cos(var6);
		double var20 = Math.sin(var8);
		double var22 = Math.sin(var10);
		double var24 = Math.cos(var8);
		double var26 = Math.cos(var10);
		double[] var28 = new double[3];
		double[] var29 = new double[3];
		var28[0] = var18 * var16;
		var28[1] = var18 * var12;
		var28[2] = var14;
		var29[0] = var26 * var24;
		var29[1] = var26 * var20;
		var29[2] = var22;
		double var30 = Math.sqrt((var28[0] - var29[0]) * (var28[0] - var29[0]) + (var28[1] - var29[1])
				* (var28[1] - var29[1]) + (var28[2] - var29[2]) * (var28[2] - var29[2]));
		return (float) (Math.asin(var30 / 2.0D) * 1.27420015798544E7D);
	}

/*	public static float calculateLineDistance(Object bizLat, Object bizLng, Object lat, Object lng) {

		// TODO Auto-generated method stub
		return 0;
	}*/

	
	public static void main(String[] args) {
		//杭州坐标
		double x1=120.2;
		double y1=30.3;
		//上海的坐标
		double x2=121.54;
		double y2=31.345;
		float dis=	GisUtils.calculateLineDistance(x2, y2, x1, y1);
		System.out.println(dis);
	}
}
