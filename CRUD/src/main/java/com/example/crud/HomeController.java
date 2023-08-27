package com.example.crud;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

//    @FXML
//    private Label welcomeText;

    @FXML
    protected void openUpdate() throws IOException {
        openNewWindow("Update.fxml");
    }
    @FXML
    protected void openDelete() throws IOException {
        openNewWindow("Delete.fxml");
    }
    @FXML
    protected void openCreate() throws IOException {
        openNewWindow("Create.fxml");
    }



    private void openNewWindow(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("EMPLOYEES");
        stage.setScene(new Scene(root));
        stage.show();
    }}