package com.spdb.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 地图图形处理
 * 
 * @author YUAN
 */
public class MapGeoUtil {

	private List<MapPoint> mapPoints = null;

	/**
	 * 获取点集合的凸点
	 * 
	 * 从最北边的点开始找下一个点，使其余所有点在这个点和下个点的连线的同一侧 外接多边形顶点集合
	 */
	public List<MapPoint> getBumpPoint(List<MapPoint> points) throws Exception {
		this.mapPoints = points;
		List<MapPoint> result = new ArrayList<MapPoint>();
		// 最北边的点作为多边形第一个点
		MapPoint a = NorthernMost();
		MapPoint b = NorthernMost();
		result.add(b);// add第一个点
		MapPoint c = GetNextPoint(b, b);// 第一次找点特殊处理
		while (!NorthernMost().equals(c)) {
			a = b;
			b = c;// 交换abc三个点，继续找下一个点
			result.add(c);
			c = GetNextPoint(b, a);
		}
		return result;
	}

	public MapPoint[] getBumpPoint(MapPoint[] points) throws Exception {
		if (points == null)
			return null;
		List<MapPoint> mp = Arrays.asList(points);
		List<MapPoint> mpList = getBumpPoint(mp);
		if (mpList != null) {
			MapPoint[] mPoints = new MapPoint[mpList.size()];
			mpList.toArray(mPoints);
			return mPoints;
		}
		return null;
	}

	/*
	 * 找到最北边的点为多边形的第一个点
	 */
	private MapPoint NorthernMost() {
		MapPoint lo = this.mapPoints.get(1);
		for (MapPoint l : this.mapPoints) {
			if (l.getY() > lo.getY())
				lo = l;
		}
		return lo;
	}

	/*
	 * 给定一个点获取另一个点，使得列表中其他点都在两点连线同一侧，但是找到的这个点不能是上一个点 <param
	 * name="_currentpoint">给定这个点</param> <param name="_lastpoint">上一个点</param>
	 */
	private MapPoint GetNextPoint(MapPoint _currentpoint, MapPoint _lastpoint) {
		for (MapPoint l : this.mapPoints) {
			if (!_currentpoint.equals(l)) {
				if (AtOneSide(_currentpoint, l) && !_lastpoint.equals(l))
					return l;
			}
		}
		return null;
	}

	/*
	 * 判断所有点是否在两点连线一侧
	 */
	private Boolean AtOneSide(MapPoint l1, MapPoint l2) {
		double k = (l1.getY() - l2.getY()) / (l1.getX() - l2.getX());
		double b = l1.getY() - l1.getX() * (l1.getY() - l2.getY())
				/ (l1.getX() - l2.getX());
		Boolean v = GetV(l1, l2, k, b);
		for (MapPoint l : this.mapPoints) {
			if (!l.equals(l1) && !l.equals(l2)) {
				if ((l.getY() > (k * l.getX() + b)) != v)
					return false;
			}
		}
		return true;
	}

	/*
	 * 点集中随便找到第三点，确定他在两点连线的哪一侧
	 */
	private boolean GetV(MapPoint l1, MapPoint l2, double k, double b) {
		for (MapPoint l : this.mapPoints) {
			if (!l.equals(l1) && !l.equals(l2)) {
				return l.getY() > (k * l.getX() + b);
			}
		}
		return false;
	}

	/**
	 *根据一个给定多边形的点集合坐标，生成基于多边形的边缓冲区边界点坐标串
	 * @param points 多边形点集合
	 * @param radius 缓冲半径(m)
	 * @return 缓冲区点集合
	 **/
	public List<MapPoint> getPolylineBufferZone(List<MapPoint> points,
			double radius) {
		if (points == null || points.size() < 1)
			return null;
		this.mapPoints = points;
		if (this.mapPoints.size() < 2)
			return GetPointBufferZone(this.mapPoints.get(0), radius);
		radius = radius / 100000;
		return GetLeftBufferEdgeCoords(radius);
	}

