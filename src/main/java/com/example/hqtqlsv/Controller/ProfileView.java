package com.example.hqtqlsv.Controller;

import com.example.hqtqlsv.Model.Student;
import com.example.hqtqlsv.Model.User;
import com.example.hqtqlsv.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileView implements Initializable {
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
    void changePass() {

    }


    //TODO cho phép admin sửa thông tin, student thì không.
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
            email.setText(student.getEmail());
        }
    }

    @FXML
    public void back() {
        Pane parent = (Pane) ViewFactory.getInstance().getProfileView().getParent();
        parent.getChildren().remove(ViewFactory.getInstance().getProfileView());
        ViewFactory.getInstance().getCurrentSelection().set(ViewFactory.MAIN_VIEW);
    }
}
