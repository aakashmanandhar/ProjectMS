/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aakash.pms.dao.impl;

import com.aakash.pms.dao.EmployeeDAO;
import com.aakash.pms.entity.Employee;
import java.util.List;

/**
 *
 * @author aakashm
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    List<Employee> empList;

    public EmployeeDAOImpl(List<Employee> empList) {
        this.empList = empList;
    }

    @Override
    public boolean insert(Employee e) {
        return empList.add(e);
    }

    @Override
    public List<Employee> getAll() {
        return empList;
    }

    @Override
    public Employee getById(int id) {
        for (Employee e : empList) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public int lastId() {
        if (empList.size() == 0) {
            return 1;
        }
        return empList.get(empList.size() - 1).getId() + 1;

    }

    @Override
    public boolean delete(Employee e) {
        return empList.remove(e);
    }

}
