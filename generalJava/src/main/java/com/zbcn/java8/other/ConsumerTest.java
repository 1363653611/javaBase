package com.zbcn.java8.other;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer 表示执行在单个参数上的操作
 */
public class ConsumerTest {

    public static void main(String[] args) {

        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // Consumer to display a list of integers
        Consumer<List<Integer>>
                dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        //dispList.accept(list);
        //System.out.println();
        // using addThen()
//        System.out.println();
//        modify.andThen(dispList).accept(list);
       // System.out.println();
        dispList.andThen(modify).accept(list);
    }
}
