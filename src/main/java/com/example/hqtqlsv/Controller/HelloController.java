package com.example.hqtqlsv.Controller;

import com.example.hqtqlsv.Model.AccountActivity;
import com.example.hqtqlsv.Model.Student;
import com.example.hqtqlsv.Model.User;
import com.example.hqtqlsv.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {
    @FXML
    public Label errorLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void login() {
        int result = AccountActivity.login(usernameField.getText(), passwordField.getText());
        //int result = AccountActivity.login("22020800", "123456Aa");
        if (result == AccountActivity.LOGIN_SUCCESS) {
            errorLabel.setVisible(false);
            ViewFactory.getInstance().showWindow();
            return;
        }
        if (result == AccountActivity.LOGIN_FAILED) {
            errorLabel.setVisible(true);
        }
    }

    @FXML
    public void loginByEnter(KeyEvent keyEvent) {
//        if (keyEvent.getCode() == KeyCode.ENTER) {
//            System.out.println("true");
//            login();
//        }
    }
}