package com.sort.tao.sortalgorithm.utils;

/**
 * Created by tao on 2017/6/6.
 */

public enum SortAlgorithm {
    StraightInsertionSort("直接插入排序"),ShellSort("希尔排序"),SimpleSelectionSort("简单选择排序"),HeapSort("堆排序"),BubbleSort("冒泡排序"),QuickSort("快速排序"),MergeSort("归并排序"),RadixSort("基数排序");
    private String algorithmText;
    SortAlgorithm(String algorithmText){
        this.algorithmText = algorithmText;
    }

    public String getAlgorithmText() {
        return algorithmText;
    }

    public static SortAlgorithm getAlgorithmByContent(String content){
        if(content == null){
            return null;
        }else if(content.equals(StraightInsertionSort.getAlgorithmText())){
            return StraightInsertionSort;
        }else if(content.equals(ShellSort.getAlgorithmText())){
            return ShellSort;
        }else if(content.equals(SimpleSelectionSort.getAlgorithmText())){
            return SimpleSelectionSort;
        }else if(content.equals(HeapSort.getAlgorithmText())){
            return HeapSort;
        }else if(content.equals(BubbleSort.getAlgorithmText())){
            return BubbleSort;
        }else if(content.equals(QuickSort.getAlgorithmText())){
            return QuickSort;
        }else if(content.equals(MergeSort.getAlgorithmText())){
            return MergeSort;
        }else if(content.equals(RadixSort.getAlgorithmText())){
            return RadixSort;
        }else{
            return null;
        }
    }
}
