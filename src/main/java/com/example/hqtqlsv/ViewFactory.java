package com.example.hqtqlsv;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    private static ViewFactory instance;
    private final StringProperty currentSelection;
    public static final String LOGIN_VIEW = "loginView";
    public static final String MAIN_VIEW = "mainView";

    private ViewFactory() {
        stage.setResizable(false);
        currentSelection = new SimpleStringProperty();
    }

    public synchronized static ViewFactory getInstance() {
        if (instance == null) {
            instance = new ViewFactory();
        }
        return instance;
    }
    private final Stage stage = new Stage();
    private Scene scene;


    private Scene createStage(FXMLLoader loader) {
        Scene scene = null;

        try {
            scene = new Scene(loader.load());
            //stage.getIcons().add(new Image(ViewFactory.class.getResourceAsStream("/Images/icon.png")));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        stage.setScene(scene);
        stage.setTitle("appName");

        stage.centerOnScreen();
        stage.show();
        return scene;
    }


    public void showLoginView() {
        scene = createStage(new FXMLLoader(getClass().getResource("login-view.fxml")));
    }

    public void showWindow() {
        scene = createStage(new FXMLLoader(getClass().getResource("main-view.fxml")));
    }
}
