/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.group4_project;

/**
 *
 * @author User
 */
public class ServiceCategory {

    int idc;
    String type;

    public ServiceCategory() {
    }

    public ServiceCategory(String type) {
        this.type = type;
    }

    public ServiceCategory(int idc, String type) {
        this.idc = idc;
        this.type = type;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
