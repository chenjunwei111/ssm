package com.spdb.common;

import java.math.BigDecimal;
import java.util.*;

/**
 * 采用的是分治法，并对凸包点进行排序处理
 * 
 * @author Chan
 * 
 */
public class ConvexHull {
	Set<MapPoint> ans = new HashSet<>();

	public ConvexHull() {

	}

	public static void main(String[] args) {

		// 下面的点不适合该方法，反而适合穷举法
		MapPoint[] A = new MapPoint[12];
		A[0] = new MapPoint(102.77139, 24.976204);
		A[1] = new MapPoint(102.77298, 24.97676);
		A[2] = new MapPoint(102.77058, 24.97543);
		A[3] = new MapPoint(102.77213, 24.974043);
		A[4] = new MapPoint(102.76885, 24.975227);
		A[5] = new MapPoint(102.76863, 24.974577);
		A[6] = new MapPoint(102.76995, 24.975182);

		A[7] = new MapPoint(102.77298, 24.97676);
		A[8] = new MapPoint(102.77184, 24.97752);
		A[9] = new MapPoint(102.76879, 24.974073);
		A[10] = new MapPoint(102.77298, 24.97676);
		A[11] = new MapPoint(102.77063, 24.975445);

		ConvexHull ch = new ConvexHull();

		MapPoint[] lp = ch.getConvexPoint(ch.distinct(A));
		int i = 1;
		for (MapPoint p : lp) {
			System.out.println(i + "," + p.getX() + "," + p.getY());
			i++;
		}
	}

	public MapPoint[] getConvexPoint(MapPoint[] ps) {
		List<MapPoint> pp = new ArrayList<MapPoint>();
		for (MapPoint p : ps) {
			pp.add(p);
		}
		helper(pp, false);
		helper(pp, true);

		List<MapPoint> tmp = new ArrayList<>(ans);

		Collections.sort(tmp, new Comparator<MapPoint>() {
			@Override
			public int compare(MapPoint o1, MapPoint o2) {
				if (o1.getX().equals(o2.getX())) {
					if (o1.getY().equals(o2.getY())) {
						return 0;
					} else {
						if (o1.getY() > o2.getY()) {
							return 1;
						} else {
							return -1;
						}
					}
				} else {
					if (o1.getX() > o2.getX()) {
						return 1;
					} else {
						return -1;
					}
				}
				// return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
			}
		});

		MapPoint[] mps = new MapPoint[tmp.size()];

		for (int i = 0; i < tmp.size(); i++) {
			// System.out.println(tmp.get(i).getX() + "," + tmp.get(i).getY());
			mps[i] = new MapPoint(tmp.get(i).getX(), tmp.get(i).getY());
		}
		ClockwiseSortPoints(mps);
		return mps;
	}

	public MapPoint[] distinct(MapPoint[] A) {
		List<String> numList = new ArrayList<String>();
		for (MapPoint i : A)
			numList.add(i.toString());

		Set<String> numSet = new HashSet<String>();
		numSet.addAll(numList);

		MapPoint[] B = new MapPoint[numSet.size()];
		Iterator<String> it = numSet.iterator();
		int i = 0;
		while (it.hasNext()) {
			String[] m = it.next().split(",");
			B[i] = new MapPoint(Double.parseDouble(m[0]),
					Double.parseDouble(m[1]));
			i++;
		}
		return B;
	}

	private void helper(List<MapPoint> points, boolean calcuConvex) {
		if (points.size() == 0)
			return;
		Collections.sort(points, new Comparator<MapPoint>() {
			@Override
			public int compare(MapPoint o1, MapPoint o2) {
				if (o1.getX().equals(o2.getX())) {
					if (o1.getY().equals(o2.getY())) {
						return 0;
					} else {
						if (o1.getY() > o2.getY()) {
							return 1;
						} else {
							return -1;
						}
					}
				} else {
					if (o1.getX() > o2.getX()) {
						return 1;
					} else {
						return -1;
					}
				}
				// return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
			}
		});
		int fir = 0;
		int lst = points.size() - 1;

		ans.add(points.get(fir));
		ans.add(points.get(lst));

		if (points.size() == 2)
			return;

		// oneLine
		boolean isLine = true;
		for (int i = 0; i < points.size(); i++) {
			if (i == fir || i == lst)
				continue;
			if (calcuTriangle(points.get(fir), points.get(lst), points.get(i)) != 0) {
				isLine = false;
				break;
			}
		}
		if (isLine) {
			ans.addAll(points);
			return;
		}

		int maxIndex = -1;
		double max = 0;
		for (int i = 0; i < points.size(); i++) {
			if (i == fir || i == lst)
				continue;
			// 上凸包
			if (calcuConvex
					&& calcuTriangle(points.get(fir), points.get(lst),
							points.get(i)) > max) {
				maxIndex = i;
				max = calcuTriangle(points.get(fir), points.get(lst),
						points.get(i));
			}
			// 下凸包
			if (!calcuConvex
					&& -calcuTriangle(points.get(fir), points.get(lst),
							points.get(i)) > max) {
				maxIndex = i;
				max = -calcuTriangle(points.get(fir), points.get(lst),
						points.get(i));
			}
		}

		if (maxIndex == -1) {
			return;
		}

		List<MapPoint> c1 = new ArrayList<>();
		split(fir, maxIndex, points, c1, calcuConvex);
		helper(c1, calcuConvex);

		List<MapPoint> c2 = new ArrayList<>();
		split(lst, maxIndex, points, c2, !calcuConvex);
		helper(c2, calcuConvex);
	}

