package com.example.crud;

 import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
 import javafx.scene.text.Text;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class CreateController {
        @FXML
        private TextField ID;
        @FXML
        private TextField Name;
        @FXML
        private TextField Address;
        @FXML
        private TextField Phone;
        @FXML
        private TextField DeptNo;
        @FXML
        private TextField Deptname;
        @FXML
        private TextField Salary;
        @FXML
        private Text sucessmsg;
        @FXML
        private Text errormsg;

        @FXML
        private void btncreate() throws SQLException {
            String SQL_INSERT = "INSERT INTO employee (Emp_NO, Emp_Name, Emp_Add, Emp_Phone, Dept_No, Dept_Name, Salary) VALUES (?,?,?,?,?,?,?)";

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employees?serverTimezone=UTC", "root", null);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

                preparedStatement.setInt(1, Integer.parseInt(ID.getText()));
                preparedStatement.setString(2, Name.getText());
                preparedStatement.setString(3, Address.getText());
                preparedStatement.setString(4, Phone.getText());
                preparedStatement.setString(5, DeptNo.getText());
                preparedStatement.setString(6, Deptname.getText());
                preparedStatement.setString(7, Salary.getText());

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    sucessmsg.setText("New Record Created");
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