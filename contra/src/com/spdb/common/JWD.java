package com.spdb.common;

public class JWD {

	// 计算距离
	public static Double getDistance(Double jd1, Double wd1, Double jd2,
			Double wd2) {
		// val r: Double = 6378.137
		// // 地球半径,单位为千米
		// val CP: Double = 0.01745329251994329576923690768489
		// var x: Double = 0.0
		// var y: Double = 0.0
		//
		// x = (jd2 - jd1) * CP * r * Math.cos((wd1 + wd2) * CP.toDouble / 2)
		// y = (wd2 - wd1) * CP * r
		// Math.round(Math.pow((x * x + y * y), 0.5) * 1000) / 1000.0

		Double pi = 3.14159265;
		Double r = 6378137.0;
		Double x = (jd1 - jd2) * pi * r
				* Math.cos(((wd1 + wd2) / 2) * pi / 180) / 180;
		Double y = (wd1 - wd2) * pi * r / 180;
		return Math.pow(x * x + y * y, 0.5) / 1000.0;
	}

	// 计算相对角
	public static Integer digr(Double jd1, Double wd1, Double jd2, Double wd2) {
		Double delx = jd2 - jd1;
		Double dely = wd2 - wd1;

		Double distx = getDistance(jd1, wd1, jd2, wd1);
		Double disty = getDistance(jd2, wd1, jd2, wd2);

		Integer digr = 0;

		if (distx != 0) {
			Integer digr2 = (int) (Math.atan(disty / distx) / 3.14159265 * 180);
			if (delx >= 0 && dely >= 0) {
				digr = 90 - digr2;
			}
			if (delx < 0 && dely < 0) {
				digr = 270 - digr2;
			}
			if (delx >= 0 && dely < 0) {
				digr = 90 + digr2;
			}
			if (delx < 0 && dely >= 0) {
				digr = 270 + digr2;
			}
		} else {
			if (dely == 0) {
				digr = 0;
			} else {
				digr = (int) (90 - dely / Math.abs(dely));
			}
		}
		return digr;
	}

	// 是否主瓣方向
	public static Integer IsInCoverageArea(Integer AzimuthA, Integer xdj,
			Integer fgfw) {
		Integer num = AzimuthA - (fgfw / 2);
		Integer num2 = AzimuthA + (fgfw / 2);
		Integer rst = 0;
		if (num <= 0) {
			num += 360;
		}
		if (num2 <= 0) {
			num2 += 360;
		}
		if (num2 >= 360) {
			num2 -= 360;
		}
		if (num > num2) {
			if ((xdj < 360) && (xdj > num)) {
				rst = 1;
			}
			if ((xdj >= 0) && (xdj < num2)) {
				rst = 1;
			}
		} else if ((xdj >= num) && (xdj <= num2)) {
			rst = 1;
		}
		return rst;
	}

}
