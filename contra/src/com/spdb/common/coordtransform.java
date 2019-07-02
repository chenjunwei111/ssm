package com.spdb.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 百度坐标转换
 * 
 * @author YUAN
 * 
 */
public class coordtransform {
	private Double x_PI = 3.14159265358979324 * 3000.0 / 180.0;
	private Double PI = 3.1415926535897932384626;
	private Double a = 6378245.0;
	private Double ee = 0.00669342162296594323;

	/**
	 * WGS84转BD09
	 * 
	 * @param points
	 * @return
	 */
	public List<MapPoint> Wgs84toDB09(List<MapPoint> points) {
		if (points == null)
			return null;
		List<MapPoint> mPoints = new ArrayList<MapPoint>();
		MapPoint ps = null;
		for (MapPoint p : points) {
			ps = wgs84togcj02(p);
			mPoints.add(gcj02tobd09(ps));
		}
		return mPoints;
	}

	/**
	 * DB09转WGS84
	 * 
	 * @param points
	 * @return 
	 */
	public List<MapPoint> DB09toWgs84(List<MapPoint> points) {
		if (points == null)
			return null;
		List<MapPoint> mPoints = new ArrayList<MapPoint>();
		MapPoint ps = null;
		for (MapPoint p : points) {
			ps = bd09togcj02(p);
			mPoints.add(gcj02towgs84(ps));
		}
		return mPoints;
	}

	private MapPoint bd09togcj02(MapPoint p) {
		p.setX(p.getX() - 0.0065);
		p.setY(p.getY() - 0.006);
		double x = p.getX();
		double y = p.getY();
		Double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_PI);
		Double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_PI);
		Double lng = z * Math.cos(theta);
		Double lat = z * Math.sin(theta);
		return new MapPoint(lng, lat);
	}

	private MapPoint gcj02tobd09(MapPoint mp) {
		double lng = mp.getX();
		double lat = mp.getY();
		double z = Math.sqrt(lng * lng + lat * lat) + 0.00002
				* Math.sin(lat * x_PI);
		double theta = Math.atan2(lat, lng) + 0.000003 * Math.cos(lng * x_PI);
		double bd_lng = z * Math.cos(theta) + 0.0065;
		double bd_lat = z * Math.sin(theta) + 0.006;
		return new MapPoint(bd_lng, bd_lat);
	}

	private MapPoint wgs84togcj02(MapPoint mp) {
		double lng = mp.getX();
		double lat = mp.getY();
		if (out_of_china(lng, lat)) {
			return new MapPoint(lng, lat);
		} else {
			double dlat = transformlat(lng - 105.0, lat - 35.0);
			double dlng = transformlng(lng - 105.0, lat - 35.0);
			double radlat = lat / 180.0 * PI;
			double magic = Math.sin(radlat);
			magic = 1 - ee * magic * magic;
			double sqrtmagic = Math.sqrt(magic);
			dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
			dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
			double mglat = lat + dlat;
			double mglng = lng + dlng;
			return new MapPoint(mglng, mglat);
		}
	}

	private MapPoint gcj02towgs84(MapPoint mp) {
		double lng = mp.getX();
		double lat = mp.getY();
		if (out_of_china(lng, lat)) {
			return new MapPoint(lng, lat);
		} else {
			double dlat = transformlat(lng - 105.0, lat - 35.0);
			double dlng = transformlng(lng - 105.0, lat - 35.0);
			double radlat = lat / 180.0 * PI;
			double magic = Math.sin(radlat);
			magic = 1 - ee * magic * magic;
			double sqrtmagic = Math.sqrt(magic);
			dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
			dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
			double mglat = lat + dlat;
			double mglng = lng + dlng;
			return new MapPoint(lng * 2 - mglng, lat * 2 - mglat);
		}
	}

	private double transformlat(double lng, double lat) {
		double ret = -100.0 + 2.0 * lng + 3.0 * lat + 0.2 * lat * lat + 0.1
				* lng * lat + 0.2 * Math.sqrt(Math.abs(lng));
		ret += (20.0 * Math.sin(6.0 * lng * PI) + 20.0 * Math.sin(2.0 * lng
				* PI)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(lat * PI) + 40.0 * Math.sin(lat / 3.0 * PI)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(lat / 12.0 * PI) + 320 * Math.sin(lat * PI
				/ 30.0)) * 2.0 / 3.0;
		return ret;
	}

	private double transformlng(double lng, double lat) {
		double ret = 300.0 + lng + 2.0 * lat + 0.1 * lng * lng + 0.1 * lng
				* lat + 0.1 * Math.sqrt(Math.abs(lng));
		ret += (20.0 * Math.sin(6.0 * lng * PI) + 20.0 * Math.sin(2.0 * lng
				* PI)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(lng * PI) + 40.0 * Math.sin(lng / 3.0 * PI)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(lng / 12.0 * PI) + 300.0 * Math.sin(lng / 30.0
				* PI)) * 2.0 / 3.0;
		return ret;
	}

	private boolean out_of_china(double lng, double lat) {
		return !(lng > 73.66 && lng < 135.05 && lat > 3.86 && lat < 53.55);
	}

}
