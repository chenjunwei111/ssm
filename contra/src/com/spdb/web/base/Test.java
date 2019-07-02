package com.spdb.web.base;

import java.math.BigDecimal;
import java.util.Random;

public class Test {
    public static String randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat, String type) {
        Random random = new Random();
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        return lon+","+lat;
    }
    public static void main(String[] args) {
        System.out.println(Test.randomLonLat(104.990179,104.991179,23.51913,23.52913,"Lat"));
    }
}
