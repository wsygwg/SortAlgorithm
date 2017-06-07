package com.sort.tao.sortalgorithm.algorithms.exchange;

import android.util.Log;

import com.sort.tao.sortalgorithm.utils.ArrayUtil;
import com.sort.tao.sortalgorithm.utils.Sort;
import com.sort.tao.sortalgorithm.utils.SortSend;

import java.util.ArrayList;

/**
 * 快速排序
 * Created by tao on 2017/6/6.
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
                changeIndexNumber(numbers, lowIndex, highIndex);
                while (numbers.get(highIndex) >= numbers.get(lowIndex)) {
                    if (lowIndex < numbers.size() - 1) {
                        lowIndex++;
                    } else {
                        break;
                    }
                }
                //较小的数放到前面
                changeIndexNumber(numbers, lowIndex, highIndex);
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
                changeIndexNumber(numbers, lowIndex, highIndex);
                while (numbers.get(highIndex) <= numbers.get(lowIndex)) {
                    if (lowIndex < numbers.size() - 1) {
                        lowIndex++;
                    } else {
                        break;
                    }
                }
                //较大的数放到前面
                changeIndexNumber(numbers, lowIndex, highIndex);
            }
        }
        Log.e(TAG, "lowIndex = " + lowIndex);
        return lowIndex;
    }

    private void changeIndexNumber(ArrayList<Integer> array, int indexA, int indexB) {
        if (indexA < indexB) {
            int indexANumber = array.get(indexA);
            array.set(indexA, array.get(indexB));
            array.set(indexB, indexANumber);
        }
    }
}
