package com.example.ds_project.Algorithms;
// Java implementation of QuickSort
import com.example.ds_project.helpers.ArraysHandler;


import java.util.Vector;

public class QuickSort{

    int step=0;
    Vector<Integer> unsortedNumbersQuick = new Vector<Integer>();

     void swap( int i, int j)
    {
        int temp = unsortedNumbersQuick.get(i);
        unsortedNumbersQuick.set(i, unsortedNumbersQuick.get(j));
        unsortedNumbersQuick.set(j, temp);
        step+=3;
    }
     int partition( int low, int high)
    {
        int pivot = unsortedNumbersQuick.get(high);
        int i = (low - 1);
        step+=2;

        for(int j = low; j <= high - 1; j++)
        {
            if (unsortedNumbersQuick.get(j) < pivot)
            {
                i++;
                swap( i, j);
                step+=2;
            }
        }
        swap( i + 1, high);
        return (i + 1);
    }
     void quickSort( int low, int high)
    {
        if (low < high)
        {
            int pi = partition( low, high);
            quickSort( low, pi - 1);
            quickSort( pi + 1, high);
        }
    }


    public int callQuickSort(){
        for (Integer unsortedNumber : ArraysHandler.unsortedNumbers) {
            unsortedNumbersQuick.addElement(unsortedNumber);
        }
        quickSort(0,unsortedNumbersQuick.size()-1);
        for (int i = 0; i <unsortedNumbersQuick.size() ; i++) {
            System.out.println(unsortedNumbersQuick.get(i));
        }

        for (int i = 0; i <unsortedNumbersQuick.size() ; i++) {
            System.out.println(unsortedNumbersQuick.get(i));
        }
        return step;
    }

    public int callAsymptotic(){
        int x = ArraysHandler.unsortedNumbers.size();
        return x *x ;

    }

}