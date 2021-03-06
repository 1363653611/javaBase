package com.zbcn.common.base.generic;

/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 即：class FruitGenerator<T> implements Generator<T>{
 * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
 * @author Administrator
 * @date 2019/1/15 15:18
 */
public class Generator<T> implements GenericIF<T> {
    @Override
    public T getGeneric() {
        return null;
    }
}
