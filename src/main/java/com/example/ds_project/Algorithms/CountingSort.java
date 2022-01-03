package com.example.ds_project.Algorithms;

// Counting sort in Java programming

import com.example.ds_project.helpers.ArraysHandler;


import java.util.Vector;

public class CountingSort {

    public   int countingSort() {

        int step=0;
        Vector<Integer> unsortedNumbersCounting = new Vector<Integer>();

        for (Integer unsortedNumber : ArraysHandler.unsortedNumbers) {
            unsortedNumbersCounting.addElement(unsortedNumber);
        }

        int[] output = new int[unsortedNumbersCounting.size() + 1];

        // Find the largest element of the array
        int max = unsortedNumbersCounting.get(0);
        for (int i = 1; i < unsortedNumbersCounting.size(); i++) {
            if (unsortedNumbersCounting.get(i) > max) {
                max = unsortedNumbersCounting.get(i);
                step++;
            }
        }
        int[] count = new int[max + 1];
        step++;
        // Initialize count unsortedNumbersCounting with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
            step++;
        }

        // Store the count of each element
        for (int i = 0; i < unsortedNumbersCounting.size(); i++) {
            count[unsortedNumbersCounting.get(i)]++;
            step++;
        }

        // Store the cummulative count of each unsortedNumbersCounting
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            step++;
        }

        // Find the index of each element of the original unsortedNumbersCounting in count unsortedNumbersCounting, and
        // place the elements in output unsortedNumbersCounting
        for (int i = unsortedNumbersCounting.size() - 1; i >= 0; i--) {
            output[count[unsortedNumbersCounting.get(i)] - 1] = unsortedNumbersCounting.get(i);
            count[unsortedNumbersCounting.get(i)]--;
            step+=2;
        }

        // Copy the sorted elements into original unsortedNumbersCounting
        for (int i = 0; i < unsortedNumbersCounting.size(); i++) {
            unsortedNumbersCounting.set(i, output[i]);
            step++;
        }

        for (int i = 0; i <unsortedNumbersCounting.size() ; i++) {
            System.out.println(unsortedNumbersCounting.get(i));
        }
        return step;
    }
    public int callAsymptotic(){
        int x = ArraysHandler.unsortedNumbers.size();
        return (int) (x * Math.log(x));

    }

}