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
public class Bill_serSell extends Service_Sell {

    int idb;
    int qty;
    public Bill_serSell() {
    }

    public Bill_serSell(int idb, int qty) {
        this.idb = idb;
        this.qty = qty;
    }
    
    public Bill_serSell(int idb, String name, String type, int price, int qty) {
        super(name, price, type);
        this.idb = idb;
        this.qty = qty;
    }

    public int getIdb() {
        return idb;
    }

    public int getQty() {
        return qty;
    }

    public void setIdb(int idb) {
        this.idb = idb;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
