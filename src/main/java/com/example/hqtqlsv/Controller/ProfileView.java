package com.example.hqtqlsv.Controller;

import com.example.hqtqlsv.Model.AccountActivity;
import com.example.hqtqlsv.Model.Student;
import com.example.hqtqlsv.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileView implements Initializable {
    private boolean isChangingProfile = false;

    @FXML
    private Button changePrfBtn;

    @FXML
    private Button changePw;

    @FXML
    private TextField hoVaTen;

    @FXML
    private TextField queQuan;

    @FXML
    private Label sex;

    @FXML
    void changProfile() {
        if (!isChangingProfile) {
            hoVaTen.setEditable(true);
            queQuan.setEditable(true);
            changePrfBtn.setText("Lưu");
        } else {
            boolean success = AccountActivity.changeProfile(User.getInstance().getUserName());
            if (success ==  false) {
                Student student = (Student) User.getInstance();
                hoVaTen.setText(student.getHoVaTen());
                queQuan.setText(student.getQueQuan());
                sex.setText(student.isMale()? "Nam" : "Nữ");
                return;
            }
            User.init(AccountActivity.queryStudent(User.getInstance().getUserName()));
            hoVaTen.setEditable(false);
            queQuan.setEditable(false);
            changePrfBtn.setText("Chỉnh sửa");

        }
    }

    @FXML
    void changePass() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hoVaTen.setEditable(false);
        queQuan.setEditable(false);
        if (User.getInstance().getClass().equals(Student.class)) {
            Student student = (Student) User.getInstance();
            hoVaTen.setText(student.getHoVaTen());
            queQuan.setText(student.getQueQuan());
            sex.setText(student.isMale()? "Nam" : "Nữ");
        }
    }
}
