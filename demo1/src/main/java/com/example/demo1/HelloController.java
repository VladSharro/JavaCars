package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML
    private TextField s_text;
    @FXML
    private Button BtnBack;
    @FXML
    private Button BtnClear;
    @FXML
    private TextField r_text;
    @FXML
    private TextField t_text;
    @FXML
    private TextField v_text;
    @FXML
    private Button Bott;
    @FXML
    private TextField a_text;
    @FXML
    private CategoryAxis xAx;
    @FXML
    private NumberAxis yAx;
    @FXML
    private AreaChart ch;

    Stage stage=new Stage();


    double a;
    double v;
    double r;
    double t;
    double s;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        a = 1.0;
        v = 1.0;
        r = 1.0;
        t = 1.0;
        s = 1.0;
        int n = 0;
        //System.out.println(q);
        //ch.getData().remove(0);
            Bott.setOnAction(actionEvent -> {
                XYChart.Series variant = new XYChart.Series();
                XYChart.Series teor = new XYChart.Series();
                XYChart.Series teor2 = new XYChart.Series();
                variant.setName("Model");
                teor.setName("Theoretical");
                double f = 0.0;
                ArrayList<Double> x = new ArrayList<>();
                ArrayList<Double> teorem = new ArrayList<>();
                ArrayList<Double> y = new ArrayList<>();
                a = Double.parseDouble(a_text.getText());
                v = Double.parseDouble(v_text.getText());
                t = Double.parseDouble(t_text.getText());
                r = Double.parseDouble(r_text.getText());
                s = Double.parseDouble(s_text.getText()); //tau
                int sr = 1;
                long factorial = 1;
                double lua = (r/v - v/(2*a))/t;
                double k;
                int num_t = (int)(r/(v*t));
                //System.out.println(num_t);
                if (a == 0){
                    k = r/v;
                }
                else{
                    k = r/v - v/(2*a);
                    //System.out.println(k);
                }
                double dead = Math.pow(v,2)/(2*a);
                int summ = 0;
                //System.out.println(dead);
                double sim = 0;
                double tar = 0.0;
                while (tar < 100){
                    //System.out.println(100-tar);
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
                    System.out.println(1-1/Math.pow((tar+1),2));
                    variant.getData().add(new XYChart.Data<>(Double.toString(tar) ,summ/(s)));
                    teor.getData().add(new XYChart.Data<>(Double.toString(tar) ,1- Math.pow( (100 - tar) / 100 , lua)));// 1-1/Math.pow((tar+1),2)  ,  tar / 100

                    summ = 0;
                    tar++;
                }
                ch.getData().add(variant);
                ch.getData().add(teor);
            });
            BtnClear.setOnAction(actionEvent -> {
                ch.getData().clear();
            });
        //ch.getData().remove(0);
            //ch.getData().clear();
        }

    public void switchtomain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        /*while (i<100){
            variant.getData().add(new XYChart.Data<>(Integer.toString(i),i*i*a));
            i++;
        }*/
        //AreaChart.getData().addAll(seriesApril);
        //ch.getData().add(variant);
        //a = Double.parseDouble(a_text.getText());

}