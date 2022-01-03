package com.example.ds_project.helpers;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Vector;

public class ArraysHandler {
   public static Vector<Integer> unsortedNumbers = new Vector<Integer>();


    //alorithm 1
    public static Vector<Integer> x1 = new Vector<Integer>();
    public static Vector<Integer> y1 = new Vector<Integer>();

    //alorithm 2
    public static Vector<Integer> x2 = new Vector<Integer>();
    public static Vector<Integer> y2 = new Vector<Integer>();

   public void createArrayWithGivenNum(int x){
        Random rand = new Random();
        unsortedNumbers.removeAllElements();
        int upperbound = 10000;
        for (int i =0;i<x;i++){
            unsortedNumbers.addElement(rand.nextInt(upperbound));
        }
    }



}
