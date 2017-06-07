package com.sort.tao.sortalgorithm.utils;

import java.util.ArrayList;

/**
 * Created by tao on 2017/6/7.
 */

public class ArrayUtil {
    public static String makeString(ArrayList<Integer> data){
        StringBuilder sb = new StringBuilder();
        for(Integer i : data){
            sb.append(i + " ");
        }
        return sb.toString();
    }
}
