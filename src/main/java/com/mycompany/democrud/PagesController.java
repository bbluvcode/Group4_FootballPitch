/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.democrud;

import DAO.*;
import Entities.Booking;
import Entities.Customer;
import Entities.PaymentBill;
import Entities.Service;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author ADMIN
 * <p>
 */
public class PagesController implements Initializable {

    Alert alert;
    PitchDAO pDAO = new PitchDAO();
    UserDAO userDAO = new UserDAO();
    CustomerDAO cusDAO = new CustomerDAO();
    PaymentBillDAO pmDAO = new PaymentBillDAO();
    BookingDAO bkDAO = new BookingDAO();
    Optional<Booking> opBk;
    Optional<PaymentBill> opPm;
    Booking bk = new Booking();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    //===========================================================
    //=============Manage Booking================================
    //===========================================================
    @FXML
    private Button btnClose;
    @FXML
    private Button btnMini;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnBillPage;
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
    //=========================End manage booking================
    //===========================================================
    //=============New Customer==================================
    //===========================================================
    @FXML
    private Button btnEmployeePage;
    @FXML
    private Button btnCustomerPage;
    @FXML
    private Button btnSportPage;
    @FXML
    private Button btnServicePage;
    @FXML
    private Button btnCatePage;
    @FXML
    private ImageView ivEmployee;
    @FXML
    private Label tfEmployeeName;
    @FXML
    private TextField txtFullName_Cus;
    @FXML
    private TextField txtPhone_Cus;
    @FXML
    private Button btnSave_Cus;
    @FXML
    private Button btnCancel_Cus;
    @FXML
    private Label lbIDP_hide_Booking1;
    //=========================End manage booking================
    //===========================================================
    //=============New Customer==================================
    //===========================================================
    @FXML
    private AnchorPane pAcNewCus_Page;
    @FXML
    private TextField txtMail_Cus;
    @FXML
    private BorderPane pBdpManagebooking_page;
    //=========================End new Customer================
    //===========================================================
    //============= Bill ==================================
    //===========================================================
    @FXML
    private BorderPane pBdpBillDetail_page;
    @FXML
    private Button btnBillDetail_Booking;
    @FXML
    private TableView<Service> tvService_Bill;
    @FXML
    private TableColumn<Integer, Integer> colNoSer_Bill;
    @FXML
    private TableColumn<Service, String> colNameSer_Bill;
    @FXML
    private TableColumn<Service, Integer> colPriceSer_Bill;
    @FXML
    private TableColumn<Service, Integer> colQtySer_Bill;
    @FXML
    private TableColumn<Service, Integer> colTotalSer_Bill;
    @FXML
    private ComboBox<String> cboCus_Bill;
    @FXML
    private TextField txtTimeBook_Bill;
    @FXML
    private TextField txtDeposit_Bill;
    @FXML
    private TextField txtTimeStart_Bill;
    @FXML
    private TextField txtTimeEnd_Bill;
    @FXML
    private TextField txtHrsUsed_Bill;
    @FXML
    private Label lbPaytime_Bill;
    @FXML
    private Label lbStaffID_Bill;
    @FXML
    private Label lbSubtotal_Bill;
    @FXML
    private Label lbTax_Bill;
    @FXML
    private Label lbTotal_Bill;
    @FXML
    private Button btnCheckOut_Bill;
    @FXML
    private Button btnAddSer_Bill;
    @FXML
    private Button btnUpdate_Bill;
    @FXML
    private TextField txtSearch_Bill;
    @FXML
    private Button btnClearFilter_Bill;
    @FXML
    private TableView<PaymentBill> tvBillPayment_Bill;
    @FXML
    private TableColumn<PaymentBill, Integer> col_idb_Bill;
    @FXML
    private TableColumn<PaymentBill, Integer> col_idp_Bill;
    @FXML
    private TableColumn<PaymentBill, Integer> col_ttpay_Bill;
    @FXML
    private Label lb_paydate_Bill;
    @FXML
    private Label lb_idp_Bill;
    @FXML
    private Label lb_idb_Bill;
    @FXML
    private DatePicker dpk_DateFilter_Bill;
    @FXML
    private TableColumn<PaymentBill, String> col_idk_Bill;
    @FXML
    private Button btnAddNew_Bill;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initialize_manageBooking();
        initialize_Bill();
    }


    private void OnlyEnterNumber(TextField name) {
        // Kết nối sự kiện KeyTyped cho TextField
        //name.addEventFilter(KeyEvent.KEY_TYPED, this::OnlyEnterNumber);

        // Thêm ChangeListener để kiểm tra dữ liệu đầu vào
        name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                name.setText(newValue.replaceAll("[^\\d]", ""));
                alert = new Alert(Alert.AlertType.ERROR, "Only enter numbers, Please!", ButtonType.OK);
                alert.showAndWait();
            }
        });
    }

    //================================================================================================================
    //==============================================**MANAGE BOOKING**==============================================
    //================================================================================================================
    //**initialize**
    public void initialize_manageBooking() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        spnHrs_Booking.setValueFactory(valueFactory);
        setItem_cboIdk_Booking(cboIdk_Booking);
        //Disible Button_Booking
        setBtnNOTvisible(btnBooking_Booking);
        showPitchObservableList_Booking(3);
        OnlyEnterNumber(txtDeposit_Booking);
    }

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

    public void setItem_cboIdk_Booking(ComboBox combobox) {
        cusDAO = new CustomerDAO();
        ObservableList<String> ID_CusObservableList = cusDAO.getAll_ID_Cus();
        combobox.setItems(ID_CusObservableList);
        combobox.setPromptText(" Select...");
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

    @FXML
    public void selectPitch_Booking() {
        try {
            Pitch itemSelect = tvBooked_PitchObservableList_Booking.getSelectionModel().getSelectedItem();
            lbNamePitch_Booking.setText(itemSelect.getName());
            lbIDP_hide_Booking.setText("" + itemSelect.getIdp());
            btnBillDetail_Booking.setVisible(false);
            btnStart_Booking.setVisible(false);

            int stt;
            if (itemSelect.getAvailable() != 1) {
                stt = 1;
                if (itemSelect.getAvailable() == 3) {
                    btnStart_Booking.setVisible(true);
                }
                if (itemSelect.getAvailable() == 2) {
                    stt = 2;
                    btnBillDetail_Booking.setVisible(true);
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
        } catch (Exception e) {
            reset_Booking();
        }
    }


    @FXML
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
        //List<Node> pages = Arrays.asList(EmployeePage, CustomerPage, SportPage, ServicePage, CatePage, BillPage, PaymentPage, DashboardPage);
        //List<Button> buttons = Arrays.asList(btnEmployeePage, btnCustomerPage, btnSportPage, btnServicePage, btnCatePage, btnBillPage);
        List<Button> buttons = Arrays.asList(btnCustomerPage, btnSportPage, btnBillPage);
        List<Node> pages = Arrays.asList(pAcNewCus_Page, pBdpManagebooking_page, pBdpBillDetail_page);

        for (int i = 0; i < buttons.size(); i++) {
            if (event.getSource() == buttons.get(i)) {
                for (int j = 0; j < pages.size(); j++) {
                    pages.get(j).setVisible(i == j);
                    buttons.get(j).setStyle(i == j
                            ? "-fx-background-color: linear-gradient(to bottom right, #d3133d, #a4262f); -fx-scale-x: 1.1; -fx-scale-y: 1.1;"
                            : "-fx-background-color: transparent; -fx-scale-x: 1.0; -fx-scale-y: 1.0;");
                }
                break;
            }
        }
    }

    private void selectPitch_Booking(MouseEvent event) {
        selectPitch_Booking();
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
            alert.setContentText("Booking Added Successfully!");
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
        SpinnerValueFactory<Integer> valueHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(crHours, 23, crHours);
        spnHour_timeBook_Booking.setValueFactory(valueHour);
        Click_spnHour_timeBook_Booking();

        Alert alert = new Alert(AlertType.INFORMATION);
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

    private void Click_spnHour_timeBook_Booking(MouseEvent event) {
        Click_spnHour_timeBook_Booking();
    }

    @FXML
    private void BillDetail_Booking(ActionEvent event) {
        pBdpBillDetail_page.setVisible(true);
        btnBillPage.setStyle("-fx-background-color: linear-gradient(to bottom right, #d3133d, #a4262f); -fx-scale-x: 1.1; -fx-scale-y: 1.1;");

        pBdpManagebooking_page.setVisible(false);
        btnSportPage.setStyle("-fx-background-color: transparent; -fx-scale-x: 1.0; -fx-scale-y: 1.0;");

        initialize_Bill();
        tvBillPayment_Bill.getSelectionModel().selectLast();
        SelectBill_Bill();
    }

    //==============================================**END MANAGE BOOKING**==============================================
    //================================================================================================================
    //==============================================**ADD CUSTOMER**==============================================

    @FXML
    private void signout(ActionEvent event) {
    }

    @FXML
    private void editProfile(ActionEvent event) {
    }

    @FXML
    private void Save_Cus(ActionEvent event) {
        String fullname = txtFullName_Cus.getText();
        String sdt = txtPhone_Cus.getText();
        String mail = txtMail_Cus.getText();

        if (fullname.isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message");
            alert.setHeaderText("Full name cannot blank");
            alert.show();
            return;
        }
//        if (mail.isEmpty()) {
//            alert = new Alert(AlertType.ERROR);
//            System.out.println("mail cannot blank");
//        }
        if (sdt.length() < 10) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message");
            alert.setHeaderText("Phone number cannot blank");
            alert.show();

        } else {
            Customer cus = new Customer(sdt, fullname, sdt, 0, mail);
            cusDAO.Insert(cus);
            alert = new Alert(AlertType.CONFIRMATION);
            pAcNewCus_Page.setVisible(false);
            setItem_cboIdk_Booking(cboIdk_Booking);

        }
    }

    @FXML
    private void Cancel_Cus(ActionEvent event) {
        pAcNewCus_Page.setVisible(false);
    }

    @FXML
    private void NewCus_Booking(ActionEvent event) {
        pAcNewCus_Page.setVisible(true);
        OnlyEnterNumber(txtPhone_Cus);
    }

    @FXML
    private void btnReset_Cus(ActionEvent event) {
        btnReset_Cus();
    }

    private void btnReset_Cus() {
        txtFullName_Cus.setText("");
        txtPhone_Cus.setText("");
        txtMail_Cus.setText("");
    }

    //==============================================**END ADD CUSTOMER**==============================================
    //================================================================================================================
    //==============================================**DETAIL BILL**==============================================
    public void initialize_Bill() {
/*        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        spnHrs_Booking.setValueFactory(valueFactory);
        //setItem_cboIdk_Booking();
        //Disible Button_Booking
        setBtnNOTvisible(btnBooking_Booking);
        showPitchObservableList_Booking(3);
        OnlyEnterNumber(txtDeposit_Booking);*/
        Display_BillPaymentList_Bill();
    }


    @FXML
    private void CheckOut_Bill(ActionEvent event) {
    }

    @FXML
    private void AddService_Bill(ActionEvent event) {
    }

    @FXML
    private void Update_Bill(ActionEvent event) {
        int idb = Integer.parseInt(lb_idb_Bill.getText());
        int idp = Integer.parseInt(lb_idp_Bill.getText());
        String idk = cboCus_Bill.getValue();
        Time time_start = Time.valueOf(txtTimeStart_Bill.getText());
        Time time_end;
        try {
            time_end = Time.valueOf(txtTimeEnd_Bill.getText());
            System.out.println("trong try");
        } catch (Exception e) {
            time_end = null;
            System.out.println("torng catch");
        }
        int hrs_used = Integer.parseInt(txtHrsUsed_Bill.getText());
        Date pay_date = Date.valueOf(lb_paydate_Bill.getText());
        int deposit = Integer.parseInt(txtDeposit_Bill.getText());
        int tt_booking = Integer.parseInt(lbTax_Bill.getText());
        int tt_service = Integer.parseInt(lbSubtotal_Bill.getText());
        int tt_payment = Integer.parseInt(lbTotal_Bill.getText());
        Time time_book = Time.valueOf(txtTimeBook_Bill.getText());

        PaymentBill pb = new PaymentBill(idb, idp, idk, time_start, time_end, hrs_used, pay_date, deposit, tt_booking, tt_service, tt_payment, time_book);
        PaymentBillDAO pbDAO = new PaymentBillDAO();
        pbDAO.Update(idb, pb);

        Display_BillPaymentList_Bill();

    }

    @FXML
    private void ClearFilter_Bill(ActionEvent event) {
    }

    @FXML
    private void SelectBill_Bill(MouseEvent event) {
        SelectBill_Bill();
    }

    private void SelectBill_Bill() {
        try {
            btnCheckOut_Bill.setDisable(true);
            PaymentBill pSelected = tvBillPayment_Bill.getSelectionModel().getSelectedItem();
            pmDAO = new PaymentBillDAO();
            pmDAO.getAll();
            opPm = pmDAO.GetById(pSelected.getIdb());
            if (opPm.isEmpty()) {
                System.out.println("Cannot found bill");
                reset_Booking();
                return;
            }
            PaymentBill pb = opPm.get();

            int subtotalService = 0;
//            int subtotalService = pb.getTt_service();
            int subtotalPitchFee = pb.getTt_booking();
            int total = pb.getTt_payment();

            int price_pitch = pb.getPrice_pitch();
            LocalTime StartTime = pb.getTime_start().toLocalTime();
            String end_time = String.valueOf(pb.getTime_end());
            int hrs_used = pb.getHrs_used();
            if (end_time.equals("null") || end_time.isEmpty()) {
                btnCheckOut_Bill.setDisable(false);

                end_time = "...";

                LocalTime EndTime = LocalTime.now();
                Duration duration = Duration.between(StartTime, EndTime);

                hrs_used = (int) duration.toHours();
                hrs_used = Math.abs(hrs_used);
                if (hrs_used == 0 || hrs_used > 0 && duration.toMinutes() >= 15) {
                    hrs_used++;
                }

//                subtotalService = Display_ServiceList_Bill(pb.getIdb());            ;
//                subtotalPitchFee = price_pitch * hrs_used;
//                total = subtotalService + subtotalPitchFee;
//                System.out.println("total new: " + total);
            }

            subtotalService = Display_ServiceList_Bill(pb.getIdb());
            ;
            subtotalPitchFee = price_pitch * hrs_used;
            total = subtotalService + subtotalPitchFee;

            lb_paydate_Bill.setText(String.valueOf(pb.getPay_date()));
            lb_idb_Bill.setText(String.valueOf(pb.getIdb()));
            lb_idp_Bill.setText(String.valueOf(pb.getIdp()));
            cboCus_Bill.setValue(pb.getIdk());
            lbTotal_Bill.setText(String.valueOf(pb.getTt_payment()));

            txtTimeBook_Bill.setText(String.valueOf(pb.getTime_book()));
            txtDeposit_Bill.setText(String.valueOf(pb.getDeposit()));
            txtTimeStart_Bill.setText(String.valueOf(pb.getTime_start()));
            txtTimeEnd_Bill.setText(end_time);
            txtHrsUsed_Bill.setText("" + hrs_used);
            lbPaytime_Bill.setText(end_time);
            lbStaffID_Bill.setText(pb.getQluser_name() + " - " + pb.getIdu());

            lbSubtotal_Bill.setText(String.valueOf(subtotalService));
            lbTax_Bill.setText(String.valueOf(subtotalPitchFee));
            lbTotal_Bill.setText(String.valueOf(total));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Display_BillPaymentList_Bill() {
        pmDAO = new PaymentBillDAO();
        ObservableList<PaymentBill> bList = pmDAO.getAll();
        col_idb_Bill.setCellValueFactory(new PropertyValueFactory<>("idb"));
        col_idp_Bill.setCellValueFactory(new PropertyValueFactory<>("idp"));
        col_idk_Bill.setCellValueFactory(new PropertyValueFactory<>("idk"));
        col_ttpay_Bill.setCellValueFactory(new PropertyValueFactory<>("tt_payment"));

        tvBillPayment_Bill.setItems(bList);
    }

    private int Display_ServiceList_Bill(int idb) {
        pmDAO = new PaymentBillDAO();
        ObservableList<Service> sList = pmDAO.getAllSerVice(idb);
        colNoSer_Bill.setCellValueFactory(new PropertyValueFactory<>("no"));
        colNameSer_Bill.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPriceSer_Bill.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQtySer_Bill.setCellValueFactory(new PropertyValueFactory<>("qoh"));
        colTotalSer_Bill.setCellValueFactory(new PropertyValueFactory<>("total"));
        tvService_Bill.setItems(sList);

        int subtotal = 0;
        for (Service s : sList) {
            subtotal += s.getTotal();
        }

        return subtotal;
    }

    @FXML
    private void AddNew_Bill(ActionEvent event) {
    }

    @FXML
    private void Search_Bill(KeyEvent event) {
        System.out.println("test search");
        FilteredList<PaymentBill> filteredData = new FilteredList<>(pmDAO.pbObservableList, p -> true);

        System.out.println(txtSearch_Bill.getText());
        String newValue = txtSearch_Bill.getText().toLowerCase();
//        ObservableList<PaymentBill> subList = filteredData.filtered(p -> p.getIdb() == Integer.parseInt(txtSearch_Bill.getText()));
        ObservableList<PaymentBill> subList = filteredData.filtered(p -> {
//            return p.getIdb() == Integer.parseInt(txtSearch_Bill.getText());
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue;
                if (p.getIdk().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
            if (String.valueOf(p.getIdb()).equals(lowerCaseFilter)) {
                return true;
            }

            return false;
        });
//        txtSearch_Bill.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate(p -> {
//                System.out.println("search--");
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                String lowerCaseFilter = newValue.toLowerCase();
////                if (p.getIdk().toLowerCase().contains(lowerCaseFilter)) {
////                    return true;
////                }
//                if (String.valueOf(p.getIdb()).equals(lowerCaseFilter)) {
//                    return true;
//                }
//                if (String.valueOf(p.getIdp()).equals(lowerCaseFilter)) {
//                    return true;
//                }
////                if (String.valueOf(p.getTt_payment()).contains(lowerCaseFilter)) {
////                    return true;
////                }
//                System.out.println("search: " + lowerCaseFilter);
//
//                return false;
//
//            });
//        });
        //SortedList<PaymentBill> sortedData = new SortedList<>(filteredData);
        //sortedData.comparatorProperty().bind(tvBillPayment_Bill.comparatorProperty());
        tvBillPayment_Bill.setItems(subList);
    }

    @FXML
    private void SearchPitch_Booking(KeyEvent event) {
    }
}
