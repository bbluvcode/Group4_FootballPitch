/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

import javafx.scene.image.ImageView;

/**
 *
 * @author User
 */
public class Service_Rent extends ServiceCategory {

    int idsr;
    String name;
    int price;
    ImageView img;
    int qoh;

    public Service_Rent(int idsr, String name, int price, ImageView img, int qoh, int idc, String type) {
        super(idc, type);
        this.idsr = idsr;
        this.name = name;
        this.price = price;
        this.img = img;
        this.qoh = qoh;
    }

    public Service_Rent(int idsr, String type, String name, int price, ImageView img, int qoh) {
        this.idsr = idsr;
        this.type = type;
        this.name = name;
        this.price = price;
        this.img = img;
        this.qoh = qoh;
    }

    public int getIdsr() {
        return idsr;
    }

    public void setIdsr(int idsr) {
        this.idsr = idsr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public int getQoh() {
        return qoh;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

//    public int getIdc() {
//        return idc;
//    }
//
//    public void setIdc(int idc) {
//        this.idc = idc;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
}
