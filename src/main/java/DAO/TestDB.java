/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Service;
import Entities.Service;
import Entities.Service;
import javafx.collections.ObservableList;


/**
 *
 * @author ADMIN
 */
public class TestDB {

    public static void main(String[] args) {
//        FieldsDAO fObservableListDB = new FieldsDAO();
//        ObservableList<Field> fObservableList = fObservableListDB.getAll();
//        Pitch t = fObservableList.get(3);
//        
//        System.out.println(t);
//        int idcp = t.getIdcp();
//        String name = t.getName();
//        int available = t.getAvailable();
//        System.out.println(idcp+ name+ available);
//        fObservableListDB.Insert(t);
//        fObservableListDB.Update(1 , t);
//        for(Pitch f : fObservableList){
//            System.out.println(f);
//        }

        ServiceDAO uObservableListDB = new ServiceDAO();
        ObservableList<Service> uObservableList = uObservableListDB.getAll();
        for (Service f : uObservableList) {
            System.out.println(f);
        }

//
//        Service pn = new Service();
//        System.out.println(pn);
    }
}
