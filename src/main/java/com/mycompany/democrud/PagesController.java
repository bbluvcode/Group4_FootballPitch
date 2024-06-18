/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.democrud;

import DAO.BookingDAO;
import DAO.PaymentBillDAO;
import DAO.PitchDAO;
import DAO.UserDAO;
import Entities.Booking;
import Entities.PaymentBill;
import Entities.User;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class PagesController implements Initializable {

    @FXML
    private Button btnClose;
    @FXML
    private Button btnMini;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnCusPage;
    @FXML
    private Button btnPitPage;
    @FXML
    private Button btnSerPage;
    @FXML
    private Button btnBillPage;
    @FXML
    private Button btnPayPage;
    @FXML
    private TableColumn<Integer, Integer> colNoPitch_Booking;
    @FXML
    private TableColumn<Pitch, String> colNamePitch_Booking;
    @FXML
    private TableColumn<Pitch, String> colSizePitch_Booking;
    @FXML
    private TableColumn<Pitch, String> colPricePitch_Booking;
    @FXML
    private TableView<Pitch> tvBooked_PitchList_Booking;
    @FXML
    private ComboBox<String> cboIdk_Booking;
    @FXML
    private TextField txtTimeStart_Booking;
    @FXML
    private Spinner<Integer> spnHrs_Booking;
    @FXML
    private TextField txtDeposit_Booking;
    @FXML
    private Label lbNameTable_booking;
    @FXML
    private Label lbNamePitch_Booking;
    @FXML
    private Button btnBooking_Booking;
    @FXML
    private Button btnNew_Booking;
    @FXML
    private Button btnComplete_Booking;
    @FXML
    private Button btnAdd_Booking;
    @FXML
    private Button btnDelete_Booking;
    @FXML
    private Button btnUpdate_Booking;
    @FXML
    private Button btnReset_Booking;
    @FXML
    private Label lbIDP_hide_Booking;
    @FXML
    private TextField txtSearch_Booking;
    @FXML
    private Button btnStart_Booking;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //**MANAGE BOOKING**
        
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        spnHrs_Booking.setValueFactory(valueFactory);
        setItem_cboIdk_Booking();

        //Disible Button_Booking
        setBtnNOTvisible(btnBooking_Booking);
        showPitchList_Booking(3);
        
        //****END - manage booking****      

    }

    BookingDAO bkDAO = new BookingDAO();
    Optional<Booking> opBk;
    Booking bk = new Booking();

    public void showPitchList_Booking(int available) {
        PitchDAO pDAO = new PitchDAO();
        ObservableList<Pitch> pitchBookedList = pDAO.getByAvailable(available);

        colNamePitch_Booking.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNoPitch_Booking.setCellValueFactory(new PropertyValueFactory<>("no"));
        colPricePitch_Booking.setCellValueFactory(new PropertyValueFactory<>("price"));
        colSizePitch_Booking.setCellValueFactory(new PropertyValueFactory<>("size"));

        tvBooked_PitchList_Booking.setItems(pitchBookedList);
        String nameTablelist = available == 1 ? "Available" : available == 2 ? "Renting" : "Booked";
        lbNameTable_booking.setText(nameTablelist + " Pitch List");

        tvBooked_PitchList_Booking.getSelectionModel().selectFirst();
        tvBooked_PitchList_Booking.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        selectPitch_Booking();
    }

    public void reset_Booking() {
        txtDeposit_Booking.clear();
        txtTimeStart_Booking.clear();
        spnHrs_Booking.getValueFactory().setValue(0);
        cboIdk_Booking.getSelectionModel().clearSelection();
        cboIdk_Booking.setValue("");
        lbNamePitch_Booking.setText("...");

    }

    public void setItem_cboIdk_Booking() {
        UserDAO cusDAO = new UserDAO();
        ObservableList<String> ID_CusList = cusDAO.getAll_ID_User();
        cboIdk_Booking.setItems(ID_CusList);
        cboIdk_Booking.setPromptText(" Select...");
    }

    public void setBtnVisible(Button fxid) {
        fxid.setVisible(true);
    }

    public void setBtnNOTvisible(Button fxid) {
        fxid.setVisible(false);
    }

    public void setBtnDisible_Booking() {
        btnAdd_Booking.setDisable(true);
        btnDelete_Booking.setDisable(true);
        btnUpdate_Booking.setDisable(true);
        btnReset_Booking.setDisable(false);
        setBtnNOTvisible(btnStart_Booking);
    }

    public void setDisableInput_Booking(boolean tf) {
        txtDeposit_Booking.setDisable(tf);
        txtTimeStart_Booking.setDisable(tf);
        spnHrs_Booking.setDisable(tf);
        btnReset_Booking.setDisable(tf);
        cboIdk_Booking.setDisable(tf);
    }

    void changeVisibleBtn_Booking(String btnId) {
        if (btnNew_Booking.getId().equals(btnId)) {
            btnNew_Booking.setVisible(false);
        } else {
            btnNew_Booking.setVisible(true);
        }
        if (btnBooking_Booking.getId().equals(btnId)) {
            btnBooking_Booking.setVisible(false);
        } else {
            btnBooking_Booking.setVisible(true);
        }
        if (btnComplete_Booking.getId().equals(btnId)) {
            btnComplete_Booking.setVisible(false);
        } else {
            btnComplete_Booking.setVisible(true);
        }

    }

    private void selectPitch_Booking(MouseEvent event) {
        selectPitch_Booking();
    }

    //====FXML ACTION====================================================================================================
    //====FXML ====================================================================================================
    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void minimize(ActionEvent event) {

    }

    @FXML
    private void switchPage(ActionEvent event) {
    }

    @FXML
    public void selectPitch_Booking() {
        Pitch itemSelect = tvBooked_PitchList_Booking.getSelectionModel().getSelectedItem();
        lbNamePitch_Booking.setText(itemSelect.getName());
        lbIDP_hide_Booking.setText("" + itemSelect.getIdp());

        if (itemSelect.getAvailable() != 1) {
            if (itemSelect.getAvailable() == 3) {
                setBtnVisible(btnStart_Booking);
            }
            bkDAO.getAll();
            opBk = bkDAO.getBookingByPitch(itemSelect.getIdp());
            if (opBk.isEmpty()) {
                System.out.println("Cannot found booking");
                reset_Booking();
                return;
            }
            bk = opBk.get();
            System.out.println(bk);
            txtDeposit_Booking.setText("" + bk.getDep());
            txtTimeStart_Booking.setText(bk.getTime_book().toString());
            spnHrs_Booking.getValueFactory().setValue(bk.getHrs());
            cboIdk_Booking.setValue(bk.getIdk());
        }
    }

    @FXML
    private void btnReset_Booking(ActionEvent event) {
        reset_Booking();
    }

    @FXML
    private void btnAdd_Booking(ActionEvent event) {

        setBtnVisible(btnNew_Booking);
        setBtnNOTvisible(btnAdd_Booking);
    }

    @FXML
    private void btnDelete_Booking(ActionEvent event) {
    }

    @FXML
    private void btnUpdate_Booking(ActionEvent event) {
    }

    @FXML
    private void btnNew_Booking(ActionEvent event) {
        showPitchList_Booking(1);
        Alert alert = new Alert(AlertType.ERROR);

        alert.setTitle("Message");
        alert.setHeaderText("Please select a available pitch from list!");
//        alert.setContentText("Please select a available from list!");
        alert.show();
        changeVisibleBtn_Booking(btnNew_Booking.getId());
        lbNameTable_booking.getStyleClass().removeAll("update-btn");
        lbNameTable_booking.getStyleClass().add("add-btn");

        txtTimeStart_Booking.focusTraversableProperty();
        setBtnDisible_Booking();
        btnAdd_Booking.setDisable(false);
        reset_Booking();
        setBtnNOTvisible(btnNew_Booking);
        setBtnVisible(btnAdd_Booking);
        setDisableInput_Booking(false);

    }

    @FXML
    private void btnBooking_Booking(ActionEvent event) {
        changeVisibleBtn_Booking(btnBooking_Booking.getId());
        showPitchList_Booking(3);
        lbNameTable_booking.getStyleClass().removeAll("add-btn");
        lbNameTable_booking.getStyleClass().add("update-btn");

        setBtnDisible_Booking();
        btnDelete_Booking.setDisable(false);
        btnUpdate_Booking.setDisable(false);
        setDisableInput_Booking(false);

    }

    @FXML
    private void btnComplete_Booking(ActionEvent event) {
        changeVisibleBtn_Booking(btnComplete_Booking.getId());
        showPitchList_Booking(2);
        setBtnDisible_Booking();

        selectPitch_Booking();
        setDisableInput_Booking(true);

    }

    @FXML
    private void btnStart_Booking(ActionEvent event) { //cập nhật thời gian bắt đầu
    }

}
