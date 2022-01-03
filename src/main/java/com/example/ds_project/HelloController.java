package com.example.ds_project;

import com.example.ds_project.Algorithms.*;
import com.example.ds_project.helpers.ArraysHandler;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField arraySizeTextfield;
    @FXML
    private TextField stepSize;
    @FXML
    private Button generateButton;

    @FXML
    private ComboBox<String> leftList;

    @FXML
    private ComboBox<String> rightList;
    int arraySize;


    @FXML
    void extractDataOfSortingAlgorithm(ActionEvent event) {
        String textOfLeftList=leftList.getSelectionModel().getSelectedItem();
        String textOfRightList=rightList.getSelectionModel().getSelectedItem();

        ArraysHandler.x1.removeAllElements();
        ArraysHandler.y1.removeAllElements();
        ArraysHandler.x2.removeAllElements();
        ArraysHandler.y2.removeAllElements();

        try {
            if(textOfLeftList==null || textOfRightList==null){
                throw new Exception("choose an algorithm");
            };
            if (isNumbers(arraySizeTextfield.getText()) && isNumbers(stepSize.getText())) {
                arraySize = Integer.parseInt(arraySizeTextfield.getText());
            } else throw new Exception("enter a valid array and step size");

            if (textOfLeftList=="its asymptotic" && textOfRightList=="its asymptotic") throw new Exception("choose at least one algorithm");

            extractDataOfSortingAlgorithms(arraySize,textOfLeftList,textOfRightList);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.toString());
            alert.showAndWait();
            System.out.println(e);
        }
    }

    void chooseAndUseAnAlgorithmForArray1(String requestedAlgorithmLeft,String requestedAlgorithmRight){
        if (requestedAlgorithmLeft=="Radix Sort"){
            Radix m = new Radix();
            ArraysHandler.y1.addElement(m.callRadix());
        }
        else if(requestedAlgorithmLeft== "Bubble sort"){

            BubbleSort m = new BubbleSort();
            ArraysHandler.y1.addElement(m.bubbleSort());
        }
        else if(requestedAlgorithmLeft=="Counting sort"){

            CountingSort m = new CountingSort();
            ArraysHandler.y1.addElement(m.countingSort());
        }
        else if(requestedAlgorithmLeft=="Heap sort"){

            HeapSort m = new HeapSort();
            ArraysHandler.y1.addElement(m.callHeapSort());
        }
        else if(requestedAlgorithmLeft=="Insertion sort"){

            InsertionSort m = new InsertionSort();
            ArraysHandler.y1.addElement(m.sort());

        }
        else if(requestedAlgorithmLeft=="Merge sort"){

            MergeSort m = new MergeSort();
            ArraysHandler.y1.addElement(m.callMergeSort());
        }
        else if(requestedAlgorithmLeft=="Quick sort"){

            QuickSort m = new QuickSort();
            ArraysHandler.y1.addElement(m.callQuickSort());

        }
        else if(requestedAlgorithmLeft=="Selection sort"){

            SelectionSort m = new SelectionSort();
            ArraysHandler.y1.addElement(m.sort());

        }
        else{
            if (requestedAlgorithmRight=="Radix Sort"){

                Radix m = new Radix();
                ArraysHandler.y1.addElement(m.callAsymptotic());
            }
            else if(requestedAlgorithmRight== "Bubble sort"){

                BubbleSort m = new BubbleSort();
                ArraysHandler.y1.addElement(m.callAsymptotic());

            }
            else if(requestedAlgorithmRight=="Counting sort"){

                CountingSort m = new CountingSort();
                ArraysHandler.y1.addElement(m.callAsymptotic());
            }
            else if(requestedAlgorithmRight=="Heap sort"){

                HeapSort m = new HeapSort();
                ArraysHandler.y1.addElement(m.callAsymptotic());
            }
            else if(requestedAlgorithmRight=="Insertion sort"){

                InsertionSort m = new InsertionSort();
                ArraysHandler.y1.addElement(m.callAsymptotic());
            }
            else if(requestedAlgorithmRight=="Merge sort"){

                MergeSort m = new MergeSort();
                ArraysHandler.y1.addElement(m.callAsymptotic());
            }
            else if(requestedAlgorithmRight=="Quick sort"){

                QuickSort m = new QuickSort();
                ArraysHandler.y1.addElement(m.callAsymptotic());

            }
            else if(requestedAlgorithmRight=="Selection sort"){

                SelectionSort m = new SelectionSort();
                ArraysHandler.y1.addElement(m.callAsymptotic());

            }
        }

    }

    void chooseAndUseAnAlgorithmForArray2(String requestedAlgorithmLeft,String requestedAlgorithmRight){
        if (requestedAlgorithmRight=="Radix Sort"){

            Radix m = new Radix();
            ArraysHandler.y2.addElement(m.callRadix());
        }
        else if(requestedAlgorithmRight== "Bubble sort"){

            BubbleSort m = new BubbleSort();
            ArraysHandler.y2.addElement(m.bubbleSort());
        }
        else if(requestedAlgorithmRight=="Counting sort"){

            CountingSort m = new CountingSort();
            ArraysHandler.y2.addElement(m.countingSort());
        }
        else if(requestedAlgorithmRight=="Heap sort"){

            HeapSort m = new HeapSort();
            ArraysHandler.y2.addElement(m.callHeapSort());
        }
        else if(requestedAlgorithmRight=="Insertion sort"){

            InsertionSort m = new InsertionSort();
            ArraysHandler.y2.addElement(m.sort());

        }
        else if(requestedAlgorithmRight=="Merge sort"){

            MergeSort m = new MergeSort();
            ArraysHandler.y2.addElement(m.callMergeSort());
        }
        else if(requestedAlgorithmRight=="Quick sort"){

            QuickSort m = new QuickSort();
            ArraysHandler.y2.addElement(m.callQuickSort());

        }
        else if(requestedAlgorithmRight=="Selection sort"){

            SelectionSort m = new SelectionSort();
            ArraysHandler.y2.addElement(m.sort());

        }
        else{
            if (requestedAlgorithmLeft=="Radix Sort"){

                Radix m = new Radix();
                ArraysHandler.y2.addElement(m.callAsymptotic());
            }
            else if(requestedAlgorithmLeft== "Bubble sort"){

                BubbleSort m = new BubbleSort();
                ArraysHandler.y2.addElement(m.callAsymptotic());

            }
            else if(requestedAlgorithmLeft=="Counting sort"){

                CountingSort m = new CountingSort();
                ArraysHandler.y2.addElement(m.callAsymptotic());
            }
            else if(requestedAlgorithmLeft=="Heap sort"){

                HeapSort m = new HeapSort();
                ArraysHandler.y2.addElement(m.callAsymptotic());
            }
            else if(requestedAlgorithmLeft=="Insertion sort"){

                InsertionSort m = new InsertionSort();
                ArraysHandler.y2.addElement(m.callAsymptotic());
            }
            else if(requestedAlgorithmLeft=="Merge sort"){

                MergeSort m = new MergeSort();
                ArraysHandler.y2.addElement(m.callAsymptotic());
            }
            else if(requestedAlgorithmLeft=="Quick sort"){

                QuickSort m = new QuickSort();
                ArraysHandler.y2.addElement(m.callAsymptotic());

            }
            else if(requestedAlgorithmLeft=="Selection sort"){

                SelectionSort m = new SelectionSort();
                ArraysHandler.y2.addElement(m.callAsymptotic());

            }
        }

    }


    void extractDataOfSortingAlgorithms(int arrSize,String textOfLeftList ,String textOfRightList) throws IOException {
        for (int i = 10; i < arrSize; i += Integer.parseInt(stepSize.getText())) {

            ArraysHandler x = new ArraysHandler();
            //create unsorted numbers in an array
            x.createArrayWithGivenNum(i);


            ArraysHandler.x1.addElement(i);


            chooseAndUseAnAlgorithmForArray1(textOfLeftList,textOfRightList);
        }

        for (int i = 10; i < arrSize; i += Integer.parseInt(stepSize.getText())) {
            ArraysHandler.x2.addElement(i);
            ArraysHandler x = new ArraysHandler();
            x.createArrayWithGivenNum(i);
            chooseAndUseAnAlgorithmForArray2(textOfLeftList,textOfRightList);
        }
        XYChart.Series<String,Number> series1= new XYChart.Series<String,Number>();
       XYChart.Series<String,Number> series2= new XYChart.Series<String,Number>();
        series1.setName(textOfLeftList);
        series2.setName(textOfRightList);
        for (int i = 0; i < ArraysHandler.x1.size(); i++) {
            series1.getData().add(new XYChart.Data<String,Number>(ArraysHandler.x1.get(i).toString(), ArraysHandler.y1.get(i)));
        }for (int i = 0; i < ArraysHandler.x2.size(); i++) {
            series2.getData().add(new XYChart.Data<String, Number>(ArraysHandler.x2.get(i).toString(), ArraysHandler.y2.get(i)));
        }



        FXMLLoader loader = new FXMLLoader(getClass().getResource("chart.fxml"));
        Parent root = loader.load();
        chartController controller = loader.getController();
        controller.initData(series1,series2,textOfLeftList,textOfRightList);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("chart");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();


    }

    private boolean isNumbers(String text) {

        if ((text.matches("[0-9]+") && text.length() > 0)) {
            return true;
        } else {
            System.out.println("not a number");
            return false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("its asymptotic", "Bubble sort", "Counting sort", "Heap sort", "Insertion sort", "Merge sort", "Quick sort", "Radix Sort", "Selection sort");
        leftList.setItems(list);
        rightList.setItems(list);
    }


}
