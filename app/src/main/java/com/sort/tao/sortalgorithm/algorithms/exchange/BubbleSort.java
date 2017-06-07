package com.sort.tao.sortalgorithm.algorithms.exchange;

import android.util.Log;

import com.sort.tao.sortalgorithm.utils.Sort;
import com.sort.tao.sortalgorithm.utils.SortSend;

import java.util.ArrayList;

/**
 * 冒泡排序(改进版)
 *
 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 *
 * Created by tao on 2017/6/6.
 */

public class BubbleSort implements Sort {
    private static final String TAG = BubbleSort.class.getSimpleName();

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> numbers, SortSend sortSend) {
        for (int j = numbers.size(); j > 1; j--) {
            boolean changeFlag = false;
            for (int i = 0; i < j - 1; i++) {
                if (numbers.get(i) > numbers.get(i + 1)) {
                    if (sortSend == SortSend.Ascend) {
                        changeFlag = true;
                        int x = numbers.get(i);
                        numbers.set(i, numbers.get(i + 1));
                        numbers.set(i + 1, x);
                    }
                } else if (numbers.get(i) < numbers.get(i + 1)) {
                    if (sortSend == SortSend.Descend) {
                        changeFlag = true;
                        int x = numbers.get(i);
                        numbers.set(i, numbers.get(i + 1));
                        numbers.set(i + 1, x);
                    }
                }
            }
            if (!changeFlag) {
                //如果没有进行交换，说明已经排序完成，不需要再继续循环
                Log.e(TAG, "已经排序完成，不需要再继续循环。 j = " + j);
                break;
            }
        }
        return numbers;
    }
}
