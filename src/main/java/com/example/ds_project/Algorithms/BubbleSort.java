package com.example.ds_project.Algorithms;
import com.example.ds_project.helpers.ArraysHandler;

import java.util.Vector;

public class BubbleSort
{
    public  int bubbleSort() {
         Vector<Integer> unsortedNumbersBubble = new Vector<Integer>();

         int step=0;

        for (Integer unsortedNumber : ArraysHandler.unsortedNumbers) {
            unsortedNumbersBubble.addElement(unsortedNumber);
        }

        int n = unsortedNumbersBubble.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (unsortedNumbersBubble.get(j) > unsortedNumbersBubble.get(j + 1)) {
                    int temp = unsortedNumbersBubble.get(j);
                    unsortedNumbersBubble.set(j, unsortedNumbersBubble.get(j + 1));
                    unsortedNumbersBubble.set(j + 1, temp);
                    step+=3;
                }

        for (int i = 0; i <unsortedNumbersBubble.size() ; i++) {
            System.out.println(unsortedNumbersBubble.get(i));
        }

        return step;
    }

    public int callAsymptotic(){
       int x = ArraysHandler.unsortedNumbers.size();
      return  x * x;
    }



 }