package com.example.hqtqlsv.Controller.student;

import com.example.hqtqlsv.Model.AccountActivity;
import com.example.hqtqlsv.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class DoiMatKhauController {
    @FXML
    private Label errLabel;

    @FXML
    private PasswordField confirmNewPass;

    @FXML
    private PasswordField newPass;

    @FXML
    private PasswordField oldPass;

    @FXML
    void confirmChangePass() {
        String oldPassword = oldPass.getText();
        String newPassword = newPass.getText();
        String confirmPassword = confirmNewPass.getText();

        // Check if old password is correct
        if (!isOldPasswordCorrect(oldPassword)) {
            errLabel.setText("Old password is incorrect");
            errLabel.setVisible(true);
            return;
        }

        // Check if new password and confirm password match
        if (!newPassword.equals(confirmPassword)) {
            errLabel.setText("New password and confirm password do not match");
            errLabel.setVisible(true);
            return;
        }

        // Update password in database
        if (updatePassword(newPassword)) {
            errLabel.setVisible(false);
            //TODO

        } else {
            errLabel.setText("Failed to change password");
            errLabel.setVisible(true);
        }
    }

    private boolean updatePassword(String newPassword) {
        return AccountActivity.changePassword(User.getInstance().getUserName(), newPassword);
    }

    private boolean isOldPasswordCorrect(String oldPassword) {
        return oldPassword.equals(User.getInstance().getPassword());
    }
}
