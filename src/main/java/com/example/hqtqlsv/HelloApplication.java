package com.example.hqtqlsv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewFactory.getInstance().showLoginView();
    }

    public static void main(String[] args) {
        launch();
    }
}