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

public class Third implements Initializable {


    @FXML
    private AreaChart ch;
    @FXML
    private CategoryAxis xAx;
    @FXML
    private NumberAxis yAx;
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
    @FXML
    private TextField a_text;
    @FXML
    private TextField a_text_2;

    Stage stage=new Stage();

    double a;
    double v;
    double r;
    double t;
    double s;
    double a_2;
    double v_2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        a = 1.0;
        v = 1.0;
        r = 1.0;
        t = 1.0;
        s = 1.0;
        a_2 = 1.0;
        v_2 = 1.0;
        int n = 0;
        Bott.setOnAction(actionEvent -> {
            XYChart.Series teor = new XYChart.Series();
            XYChart.Series variant = new XYChart.Series();
            variant.setName("Model");
            teor.setName("Theoretical");
            a = Double.parseDouble(a_text.getText());
            v = Double.parseDouble(v_text.getText());
            t = Double.parseDouble(t_text.getText());
            r = Double.parseDouble(r_text.getText());
            s = Double.parseDouble(s_text.getText());
            a_2 = Double.parseDouble(a_text_2.getText());
            v_2 = Double.parseDouble(v_text_2.getText());
            double a_n = Math.sqrt(r*r - 10*10);
            double lua = ((2*r*a*a_2-Math.pow(v,2)*a_2-v*v_2*a)/(2*v*a*a_2))/t;
            double dead = (Math.pow(v,2)*a_2 + v*v_2*a)/(2*a*a_2); //(Math.pow(v,2)*a_2 + Math.pow(v_2,2)*a)/(2*a*a_2)
            System.out.println(lua);
            double tar = 0.0;
            int summ = 0;
            while (tar<100){
                int tau = 0;
                while (tau<s){
                    double road = 0.0;
                    while (road<r){
                        double q_1 = 100*Math.random();
                        //System.out.println(q_1);
                        if (q_1<tar){
                            summ++;
                            tau++;
                            break;
                        }
                        else{
                            road = road + v*t;
                        }
                        if (road >= r-dead){
                            tau++;
                            break;
                        }
                    }
                    //System.out.println(summ);

                    //tau++;
                }
                System.out.println((100-tar)/100);
                variant.getData().add(new XYChart.Data<>(Double.toString(tar) ,summ/(s)));
                teor.getData().add(new XYChart.Data<>(Double.toString(tar) ,1- Math.pow( (100 - tar) / 100 , lua)));
                summ = 0;
                tar++;
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
