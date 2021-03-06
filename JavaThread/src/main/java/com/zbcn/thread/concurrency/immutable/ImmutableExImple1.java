package com.zbcn.thread.concurrency.immutable;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Description: final、的作用
 * @Auther: zbcn
 * @Date: 2/27/19 17:03
 */
public class ImmutableExImple1 {

    private final static Integer a = 1;

    private final static String b = "a";

    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(2,3);
        map.put(4,5);

    }

    public static void main(String[] args) {
        //具体值不能单独赋值
        //a =2;
        //b = "3";
        //引用不能只向别的值
        //map = Maps.newHashMap();
        //对象的值可以改变
        map.put(8,7);
    }
}
