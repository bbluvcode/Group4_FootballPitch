/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Service;
import Entities.Service;
import Entities.Service;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TestDB {

    public static void main(String[] args) {
//        FieldsDAO fListDB = new FieldsDAO();
//        List<Field> fList = fListDB.getAll();
//        Pitch t = fList.get(3);
//        
//        System.out.println(t);
//        int idcp = t.getIdcp();
//        String name = t.getName();
//        int available = t.getAvailable();
//        System.out.println(idcp+ name+ available);
//        fListDB.Insert(t);
//        fListDB.Update(1 , t);
//        for(Pitch f : fList){
//            System.out.println(f);
//        }

        ServiceDAO uListDB = new ServiceDAO();
        List<Service> uList = uListDB.getAll();
        for (Service f : uList) {
            System.out.println(f);
        }

//
//        Service pn = new Service();
//        System.out.println(pn);
    }
}
