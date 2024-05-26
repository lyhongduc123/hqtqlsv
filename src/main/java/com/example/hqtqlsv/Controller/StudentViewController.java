package com.example.hqtqlsv.Controller;

import com.example.hqtqlsv.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {
    private boolean hasAPane = false;
    @FXML
    public Button showProfileBtn;
    @FXML
    private AnchorPane dad;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ViewFactory.getInstance().getCurrentSelection().addListener((o, oldValue, newValue) -> {
            switch (newValue) {
                case ViewFactory.PROFILE_VIEW -> {
                    dropLast();
                    dad.getChildren().add(ViewFactory.getInstance().getProfileView());
                    hasAPane = true;
                }
            }
        });
    }

    public void showProfile() {
        ViewFactory.getInstance().getCurrentSelection().set(ViewFactory.PROFILE_VIEW);
    }

    private void dropLast() {
        if (hasAPane) {
            dad.getChildren().remove(dad.getChildren().size() - 1);
        }
    }
}
