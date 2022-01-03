package com.example.ds_project.Algorithms;


import com.example.ds_project.helpers.ArraysHandler;

import java.util.Arrays;
import java.util.Vector;

public class Radix {

    int step=0;
    Vector<Integer> unsortedNumbersRadix = new Vector<Integer>();

     int getMax( int n)
    {
        int mx = unsortedNumbersRadix.get(0);
        step++;
        for (int i = 1; i < n; i++)
            if (unsortedNumbersRadix.get(i) > mx) {
                mx = unsortedNumbersRadix.get(i);
                step++;
            }

        return mx;
    }

     void countSort( int n, int exp)
    {
        int output[] = new int[n]; // output unsortedNumbersRadixay
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        step+=4;
        for (i = 0; i < n; i++) {
            count[(unsortedNumbersRadix.get(i) / exp) % 10]++;
            step++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            step++;
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(unsortedNumbersRadix.get(i) / exp) % 10] - 1] = unsortedNumbersRadix.get(i);
            count[(unsortedNumbersRadix.get(i) / exp) % 10]--;
            step+=2;
        }

        for (i = 0; i < n; i++) {
            unsortedNumbersRadix.set(i, output[i]);
            step++;
        }
    }

     void radixsort( int n)
    {
        int m = getMax( n);
        step++;

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort( n, exp);

    }

 public    int callRadix(){
        for (Integer unsortedNumber : ArraysHandler.unsortedNumbers) {
            unsortedNumbersRadix.addElement(unsortedNumber);
        }
        radixsort(unsortedNumbersRadix.size());

     for (int i = 0; i <unsortedNumbersRadix.size() ; i++) {
         System.out.println(unsortedNumbersRadix.get(i));
     }
        return step;
    }

    public int callAsymptotic(){
        int x = ArraysHandler.unsortedNumbers.size();
        return  x+x;

    }
}