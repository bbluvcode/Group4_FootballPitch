/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.group4_project;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.ChartDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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
    private ComboBox<String> dashboard_cboFilter;
    @FXML
    private Button dashboard_btnSetChart_Service;
    @FXML
    private Button dashboard_btnSetChart_customer;
    @FXML
    private Button dashboard_btnSetChart_pitch;
    @FXML
    private Label lbTotalRevenue;
    @FXML
    private Label lbServiceRevenue;
    @FXML
    private Label lbTotalRentals;
    @FXML
    private Label lbRentalRevenua;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}