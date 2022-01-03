package com.example.ds_project.Algorithms;



import com.example.ds_project.helpers.ArraysHandler;

import java.util.Vector;

public class SelectionSort
{
    public int sort()
    {

        int step=0;
        Vector<Integer> unsortedNumbersSelection = new Vector<Integer>();

        for (Integer unsortedNumber : ArraysHandler.unsortedNumbers) {
            unsortedNumbersSelection.addElement(unsortedNumber);
        }

        int n = unsortedNumbersSelection.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            step++;
            for (int j = i+1; j < n; j++)
                if (unsortedNumbersSelection.get(j) < unsortedNumbersSelection.get(min_idx)) {
                    min_idx = j;
                    step++;
                }

            // Swap the found minimum element with the first
            // element
            int temp = unsortedNumbersSelection.get(min_idx);
            unsortedNumbersSelection.set(min_idx, unsortedNumbersSelection.get(i));
            unsortedNumbersSelection.set(i, temp);
            step+=3;
        }


        for(int i=0;i<1000;i++){

            System.out.println(unsortedNumbersSelection.get(i));
        }
        return step;
    }

    public int callAsymptotic(){
        int x = ArraysHandler.unsortedNumbers.size();
        return x * x;

    }
}
