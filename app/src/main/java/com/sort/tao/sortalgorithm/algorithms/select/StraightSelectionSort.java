package com.sort.tao.sortalgorithm.algorithms.select;

import com.sort.tao.sortalgorithm.utils.Sort;
import com.sort.tao.sortalgorithm.utils.SortSend;

import java.util.ArrayList;

/**
 * 直接选择排序
 * <p>
 * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
 * Created by tao on 2017/6/6.
 */

public class StraightSelectionSort implements Sort {

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> numbers, SortSend sortSend) {
        ArrayList<Integer> retArray = new ArrayList<>();
        while (numbers.size() > 0) {
            int x = findX(numbers, sortSend);
            retArray.add(x);
        }
        return retArray;
    }

    private int findX(ArrayList<Integer> arrayList, SortSend sortSend) {
        int x = arrayList.get(0);
        int xIndex = 0;
        if (sortSend == SortSend.Ascend) {
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i) < x) {
                    x = arrayList.get(i);
                    xIndex = i;
                }
            }
        } else {
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i) > x) {
                    x = arrayList.get(i);
                    xIndex = i;
                }
            }
        }
        arrayList.remove(xIndex);
        return x;
    }
}
