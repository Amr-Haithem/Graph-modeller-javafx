package com.example.ds_project.Algorithms;

import com.example.ds_project.helpers.ArraysHandler;

import java.util.Vector;

public class HeapSort {


    int step=0;
    Vector<Integer> unsortedNumbersHeap = new Vector<Integer>();


    public void sort()
    {


        int n = unsortedNumbersHeap.size();
        step++;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify( n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = unsortedNumbersHeap.get(0);
            unsortedNumbersHeap.set(0, unsortedNumbersHeap.get(i));
            unsortedNumbersHeap.set(i, temp);
            step+=3;
            heapify( i, 0);
        }
    }
    void heapify( int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2;
        step+=3;

        if (l < n && unsortedNumbersHeap.get(l) > unsortedNumbersHeap.get(largest)){

            largest = l;
            step++;

        }
        if (r < n && unsortedNumbersHeap.get(r) > unsortedNumbersHeap.get(largest)){
            largest = r;
            step++;
        }
        if (largest != i) {
            int swap = unsortedNumbersHeap.get(i);
            unsortedNumbersHeap.set(i, unsortedNumbersHeap.get(largest));
            unsortedNumbersHeap.set(largest, swap);
            step+=3;
            heapify( n, largest);
        }
    }
    public  int callHeapSort(){
        for (Integer unsortedNumber : ArraysHandler.unsortedNumbers) {
            unsortedNumbersHeap.addElement(unsortedNumber);
        }
        sort();

        for (int i = 0; i <unsortedNumbersHeap.size() ; i++) {
            System.out.println(unsortedNumbersHeap.get(i));
        }
        return step;
    }
    public int callAsymptotic(){
        int x = ArraysHandler.unsortedNumbers.size();
        return (int) (x * Math.log(x));

    }
}