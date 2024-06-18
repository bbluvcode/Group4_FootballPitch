/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class User extends UserCategory {

    String idu;
    String pw;
    String name;
    Date birthday;
    boolean gender;
    String phone;
    String img;

    public User() {
    }

    public User(String idu, String pw, String name, Date birthday, boolean gender, String phone, String img, int idt, String type) {
        super(idt, type);
        this.idu = idu;
        this.pw = pw;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.img = img;
    }

    public String getIdu() {
        return idu;
    }

    public void setIdu(String idu) {
        this.idu = idu;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIdt() {
        return idt;
    }

    public void setIdt(int idt) {
        this.idt = idt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{idt=" + idt + ", type=" + type + ", idu=" + idu + ", pw=" + pw + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", phone=" + phone + ", img=" + img + '}';
    }

    public String getGenderDescription() {
        return gender ? "Male" : "Female";
    }

}
