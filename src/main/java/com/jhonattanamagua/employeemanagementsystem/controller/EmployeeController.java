/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jhonattanamagua.employeemanagementsystem.controller;

import com.jhonattanamagua.employeemanagementsystem.exception.ArgumentedException;
import com.jhonattanamagua.employeemanagementsystem.exception.Errors;
import com.jhonattanamagua.employeemanagementsystem.model.Employee;
import com.jhonattanamagua.employeemanagementsystem.service.interfaces.IEmployeeService;
import java.time.Clock;
import java.util.Scanner;

/**
 *
 * @author PC Master
 */
public class EmployeeController {
    private IEmployeeService employeeService;
    private Scanner scanner= new Scanner(System.in);
    
    public EmployeeController(IEmployeeService empoEmployeeService){
        this.employeeService= empoEmployeeService;
    }
    
    public void start(){
         while (true){
            int choice = 0;
             printMenu();
            try {
               
                String input = scanner.nextLine();
                if(validateIntInput(input))throw new ArgumentedException(Errors.INVALID_FORMAT.toString());
                choice=Integer.parseInt(input);
                switch (choice) {
                    case 1 -> createEmployee();
                    case 2 -> removeEmployee();
                    case 3 -> listAllEmployees();
                    case 4 -> updateEmployee();
                    case 5 -> searchEmployee();
                    case 6 -> {
                                System.out.println("Exiting...");
                                return;
                              }
                    default -> throw new ArgumentedException(Errors.INVALID_CHOICE.toString());
                }
            } catch (ArgumentedException e) {
                System.out.println(e.getMessage());
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                
            }
        }
    }
     
    public void printMenu(){
        System.out.println("----------------------");
        System.out.println("Employee Management System Menu:");
        System.out.println("|1. Add Employee");
        System.out.println("|2. Remove Employee");
        System.out.println("|3. Print Employee List");
        System.out.println("|4. Update Employee Details");
        System.out.println("|5. Search for Employee");
        System.out.println("|6. Exit");
        System.out.println("-----------------------");
        System.out.println("Enter your choice: ");

    }
    public void createEmployee(){
        String input="";
        Long id;
        Double salary ;
        System.out.println("Enter Employee ID:");
        input= scanner.nextLine();
        if(validateLongInput(input))throw new ArgumentedException(Errors.INVALID_FORMAT.toString());
        id=Long.parseLong(input);
        Employee employee = employeeService.getEmployeeById(id);
        if(employee!=null)throw new ArgumentedException(Errors.EMPLOYEE_ALREADY_EXIST.toString());
        System.out.println("Enter Employee Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Employee Salary:");
        input = scanner.nextLine().toUpperCase();
        if(validateDoubleInput(input))throw new ArgumentedException(Errors.INVALID_FORMAT.toString());
        salary=Double.parseDouble(input);
        employee = new Employee(id, name, salary);
        employeeService.addEmployee(employee);
        System.out.println("Employee created Succesfully");
       
        
    }
    public void removeEmployee(){
        Long id;
        String input="";
        System.out.println("Enter Employee ID to remove:");
        input= scanner.nextLine();
        if(validateLongInput(input))throw new ArgumentedException(Errors.INVALID_FORMAT.toString());
        id=Long.parseLong(input);
        Employee employee = employeeService.getEmployeeById(id);
        if(employee==null)throw new ArgumentedException(Errors.EMPLOYEE_NOT_FOUND.toString());
        employeeService.deleteEmployee(id);
        System.out.println("Employeed Remooved Succesfully");
        
    }
    public void listAllEmployees(){
        for(Employee employee : employeeService.getAllEmployees()){
            System.out.println(employee);
        }
        System.out.println("All employees listed");
        
    }
    public void updateEmployee(){
        String input="";
        Long id;
        Double salary;
        System.out.println("Enter employee ID to update: ");
        input= scanner.nextLine();
        if(validateLongInput(input))throw new ArgumentedException(Errors.INVALID_FORMAT.toString());
        id=Long.parseLong(input);
        
        Employee employee= employeeService.getEmployeeById(id);
        if(employee==null)throw new ArgumentedException(Errors.EMPLOYEE_NOT_FOUND.toString());
       
        System.out.println("Enter new Employee Name: ");
        String name = scanner.nextLine().toUpperCase();
        
        System.out.println("Enter new Salary: ");
        input= scanner.nextLine();
        if(validateDoubleInput(input))throw new ArgumentedException(Errors.INVALID_FORMAT.toString());
        salary = Double.parseDouble(input);
        
        employee.setName(name);
        employee.setSalary(salary);
        employeeService.updateEmployee(employee);
        System.out.println("Employee Updated Succesfully");
        
    }
    public void searchEmployee(){
        Long id;
        String input="";
        System.out.println("Enter Employee ID to search: ");
        input= scanner.nextLine();
        if(validateLongInput(input))throw new ArgumentedException(Errors.INVALID_FORMAT.toString());
        id = Long.parseLong(input);
        Employee employee = employeeService.getEmployeeById(id);
        if(employee==null)throw new ArgumentedException(Errors.EMPLOYEE_NOT_FOUND.toString());
        System.out.println(employee);

    }
    public boolean validateLongInput(String input){
        Long var;
         try {
                var = Long.parseLong(input);
            } catch (NumberFormatException e) {
                return true;   
            }
    return false;
    }
     public boolean validateDoubleInput(String input){
        Double var;
         try {
                var = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                return true;   
            }
    return false;
    }
     public boolean validateIntInput(String input){
        int var;
         try {
                var = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                return true;   
            }
    return false;
    }
     
}
