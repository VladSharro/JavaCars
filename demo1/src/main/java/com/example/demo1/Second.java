package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Second implements Initializable {

    @FXML
    private AreaChart ch;
    @FXML
    private TextField t_text;
    @FXML
    private Button BtnClear;
    @FXML
    private Button Bott;
    Stage stage=new Stage();

    double t;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        t = 1.0;
        Bott.setOnAction(actionEvent -> {
            XYChart.Series variant = new XYChart.Series();
            variant.setName("Graph");
            t = Double.parseDouble(t_text.getText());
            int f = 0;
            while(f<101){
                variant.getData().add(new XYChart.Data<>(Integer.toString(f), 1 - Math.pow((double) f/100,t)));
                f++;
            }
            ch.getData().add(variant);
        });

        BtnClear.setOnAction(actionEvent -> {
            ch.getData().clear();
        });
    }


    public void switchtomain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
