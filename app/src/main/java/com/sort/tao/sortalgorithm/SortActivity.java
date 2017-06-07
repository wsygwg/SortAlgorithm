package com.sort.tao.sortalgorithm;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.sort.tao.sortalgorithm.algorithms.MergeSort;
import com.sort.tao.sortalgorithm.algorithms.RadixSort;
import com.sort.tao.sortalgorithm.algorithms.exchange.BubbleSort;
import com.sort.tao.sortalgorithm.algorithms.exchange.QuickSort;
import com.sort.tao.sortalgorithm.algorithms.insert.ShellSort;
import com.sort.tao.sortalgorithm.algorithms.insert.StraightInsertionSort;
import com.sort.tao.sortalgorithm.algorithms.select.HeapSort;
import com.sort.tao.sortalgorithm.algorithms.select.StraightSelectionSort;
import com.sort.tao.sortalgorithm.utils.ArrayUtil;
import com.sort.tao.sortalgorithm.utils.Sort;
import com.sort.tao.sortalgorithm.utils.SortAlgorithm;
import com.sort.tao.sortalgorithm.utils.SortSend;

import java.util.ArrayList;
import java.util.Random;

public class SortActivity extends AppCompatActivity {

    private TextView textViewBeforeSort, textViewAfterSort;
    private Spinner spinnerSortMethod;
    private RadioGroup radioGroup;
    private RadioButton radioButtonAscend,radioButtonDescend;
    private Button buttonGenerate, buttonSort;
    private SortAlgorithm currentAlgorithm = SortAlgorithm.StraightInsertionSort;
    private SortSend sortSend = SortSend.Ascend;
    private ArrayList<Integer> unSortedNumbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        initViews();
        addListeners();
    }

    private void initViews() {
        textViewBeforeSort = (TextView) findViewById(R.id.textViewBeforeSort);
        textViewAfterSort = (TextView) findViewById(R.id.textViewAfterSort);
        spinnerSortMethod = (Spinner) findViewById(R.id.spinnerSortMethod);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonAscend = (RadioButton)findViewById(R.id.radioButtonAscend);
        radioButtonDescend = (RadioButton)findViewById(R.id.radioButtonDescend);
        buttonGenerate = (Button) findViewById(R.id.buttonGenerate);
        buttonSort = (Button) findViewById(R.id.buttonSort);
    }

    private void addListeners() {
        final ArrayList<String> datas = new ArrayList<>();
        datas.add(SortAlgorithm.StraightInsertionSort.getAlgorithmText());
        datas.add(SortAlgorithm.ShellSort.getAlgorithmText());
        datas.add(SortAlgorithm.SimpleSelectionSort.getAlgorithmText());
        datas.add(SortAlgorithm.HeapSort.getAlgorithmText());
        datas.add(SortAlgorithm.BubbleSort.getAlgorithmText());
        datas.add(SortAlgorithm.QuickSort.getAlgorithmText());
        datas.add(SortAlgorithm.MergeSort.getAlgorithmText());
        datas.add(SortAlgorithm.RadixSort.getAlgorithmText());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SortActivity.this, android.R.layout.simple_spinner_item, datas);
        spinnerSortMethod.setAdapter(arrayAdapter);
        spinnerSortMethod.setSelection(0);
        spinnerSortMethod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentAlgorithm = SortAlgorithm.getAlgorithmByContent(datas.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        radioButtonAscend.setChecked(true); //默认升序排列
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId == R.id.radioButtonAscend){
                    sortSend = SortSend.Ascend;
                }else if(checkedId == R.id.radioButtonDescend){
                    sortSend = SortSend.Descend;
                }
            }
        });
        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupDatas();
            }
        });
        buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortLogic(unSortedNumbers);
            }
        });
    }

    private void setupDatas() {
        if (unSortedNumbers.size() > 0) {
            unSortedNumbers.clear();
        }
        int count = getRandom(2,50);
        ArrayList<Integer> arrayList = createNums(count);
        unSortedNumbers.addAll(arrayList);
        String s = ArrayUtil.makeString(unSortedNumbers);
        textViewBeforeSort.setText(s);
    }

    private void sortLogic(ArrayList<Integer> beforeData){
        try{
            ArrayList<Integer> afterData = sortByAlgorithm(currentAlgorithm,beforeData);
            String s = ArrayUtil.makeString(afterData);
            textViewAfterSort.setText(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private ArrayList<Integer> sortByAlgorithm(SortAlgorithm sortAlgorithm,ArrayList<Integer> beforeData){
        ArrayList<Integer> afterData = new ArrayList<>();
        for(Integer i : beforeData){
            afterData.add(i.intValue());
        }
        Sort sort = getAlogrithmMethod(sortAlgorithm);
        return sort.sort(afterData,sortSend);
    }

    private Sort getAlogrithmMethod(SortAlgorithm sortAlgorithm){
        Sort sort;
        switch(sortAlgorithm){
            case StraightInsertionSort:
                sort =  new StraightInsertionSort();
                break;
            case ShellSort:
                sort =  new ShellSort();
                break;
            case SimpleSelectionSort:
                sort =  new StraightSelectionSort();
                break;
            case HeapSort:
                sort =  new HeapSort();
                break;
            case BubbleSort:
                sort =  new BubbleSort();
                break;
            case QuickSort:
                sort =  new QuickSort();
                break;
            case MergeSort:
                sort =  new MergeSort();
                break;
            case RadixSort:
                sort =  new RadixSort();
                break;
            default:
                sort =  new StraightInsertionSort();
                break;
        }
        return sort;
    }

    private ArrayList<Integer> createNums(int count) {
        ArrayList<Integer> retArray = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            retArray.add(random.nextInt(100));
        }
        return retArray;
    }

    public static int getRandom(int min, int max){
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }
}
