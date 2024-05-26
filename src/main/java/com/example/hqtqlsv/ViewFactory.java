package com.example.hqtqlsv;

import com.example.hqtqlsv.Model.Admin;
import com.example.hqtqlsv.Model.Student;
import com.example.hqtqlsv.Model.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    private static ViewFactory instance;
    private final StringProperty currentSelection;
    public static final String PROFILE_VIEW = "profileView";
    public static final String ADMIN_VIEW = "adminView";

    private AnchorPane profileView;

    private ViewFactory() {
        stage.setResizable(false);
        currentSelection = new SimpleStringProperty();
    }

    public synchronized static ViewFactory getInstance() {
        if (instance == null) {
            instance = new ViewFactory();
        }
        return instance;
    }
    private final Stage stage = new Stage();
    private Scene scene;

    public StringProperty getCurrentSelection() {
        return currentSelection;
    }

    public StringProperty currentSelectionProperty() {
        return currentSelection;
    }

    private Scene createStage(FXMLLoader loader) {
        Scene scene = null;

        try {
            scene = new Scene(loader.load());
            //stage.getIcons().add(new Image(ViewFactory.class.getResourceAsStream("/Images/icon.png")));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        stage.setScene(scene);
        stage.setTitle("appName");

        stage.centerOnScreen();
        stage.show();
        return scene;
    }


    public void showLoginView() {
        scene = createStage(new FXMLLoader(getClass().getResource("login-view.fxml")));
    }

    public void showWindow() {
        if (User.getInstance().getClass().equals(Student.class))
            scene = createStage(new FXMLLoader(getClass().getResource("main-view.fxml")));
        else if (Student.getInstance().getClass().equals(Admin.class))
            scene = createStage(new FXMLLoader(getClass().getResource("admin-view.fxml")));
    }

    public AnchorPane getProfileView() {
        if (profileView == null) {
            try {
                profileView = FXMLLoader.load(getClass().getResource("profile-view.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return profileView;
    }


}
