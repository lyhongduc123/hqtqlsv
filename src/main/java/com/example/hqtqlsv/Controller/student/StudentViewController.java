package com.example.hqtqlsv.Controller.student;

import com.example.hqtqlsv.Model.Student;
import com.example.hqtqlsv.Model.StudentForShow;
import com.example.hqtqlsv.Model.User;
import com.example.hqtqlsv.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {
    private boolean hasAPaneOn = false;
    @FXML
    public Button showProfileBtn;
    @FXML
    private AnchorPane dad;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StudentForShow.setStudent((Student) User.getInstance());
        ViewFactory.getInstance().getCurrentSelection().addListener((o, oldValue, newValue) -> {
            switch (newValue) {
                case ViewFactory.PROFILE_VIEW -> {
                    dropLast();
                    dad.getChildren().add(ViewFactory.getInstance().getProfileView());
                    hasAPaneOn = true;
                }
                case ViewFactory.CHANGE_PASSWORD_VIEW -> {
                    dropLast();
                    dad.getChildren().add(ViewFactory.getInstance().getChangePasswordView());
                    hasAPaneOn = true;
                }
                case ViewFactory.MAIN_VIEW -> hasAPaneOn = false;
            }
        });
    }

    @FXML
    public void showProfile() {
        ViewFactory.getInstance().getCurrentSelection().set(ViewFactory.PROFILE_VIEW);
    }

    private void dropLast() {
        if (hasAPaneOn) {
            dad.getChildren().remove(dad.getChildren().size() - 1);
        }
    }

    @FXML
    public void changePassword() {
        ViewFactory.getInstance().getCurrentSelection().set(ViewFactory.CHANGE_PASSWORD_VIEW);
    }
}
