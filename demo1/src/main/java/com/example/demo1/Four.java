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
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Four implements Initializable {

    @FXML
    private TextField t_t_text;
    @FXML
    private AreaChart ch;
    @FXML
    private Button Bott;
    @FXML
    private TextField r_text;
    @FXML
    private TextField t_text;
    @FXML
    private TextField v_text;
    @FXML
    private Button BtnClear;
    @FXML
    private Button BtnBack;
    @FXML
    private TextField s_text;
    @FXML
    private TextField v_text_2;
    //@FXML
    //private TextField a_text_2;
    //@FXML
    //private TextField a_text;
    @FXML
    private TextField S_field;


    Stage stage=new Stage();

    double a;
    double v;
    double r;
    double t;
    double s;
    //double a_2;
    double v_2;
    double S;
    double t_t;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        a = 1.0;
        v = 1.0;
        r = 1.0;
        t = 1.0;
        s = 1.0;
        t_t = 1.0;
        //a_2 = 1.0;
        v_2 = 1.0;
        int n = 0;
        Bott.setOnAction(actionEvent -> {
            XYChart.Series teor = new XYChart.Series();
            XYChart.Series variant = new XYChart.Series();
            variant.setName("Model");
            teor.setName("Theoretical");
            //a = Double.parseDouble(a_text.getText());
            v = Double.parseDouble(v_text.getText());
            t = Double.parseDouble(t_text.getText());
            r = Double.parseDouble(r_text.getText());
            s = Double.parseDouble(s_text.getText());
            v_2 = Double.parseDouble(v_text_2.getText());
            S = Double.parseDouble(S_field.getText());
            t_t = Double.parseDouble(t_t_text.getText());
            double a_n = Math.sqrt(r*r - S*S);
            //double t_t = Math.abs(S/v - a_n/v_2);
            double lua = (a_n/v_2 + t_t)/t;
            System.out.println(a_n);
            System.out.println(lua);
            double tar = 0.0;
            int summ = 0;
            while (tar<100){
                int tau = 0;

                while (tau<s){
                    double road = 0.0;
                    while (road<(a_n + t_t * v)){
                        double q_1 = 100*Math.random();
                        //System.out.println(q_1);
                        if (q_1<tar){
                            summ++;
                            tau++;
                            break;
                        }
                        else{
                            road = road + v_2*t;
                            if (road>=(a_n + t_t * v_2)){
                                tau++;
                                break;
                            }
                        }
                       // tau++;
                    }
                    //System.out.println(tau+"  "+summ);
                    //tau++;
                }
                if (t_t <= Math.abs(S/v - a_n/v_2)) {
                    variant.getData().add(new XYChart.Data<>(Double.toString(tar), summ / s));
                    teor.getData().add(new XYChart.Data<>(Double.toString(tar), 1 - Math.pow((100 - tar) / 100, lua)));
                    System.out.println("1");
                    summ = 0;
                    tar++;
                }
                if (t_t > Math.abs(S/v - a_n/v_2)) {
                    variant.getData().add(new XYChart.Data<>(Double.toString(tar), 1));
                    teor.getData().add(new XYChart.Data<>(Double.toString(tar), 1));
                    System.out.println("2");
                    summ = 0;
                    tar++;
                }
                    //summ = 0;w
                   // tar++;

            }
            //System.out.println((100-tar)/100);
            ch.getData().add(teor);
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
