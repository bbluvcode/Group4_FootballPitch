/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.democrud;

import DAO.PaymentBillDAO;
import Entities.Service;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class CardServiceController implements Initializable {

    @FXML
    private AnchorPane ser_card_form;
    @FXML
    private Label ser_name;
    @FXML
    private Label ser_price;
    @FXML
    private ImageView ser_imageView;
    @FXML
    private Button ser_addBtn;

    private int idb;
    private int idc;
    private int ids;
    private Service ser_Data;
    private Image image;
    private final String IMAGE_DIR = "../src/main/resources/com/mycompany/imageView/";

    public void setData(Service ser) {
        ser_Data = ser;

        ser_name.setText(ser.getName());
        ser_price.setText("" + ser.getPrice());
        String path = "file:/" + IMAGE_DIR + ser.getImg();
        image = new Image(path, 176, 112, false, true);
        ser_imageView.setImage(image);
        idb = ser.getIdb();
        idc = ser.getIdc();
        ids = ser.getIds();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addBtn(ActionEvent event) {
        PaymentBillDAO pDAO = new PaymentBillDAO();
        pDAO.addServiceToBill(idb, ids, idc);
        //PagesController mainPage = new PagesController();
       // mainPage.menuDisplayCard_Ser(idb);
    }

}
