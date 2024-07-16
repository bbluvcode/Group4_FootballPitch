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
public class Service_Sell extends ServiceCategory {

    int idss;
    String name;
    int price;
    ImageView img;
    int qoh;

    public Service_Sell() {
    }

    public Service_Sell(String name, int price, String type) {
        super(type);
        this.name = name;
        this.price = price;
    }

    public Service_Sell(int idss, String name, int price, ImageView img, int qoh, int idc, String type) {
        super(idc, type);
        this.idss = idss;
        this.name = name;
        this.price = price;
        this.img = img;
        this.qoh = qoh;
    }

    public Service_Sell(String name, String type, int price, ImageView img, int qoh, int idss) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.img = img;
        this.qoh = qoh;
        this.idss = idss;
    }

    public void setIdss(int idss) {
        this.idss = idss;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    public int getIdss() {
        return idss;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ImageView getImg() {
        return img;
    }

    public int getQoh() {
        return qoh;
    }

}
