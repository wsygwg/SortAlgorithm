package com.sort.tao.sortalgorithm.utils;

import java.util.ArrayList;

/**
 * Created by tao on 2017/6/7.
 */

public class ArrayUtil {
    public static String makeString(ArrayList<Integer> data){
        //StringBuilder线程不安全，单线程使用
        StringBuilder sb = new StringBuilder();
        for(Integer i : data){
            sb.append(i + " ");
        }
        return sb.toString();
    }

    public synchronized static void changeIndexNumber(ArrayList<Integer> array, int indexA, int indexB) {
        if (indexA < indexB) {
            int indexANumber = array.get(indexA);
            array.set(indexA, array.get(indexB));
            array.set(indexB, indexANumber);
        }
    }
}
