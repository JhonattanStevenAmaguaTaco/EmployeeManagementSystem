/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jhonattanamagua.employeemanagementsystem.service;

import com.jhonattanamagua.employeemanagementsystem.model.Employee;
import com.jhonattanamagua.employeemanagementsystem.repository.interfaces.IEmployeeRepository;
import com.jhonattanamagua.employeemanagementsystem.service.interfaces.IEmployeeService;
import java.util.List;

/**
 *
 * @author PC Master
 */
public class EmployeeService implements IEmployeeService{

    private IEmployeeRepository employeeRepository;
    public EmployeeService(IEmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    
    @Override
    public void addEmployee(Employee employee) {
        this.employeeRepository.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.getAllEmployees();
    }

    @Override
    public void updateEmployee(Employee employee) {
        this.employeeRepository.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        this.employeeRepository.deleteEmployee(id);
    }
    
}
