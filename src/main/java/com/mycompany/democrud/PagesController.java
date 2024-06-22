/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.democrud;

import DAO.*;
import Entities.Booking;
import Entities.PaymentBill;
import Entities.User;

import java.net.URL;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ADMIN
 * <p>
 * hoi co lam sao để thiết lap đinh dang nhạp cho txt là time
 */
public class PagesController implements Initializable {

    Alert alert;
    PitchDAO pDAO;
    UserDAO userDAO;
    CustomerDAO cusDAO;
    PaymentBillDAO pmDAO = new PaymentBillDAO();
    BookingDAO bkDAO = new BookingDAO();
    Optional<Booking> opBk;
    Booking bk = new Booking();

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
    private TableView<Pitch> tvBooked_PitchObservableList_Booking;
    @FXML
    private ComboBox<String> cboIdk_Booking;
    @FXML
    private TextField txtTimeStart_Booking;
    @FXML
    private Spinner<Integer> spnHrs_Booking;
    @FXML
    private Spinner<Integer> spnHour_timeBook_Booking;
    @FXML
    private Spinner<Integer> spnMinute_timeBook_Booking;
    @FXML
    private StackPane stpTimeBook_Booking;
    @FXML
    private TextField txtDeposit_Booking;
    @FXML
    private Label lbNameTable_booking;
    @FXML
    private Label lbNamePitch_Booking;
    @FXML
    private Label lbIdb_booking;
    @FXML
    private Label lbIdu_booking;
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

