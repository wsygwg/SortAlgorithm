package com.sort.tao.sortalgorithm.algorithms.exchange;

import com.sort.tao.sortalgorithm.utils.Sort;
import com.sort.tao.sortalgorithm.utils.SortSend;

import java.util.ArrayList;

/**
 * 快速排序
 * Created by tao on 2017/6/6.
 */

public class QuickSort implements Sort {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> numbers, SortSend sortSend) {
        return null;
    }

    private static void Fast(int[] array, int left, int right) {
        if (left < right) {
            int p = Partition1(array, left, right);
            Fast(array, left, p - 1);
            Fast(array, p + 1, right);
        }
//      if (left < right) {
//          int p = Partition2(array, left, right);
//          Fast(array, left, p - 1);
//          Fast(array, p + 1, right);
//      }
    }

    private static int Partition1(int[] array, int left, int right) {
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

//    private static int Partition2(int[] array, int start, int end) {
//        int pivot = array[start];
//        int left = start, right = end;
//        while (left <= right) {
//            while (left <= right && array[left] <= pivot) {
//                left++;
//            }
//            while (left <= right && array[right] >= pivot) {
//                right--;
//            }
//            if (left < right) {
//                Swap(array[right], array[left]);
//                left++;
//                right--;
//            }
//        }
//        Swap(array[start], array[right]);
//        return right;
//    }
//    static void Swap(int a,int b){
//
//    }
}