	/**
	 * 根据一个给定点的坐标，生成基于这个点的点缓冲区边界点坐标串(逆时针)
	 **/
	public List<MapPoint> GetPointBufferZone(MapPoint center, double radius) {
		Integer N = 12;
		double alpha = 0.0;// Math.PI / 6;
		double gamma = (2 * Math.PI) / N;
		radius = radius / 100000;
		List<MapPoint> rList = new ArrayList<MapPoint>();
		double x = 0.0, y = 0.0;
		for (double phi = 0; phi < (N - 1) * gamma; phi += gamma) {
			x = center.getX() + radius * Math.cos(alpha + phi);
			y = center.getY() + radius * Math.sin(alpha + phi);
			rList.add(new MapPoint(x, y));

		}
		return rList;
	}

	// / <summary>
	// / 根据给定的一系列有顺序的坐标，逆时针生成轴线左侧的缓冲区边界点
	// / </summary>
	// / <param name="coords">一系列有顺序的坐标</param>
	// / <param name="radius">缓冲区半径</param>
	// / <returns>缓冲区的边界坐标</returns>
	private List<MapPoint> GetLeftBufferEdgeCoords(double radius) {

		// 计算时所需变量
		double alpha = 0.0;// 向量绕起始点沿顺时针方向旋转到X轴正半轴所扫过的角度
		double delta = 0.0;// 前后线段所形成的向量之间的夹角
		double l = 0.0;// 前后线段所形成的向量的叉积

		// 辅助变量
		List<MapPoint> rslList = new ArrayList<MapPoint>();
		double startRadian = 0.0;
		double endRadian = 0.0;
		double beta = 0.0;
		double x = 0.0, y = 0.0;
		Integer curidx = 0;
		MapPoint cPoint = null, pPoint = null, nPoint = null;
		for (MapPoint p : this.mapPoints) {
			if (curidx == 0) {
				cPoint = this.mapPoints.get(curidx);
				pPoint = this.mapPoints.get(this.mapPoints.size() - 1);
				nPoint = this.mapPoints.get(curidx + 1);
			} else if (curidx == this.mapPoints.size() - 1) {
				pPoint = this.mapPoints.get(this.mapPoints.size() - 2);
				cPoint = this.mapPoints.get(curidx);
				nPoint = this.mapPoints.get(0);

			} else {
				pPoint = this.mapPoints.get(curidx - 1);
				cPoint = this.mapPoints.get(curidx);
				nPoint = this.mapPoints.get(curidx + 1);
			}
			alpha = GetQuadrantAngle(cPoint, nPoint);
			delta = GetIncludedAngel(pPoint, cPoint, nPoint);
			l = GetVectorProduct(pPoint, cPoint, nPoint);
			List<MapPoint> rsl = null;
			if (l > 0) {
				startRadian = alpha + (3 * Math.PI) / 2 - delta;
				endRadian = alpha + (3 * Math.PI) / 2;
				rsl = GetBufferCoordsByRadian(this.mapPoints.get(curidx),
						startRadian, endRadian, radius);
				if (rsl != null) {
					rslList.addAll(rsl);
					rsl = null;
				}

			} else if (l < 0) {
				beta = alpha - (Math.PI - delta) / 2;
				x = cPoint.getX() + radius * Math.cos(beta);
				y = cPoint.getY() + radius * Math.sin(beta);
				rslList.add(new MapPoint(x, y));
			}
			curidx++;
		}
		return rslList;
	}

