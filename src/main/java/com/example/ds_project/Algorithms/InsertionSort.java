package com.example.ds_project.Algorithms;



import com.example.ds_project.helpers.ArraysHandler;

import java.util.Vector;

public class InsertionSort {


    Vector<Integer> unsortedNumbersInsertion= new Vector<Integer>();

   public int sort()
    {
        int step=0;

        for (Integer unsortedNumber : ArraysHandler.unsortedNumbers) {
            unsortedNumbersInsertion.addElement(unsortedNumber);
        }

        int n = unsortedNumbersInsertion.size();
        step++;

        for (int i = 1; i < n; ++i) {
            int key = unsortedNumbersInsertion.get(i);
            int j = i - 1;
            step+=2;

            while (j >= 0 && unsortedNumbersInsertion.get(j) > key) {
                unsortedNumbersInsertion.set(j + 1, unsortedNumbersInsertion.get(j));
                j = j - 1;
                step+=2;
            }
            unsortedNumbersInsertion.set(j + 1, key);
            step++;
        }


        for (int i = 0; i <unsortedNumbersInsertion.size() ; i++) {
            System.out.println(unsortedNumbersInsertion.get(i));
        }
        return step;
    }

    public int callAsymptotic(){
        int x = ArraysHandler.unsortedNumbers.size();
        return x * x;

    }
}