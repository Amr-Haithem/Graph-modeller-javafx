package com.example.ds_project;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.shape.Line;

public class chartController {

    @FXML
    private LineChart<String, Number> llineChart;

    void initData( XYChart.Series<String,Number>s1,XYChart.Series<String,Number>s2,String left,String right) {
        llineChart.getData().clear();
        llineChart.setTitle(left+" vs "+right);
        llineChart.getData().addAll(s1,s2);
    }

}
