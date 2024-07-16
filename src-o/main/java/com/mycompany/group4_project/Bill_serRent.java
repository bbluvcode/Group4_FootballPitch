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
public class Bill_serRent extends Service_Rent{

    int idb;
    int qty;

    public Bill_serRent(int idb, int qty, int idsr, String name, int price, ImageView img, int qoh, int idc, String type) {
        super(idsr, name, price, img, qoh, idc, type);
        this.idb = idb;
        this.qty = qty;
    }
    
    public int getIdb() {
        return idb;
    }

    public void setIdb(int idb) {
        this.idb = idb;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
