/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.group4_project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AdminPageController implements Initializable {

    @FXML
    private Button btnMini;
    @FXML
    private Button btnLogout;
    @FXML
    private MenuButton btnCatePage;
    @FXML
    private AnchorPane admin_page;
    @FXML
    private Button btnClose;
    @FXML
    private Button btnPaymentPage;
    @FXML
    private Button btnDashboardPage;
    @FXML
    private BorderPane DashboardPage;
    @FXML
    private BorderPane PaymentPage;
    @FXML
    private Button btnEmployeePage;
    @FXML
    private Button btnCustomerPage;
    @FXML
    private Button btnSportPage;
    @FXML
    private MenuButton btnServicePage;
    @FXML
    private BorderPane EmployeePage;
    @FXML
    private BorderPane CustomerPage;
    @FXML
    private BorderPane SportPage;
    @FXML
    private ImageView ivEmployee;
    @FXML
    private Label tfEmployeeName;
    @FXML
    private BorderPane EditProfilePage;
    @FXML
    private TextField tfPhone_EditProfile;
    @FXML
    private TextField tfName_EditProfile;
    @FXML
    private ToggleGroup gender_EditProfile;
    @FXML
    private DatePicker dpBirth_EditProfile;
    @FXML
    private ImageView View__EditProfile;
    @FXML
    private Button btnImg_EditProfile;
    @FXML
    private RadioButton rdMale;
    @FXML
    private RadioButton rdFemale;
    @FXML
    private TextField tfPosition_EditProfile;
    @FXML
    private Label lbMess_Name;
    @FXML
    private Label lbMess_Birth;
    //------------------------------------Image
    private final String IMAGE_DIR = "C:/2308/HK2/Project/Group4_Project/src/main/resources/com/mycompany/images/";
    private String selectImageName_EditUser;
    private String selectImageURL_EditUser;
    private String imageURL_EditUser;
    private Path from_EditUser, to_EditUser;
    private File selectedFile_EditUser;
    //--------------------------------------
    @FXML
    private BorderPane DetailPage;
    @FXML
    private AnchorPane openEditProfile;
    @FXML
    private AnchorPane openChangePassword;
    @FXML
    private Label lbCurPass_EditProfile;
    @FXML
    private PasswordField pfCurPass_EditProfile;
    @FXML
    private TextField tfCurPass_EditProfile;
    @FXML
    private Button btnshowCurPass_EditProfile;
    @FXML
    private Label lbNewPass_EditProfile;
    @FXML
    private PasswordField pfNewPass_EditProfile;
    @FXML
    private TextField tfNewPass_EditProfile;
    @FXML
    private Button btnhideNewPass_EditProfile;
    @FXML
    private PasswordField pfConfirm_EditProfile;
    @FXML
    private Button btnshowConfirm_EditProfile;
    @FXML
    private TextField tfConfirm_EditProfile;
    @FXML
    private Button btnhideConfirm_EditProfile;
    @FXML
    private Label lbConfirmPass_EditProfile;
    @FXML
    private Button btnhideCurPass_EditProfile;
    @FXML
    private Button btnshowNewPass_EditProfile;
    @FXML
    private TextField tfDeposit_Payment;
    @FXML
    private TextField tfStart_Payment;
    @FXML
    private RadioButton rdYes_Payment;
    @FXML
    private ToggleGroup completed_Pay;
    @FXML
    private RadioButton rdNo_Payment;
    @FXML
    private DatePicker dpDate_Payment;
    @FXML
    private TextField tfEnd_Payment;
    @FXML
    private ComboBox<String> cbEmpName_Payment;
    @FXML
    private ComboBox<String> cbPitchName_Payment;
    @FXML
    private ComboBox<String> cbStt_Payment;
    @FXML
    private TableView<PaymentBill> tvPayment;
    @FXML
    private TableColumn<PaymentBill, String> colEmpName_Payment;
    @FXML
    private TableColumn<PaymentBill, String> colPitchName_Payment;
    @FXML
    private TableColumn<PaymentBill, String> colCusName_Payment;
    @FXML
    private TableColumn<PaymentBill, Integer> colBooking_Payment;
    @FXML
    private TableColumn<PaymentBill, Integer> colSerivce_Payment;
    @FXML
    private TableColumn<PaymentBill, Integer> colPayment_Payment;
    @FXML
    private TableColumn<PaymentBill, Date> colDate_Payment;
    @FXML
    private TableColumn<PaymentBill, Integer> colHrsBooking_Payment;
    @FXML
    private TableColumn<PaymentBill, Time> colStart_Payment;
    @FXML
    private TableColumn<PaymentBill, Time> colEnd_Payment;
    @FXML
    private TableColumn<PaymentBill, Integer> colHrsUse_Payment;
    @FXML
    private TableColumn<PaymentBill, Boolean> colCompleted_Payment;
    @FXML
    private TableColumn<PaymentBill, Integer> colDeposit_Payment;
    @FXML
    private TableColumn<PaymentBill, Time> colTimeBooking_Payment;
    @FXML
    private TextField tfTimeBooking_Payment;
    @FXML
    private Spinner<Integer> spHrsBooking_Payment;
    @FXML
    private Label lbEmpName_Payment;
    @FXML
    private Label lbPitchName_Payment;
    @FXML
    private Label lbStatus_Payment;
    @FXML
    private Label lbCusName_Payment;
    @FXML
    private Label lbDeposit_Payment;
    @FXML
    private Label lbDate_Payment;
    @FXML
    private Label lbTimeBooking_Payment;
    @FXML
    private Label lbStart_Payment;
    @FXML
    private Label lbEnd_Payment;
    @FXML
    private ComboBox<String> cbCusName_Payment;
    @FXML
    private TableColumn<PaymentBill, Integer> colIdb_Payment;
    @FXML
    private TextField tfPayCode_DetailPay;
    @FXML
    private TextField tfCusName_DetailPay;
    @FXML
    private TextField tfPitName_DetailPay;
    @FXML
    private TextField tfEmpName_DetailPay;
    @FXML
    private TextField tfDeposit_DetailPay;
    @FXML
    private TextField tfBookng_DetailPay;
    @FXML
    private TextField tfService_DetailPay;
    @FXML
    private TextField tfTotalPay_DetailPay;
    @FXML
    private TableView<Composite_Bill> tvService_DetailPay;
    @FXML
    private TableColumn<Composite_Bill, String> colProductName_DetailPay;
    @FXML
    private TableColumn<Composite_Bill, String> colType_DetailPay;
    @FXML
    private TableColumn<Composite_Bill, Integer> colPrice_DetailPay;
    @FXML
    private TableColumn<Composite_Bill, Integer> colQuantity_DetailPay;
    @FXML
    private TableColumn<Composite_Bill, Integer> colTotal_DetailPay;
    @FXML
    private Spinner<Integer> spQuantity_DetailPay;
    @FXML
    private ComboBox<String> cbProductName_DetailPay;
    @FXML
    private RadioButton rdDrink_DetailPay;
    @FXML
    private ToggleGroup typeProduct_DetailPay;
    @FXML
    private RadioButton rdFood_DetailPay;
    @FXML
    private RadioButton rdAccess_DetailPay;
    @FXML
    private Label lbName_DetailPay;
    @FXML
    private Label lbQty_DetailPay;
    @FXML
    private TextField tfMail_EditProfile;
    @FXML
    private Label lbMess_Mail;
    @FXML
    private TextField tfPricePitch_Payment;
    @FXML
    private Button btnAdd_PaymentDetail;
    @FXML
    private Button btnClear_PaymentDetail;
    @FXML
    private Button btnUpdate_PaymentDetail;
    @FXML
    private Button btnDelete_PaymentDetail;
    @FXML
    private Button btnAdd_Payment;
    @FXML
    private Button btnUpdate_Payment;
    @FXML
    private Button btnClear_Payment;
    @FXML
    private Button btnDelete_Payment;
    @FXML
    ///--------------Employee
    private ImageView View_User;
    @FXML
    private Button btnImg_User;
    @FXML
    private TextField tfPhone_User;
    @FXML
    private PasswordField tfPass_User;
    @FXML
    private ComboBox<String> cbPos_User;
    @FXML
    private Button btnPosition_User;
    @FXML
    private TextField tfName_User;
    @FXML
    private RadioButton maleRadioButton_User;
    @FXML
    private ToggleGroup gender_User;
    @FXML
    private RadioButton femaleRadioButton_User;
    @FXML
    private DatePicker tfBirth_User;
    @FXML
    private TextField tfEmail_User;
    @FXML
    private Label btnConfirmE_Cus;
    @FXML
    private Button btnAdd_User;
    @FXML
    private Button btnClear_User;
    @FXML
    private Button btnUpdate_User;
    @FXML
    private Button btnDelete_User;
    @FXML
    private Label lblWarning_User;
    @FXML
    private TextField tfSearch_User;
    @FXML
    private TableView<User> tbView_User;
    @FXML
    private TableColumn<User, ImageView> colImg_User;
    @FXML
    private TableColumn<User, String> colName_User;
    @FXML
    private TableColumn<User, String> colPos_User;
    @FXML
    private TableColumn<User, String> colGender_User;
    @FXML
    private TableColumn<User, String> colBirth_User;
    @FXML
    private TableColumn<User, String> colPhone_User;
    @FXML
    private TableColumn<User, String> colEmail_User;
    @FXML
    private TableColumn<User, String> colPass_User;
    //--------------------------
    private String selectImageName;
    private Path from, to;
    private String selectImageURL;
    private File selectedFile;
    private String verificationCode;
    //-------------------------------

    //---------------------------Customer
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
    private TextField tfPoint_Cus;
    @FXML
    private TextField tfEmail_Cus;
    @FXML
    private Button btnAdd_Cus;
    @FXML
    private TextField tfSearch_Cus;
    @FXML
    private TableView<Customer> tbView_Cus;
    @FXML
    private TableColumn<Customer, String> colName_Cus;
    @FXML
    private TableColumn<Customer, String> colPhone_Cus;
    @FXML
    private TableColumn<Customer, Integer> colPoint_Cus;
    @FXML
    private TableColumn<Customer, String> colEmail_Cus;
    private Connection connection;
    private ObservableList<Customer> customerList;
    //----------------------
    @FXML
    private MenuItem btnSellServicePage;
    @FXML
    private MenuItem btnRentServicePage;
    @FXML
    private MenuItem btnCateServicePage;
    @FXML
    private MenuItem btnCatePitchPage;
    @FXML
    private BorderPane SellServicePage;
    @FXML
    private BorderPane RentServicePage;
    @FXML
    private BorderPane CatePitchPage;

    ////////////////////////////----------SellService
    private CategoryDAO categoryDAO;
    @FXML
    private ImageView imageview_SaleService;
    @FXML
    private Button btnImg_SaleService;
    @FXML
    private TextField tfName_SaleService;
    @FXML
    private TextField tfPrice_SaleService;
    @FXML
    private ComboBox<String> cbType_SaleService;
    @FXML
    private Spinner<Integer> Quantity_SaleService;
    @FXML
    private Button btnAdd_SaleService;
    @FXML
    private Button btnClear_SaleService;
    @FXML
    private Button btnUpdate_SaleService;
    @FXML
    private Button btnDelete_SaleService;
    @FXML
    private TextField btnSearch_Ser;
    @FXML
    private TableView<Service_Sell> tbView_Ser;
    @FXML
    private TableColumn<Service_Sell, ImageView> colImg_SaleService;
    @FXML
    private TableColumn<Service_Sell, String> colName_SaleService;
    @FXML
    private TableColumn<Service_Sell, String> colType_SaleService;
    @FXML
    private TableColumn<Service_Sell, Float> colPrice_SaleService;
    @FXML
    private TableColumn<Service_Sell, Integer> colQoh_SaleService;
    private final ObservableList<String> dataList = FXCollections.observableArrayList("Food", "Drink", "Accessories");

    //////////////////////---------------RentService
    @FXML
    private ImageView imageview_RentService;
    @FXML
    private Button btnImg_RentService;
    @FXML
    private TextField tfName_RentService;
    @FXML
    private TextField tfPrice_RentService;
    @FXML
    private ComboBox<String> cbType_RentService;
    @FXML
    private Spinner<Integer> Quantity_RentService;
    @FXML
    private Button btnAdd_RentService;
    @FXML
    private Button btnClear_RentService;
    @FXML
    private Button btnUpdate_RentService;
    @FXML
    private Button btnDelete_RentService;
    @FXML
    private TextField btnSearch_Ren;
    @FXML
    private TableView<Service_Rent> tbView_Ren;
    @FXML
    private TableColumn<Service_Rent, ImageView> colImg_RentService;
    @FXML
    private TableColumn<Service_Rent, String> colName_RentService;
    @FXML
    private TableColumn<Service_Rent, String> colType_RentService;
    @FXML
    private TableColumn<Service_Rent, Float> colPrice_RentService;
    @FXML
    private TableColumn<Service_Rent, Integer> colQoh_RentService;
    @FXML
    private TextField tfSearch_Payment;
    @FXML
    private BorderPane CateServicePage;
    @FXML
    private Label tfEmployeePosition;
    @FXML
    private DatePicker dpSelectDate_Payment;

    public AdminPageController() {
        this.categoryDAO = new CategoryDAO();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        setOpenPage();
        //Edit profile
        informationUser();
        //PaymentBill
        setupOpenPaymentBill();
        //Employee
        setupOpenEmployeePage();
        //Customer
        setupOpenCustomerPage();
        //SellService
        setupOpenSellServicePage();
        //RentService
        setupOpenRentServicePage();
    }

    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void minimize() {
        Stage stage = (Stage) admin_page.getScene().getWindow();
        stage.setIconified(true);
    }

    private void clearInSportPage() {

    }

    private void clearInDashboardPage() {

    }

    private void clearInCateServicePage() {

    }

    private void clearInCatePitchPage() {

    }

    @FXML
    public void switchPage(ActionEvent event) {
        EditProfilePage.setVisible(false);

        List<Node> pages = Arrays.asList(
                EmployeePage, CustomerPage, SportPage, PaymentPage, DashboardPage,
                SellServicePage, RentServicePage, CateServicePage, CatePitchPage
        );

        List<Button> buttons = Arrays.asList(
                btnEmployeePage, btnCustomerPage, btnSportPage, btnPaymentPage, btnDashboardPage
        );

        List<MenuItem> menuItems = Arrays.asList(
                btnSellServicePage, btnRentServicePage, btnCateServicePage, btnCatePitchPage
        );

        List<MenuButton> menuButtons = Arrays.asList(
                btnServicePage, btnCatePage
        );

        String selectedStyle = "-fx-background-color: linear-gradient(to bottom right, #753036, #3c8256); -fx-scale-x: 1.1; -fx-scale-y: 1.1;";
        String defaultStyle = "-fx-background-color: transparent; -fx-scale-x: 1.0; -fx-scale-y: 1.0;";

        pages.forEach(page -> page.setVisible(false));
        buttons.forEach(button -> button.setStyle(defaultStyle));
        menuButtons.forEach(menuButton -> menuButton.setStyle(defaultStyle));
        if (event.getSource() instanceof Button) {
            int index = buttons.indexOf(event.getSource());
            if (index != -1) {
                pages.get(index).setVisible(true);
                buttons.get(index).setStyle(selectedStyle);
                clearPage(index);
            }
        } else if (event.getSource() instanceof MenuItem) {
            int index = menuItems.indexOf(event.getSource());
            if (index != -1) {
                pages.get(buttons.size() + index).setVisible(true);
                menuButtons.get(0).setStyle(selectedStyle);
                clearPage(buttons.size() + index);
            }
        } else if (event.getSource() instanceof MenuButton) {
            int index = menuButtons.indexOf(event.getSource());
            if (index != -1) {
                pages.get(buttons.size() + menuItems.size() + index).setVisible(true);
                menuButtons.get(index).setStyle(selectedStyle);
                clearPage(buttons.size() + menuItems.size() + index);
            }
        }
    }

    private void clearPage(int pageIndex) {
        switch (pageIndex) {
            case 0:
                clearInEmployeePage();
                break;
            case 1:
                clearInCustomerPage();
                break;
            case 2:
                clearInSportPage();
                break;
            case 3:
                clearInPaymentPage();
                break;
            case 4:
                clearInDashboardPage();
                break;
            case 5:
                clearInSellServicePage();
                break;
            case 6:
                clearInRentServicePage();
                break;
            case 7:
                clearInCateServicePage();
                break;
            case 8:
                clearInCatePitchPage();
                break;
            default:
                break;
        }
    }

    //----------------------------------EDIT PROFILE---------------------------------------------//
    private User Emp = App.getLoggedInUser();

    private void informationUser() {
        String phone = Emp.getPhone();
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        String sql = "SELECT u.*, ut.type "
                + "FROM qluser u "
                + "LEFT JOIN user_type ut ON u.idt = ut.idt "
                + "WHERE u.phone = ?";
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = cn.prepareStatement(sql);
            preparedStatement.setString(1, phone);

            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Emp.setName(rs.getString("name"));
                Emp.setMail(rs.getString("mail"));
                tfEmployeeName.setText(Emp.getName());
                //image
                imageURL_EditUser = rs.getString("img");
                Image img = new Image("file:/" + IMAGE_DIR + imageURL_EditUser);
                ivEmployee.setImage(img);
                ivEmployee.setFitHeight(125);
                ivEmployee.setFitWidth(125);
                ivEmployee.setPreserveRatio(true);
                double imageWidth = img.getWidth();
                double imageHeight = img.getHeight();
                double fitWidth = ivEmployee.getFitWidth();
                double fitHeight = ivEmployee.getFitHeight();
                double scale;
                if (imageWidth > imageHeight) {
                    scale = fitHeight / imageHeight;
                } else {
                    scale = fitWidth / imageWidth;
                }
                double viewportWidth = fitWidth / scale;
                double viewportHeight = fitHeight / scale;
                double xOffset = (imageWidth - viewportWidth) / 2;
                double yOffset = (imageHeight - viewportHeight) / 2;
                Rectangle2D viewport = new Rectangle2D(xOffset, yOffset, viewportWidth, viewportHeight);
                ivEmployee.setViewport(viewport);
                double radius = Math.min(fitWidth, fitHeight) / 2;
                Circle clip = new Circle(fitWidth / 2, fitHeight / 2, radius);
                ivEmployee.setClip(clip);

                Emp.setIdt(rs.getInt("idt"));
                Emp.setImg(ivEmployee);
                Emp.setPhone(phone);
                Emp.setPw(rs.getString("pw"));
                Emp.setBirthday(rs.getDate("birthday"));
                Emp.setGender(rs.getBoolean("gender"));
                if ("Male".equalsIgnoreCase(Emp.getGenderDescription())) {
                    rdFemale.setDisable(true);
                } else if ("Female".equalsIgnoreCase(Emp.getGenderDescription())) {
                    rdMale.setDisable(true);
                }
                tfPosition_EditProfile.setText(rs.getString("type"));
                tfEmployeePosition.setText("Position: " + rs.getString("type"));
            } else {
                showAlert(Alert.AlertType.ERROR, "User not found", "User with phone number " + phone + " not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Error fetching user details: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void goToBookingPage(MouseEvent event) {
        try {
            App.setRoot("StaffPage");
            showAlert(AlertType.INFORMATION, "Redirect to Booking Page", "Redirect to Booking Page Successfully!");
        } catch (IOException ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void signout(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Paradise Sport");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to SIGN OUT?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                App.setRoot("Login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void editProfile(ActionEvent event) {
        setOpenPage();
        DashboardPage.setVisible(false);

        EditProfilePage.setVisible(true);
        openEditProfile.setVisible(true);
        openChangePassword.setVisible(false);
        //clear Label
        lbMess_Name.setText("");
        lbMess_Birth.setText("");
        lbMess_Mail.setText("");
        //Information
        tfPhone_EditProfile.setText(Emp.getPhone());
        tfName_EditProfile.setText(Emp.getName());
        tfMail_EditProfile.setText(Emp.getMail());
        setDateFormat(dpBirth_EditProfile);
        Date birth = Emp.getBirthday();
        if (birth != null) {
            LocalDate localDate = convertToLocalDate(birth);
            dpBirth_EditProfile.setValue(localDate);
        } else {
            dpBirth_EditProfile.setValue(null);
        }
        RadioButton selectedType = (RadioButton) gender_EditProfile.getToggles().stream()
                .filter(toggle -> toggle.getUserData().equals(Emp.getGenderDescription()))
                .findFirst()
                .orElse(null);
        if (selectedType != null) {
            gender_EditProfile.selectToggle(selectedType);
        }
        ImageView img = Emp.getImg(); //class
        Image image = img.getImage();
        View__EditProfile.setImage(image);
        View__EditProfile.setFitHeight(114);
        View__EditProfile.setFitWidth(152);
    }

    private LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toLocalDate();
    }

    private void executeSQL(String query) {
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Validate Mail
    private boolean validateMail(String mail) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return mail.matches(emailRegex);
    }

    @FXML
    private void UpdateEditProfile(ActionEvent event) {
        lbMess_Name.setText("");
        lbMess_Birth.setText("");
        lbMess_Mail.setText("");
        String phone = Emp.getPhone();
        String name = tfName_EditProfile.getText();
        LocalDate birth = dpBirth_EditProfile.getValue();
        String mail = tfMail_EditProfile.getText();

        boolean hasErr = false;
        if (name.isBlank()) {
            lbMess_Name.setText("Please fill Name!");
            hasErr = true;
        }
        if (birth == null) {
            lbMess_Birth.setText("Please select Birthday!");
            hasErr = true;
        } else {
            LocalDate today = LocalDate.now();
            Period period = Period.between(birth, today);
            int age = period.getYears();
            if (age < 17 || age > 80) {
                lbMess_Birth.setText("Age must be between 17 and 80!");
                hasErr = true;
            }
        }
        if (mail.isBlank()) {
            lbMess_Mail.setText("Please fill Email!");
            hasErr = true;
        } else {
            if (!validateMail(mail)) {
                lbMess_Mail.setText("Invalid Email format!");
                hasErr = true;
            } else {
                if (categoryDAO.mailExistsInQLUser(mail) && !mail.equals(Emp.getMail())) {
                    lbMess_Mail.setText("Email already exists!");
                    hasErr = true;
                }
            }
        }
        if (hasErr) {
            return;
        }

        String imageNameToUse = (selectImageName_EditUser != null) ? selectImageName_EditUser : imageURL_EditUser;
        boolean isChanged = !Objects.equals(name, Emp.getName())
                || !Objects.equals(birth, convertToLocalDate(Emp.getBirthday()))
                || !Objects.equals(mail, Emp.getMail())
                || !Objects.equals(imageNameToUse, getNameofImageView(Emp.getImg()));

        if (!isChanged) {
            showAlert(AlertType.INFORMATION, "No Changes", "No changes In Your Profile.\nCannot Update Your Profile!");
            return;
        }
        //sql
        String sql = "UPDATE qluser SET "
                + "name='" + name + "',"
                + "mail='" + mail + "',"
                + "img='" + imageNameToUse + "',"
                + "birthday='" + birth + "'"
                + "WHERE phone='" + phone + "'";
        try {
            Alert alert;
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Paradise Sport");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE your Profile?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                executeSQL(sql);
                //alert
                showAlert(AlertType.INFORMATION, "Paradise Sport", "Successfully Updated your Profile!");
                informationUser();
                setOpenPage();
                //Update emplist
                refreshEmployeeList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getNameofImageView(ImageView a) {
        String name = null;
        Image image = a.getImage();

        if (image != null) {
            String imageUrl = image.getUrl();
            name = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        }
        return name;
    }

    @FXML
    private void changeImg_EditProfile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        selectedFile_EditUser = fileChooser.showOpenDialog(null);
        if (selectedFile_EditUser != null) {
            //duong dan image
            selectImageURL_EditUser = selectedFile_EditUser.toURI().toString();
            //ten image
            selectImageName_EditUser = selectedFile_EditUser.getName();
            //copy file img ve IMAG_DIR trong project
            from_EditUser = Paths.get(selectedFile_EditUser.toURI());
            to_EditUser = Paths.get(IMAGE_DIR + selectImageName_EditUser);
            CopyOption options = StandardCopyOption.REPLACE_EXISTING;
            try {
                Files.copy(from_EditUser, to_EditUser, options);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            if (event.getSource() == btnImg_EditProfile) {
                View__EditProfile.setImage(new Image(selectImageURL_EditUser));
                View__EditProfile.setFitHeight(114);
                View__EditProfile.setFitWidth(152);
            }
        }
    }

    @FXML
    private void backToDashboard(ActionEvent event) {
        setOpenPage();
    }

    private void setOpenPage() {
        EmployeePage.setVisible(false);
        CustomerPage.setVisible(false);
        SportPage.setVisible(false);
        SellServicePage.setVisible(false);
        RentServicePage.setVisible(false);
        CateServicePage.setVisible(false);
        CatePitchPage.setVisible(false);
        PaymentPage.setVisible(false);
        EditProfilePage.setVisible(false);
        DetailPage.setVisible(false);
        DashboardPage.setVisible(true);
    }

    @FXML
    private void changePass(ActionEvent event) {
        setOpenPage();
        DashboardPage.setVisible(false);
        EditProfilePage.setVisible(true);
        openEditProfile.setVisible(false);
        openChangePassword.setVisible(true);
        //clear
        clearAllFields(openChangePassword);
        lbCurPass_EditProfile.setText("");
        lbNewPass_EditProfile.setText("");
        lbConfirmPass_EditProfile.setText("");

    }

    //Clear tf, pf
    private void clearAllFields(Parent parent) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof TextField) {
                ((TextField) node).clear();
            } else if (node instanceof PasswordField) {
                ((PasswordField) node).clear();
            } else if (node instanceof Parent) {
                clearAllFields((Parent) node);
            }
        }
    }

    @FXML
    private void ChangePasswordEditProfile(ActionEvent event) {
        lbCurPass_EditProfile.setText("");
        lbNewPass_EditProfile.setText("");
        lbConfirmPass_EditProfile.setText("");
        String phone = Emp.getPhone();
        String curPass;
        if (tfCurPass_EditProfile.isVisible()) {
            curPass = tfCurPass_EditProfile.getText();
        } else {
            curPass = pfCurPass_EditProfile.getText();
        }
        String newPass;
        if (tfNewPass_EditProfile.isVisible()) {
            newPass = tfNewPass_EditProfile.getText();
        } else {
            newPass = pfNewPass_EditProfile.getText();
        }
        String confirmPass;
        if (tfConfirm_EditProfile.isVisible()) {
            confirmPass = tfConfirm_EditProfile.getText();
        } else {
            confirmPass = pfConfirm_EditProfile.getText();
        }

        boolean hasErr = false;

        if (curPass.isEmpty()) {
            lbCurPass_EditProfile.setText("This field cannot be blank!");
            if (tfCurPass_EditProfile.isVisible()) {
                tfCurPass_EditProfile.requestFocus();
            } else {
                pfCurPass_EditProfile.requestFocus();
            }
            hasErr = true;
        } else if (!curPass.equals(Emp.getPw())) {
            lbCurPass_EditProfile.setText("Current password is incorrect!");
            if (tfCurPass_EditProfile.isVisible()) {
                tfCurPass_EditProfile.requestFocus();
            } else {
                pfCurPass_EditProfile.requestFocus();
            }
            hasErr = true;
        }
        if (!hasErr) {
            if (newPass.isEmpty()) {
                lbNewPass_EditProfile.setText("This field cannot be blank!");
                if (tfNewPass_EditProfile.isVisible()) {
                    tfNewPass_EditProfile.requestFocus();
                } else {
                    pfNewPass_EditProfile.requestFocus();
                }
                hasErr = true;
            } else if (newPass.equals(curPass)) {
                lbNewPass_EditProfile.setText("Cannot be the same as Current password!");
                if (tfNewPass_EditProfile.isVisible()) {
                    tfNewPass_EditProfile.requestFocus();
                } else {
                    pfNewPass_EditProfile.requestFocus();
                }
                hasErr = true;
            } else if (newPass.length() < 3) {
                lbNewPass_EditProfile.setText("NewPassword at least 3 characters!");
                if (tfNewPass_EditProfile.isVisible()) {
                    tfNewPass_EditProfile.requestFocus();
                } else {
                    pfNewPass_EditProfile.requestFocus();
                }
                hasErr = true;
            }
        }

        if (!hasErr && confirmPass.isEmpty()) {
            lbConfirmPass_EditProfile.setText("This field cannot be blank!");
            if (tfConfirm_EditProfile.isVisible()) {
                tfConfirm_EditProfile.requestFocus();
            } else {
                pfConfirm_EditProfile.requestFocus();
            }
            hasErr = true;
        } else if (!hasErr && !newPass.equals(confirmPass)) {
            lbConfirmPass_EditProfile.setText("Not the same as the new password!");
            if (tfConfirm_EditProfile.isVisible()) {
                tfConfirm_EditProfile.requestFocus();
            } else {
                pfConfirm_EditProfile.requestFocus();
            }
            hasErr = true;
        }

        if (hasErr) {
            return;
        }
        String sql = "UPDATE qluser SET "
                + "pw='" + newPass + "'"
                + "WHERE phone='" + phone + "'";
        try {
            Alert alert;
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Paradise Sport");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to Change Password?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                executeSQL(sql);
                //alert
                showAlert(AlertType.INFORMATION, "Paradise Sport", "Successfully Change Password!");
                informationUser();
                setOpenPage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showPassword(TextField textField, PasswordField passwordField, Button showButton, Button hideButton) {
        textField.setText(passwordField.getText());
        textField.setVisible(true);
        textField.setManaged(true);
        passwordField.setVisible(false);
        passwordField.setManaged(false);
        showButton.setVisible(false);
        hideButton.setVisible(true);

        textField.requestFocus();
        textField.positionCaret(passwordField.getText().length());
    }

    private void hidePassword(TextField textField, PasswordField passwordField, Button showButton, Button hideButton) {
        passwordField.setText(textField.getText());
        passwordField.setVisible(true);
        passwordField.setManaged(true);
        textField.setVisible(false);
        textField.setManaged(false);
        showButton.setVisible(true);
        hideButton.setVisible(false);

        passwordField.requestFocus();
        passwordField.positionCaret(textField.getText().length());
    }

    @FXML
    private void showCurPass(ActionEvent event) {
        showPassword(tfCurPass_EditProfile, pfCurPass_EditProfile, btnshowCurPass_EditProfile, btnhideCurPass_EditProfile);
    }

    @FXML
    private void hideCurPass(ActionEvent event) {
        hidePassword(tfCurPass_EditProfile, pfCurPass_EditProfile, btnshowCurPass_EditProfile, btnhideCurPass_EditProfile);
    }

    @FXML
    private void showNewPass(ActionEvent event) {
        showPassword(tfNewPass_EditProfile, pfNewPass_EditProfile, btnshowNewPass_EditProfile, btnhideNewPass_EditProfile);
    }

    @FXML
    private void hideNewPass(ActionEvent event) {
        hidePassword(tfNewPass_EditProfile, pfNewPass_EditProfile, btnshowNewPass_EditProfile, btnhideNewPass_EditProfile);
    }

    @FXML
    private void showConfirmPass(ActionEvent event) {
        showPassword(tfConfirm_EditProfile, pfConfirm_EditProfile, btnshowConfirm_EditProfile, btnhideConfirm_EditProfile);
    }

    @FXML
    private void hideConfirmPass(ActionEvent event) {
        hidePassword(tfConfirm_EditProfile, pfConfirm_EditProfile, btnshowConfirm_EditProfile, btnhideConfirm_EditProfile);
    }
    //--------------------------------------------------------------------------------------------------------------------------------

    //---------------------------------------PAYMENT-------------------------------------//
    //Update Emp, Cus, Pitch list
    private void refreshEmployeeList() {
        ObservableList<String> nameEmpList = categoryDAO.getNameEmployees();
        cbEmpName_Payment.setItems(nameEmpList);
    }

    private void refreshCustomerList() {
        ObservableList<String> nameCusList = categoryDAO.getNameCustomers();
        cbCusName_Payment.setItems(nameCusList);
    }

    private void refreshPitchList() {
        ObservableList<String> namePitchList = categoryDAO.getNamePitchs();
        cbPitchName_Payment.setItems(namePitchList);
    }

    private void setupOpenPaymentBill() {
        btnAdd_Payment.setDisable(true);
        btnDelete_Payment.setDisable(true);
        ObservableList<String> sttList = FXCollections.observableArrayList("Pending", "Completed", "Cancel");
        cbStt_Payment.setItems(sttList);
        categoryDAO = new CategoryDAO();
        refreshEmployeeList();
        refreshCustomerList();
        refreshPitchList();
        completed_Pay.selectToggle(rdNo_Payment);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 3, 1);
        spHrsBooking_Payment.setValueFactory(valueFactory);
        rdYes_Payment.setUserData("Yes");
        rdNo_Payment.setUserData("No");
        setDateFormat(dpDate_Payment);
        setDateFormat(dpSelectDate_Payment);
        showPaymentBills();
        clearInPaymentPage();
        tfSearch_Payment.textProperty().addListener((observable, oldValue, newValue) -> searchInBillPayment());
        dpSelectDate_Payment.setOnAction(event -> {
            searchInBillPayment();
        });
        btnCloseSearch_Payment.setVisible(false);
        btnCloseDate_Payment.setVisible(false);

    }

    public ObservableList getPaymentBills() {
        //tao danh sach 
        ObservableList<PaymentBill> plist = FXCollections.observableArrayList();
        //connect
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        //truy van
        String query = "SELECT "
                + "idb, "
                + "ql.name AS empname, "
                + "s.name AS pitchname, "
                + "k.name AS cusname, "
                + "time_start, "
                + "time_end, "
                + "hrs_used, "
                + "deposit, "
                + "tt_booking, "
                + "tt_service, "
                + "tt_payment, "
                + "pay_date, "
                + "completed, "
                + "time_book, "
                + "hrs, "
                + "stt "
                + "FROM payments p "
                + "JOIN sanbong s ON p.idp = s.idp "
                + "JOIN qluser ql ON p.idu = ql.idu "
                + "JOIN khachhang k ON p.idk = k.idk;";

        //thuc thi
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);
            PaymentBill p;
            while (rs.next()) {
                int idb = rs.getInt("idb");
                String empName = rs.getString("empname");
                String pitchName = rs.getString("pitchname");
                String cusName = rs.getString("cusname");
                int deposit = rs.getInt("deposit");
                int ttbooking = rs.getInt("tt_booking");
                int ttservice = rs.getInt("tt_service");
                int ttpayment = rs.getInt("tt_payment");
                int hrs = rs.getInt("hrs");
                int hrs_used = rs.getInt("hrs_used");
                Time timebooking = rs.getTime("time_book");
                int stt = rs.getInt("stt");
                boolean completed = rs.getBoolean("completed");
                Time start = rs.getTime("time_start");
                Time end = rs.getTime("time_end");
                Date date = rs.getDate("pay_date");

                p = new PaymentBill(idb, start, end, hrs_used, date, deposit, ttbooking, ttservice, ttpayment, completed, timebooking, hrs, stt, cusName, empName, pitchName);
                plist.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return plist;
    }

    private void setDateFormat(DatePicker datePicker) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        datePicker.setConverter(new StringConverter<>() {
            @Override
            public String toString(LocalDate date) {
                return date != null ? dateFormatter.format(date) : "";
            }

            @Override
            public LocalDate fromString(String string) {
                return string != null && !string.isEmpty() ? LocalDate.parse(string, dateFormatter) : null;
            }
        });
        datePicker.getEditor().focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                LocalDate date = datePicker.getConverter().fromString(datePicker.getEditor().getText());
                datePicker.setValue(date);
            }
        });
    }

    private String getStatusDetail(int stt) {
        switch (stt) {
            case 1:
                return "Pending";
            case 2:
                return "Completed";
            case 3:
                return "Cancel";
            default:
                return "Not found";
        }
    }

    public void showPaymentBills() {
        ObservableList<PaymentBill> plist = getPaymentBills();
        colIdb_Payment.setCellValueFactory(new PropertyValueFactory<>("idb"));
        colEmpName_Payment.setCellValueFactory(new PropertyValueFactory<>("qluser_name"));
        colPitchName_Payment.setCellValueFactory(new PropertyValueFactory<>("sanbong_name"));
        colCusName_Payment.setCellValueFactory(new PropertyValueFactory<>("khachhang_name"));
        colDeposit_Payment.setCellValueFactory(new PropertyValueFactory<>("deposit"));
        colBooking_Payment.setCellValueFactory(new PropertyValueFactory<>("tt_booking"));
        colSerivce_Payment.setCellValueFactory(new PropertyValueFactory<>("tt_service"));
        colPayment_Payment.setCellValueFactory(new PropertyValueFactory<>("tt_payment"));
        //date
        colDate_Payment.setCellValueFactory(new PropertyValueFactory<>("pay_date"));
        colDate_Payment.setCellFactory(new DateCellFactory("dd/MM/yyyy"));

        colHrsBooking_Payment.setCellValueFactory(new PropertyValueFactory<>("hrs"));
        colTimeBooking_Payment.setCellValueFactory(new PropertyValueFactory<>("time"));
        colStart_Payment.setCellValueFactory(new PropertyValueFactory<>("time_start"));
        colEnd_Payment.setCellValueFactory(new PropertyValueFactory<>("time_end"));
        colHrsUse_Payment.setCellValueFactory(new PropertyValueFactory<>("hrs_used"));
        colCompleted_Payment.setCellValueFactory(new PropertyValueFactory<>("completed"));
        tvPayment.setItems(plist);
    }

    private ObservableList<PaymentBill> filterPaymentBillsByDate(LocalDate date) {
        ObservableList<PaymentBill> allPayments = getPaymentBills();
        if (date == null) {
            return allPayments;
        }
        ObservableList<PaymentBill> filterList = FXCollections.observableArrayList();

        for (PaymentBill bill : allPayments) {
            if (bill.getPay_date().toLocalDate().equals(date)) {
                filterList.add(bill);
            }
        }
        return filterList;
    }

    private ObservableList<PaymentBill> filterPaymentBills(String search, LocalDate date) {
        ObservableList<PaymentBill> filteredByDate = filterPaymentBillsByDate(date);
        if (search == null || search.isEmpty()) {
            return filteredByDate;
        }
        ObservableList<PaymentBill> filterList = FXCollections.observableArrayList();
        String lowerCaseFilter = search.toLowerCase();

        for (PaymentBill bill : filteredByDate) {
            if (bill.getQluser_name().toLowerCase().contains(lowerCaseFilter)
                    || bill.getSanbong_name().toLowerCase().contains(lowerCaseFilter)
                    || bill.getKhachhang_name().toLowerCase().contains(lowerCaseFilter)) {
                filterList.add(bill);
            }
        }
        return filterList;
    }

    @FXML
    private void searchInBillPayment() {
        String searchText = tfSearch_Payment.getText();
        LocalDate selectedDate = dpSelectDate_Payment.getValue();

        LocalDate storedDate = dpSelectDate_Payment.getUserData() instanceof LocalDate
                ? (LocalDate) dpSelectDate_Payment.getUserData() : null;

        if (selectedDate != null) {
            btnCloseDate_Payment.setVisible(true);
        } else {
            btnCloseDate_Payment.setVisible(false);
        }

        if (searchText != null && !searchText.isEmpty()) {
            btnCloseSearch_Payment.setVisible(true);
        } else {
            btnCloseSearch_Payment.setVisible(false);
        }

        if (!Objects.equals(selectedDate, storedDate)) {
            dpSelectDate_Payment.setUserData(selectedDate);
            ObservableList<PaymentBill> filterListByDate = filterPaymentBillsByDate(selectedDate);
            tvPayment.setItems(filterListByDate);
        } else {
            ObservableList<PaymentBill> filterList = filterPaymentBills(searchText, selectedDate);
            tvPayment.setItems(filterList);
        }
    }
    @FXML
    private Button btnCloseSearch_Payment;
    @FXML
    private Button btnCloseDate_Payment;

    @FXML
    private void clearPayDateInPayment(ActionEvent event) {
        dpSelectDate_Payment.setValue(null);
        dpSelectDate_Payment.setUserData(null);
        btnCloseDate_Payment.setVisible(false);
        searchInBillPayment();
    }

    @FXML
    private void clearFieldSearchInPayment(ActionEvent event) {
        tfSearch_Payment.clear();
        btnCloseSearch_Payment.setVisible(false);
        searchInBillPayment();
    }

    private Time ConverttoTime(TextField textField, Label error) {
        String timeInput = textField.getText();
        if (timeInput.isEmpty()) {
            error.setText("Please enter a time");
            return null;
        }
        try {
            String[] parts = timeInput.trim().split(":");
            if (parts.length != 2) {
                error.setText("Invalid format");
                return null;
            }
            int hours = Integer.parseInt(parts[0].trim());
            int minutes = Integer.parseInt(parts[1].trim());
            if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
                error.setText("Invalid time");
                return null;
            }

            LocalTime localTime = LocalTime.of(hours, minutes);
            return Time.valueOf(localTime);
        } catch (NumberFormatException e) {
            error.setText("Invalid format");
            return null;
        }
    }

    private int validateInput(String input, Label label, String fieldName) {
        if (input.isEmpty()) {
            label.setText("Please enter a " + fieldName + "!");
            return -1;
        }
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                label.setText(fieldName + " isn't negative number!");
                return -1;
            }
            return value;
        } catch (NumberFormatException e) {
            label.setText(fieldName + " is a digit!");
            return -1;
        }
    }

    private String formatTimetoString(Time t) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = t.toLocalTime();
        return localTime.format(formatter);
    }

    @FXML
    private void showPriceOfPitchInPayment(ActionEvent event) {
        String pitchName = cbPitchName_Payment.getSelectionModel().getSelectedItem();
        if (pitchName != null) {
            int priceofPitch = categoryDAO.getPriceOfPitch(pitchName);
            tfPricePitch_Payment.setText(String.valueOf(priceofPitch));
        }
    }

    @FXML
    private void addPayment(ActionEvent event) {
        clearLabelsInPayment();

        String empName = cbEmpName_Payment.getSelectionModel().getSelectedItem();
        String pitchName = cbPitchName_Payment.getSelectionModel().getSelectedItem();
        int priceofPitch = categoryDAO.getPriceOfPitch(pitchName);
        tfPricePitch_Payment.setText(String.valueOf(priceofPitch));
        String cusName = cbCusName_Payment.getSelectionModel().getSelectedItem();
        String status = cbStt_Payment.getSelectionModel().getSelectedItem();
        String deposit = tfDeposit_Payment.getText();
        int Status = 0;
        RadioButton rdType = (RadioButton) completed_Pay.getSelectedToggle();
        boolean completed;
        if (rdType.getText().equals("Yes")) {
            completed = true;
        } else {
            completed = false;
        }
        LocalDate date = dpDate_Payment.getValue();
        Date pay_date = Date.valueOf("2000-01-01");
        int hrs = spHrsBooking_Payment.getValue();
        Time timebooking = ConverttoTime(tfTimeBooking_Payment, lbTimeBooking_Payment);
        Time start = ConverttoTime(tfStart_Payment, lbStart_Payment);
        Time end = ConverttoTime(tfEnd_Payment, lbEnd_Payment);
        int hrs_Used = 0;

        //Validate
        boolean hasErr = false;

        if (start != null && timebooking != null && start.toLocalTime().isBefore(timebooking.toLocalTime())) {
            lbStart_Payment.setText("TimeStart cann't earlier than TimeBooking");
            hasErr = true;
        }
        if (start != null && end != null) {
            hrs_Used = (int) Math.ceil((double) Duration.between(start.toLocalTime(), end.toLocalTime()).toMinutes() / 60);
            if (end.toLocalTime().isBefore(start.toLocalTime())) {
                lbEnd_Payment.setText("TimeEnd cann't earlier than TimeStart");
                hasErr = true;
            } else if (end.toLocalTime().isAfter(start.toLocalTime())) {
                lbEnd_Payment.setText("");
            } else {
                lbEnd_Payment.setText("TimeEnd cann't equal with TimeStart");
                hasErr = true;
            }
        }

        int Deposit = validateInput(deposit, lbDeposit_Payment, "Deposit");
        int Booking = categoryDAO.getPriceOfPitch(pitchName) * hrs_Used;
        int Service = 0;
        int Payment = Booking + Service - Deposit;

        if (Deposit == -1) {
            hasErr = true;
        }
        if (Deposit > categoryDAO.getPriceOfPitch(pitchName) * hrs) {
            lbDeposit_Payment.setText("Deposit cann't greater than " + categoryDAO.getPriceOfPitch(pitchName) * hrs + "!");
            hasErr = true;
        }
        if (empName == null) {
            lbEmpName_Payment.setText("Select a Employee!");
            hasErr = true;
        }
        if (pitchName == null) {
            lbPitchName_Payment.setText("Select a Pitch!");
            hasErr = true;
        }
        if (cusName == null) {
            lbCusName_Payment.setText("Select a Customer!");
            hasErr = true;
        }
        if (status == null) {
            lbStatus_Payment.setText("Select a Status!");
            hasErr = true;
        } else {
            switch (status) {
                case "Pending":
                    Status = 1;
                    break;
                case "Completed":
                    Status = 2;
                    break;
                case "Cancel":
                    Status = 3;
                    break;
                default:
                    break;
            }
        }
        if (date == null) {
            lbDate_Payment.setText("Select a PayDate!");
            hasErr = true;
        } else {
            if (date.isBefore(LocalDate.now())) {
                lbDate_Payment.setText("PayDate cannot be in the past!");
                hasErr = true;
            } else {
                pay_date = Date.valueOf(date);
            }
        }
        if (hasErr) {
            return;
        }

        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        PreparedStatement ps = null;
        String sql = "INSERT INTO payments (idu, idp, idk, time_start, time_end, hrs_used, deposit, tt_booking, tt_service, tt_payment, pay_date, completed, time_book, hrs, stt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, categoryDAO.getIDInEmp(empName));
            ps.setInt(2, categoryDAO.getIDInPitch(pitchName));
            ps.setString(3, categoryDAO.getIDInCustomer(cusName));
            ps.setTime(4, start);
            ps.setTime(5, end);
            ps.setInt(6, hrs_Used);
            ps.setInt(7, Deposit);
            ps.setInt(8, Booking);
            ps.setInt(9, Service);
            ps.setInt(10, Payment);
            ps.setDate(11, pay_date);
            ps.setBoolean(12, completed);
            ps.setTime(13, timebooking);
            ps.setInt(14, hrs);
            ps.setInt(15, Status);

            if (ps.executeUpdate() > 0) {
                showAlert(AlertType.INFORMATION, "PaymentBill", "Payment Bill added Successfully!");
                showPaymentBills();
                clearInPaymentPage();
            } else {
                showAlert(AlertType.ERROR, "Error", "Failed to add payment.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    private PaymentBill paySSI;

    @FXML
    private void onSelectPaymentBill(MouseEvent event) {
        clearLabelsInPayment();
        PaymentBill b = tvPayment.getSelectionModel().getSelectedItem();
        if (b != null) {
            paySSI = new PaymentBill(b.getIdb(), b.getTime_start(), b.getTime_end(), b.getPay_date(), b.getDeposit(), b.getTt_booking(),
                    b.getTt_service(), b.getTt_payment(), b.isComp(), b.getTime(), b.getHrs(), b.getStt(), b.getKhachhang_name(), b.getQluser_name(), b.getSanbong_name());

            tfDeposit_Payment.setText(String.valueOf(b.getDeposit()));
            RadioButton selectedType = (RadioButton) completed_Pay.getToggles().stream()
                    .filter(toggle -> toggle.getUserData().equals(b.getCompleted()))
                    .findFirst()
                    .orElse(null);
            if (selectedType != null) {
                completed_Pay.selectToggle(selectedType);
            }
            cbEmpName_Payment.setValue(b.getQluser_name());
            cbCusName_Payment.setValue(b.getKhachhang_name());
            cbPitchName_Payment.setValue(b.getSanbong_name());
            tfPricePitch_Payment.setText(String.valueOf(categoryDAO.getPriceOfPitch(b.getSanbong_name())));
            cbStt_Payment.setValue(b.getSttDetail());
            spHrsBooking_Payment.getValueFactory().setValue(b.getHrs());
            if (b.getPay_date() != null) {
                dpDate_Payment.setValue(b.getPay_date().toLocalDate());
            } else {
                dpDate_Payment.setValue(null);
            }
            if (paySSI.getPay_date().toLocalDate().isBefore(LocalDate.now())) {
                btnUpdate_Payment.setDisable(true);
            } else {
                btnUpdate_Payment.setDisable(false);
            }
            tfTimeBooking_Payment.setText(formatTimetoString(b.getTime()));
            tfStart_Payment.setText(formatTimetoString(b.getTime_start()));
            tfEnd_Payment.setText(formatTimetoString(b.getTime_end()));
        } else {
            clearInPaymentPage();
        }
    }

    private int getSelectedPaymentID() {
        PaymentBill selectedBill = tvPayment.getSelectionModel().getSelectedItem();
        if (selectedBill != null) {
            return selectedBill.getIdb();
        }
        return -1;
    }

    @FXML
    private void updatePayment(ActionEvent event) {
        clearLabelsInPayment();
        int selectedPaymentID = getSelectedPaymentID();
        if (selectedPaymentID == -1) {
            showAlert(AlertType.ERROR, "Error", "No Payment Bill selected!");
            return;
        }
        PaymentBill selectedBill = tvPayment.getSelectionModel().getSelectedItem();
        if (selectedBill == null) {
            showAlert(AlertType.ERROR, "Error", "No Payment Bill selected!");
            return;
        }

        // Lấy dữ liệu cũ của hóa đơn từ biến paySSI
        if (paySSI == null) {
            paySSI = selectedBill;
        }
        String empName = cbEmpName_Payment.getSelectionModel().getSelectedItem();
        String pitchName = cbPitchName_Payment.getSelectionModel().getSelectedItem();
        String cusName = cbCusName_Payment.getSelectionModel().getSelectedItem();
        String status = cbStt_Payment.getSelectionModel().getSelectedItem();
        String deposit = tfDeposit_Payment.getText();
        int Status = 0;
        RadioButton rdType = (RadioButton) completed_Pay.getSelectedToggle();
        boolean completed;
        if (rdType.getText().equals("Yes")) {
            completed = true;
        } else {
            completed = false;
        }
        LocalDate date = dpDate_Payment.getValue();
        Date pay_date = Date.valueOf("2000-01-01");
        int hrs = spHrsBooking_Payment.getValue();
        int hrs_Used = 0;
        String Start = tfStart_Payment.getText();
        String End = tfEnd_Payment.getText();
        String TimeBooking = tfTimeBooking_Payment.getText();
        if (empName == null && pitchName == null && cusName == null && status == null
                && (deposit == null || deposit.isEmpty())
                && date == null
                && (Start == null || Start.isEmpty())
                && (End == null || End.isEmpty())
                && (TimeBooking == null || TimeBooking.isEmpty())) {

            showAlert(AlertType.ERROR, "Error", "No Payment Bill selected!");
            return;
        }

        Time timebooking = ConverttoTime(tfTimeBooking_Payment, lbTimeBooking_Payment);
        Time start = ConverttoTime(tfStart_Payment, lbStart_Payment);
        Time end = ConverttoTime(tfEnd_Payment, lbEnd_Payment);

        boolean hasErr = false;
        if (start != null && timebooking != null && start.toLocalTime().isBefore(timebooking.toLocalTime())) {
            lbStart_Payment.setText("TimeStart cann't earlier than TimeBooking");
            hasErr = true;
        }
        if (start != null && end != null) {
            hrs_Used = (int) Duration.between(start.toLocalTime(), end.toLocalTime()).toHours();
            if (end.toLocalTime().isBefore(start.toLocalTime())) {
                lbEnd_Payment.setText("TimeEnd cann't earlier than TimeStart");
                hasErr = true;
            } else if (end.toLocalTime().isAfter(start.toLocalTime())) {
                lbEnd_Payment.setText("");
            } else {
                lbEnd_Payment.setText("TimeEnd cann't equal with TimeStart");
                hasErr = true;
            }
        }

        int Deposit = validateInput(deposit, lbDeposit_Payment, "Deposit");
        int Booking = categoryDAO.getPriceOfPitch(pitchName) * hrs_Used;
        int Service = 0;
        int Payment = Booking + Service - Deposit;

        if (Deposit == -1) {
            hasErr = true;
        }
        if (Deposit > categoryDAO.getPriceOfPitch(pitchName) * hrs) {
            lbDeposit_Payment.setText("Deposit cann't greater than " + categoryDAO.getPriceOfPitch(pitchName) * hrs + "!");
            hasErr = true;
        }
        if (empName == null) {
            lbEmpName_Payment.setText("Select a Employee!");
            hasErr = true;
        }
        if (pitchName == null) {
            lbPitchName_Payment.setText("Select a Pitch!");
            hasErr = true;
        }
        if (cusName == null) {
            lbCusName_Payment.setText("Select a Customer!");
            hasErr = true;
        }
        if (status == null) {
            lbStatus_Payment.setText("Select a Status!");
            hasErr = true;
        } else {
            switch (status) {
                case "Pending":
                    Status = 1;
                    break;
                case "Completed":
                    Status = 2;
                    break;
                case "Cancel":
                    Status = 3;
                    break;
                default:
                    break;
            }
        }
        if (date == null) {
            lbDate_Payment.setText("Select a PayDate!");
            hasErr = true;
        } else {
            pay_date = Date.valueOf(date);
        }
        boolean isChanged = !Objects.equals(selectedBill.getQluser_name(), empName)
                || !Objects.equals(selectedBill.getSanbong_name(), pitchName)
                || !Objects.equals(selectedBill.getKhachhang_name(), cusName)
                || selectedBill.getStt() != Status
                || selectedBill.getDeposit() != validateInput(deposit, lbDeposit_Payment, "Deposit")
                || selectedBill.isComp() != completed
                || !Objects.equals(selectedBill.getPay_date(), (date != null ? Date.valueOf(date) : null))
                || !Objects.equals(selectedBill.getTime_start(), start)
                || !Objects.equals(selectedBill.getTime_end(), end)
                || !Objects.equals(selectedBill.getTime(), timebooking)
                || selectedBill.getHrs() != spHrsBooking_Payment.getValue();
        if (!isChanged) {
            showAlert(AlertType.INFORMATION, "No Changes In Payment", "No Changes In Payment!\nCannot Update Payment!");
            return;
        }
        if (hasErr) {
            return;
        }

        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        PreparedStatement ps = null;

        String sql = "UPDATE payments SET idu = ?, idp = ?, idk = ?, time_start = ?, time_end = ?, hrs_used = ?, "
                + "deposit = ?, tt_booking = ?, tt_service = ?, tt_payment = ?, pay_date = ?, completed = ?, "
                + "time_book = ?, hrs = ?, stt = ? WHERE idb = ?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, categoryDAO.getIDInEmp(empName));
            ps.setInt(2, categoryDAO.getIDInPitch(pitchName));
            ps.setString(3, categoryDAO.getIDInCustomer(cusName));
            ps.setTime(4, start);
            ps.setTime(5, end);
            ps.setInt(6, hrs_Used);
            ps.setInt(7, Deposit);
            ps.setInt(8, Booking);
            ps.setInt(9, Service);
            ps.setInt(10, Payment);
            ps.setDate(11, pay_date);
            ps.setBoolean(12, completed);
            ps.setTime(13, timebooking);
            ps.setInt(14, hrs);
            ps.setInt(15, Status);
            ps.setInt(16, selectedPaymentID);

            Alert alert;
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK) && option.isPresent()) {
                if (ps.executeUpdate() > 0) {
                    showAlert(AlertType.INFORMATION, "PaymentBill", "Payment Bill updated successfully!");
                    showPaymentBills();
                    clearInPaymentPage();
                } else {
                    showAlert(AlertType.ERROR, "Error", "Failed to update payment.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public void clearLabelsInPayment() {
        Label[] labels = {
            lbEmpName_Payment,
            lbPitchName_Payment,
            lbStatus_Payment,
            lbCusName_Payment,
            lbDeposit_Payment,
            lbDate_Payment,
            lbTimeBooking_Payment,
            lbStart_Payment,
            lbEnd_Payment
        };
        for (Label label : labels) {
            label.setText("");
        }
    }

    private void clearInPaymentPage() {
        clearLabelsInPayment();
        cbEmpName_Payment.getSelectionModel().clearSelection();
        cbPitchName_Payment.getSelectionModel().clearSelection();
        cbCusName_Payment.getSelectionModel().clearSelection();
        cbStt_Payment.getSelectionModel().clearSelection();
        completed_Pay.selectToggle(rdNo_Payment);
        dpDate_Payment.setValue(null);
        spHrsBooking_Payment.getValueFactory().setValue(1);
        tfDeposit_Payment.clear();
        tfTimeBooking_Payment.clear();
        tfStart_Payment.clear();
        tfEnd_Payment.clear();
        tfPricePitch_Payment.clear();

    }

    @FXML
    private void clearPayment(ActionEvent event) {
        clearInPaymentPage();
        paySSI = null;
    }

    @FXML
    private void deletePayment(ActionEvent event) {
        int selectedPaymentID = getSelectedPaymentID();
        if (selectedPaymentID == -1) {
            showAlert(AlertType.ERROR, "Error", "No Payment Bill selected!");
            return;
        }

        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String selectRentSQL = "SELECT name, sum(qty) as qty FROM hd_ser_rent hdsr JOIN ser_rent sr ON hdsr.idsr = sr.idsr WHERE idb = ? GROUP BY name";
        String selectSellSQL = "SELECT name, sum(qty) as qty FROM hd_ser_sell hdss JOIN ser_sell ss ON hdss.idss = ss.idss WHERE idb = ? GROUP BY name";
        StringBuilder detailMessage = new StringBuilder("Are you sure you want to delete this Payment Bill?\n\nInformation of Payment Bill:\n");

        try {
            ps = cn.prepareStatement(selectRentSQL);
            ps.setInt(1, selectedPaymentID);
            rs = ps.executeQuery();
            boolean hasRentDetails = false;
            if (rs.next()) {
                detailMessage.append("Product: ").append(rs.getString("name")).append("\n");
                detailMessage.append("Quantity: ").append(rs.getInt("qty")).append("\n\n");
                hasRentDetails = true;
            }
            rs.close();
            ps.close();

            ps = cn.prepareStatement(selectSellSQL);
            ps.setInt(1, selectedPaymentID);
            rs = ps.executeQuery();
            boolean hasSellDetails = false;
            if (rs.next()) {
                detailMessage.append("Product: ").append(rs.getString("name")).append("\n");
                detailMessage.append("Quantity: ").append(rs.getInt("qty")).append("\n");
                hasSellDetails = true;
            }

            rs.close();
            ps.close();

            if (!hasRentDetails && !hasSellDetails) {
                detailMessage.append("Not found Service in Payment Bill!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            showAlert(AlertType.ERROR, "Error", "Failed to fetch Payment Bill details.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirm Delete");
        alert.setContentText(detailMessage.toString());
        Optional<ButtonType> option = alert.showAndWait();
        if (option.isPresent() && option.get() == ButtonType.OK) {
            PreparedStatement ps1 = null, ps2 = null, ps3 = null;

            String deleteRentSQL = "DELETE FROM hd_ser_rent WHERE idb = ?";
            String deleteSellSQL = "DELETE FROM hd_ser_sell WHERE idb = ?";
            String deletePaymentSQL = "DELETE FROM payments WHERE idb = ?";

            try {
                cn.setAutoCommit(false);

                ps1 = cn.prepareStatement(deleteRentSQL);
                ps1.setInt(1, selectedPaymentID);
                ps1.executeUpdate();

                ps2 = cn.prepareStatement(deleteSellSQL);
                ps2.setInt(1, selectedPaymentID);
                ps2.executeUpdate();

                ps3 = cn.prepareStatement(deletePaymentSQL);
                ps3.setInt(1, selectedPaymentID);
                int rowsAffected = ps3.executeUpdate();

                if (rowsAffected > 0) {
                    cn.commit();
                    showAlert(AlertType.INFORMATION, "PaymentBill", "Payment Bill deleted successfully!");
                    showPaymentBills();
                    clearInPaymentPage();
                } else {
                    cn.rollback();
                    showAlert(AlertType.ERROR, "Error", "Failed to delete Payment Bill.");
                }
            } catch (SQLException e) {
                if (cn != null) {
                    try {
                        cn.rollback();
                    } catch (SQLException ex) {
                        System.out.println("Error rolling back transaction: " + ex.getMessage());
                    }
                }
                System.out.println("Error: " + e.getMessage());
                showAlert(AlertType.ERROR, "Error", "Error deleting Payment Bill.");
            } finally {
                try {
                    if (ps1 != null) {
                        ps1.close();
                    }
                    if (ps2 != null) {
                        ps2.close();
                    }
                    if (ps3 != null) {
                        ps3.close();
                    }
                    if (cn != null) {
                        cn.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error closing resources: " + e.getMessage());
                }
            }
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------------

    //---------------------------------------DETAIL OF PAYMENT-------------------------------------//
    private void setOpenDetailOfPayment() {
        if (paySSI != null) {
            setOpenPage();
            DashboardPage.setVisible(false);
            DetailPage.setVisible(true);
            detailOfPaymentBill();
            setupDetailOfPayment();
            showInvoicesOfPayment();
        } else {
            showAlert(AlertType.ERROR, "Error", "No Payment Bill selected!");
            return;
        }
    }

    private void setupDetailOfPayment() {
        rdFood_DetailPay.setOnAction(event -> updateComboxInDetailPay());
        rdDrink_DetailPay.setOnAction(event -> updateComboxInDetailPay());
        rdAccess_DetailPay.setOnAction(event -> updateComboxInDetailPay());
        typeProduct_DetailPay.selectToggle(rdDrink_DetailPay);
        rdDrink_DetailPay.setUserData("Drink");
        rdFood_DetailPay.setUserData("Food");
        rdAccess_DetailPay.setUserData("Accessories");
        updateComboxInDetailPay();
        cbProductName_DetailPay.setPromptText("Select...");
        cbProductName_DetailPay.setOnAction(event -> updateSpinnerInDetailPay());
    }

    private void clearInDetailPay() {
        typeProduct_DetailPay.selectToggle(rdDrink_DetailPay);
        cbProductName_DetailPay.getSelectionModel().clearSelection();
        cbProductName_DetailPay.setValue(null);
        spQuantity_DetailPay.setValueFactory(null);
        spQuantity_DetailPay.getEditor().clear();
    }

    //Update type product
    private void refreshFoodList() {
        ObservableList<String> foodList = categoryDAO.getProductsIsFood();
        cbProductName_DetailPay.setItems(foodList);
    }

    private void refreshDrinkList() {
        ObservableList<String> drinkList = categoryDAO.getProductsIsDrink();
        cbProductName_DetailPay.setItems(drinkList);
    }

    private void refreshAccessoriesList() {
        ObservableList<String> accessList = categoryDAO.getProductsIsAcess();
        cbProductName_DetailPay.setItems(accessList);
    }

    private void updateComboxInDetailPay() {
        spQuantity_DetailPay.setValueFactory(null);
        spQuantity_DetailPay.getEditor().clear();
        RadioButton selectedRadioButton = (RadioButton) typeProduct_DetailPay.getSelectedToggle();
        if (selectedRadioButton != null) {
            if (selectedRadioButton == rdFood_DetailPay) {
                refreshDrinkList();
            } else if (selectedRadioButton == rdDrink_DetailPay) {
                refreshFoodList();
            } else if (selectedRadioButton == rdAccess_DetailPay) {
                refreshAccessoriesList();
            }
        }
        String selectedProduct = cbProductName_DetailPay.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            cbProductName_DetailPay.getSelectionModel().select(selectedProduct);
        }
    }

    private void updateSpinnerInDetailPay() {
        String selectedProduct = cbProductName_DetailPay.getValue();
        RadioButton selectedRadioButton = (RadioButton) typeProduct_DetailPay.getSelectedToggle();
        if (selectedProduct != null) {
            Integer quantity;
            if (selectedRadioButton == rdAccess_DetailPay) {
                quantity = categoryDAO.getQuantityInSerRent(selectedProduct);
            } else {
                quantity = categoryDAO.getQuantityInSerSell(selectedProduct);
            }

            if (quantity != null) {
                SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, quantity, 0);
                spQuantity_DetailPay.setValueFactory(valueFactory);
            }
        }
    }

    private void detailOfPaymentBill() {
        tfPayCode_DetailPay.setText("" + paySSI.getIdb());
        tfCusName_DetailPay.setText(paySSI.getKhachhang_name());
        tfPitName_DetailPay.setText(paySSI.getSanbong_name());
        tfEmpName_DetailPay.setText(paySSI.getQluser_name());
        tfDeposit_DetailPay.setText("$ " + paySSI.getDeposit());
        tfBookng_DetailPay.setText("$ " + paySSI.getTt_booking());
        tfService_DetailPay.setText("$ " + paySSI.getTt_service());
        tfTotalPay_DetailPay.setText("$ " + paySSI.getTt_payment());
        if (paySSI.getPay_date().toLocalDate().isBefore(LocalDate.now())) {
            btnUpdate_PaymentDetail.setDisable(true);
            btnAdd_PaymentDetail.setDisable(true);
        } else {
            btnUpdate_PaymentDetail.setDisable(false);
            btnAdd_PaymentDetail.setDisable(false);
        }
        clearInDetailPay();
    }

    public ObservableList getInvoicesOfPayment() {
        //tao danh sach 
        ObservableList<Composite_Bill> plist = FXCollections.observableArrayList();
        //connect
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        //truy van
        String sql = "SELECT combined.idb AS id, combined.name, combined.type, combined.price, combined.total_quantity, combined.totalAmount "
                + "FROM ("
                + "    SELECT hdss.idb, ss.name, cs.type, ss.price, SUM(hdss.qty) AS total_quantity, ss.price * SUM(hdss.qty) AS totalAmount "
                + "    FROM hd_ser_sell hdss "
                + "    JOIN ser_sell ss ON hdss.idss = ss.idss "
                + "    JOIN cat_ser cs ON cs.idc = ss.idc "
                + "    WHERE hdss.idb = ? "
                + "    GROUP BY hdss.idb, ss.name, cs.type, ss.price "
                + "    UNION ALL "
                + "    SELECT hdsr.idb, sr.name, cs.type, sr.price, SUM(hdsr.qty) AS total_quantity, sr.price * SUM(hdsr.qty) AS totalAmount "
                + "    FROM hd_ser_rent hdsr "
                + "    JOIN ser_rent sr ON hdsr.idsr = sr.idsr "
                + "    JOIN cat_ser cs ON cs.idc = sr.idc "
                + "    WHERE hdsr.idb = ? "
                + "    GROUP BY hdsr.idb, sr.name, cs.type, sr.price "
                + ") AS combined";

        PreparedStatement st;
        try {
            st = cn.prepareStatement(sql);
            int idb = paySSI.getIdb();

            st.setInt(1, idb);
            st.setInt(2, idb);

            ResultSet rs = st.executeQuery();
            Composite_Bill c;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                int qty = rs.getInt("total_quantity");
                double total = rs.getInt("totalAmount");
                c = new Composite_Bill(id, qty, total, name, price, type);
                plist.add(c);
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plist;
    }

    public void showInvoicesOfPayment() {
        ObservableList<Composite_Bill> plist = getInvoicesOfPayment();
        colProductName_DetailPay.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType_DetailPay.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPrice_DetailPay.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQuantity_DetailPay.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colTotal_DetailPay.setCellValueFactory(new PropertyValueFactory<>("total"));
        tvService_DetailPay.setItems(plist);

    }

    @FXML
    private void gotoDetaiofPayment(ActionEvent event) {
        setOpenDetailOfPayment();
    }

    @FXML
    private void onSelectInvoiceInDetailPay(MouseEvent event) {
        try {
            Composite_Bill b = tvService_DetailPay.getSelectionModel().getSelectedItem();
            if (b != null) {
                RadioButton selectedType = (RadioButton) typeProduct_DetailPay.getToggles().stream()
                        .filter(toggle -> toggle.getUserData().equals(b.getType()))
                        .findFirst()
                        .orElse(null);
                if (selectedType != null) {
                    typeProduct_DetailPay.selectToggle(selectedType);
                    updateComboxInDetailPay();
                    cbProductName_DetailPay.setValue(b.getName());
                }
                if (spQuantity_DetailPay.getValueFactory() != null) {
                    spQuantity_DetailPay.getValueFactory().setValue(b.getQty());
                } else {
                    SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, b.getQty(), 0);
                    spQuantity_DetailPay.setValueFactory(valueFactory);
                }

            } else {
                clearInDetailPay();
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Unable to select invoice details.");
        }
    }

    @FXML
    private void addInvoice_PaymentDetail(ActionEvent event) {
        lbName_DetailPay.setText("");
        lbQty_DetailPay.setText("");

        String name = cbProductName_DetailPay.getSelectionModel().getSelectedItem();
        Integer qty = spQuantity_DetailPay.getValue();

        boolean hasErr = false;
        boolean hasNameErr = name == null;
        if (hasNameErr) {
            lbName_DetailPay.setText("Please choose a product!");
            hasErr = true;
        }

        if (!hasNameErr) {
            qty = Optional.ofNullable(qty).orElse(0);
            if (qty <= 0) {
                lbQty_DetailPay.setText("Quantity greater than 0!");
                hasErr = true;
            }
        }
        if (hasErr || hasNameErr) {
            return;
        }

        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        PreparedStatement ps = null;
        PreparedStatement updatePs = null;
        ResultSet rs = null;

        RadioButton selectedRadioButton = (RadioButton) typeProduct_DetailPay.getSelectedToggle();
        int newPayService = 0;
        String insertQuery = null;
        String selectQuery = null;
        String updateQuery = null;
        String productType = selectedRadioButton == rdAccess_DetailPay ? "ser_rent" : "ser_sell";

        try {
            cn.setAutoCommit(false); // Transaction

            if (productType.equals("ser_rent")) {
                insertQuery = "INSERT INTO hd_ser_rent (idsr, idb, qty) VALUES ((SELECT idsr FROM ser_rent WHERE name = ?), ?, ?)";
                selectQuery = "SELECT qoh, price FROM ser_rent WHERE name = ?";
                updateQuery = "UPDATE ser_rent SET qoh = ? WHERE name = ?";
            } else {
                insertQuery = "INSERT INTO hd_ser_sell (idss, idb, qty) VALUES ((SELECT idss FROM ser_sell WHERE name = ?), ?, ?)";
                selectQuery = "SELECT qoh, price FROM ser_sell WHERE name = ?";
                updateQuery = "UPDATE ser_sell SET qoh = ? WHERE name = ?";
            }

            // Insert the invoice
            ps = cn.prepareStatement(insertQuery);
            ps.setString(1, name);
            ps.setInt(2, paySSI.getIdb());
            ps.setInt(3, qty);
            ps.executeUpdate();

            // Get current quantity and price
            ps = cn.prepareStatement(selectQuery);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                int currentQuantity = rs.getInt("qoh");
                int price = rs.getInt("price");
                newPayService = price * qty;

                // Update the quantity
                int newQuantity = currentQuantity - qty;
                if (newQuantity < 0) {
                    newQuantity = 0;
                }
                updatePs = cn.prepareStatement(updateQuery);
                updatePs.setInt(1, newQuantity);
                updatePs.setString(2, name);
                updatePs.executeUpdate();

                // Check if the product is out of stock
                if (newQuantity == 0) {
                    showAlert(AlertType.WARNING, "Product Out of Stock", "The product \"" + name + "\" is now out of stock!");
                }
            }
            cn.commit(); // Complete transaction

            // Show success alert
            showAlert(AlertType.INFORMATION, "Success", "Bill added and product quantity updated!");

        } catch (SQLException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error rolling back transaction: " + ex.getMessage());
                }
            }
            System.out.println("Error: " + e.getMessage());
            showAlert(AlertType.ERROR, "Error", "Error adding invoice or updating product quantity!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (updatePs != null) {
                    updatePs.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        // Update tt_service and tt_payment in the payments table
        updatePaymentDetails(newPayService);
    }

    //Update tt_service and tt_payment
    private void updatePaymentDetails(int newPayService) {
        String updatePaymentSQL = "UPDATE payments SET tt_service = tt_service + ?, tt_payment = tt_payment + ? WHERE idb = ?";
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(updatePaymentSQL);
            ps.setInt(1, newPayService);
            ps.setInt(2, newPayService); // Assuming tt_payment should also be updated with newPayService
            ps.setInt(3, paySSI.getIdb());
            if (ps.executeUpdate() > 0) {
                // Refresh paySSI information
                refreshPaySSI();
                // Update the detail of payment bill
                detailOfPaymentBill();
                // Update the table view
                showInvoicesOfPayment();
                showAlert(Alert.AlertType.INFORMATION, "PaymentBill", "Payment Bill updated successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to update payment.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    //Update PaymentBill paySSI
    private void refreshPaySSI() {
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        String query = "SELECT * FROM payments WHERE idb = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, paySSI.getIdb());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paySSI.setTt_service(rs.getInt("tt_service"));
                paySSI.setTt_payment(rs.getInt("tt_payment"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    @FXML
    private void clearInvoice_PaymentDetail(ActionEvent event) {
        clearInDetailPay();
    }

    @FXML
    private void updateInvoice_PaymentDetail(ActionEvent event) {
        lbQty_DetailPay.setText("");

        Integer newQty = spQuantity_DetailPay.getValue();

        if (newQty == null || newQty <= 0) {
            lbQty_DetailPay.setText("Quantity greater than 0!");
            return;
        }

        Composite_Bill selectedBill = tvService_DetailPay.getSelectionModel().getSelectedItem();
        if (selectedBill == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "No Invoice Service selected!");
            return;
        }

        int oldQty = selectedBill.getQty();
        int qtyDifference = newQty - oldQty;

        if (qtyDifference == 0) {
            showAlert(Alert.AlertType.INFORMATION, "No Change", "Quantity remains the same.");
            return;
        }

        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        RadioButton selectedRadioButton = (RadioButton) typeProduct_DetailPay.getSelectedToggle();
        String productType = selectedRadioButton == rdAccess_DetailPay ? "ser_rent" : "ser_sell";
        String name = cbProductName_DetailPay.getSelectionModel().getSelectedItem();

        String selectQuery = null;
        String updateDetailQuery = null;
        String updateProductQuery = null;
        int newPayService = 0;

        if (productType.equals("ser_rent")) {
            selectQuery = "SELECT qoh, price FROM ser_rent WHERE name = ?";
            updateDetailQuery = "UPDATE hd_ser_rent SET qty = ? WHERE idsr = (SELECT idsr FROM ser_rent WHERE name = ?) AND idb = ?";
            updateProductQuery = "UPDATE ser_rent SET qoh = ? WHERE name = ?";
        } else {
            selectQuery = "SELECT qoh, price FROM ser_sell WHERE name = ?";
            updateDetailQuery = "UPDATE hd_ser_sell SET qty = ? WHERE idss = (SELECT idss FROM ser_sell WHERE name = ?) AND idb = ?";
            updateProductQuery = "UPDATE ser_sell SET qoh = ? WHERE name = ?";
        }

        try {
            cn.setAutoCommit(false); // Transaction

            // Get current quantity on hand and price
            ps = cn.prepareStatement(selectQuery);
            ps.setString(1, name);
            rs = ps.executeQuery();
            int currentQoh = 0;
            int price = 0;
            if (rs.next()) {
                currentQoh = rs.getInt("qoh");
                price = rs.getInt("price");
            }

            // Update the quantity in the invoice detail
            ps = cn.prepareStatement(updateDetailQuery);
            ps.setInt(1, newQty);
            ps.setString(2, name);
            ps.setInt(3, paySSI.getIdb());
            ps.executeUpdate();

            // Update the quantity on hand in the product table
            int newQoh = currentQoh - qtyDifference;
            ps = cn.prepareStatement(updateProductQuery);
            ps.setInt(1, newQoh);
            ps.setString(2, name);
            ps.executeUpdate();

            cn.commit(); // Complete transaction

            // Check if the product is out of stock
            if (newQoh == 0) {
                showAlert(Alert.AlertType.WARNING, "Product Out of Stock", "The product \"" + name + "\" is now out of stock!");
            }
            // Calculate the price difference for the updatePaymentDetails method
            newPayService = price * qtyDifference;

        } catch (SQLException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error rolling back transaction: " + ex.getMessage());
                }
            }
            System.out.println("Error: " + e.getMessage());
            showAlert(Alert.AlertType.ERROR, "Error", "Error updating invoice detail or product quantity!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        updatePaymentDetails(newPayService);
    }

    @FXML
    private void deleteInvoice_PaymentDetail(ActionEvent event) {
        Composite_Bill selectedBill = tvService_DetailPay.getSelectionModel().getSelectedItem();
        if (selectedBill == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "No Invoice Service selected!");
            return;
        }

        RadioButton selectedRadioButton = (RadioButton) typeProduct_DetailPay.getSelectedToggle();
        String productType = selectedRadioButton == rdAccess_DetailPay ? "ser_rent" : "ser_sell";
        String name = cbProductName_DetailPay.getSelectionModel().getSelectedItem();

        String deleteDetailQuery = null;
        String updateProductQuery = null;
        String selectServiceQuery = null;
        String selectInvoiceQuery = null;

        if (productType.equals("ser_rent")) {
            deleteDetailQuery = "DELETE FROM hd_ser_rent WHERE idsr = (SELECT idsr FROM ser_rent WHERE name = ?) AND idb = ?";
            updateProductQuery = "UPDATE ser_rent SET qoh = qoh + ? WHERE name = ?";
            selectServiceQuery = "SELECT price FROM ser_rent WHERE name = ?";
            selectInvoiceQuery = "SELECT qty FROM hd_ser_rent WHERE idsr = (SELECT idsr FROM ser_rent WHERE name = ?) AND idb = ?";
        } else {
            deleteDetailQuery = "DELETE FROM hd_ser_sell WHERE idss = (SELECT idss FROM ser_sell WHERE name = ?) AND idb = ?";
            updateProductQuery = "UPDATE ser_sell SET qoh = qoh + ? WHERE name = ?";
            selectServiceQuery = "SELECT price FROM ser_sell WHERE name = ?";
            selectInvoiceQuery = "SELECT qty FROM hd_ser_sell WHERE idss = (SELECT idss FROM ser_sell WHERE name = ?) AND idb = ?";
        }

        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        int payRemove = 0;

        try {
            cn.setAutoCommit(false);

            ps = cn.prepareStatement(selectInvoiceQuery);
            ps.setString(1, name);
            ps.setInt(2, paySSI.getIdb());
            rs = ps.executeQuery();
            int currentQty = 0;
            if (rs.next()) {
                currentQty = rs.getInt("qty");
            }

            ps = cn.prepareStatement(selectServiceQuery);
            ps.setString(1, name);
            rs = ps.executeQuery();
            int price = 0;
            if (rs.next()) {
                price = rs.getInt("price");
            }

            ps = cn.prepareStatement(deleteDetailQuery);
            ps.setString(1, name);
            ps.setInt(2, paySSI.getIdb());
            ps.executeUpdate();

            ps = cn.prepareStatement(updateProductQuery);
            ps.setInt(1, currentQty);
            ps.setString(2, name);
            ps.executeUpdate();

            cn.commit();

            int qtyToRemove = selectedBill.getQty();
            payRemove = (-1) * qtyToRemove * price;
            showAlert(Alert.AlertType.INFORMATION, "Success", "Invoice detail deleted and payment details updated successfully.");
        } catch (SQLException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error rolling back transaction: " + ex.getMessage());
                }
            }
            System.out.println("Error: " + e.getMessage());
            showAlert(Alert.AlertType.ERROR, "Error", "Error deleting invoice detail or updating payment details!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        updatePaymentDetails(payRemove);
    }

    @FXML
    private void backToPaymentBill(ActionEvent event) {
        clearInDetailPay();

        setOpenPage();
        DashboardPage.setVisible(false);
        PaymentPage.setVisible(true);
    }

    //-----------------------------------------------------EMPLOYEE-----------------------------------------------------------------
    private void setupOpenEmployeePage() {
        showUsers();

        loadPositions_User();

        loadUserData();

        tfSearch_User.textProperty().addListener((observable, oldValue, newValue) -> {
            searchUser();
        });

        tfEmail_User.textProperty().addListener((observable, oldValue, newValue) -> {
            isEmailConfirmed_User = false;
            btnAdd_User.setDisable(true);
        });
    }

    @FXML
    private void searchUser() {
        String keyword = tfSearch_User.getText().trim();
        if (keyword.isEmpty()) {
            showUsers();
        } else {
            ObservableList<User> searchResults = FXCollections.observableArrayList();

            for (User user : tbView_User.getItems()) {
                if (user.getName().toLowerCase().contains(keyword.toLowerCase())
                        || user.getPhone().toLowerCase().contains(keyword.toLowerCase())) {
                    searchResults.add(user);
                }
            }

            tbView_User.setItems(searchResults);

        }
    }

    public void showUsers() {
        ObservableList<User> userList = getUsers();

        // Show data in TableView
        colImg_User.setCellValueFactory(new PropertyValueFactory<>("img"));
        colName_User.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPos_User.setCellValueFactory(new PropertyValueFactory<>("position"));
        colGender_User.setCellValueFactory(cellData -> {
            SimpleStringProperty property = new SimpleStringProperty();
            if (cellData.getValue().isGender()) {
                property.setValue("Male");
            } else {
                property.setValue("Female");
            }
            return property;
        });
        colBirth_User.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        colPhone_User.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail_User.setCellValueFactory(new PropertyValueFactory<>("mail"));
        colPass_User.setCellValueFactory(new PropertyValueFactory<>("pw"));

        tbView_User.setItems(userList);
    }

    public ObservableList<User> getUsers() {
        ObservableList<User> userList = FXCollections.observableArrayList();

        ConnectDB connector = new ConnectDB();
        Connection conn = connector.getConnect();

        if (conn != null) {
            try {
                String query = "SELECT q.img, q.name, q.idt, ut.type, q.gender, q.birthday, q.phone, q.mail, q.pw "
                        + "FROM qluser q INNER JOIN user_type ut ON q.idt = ut.idt";

                try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

                    while (rs.next()) {
                        String image = rs.getString("img");
                        String name = rs.getString("name");
                        String position = rs.getString("type");
                        boolean gender = rs.getBoolean("gender");
                        Date birthday = rs.getDate("birthday");
                        String phone = rs.getString("phone");
                        String mail = rs.getString("mail");
                        String pw = rs.getString("pw");

                        // Load image from file path
                        Image img = new Image("file:/" + IMAGE_DIR + image);
                        ImageView imgView = new ImageView(img);
                        imgView.setFitHeight(50);
                        imgView.setFitWidth(50);
                        imgView.setPreserveRatio(true);

                        // Create User object and add to ObservableList
                        User user = new User(null, imgView, name, position, gender, birthday, phone, mail, pw);
                        userList.add(user);
                    }

                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error fetching users: " + ex.getMessage());
            }
        } else {
            System.out.println("Failed to connect to database");
        }

        return userList;
    }

    @FXML
    private void onSelectUser(MouseEvent event) {
        User selectedUser = tbView_User.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            tfName_User.setText(selectedUser.getName());
            cbPos_User.setValue(selectedUser.getPosition());

            if (selectedUser.isGender()) {
                maleRadioButton_User.setSelected(true);
            } else {
                femaleRadioButton_User.setSelected(true);
            }

            Date birthday = selectedUser.getBirthday();
            LocalDate localDate = birthday.toLocalDate();
            tfBirth_User.setValue(localDate);
            tfPhone_User.setText(selectedUser.getPhone());

            // Assuming View_User is an ImageView
            View_User.setImage(selectedUser.getImg().getImage());

            // Assuming getImg() returns an ImageView directly
            String imageUrl = selectedUser.getImg().getImage().getUrl();
            String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
            selectImageName = imageName;
            tfEmail_User.setText(selectedUser.getMail());
            tfPass_User.setText(selectedUser.getPw());
        }
    }

    @FXML
    private void addUser_User(ActionEvent event) {
        String name = tfName_User.getText();
        String position = cbPos_User.getValue();
        RadioButton selectedGender = (RadioButton) gender_User.getSelectedToggle();
        String gender = selectedGender != null ? selectedGender.getText() : "";
        String birthday = tfBirth_User.getValue() != null ? tfBirth_User.getValue().toString() : "";
        String phone = tfPhone_User.getText();
        String password = tfPass_User.getText(); // Assuming password is used as idu
        String mail = tfEmail_User.getText();

        User loggedInUser = App.getLoggedInUser();

        // Kiểm tra nếu người dùng đã đăng nhập và có loại người dùng
        if (loggedInUser != null && loggedInUser.getType() != null) {
            String userType = loggedInUser.getType().toLowerCase();
            if (userType.equals("admin")) {
                // Nếu là admin, kiểm tra xem người dùng muốn thêm là admin hoặc owner không
                if (position != null && (position.equalsIgnoreCase("admin") || position.equalsIgnoreCase("owner"))) {
                    showAlert(Alert.AlertType.ERROR, "Permission Denied", "Admin users cannot add other admins or owners.");
                    return;
                }
            }
        }
        // Use a loop to validate each input field
        boolean isValid = false;
        while (!isValid) {
            try {
                if (name.isEmpty()) {
                    throw new Exception("Name is required");
                }
                if (position == null) {
                    throw new Exception("Position is required");
                }
                if (gender.isEmpty()) {
                    throw new Exception("Gender is required");
                }
                if (birthday.isEmpty()) {
                    throw new Exception("Birthday is required");
                }
                if (phone.isEmpty()) {
                    throw new Exception("Phone number is required");
                }
                if (password.isEmpty()) {
                    throw new Exception("Password is required");
                }
                if (selectImageName == null) {
                    throw new Exception("Image is required");
                }
                if (mail.isEmpty()) {
                    throw new Exception("Email is required");
                }

                // All validations passed
                isValid = true;
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Form Error!", e.getMessage());
                return;
            }
        }

        // Copy selected image to IMAGE_DIR
        Path sourcePath = Paths.get(IMAGE_DIR, selectImageName);
        Path targetPath = Paths.get(IMAGE_DIR, new File(selectImageName).getName());

        try {
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            showAlert(Alert.AlertType.ERROR, "Image Copy Error", "Failed to copy image: " + ex.getMessage());
            return;
        }

        ConnectDB connector = new ConnectDB();
        Connection conn = connector.getConnect();

        if (conn != null) {
            try {
                // Insert new user into qluser table
                String query = "INSERT INTO qluser (idu, pw, idt, name, birthday, gender, phone, img, mail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, phone); // idu is phone number
                    stmt.setString(2, password); // pw is password
                    stmt.setString(3, positionUserMap.get(position)); // Convert position name to idt
                    stmt.setString(4, name);
                    stmt.setString(5, birthday);
                    stmt.setBoolean(6, gender.equals("Male")); // Gender: true for male, false for female
                    stmt.setString(7, phone); // Phone also stored in phone
                    stmt.setString(8, selectImageName); // Image path
                    stmt.setString(9, mail);

                    stmt.executeUpdate();
                } // idu is phone number
                conn.close();

                // Reload data after successful addition
                loadUserData();
                clearInEmployeePage();
                showAlert(Alert.AlertType.INFORMATION, "Success", "User member added successfully");
                btnAdd_User.setDisable(true);
            } catch (SQLException ex) {
                System.out.println("Error adding user: " + ex.getMessage());
                showAlert(Alert.AlertType.ERROR, "Error", "User already exists: " + ex.getMessage());
            }
        } else {
            System.out.println("Failed to connect to database");
        }
    }

    @FXML
    private void updateUser_User(ActionEvent event) {
        String name = tfName_User.getText();
        String position = cbPos_User.getValue();
        RadioButton selectedGender = (RadioButton) gender_User.getSelectedToggle();
        String gender = selectedGender != null ? selectedGender.getText() : "";
        String birthday = tfBirth_User.getValue() != null ? tfBirth_User.getValue().toString() : "";
        String phone = tfPhone_User.getText();
        String mail = tfEmail_User.getText();
        String pass = tfPass_User.getText();

        if (name.isEmpty() || position == null || gender.isEmpty() || birthday.isEmpty() || phone.isEmpty() || selectImageName == null || mail.isEmpty() || pass.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please fill in all fields");
            return;
        }

        // Kiểm tra xem position có tồn tại trong bản đồ hay không
        if (!positionUserMap.containsKey(position)) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Invalid position selected");
            return;
        }

        // Copy selected image to IMAGE_DIR if it doesn't exist
        Path sourcePath = Paths.get(IMAGE_DIR, selectImageName);
        Path targetPath = Paths.get(IMAGE_DIR, new File(selectImageName).getName());

        try {
            if (!Files.exists(targetPath)) {
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException ex) {
            showAlert(Alert.AlertType.ERROR, "Image Copy Error", "Failed to copy image: " + ex.getMessage());
            return;
        }

        ConnectDB connector = new ConnectDB();
        Connection conn = connector.getConnect();

        if (conn != null) {
            try {
                // Update user in the database
                String query = "UPDATE qluser SET name=?, idt=?, gender=?, birthday=?, phone=?, img=?, mail=?, pw=? WHERE phone=?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, name);
                    stmt.setString(2, positionUserMap.get(position)); // Convert position name to idt
                    stmt.setBoolean(3, gender.equals("Male"));
                    stmt.setString(4, birthday);
                    stmt.setString(5, phone);
                    stmt.setString(6, selectImageName);
                    stmt.setString(7, mail);
                    stmt.setString(8, pass);
                    stmt.setString(9, phone);

                    stmt.executeUpdate();
                }
                conn.close();

                // Reload data after successful update
                loadUserData();
                showAlert(Alert.AlertType.INFORMATION, "Success", "User member updated successfully");
            } catch (SQLException ex) {
                System.out.println("Error updating user: " + ex.getMessage());
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to update user: " + ex.getMessage());
            }
        } else {
            System.out.println("Failed to connect to database");
        }
    }

    private final Map<String, String> positionUserMap = new HashMap<>();

    void loadPositions_User() {
        ObservableList<String> positionList = FXCollections.observableArrayList();
        positionUserMap.clear(); // Clear map before reloading

        ConnectDB connector = new ConnectDB();
        Connection conn = connector.getConnect();

        if (conn != null) {
            try {
                String query = "SELECT idt, type FROM user_type";
                try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

                    while (rs.next()) {
                        String idt = rs.getString("idt");
                        String type = rs.getString("type");
                        positionList.add(type);
                        positionUserMap.put(type, idt); // Store type and idt in the map
                    }

                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error fetching positions: " + ex.getMessage());
            }
        } else {
            System.out.println("Failed to connect to database");
        }

        cbPos_User.setItems(positionList);
    }

    public void loadUserData() {
        ConnectDB connector = new ConnectDB();
        Connection conn = connector.getConnect();

        if (conn != null) {
            try {
                String query = "SELECT q.img, q.name, q.idt, ut.type, q.gender, q.birthday, q.phone, q.mail, q.pw "
                        + "FROM qluser q INNER JOIN user_type ut ON q.idt = ut.idt WHERE q.idt > ?";

                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, Emp.getIdt());
                    ResultSet rs = stmt.executeQuery();
                    // Clear existing items in TableView
                    tbView_User.getItems().clear();

                    while (rs.next()) {
                        String image = rs.getString("img");
                        String name = rs.getString("name");
                        String position = rs.getString("type");
                        boolean gender = rs.getBoolean("gender");
                        Date birthday = rs.getDate("birthday");
                        String phone = rs.getString("phone");
                        String mail = rs.getString("mail");
                        String pw = rs.getString("pw");

                        // Load image from file path
                        Image img = new Image("file:/" + IMAGE_DIR + image);
                        ImageView imgView = new ImageView(img);
                        imgView.setFitHeight(50);
                        imgView.setFitWidth(50);
                        imgView.setPreserveRatio(true);

                        // Create User object and add to TableView
                        User user = new User(null, imgView, name, position, gender, birthday, phone, mail, pw);
                        tbView_User.getItems().add(user);
                    }
                    // Close resources

                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error fetching data: " + ex.getMessage());

            }
        } else {
            System.out.println("Failed to connect to database");
        }
    }

    @FXML
    public void deleteUser_User(ActionEvent event) {
        String phone = tfPhone_User.getText(); // Assuming phone number is used as the unique identifier (idu)

        if (phone.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter a phone number to delete");
            return;
        }

        // Show confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Delete User");
        alert.setContentText("Are you sure you want to delete this user?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User confirmed deletion
            ConnectDB connector = new ConnectDB();
            Connection conn = connector.getConnect();

            if (conn != null) {
                try {
                    // Delete staff member from the database
                    String query = "DELETE FROM qluser WHERE phone=?";
                    int rowsDeleted;
                    try (PreparedStatement stmt = conn.prepareStatement(query)) {
                        stmt.setString(1, phone); // Delete based on phone number as ID
                        rowsDeleted = stmt.executeUpdate();
                    } // Delete based on phone number as ID
                    conn.close();

                    if (rowsDeleted > 0) {
                        // Reload data after successful deletion
                        loadUserData();
                        showUsers();
                        showAlert(Alert.AlertType.INFORMATION, "Success", "Staff member deleted successfully");
                        clearInEmployeePage();
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Delete Error", "No such staff member found with the provided phone number");
                    }
                } catch (SQLException ex) {
                    System.out.println("Error deleting user: " + ex.getMessage());
                    showAlert(Alert.AlertType.ERROR, "Delete Error", "Insufficient permissions to delete this user");
                }
            } else {
                System.out.println("Failed to connect to database");
            }
        } else {
            // User clicked Cancel or closed the dialog
            System.out.println("Deletion cancelled by user");
        }
    }

    @FXML
    public void selectImage_User(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Update selectImageName with the selected file name
            selectImageName = selectedFile.getName();

            // Construct selectImageURL correctly using URI.toString()
            selectImageURL = selectedFile.toURI().toString();
            System.out.println(selectImageURL); // Debugging

            // Copy the selected file to IMAGE_DIR
            from = selectedFile.toPath();
            to = Paths.get(IMAGE_DIR + selectImageName);

            CopyOption options = StandardCopyOption.REPLACE_EXISTING;
            try {
                Files.copy(from, to, options);

                // Load the image into ImageView
                Image image = new Image(selectImageURL);
                View_User.setImage(image);

            } catch (IOException ex) {

                System.out.println("Error: cannot copy " + ex.getMessage());
            }
        }
    }

    @FXML
    public void clearFields_User(ActionEvent event) {
        clearInEmployeePage();
    }

    public void clearInEmployeePage() {
        tfName_User.clear();
        cbPos_User.setValue(null);
        gender_User.selectToggle(null);
        tfBirth_User.setValue(null);
        tfPhone_User.clear();
        tfPass_User.clear();
        View_User.setImage(null); // Reset ImageView
        selectImageName = null; // Reset selectedImageName if needed
        tfEmail_User.clear();
    }

    @FXML
    private void Position_User(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Position.fxml"));
            Parent root = loader.load();

            PositionController positionController = loader.getController();
            positionController.setParentController(this);

            // Sử dụng đường dẫn tương đối từ thư mục resources
            String css = getClass().getResource("position.css").toExternalForm();
            root.getStylesheets().add(css);

            Stage stage = new Stage();
            stage.setTitle("Position");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error opening Add Position window: " + ex.getMessage());
        }
    }

    // Biến để theo dõi trạng thái xác nhận email
    private boolean isEmailConfirmed_User = false;

// Hàm để xác nhận email
    @FXML
    private void btnConfirmE_User(MouseEvent event) {
        String email = tfEmail_User.getText();

        // Kiểm tra email hợp lệ trước khi gửi mã xác nhận
        if (!isValidEmail_User(email)) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Invalid email address.");
            return;
        }

        // Gửi mã xác nhận trong một luồng riêng để không khóa giao diện người dùng
        new Thread(() -> sendVerificationEmail_User(email)).start();

        // Hiển thị dialog để người dùng nhập mã xác nhận
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Email Verification");
        dialog.setHeaderText("A verification code has been sent to your email.");
        dialog.setContentText("Please enter the verification code:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(code -> {
            if (isVerificationCodeCorrect_User(code)) {
                isEmailConfirmed_User = true;
                btnAdd_User.setDisable(false);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Email verified successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid verification code.");
            }
        });
    }

// Hàm để gửi email xác nhận
    private void sendVerificationEmail_User(String email) {
        verificationCode = generateVerificationCode_User();

        String subject = "Your Verification Code";
        String message = "Your verification code is: " + verificationCode;

        // Setup mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("paradisesport2024@gmail.com", "qjsh sesq wbci fsku");
            }
        });

        try {
            // Create a default MimeMessage object
            Message msg = new MimeMessage(session);

            // Set From: header field
            msg.setFrom(new InternetAddress("paradisesport2024@gmail.com"));

            // Set To: header field
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            // Set Subject: header field
            msg.setSubject(subject);

            // Set the actual message
            msg.setText(message);

            // Send message
            Transport.send(msg);
            System.out.println("Sent message successfully...");

        } catch (MessagingException e) {
            Platform.runLater(() -> showAlert(Alert.AlertType.ERROR, "Error", "Failed to send email: " + e.getMessage()));
        }
    }

// Hàm kiểm tra email hợp lệ
    private boolean isValidEmail_User(String email) {
        // Simple email validation using regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

// Hàm tạo mã xác nhận
    private String generateVerificationCode_User() {
        // Generate a random 6-digit verification code
        return String.valueOf((int) (Math.random() * 900000) + 100000);
    }

// Hàm kiểm tra mã xác nhận
    private boolean isVerificationCodeCorrect_User(String code) {
        return verificationCode != null && verificationCode.equals(code);
    }

// Đặt lại trạng thái xác nhận email khi email bị thay đổi
    private void tfEmail_User_TextChanged(ActionEvent event) {
        isEmailConfirmed_User = false;
        btnAdd_User.setDisable(true);
    }

    //-----------------------------------------------------CUSTOMER----------------------------------------------------------------
    private void setupOpenCustomerPage() {
        connectToDatabase();
        showCustomers();
        loadCustomers();
        tfSearch_Cus.textProperty().addListener((observable, oldValue, newValue) -> {
            searchCus();
        });
        if (Emp.getIdt() > 1) {
            btnDelete_Cus.setDisable(true);
        } else {
            btnDelete_Cus.setDisable(false);
        }
    }

    private void searchCus() {
        String keyword = tfSearch_Cus.getText().trim();
        if (keyword.isEmpty()) {
            showCustomers();
        } else {
            ObservableList<Customer> searchResults = FXCollections.observableArrayList();

            for (Customer cus : tbView_Cus.getItems()) {
                if (cus.getPhone().toLowerCase().contains(keyword.toLowerCase())) {
                    searchResults.add(cus);
                }
            }

            tbView_Cus.setItems(searchResults);
        }
    }

    public void showCustomers() {
        ObservableList<Customer> cusList = loadCustomers2();

        if (cusList == null) {
            System.out.println("Customer list is null. Please check loadCustomers method.");
            return;
        }

        customerList = FXCollections.observableArrayList();

        colName_Cus.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhone_Cus.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colPoint_Cus.setCellValueFactory(new PropertyValueFactory<>("point"));
        colEmail_Cus.setCellValueFactory(new PropertyValueFactory<>("mail"));

        tbView_Cus.setItems(cusList);
    }

    private ObservableList<Customer> loadCustomers2() {
        ObservableList<Customer> cusList = FXCollections.observableArrayList();

        ConnectDB connector = new ConnectDB();
        Connection conn = connector.getConnect();

        if (conn != null) {
            try {
                String query = "SELECT name, phone, point, mail FROM khachhang";
                try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String phone = rs.getString("phone");
                        int point = rs.getInt("point");
                        String mail = rs.getString("mail");

                        Customer customer = new Customer(phone, name, phone, point, mail);
                        cusList.add(customer);
                    }
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error fetching users: " + ex.getMessage());
            }
        } else {
            System.out.println("Failed to connect to database");
        }
        return cusList; // return the correct cusList
    }

    private void connectToDatabase() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsanbong;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "123";

        try {
            // Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Connect to database
            connection = DriverManager.getConnection(url, username, pass);
            System.out.println("Connect Successfully");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error loading driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error connecting to database: " + ex.getMessage());
        }
    }

    private void loadCustomers() {
        if (connection != null) {
            String query = "SELECT name, phone, point, mail FROM khachhang";

            try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    int point = rs.getInt("point");
                    String mail = rs.getString("mail");

                    Customer customer = new Customer(phone, name, phone, point, mail);
                    customerList.add(customer);
                }
            } catch (SQLException ex) {
                System.out.println("Error loading customers: " + ex.getMessage());
            }
        }
    }

    @FXML
    private void addCustomer(ActionEvent event) {
        String name = tfName_Cus.getText().trim();
        String phone = tfPhone_Cus.getText().trim();
        String pointText = tfPoint_Cus.getText().trim();
        String mail = tfEmail_Cus.getText().trim();

        // Kiểm tra các trường dữ liệu không được để trống
        if (name.isEmpty() || phone.isEmpty() || pointText.isEmpty() || mail.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill in all fields.");
            return;
        }

        int point = Integer.parseInt(pointText);
        try {
            if (point < 0) {
                showAlert(Alert.AlertType.ERROR, "Error", "Points must be a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Points must be a valid number.");
            return;
        }

        if (!phone.matches("\\d{10}")) {
            showAlert(Alert.AlertType.ERROR, "Error", "Phone number must be 10 digits.");
            return;
        }

        // Kiểm tra xem số điện thoại hoặc email đã tồn tại chưa
        if (isCustomerExistAdd(phone, mail)) {
            return;
        }

        if (connection != null) {
            String insertQuery = "INSERT INTO khachhang (idk, name, phone, point, mail) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
                ps.setString(1, phone);
                ps.setString(2, name);
                ps.setString(3, phone);
                ps.setInt(4, point);
                ps.setString(5, mail);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    Customer newCustomer = new Customer(phone, name, phone, point, mail);
                    customerList.add(newCustomer);
                    clearInCustomerPage();
                    showCustomers();
                    tbView_Cus.refresh();
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Customer added successfully.");
                    btnAdd_Cus.setDisable(true);
                }
            } catch (SQLException ex) {
                showAlert(Alert.AlertType.ERROR, "SQL Error", "Error adding customer: \n" + ex.getMessage());
            }
        }
    }

    private boolean isCustomerExistUpdate(String phone, String mail, String currentPhone, String currentMail) {
        boolean phoneExists = false;
        boolean mailExists = false;

        if (connection != null) {
            if (!phone.equals(currentPhone)) {
                String phoneQuery = "SELECT COUNT(*) FROM khachhang WHERE phone = ?";
                try (PreparedStatement psPhone = connection.prepareStatement(phoneQuery)) {
                    psPhone.setString(1, phone);

                    try (ResultSet rsPhone = psPhone.executeQuery()) {
                        if (rsPhone.next()) {
                            phoneExists = rsPhone.getInt(1) > 0;
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("Error checking customer existence for phone: \n" + ex.getMessage());
                }
            }

            if (!mail.equals(currentMail)) {
                String mailQuery = "SELECT COUNT(*) FROM khachhang WHERE mail = ?";
                try (PreparedStatement psMail = connection.prepareStatement(mailQuery)) {
                    psMail.setString(1, mail);

                    try (ResultSet rsMail = psMail.executeQuery()) {
                        if (rsMail.next()) {
                            mailExists = rsMail.getInt(1) > 0;
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("Error checking customer existence for mail: \n" + ex.getMessage());
                }
            }
        }

        if (phoneExists && mailExists) {
            showAlert(Alert.AlertType.ERROR, "Error", "Phone number and email already exist.");
        } else if (phoneExists) {
            showAlert(Alert.AlertType.ERROR, "Error", "Phone number already exists.");
        } else if (mailExists) {
            showAlert(Alert.AlertType.ERROR, "Error", "Email already exists.");
        }

        return phoneExists || mailExists;
    }

    private boolean isCustomerExistAdd(String phone, String mail) {
        if (connection != null) {
            String query = "SELECT COUNT(*) FROM khachhang WHERE phone = ?";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, phone);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int countPhone = rs.getInt(1);
                        if (countPhone > 0) {
                            showAlert(Alert.AlertType.ERROR, "Error", "Phone number already exists.");
                            return true;
                        }
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error checking customer existence: \n" + ex.getMessage());
            }

            // Kiểm tra email
            query = "SELECT COUNT(*) FROM khachhang WHERE mail = ?";

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, mail);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int countMail = rs.getInt(1);
                        if (countMail > 0) {
                            showAlert(Alert.AlertType.ERROR, "Error", "Email already exists.");
                            return true;
                        }
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error checking customer existence: \n" + ex.getMessage());
            }
        }

        return false;
    }

    private void clearInCustomerPage() {
        tfName_Cus.clear();
        tfPhone_Cus.clear();
        tfPoint_Cus.clear();
        tfEmail_Cus.clear();

    }

    @FXML
    private void clearCustomer(ActionEvent event) {
        clearInCustomerPage();
    }

    @FXML
    private void updateCustomer(ActionEvent event) {
        Customer selectedCustomer = tbView_Cus.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            // Lấy giá trị mới từ giao diện người dùng
            String name = tfName_Cus.getText().trim();
            String phone = tfPhone_Cus.getText().trim();
            String pointText = tfPoint_Cus.getText().trim();
            String mail = tfEmail_Cus.getText().trim();
            String idk = phone; // Sử dụng phone làm idk

            // Kiểm tra xem tất cả các trường đã được điền
            if (name.isEmpty() || phone.isEmpty() || pointText.isEmpty() || mail.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please fill in all fields.");
                return;
            }

            // Kiểm tra điều kiện dữ liệu và ràng buộc
            int point;
            try {
                point = Integer.parseInt(pointText);
                if (point < 0) {
                    showAlert(Alert.AlertType.ERROR, "Error", "Points must be a positive integer.");
                    return;
                }
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Points must be a valid number.");
                return;
            }

            if (!phone.matches("\\d{10}")) {
                showAlert(Alert.AlertType.ERROR, "Error", "Phone number must be 10 digits.");
                return;
            }

            // Kiểm tra nếu có bất kỳ dữ liệu nào đã thay đổi
            if (name.equals(selectedCustomer.getName())
                    && phone.equals(selectedCustomer.getPhone())
                    && point == selectedCustomer.getPoint()
                    && mail.equals(selectedCustomer.getMail())) {
                showAlert(Alert.AlertType.WARNING, "No Changes", "No changes detected.");
                return;
            }

            // Kiểm tra xem email hoặc phone đã tồn tại chưa
            if (isCustomerExistUpdate(phone, mail, selectedCustomer.getPhone(), selectedCustomer.getMail())) {
                return;
            }

            // Hiển thị hộp thoại xác nhận trước khi cập nhật
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Confirmation");
            confirmAlert.setHeaderText(null);
            confirmAlert.setContentText("Do you really want to update the customer information?");

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Nếu người dùng đồng ý, tiếp tục với việc cập nhật

                // Nếu phone (idk) đã thay đổi, hiển thị hộp thoại xác nhận
                if (!phone.equals(selectedCustomer.getPhone())) {
                    Alert phoneChangeAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    phoneChangeAlert.setTitle("Confirmation");
                    phoneChangeAlert.setHeaderText(null);
                    phoneChangeAlert.setContentText("Changing the phone number will also update related records. Do you really want to change the phone number?");

                    Optional<ButtonType> phoneChangeResult = phoneChangeAlert.showAndWait();
                    if (phoneChangeResult.isPresent() && phoneChangeResult.get() == ButtonType.NO) {
                        return;
                    }
                }

                // Thực hiện câu lệnh UPDATE trong cơ sở dữ liệu
                if (connection != null) {
                    try {
                        // Bắt đầu giao dịch
                        connection.setAutoCommit(false);

                        // Vô hiệu hóa kiểm tra ràng buộc khóa ngoại
                        try (Statement stmt = connection.createStatement()) {
                            stmt.execute("ALTER TABLE payments NOCHECK CONSTRAINT FK__payments__idk__656C112C");
                        }

                        // Cập nhật bảng khachhang
                        String updateCustomerQuery = "UPDATE khachhang SET name = ?, phone = ?, point = ?, mail = ?, idk = ? WHERE phone = ?";
                        try (PreparedStatement ps = connection.prepareStatement(updateCustomerQuery)) {
                            ps.setString(1, name);
                            ps.setString(2, phone);
                            ps.setInt(3, point);
                            ps.setString(4, mail);
                            ps.setString(5, idk);
                            ps.setString(6, selectedCustomer.getPhone());
                            ps.executeUpdate();
                        }

                        // Cập nhật bảng payments
                        if (!idk.equals(selectedCustomer.getPhone())) {
                            String updatePaymentsQuery = "UPDATE payments SET idk = ? WHERE idk = ?";
                            try (PreparedStatement ps = connection.prepareStatement(updatePaymentsQuery)) {
                                ps.setString(1, phone);
                                ps.setString(2, selectedCustomer.getPhone());
                                ps.executeUpdate();
                            }
                        }

                        // Kích hoạt lại kiểm tra ràng buộc khóa ngoại
                        try (Statement stmt = connection.createStatement()) {
                            stmt.execute("ALTER TABLE payments CHECK CONSTRAINT FK__payments__idk__656C112C");
                        }

                        // Commit giao dịch
                        connection.commit();

                        // Cập nhật lại thông tin của đối tượng Customer
                        selectedCustomer.setName(name);
                        selectedCustomer.setPhone(phone);
                        selectedCustomer.setPoint(point);
                        selectedCustomer.setMail(mail);
                        selectedCustomer.setIdk(phone);
                        tbView_Cus.refresh();
                        showAlert(Alert.AlertType.INFORMATION, "Success", "Customer updated successfully.");
                        clearInCustomerPage();
                        showCustomers();
                    } catch (SQLException ex) {
                        try {
                            connection.rollback();
                        } catch (SQLException rollbackEx) {
                            showAlert(Alert.AlertType.ERROR, "Error", "Cannot rollback transaction. \nPlease check your data and try again.");
                            System.out.println("Error rolling back transaction: " + rollbackEx.getMessage());
                        }
                        showAlert(Alert.AlertType.ERROR, "Error", "Cannot update customer. \nPlease check your data and try again.");
                        System.out.println("Error updating customer: " + ex.getMessage());
                    } finally {
                        try {
                            connection.setAutoCommit(true);
                        } catch (SQLException ex) {
                            System.out.println("Error setting auto-commit to true: " + ex.getMessage());
                        }
                    }
                }
            } else {
                // Nếu người dùng không đồng ý cập nhật, thoát ra khỏi phương thức
                return;
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please select a customer to update.");
        }
    }

    @FXML
    private void deleteCustomer(ActionEvent event) {
        Customer selectedCustomer = tbView_Cus.getSelectionModel().getSelectedItem();

        if (selectedCustomer == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a customer to delete.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Delete Customer");
        alert.setContentText("Are you sure you want to delete this customer? \nThis action will also delete associated records in payments.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (connection != null) {
                try {
                    // Xóa các bản ghi trong payments có liên quan đến khách hàng
                    String deletePaymentsQuery = "DELETE FROM payments WHERE idk = ?";
                    try (PreparedStatement deletePaymentsPs = connection.prepareStatement(deletePaymentsQuery)) {
                        deletePaymentsPs.setString(1, selectedCustomer.getIdk());
                        int rowsAffectedInPayments = deletePaymentsPs.executeUpdate();
                        if (rowsAffectedInPayments > 0) {
                            System.out.println("Deleted " + rowsAffectedInPayments + " records in payments for customer \n" + selectedCustomer.getIdk());
                        }
                    }

                    // Sau khi xóa các bản ghi trong payments, tiếp tục xóa khách hàng
                    String deleteCustomerQuery = "DELETE FROM khachhang WHERE idk = ?";
                    try (PreparedStatement deleteCustomerPs = connection.prepareStatement(deleteCustomerQuery)) {
                        deleteCustomerPs.setString(1, selectedCustomer.getIdk());

                        int rowsAffected = deleteCustomerPs.executeUpdate();
                        if (rowsAffected > 0) {
                            // Remove customer from the list
                            customerList.remove(selectedCustomer);
                            tbView_Cus.refresh();
                            showAlert(Alert.AlertType.INFORMATION, "Success", "Customer deleted successfully.");
                            clearInCustomerPage();
                            showCustomers();
                        } else {
                            showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete customer.");
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("Error deleting customer: " + ex.getMessage());
                    showAlert(Alert.AlertType.ERROR, "Error", "Cannot delete customer.\n Please try again later.");
                }
            }
        } else {
            System.out.println("Deletion cancelled by user");
        }
    }

    @FXML
    private void onSelectCustomer(MouseEvent event
    ) {
        if (event.getClickCount() == 1) { // Check if single click
            Customer selectedCustomer = tbView_Cus.getSelectionModel().getSelectedItem();
            if (selectedCustomer != null) {
                tfName_Cus.setText(selectedCustomer.getName());
                tfPhone_Cus.setText(selectedCustomer.getPhone());
                tfPoint_Cus.setText(String.valueOf(selectedCustomer.getPoint()));
                tfEmail_Cus.setText(selectedCustomer.getMail());
            }
        }
    }

    private void onSelectCustomer(Customer newSelection) {
        if (connection != null) {
            String query = "SELECT phone FROM khachhang WHERE phone = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, newSelection.getPhone());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String phone = rs.getString("phone");
                    } else {
                        System.out.println("No customer found with ID: " + newSelection.getIdk());
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error loading customer: " + ex.getMessage());
            }
        }
    }

    // Biến để theo dõi trạng thái xác nhận email
    private boolean isEmailConfirmed_Cus = false;

// Hàm để xác nhận email
    @FXML
    private void btnConfirmE_Cus(MouseEvent event) {
        String email = tfEmail_Cus.getText();

        // Kiểm tra email hợp lệ trước khi gửi mã xác nhận
        if (!isValidEmail_Cus(email)) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Invalid email address.");
            return;
        }

        // Gửi mã xác nhận trong một luồng riêng để không khóa giao diện người dùng
        new Thread(() -> sendVerificationEmail_Cus(email)).start();

        // Hiển thị dialog để người dùng nhập mã xác nhận
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Email Verification");
        dialog.setHeaderText("A verification code \nhas been sent to your email.");
        dialog.setContentText("Please enter the verification code:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(code -> {
            if (isVerificationCodeCorrect_Cus(code)) {
                isEmailConfirmed_Cus = true;
                btnAdd_Cus.setDisable(false);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Email verified successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid verification code.");
            }
        });
    }

