package com.sort.tao.sortalgorithm.algorithms.exchange;

import android.util.Log;

import com.sort.tao.sortalgorithm.utils.ArrayUtil;
import com.sort.tao.sortalgorithm.utils.Sort;
import com.sort.tao.sortalgorithm.utils.SortSend;

import java.util.ArrayList;

/**
 * 快速排序
 * <p>
 * 1）选择一个基准元素,通常选择第一个元素或者最后一个元素,
 * 2）通过一趟排序讲待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小。另一部分记录的 元素值比基准值大。
 * 3）此时基准元素在其排好序后的正确位置
 * 4）然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。
 * * Created by tao on 2017/6/6.
 */

public class QuickSort implements Sort {
    private static final String TAG = Sort.class.getSimpleName();

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> numbers, SortSend sortSend) {
        return fastSort(numbers, 0, numbers.size() - 1, sortSend);
    }

    private ArrayList<Integer> fastSort(ArrayList<Integer> numbers, int lowIndex, int highIndex, SortSend sortSend) {
        int partitionIndex = partition(numbers, lowIndex, highIndex, sortSend);
        Log.e(TAG, ArrayUtil.makeString(numbers));
        if (partitionIndex - 1 >= 0 && lowIndex < partitionIndex - 1 && lowIndex < partitionIndex - 1) {
            fastSort(numbers, lowIndex, partitionIndex - 1, sortSend);
        }
        if (partitionIndex + 1 <= numbers.size() - 1 && partitionIndex + 1 < highIndex && partitionIndex + 1 < highIndex) {
            fastSort(numbers, partitionIndex + 1, highIndex, sortSend);
        }
        return numbers;
    }

    /**
     * 返回pivot
     *
     * @param numbers
     * @param sortSend
     * @return
     */
    private int partition(ArrayList<Integer> numbers, int lowIndex, int highIndex, SortSend sortSend) {
        while (lowIndex < highIndex) {
            Log.e(TAG, "lowIndex = " + lowIndex + " ; highIndex = " + highIndex);
            if (sortSend == SortSend.Ascend) {
                //升序排列
                while (numbers.get(lowIndex) <= numbers.get(highIndex)) {
                    if (highIndex > 0) {
                        highIndex--;
                    } else {
                        break;
                    }
                }
                //较大的数放到后面
                ArrayUtil.changeIndexNumber(numbers, lowIndex, highIndex);
                while (numbers.get(highIndex) >= numbers.get(lowIndex)) {
                    if (lowIndex < numbers.size() - 1) {
                        lowIndex++;
                    } else {
                        break;
                    }
                }
                //较小的数放到前面
                ArrayUtil.changeIndexNumber(numbers, lowIndex, highIndex);
            } else if (sortSend == SortSend.Descend) {
                //降序排列
                while (numbers.get(lowIndex) >= numbers.get(highIndex)) {
                    if (highIndex > 0) {
                        highIndex--;
                    } else {
                        break;
                    }
                }
                //较小的数放到后面
                ArrayUtil.changeIndexNumber(numbers, lowIndex, highIndex);
                while (numbers.get(highIndex) <= numbers.get(lowIndex)) {
                    if (lowIndex < numbers.size() - 1) {
                        lowIndex++;
                    } else {
                        break;
                    }
                }
                //较大的数放到前面
                ArrayUtil.changeIndexNumber(numbers, lowIndex, highIndex);
            }
        }
        Log.e(TAG, "lowIndex = " + lowIndex);
        return lowIndex;
    }
}
