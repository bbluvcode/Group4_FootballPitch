/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

import java.sql.Date;
import javafx.scene.image.ImageView;

/**
 *
 * @author User
 */
public class User extends UserCategory {

    String idu;
    String name;
    Date birthday;
    boolean gender;
    String phone;
    String pw;
    ImageView img;
    String mail;
    private String position;

    public User() {

    }

    public User(String idu, String name, Date birthday, boolean gender, String phone, String pw, ImageView img, String mail) {
        this.idu = idu;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.pw = pw;
        this.img = img;
        this.mail = mail;
    }

    public User(String idu, String name, Date birthday, boolean gender, String phone, String pw, ImageView img, String mail, String position) {
        this.idu = idu;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.pw = pw;
        this.img = img;
        this.mail = mail;
        this.position = position;
    }

    public User(String idu, ImageView img, String name, String position, boolean gender, Date birthday, String phone, String mail, String pw) {
        this.idu = idu;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.pw = pw;
        this.img = img;
        this.mail = mail;
        this.position = position; // Set position
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User(String idu, String phone) {
        this.idu = idu;
        this.phone = phone;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPw() {
        return pw;
    }

    public User(String phone) {
        this.phone = phone;
    }

    public String getIdu() {
        return idu;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public ImageView getImg() {
        return img;
    }

    public void setIdu(String idu) {
        this.idu = idu;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public String getGenderDescription() {
        return gender ? "Male" : "Female";
    }
}
