package com.example.hqtqlsv.Controller;

import com.example.hqtqlsv.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    public Button showProfileBtn;
    @FXML
    private AnchorPane dad;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ViewFactory.getInstance().getCurrentSelection().addListener((o, oldValue, newValue) -> {
            switch (newValue) {
                case ViewFactory.PROFILE_VIEW -> {
                    if (dad.getChildren().size() >= 1) {
                        dad.getChildren().remove(dad.getChildren().size() - 1);
                    }
                    dad.getChildren().add(ViewFactory.getInstance().getProfileView());
                }
            }
        });
    }

    public void showProfile() {
        ViewFactory.getInstance().getCurrentSelection().set(ViewFactory.PROFILE_VIEW);
    }
}
