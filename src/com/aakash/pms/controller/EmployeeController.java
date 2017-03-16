/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aakash.pms.controller;

import com.aakash.pms.dao.EmployeeDAO;
import com.aakash.pms.entity.Employee;
import java.util.Scanner;

/**
 *
 * @author aakashm
 */
public class EmployeeController {

    private Scanner input;
    private EmployeeDAO empDAO;

    public EmployeeController(Scanner input, EmployeeDAO empDAO) {
        this.input = input;
        this.empDAO = empDAO;
    }

    private void menu() {
        System.out.println("1. Add Employee");
        System.out.println("2. Show All Employees");
        System.out.println("3. Search EmployeeBy Id");
        System.out.println("4. Delete EmployeeBy Id");
        System.out.println("5. Search Employee");
        System.out.println("6. Exit");
        System.out.println("Enter Your Choice:");
    }

    private void addView() {
        while (true) {
            Employee emp = new Employee();
            emp.setId(empDAO.lastId());
            System.out.println("Enter First Name:");
            emp.setFirstName(input.next());
            System.out.println("Enter Last Name:");
            emp.setLastName(input.next());
            System.out.println("Enter Status");
            emp.setStatus((input.nextInt() == 1));

            empDAO.insert(emp);
            System.out.println("Do You Want To Add more [Y/N]?");
            if (input.next().equals("n")) {
                break;
            }
        }
    }

    private void showAllView() {
        for (Employee ee : empDAO.getAll()) {
            System.out.println(ee);
        }
    }

    private void searchByIdView() {
        System.out.println("Enter Id To Search:");
        Employee employee = empDAO.getById(input.nextInt());
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Id Didnot Match with the database");
        }
    }

    private void deleteView() {
        System.out.println("Enter Employee Id:");
        Employee employee = empDAO.getById(input.nextInt());
        if (employee != null) {
            empDAO.delete(employee);
        } else {
            System.out.println("Id Didnot Match with the database");
        }
    }

    private void searchView() {

    }

    public void process() {
        menu();

        switch (input.nextInt()) {
            case 1:
                addView();
                break;
            case 2:
                showAllView();
                break;
            case 3:
                searchByIdView();
                break;
            case 4:
                deleteView();
                break;
            case 6:
                System.exit(0);
                break;

        }
    }
}