	private void split(int a1, int a2, List<MapPoint> points,
			List<MapPoint> part1, boolean isConvex) {
		for (int i = 0; i < points.size(); i++) {
			if (i == a1 || i == a2) {
				part1.add(points.get(i));
				continue;
			}
			if (isConvex
					&& calcuTriangle(points.get(a1), points.get(a2),
							points.get(i)) >= 0) {
				part1.add(points.get(i));
			}

			if (!isConvex
					&& calcuTriangle(points.get(a1), points.get(a2),
							points.get(i)) <= 0) {
				part1.add(points.get(i));
			}
		}
	}

	private double calcuTriangle(MapPoint a1, MapPoint a2, MapPoint a3) {
		return a1.getX() * a2.getY() + a3.getX() * a1.getY() + a2.getX()
				* a3.getY() - a3.getX() * a2.getY() - a2.getX() * a1.getY()
				- a1.getX() * a3.getY();
	}

	public void ClockwiseSortPoints(MapPoint[] vPoints) {
		// 计算重心
		MapPoint center = new MapPoint();
		double X = 0;
		double Y = 0;

		for (int i = 0; i < vPoints.length; i++) {
			X += vPoints[i].getX();
			Y += vPoints[i].getY();
		}

		center.setX(decimal(X / vPoints.length, 6));
		center.setY(decimal(Y / vPoints.length, 6));

		// System.out.println("======>" + center.getX() + "," + center.getY());

		// 冒泡排序
		for (int i = 0; i < vPoints.length - 1; i++) {
			for (int j = 0; j < vPoints.length - i - 1; j++) {
				if (PointCmp(vPoints[j], vPoints[j + 1], center)) {
					MapPoint tmp = vPoints[j];
					vPoints[j] = vPoints[j + 1];
					vPoints[j + 1] = tmp;
				}
			}
		}
	}

	// 若点a大于点b,即点a在点b顺时针方向,返回true,否则返回false
	private boolean PointCmp(MapPoint a, MapPoint b, MapPoint center) {
		if (a.getX() >= 0 && b.getX() < 0) {
			// System.out.println(a.toString() + "==" + b.toString() + "=="
			// + center.toString() + "==" + 1);
			return true;
		}

		if (a.getX() == 0 && b.getX() == 0) {
			// System.out.println(a.toString() + "==" + b.toString() + "=="
			// + center.toString() + "==" + 0);
			return a.getY() > b.getY();
		}

		// 向量OA和向量OB的叉积
		double det = ((a.getX() - center.getX()) * (b.getY() - center.getY()) - (b
				.getX() - center.getX()) * (a.getY() - center.getY()));
		if (det < 0) {
			// System.out.println(a.toString() + "==" + b.toString() + "=="
			// + center.toString() + "==" + "11");
			return true;
		}

		if (det > 0) {
			// System.out.println(a.toString() + "==" + b.toString() + "=="
			// + center.toString() + "==" + "00");
			return false;
		}

		// 向量OA和向量OB共线，以距离判断大小
		double d1 = (a.getX() - center.getX()) * (a.getX() - center.getX())
				+ (a.getY() - center.getY()) * (a.getY() - center.getY());
		double d2 = (b.getX() - center.getX()) * (b.getX() - center.getY())
				+ (b.getY() - center.getY()) * (b.getY() - center.getY());
		return d1 > d2;
	}

	public static double decimal(double oldDouble, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(oldDouble));
		BigDecimal one = new BigDecimal("1");
		// return b.divide(one, scale, BigDecimal.ROUND_FLOOR).doubleValue();
		if (oldDouble > 0) {
			// 此处的scale表示的是，小数点之后的精度。
			return b.divide(one, scale, BigDecimal.ROUND_DOWN).doubleValue();
		} else {
			return b.divide(one, scale, BigDecimal.ROUND_UP).doubleValue();
		}
	}

}
