package com.sort.tao.sortalgorithm.algorithms.select;

import com.sort.tao.sortalgorithm.utils.Sort;
import com.sort.tao.sortalgorithm.utils.SortSend;

import java.util.ArrayList;

/**
 * 堆排序
 * Created by tao on 2017/6/6.
 */

public class HeapSort implements Sort {

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> numbers, SortSend sortSend) {
        heapSort(numbers, sortSend);
        return numbers;
    }

    public void HeapAdjust(ArrayList<Integer> array, int parent, int length, SortSend sortSend) {
        int temp = array.get(parent); // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子
        while (child < length) {
            if (sortSend == SortSend.Ascend) {
                // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
                if (child + 1 < length && array.get(child) < array.get(child + 1)) {
                    child++;
                }
                // 如果父结点的值已经大于孩子结点的值，则直接结束
                if (temp >= array.get(child))
                    break;
            } else {
                // 如果有右孩子结点，并且右孩子结点的值小于左孩子结点，则选取右孩子结点
                if (child + 1 < length && array.get(child) > array.get(child + 1)) {
                    child++;
                }
                // 如果父结点的值已经小于孩子结点的值，则直接结束
                if (temp <= array.get(child))
                    break;
            }
            // 把孩子结点的值赋给父结点
            array.set(parent, array.get(child));
            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        array.set(parent, temp);
    }

    public void heapSort(ArrayList<Integer> list, SortSend sortSend) {
        // 循环建立初始堆
        for (int i = list.size() / 2; i >= 0; i--) {
            HeapAdjust(list, i, list.size() - 1, sortSend);
        }
        // 进行n-1次循环，完成排序
        for (int i = list.size() - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = list.get(i);
            list.set(i, list.get(0));
            list.set(0, temp);
            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(list, 0, i, sortSend);
            System.out.format("第 %d 趟: \t", list.size() - i);
//            printPart(list, 0, list.length - 1);
        }
    }
}