	// / <summary>
	// / 获取指定弧度范围之间的缓冲区圆弧拟合边界点
	// / </summary>
	// / <param name="center">指定拟合圆弧的原点</param>
	// / <param name="startRadian">开始弧度</param>
	// / <param name="endRadian">结束弧度</param>
	// / <param name="radius">缓冲区半径</param>
	// / <returns>缓冲区的边界坐标</returns>
	private List<MapPoint> GetBufferCoordsByRadian(MapPoint center,
			double startRadian, double endRadian, double radius) {
		double gamma = Math.PI / 6;
		List<MapPoint> mpList = new ArrayList<MapPoint>();
		double x = 0.0, y = 0.0;
		for (double phi = startRadian; phi <= endRadian + 0.000000000000001; phi += gamma) {
			x = center.getX() + radius * Math.cos(phi);
			y = center.getY() + radius * Math.sin(phi);
			mpList.add(new MapPoint(x, y));

		}
		return mpList;
	}

	// / <summary>
	// / 获取相邻三个点所形成的两个向量的交叉乘积
	// / </summary>
	// / <param name="preCoord">第一个节点坐标</param>
	// / <param name="midCoord">第二个节点坐标</param>
	// / <param name="nextCoord">第三个节点坐标</param>
	// / <returns>相邻三个点所形成的两个向量的交叉乘积</returns>
	private double GetVectorProduct(MapPoint preCoord, MapPoint midCoord,
			MapPoint nextCoord) {
		return (midCoord.getX() - preCoord.getX())
				* (nextCoord.getY() - midCoord.getY())
				- (nextCoord.getX() - midCoord.getX())
				* (midCoord.getY() - preCoord.getY());
	}

	// / <summary>
	// / 获取由两个点所形成的向量的象限角度
	// / </summary>
	// / <param name="preCoord">第一个点的坐标</param>
	// / <param name="nextCoord">第二个点的坐标</param>
	// / <returns></returns>
	private double GetQuadrantAngle(MapPoint preCoord, MapPoint nextCoord) {
		return GetQuadrantAngle(nextCoord.getX() - preCoord.getX(),
				nextCoord.getY() - preCoord.getY());
	}

	// / <summary>
	// / 由增量X和增量Y所形成的向量的象限角度
	// / </summary>
	// / <param name="x">增量X</param>
	// / <param name="y">增量Y</param>
	// / <returns>象限角</returns>
	private double GetQuadrantAngle(double x, double y) {
		double theta = Math.atan(y / x);
		if (x > 0 && y > 0)
			return theta;
		if (x > 0 && y < 0)
			return Math.PI * 2 + theta;
		if (x < 0 && y > 0)
			return theta + Math.PI;
		if (x < 0 && y < 0)
			return theta + Math.PI;
		return theta;
	}

	// / <summary>
	// / 获取由相邻的三个点所形成的两个向量之间的夹角
	// / </summary>
	// / <param name="preCoord"></param>
	// / <param name="midCoord"></param>
	// / <param name="nextCoord"></param>
	// / <returns></returns>
	private double GetIncludedAngel(MapPoint preCoord, MapPoint midCoord,
			MapPoint nextCoord) {
		double innerProduct = (midCoord.getX() - preCoord.getX())
				* (nextCoord.getX() - midCoord.getX())
				+ (midCoord.getY() - preCoord.getY())
				* (nextCoord.getY() - midCoord.getY());
		double mode1 = Math.sqrt(Math.pow((midCoord.getX() - preCoord.getX()),
				2.0) + Math.pow((midCoord.getY() - preCoord.getY()), 2.0));
		double mode2 = Math.sqrt(Math.pow((nextCoord.getX() - midCoord.getX()),
				2.0) + Math.pow((nextCoord.getY() - midCoord.getY()), 2.0));
		return Math.acos(innerProduct / (mode1 * mode2));
	}

	// / <summary>
	// / 获取由两个点所形成的向量的模(长度)
	// / </summary>
	// / <param name="preCoord">第一个点</param>
	// / <param name="nextCoord">第二个点</param>
	// / <returns>由两个点所形成的向量的模(长度)</returns>
	private double GetDistance(MapPoint preCoord, MapPoint nextCoord) {
		return Math.sqrt(Math.pow((nextCoord.getX() - preCoord.getX()), 2)
				+ Math.pow((nextCoord.getY() - preCoord.getY()), 2));
	}

}
