package com.example.hqtqlsv.Controller.admin;

import com.example.hqtqlsv.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    private boolean hasAPaneOn = false;

    @FXML
    private AnchorPane dad;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ViewFactory.getInstance().getCurrentSelection().addListener((o, oldValue, newValue) -> {
            switch (newValue) {
                case ViewFactory.TIM_SINH_VIEN -> {
                    dropLast();
                    dad.getChildren().add(ViewFactory.getInstance().getTimSinhVien());
                    ViewFactory.getInstance().getTimSinhVien().setVisible(true);
                    hasAPaneOn = true;
                }
                case ViewFactory.PROFILE_VIEW -> {
                    ViewFactory.getInstance().getTimSinhVien().setVisible(false);
                    dad.getChildren().add(ViewFactory.getInstance().getProfileView());
                    hasAPaneOn = true;
                }
                case ViewFactory.MAIN_VIEW -> hasAPaneOn = false;
            }
        });
    }

    public void timSinhVien() {
        ViewFactory.getInstance().getCurrentSelection().set(ViewFactory.TIM_SINH_VIEN);
    }

    private void dropLast() {
        if (hasAPaneOn) {
            dad.getChildren().remove(dad.getChildren().size() - 1);
        }
    }
}
