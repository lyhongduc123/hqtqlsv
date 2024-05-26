package com.example.hqtqlsv.Controller;

import com.example.hqtqlsv.Model.AccountActivity;
import com.example.hqtqlsv.Model.Student;
import com.example.hqtqlsv.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
    private TextField email;

    @FXML
    private TextField hoVaTen;

    @FXML
    private TextField lop;

    @FXML
    private TextField mssv;

    @FXML
    private TextField queQuan;

    @FXML
    private TextField sex;

    @FXML
    private DatePicker ngaySinh;


    @FXML
    void changProfile() {
        isChangingProfile = !isChangingProfile;
        if (isChangingProfile) {
            hoVaTen.setDisable(false);
            queQuan.setDisable(false);
            sex.setDisable(false);
            email.setDisable(false);
            changePrfBtn.setText("Lưu");
        } else {
            hoVaTen.setDisable(true);
            queQuan.setDisable(true);
            sex.setDisable(true);
            email.setDisable(true);
            changePrfBtn.setText("Chỉnh sửa");
            boolean success = AccountActivity.changeProfile(User.getInstance().getUserName(), hoVaTen.getText()
            ,  queQuan.getText(), false ); //TODO fix sex
            if (success ==  false) {
                Student student = (Student) User.getInstance();
                hoVaTen.setText(student.getHoVaTen());
                queQuan.setText(student.getQueQuan());
                sex.setText(student.isMale()? "Nam" : "Nữ");
                System.out.println("can't change profile");
                return;
            }
            User.init(AccountActivity.queryStudent(User.getInstance().getUserName()));
        }
    }

    @FXML
    void changePass() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (User.getInstance().getClass().equals(Student.class)) {
            Student student = (Student) User.getInstance();
            hoVaTen.setText(student.getHoVaTen());
            queQuan.setText(student.getQueQuan());
            sex.setText(student.isMale()? "Nam" : "Nữ");
            mssv.setText(student.getMssv());
            lop.setText(student.getTen_lop_fk());
            ngaySinh.setValue(student.getNgaySinh().toLocalDate());
        }
    }
}
