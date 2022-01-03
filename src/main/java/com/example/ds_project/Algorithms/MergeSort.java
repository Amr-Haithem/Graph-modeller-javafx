package com.example.ds_project.Algorithms;




import com.example.ds_project.helpers.ArraysHandler;

import java.util.Vector;

public class MergeSort
{


    int step=0;
    Vector<Integer> unsortedNumbersMerge = new Vector<Integer>();

    void merge( int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        step+=2;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
        step+=2;

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = unsortedNumbersMerge.get(l + i);
            step++;
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = unsortedNumbersMerge.get(m + 1 + j);
            step++;
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        int k = l;
        step+=3;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                unsortedNumbersMerge.set(k, L[i]);
                i++;
                step+=2;
            }
            else {
                unsortedNumbersMerge.set(k, R[j]);
                j++;
                step+=2;
            }
            k++;
            step++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            unsortedNumbersMerge.set(k, L[i]);
            i++;
            k++;
            step+=3;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            unsortedNumbersMerge.set(k, R[j]);
            j++;
            k++;

            step+=3;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort( int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
            step++;
            sort(l, m);
            sort(m + 1, r);
            merge( l, m, r);
        }
    }

    public  int callMergeSort(){
        for (Integer unsortedNumber : ArraysHandler.unsortedNumbers) {
            unsortedNumbersMerge.addElement(unsortedNumber);
        }
        sort(0,unsortedNumbersMerge.size()-1);
        System.out.println("size of the sorted array is"+unsortedNumbersMerge.size());
        for (int i = 0; i <unsortedNumbersMerge.size() ; i++) {
            System.out.println(unsortedNumbersMerge.get(i));
        }
        return step;
    }

    public int callAsymptotic(){
        int x = ArraysHandler.unsortedNumbers.size();
        return (int) (x * Math.log(x));
    }
}
