package com.example.hqtqlsv.Controller.student;

import com.example.hqtqlsv.Model.Admin;
import com.example.hqtqlsv.Model.Student;
import com.example.hqtqlsv.Model.StudentForShow;
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

public class StudentProfileView implements Initializable {
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


    //TODO cho phép admin sửa thông tin, student thì không.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hoVaTen.setText(StudentForShow.getStudent().getHoVaTen());
        queQuan.setText(StudentForShow.getStudent().getQueQuan());
        sex.setText(StudentForShow.getStudent().isMale()? "Nam" : "Nữ");
        mssv.setText(StudentForShow.getStudent().getMssv());
        lop.setText(StudentForShow.getStudent().getTen_lop_fk());
        ngaySinh.setValue(StudentForShow.getStudent().getNgaySinh().toLocalDate());
        email.setText(StudentForShow.getStudent().getEmail());
    }

    @FXML
    public void back() {
        if (User.getInstance() instanceof Student) back(ViewFactory.MAIN_VIEW);
        if (User.getInstance() instanceof Admin) back(ViewFactory.TIM_SINH_VIEN);
    }

    public void back(String previousState) {
        Pane parent = (Pane) ViewFactory.getInstance().getProfileView().getParent();
        parent.getChildren().remove(ViewFactory.getInstance().getProfileView());
        ViewFactory.getInstance().getCurrentSelection().set(previousState);
    }
}
