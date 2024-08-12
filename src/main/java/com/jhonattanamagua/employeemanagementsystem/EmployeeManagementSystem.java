/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jhonattanamagua.employeemanagementsystem;

import com.jhonattanamagua.employeemanagementsystem.controller.EmployeeController;
import com.jhonattanamagua.employeemanagementsystem.repository.EmployeeRepository;
import com.jhonattanamagua.employeemanagementsystem.repository.interfaces.IEmployeeRepository;
import com.jhonattanamagua.employeemanagementsystem.service.EmployeeService;
import com.jhonattanamagua.employeemanagementsystem.service.interfaces.IEmployeeService;

/**
 *
 * @author Jhona
 */
public class EmployeeManagementSystem {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        IEmployeeRepository repository= new EmployeeRepository();
        IEmployeeService service = new EmployeeService(repository);
        EmployeeController controller = new EmployeeController(service);
         controller.start();    
    }
}
