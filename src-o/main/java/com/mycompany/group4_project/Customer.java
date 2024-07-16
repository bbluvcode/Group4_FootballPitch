/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

public class Customer {

    private String idk;
    private String name;
    private String phone;
    private String mail;
    private int point;

    public Customer() {
    }

    public Customer(String idk, String name, String phone, int point, String mail) {
        this.idk = idk;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.point = point;
    }

    public String getIdk() {
        return idk;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setIdk(String idk) {
        this.idk = idk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getPoint() {
        return point;
    }

    public int getIdNum() {
        try {
            return Integer.parseInt(idk.substring(2));
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            return -1; // hoặc giá trị mặc định phù hợp với logic của bạn
        }
    }

}
