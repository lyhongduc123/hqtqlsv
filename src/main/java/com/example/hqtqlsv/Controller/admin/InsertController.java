package com.example.hqtqlsv.Controller.admin;

import com.example.hqtqlsv.Model.DBConnection;
import com.example.hqtqlsv.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertController {
    @FXML
    private TextField email;

    @FXML
    private TextField hoVaTen;

    @FXML
    private Button insertBtn;

    @FXML
    private TextField lop;

    @FXML
    private TextField mssv;

    @FXML
    private DatePicker ngaySinh;

    @FXML
    private TextField queQuan;

    @FXML
    private TextField sex;

    @FXML
    private TextField cccd;

    @FXML
    void back() {
        Pane parent = (Pane) ViewFactory.getInstance().getInsertView(false).getParent();
        parent.getChildren().remove(ViewFactory.getInstance().getInsertView(false));
        ViewFactory.getInstance().getCurrentSelection().set(ViewFactory.TIM_SINH_VIEN);
    }

    @FXML
    boolean insert() {
        String query = "INSERT INTO sinh_vien VALUES (";

        try {
            PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query);

            pstmt.setString(8, email.getText());
            pstmt.setString(2, hoVaTen.getText());
            pstmt.setString(6, lop.getText());
            pstmt.setString(1, mssv.getText());
            pstmt.setString(4, cccd.getText());
            pstmt.setDate(3, Date.valueOf(ngaySinh.getValue()));
            pstmt.setString(7, queQuan.getText());
            pstmt.setString(5, sex.getText());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insert successful!");
                return true;
            } else {
                System.out.println("Insert failed!");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
            return false;
        }
    }
}
