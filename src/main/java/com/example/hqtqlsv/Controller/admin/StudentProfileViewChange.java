package com.example.hqtqlsv.Controller.admin;

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

public class StudentProfileViewChange implements Initializable {
    @FXML
    private Button insertBtn;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reset();
    }

    @FXML
    public void back() {
        if (User.getInstance() instanceof Student) back(ViewFactory.MAIN_VIEW);
        if (User.getInstance() instanceof Admin) back(ViewFactory.TIM_SINH_VIEN);
    }

    public void back(String previousState) {
        reset();
        Pane parent = (Pane) ViewFactory.getInstance().getChangeView(false).getParent();
        parent.getChildren().remove(ViewFactory.getInstance().getChangeView(false));
        ViewFactory.getInstance().getCurrentSelection().set(previousState);
    }

    public void reset() {
        hoVaTen.setText(StudentForShow.getStudent().getHoVaTen());
        queQuan.setText(StudentForShow.getStudent().getQueQuan());
        sex.setText(StudentForShow.getStudent().isMale()? "Nam" : "Nữ");
        mssv.setText(StudentForShow.getStudent().getMssv());
        lop.setText(StudentForShow.getStudent().getTen_lop_fk());
        ngaySinh.setValue(StudentForShow.getStudent().getNgaySinh().toLocalDate());
        email.setText(StudentForShow.getStudent().getEmail());

        hoVaTen.setDisable(User.getInstance() instanceof Student);
        lop.setDisable(User.getInstance() instanceof Student);
        queQuan.setDisable(User.getInstance() instanceof Student);
        ngaySinh.setDisable(User.getInstance() instanceof Student);
        sex.setDisable(User.getInstance() instanceof Student);
        mssv.setDisable(User.getInstance() instanceof Student);
    }
}
