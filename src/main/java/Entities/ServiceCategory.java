/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author ADMIN
 */
public class ServiceCategory {

    int idc;
    String type;

    public ServiceCategory() {
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

    public String getName() {
        return type;
    }

    public void setName(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ServiceCategory{" + "idc=" + idc + ", type=" + type + '}';
    }
    
    
}
