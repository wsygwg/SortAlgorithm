package com.sort.tao.sortalgorithm.algorithms.insert;

import com.sort.tao.sortalgorithm.utils.Sort;
import com.sort.tao.sortalgorithm.utils.SortSend;

import java.util.ArrayList;

/**
 * 直接插入排序
 * <p>
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止
 * Created by tao on 2017/6/6.
 */

public class StraightInsertionSort implements Sort {

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> numbers, SortSend sortSend) {
        ArrayList<Integer> retArray = new ArrayList<>();
        retArray.add(numbers.get(0));
        if (sortSend == SortSend.Ascend) {
            //升序
            for (int i = 1; i < numbers.size(); i++) {
                int currentNum = numbers.get(i);
                for (int j = 0; j < retArray.size(); j++) {
                    if (currentNum <= retArray.get(j)) {
                        retArray.add(j, currentNum);
                        break;
                    }else{
                        if(j == retArray.size() -1){
                            retArray.add(currentNum);
                            break;
                        }
                    }
                }
            }
        } else {
            //降序
            for (int i = 1; i < numbers.size(); i++) {
                int currentNum = numbers.get(i);
                for (int j = 0; j < retArray.size(); j++) {
                    if (currentNum >= retArray.get(j)) {
                        retArray.add(j, currentNum);
                        break;
                    }else{
                        if(j == retArray.size() -1){
                            retArray.add(currentNum);
                            break;
                        }
                    }
                }
            }
        }
        return retArray;
    }
}
