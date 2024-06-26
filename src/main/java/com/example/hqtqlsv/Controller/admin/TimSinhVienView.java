package com.example.hqtqlsv.Controller.admin;

import com.example.hqtqlsv.Model.*;
import com.example.hqtqlsv.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TimSinhVienView implements Initializable {
    @FXML
    public Label numRes;
    @FXML
    private TextField idField;
    @FXML
    private TextField hotenField;
    @FXML
    private TextField ngaysinhField;
    @FXML
    private TextField cccdField;
    @FXML
    private TextField lopField;

    @FXML
    private TableView<SinhVien> table;

    @FXML
    private TableColumn<SinhVien, String> idCol;
    @FXML
    private TableColumn<SinhVien, String> hotenCol;
    @FXML
    private TableColumn<SinhVien, String> ngaysinhCol;
    @FXML
    private TableColumn<SinhVien, String> cccdCol;
    @FXML
    private TableColumn<SinhVien, String> lopCol;
    @FXML
    private TableColumn<SinhVien, String> quequanCol;
    @FXML
    private TableColumn<SinhVien, String> emailCol;

    @FXML
    public void Search(){

        String id = idField.getText();
        String hoten = hotenField.getText();
        String ngaysinh = ngaysinhField.getText();
        String cccd = cccdField.getText();
        String lop = lopField.getText();

        String query = "SELECT * FROM sinh_vien WHERE 1=1";

        if (!id.isEmpty()) query += " AND mssv LIKE '" + id + "%'";
        if (!hoten.isEmpty()) query += " AND ho_ten LIKE '" + hoten + "%'";
        if (!ngaysinh.isEmpty()) query += " AND ngay_sinh LIKE '%" + ngaysinh + "%'";
        if (!cccd.isEmpty()) query += " AND cccd LIKE '" + cccd + "%'";
        if (!lop.isEmpty()) query += " AND ten_lop_fk LIKE '" + lop + "%'";

        System.out.println(query);
        int cnt = 0;

        ObservableList<SinhVien> list = FXCollections.observableArrayList();
        table.getItems().clear();
        try ( ResultSet rs = stmt.executeQuery(query))
        {
            while (rs.next()) {
                ++cnt;
                list.add(new SinhVien(
                        rs.getString("mssv"),
                        rs.getString("ho_ten"),
                        rs.getString("ngay_sinh"),
                        rs.getString("cccd"),
                        rs.getString("gioi_tinh"),
                        rs.getString("ten_lop_fk"),
                        rs.getString("que_quan"),
                        rs.getString("email")
                ));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        table.setItems(list);
        numRes.setText("Có " + cnt + " kết quả.");
    }
    Connection conn;
    Statement stmt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("mssv"));
        hotenCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        ngaysinhCol.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        cccdCol.setCellValueFactory(new PropertyValueFactory<>("cccd"));
        lopCol.setCellValueFactory(new PropertyValueFactory<>("tenLop"));
        quequanCol.setCellValueFactory(new PropertyValueFactory<>("queQuan"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        conn = DBConnection.getConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void xem() {
        SinhVien nguoi_duoc_chon = table.getSelectionModel().getSelectedItem();
        if (nguoi_duoc_chon!= null) {
            System.out.println(nguoi_duoc_chon);
            Student student = AccountActivity.queryStudent(nguoi_duoc_chon.getMssv());
            StudentForShow.setStudent(student);
            ViewFactory.getInstance().getCurrentSelection().set(ViewFactory.PROFILE_VIEW);
        }
    }

    @FXML
    public void addSv() {
        ViewFactory.getInstance().getCurrentSelection().set(ViewFactory.INSERT_VIEW);
    }

    @FXML
    public void deleteSv() {
        String mssv = table.getSelectionModel().getSelectedItem().getMssv();
        AccountActivity.deleteStudent(mssv);
    }
}
