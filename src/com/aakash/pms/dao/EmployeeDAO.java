/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aakash.pms.dao;

import com.aakash.pms.entity.Employee;
import java.util.List;

/**
 *
 * @author aakashm
 */
public interface EmployeeDAO {

    boolean insert(Employee e);

    boolean delete(Employee e);

    List<Employee> getAll();

    Employee getById(int id);

    int lastId();

}
