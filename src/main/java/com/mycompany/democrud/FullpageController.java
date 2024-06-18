/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.democrud;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FullpageController implements Initializable {

    @FXML
    private Button btnMini;
    @FXML
    private Button btnUserPage;
    @FXML
    private Button btnCusPage;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnSerPage;
    @FXML
    private Button btnCatePage;
    @FXML
    private BorderPane UserPage;
    @FXML
    private ImageView View_U;
    @FXML
    private Button btnImg_U;
    @FXML
    private PasswordField tfPass;
    @FXML
    private ComboBox<?> cbPos_U;
    @FXML
    private TextField tfName_U;
    @FXML
    private ToggleGroup gender_U;
    @FXML
    private DatePicker tfBirth_U;
    @FXML
    private TextField tfPhone_U;
    @FXML
    private Button btnAdd_U;
    @FXML
    private Button btnClear_U;
    @FXML
    private Button btnUpdate_U;
    @FXML
    private Button btnDelete_U;
    @FXML
    private TextField btnSearch_U;
    @FXML
    private TableView<?> tbView_U;
    @FXML
    private TableColumn<?, ?> colImg_U;
    @FXML
    private TableColumn<?, ?> colName_U;
    @FXML
    private TableColumn<?, ?> colPos_U;
    @FXML
    private TableColumn<?, ?> colGender_U;
    @FXML
    private TableColumn<?, ?> colBirth_U;
    @FXML
    private TableColumn<?, ?> colPhone_U;
    @FXML
    private ImageView View_Cus;
    @FXML
    private Button btnImg_Cus;
    @FXML
    private Button btnAdd_Cus;
    @FXML
    private Button btnClear_Cus;
    @FXML
    private Button btnUpdate_Cus;
    @FXML
    private Button btnDelete_Cus;
    @FXML
    private TextField tfName_Cus;
    @FXML
    private TextField tfPhone_Cus;
    @FXML
    private Label tfPoint_Cus;
    @FXML
    private TextField btnSearch_Cus;
    @FXML
    private TableView<?> tbView_Cus;
    @FXML
    private TableColumn<?, ?> colImg_Cus;
    @FXML
    private TableColumn<?, ?> colName_Cus;
    @FXML
    private TableColumn<?, ?> colGender_Cus;
    @FXML
    private TableColumn<?, ?> colBirth_Cus;
    @FXML
    private TableColumn<?, ?> colPhone_Cus;
    @FXML
    private TableColumn<?, ?> colPoint_Cus;
    @FXML
    private ImageView View_Ser;
    @FXML
    private Button btnImg_Ser;
    @FXML
    private TextField tfName_Ser;
    @FXML
    private PasswordField tfPrice_Ser;
    @FXML
    private ComboBox<?> cbType_Ser;
    @FXML
    private Spinner<?> Quantity_Ser;
    @FXML
    private Button btnAdd_Ser;
    @FXML
    private Button btnClear_Ser;
    @FXML
    private Button btnUpdate_Ser;
    @FXML
    private Button btnDelete_Ser;
    @FXML
    private TextField btnSearch_Ser;
    @FXML
    private TableView<?> tbView_Ser;
    @FXML
    private TableColumn<?, ?> colImg_Ser;
    @FXML
    private TableColumn<?, ?> colName_Ser;
    @FXML
    private TableColumn<?, ?> colType_Ser;
    @FXML
    private TableColumn<?, ?> colPrice_Ser;
    @FXML
    private TableColumn<?, ?> colQoh_Ser;
    @FXML
    private PasswordField tfPass2;
    @FXML
    private AnchorPane admin_page;
    @FXML
    private BorderPane CusPage;
    @FXML
    private BorderPane PitPage;
    @FXML
    private BorderPane SerPage;
    @FXML
    private BorderPane CatePage;
    @FXML
    private Button btnPitPage;
    @FXML
    private Button btnClose;
    @FXML
    private Button btnBillPage;
    @FXML
    private Button btnPayPage;
    @FXML
    private Button btnSalesPage;

    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void minimize() {
        Stage stage = (Stage) admin_page.getScene().getWindow();
        stage.setIconified(true);
    }
    
    @FXML
    public void switchPage(ActionEvent event) {
        List<Node> pages = new ArrayList<>();
        List<Button> buttons = new ArrayList<>();

        //page
        pages.add(UserPage);
        pages.add(CusPage);
        pages.add(PitPage);
        pages.add(SerPage);
        pages.add(CatePage);
        //btn
        buttons.add(btnUserPage);
        buttons.add(btnCusPage);
        buttons.add(btnPitPage);
        buttons.add(btnSerPage);
        buttons.add(btnCatePage);

        for (int i = 0; i < buttons.size(); i++) {
            if (event.getSource() == buttons.get(i)) {
                for (int j = 0; j < pages.size(); j++) {
                    pages.get(j).setVisible(i == j);
                    buttons.get(j).setStyle(i == j
                            ? "-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f); -fx-scale-x: 1.1; -fx-scale-y: 1.1;"
                            : "-fx-background-color: transparent");
                }
                break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
