/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jhonattanamagua.employeemanagementsystem.repository.interfaces;

import com.jhonattanamagua.employeemanagementsystem.model.Employee;
import java.util.List;

/**
 *
 * @author PC Master
 */
public interface IEmployeeRepository {
    void addEmployee(Employee employee);
    Employee findById(Long id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(Long id);
}
