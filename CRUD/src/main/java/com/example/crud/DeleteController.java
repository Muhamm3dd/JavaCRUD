package com.example.crud;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.sql.*;

public class DeleteController {

    @FXML
    private TextField ID;
    @FXML
    private Text sucessmsg;
    @FXML
    private Text errormsg;
    @FXML
    public void btndelete(){


        String SQL_SELECT = "DELETE from employee where Emp_No = ?";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/employees?serverTimezone=UTC", "root", null);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setInt(1, Integer.parseInt(ID.getText()));


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                sucessmsg.setText("Record successfully deleted");
                errormsg.setVisible(false);
            } else {
                sucessmsg.setVisible(false);
                errormsg.setVisible(true);
            }



        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
