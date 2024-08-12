/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jhonattanamagua.employeemanagementsystem.repository;

import com.jhonattanamagua.employeemanagementsystem.model.Employee;
import com.jhonattanamagua.employeemanagementsystem.repository.interfaces.IEmployeeRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC Master
 */
public class EmployeeRepository implements IEmployeeRepository{
    private Map<Long, Employee> employeeMap= new HashMap<>();
    
    
    @Override
    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getId(),employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeMap.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public void updateEmployee(Employee employee) {
       employeeMap.put(employee.getId(), employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeMap.remove(id);
    }
    
}
