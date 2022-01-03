package com.example.ds_project.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations{


public void createFileWithUnsortedRandomNums(int x) throws IOException {
    try {
        File unsortedFile = new File("D:\\University\\Junior\\projects\\teraven_function_modeller\\src\\main\\java\\com\\example\\teraven_function_modeler\\helpers\\files\\unsorted.txt");
        if (unsortedFile.createNewFile()) {
            System.out.println("File created: " + unsortedFile.getName());
        } else {
            System.out.println("File already exists.");
        }
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }




    FileWriter unsortedFile = new FileWriter("D:\\University\\Junior\\projects\\teraven_function_modeller\\src\\main\\java\\com\\example\\teraven_function_modeler\\helpers\\files\\unsorted.txt");
try{
        while(x<0){
            x--;
        unsortedFile.write(x);
        }

}

catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }}


    void getUnsortedFile(){
     try {
          File unsortedFile = new File("unsorted.txt");

          Scanner myReader = new Scanner(unsortedFile);

          /*while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
          }
          myReader.close();*/
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }


}