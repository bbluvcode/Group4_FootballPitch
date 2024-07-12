/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.group4_project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

public class PositionController implements Initializable {

    @FXML
    private TextField tfNewPos_User;

    @FXML
    private TableView<UserCategory> tvPosition_User;

    @FXML
    private TableColumn<UserCategory, String> colPosition_User;

    private ObservableList<UserCategory> positionList;

    private AdminPageController parentController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        positionList = FXCollections.observableArrayList();
        colPosition_User.setCellValueFactory(new PropertyValueFactory<>("type"));

        // Initialize TableView with empty data
        tvPosition_User.setItems(positionList);

        // Load data from database
        loadDataFromDatabase();
    }

    public void setParentController(AdminPageController parentController) {
        this.parentController = parentController;
    }

    @FXML
    private void addPosition_User(ActionEvent event) {
        String newPos = tfNewPos_User.getText().trim();

        if (newPos.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter a position.");
            return;
        }

        ConnectDB connector = new ConnectDB();
        Connection conn = connector.getConnect();

        if (conn != null) {
            try {
                // Find the highest idt currently in the user_type table
                String maxIdQuery = "SELECT MAX(idt) FROM user_type";
                int nextId;
                try (PreparedStatement maxIdStmt = conn.prepareStatement(maxIdQuery); ResultSet maxIdRs = maxIdStmt.executeQuery()) {
                    nextId = 1; // Default value if the table has no data
                    if (maxIdRs.next()) {
                        nextId = maxIdRs.getInt(1) + 1;
                    }
                }

                // Insert new type into user_type table with idt as nextId and type as newPos
                String insertQuery = "INSERT INTO user_type (idt, type) VALUES (?, ?)";
                try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                    insertStmt.setInt(1, nextId);
                    insertStmt.setString(2, newPos);

                    int rowsAffected = insertStmt.executeUpdate();

                    if (rowsAffected > 0) {
                        showAlert(Alert.AlertType.INFORMATION, "Insertion Successful!", "New position has been added.");
                        loadDataFromDatabase();
                        // Reload positions in parent controller
                        if (parentController != null) {
                            parentController.loadPositions_User();
                        }
                        clearFields();
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Insertion Failed!", "No rows affected.");
                    }
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error inserting position: " + ex.getMessage());
                showAlert(Alert.AlertType.ERROR, "SQL Error", "Error inserting position: " + ex.getMessage());
            }

        } else {
            System.out.println("Failed to connect to database");
            showAlert(Alert.AlertType.ERROR, "Connection Error", "Failed to connect to database");
        }

    }

    @FXML
    private void deletePosition_User(ActionEvent event) {
        UserCategory selectedPosition = tvPosition_User.getSelectionModel().getSelectedItem();

        if (selectedPosition == null) {
            showAlert(Alert.AlertType.ERROR, "Delete Error", "Please select a position to delete.");
            return;
        }

        // Check if the selected position is "owner"
        if (selectedPosition.getType().equalsIgnoreCase("owner")) {
            showAlert(Alert.AlertType.ERROR, "Delete Error", "Cannot delete 'owner' position.");
            return;
        }

        ConnectDB connector = new ConnectDB();
        Connection conn = connector.getConnect();

        if (conn != null) {
            try {
                // Delete position from user_type table where idt matches selected position's idt
                String deleteQuery = "DELETE FROM user_type WHERE idt=?";
                try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {
                    deleteStmt.setInt(1, selectedPosition.getIdt());

                    int rowsDeleted = deleteStmt.executeUpdate();

                    if (rowsDeleted > 0) {
                        showAlert(Alert.AlertType.INFORMATION, "Deletion Successful!", "Position deleted successfully.");
                        loadDataFromDatabase();
                        if (parentController != null) {
                            parentController.loadPositions_User(); // Reload positions in parent controller
                        }
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Delete Error", "No such position found with the provided idt.");
                    }
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error deleting position: " + ex.getMessage());
                showAlert(Alert.AlertType.ERROR, "Delete Error", "Error deleting position: " + ex.getMessage());
            }
        } else {
            System.out.println("Failed to connect to database");
            showAlert(Alert.AlertType.ERROR, "Connection Error", "Failed to connect to database");
        }
    }

    private void loadDataFromDatabase() {
        ConnectDB connector = new ConnectDB();
        Connection conn = connector.getConnect();

        if (conn != null) {
            try {
                positionList.clear(); // Clear previous data
                String query = "SELECT * FROM user_type";
                try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

                    while (rs.next()) {
                        int idt = rs.getInt("idt");
                        String type = rs.getString("type");
                        UserCategory position = new UserCategory(idt, type);
                        positionList.add(position);
                    }

                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error loading positions: " + ex.getMessage());
                showAlert(Alert.AlertType.ERROR, "Load Error", "Error loading positions from database.");
            }
        } else {
            System.out.println("Failed to connect to database");
            showAlert(Alert.AlertType.ERROR, "Connection Error", "Failed to connect to database");
        }

        tvPosition_User.setItems(positionList); // Set data to TableView
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        tfNewPos_User.clear();
    }

    private void closeWindow() {
        Stage stage = (Stage) tfNewPos_User.getScene().getWindow();
        stage.close();
    }

}
