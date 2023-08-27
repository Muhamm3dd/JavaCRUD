package com.example.crud;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.*;

public class UpdateController {

    @FXML
    private Text sucessmsg;

    @FXML
    private Text errormsg;

    @FXML
    private TextField ID;

    @FXML
    private TextField salaryInc;

    @FXML
    private void btnUpdate(){
//        int employeeId = Integer.parseInt(ID.getText());
//        double percentageIncrement = Double.parseDouble(salaryInc.getText());

        String SQL_SELECT = "UPDATE employee SET Salary = Salary +(Salary * ?) WHERE Emp_NO = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employees?serverTimezone=UTC", "root", null);

             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setDouble(1, Double.parseDouble(salaryInc.getText())/100);
            preparedStatement.setInt(2, Integer.parseInt(ID.getText()));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                sucessmsg.setText("Record Updated");
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