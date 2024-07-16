/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 * @author ADMIN
 */
public class Customer {

    String idk;
    String name;
    String phone;
    int point;
    String mail;

    public Customer() {
    }

    public Customer(String idk, String name, String phone, int point, String mail) {
        this.idk = idk;
        this.name = name;
        this.phone = phone;
        this.point = point;
        this.mail = mail;
    }

    public String getIdk() {
        return idk;
    }

    public void setIdk(String idk) {
        this.idk = idk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Customer{" + "idk=" + idk + ", name=" + name + ", phone=" + phone + ", point=" + point + ", mail=" + mail + '}';
    }

}
