/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.group4_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MergeController implements Initializable {


    @FXML
    private BorderPane DashboardPage;
    @FXML
    private Button dashboard_btnSalesPerformance;
    @FXML
    private BarChart<String, Number> dashboard_barChart_Income;
    @FXML
    private ComboBox<?> dashboard_cboFilter;
    @FXML
    private Button dashboard_btnSetChart_Service;
    @FXML
    private Button dashboard_btnSetChart_customer;
    @FXML
    private Button dashboard_btnSetChart_pitch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void setRoot_SalesPerformance(ActionEvent event) {
        try {
            App.setRoot("Dashboard");
            System.out.println("setRoot_SalesPerformance");
        } catch (IOException ex) {
            Logger.getLogger(MergeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void dashboard_btnSetChart_Service(ActionEvent event) {
    }

    @FXML
    private void dashboard_btnSetChart_customer(ActionEvent event) {
    }

    @FXML
    private void dashboard_btnSetChart_pitch(ActionEvent event) {
    }

    void setData_chart() {

    }

}
