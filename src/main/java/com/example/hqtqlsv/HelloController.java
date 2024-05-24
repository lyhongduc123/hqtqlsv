package com.example.hqtqlsv;

import com.example.hqtqlsv.Model.AccountActivity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void login() {
        int result = AccountActivity.login(usernameField.getText(), passwordField.getText());
        if (result == AccountActivity.LOGIN_SUCCESS) {
            ViewFactory.getInstance().showWindow();
            return;
        }
        if (result == AccountActivity.LOGIN_FAILED) {

        }

    }
}