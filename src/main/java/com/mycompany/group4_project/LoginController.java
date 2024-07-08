/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.group4_project;

import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane loginPage;
    @FXML
    private TextField tfPhone;
    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField pfPass;
    @FXML
    private TextField tfPass;
    @FXML
    private Button btnshowPass_Login;
    @FXML
    private Button btnhidePass_Login;
    @FXML
    private TextField tfEmail_Forgot;
    @FXML
    private Label lbEmail;
    @FXML
    private TextField tfCode_Forgot;
    @FXML
    private Label lbCode;
    @FXML
    private Pane loginForm;
    @FXML
    private Pane forgotPassForm;
    @FXML
    private TextField tfNewPass_Forgot;
    @FXML
    private Label lbNewPass_Forgot;
    @FXML
    private Button btnhideNewPass_Forgot;
    @FXML
    private Label lbConfirmPass_Forgot;
    @FXML
    private Button btnhideConfirm_Forgot;
    @FXML
    private PasswordField pfNewPass_Forgot;
    @FXML
    private Button btnshowNewPass_Forgot;
    @FXML
    private PasswordField pfConfirmPass_Forgot;
    @FXML
    private Button btnshowConfirm_Forgot;
    @FXML
    private TextField tfConfirmPass_Forgot;
    @FXML
    private Pane newPassForm;
    @FXML
    private Button btnSend;
    @FXML
    private Button btnVerify;
    @FXML
    private Label lbCountDown;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginForm.setVisible(true);
        forgotPassForm.setVisible(false);
        newPassForm.setVisible(false);
        tfPass.setVisible(false);
        tfPass.setManaged(false);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    private Label tfMess_Phone;
    @FXML
    private Label tfMess_Pass;

    @FXML
    private void login(ActionEvent event) {
        tfMess_Phone.setText("");
        tfMess_Pass.setText("");
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        String phone = tfPhone.getText();
        String pass;
        if (tfPass.isVisible()) {
            pass = tfPass.getText();
        } else {
            pass = pfPass.getText();
        }
        if (phone.isBlank() && pass.isBlank()) {
            tfMess_Phone.setText("Please fill phone number!");
            tfMess_Pass.setText("Please fill password!");
            tfPhone.requestFocus();
            return;
        }
        if (phone.isBlank()) {
            tfMess_Phone.setText("Please fill in the phone number!");
            tfPhone.requestFocus();
            return;
        } else {
            if (!phone.matches("\\d{10}") && !phone.matches("\\w{5,}")) {
                tfMess_Phone.setText("Phone number invalid format!");
                tfPhone.requestFocus();
                return;
            }
        }
        if (pass.isBlank()) {
            tfMess_Pass.setText("Please fill in the password!");
            if (tfPass.isVisible()) {
                tfPass.requestFocus();
            } else {
                pfPass.requestFocus();
            }
            return;
        } else {
            if (pass.length() < 3) {
                tfMess_Pass.setText("Password at least 3 characters!");
                if (tfPass.isVisible()) {
                    tfPass.requestFocus();
                } else {
                    pfPass.requestFocus();
                }
                return;
            }
        }

        String phoneSql = "SELECT * FROM qluser WHERE phone = '" + phone + "'";
        // 
        String passSql = "SELECT * FROM qluser WHERE phone = '" + phone + "' AND pw = '" + pass + "'";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(phoneSql);
            if (rs.next()) {
                rs.close();

                rs = st.executeQuery(passSql);
                if (rs.next()) {
                    String name = rs.getString("name");
                    boolean gender = rs.getBoolean("gender");
                    int role = rs.getInt("idt");
                    if (gender == true) {
                        showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome to Paradise Sport: Mr." + name);
                    } else {
                        showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome to Paradise Sport: Mrs." + name);

                    }
                    User user = new User(phone);
                    App.setLoggedInUser(user);
                    try {
                        if (role > 1) {
                            App.setRoot("StaffPage");
                        } else {
                            App.setRoot("AdminPage");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    tfMess_Pass.setText("Incorrect Password!");
                    if (tfPass.isVisible()) {
                        tfPass.requestFocus();
                    } else {
                        pfPass.requestFocus();
                    }
                }
            } else {
                tfMess_Phone.setText("Phone number does not exist!");
                tfPhone.requestFocus();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error database", "Error connect database: " + ex.getMessage());
        } finally {
            // Đóng tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void minimize(ActionEvent event) {
        Stage stage = (Stage) loginPage.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void showPass(ActionEvent event) {
        showPassword(tfPass, pfPass, btnshowPass_Login, btnhidePass_Login);
    }

    @FXML
    private void hidePass(ActionEvent event) {
        hidePassword(tfPass, pfPass, btnshowPass_Login, btnhidePass_Login);
    }

    private void setUpLogin() {
        loginForm.setVisible(true);
        forgotPassForm.setVisible(false);
        newPassForm.setVisible(false);
        if (tfPhone.getText().isBlank()) {
            tfPhone.requestFocus();
        } else {
            if (tfPass.isVisible()) {
                tfPass.clear();
                tfPass.requestFocus();
            } else {
                pfPass.clear();
                pfPass.requestFocus();
            }
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

    //-------------------------------------------FORGOT PASSWORD------------------------------------------------------------------
    @FXML
    private void backToLogin(ActionEvent event) {
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
        }
        setUpLogin();
    }

    @FXML
    private void forgotPass(ActionEvent event) {
        loginForm.setVisible(false);
        newPassForm.setVisible(false);
        forgotPassForm.setVisible(true);
        tfEmail_Forgot.clear();
        lbEmail.setText("");
        tfEmail_Forgot.requestFocus();
        tfCode_Forgot.clear();
        lbCode.setText("");
        lbCountDown.setText("");
        btnSend.setVisible(true);
        btnVerify.setVisible(false);
    }

    private String verificationCode;
    private String mailUser;
    private long codeExpirationTime;
    private final int CODE_DURATION = 1 * 20 * 1000;

    private boolean validateMail(String mail) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return mail.matches(emailRegex);
    }

    private boolean mailExistsInQLUser(String email) {
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        String query = "SELECT COUNT(*) FROM qluser WHERE mail = ?";

        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private String generateVerificationCode() {
        SecureRandom random = new SecureRandom();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }

    @FXML
    private void sendEmail(ActionEvent event) {

        lbEmail.setText("");
        lbCode.setText("");
        mailUser = tfEmail_Forgot.getText();
        boolean hasErr = false;
        if (mailUser.isBlank()) {
            lbEmail.setText("Please fill Email!");
            tfEmail_Forgot.requestFocus();
            hasErr = true;
        } else {
            if (!validateMail(mailUser)) {
                lbEmail.setText("Invalid Email format!");
                tfEmail_Forgot.requestFocus();
                hasErr = true;
            } else {
                if (!mailExistsInQLUser(mailUser)) {
                    lbEmail.setText("Email does not exist!");
                    tfEmail_Forgot.requestFocus();
                    hasErr = true;
                }
            }
        }
        if (hasErr) {
            return;
        }
        verificationCode = generateVerificationCode();

        String subject = "ParadiseSport ! Forgot Password ";
        String message = "Your verification code is: " + verificationCode + "\nNote: The code is valid for " + (CODE_DURATION / 60000) + " minutes.";
        String emailName = "paradisesport2024@gmail.com";
        String emailPass = "qjsh sesq wbci fsku";
        // Setup mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailName, emailPass);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(emailName));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailUser));
            msg.setSubject(subject);
            msg.setText(message);
            Transport.send(msg);

            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successfully");
                alert.setHeaderText(null);
                alert.setContentText("Verification code sent to email successfully!\nPlease enter the code in the box below!");

                alert.getButtonTypes().setAll(ButtonType.OK);
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        codeExpirationTime = System.currentTimeMillis() + CODE_DURATION;
                        startCountdown();
                        btnSend.setVisible(false);
                        btnVerify.setVisible(true);
                        tfCode_Forgot.clear();
                        tfCode_Forgot.requestFocus();
                    }
                });
            });

        } catch (MessagingException e) {
            Platform.runLater(() -> showAlert(Alert.AlertType.ERROR, "Error", "Failed to send email: " + e.getMessage()));
        }
    }

    private ScheduledExecutorService executor;

    private void startCountdown() {
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
        }
        executor = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> {
            long remainingTime = codeExpirationTime - System.currentTimeMillis();
            if (remainingTime <= 0) {
                verificationCode = null;
                executor.shutdown();
                Platform.runLater(() -> {
                    lbCode.setText("Code expired! Please request new Code!");
                    btnSend.setVisible(true);
                    btnVerify.setVisible(false);
                    lbCountDown.setText("");
                    btnSend.requestFocus();
                });
            } else {
                Platform.runLater(() -> lbCountDown.setText("(" + remainingTime / 1000 + " s)"));
            }
        };
        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }

    private boolean verifyCodeCorrect(String code) {
        return verificationCode != null && verificationCode.equals(code) && System.currentTimeMillis() < codeExpirationTime;
    }

    @FXML
    private void verifyCode(ActionEvent event) {
        lbCode.setText("");
        String codeNumber = tfCode_Forgot.getText();

        boolean hasErr = false;
        if (codeNumber.isEmpty()) {
            lbCode.setText("Please fill Code!");
            hasErr = true;
        } else {
            if (!verifyCodeCorrect(codeNumber)) {
                lbCode.setText("Code incorrect!");
                hasErr = true;
            } else {
                showAlert(Alert.AlertType.INFORMATION, "VerifyCode Successfully", "Verification code successfully!\nRedirect to the Reset password page!");
                //Verify success
                loginForm.setVisible(false);
                newPassForm.setVisible(true);
                forgotPassForm.setVisible(false);
                lbNewPass_Forgot.setText("");
                lbConfirmPass_Forgot.setText("");
                if (tfNewPass_Forgot.isVisible()) {
                    tfNewPass_Forgot.clear();
                    tfNewPass_Forgot.requestFocus();
                } else {
                    pfNewPass_Forgot.clear();
                    pfNewPass_Forgot.requestFocus();
                }
                if (tfConfirmPass_Forgot.isVisible()) {
                    tfConfirmPass_Forgot.clear();
                } else {
                    pfConfirmPass_Forgot.clear();
                }
            }
        }
        if (hasErr) {
            return;
        }
    }

    @FXML
    private void submitNewPass(ActionEvent event) {
        lbNewPass_Forgot.setText("");
        lbConfirmPass_Forgot.setText("");
        String newPass;
        if (tfNewPass_Forgot.isVisible()) {
            newPass = tfNewPass_Forgot.getText();
        } else {
            newPass = pfNewPass_Forgot.getText();
        }
        String confirmPass;
        if (tfConfirmPass_Forgot.isVisible()) {
            confirmPass = tfConfirmPass_Forgot.getText();
        } else {
            confirmPass = pfConfirmPass_Forgot.getText();
        }
        boolean hasErr = false;

        if (newPass.isEmpty()) {
            lbNewPass_Forgot.setText("Please fill New Password!");
            if (tfNewPass_Forgot.isVisible()) {
                tfNewPass_Forgot.requestFocus();
            } else {
                pfNewPass_Forgot.requestFocus();
            }
            hasErr = true;
        } else if (newPass.length() < 3) {
            lbNewPass_Forgot.setText("NewPassword at least 3 characters!");
            if (tfNewPass_Forgot.isVisible()) {
                tfNewPass_Forgot.requestFocus();
            } else {
                pfNewPass_Forgot.requestFocus();
            }
            hasErr = true;
        }
        if (!hasErr) {
            if (confirmPass.isEmpty()) {
                lbConfirmPass_Forgot.setText("Please fill Confirm Password!");
                if (tfConfirmPass_Forgot.isVisible()) {
                    tfConfirmPass_Forgot.requestFocus();
                } else {
                    pfConfirmPass_Forgot.requestFocus();
                }
                hasErr = true;
            } else if (!newPass.equals(confirmPass)) {
                lbConfirmPass_Forgot.setText("Not the same as the New Password!");
                if (tfConfirmPass_Forgot.isVisible()) {
                    tfConfirmPass_Forgot.requestFocus();
                } else {
                    pfConfirmPass_Forgot.requestFocus();
                }
                hasErr = true;
            }
        }
        if (hasErr) {
            return;
        }
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        PreparedStatement ps = null;

        String sql = "UPDATE qluser SET pw = ? WHERE mail = ?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, newPass);
            ps.setString(2, mailUser);
            if (ps.executeUpdate() > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Reset Password", "Reset Password successfully!\nRedirect to the Login page!");
                setUpLogin();
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

    @FXML
    private void showNewPass(ActionEvent event) {
        showPassword(tfNewPass_Forgot, pfNewPass_Forgot, btnshowNewPass_Forgot, btnhideNewPass_Forgot);
    }

    @FXML
    private void showConfirmPass(ActionEvent event) {
        showPassword(tfConfirmPass_Forgot, pfConfirmPass_Forgot, btnshowConfirm_Forgot, btnhideConfirm_Forgot);
    }

    @FXML
    private void hideNewPass(ActionEvent event) {
        hidePassword(tfNewPass_Forgot, pfNewPass_Forgot, btnshowNewPass_Forgot, btnhideNewPass_Forgot);
    }

    @FXML
    private void hideConfirmPass(ActionEvent event) {
        hidePassword(tfConfirmPass_Forgot, pfConfirmPass_Forgot, btnshowConfirm_Forgot, btnhideConfirm_Forgot);
    }

}
