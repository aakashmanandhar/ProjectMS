/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aakash.pms;

import com.aakash.pms.controller.EmployeeController;
import com.aakash.pms.dao.EmployeeDAO;
import com.aakash.pms.dao.impl.EmployeeDAOImpl;
import com.aakash.pms.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author aakashm
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        EmployeeController ec=new EmployeeController(input, new EmployeeDAOImpl(new Vector<>()));
        
        while (true) {

            ec.process();
        }
    }

}
