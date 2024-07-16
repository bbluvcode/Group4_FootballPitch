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
public class Composite_Service extends ServiceCategory{
    int ids;
    String name;
    int price;
    int qoh;

    public Composite_Service(String name, int price, String type) {
        super(type);
        this.name = name;
        this.price = price;
    }
    
    public int getIds() {
        return ids;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQoh() {
        return qoh;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }
    
    
}
