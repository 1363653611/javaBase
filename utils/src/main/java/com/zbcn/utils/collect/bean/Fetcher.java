package com.zbcn.utils.collect.bean;

/**
 * Created by zhangquanhong on 2016/8/26.
 */
public interface Fetcher<T, V> {

    public V fetch(T t);
}