        initialize_manageBooking();
    }
    //**initialize**
    public void initialize_manageBooking() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        spnHrs_Booking.setValueFactory(valueFactory);
        setItem_cboIdk_Booking();

        //Disible Button_Booking

        setBtnNOTvisible(btnBooking_Booking);
        showPitchObservableList_Booking(3);
    }

    //**MANAGE BOOKING**
    public void showPitchObservableList_Booking(int available) {
        String nameTableObservableList = available == 1 ? "Available" : available == 2 ? "Renting" : "Booking";

        try {
            pDAO = new PitchDAO();
            ObservableList<Pitch> pitchBookedObservableList = pDAO.getByAvailable(available);
            lbNameTable_booking.setText(nameTableObservableList + " Pitch List");
            colNamePitch_Booking.setCellValueFactory(new PropertyValueFactory<>("name"));
            colNoPitch_Booking.setCellValueFactory(new PropertyValueFactory<>("no"));
            colPricePitch_Booking.setCellValueFactory(new PropertyValueFactory<>("price"));
            colSizePitch_Booking.setCellValueFactory(new PropertyValueFactory<>("size"));

            tvBooked_PitchObservableList_Booking.setItems(pitchBookedObservableList);

            tvBooked_PitchObservableList_Booking.getSelectionModel().selectFirst();
            tvBooked_PitchObservableList_Booking.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            selectPitch_Booking();
        } catch (Exception e) {
            reset_Booking();
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Show");
            alert.setHeaderText(nameTableObservableList + " Pitch List is empty");
            alert.setContentText("Something wrong, try again!");
            alert.show();
        }

    }

    public void reset_Booking() {
        txtDeposit_Booking.clear();
        txtTimeStart_Booking.clear();
        spnHrs_Booking.getValueFactory().setValue(0);
        cboIdk_Booking.getSelectionModel().clearSelection();
        cboIdk_Booking.setValue("");
        lbNamePitch_Booking.setText("...");
        lbIDP_hide_Booking.setText("");
        lbIdb_booking.setText("");
    }

    public void setItem_cboIdk_Booking() {
        cusDAO = new CustomerDAO();
        ObservableList<String> ID_CusObservableList = cusDAO.getAll_ID_Cus();
        cboIdk_Booking.setItems(ID_CusObservableList);
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

    void Click_spnHour_timeBook_Booking() {
        LocalTime crHrs = LocalTime.now().plusMinutes(15);
        int crHours = crHrs.getHour();
        int crMinutes = crHrs.getMinute();

        int spnHour = spnHour_timeBook_Booking.getValue();
        if (spnHour == crHours) {
            SpinnerValueFactory<Integer> valueMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(crMinutes, 55, crMinutes, 5);
            spnMinute_timeBook_Booking.setValueFactory(valueMinute);
        } else {
            SpinnerValueFactory<Integer> valueMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 55, 0, 5);
            spnMinute_timeBook_Booking.setValueFactory(valueMinute);
        }
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
        Pitch itemSelect = tvBooked_PitchObservableList_Booking.getSelectionModel().getSelectedItem();
        lbNamePitch_Booking.setText(itemSelect.getName());
        lbIDP_hide_Booking.setText("" + itemSelect.getIdp());
        int stt;
        if (itemSelect.getAvailable() != 1) {
            stt = 2;
            if (itemSelect.getAvailable() == 3) {
                stt = 1;
                btnStart_Booking.setVisible(true);
            }
            bk = new Booking();
            bkDAO = new BookingDAO();
            bkDAO.getAll();
            opBk = bkDAO.getBookingByPitch(itemSelect.getIdp(), stt);
            if (opBk.isEmpty()) {
                System.out.println("Cannot found booking");
                reset_Booking();
                return;
            }
            bk = opBk.get();
            txtDeposit_Booking.setText("" + bk.getDep());
            txtTimeStart_Booking.setText(bk.getTime_book().toString());
            spnHrs_Booking.getValueFactory().setValue(bk.getHrs());
            lbIdb_booking.setText("" + bk.getIdb());
            cboIdk_Booking.setValue(bk.getIdk());
            lbIdu_booking.setText(bk.getIdu());
        }
    }

    @FXML
    private void btnReset_Booking(ActionEvent event) {
        reset_Booking();
    }

    @FXML
    private void btnAdd_Booking(ActionEvent event) {

        int hrstimebook = spnHour_timeBook_Booking.getValue();
        int minutes = spnMinute_timeBook_Booking.getValue();

        txtTimeStart_Booking.setText(hrstimebook + ":" + minutes + ":" + "00");

        if (cboIdk_Booking.getValue().equals("")) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select customer");
            alert.showAndWait();
            return;
        }

        if (txtDeposit_Booking.getText().equals("") || txtDeposit_Booking.getText().equals("0")) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter deposit");
            alert.showAndWait();
            return;
        }

        if (lbIDP_hide_Booking.getText().equals("")) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select pitch");
            alert.showAndWait();
            return;
        } else {
            int idp = Integer.parseInt(lbIDP_hide_Booking.getText());
            String idu = lbIdu_booking.getText();
            String idk = cboIdk_Booking.getValue();
            int hrs = spnHrs_Booking.getValue();
            int deposit = Integer.parseInt(txtDeposit_Booking.getText());
            int stt = 1;
            Time time_book;
            try {
                time_book = Time.valueOf(txtTimeStart_Booking.getText());
            } catch (Exception ex) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select time");
                alert.showAndWait();
                return;
            }
            bk = new Booking();
            bk.setIdp(idp);
            bk.setIdk(idk);
            bk.setIdu(idu);
            bk.setDep(deposit);
            bk.setTime_book(time_book);
            bk.setHrs(hrs);
            bk.setStt(stt);

            bkDAO.Insert(bk);

            System.out.println("ADDED BOOOKING");
            showPitchObservableList_Booking(3);

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Added Booking");
            alert.setHeaderText(null);
            alert.setContentText("Booking Updated");
            alert.showAndWait();

            setBtnVisible(btnNew_Booking);
            setBtnNOTvisible(btnAdd_Booking);
            showPitchObservableList_Booking(3);
            stpTimeBook_Booking.setVisible(true);

        }
    }

    @FXML
    private void btnDelete_Booking(ActionEvent event) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Booking");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this booking?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int idb = Integer.parseInt(lbIdb_booking.getText());
            bkDAO.UpdateSTT(idb, 3);
            pDAO = new PitchDAO();
            pDAO.UpdateAvailable(Integer.parseInt(lbIDP_hide_Booking.getText()), 1);
            System.out.println("Deleted Booking");
            showPitchObservableList_Booking(3);
        } else {
            System.out.println("Cancel Delete Booking");
        }
    }

    @FXML
    private void btnUpdate_Booking(ActionEvent event) {
        bk = new Booking();
        bk.setIdk(cboIdk_Booking.getValue());
        bk.setDep(Integer.parseInt(txtDeposit_Booking.getText()));
        bk.setTime_book(Time.valueOf(txtTimeStart_Booking.getText()));
        bk.setHrs(spnHrs_Booking.getValue());
        bk.setIdp(Integer.parseInt(lbIDP_hide_Booking.getText()));
        int idb = Integer.parseInt(lbIdb_booking.getText());
        bkDAO.Update(idb, bk);
        System.out.println("Updated Booking");
        showPitchObservableList_Booking(3);

        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Updated Booking");
        alert.setHeaderText(null);
        alert.setContentText("Booking Updated");
        alert.showAndWait();
    }

    @FXML
    private void btnNew_Booking(ActionEvent event) {

        showPitchObservableList_Booking(1);

        stpTimeBook_Booking.setVisible(false);
        LocalTime crHrs = LocalTime.now().plusMinutes(15);
        int crHours = crHrs.getHour();
        SpinnerValueFactory<Integer> valueHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(crHours, 18, crHours);
        spnHour_timeBook_Booking.setValueFactory(valueHour);
        Click_spnHour_timeBook_Booking();


        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Message");
        alert.setHeaderText("Please select a available pitch from ObservableList!");
        alert.show();

        changeVisibleBtn_Booking(btnNew_Booking.getId());
        lbNameTable_booking.getStyleClass().removeAll("update-btn");
        lbNameTable_booking.getStyleClass().removeAll("complete-btn");
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
        stpTimeBook_Booking.setVisible(true);

        changeVisibleBtn_Booking(btnBooking_Booking.getId());
        showPitchObservableList_Booking(3);

        lbNameTable_booking.getStyleClass().removeAll("add-btn");
        lbNameTable_booking.getStyleClass().removeAll("delete-btn");
        lbNameTable_booking.getStyleClass().add("update-btn");

        setBtnDisible_Booking();
        btnDelete_Booking.setDisable(false);
        btnUpdate_Booking.setDisable(false);
        setDisableInput_Booking(false);
        txtDeposit_Booking.setVisible(true);
    }

    @FXML
    private void btnComplete_Booking(ActionEvent event) {
        lbNameTable_booking.getStyleClass().removeAll("add-btn");
        lbNameTable_booking.getStyleClass().removeAll("update-btn");
        lbNameTable_booking.getStyleClass().add("delete-btn");
        changeVisibleBtn_Booking(btnComplete_Booking.getId());
        showPitchObservableList_Booking(2);
        setBtnDisible_Booking();
        selectPitch_Booking();
        setDisableInput_Booking(true);
        txtDeposit_Booking.setVisible(true);
        stpTimeBook_Booking.setVisible(true);

    }

    @FXML
    private void btnStart_Booking(ActionEvent event) { //cập nhật thời gian bắt đầu
        try {
            int idb = Integer.parseInt(lbIdb_booking.getText());
            int idp = Integer.parseInt(lbIDP_hide_Booking.getText());

            if (idb > 0) {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Confirmation customer start use pitch");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    pmDAO.UpdateTimeStart(idb);
                    initialize_manageBooking();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Pitch " + idp + " start for rent!");
                    alert.show();
                }
            }
        } catch (Exception e) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message");
            alert.setHeaderText("Cannot start pitch booking!");
            alert.show();
        }
    }

    @FXML
    void Click_spnHour_timeBook_Booking(MouseEvent event) {
        Click_spnHour_timeBook_Booking();
    }


}
