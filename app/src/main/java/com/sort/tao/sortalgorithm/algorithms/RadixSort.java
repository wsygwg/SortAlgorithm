package com.sort.tao.sortalgorithm.algorithms;

import com.sort.tao.sortalgorithm.utils.Sort;
import com.sort.tao.sortalgorithm.utils.SortSend;

import java.util.ArrayList;

/**
 * 桶排序、基数排序
 *
 * 基本思想：
 * 是将阵列分到有限数量的桶子里。每个桶子再个别排序（有可能再使用别的排序算法或是以递回方式继续使用桶排序进行排序）。
 * 桶排序是鸽巢排序的一种归纳结果。当要被排序的阵列内的数值是均匀分配的时候，桶排序使用线性时间（Θ（n））。但桶排序并不是 比较排序，他不受到 O(n log n) 下限的影响。
 * 简单来说，就是把数据分组，放在一个个的桶中，然后对每个桶里面的在进行排序。
 * @author tao
 *
 */
public class RadixSort implements Sort {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> numbers, SortSend sortSend) {
        return null;
    }
}
