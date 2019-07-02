package com.spdb.common;

import java.math.BigDecimal;

public class MapPoint {

	// 定义点的x，y坐标，之所以是int类型，是为了日后可以在计算机屏幕上进行可视化。
	private Double x;
	private Double y;

	public void setX(Double x) {
		this.x = x;
	}

	public void setY(Double y) {
		this.y = y;
	}

	// x,y的get方法
	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	// 定义点到屏幕边缘的距离
	private static double PADDING = 20;
	// 点在屏幕中的范围
	private static double POINT_RANGE = (800 - PADDING * 2);

	// 默认构造方法，产生随机点
	public MapPoint() {
		this.x = ((Math.random() * POINT_RANGE) + PADDING);
		this.y = ((Math.random() * POINT_RANGE) + PADDING);
	}

	// 带参构造方法，可以实现手动输入固定点
	public MapPoint(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

 
	@Override
	public boolean equals(Object obj)
	{
		 if (obj == null)
         {
             return false;
         }
         if ((obj.getClass().equals(this.getClass())) == false)
         {
             return false;
         }
         MapPoint temp = null;
         temp = (MapPoint)obj;
         return this.getY().equals(temp.getY()) && this.getX().equals(temp.getX());
	}
	
	@Override
	public String toString() {
		return decimal(this.x, 6) + "," + decimal(this.y, 6);
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