// Hàm để gửi email xác nhận
    private void sendVerificationEmail_Cus(String email) {
        verificationCode = generateVerificationCode_Cus();

        String subject = "Your Verification Code";
        String message = "Your verification code is: " + verificationCode;

        // Setup mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("paradisesport2024@gmail.com", "qjsh sesq wbci fsku");
            }
        });

        try {
            // Create a default MimeMessage object
            Message msg = new MimeMessage(session);

            // Set From: header field
            msg.setFrom(new InternetAddress("paradisesport2024@gmail.com"));

            // Set To: header field
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            // Set Subject: header field
            msg.setSubject(subject);

            // Set the actual message
            msg.setText(message);

            // Send message
            Transport.send(msg);
            System.out.println("Sent message successfully...");

        } catch (MessagingException e) {
            Platform.runLater(() -> showAlert(Alert.AlertType.ERROR, "Error", "Failed to send email: " + e.getMessage()));
        }
    }

// Hàm kiểm tra email hợp lệ
    private boolean isValidEmail_Cus(String email) {
        // Simple email validation using regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

// Hàm tạo mã xác nhận
    private String generateVerificationCode_Cus() {
        // Generate a random 6-digit verification code
        return String.valueOf((int) (Math.random() * 900000) + 100000);
    }

// Hàm kiểm tra mã xác nhận
    private boolean isVerificationCodeCorrect_Cus(String code) {
        return verificationCode != null && verificationCode.equals(code);
    }

// Đặt lại trạng thái xác nhận email khi email bị thay đổi
    private void tfEmail_Cus_TextChanged(ActionEvent event) {
        isEmailConfirmed_Cus = false;
        btnAdd_Cus.setDisable(true);
    }

    //--------------------------------------------------Sell SERVICE
    private void setupOpenSellServicePage() {
        SellcomboBox();
        showSaleProducts();
        Salespinner();
    }

    @FXML
    public void SellcomboBox() {
        if (cbType_SaleService != null) {
            cbType_SaleService.setItems(dataList);
        } else {
            System.err.println("ComboBox is null!");
        }
    }

    public void Salespinner() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1);
        Quantity_SaleService.setValueFactory(valueFactory);
    }

    public void showSaleProducts() {
        ObservableList<Service_Sell> pList = getService();

        colImg_SaleService.setCellValueFactory(new PropertyValueFactory<>("img"));
        colName_SaleService.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType_SaleService.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPrice_SaleService.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQoh_SaleService.setCellValueFactory(new PropertyValueFactory<>("qoh"));

        tbView_Ser.setItems(pList);
    }

    public ObservableList<Service_Sell> getService() {
        ObservableList<Service_Sell> list = FXCollections.observableArrayList();
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();

        String query = "SELECT ss.img, ss.name, cs.type, ss.price, ss.qoh, ss.idss "
                + "FROM ser_sell ss INNER JOIN cat_ser cs ON ss.idc = cs.idc";

        try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                String image = rs.getString("img");
                Image img = new Image("file:" + IMAGE_DIR + image); // Corrected image path
                ImageView imgView = new ImageView(img);
                imgView.setFitHeight(80);
                imgView.setFitWidth(100);
                int qoh = rs.getInt("qoh");
                int idss = rs.getInt("idss");
                Service_Sell ss = new Service_Sell(name, type, price, imgView, qoh, idss);
                list.add(ss);
            }

        } catch (SQLException ex) {
            showSaleAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while fetching services.");
        }

        return list;
    }

    @FXML
    private void Import_image_SaleService(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        Stage stage = (Stage) SellServicePage.getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imageview_SaleService.setImage(image);
        }
    }

    private void clearInSellServicePage() {
        tfName_SaleService.clear();
        tfPrice_SaleService.clear();
        cbType_SaleService.getSelectionModel().clearSelection();
        Quantity_SaleService.getValueFactory().setValue(1);
        imageview_SaleService.setImage(null);
    }

    private void showSaleAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void clearSaleService(ActionEvent event) {
        clearInSellServicePage();
    }

    @FXML
    private void updateSaleService(ActionEvent event) {
        String name = tfName_SaleService.getText();
        String price = tfPrice_SaleService.getText();
        String type = cbType_SaleService.getValue();
        Integer quantity = Quantity_SaleService.getValue();

        if (name.isEmpty() || price.isEmpty() || type == null || quantity == null) {
            showSaleAlert(Alert.AlertType.ERROR, "Form Error!", "Please fill all the fields");
            return;
        }

        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        String query = "UPDATE ser_sell SET price = ?, idc = ?, qoh = ?, img = ? WHERE name = ?";

        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setFloat(1, Float.parseFloat(price));

            int idc = getIdcFromSaleType(type);
            ps.setInt(2, idc);

            ps.setInt(3, quantity);

            if (selectedFile != null) {
                Path destination = Paths.get(IMAGE_DIR, selectedFile.getName());
                if (!Files.exists(destination)) {
                    Files.copy(selectedFile.toPath(), destination);
                }
                ps.setString(4, selectedFile.getName());
            } else {
                String currentImage = getCurrentSaleImageFromDB(name);
                ps.setString(4, currentImage);
            }

            ps.setString(5, name);

            ps.executeUpdate();
            showSaleAlert(Alert.AlertType.INFORMATION, "Success", "Service updated successfully!");
            clearInSellServicePage();
            showSaleProducts();
        } catch (SQLException | IOException ex) {
            showSaleAlert(Alert.AlertType.ERROR, "Error", "An error occurred while updating the service.");
        }
    }

    private int getIdcFromSaleType(String type) {
        switch (type) {
            case "Food":
                return 1;
            case "Drinks":
                return 2;
            case "Accessories":
                return 3;
            default:
                return 0;
        }
    }

    private String getCurrentSaleImageFromDB(String name) {
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        String query = "SELECT img FROM ser_sell WHERE name = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("img");
            }
        } catch (SQLException ex) {
            showSaleAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while fetching current image.");
        }
        return null;
    }

    @FXML
    private void deleteSaleService(ActionEvent event) {
        Service_Sell selectedService = tbView_Ser.getSelectionModel().getSelectedItem();
        if (selectedService == null) {
            showSaleAlert(Alert.AlertType.ERROR, "Delete Error", "Please select a service to delete.");
            return;
        }

        int idss = selectedService.getIdss();
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        String query = "DELETE FROM ser_sell WHERE idss = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idss);
            ps.executeUpdate();
            showSaleAlert(Alert.AlertType.INFORMATION, "Success", "Service deleted successfully!");
            showSaleProducts();
        } catch (SQLException ex) {
            showSaleAlert(Alert.AlertType.ERROR, "Error", "An error occurred while deleting the service.");
        }
    }

    @FXML
    public void addSaleService(ActionEvent event) {
        String name = tfName_SaleService.getText();
        String price = tfPrice_SaleService.getText();
        String type = cbType_SaleService.getValue();
        Integer quantity = Quantity_SaleService.getValue();
        String imageFileName = selectedFile != null ? selectedFile.getName() : null;

        if (name.isEmpty() || price.isEmpty() || type == null || quantity == null || imageFileName == null) {
            showSaleAlert(Alert.AlertType.ERROR, "Form Error!", "Please fill all the fields and select an image.");
            return;
        }

        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        String query = "INSERT INTO ser_sell (idc, name, price, img, qoh) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = cn.prepareStatement(query);
            int idc = getIdcFromSaleType(type);
            ps.setInt(1, idc);
            ps.setString(2, name);
            ps.setFloat(3, Float.parseFloat(price));
            ps.setString(4, imageFileName);
            ps.setInt(5, quantity);

            if (selectedFile != null) {
                Path destination = Paths.get(IMAGE_DIR, selectedFile.getName());
                if (!Files.exists(destination)) {
                    Files.copy(selectedFile.toPath(), destination);
                }
            }

            ps.executeUpdate();
            showSaleAlert(Alert.AlertType.INFORMATION, "Success", "Service added successfully!");
            clearInSellServicePage();
            showSaleProducts();
        } catch (SQLException | IOException ex) {
            showSaleAlert(Alert.AlertType.ERROR, "Error", "An error occurred while adding the service.");
        }
    }

    @FXML
    private void onSelectSellProduct(MouseEvent event) {
        Service_Sell selectedService = tbView_Ser.getSelectionModel().getSelectedItem();

        if (selectedService != null) {

            tfName_SaleService.setText(selectedService.getName());
            tfPrice_SaleService.setText(String.valueOf(selectedService.getPrice()));
            cbType_SaleService.setValue(selectedService.getType());
            Quantity_SaleService.getValueFactory().setValue(selectedService.getQoh());

            if (selectedService.getImg() != null && selectedService.getImg().getImage() != null) {
                imageview_SaleService.setImage(selectedService.getImg().getImage());
            } else {
                imageview_SaleService.setImage(null);
            }
        }
    }

    @FXML
    private void searchSellService(ActionEvent event) {
        String searchText = btnSearch_Ser.getText().trim();

        if (searchText.isEmpty()) {

            showSaleProducts();
        } else {
            ObservableList<Service_Sell> filteredList = FXCollections.observableArrayList();
            ConnectDB con = new ConnectDB();
            Connection cn = con.getConnect();

            String query = "SELECT ss.img, ss.name, cs.type, ss.price, ss.qoh, ss.idss "
                    + "FROM ser_sell ss INNER JOIN cat_ser cs ON ss.idc = cs.idc "
                    + "WHERE ss.name LIKE ?";

            try (PreparedStatement ps = cn.prepareStatement(query)) {
                ps.setString(1, "%" + searchText + "%");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("name");
                    String type = rs.getString("type");
                    int price = rs.getInt("price");
                    String image = rs.getString("img");
                    Image img = new Image("file:" + IMAGE_DIR + image);
                    ImageView imgView = new ImageView(img);
                    imgView.setFitHeight(80);
                    imgView.setFitWidth(100);
                    int qoh = rs.getInt("qoh");
                    int idss = rs.getInt("idss");
                    Service_Sell ss = new Service_Sell(name, type, price, imgView, qoh, idss);
                    filteredList.add(ss);
                }

                tbView_Ser.setItems(filteredList);

            } catch (SQLException ex) {
                showSaleAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while searching services.");
            }
        }
    }

    ////--------------------------------------------------Rent SERVICE
    private void setupOpenRentServicePage() {
        RentcomboBox();
        showRentProducts();
        Rentspinner();
    }

    @FXML
    private void RentcomboBox() {
        cbType_RentService.setItems(dataList);
    }

    private void Rentspinner() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1);
        Quantity_RentService.setValueFactory(valueFactory);
    }

    private void clearInRentServicePage() {
        tfName_RentService.clear();
        tfPrice_RentService.clear();
        cbType_RentService.getSelectionModel().clearSelection();
        Quantity_RentService.getValueFactory().setValue(1);
        imageview_RentService.setImage(null);
        selectedFile = null;
    }

    private void showRentAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void Import_image_RentService(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        Stage stage = (Stage) RentServicePage.getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imageview_RentService.setImage(image);
        }
    }

    @FXML
    private void addRentService(ActionEvent event) {
        String name = tfName_RentService.getText();
        String price = tfPrice_RentService.getText();
        String type = cbType_RentService.getValue();
        Integer quantity = Quantity_RentService.getValue();
        String imageFileName = selectedFile != null ? selectedFile.getName() : null;

        ConnectDB con = new ConnectDB();
        try (Connection cn = con.getConnect()) {
            String query = "INSERT INTO ser_rent (idc, name, price, img, qoh) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(query);
            int idc = getIdcFromRentType(type);
            ps.setInt(1, idc);
            ps.setString(2, name);
            ps.setFloat(3, Float.parseFloat(price));
            ps.setString(4, imageFileName);
            ps.setInt(5, quantity);

            Path destination = Paths.get(IMAGE_DIR, imageFileName);
            if (!Files.exists(destination)) {
                Files.copy(selectedFile.toPath(), destination);
            } else {

                showRentAlert(Alert.AlertType.ERROR, "File Error!", "Image file already exists. Please choose another image.");
                return;
            }

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                showRentAlert(Alert.AlertType.INFORMATION, "Success", "Service added successfully!");
                clearInRentServicePage();
                showRentProducts();
            } else {
                showRentAlert(Alert.AlertType.ERROR, "Error", "Failed to add service. No rows affected.");
            }
        } catch (SQLException | IOException ex) {
            showRentAlert(Alert.AlertType.ERROR, "Error", "An error occurred while adding the service: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private int getIdcFromRentType(String type) {
        switch (type) {
            case "Food":
                return 1;
            case "Drinks":
                return 2;
            case "Accessories":
                return 3;
            default:
                return 0;
        }
    }

    @FXML
    private void clearRentService(ActionEvent event) {
        clearInRentServicePage();
    }

    @FXML
    private void updateRentService(ActionEvent event) {
        Service_Rent selectedService = tbView_Ren.getSelectionModel().getSelectedItem();
        if (selectedService == null) {
            showRentAlert(Alert.AlertType.ERROR, "Update Error", "Please select a service to update.");
            return;
        }

        String name = tfName_RentService.getText();
        String price = tfPrice_RentService.getText();
        String type = cbType_RentService.getValue();
        Integer quantity = Quantity_RentService.getValue();
        String imageFileName = selectedFile != null ? selectedFile.getName() : null;

        if (name.isEmpty() || price.isEmpty() || type == null || quantity == null || imageFileName == null) {
            showRentAlert(Alert.AlertType.ERROR, "Form Error!", "Please fill all the fields and select an image.");
            return;
        }

        ConnectDB con = new ConnectDB();
        try (Connection cn = con.getConnect()) {
            String query = "UPDATE ser_rent SET price = ?, idc = ?, qoh = ?, img = ? WHERE idsr = ?";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setFloat(1, Float.parseFloat(price));

            int idc = getIdcFromRentType(type);
            ps.setInt(2, idc);

            ps.setInt(3, quantity);

            if (selectedFile != null) {
                Path destination = Paths.get(IMAGE_DIR, selectedFile.getName());
                Files.copy(selectedFile.toPath(), destination);
                ps.setString(4, selectedFile.getName());
            } else {
                String currentImage = getCurrentRentImageFromDB(name);
                ps.setString(4, currentImage);
            }

            ps.setInt(5, selectedService.getIdsr());

            ps.executeUpdate();
            showRentAlert(Alert.AlertType.INFORMATION, "Success", "Service updated successfully!");
            clearInRentServicePage();
            showRentProducts();
        } catch (SQLException | IOException ex) {
            showRentAlert(Alert.AlertType.ERROR, "Error", "An error occurred while updating the service.");
        }
    }

    private String getCurrentRentImageFromDB(String name) {
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        String query = "SELECT img FROM ser_rent WHERE name = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("img");
            }
        } catch (SQLException ex) {
            showRentAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while fetching current image.");
        }
        return null;
    }

    @FXML
    private void deleteRentService(ActionEvent event) {
        Service_Rent selectedService = tbView_Ren.getSelectionModel().getSelectedItem();
        if (selectedService == null) {
            showRentAlert(Alert.AlertType.ERROR, "Delete Error", "Please select a service to delete.");
            return;
        }

        int idsr = selectedService.getIdsr();
        ConnectDB con = new ConnectDB();
        try (Connection cn = con.getConnect()) {
            String query = "DELETE FROM ser_rent WHERE idsr = ?";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idsr);
            ps.executeUpdate();
            showRentAlert(Alert.AlertType.INFORMATION, "Success", "Service deleted successfully!");
            showRentProducts();
        } catch (SQLException ex) {
            showRentAlert(Alert.AlertType.ERROR, "Error", "An error occurred while deleting the service.");
        }
    }

    @FXML
    private void onSelectRentProduct(MouseEvent event) {
        Service_Rent selectedService = tbView_Ren.getSelectionModel().getSelectedItem();

        if (selectedService != null) {
            tfName_RentService.setText(selectedService.getName());
            tfPrice_RentService.setText(String.valueOf(selectedService.getPrice()));
            cbType_RentService.setValue(selectedService.getType());
            Quantity_RentService.getValueFactory().setValue(selectedService.getQoh());

            if (selectedService.getImg() != null && selectedService.getImg().getImage() != null) {
                imageview_RentService.setImage(selectedService.getImg().getImage());
            } else {
                imageview_RentService.setImage(null);
            }
        }
    }

    @FXML
    private void searchRentService(ActionEvent event) {
        String searchText = btnSearch_Ren.getText().trim();

        if (searchText.isEmpty()) {
            showRentProducts();
        } else {
            ObservableList<Service_Rent> filteredList = FXCollections.observableArrayList();
            ConnectDB con = new ConnectDB();

            try (Connection cn = con.getConnect()) {
                String sql = "SELECT sr.idsr, cs.type, sr.name, sr.price, sr.img, sr.qoh "
                        + "FROM ser_rent sr INNER JOIN cat_ser cs ON sr.idc = cs.idc "
                        + "WHERE sr.name LIKE ?";
                PreparedStatement stmt = cn.prepareStatement(sql);
                stmt.setString(1, "%" + searchText + "%");
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int idsr = rs.getInt("idsr");
                    String type = rs.getString("type");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    String image = rs.getString("img");
                    Image img = new Image("file:" + IMAGE_DIR + image);
                    ImageView imgView = new ImageView(img);
                    imgView.setFitHeight(80);
                    imgView.setFitWidth(100);
                    int qoh = rs.getInt("qoh");

                    Service_Rent sr = new Service_Rent(idsr, type, name, price, imgView, qoh);
                    filteredList.add(sr);
                }

                tbView_Ren.setItems(filteredList);
            } catch (SQLException ex) {
                showRentAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while searching services.");
                ex.printStackTrace();
            }
        }
    }

    private void showRentProducts() {
        ObservableList<Service_Rent> srList = getRentService();

        colImg_RentService.setCellValueFactory(new PropertyValueFactory<>("img"));
        colName_RentService.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType_RentService.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPrice_RentService.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQoh_RentService.setCellValueFactory(new PropertyValueFactory<>("qoh"));

        tbView_Ren.setItems(srList);
    }

    public ObservableList<Service_Rent> getRentService() {
        ObservableList<Service_Rent> list = FXCollections.observableArrayList();
        ConnectDB con = new ConnectDB();
        try (Connection cn = con.getConnect()) {
            String query = "SELECT sr.img, sr.name, cs.type, sr.price, sr.qoh, sr.idsr "
                    + "FROM ser_rent sr INNER JOIN cat_ser cs ON sr.idc = cs.idc";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                String image = rs.getString("img");
                Image img = new Image("file:" + IMAGE_DIR + image); // Corrected image path
                ImageView imgView = new ImageView(img);
                imgView.setFitHeight(80);
                imgView.setFitWidth(100);
                int qoh = rs.getInt("qoh");
                int idsr = rs.getInt("idsr");
                Service_Rent sr = new Service_Rent(idsr, type, name, price, imgView, qoh);
                list.add(sr);
            }

        } catch (SQLException ex) {
            showRentAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while fetching services.");
            ex.printStackTrace();
        }

        return list;
    }
}
