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
        User.init(AccountActivity.queryStudent("testonly")); //just for test; delete later
        ViewFactory.getInstance().showWindow();
//        int result = AccountActivity.login(usernameField.getText(), passwordField.getText());

//        if (result == AccountActivity.LOGIN_SUCCESS) {

//            errorLabel.setVisible(false);
//            User.init(new Student());
//            ViewFactory.getInstance().showWindow();
//            return;
//        }
//        if (result == AccountActivity.LOGIN_FAILED) {
//            errorLabel.setVisible(true);
//        }

    }

    @FXML
    public void loginByEnter(KeyEvent keyEvent) {
//        if (keyEvent.getCode() == KeyCode.ENTER) {
//            System.out.println("true");
//            login();
//        }
    }
}