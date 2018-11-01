package com.sort.tao.sortalgorithm.algorithms.insert;

import com.sort.tao.sortalgorithm.utils.Sort;
import com.sort.tao.sortalgorithm.utils.SortSend;

import java.util.ArrayList;

/**
 * 希尔排序
 * <p>
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序
 * Created by tao on 2017/6/6.
 */

public class ShellSort implements Sort {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> numbers, SortSend sortSend) {
        //希尔排序
        int d = numbers.size();
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < numbers.size(); i = i + d) {
                    int temp = numbers.get(i);
                    int j;
                    for (j = i - d; j >= 0 && (sortSend == SortSend.Ascend) ? (numbers.get(j) > temp) : (numbers.get(j) < temp); j = j - d) {
                        numbers.set(j + d, numbers.get(j));
                    }
                    numbers.set(j + d, temp);
                }
            }
            if (d == 1) {
                break;
            }
        }
        System.out.println();
        System.out.println("希尔排序之后：");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        return numbers;
    }
}
