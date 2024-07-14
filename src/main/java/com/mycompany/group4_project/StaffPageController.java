/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.group4_project;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Period;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import DAO.*;
import Entities.Booking;
import Entities.Customer;
import Entities.PaymentBill;
import Entities.Service;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.borders.Border;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StaffPageController implements Initializable {

    @FXML
    private ImageView ivEmployee;
    @FXML
    private Label tfEmployeeName;
    @FXML
    private AnchorPane staff_page;
    @FXML
    private BorderPane EditProfilePage;
    @FXML
    private AnchorPane openEditProfile;
    @FXML
    private ImageView View__EditProfile;
    @FXML
    private Button btnImg_EditProfile;
    @FXML
    private TextField tfPhone_EditProfile;
    @FXML
    private TextField tfPosition_EditProfile;
    @FXML
    private TextField tfName_EditProfile;
    @FXML
    private RadioButton rdMale;
    @FXML
    private ToggleGroup gender_EditProfile;
    @FXML
    private RadioButton rdFemale;
    @FXML
    private DatePicker dpBirth_EditProfile;
    @FXML
    private TextField tfMail_EditProfile;
    @FXML
    private Label lbMess_Name;
    @FXML
    private Label lbMess_Birth;
    @FXML
    private Label lbMess_Mail;
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
    private Button btnhideCurPass_EditProfile;
    @FXML
    private Label lbNewPass_EditProfile;
    @FXML
    private PasswordField pfNewPass_EditProfile;
    @FXML
    private TextField tfNewPass_EditProfile;
    @FXML
    private Button btnshowNewPass_EditProfile;
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
    private Button bkPitch_btn_5;
    @FXML
    private Label bkPitch_lbStatus_6;
    @FXML
    private Button bkPitch_btn_6;
    @FXML
    private Label bkPitch_lbStatus_7;
    @FXML
    private Button bkPitch_btn_7;
    @FXML
    private Label bkPitch_lbStatus_8;
    @FXML
    private Button bkPitch_btn_8;
    @FXML
    private Label bkPitch_lbStatus_9;
    @FXML
    private Button bkPitch_btn_9;
    @FXML
    private Label bkPitch_lbStatus_10;
    @FXML
    private Button bkPitch_btn_10;
    @FXML
    private Label bkPitch_lbStatus_11;
    @FXML
    private Button bkPitch_btn_11;
    @FXML
    private Label bkPitch_lbStatus_12;
    @FXML
    private Button bkPitch_btn_12;
    @FXML
    private Label bkPitch_lbName_1;
    @FXML
    private Label bkPitch_lbName_2;
    @FXML
    private Label bkPitch_lbName_3;
    @FXML
    private Label bkPitch_lbName_4;
    @FXML
    private Label bkPitch_lbName_5;
    @FXML
    private Label bkPitch_lbName_6;
    @FXML
    private Label bkPitch_lbName_7;
    @FXML
    private Label bkPitch_lbName_8;
    @FXML
    private Label bkPitch_lbName_9;
    @FXML
    private Label bkPitch_lbName_10;
    @FXML
    private Label bkPitch_lbName_11;
    @FXML
    private Label bkPitch_lbName_12;
    @FXML
    private Label tfEmployeePosition;
    @FXML
    private Label bkPitch_lbNameCus_1;
    @FXML
    private Label bkPitch_lbTimeUsed_1;
    @FXML
    private Label bkPitch_lbNameCus_2;
    @FXML
    private Label bkPitch_lbTimeUsed_2;
    @FXML
    private Label bkPitch_lbNameCus_3;
    @FXML
    private Label bkPitch_lbTimeUsed_3;
    @FXML
    private Label bkPitch_lbNameCus_4;
    @FXML
    private Label bkPitch_lbTimeUsed_4;
    @FXML
    private Label bkPitch_lbNameCus_5;
    @FXML
    private Label bkPitch_lbTimeUsed_5;
    @FXML
    private Label bkPitch_lbNameCus_6;
    @FXML
    private Label bkPitch_lbTimeUsed_6;
    @FXML
    private Label bkPitch_lbNameCus_7;
    @FXML
    private Label bkPitch_lbTimeUsed_7;
    @FXML
    private Label bkPitch_lbNameCus_8;
    @FXML
    private Label bkPitch_lbTimeUsed_8;
    @FXML
    private Label bkPitch_lbNameCus_9;
    @FXML
    private Label bkPitch_lbTimeUsed_9;
    @FXML
    private Label bkPitch_lbNameCus_10;
    @FXML
    private Label bkPitch_lbTimeUsed_10;
    @FXML
    private Label bkPitch_lbNameCus_11;
    @FXML
    private Label bkPitch_lbTimeUsed_11;
    @FXML
    private Label bkPitch_lbNameCus_12;
    @FXML
    private Label bkPitch_lbTimeUsed_12;
    @FXML
    private ComboBox<String> bkPitch_cboTime_from;
    @FXML
    private ComboBox<String> bkPitch_cboTime_to;
    @FXML
    private Label bkPitch_lbTimeStart_1;
    @FXML
    private Label bkPitch_lbTimeStart_2;
    @FXML
    private Label bkPitch_lbTimeStart_3;
    @FXML
    private Label bkPitch_lbTimeStart_4;
    @FXML
    private Label bkPitch_lbTimeStart_5;
    @FXML
    private Label bkPitch_lbTimeStart_6;
    @FXML
    private Label bkPitch_lbTimeStart_7;
    @FXML
    private Label bkPitch_lbTimeStart_8;
    @FXML
    private Label bkPitch_lbTimeStart_9;
    @FXML
    private Label bkPitch_lbTimeStart_10;
    @FXML
    private Label bkPitch_lbTimeStart_11;
    @FXML
    private Label bkPitch_lbTimeStart_12;
    @FXML
    private Label bkPitch_lb_idb_1;
    @FXML
    private Label bkPitch_lb_idb_2;
    @FXML
    private Label bkPitch_lb_idb_3;
    @FXML
    private Label bkPitch_lb_idb_4;
    @FXML
    private Label bkPitch_lb_idb_5;
    @FXML
    private Label bkPitch_lb_idb_6;
    @FXML
    private Label bkPitch_lb_idb_7;
    @FXML
    private Label bkPitch_lb_idb_8;
    @FXML
    private Label bkPitch_lb_idb_9;
    @FXML
    private Label bkPitch_lb_idb_10;
    @FXML
    private Label bkPitch_lb_idb_11;
    @FXML
    private Label bkPitch_lb_idb_12;
    @FXML
    private Button btnClose;
    @FXML
    private Button btnMini;
    @FXML
    private Button btnLogout;
    @FXML
    private AnchorPane bkPitch_1;
    @FXML
    private AnchorPane bkPitch_2;
    @FXML
    private AnchorPane bkPitch_3;
    @FXML
    private AnchorPane bkPitch_4;
    @FXML
    private AnchorPane bkPitch_5;
    @FXML
    private AnchorPane bkPitch_6;
    @FXML
    private AnchorPane bkPitch_7;
    @FXML
    private AnchorPane bkPitch_8;
    @FXML
    private AnchorPane bkPitch_9;
    @FXML
    private AnchorPane bkPitch_10;
    @FXML
    private AnchorPane bkPitch_11;
    @FXML
    private AnchorPane bkPitch_12;
    @FXML
    private Button btnSave_Cus;
    @FXML
    private Button btnCancel_Cus;
    @FXML
    private Button btnAddNew_Bill;
    @FXML
    private Button btnClearFilter_Bill;
    @FXML
    private ScrollPane menu_scrollPane_Ser;
    @FXML
    private HBox Ser_changeQtyService;
    @FXML
    private Button Ser_DeleteService;
    @FXML
    private Label lbService_Bill;
    @FXML
    private Label lbDeposit_Bill;
    @FXML
    private Button btnExportPDF;

    public void ini() {

        initialize_manageBooking();
        initialize_Bill();
        initialize_menuService(998);
    }

    @FXML
    private VBox Ser_changeQtyService_Vbox;
    @FXML
    private TableColumn<?, ?> Ser_col_IDC;
    @FXML
    private Label Ser_lbHide_IDC;
    @FXML
    private Label Ser_lbHide_IDS;
    @FXML
    private Label Ser_lbHide_qty;
    @FXML
    private Label bkPitch_lbStatus_1;
    @FXML
    private Button bkPitch_btn_1;
    @FXML
    private Label bkPitch_lbStatus_2;
    @FXML
    private Button bkPitch_btn_2;
    @FXML
    private Label bkPitch_lbStatus_3;
    @FXML
    private Button bkPitch_btn_3;
    @FXML
    private Label bkPitch_lbStatus_4;
    @FXML
    private Button bkPitch_btn_4;
    @FXML
    private Label bkPitch_lbStatus_5;

    Alert alert;
    ServiceDAO serDAO = new ServiceDAO();
    PitchDAO pDAO = new PitchDAO();
    //UserDAO userDAO = new UserDAO();
    CustomerDAO cusDAO = new CustomerDAO();
    PaymentBillDAO pmDAO = new PaymentBillDAO();
    BookingDAO bkDAO = new BookingDAO();
    Optional<Booking> opBk;
    Optional<PaymentBill> opPm;
    Booking bk = new Booking();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    //*****ObservableList
    ObservableList<PaymentBill> pmObListForFilter = FXCollections.observableArrayList();
    //===========================================================
    //=============Manage Booking================================
    //===========================================================;
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
    private Button btnStart_Booking;
    @FXML
    private TextField txtFullName_Cus;
    @FXML
    private TextField txtPhone_Cus;

    /* List<Button> buttons = Arrays.asList(bkPitch_btn_1, bkPitch_btn_2, bkPitch_btn_3, bkPitch_btn_4, bkPitch_btn_5, bkPitch_btn_6, bkPitch_btn_7, bkPitch_btn_8, bkPitch_btn_9, bkPitch_btn_10, bkPitch_btn_11, bkPitch_btn_12);
     List<Integer> idp = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
     List<Label> lbStatus = Arrays.asList(bkPitch_lbStatus_1, bkPitch_lbStatus_2, bkPitch_lbStatus_3, bkPitch_lbStatus_4, bkPitch_lbStatus_5, bkPitch_lbStatus_6, bkPitch_lbStatus_7, bkPitch_lbStatus_8, bkPitch_lbStatus_9, bkPitch_lbStatus_10, bkPitch_lbStatus_11, bkPitch_lbStatus_12);
     List<Label> lbName = Arrays.asList(bkPitch_lbName_1, bkPitch_lbName_2, bkPitch_lbName_3, bkPitch_lbName_4, bkPitch_lbName_5, bkPitch_lbName_6, bkPitch_lbName_7, bkPitch_lbName_8, bkPitch_lbName_9, bkPitch_lbName_10, bkPitch_lbName_11, bkPitch_lbName_12);
     List<Label> lbTimeStart = Arrays.asList(bkPitch_lbTimeStart_1, bkPitch_lbTimeStart_2, bkPitch_lbTimeStart_3, bkPitch_lbTimeStart_4, bkPitch_lbTimeStart_5, bkPitch_lbTimeStart_6, bkPitch_lbTimeStart_7, bkPitch_lbTimeStart_8, bkPitch_lbTimeStart_9, bkPitch_lbTimeStart_10, bkPitch_lbTimeStart_11, bkPitch_lbTimeStart_12);
     */
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
    private Label lb_pricePitch_Bill;

    //=========================End Bill================
    //===========================================================
    //============= Menu Service page ==================================
    //===========================================================
    private ObservableList<Service> cardListData_Ser = FXCollections.observableArrayList();

    @FXML
    private AnchorPane menuService_page;
    @FXML
    private GridPane menu_gridPane_Ser;
    @FXML
    private TableView<Service> menu_tvSerOfBill_Ser;
    @FXML
    private TableColumn<Service, String> Ser_colName;
    @FXML
    private TableColumn<Service, Integer> Ser_colQty;
    @FXML
    private TableColumn<Service, Integer> Ser_colPrice;
    @FXML
    private TableColumn<Service, Integer> Ser_col_IDS;
    @FXML
    private TableColumn<Service, Integer> Ser_colQOH;
    public Label Ser_lbIDB;
    @FXML
    private Button Ser_btnSave;
    @FXML
    private Label Ser_lbServiceName;
    @FXML
    private Spinner<Integer> Ser_spnQty;
    @FXML
    private Label Ser_lbPaydate;
    @FXML
    private Label Ser_lbIDP;
    @FXML
    private Label Ser_lbTimeStart;
    @FXML
    private Label Ser_lbIDK;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setOpenPage();
        //Edit profile
        informationUser();
        //Booking
        ini();

    }

    private final String IMAGE_DIR = "../src/main/resources/com/mycompany/images/";
    private String selectImageName_EditUser;
    private String selectImageURL_EditUser;
    private String imageURL_EditUser;
    private Path from_EditUser, to_EditUser;
    private File selectedFile_EditUser;
    private CategoryDAO categoryDAO;

    public StaffPageController() {
        this.categoryDAO = new CategoryDAO();
    }

    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void minimize() {
        Stage stage = (Stage) staff_page.getScene().getWindow();
        stage.setIconified(true);
    }

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
                Emp.setIdu(rs.getString("idu"));
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
                tfEmployeePosition.setText(rs.getString("type"));
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
    private void goToManagementPage(MouseEvent event) {
        if (Emp.getIdt() < 2) {
            try {
                App.setRoot("AdminPage");
                showAlert(AlertType.INFORMATION, "Redirect to Management Page", "Redirect to Management Page Successfully!");
            } catch (IOException ex) {
                Logger.getLogger(StaffPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    @FXML
    private void editProfile(ActionEvent event) {
        pBdpManagebooking_page.setVisible(false);
        pAcNewCus_Page.setVisible(false);
        pBdpBillDetail_page.setVisible(false);
        menuService_page.setVisible(false);
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
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
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
        pBdpManagebooking_page.setVisible(true);
        pAcNewCus_Page.setVisible(false);
        pBdpBillDetail_page.setVisible(false);
        menuService_page.setVisible(false);
        EditProfilePage.setVisible(false);
    }

    @FXML
    private void changePass(ActionEvent event) {
        pBdpManagebooking_page.setVisible(false);
        pAcNewCus_Page.setVisible(false);
        pBdpBillDetail_page.setVisible(false);
        menuService_page.setVisible(false);
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
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Paradise Sport");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to Change Password?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                executeSQL(sql);
                //alert
                showAlert(Alert.AlertType.INFORMATION, "Paradise Sport", "Successfully Change Password!");
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
    //================================================================================================================
    //================================================================================================================
    //================================================================================================================

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
    //==============================================**MANAGE BOOKING**================================================
    //================================================================================================================
    //**initialize**
    ObservableList<String> cboHourList;

    public void initialize_manageBooking() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2, 1);
        spnHrs_Booking.setValueFactory(valueFactory);
        setItem_cboIdk_Booking(cboIdk_Booking);
        //Disible Button_Booking
        setBtnNOTvisible(btnBooking_Booking);
        showPitchObservableList_Booking(3);
        OnlyEnterNumber(txtDeposit_Booking);
        showPitchStatus_Booking(null, null);
        cboHourList = setTime_forCboFrom_booking();
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

    public void showPitchStatus_Booking(Time from, Time to) {
        List<Label> PitchStatus = Arrays.asList(bkPitch_lbStatus_1, bkPitch_lbStatus_2, bkPitch_lbStatus_3, bkPitch_lbStatus_4, bkPitch_lbStatus_5, bkPitch_lbStatus_6, bkPitch_lbStatus_7, bkPitch_lbStatus_8, bkPitch_lbStatus_9, bkPitch_lbStatus_10, bkPitch_lbStatus_11, bkPitch_lbStatus_12);
        List<Label> PitchName = Arrays.asList(bkPitch_lbName_1, bkPitch_lbName_2, bkPitch_lbName_3, bkPitch_lbName_4, bkPitch_lbName_5, bkPitch_lbName_6, bkPitch_lbName_7, bkPitch_lbName_8, bkPitch_lbName_9, bkPitch_lbName_10, bkPitch_lbName_11, bkPitch_lbName_12);
        List<Label> NameCus = Arrays.asList(bkPitch_lbNameCus_1, bkPitch_lbNameCus_2, bkPitch_lbNameCus_3, bkPitch_lbNameCus_4, bkPitch_lbNameCus_5, bkPitch_lbNameCus_6, bkPitch_lbNameCus_7, bkPitch_lbNameCus_8, bkPitch_lbNameCus_9, bkPitch_lbNameCus_10, bkPitch_lbNameCus_11, bkPitch_lbNameCus_12);
        List<Label> TimeUsed = Arrays.asList(bkPitch_lbTimeUsed_1, bkPitch_lbTimeUsed_2, bkPitch_lbTimeUsed_3, bkPitch_lbTimeUsed_4, bkPitch_lbTimeUsed_5, bkPitch_lbTimeUsed_6, bkPitch_lbTimeUsed_7, bkPitch_lbTimeUsed_8, bkPitch_lbTimeUsed_9, bkPitch_lbTimeUsed_10, bkPitch_lbTimeUsed_11, bkPitch_lbTimeUsed_12);
        List<Label> TimeStart = Arrays.asList(bkPitch_lbTimeStart_1, bkPitch_lbTimeStart_2, bkPitch_lbTimeStart_3, bkPitch_lbTimeStart_4, bkPitch_lbTimeStart_5, bkPitch_lbTimeStart_6, bkPitch_lbTimeStart_7, bkPitch_lbTimeStart_8, bkPitch_lbTimeStart_9, bkPitch_lbTimeStart_10, bkPitch_lbTimeStart_11, bkPitch_lbTimeStart_12);
        List<Label> lb_Idb_List = Arrays.asList(bkPitch_lb_idb_1, bkPitch_lb_idb_2, bkPitch_lb_idb_3, bkPitch_lb_idb_4, bkPitch_lb_idb_5, bkPitch_lb_idb_6, bkPitch_lb_idb_7, bkPitch_lb_idb_8, bkPitch_lb_idb_9, bkPitch_lb_idb_10, bkPitch_lb_idb_11, bkPitch_lb_idb_12);

        pDAO = new PitchDAO(from, to);
        ObservableList<Pitch> plist = pDAO.getAll();
        ObservableList<Booking> bkList = bkDAO.getAll_infoBookingForPitch(from, to);
        ObservableList<Booking> bkCOMPLETEList = bkDAO.getAll_infoBooking_COMPLETE_ForPitch(from, to);
        //pmDAO = new PaymentBillDAO();
        //pmDAO.getAll();

        for (int i = 0; i < plist.size(); i++) {
            PitchName.get(i).setText(plist.get(i).getName());
            if (plist.get(i).getAvailable() == 1) {
                PitchStatus.get(i).setText("Available");
                PitchStatus.get(i).setStyle("-fx-background-color: #3d7e3d");
                NameCus.get(i).setText(plist.get(i).getSize());
                lb_Idb_List.get(i).setText("");
                TimeUsed.get(i).setText("");
                TimeStart.get(i).setText("$" + plist.get(i).getPrice());

            } else if (plist.get(i).getAvailable() == 2) {
                PitchStatus.get(i).setText("Occupied");
                PitchStatus.get(i).setStyle("-fx-background-color: #ff0000");
                for (int j = 0; j < bkCOMPLETEList.size(); j++) {
                    if (bkCOMPLETEList.get(j).getIdp() == plist.get(i).getIdp()) {
                        NameCus.get(i).setText("Mr. " + bkCOMPLETEList.get(j).getKhachhang_name());
                        lb_Idb_List.get(i).setText(String.valueOf(bkCOMPLETEList.get(j).getIdb()));
                        LocalTime timeStart = bkCOMPLETEList.get(j).getTime_start().toLocalTime();
                        Duration duration = Duration.between(timeStart, LocalTime.now());
                        long hours = duration.toHours();
                        long minutes = duration.toMinutes() % 60;
                        TimeUsed.get(i).setText(hours + ":" + minutes);
                        TimeStart.get(i).setText(timeStart.toString());
                    }
                }
            } else if (plist.get(i).getAvailable() == 3) {
                PitchStatus.get(i).setText("Reserved");
                PitchStatus.get(i).setStyle("-fx-background-color: #cdcd03");
                for (int j = 0; j < bkList.size(); j++) {
                    if (bkList.get(j).getIdp() == plist.get(i).getIdp()) {
                        NameCus.get(i).setText("Mr. " + bkList.get(j).getKhachhang_name());
                        lb_Idb_List.get(i).setText(String.valueOf(bkList.get(j).getIdb()));
                        TimeUsed.get(i).setText("Reserved");
                    }
                }
            }
        }
    }

    public void reset_Booking() {
        txtDeposit_Booking.clear();
        txtTimeStart_Booking.clear();
        //spnHrs_Booking.getValueFactory().setValue(0);
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
        //LocalTime crHrs = LocalTime.now().plusMinutes(15);
        LocalTime crHrs = LocalTime.now();
        int crHours = crHrs.getHour();
        int crMinutes = crHrs.getMinute();

        int spnHour = spnHour_timeBook_Booking.getValue();
        if (spnHour == crHours) {
            SpinnerValueFactory<Integer> valueMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(crMinutes, 55, crMinutes, 5);
            spnMinute_timeBook_Booking.setValueFactory(valueMinute);
            bkPitch_cboTime_from.setValue(spnHour + ":" + crMinutes);
            bkPitch_cboTime_to.setValue((spnHour + 1) + ":" + crMinutes);

        } else {
            SpinnerValueFactory<Integer> valueMinute = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 55, 0, 5);
            spnMinute_timeBook_Booking.setValueFactory(valueMinute);
            bkPitch_cboTime_from.setValue(spnHour + ":" + "00");
            bkPitch_cboTime_to.setValue((spnHour + 1) + ":00");
        }

    }

    @FXML
    void spnHrs_Booking_change() {
        spnHrs_Booking.getValue();
        int hrsBook_tmp = spnHrs_Booking.getValue();
        int spnHour = spnHour_timeBook_Booking.getValue();
        bkPitch_cboTime_to.setValue((spnHour + hrsBook_tmp) + ":00");
    }

    //====FXML ACTION====================================================================================================
    //====FXML ====================================================================================================
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
        if (lbIDP_hide_Booking.getText().equals("")) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select pitch");
            alert.showAndWait();
            return;
        }
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

                bk = new Booking();
                bk.setIdp(idp);
                bk.setIdk(idk);
                bk.setIdu(idu);
                bk.setDep(deposit);
                bk.setTime_book(time_book);
                bk.setHrs(hrs);
                bk.setStt(stt);

                bkDAO.Insert(bk);
                pDAO.UpdateAvailable(Integer.parseInt(lbIDP_hide_Booking.getText()), 3);
                showPitchStatus_Booking(null, null);

                System.out.println("ADDED BOOOKING");

                initialize_manageBooking();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Added Booking");
                alert.setHeaderText(null);
                alert.setContentText("Booking Added Successfully!");
                alert.showAndWait();

                setBtnVisible(btnNew_Booking);
                setBtnNOTvisible(btnAdd_Booking);

                stpTimeBook_Booking.setVisible(true);
            } catch (Exception ex) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select time");
                alert.showAndWait();
                return;

            }
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
            initialize_manageBooking();
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
        showPitchStatus_Booking(null, null);
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
        String checkNull = bkPitch_cboTime_from.getValue();
        int iniSpnHour = crHours;
        if (checkNull != null && !checkNull.isEmpty()) {
            Time cboFrom = Time.valueOf(bkPitch_cboTime_from.getValue() + ":00");
            iniSpnHour = cboFrom.toLocalTime().getHour();
        }
        SpinnerValueFactory<Integer> valueHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(crHours, 23, iniSpnHour);
        spnHour_timeBook_Booking.setValueFactory(valueHour);
        Click_spnHour_timeBook_Booking();
        bkPitch_cboTime_to.setValue((crHours + 1) + ":00");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText("Please select a available pitch from ObservableList!");
        alert.show();

        changeVisibleBtn_Booking(btnNew_Booking.getId());
        lbNameTable_booking.getStyleClass().removeAll("update-btn");
        lbNameTable_booking.getStyleClass().removeAll("complete-btn");
        lbNameTable_booking.getStyleClass().add("add-btn");
        lbIdu_booking.setText(Emp.getIdu());

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
//        btnBillPage.setStyle("-fx-background-color: linear-gradient(to bottom right, #d3133d, #a4262f); -fx-scale-x: 1.1; -fx-scale-y: 1.1;");

        pBdpManagebooking_page.setVisible(false);
        //btnSportPage.setStyle("-fx-background-color: transparent; -fx-scale-x: 1.0; -fx-scale-y: 1.0;");

        initialize_Bill();
        tvBillPayment_Bill.getSelectionModel().selectLast();
        try {
            int idb = Integer.parseInt(lbIdb_booking.getText());
            SelectBill_Bill(idb);
        } catch (Exception e) {
            System.err.println("Error BUTTON - BillDetail:" + e.getMessage());
        }
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
        if (lb_idb_Bill.getText().contains(".")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message");
            alert.setHeaderText("Please select a booking!");
            alert.show();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Are you sure you want to CheckOut?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                int idb = Integer.parseInt(lb_idb_Bill.getText());

                int hrs_used = Integer.parseInt(txtHrsUsed_Bill.getText());
                int tt_payment = Integer.parseInt(lbTotal_Bill.getText());
                int tt_booking = Integer.parseInt(lbTax_Bill.getText());
                int tt_service = Integer.parseInt(lbSubtotal_Bill.getText());

                PaymentBill p = new PaymentBill(idb, hrs_used, tt_payment, tt_booking, tt_service);
                pmDAO.CheckOut_Bill(p);
                LocalTime lt = LocalTime.now();
                txtTimeEnd_Bill.setText(lt.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                lbPaytime_Bill.setText(lt.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Message");
                alert.setHeaderText("Payment Success!");
                alert.show();
                Display_BillPaymentList_Bill();
                btnCheckOut_Bill.setDisable(true);
                btnAddSer_Bill.setDisable(true);
                initialize_manageBooking();

                btnExportPDF.setVisible(true);
            }
        }
    }

    @FXML
    private void AddService_Bill(ActionEvent event) {
        if (lb_idb_Bill.getText().contains(".")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message");
            alert.setHeaderText("Please select a booking!");
            alert.show();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Would you like to add service?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                int idb = Integer.parseInt(lb_idb_Bill.getText());
                initialize_menuService(idb);
                pBdpBillDetail_page.setVisible(false);
                menuService_page.setVisible(true);
            }
        }
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
        } catch (Exception e) {
            time_end = null;
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
        Display_BillPaymentList_Bill();
        txtSearch_Bill.clear();
        dpk_DateFilter_Bill.setValue(null);
        btnExportPDF.setVisible(false);

    }

    @FXML
    private void SelectBill_Bill(MouseEvent event) {
        PaymentBill pSelected = tvBillPayment_Bill.getSelectionModel().getSelectedItem();

        SelectBill_Bill(pSelected.getIdb());
    }

    private void SelectBill_Bill(int idb) {
        try {
            btnCheckOut_Bill.setDisable(true);
            btnAddSer_Bill.setDisable(true);
            btnUpdate_Bill.setDisable(true);
            btnExportPDF.setVisible(false);

            pmDAO = new PaymentBillDAO();
            pmDAO.getAll();
            opPm = pmDAO.GetById(idb);
            if (opPm.isEmpty()) {
                System.out.println("Cannot found bill");
                reset_Booking();
                return;
            }
            PaymentBill pb = opPm.get();

            int subtotalService = 0;
            int subtotalPitchFee = pb.getTt_booking();
            int total = pb.getTt_payment();
            int deposit = pb.getDeposit();
            int price_pitch = pb.getPrice_pitch();
            LocalTime StartTime = pb.getTime_start().toLocalTime();
            String end_time = String.valueOf(pb.getTime_end());
            int hrs_used = pb.getHrs_used();
            if (end_time.equals("null") || end_time.isEmpty()) {
                btnCheckOut_Bill.setDisable(false);
                btnAddSer_Bill.setDisable(false);
                btnUpdate_Bill.setDisable(false);
                end_time = "...";

                LocalTime EndTime = LocalTime.now();
                Duration duration = Duration.between(StartTime, EndTime);

                hrs_used = (int) duration.toHours();
                hrs_used = Math.abs(hrs_used);
                if (hrs_used == 0 || hrs_used > 0 && duration.toMinutes() >= 15) {
                    hrs_used++;
                }
            }

            subtotalService = Display_ServiceList_Bill(pb.getIdb());    //table service
            subtotalPitchFee = price_pitch * hrs_used;
            total = subtotalService + subtotalPitchFee - deposit;

            lb_paydate_Bill.setText(String.valueOf(pb.getPay_date()));
            lb_idb_Bill.setText(String.valueOf(pb.getIdb()));
            lb_idp_Bill.setText(String.valueOf(pb.getIdp()));
            cboCus_Bill.setValue(pb.getIdk());
            lb_pricePitch_Bill.setText("$" + price_pitch);
            lbTotal_Bill.setText(String.valueOf(pb.getTt_payment()));

            txtTimeBook_Bill.setText(String.valueOf(pb.getTime_book()));
            txtDeposit_Bill.setText(String.valueOf(deposit));
            txtTimeStart_Bill.setText(String.valueOf(pb.getTime_start()));
            txtTimeEnd_Bill.setText(end_time);
            txtHrsUsed_Bill.setText("" + hrs_used);
            lbPaytime_Bill.setText(end_time);
            lbStaffID_Bill.setText(pb.getQluser_name() + " - " + pb.getIdu());

            lbSubtotal_Bill.setText(String.valueOf(subtotalService));
            lbTax_Bill.setText(String.valueOf(subtotalPitchFee));
            lbTotal_Bill.setText(String.valueOf(total));
            //Add
            lbService_Bill.setText("" + (subtotalService + subtotalPitchFee));
            lbDeposit_Bill.setText(String.valueOf(deposit));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportBillPDF(String dest) {
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            pdf.setDefaultPageSize(PageSize.A5);

            Document document = new Document(pdf);
            // Name
            Paragraph name = new Paragraph("Paradise Sport")
                    .setFontSize(22)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontColor(new DeviceRgb(255, 0, 0));
            document.add(name);
            document.add(new Paragraph("----------------------").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("").setFontSize(10));

            Table detailsTable = new Table(new float[]{1, 1}).setFontSize(11);
            detailsTable.setWidth(UnitValue.createPercentValue(100));

            detailsTable.addCell(new Cell().add(new Paragraph("Date: " + lb_paydate_Bill.getText()))
                    .setBorder(Border.NO_BORDER));
            detailsTable.addCell(new Cell().add(new Paragraph("Booking Time: " + txtTimeBook_Bill.getText()))
                    .setTextAlignment(TextAlignment.LEFT)
                    .setBorder(Border.NO_BORDER));

            detailsTable.addCell(new Cell().add(new Paragraph("Payment Code: " + lb_idb_Bill.getText()))
                    .setBorder(Border.NO_BORDER));
            detailsTable.addCell(new Cell().add(new Paragraph("Start Time: " + txtTimeStart_Bill.getText()))
                    .setTextAlignment(TextAlignment.LEFT)
                    .setBorder(Border.NO_BORDER));

            detailsTable.addCell(new Cell().add(new Paragraph("Employee Code: " + lb_idp_Bill.getText()))
                    .setBorder(Border.NO_BORDER));
            detailsTable.addCell(new Cell().add(new Paragraph("End Time: " + txtTimeEnd_Bill.getText()))
                    .setTextAlignment(TextAlignment.LEFT)
                    .setBorder(Border.NO_BORDER));

            detailsTable.addCell(new Cell().add(new Paragraph("Customer: " + getNameInCustomer(cboCus_Bill.getValue())))
                    .setBorder(Border.NO_BORDER));
            detailsTable.addCell(new Cell().add(new Paragraph("Hours Used: " + txtHrsUsed_Bill.getText()))
                    .setTextAlignment(TextAlignment.LEFT)
                    .setBorder(Border.NO_BORDER));

            detailsTable.addCell(new Cell().add(new Paragraph("Services Used: "))
                    .setBorder(Border.NO_BORDER));
            detailsTable.addCell(new Cell().add(new Paragraph("Pay Time: " + lbPaytime_Bill.getText()))
                    .setTextAlignment(TextAlignment.LEFT)
                    .setBorder(Border.NO_BORDER));

            document.add(detailsTable);

            Table table = new Table(new float[]{1, 3, 2, 1, 2}).setFontSize(11);
            table.setWidth(UnitValue.createPercentValue(100));
            table.setTextAlignment(TextAlignment.CENTER);

            table.addHeaderCell("Roll No.");
            table.addHeaderCell("Item Description");
            table.addHeaderCell("Price ($)");
            table.addHeaderCell("Quantity");
            table.addHeaderCell("Total ($)");
            addRows(table);
            document.add(table);

            Table totalsTable = new Table(new float[]{4, 2, 1});
            totalsTable.setWidth(UnitValue.createPercentValue(100));

            totalsTable.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            totalsTable.addCell(new Cell().add(new Paragraph("Total Service:")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));
            totalsTable.addCell(new Cell().add(new Paragraph("$" + lbSubtotal_Bill.getText()))
                    .setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));

            totalsTable.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            totalsTable.addCell(new Cell().add(new Paragraph("Pitch Fee:")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));
            totalsTable.addCell(new Cell().add(new Paragraph("$" + lbTax_Bill.getText()))
                    .setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));

            totalsTable.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            totalsTable.addCell(new Cell().add(new Paragraph("Deposit:")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));
            totalsTable.addCell(new Cell().add(new Paragraph("$" + lbDeposit_Bill.getText()))
                    .setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));

            totalsTable.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            totalsTable.addCell(new Cell().add(new Paragraph("Total Bill:"))
                    .setFontColor(new DeviceRgb(255, 0, 0))
                    .setFontSize(14).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));
            totalsTable.addCell(new Cell().add(new Paragraph("$" + lbService_Bill.getText()))
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontColor(new DeviceRgb(255, 0, 0))
                    .setFontSize(14).setBorder(Border.NO_BORDER));

            document.add(totalsTable);
            document.add(new Paragraph("----------------------").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("Thank you and hope to see you again!").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveAndOpenPDF() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        fileChooser.setInitialFileName("DetailBill.pdf");

        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            exportBillPDF(file.getAbsolutePath());
            try {
                // Mở file PDF sau khi tạo xong
                if (file.exists()) {
                    String os = System.getProperty("os.name").toLowerCase();
                    Runtime rt = Runtime.getRuntime();
                    if (os.contains("win")) {
                        rt.exec("rundll32 url.dll,FileProtocolHandler " + file.getAbsolutePath());
                    } else if (os.contains("mac")) {
                        rt.exec("open " + file.getAbsolutePath());
                    } else if (os.contains("nix") || os.contains("nux")) {
                        String[] cmds = {"xdg-open", file.getAbsolutePath()};
                        rt.exec(cmds);
                    } else {
                        System.out.println("Not support!");
                    }
                } else {
                    System.out.println("File not exists!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addRows(Table table) {
        ObservableList<Service> sList = tvService_Bill.getItems();
        int rollNo = 1;
        for (Service s : sList) {
            table.addCell(String.valueOf(rollNo++));
            table.addCell(s.getName());
            table.addCell(String.valueOf(s.getPrice()));
            table.addCell(String.valueOf(s.getQty()));
            table.addCell(String.valueOf(s.getTotal()));
        }
    }

    @FXML
    private void ExportPDF(ActionEvent event) {
        exportBillPDF("DetailBill.pdf");
        saveAndOpenPDF();
    }

    public String getNameInCustomer(String idk) {
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        String nameC = null;
        String query = "SELECT name FROM khachhang WHERE idk = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, idk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nameC = rs.getString("name");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return nameC;
    }

    private int Display_ServiceList_Bill(int idb) {
        pmDAO = new PaymentBillDAO();
        ObservableList<Service> sList = pmDAO.getAllSerVice(idb);
        colNoSer_Bill.setCellValueFactory(new PropertyValueFactory<>("no"));
        colNameSer_Bill.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPriceSer_Bill.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQtySer_Bill.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colTotalSer_Bill.setCellValueFactory(new PropertyValueFactory<>("total"));
        tvService_Bill.setItems(sList);

        int subtotal = 0;
        for (Service s : sList) {
            subtotal += s.getTotal();
        }

        return subtotal;
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

    @FXML
    private void Search_Bill(KeyEvent event) {
        Search_Bill();

    }

    @FXML
    private void Search_Bill() {
        FilteredList<PaymentBill> filteredData = new FilteredList<>(pmDAO.pbObservableList, p -> true);
        String newValue = txtSearch_Bill.getText().toLowerCase();

        /*ObservableList<PaymentBill> subList = filteredData.filtered(p -> p.getIdb() == Integer.parseInt(txtSearch_Bill.getText()););
          tvBillPayment_Bill.setItems(subList);*/ //cách trả về list khaác
        filteredData.setPredicate(p -> {
            if (dpk_DateFilter_Bill.getValue() == null) {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(p.getIdb()).equals(lowerCaseFilter)) {
                    return true;
                }
                if (p.getIdk().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
            } else {
                String dateValue = dpk_DateFilter_Bill.getValue().toString();

                if (newValue == null || newValue.isEmpty() && p.getPay_date().toString().equals(dateValue)) {
                    return true;
                }

                if (String.valueOf(p.getIdb()).equals(newValue) && p.getPay_date().toString().equals(dateValue)) {
                    return true;
                }
                if (p.getIdk().toLowerCase().contains(newValue) && p.getPay_date().toString().equals(dateValue)) {
                    return true;
                }
            }
            return false;
        });

        tvBillPayment_Bill.setItems(filteredData);
    }

    @FXML
    private void SearchByDate_Bill(ActionEvent event) {
        FilteredList<PaymentBill> filteredData = new FilteredList<>(pmDAO.pbObservableList, p -> true);
        String newValue = txtSearch_Bill.getText().toLowerCase();
        LocalDate dateSearch = dpk_DateFilter_Bill.getValue();
        String dateValue;
        if (dateSearch == null) {
            dateValue = "";
        } else {
            dateValue = dateSearch.toString();
        }
        String finalDateValue = dateValue;
        filteredData.setPredicate(p -> {

            if (newValue == null || newValue.isEmpty()) {
                if (dateSearch == null) {
                    return true;
                }
                if (p.getPay_date().toString().equals(finalDateValue)) {
                    return true;
                }
            } else {
                if (dateSearch == null && (String.valueOf(p.getIdb()).equals(newValue) || p.getIdk().toLowerCase().contains(newValue))) {
                    return true;
                }
                if (p.getPay_date().toString().equals(finalDateValue) && (String.valueOf(p.getIdb()).equals(newValue) || p.getIdk().toLowerCase().contains(newValue))) {
                    return true;
                }
            }
            return false;
        });
        tvBillPayment_Bill.setItems(filteredData);
    }

    //==========================================================================**END DETAIL BILL**==============================================
    //============================================================================================================================================
    //==========================================================================**MENU SERVICE**==============================================
    public void initialize_menuService(int IDB) {
        menuDisplayCard_Ser(IDB);
        Display_ServiceBill_Ser(IDB);
    }

    public void menuDisplayCard_Ser(int IDB) {
        serDAO = new ServiceDAO();

        cardListData_Ser.clear();
        cardListData_Ser.addAll(serDAO.getAll_idb(IDB));
        int row = 0;
        int column = 0;
        this.menu_gridPane_Ser.getChildren().clear();
        this.menu_gridPane_Ser.getRowConstraints().clear();
        this.menu_gridPane_Ser.getColumnConstraints().clear();

        for (int q = 0; q < cardListData_Ser.size(); q++) {
            try {
                FXMLLoader load = new FXMLLoader();
//                load.getClass().getResource("cardService.fxml");
                load.setLocation(this.getClass().getResource("cardService.fxml"));

                AnchorPane pane = (AnchorPane) load.load();
                CardServiceController card_Ser = (CardServiceController) load.getController();
                card_Ser.setData(cardListData_Ser.get(q));
                if (column == 3) {
                    column = 0;
                    ++row;
                }
                this.menu_gridPane_Ser.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(10.0));

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public void Display_ServiceBill_Ser(int IDB) {
        pmDAO = new PaymentBillDAO();
        PaymentBill p = pmDAO.getBill_Ser(IDB);

        Ser_lbIDB.setText("" + IDB);
        Ser_lbIDP.setText("" + p.getIdp());
        Ser_lbIDK.setText("" + p.getIdk());
        Ser_lbIDP.setText("" + p.getIdp());
        Ser_lbPaydate.setText("" + p.getPay_date());
        Ser_lbTimeStart.setText("" + p.getTime_start());

        pmDAO = new PaymentBillDAO();
        ObservableList<Service> sList = pmDAO.getAllSerVice(IDB);
        //Ser_colName.setCellValueFactory(new PropertyValueFactory<>("no"));
        Ser_colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        Ser_colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        Ser_colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        Ser_col_IDS.setCellValueFactory(new PropertyValueFactory<>("ids"));
        Ser_col_IDC.setCellValueFactory(new PropertyValueFactory<>("idc"));
        Ser_colQOH.setCellValueFactory(new PropertyValueFactory<>("qoh"));
        menu_tvSerOfBill_Ser.setItems(sList);

    }

    @FXML
    private void Select_Ser(MouseEvent event) {
        Service s = menu_tvSerOfBill_Ser.getSelectionModel().getSelectedItem();

        if (s != null) {
            String name = s.getName();
            int qty = s.getQty();
            int qoh = s.getQoh();
            int ids = s.getIds();
            int idc = s.getIdc();
            Ser_changeQtyService_Vbox.setVisible(true);
            Ser_lbServiceName.setText(name);
            SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, qoh + qty, qty);
            Ser_spnQty.setValueFactory(valueFactory);
            Ser_lbHide_IDC.setText("" + idc);
            Ser_lbHide_IDS.setText("" + ids);
            Ser_btnSave.setDisable(false);
            Ser_lbHide_qty.setText("" + qty);
        }
    }

    @FXML
    private void Ser_SaveChangeService(ActionEvent event) {
        Ser_btnSave.setDisable(true);
        Ser_changeQtyService_Vbox.setVisible(false);
        int qty = Ser_spnQty.getValue();
        int ids = Integer.parseInt(Ser_lbHide_IDS.getText());
        int idc = Integer.parseInt(Ser_lbHide_IDC.getText());
        int idb = Integer.parseInt(Ser_lbIDB.getText());
        pmDAO.updateService(idb, ids, idc, qty);
        Display_ServiceBill_Ser(idb);
    }

    @FXML
    private void Ser_DeleteService(ActionEvent event) {
        Ser_btnSave.setDisable(true);
        Ser_changeQtyService_Vbox.setVisible(false);
        int ids = Integer.parseInt(Ser_lbHide_IDS.getText());
        int idc = Integer.parseInt(Ser_lbHide_IDC.getText());
        int idb = Integer.parseInt(Ser_lbIDB.getText());
        int qty = Integer.parseInt(Ser_lbHide_qty.getText());
        pmDAO.deleteService(idb, ids, idc, qty);
        Display_ServiceBill_Ser(idb);
    }

    @FXML
    private void Ser_NotChange(ActionEvent event) {
        Ser_btnSave.setDisable(true);
        Ser_changeQtyService_Vbox.setVisible(false);
    }

    @FXML
    private void Ser_RefreshServiceOfBill(ActionEvent event) {
        Ser_btnSave.setDisable(true);
        Ser_changeQtyService_Vbox.setVisible(false);

        int idb = Integer.parseInt(Ser_lbIDB.getText());
        Display_ServiceBill_Ser(idb);
    }

    @FXML
    private void bkPitch_btn(ActionEvent event) {
        try {
            List<Button> buttons = Arrays.asList(bkPitch_btn_1, bkPitch_btn_2, bkPitch_btn_3, bkPitch_btn_4, bkPitch_btn_5, bkPitch_btn_6, bkPitch_btn_7, bkPitch_btn_8, bkPitch_btn_9, bkPitch_btn_10, bkPitch_btn_11, bkPitch_btn_12);
            List<Integer> idp = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
            List<Label> lbStatus = Arrays.asList(bkPitch_lbStatus_1, bkPitch_lbStatus_2, bkPitch_lbStatus_3, bkPitch_lbStatus_4, bkPitch_lbStatus_5, bkPitch_lbStatus_6, bkPitch_lbStatus_7, bkPitch_lbStatus_8, bkPitch_lbStatus_9, bkPitch_lbStatus_10, bkPitch_lbStatus_11, bkPitch_lbStatus_12);
            List<Label> lbName = Arrays.asList(bkPitch_lbName_1, bkPitch_lbName_2, bkPitch_lbName_3, bkPitch_lbName_4, bkPitch_lbName_5, bkPitch_lbName_6, bkPitch_lbName_7, bkPitch_lbName_8, bkPitch_lbName_9, bkPitch_lbName_10, bkPitch_lbName_11, bkPitch_lbName_12);
            //List<Label> lbTimeStart = Arrays.asList(bkPitch_lbTimeStart_1, bkPitch_lbTimeStart_2, bkPitch_lbTimeStart_3, bkPitch_lbTimeStart_4, bkPitch_lbTimeStart_5, bkPitch_lbTimeStart_6, bkPitch_lbTimeStart_7, bkPitch_lbTimeStart_8, bkPitch_lbTimeStart_9, bkPitch_lbTimeStart_10, bkPitch_lbTimeStart_11, bkPitch_lbTimeStart_12);
            List<Label> lb_Idb_List = Arrays.asList(bkPitch_lb_idb_1, bkPitch_lb_idb_2, bkPitch_lb_idb_3, bkPitch_lb_idb_4, bkPitch_lb_idb_5, bkPitch_lb_idb_6, bkPitch_lb_idb_7, bkPitch_lb_idb_8, bkPitch_lb_idb_9, bkPitch_lb_idb_10, bkPitch_lb_idb_11, bkPitch_lb_idb_12);

            int index = buttons.indexOf(event.getSource());
            //Time timeStart = null;

            int stt = lbStatus.get(index).getText().equals("Available") ? 1 : lbStatus.get(index).getText().equals("Occupied") ? 2 : 3;
            String name = lbName.get(index).getText();
            reset_Booking();
            lbNamePitch_Booking.setText(name);
            lbIDP_hide_Booking.setText("" + idp.get(index));
            lbIdu_booking.setText(Emp.getIdu());
            btnBillDetail_Booking.setVisible(false);
            btnStart_Booking.setVisible(false);
            //int sttBK = 0;
            if (stt != 1) {
                stpTimeBook_Booking.setVisible(true);
                if (stt == 3) {
                    //sttBK = 1;
                    btnStart_Booking.setVisible(true);
                    btnUpdate_Booking.setDisable(false);
                    btnDelete_Booking.setDisable(false);
                    btnNew_Booking.setVisible(true);
                }
                if (stt == 2) {
                    //sttBK = 2;
                    btnBillDetail_Booking.setVisible(true);
                    btnNew_Booking.setVisible(true);
                    ///here need edit
                    //timeStart = Time.valueOf(lbTimeStart.get(index).getText());
                }

                /*opPm = pmDAO.getBookingOrBillByPitch(idp.get(index), sttBK, timeStart);
                if (opPm.isEmpty()) {
                    System.out.println("Cannot found booking/bill");
                    reset_Booking();
                    return;
                }
                PaymentBill pb = opPm.get();*/
                int idb = Integer.parseInt(lb_Idb_List.get(index).getText());
                PaymentBill pb = pmDAO.getBookingOrBillByPitch(idb);
                System.out.println(pb);
                txtDeposit_Booking.setText("" + pb.getDeposit());
                txtTimeStart_Booking.setText(pb.getTime_book().toString());
                spnHrs_Booking.getValueFactory().setValue(pb.getHrs());
                lbIdb_booking.setText("" + pb.getIdb());
                cboIdk_Booking.setValue(pb.getIdk());
                lbIdu_booking.setText(pb.getIdu());

            } else {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Notification");
                alert.setHeaderText(null);
                alert.setContentText("CREATE BOOKING OR BILL?");
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    stpTimeBook_Booking.setVisible(false);
                    LocalTime crHrs = LocalTime.now().plusMinutes(15);
                    int crHours = crHrs.getHour();
                    String checkNull = bkPitch_cboTime_from.getValue();
                    int iniSpnHour = crHours;
                    if (checkNull != null && !checkNull.isEmpty()) {
                        Time cboFrom = Time.valueOf(bkPitch_cboTime_from.getValue() + ":00");
                        iniSpnHour = cboFrom.toLocalTime().getHour();
                    }
                    SpinnerValueFactory<Integer> valueHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(crHours, 23, iniSpnHour);
                    spnHour_timeBook_Booking.setValueFactory(valueHour);
                    Click_spnHour_timeBook_Booking();

                    //txtTimeStart_Booking.focusTraversableProperty();
                    setBtnDisible_Booking();
                    btnAdd_Booking.setDisable(false);

                    setBtnNOTvisible(btnNew_Booking);
                    setBtnVisible(btnAdd_Booking);
                    setDisableInput_Booking(false);
                } else {
                    reset_Booking();
                }

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            //reset_Booking();
        }
    }

    @FXML
    private void switchPage(ActionEvent event) {

        List<Node> pages = Arrays.asList(pAcNewCus_Page, pBdpBillDetail_page, menuService_page);

        pBdpManagebooking_page.setVisible(true);
        for (int j = 0; j < pages.size(); j++) {
            pages.get(j).setVisible(false);
        }
    }

    //các khung giờ
    //ObservableList<String> HourList = FXCollections.observableArrayList("7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00");
    ObservableList<String> HourList = FXCollections.observableArrayList("1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00");

    ObservableList<String> setTime_forCboFrom_booking() {
        ObservableList<String> cboHourList = FXCollections.observableArrayList();
        LocalTime lt = LocalTime.now();
        int hrNow = lt.getHour();

        cboHourList.add(hrNow + ":00");
        //int i = (hrNow - 6);
        int i = (hrNow);
        int size = HourList.size();
        while (i < size) {
            cboHourList.add(HourList.get(i));
            i++;
        }
        bkPitch_cboTime_from.setItems(cboHourList);
        ObservableList<String> cboHourList2 = FXCollections.observableArrayList();
        for (int j = 1; j < cboHourList.size(); j++) {
            cboHourList2.add(cboHourList.get(j));
        }
        bkPitch_cboTime_to.setItems(cboHourList2);
        return cboHourList;
    }

    void setTime_forCboTo_booking() {

        ObservableList<String> cboHourList2 = FXCollections.observableArrayList();
        String from = bkPitch_cboTime_from.getValue();
        for (int i = 0; i < cboHourList.size(); i++) {
            if (cboHourList.get(i).equals(from)) {
                for (int j = i + 1; j < cboHourList.size(); j++) {
                    cboHourList2.add(cboHourList.get(j));
                }
                break;
            }
        }
        bkPitch_cboTime_to.setItems(cboHourList2);
    }

    @FXML
    void bkPitch_getTimeFilterfromCbo() {
        String fromString = bkPitch_cboTime_from.getValue();
        String timeTo_String = bkPitch_cboTime_to.getValue();
        Time time_From = null, time_To = null;
        if (fromString != null) {
            time_From = Time.valueOf(bkPitch_cboTime_from.getValue() + ":00");
        }
        if (timeTo_String != null) {
            time_To = Time.valueOf(bkPitch_cboTime_to.getValue() + ":00");
        }
        showPitchStatus_Booking(time_From, time_To);
    }

    @FXML
    private void bkPitch_clearTimeToFilter() {
        if (bkPitch_cboTime_from.getValue() != null) {
            bkPitch_cboTime_to.setValue(null);
            bkPitch_getTimeFilterfromCbo();
            setTime_forCboTo_booking();
        }
    }

    @FXML
    private void AddNew_Bill(ActionEvent event) {
    }

}
