package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Dimension sSize =Toolkit.getDefaultToolkit().getScreenSize();
        FXMLLoader fxmlLoader_main = new FXMLLoader(HelloApplication.class.getResource("MainScreene.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene main = new Scene(fxmlLoader_main.load(), 756,587);
        //Scene scene = new Scene(fxmlLoader.load(), 756, 587);
        stage.setScene(main);
        stage.setTitle("Hi");
        stage.show();
        //stage.setTitle("Hello!");
        //stage.setScene(scene);
        //stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}