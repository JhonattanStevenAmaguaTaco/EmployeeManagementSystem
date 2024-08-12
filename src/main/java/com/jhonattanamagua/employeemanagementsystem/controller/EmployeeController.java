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
             printMenu();
            int choice = scanner.nextInt();
            try{
                switch (choice){
                    case 1-> createEmployee();
                    case 2-> removeEmployee();
                    case 3->listAllEmployees();
                    case 4->updateEmployee();
                    case 5->searchEmployee();
                    case 6->{
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid Choice");

                }
            }catch(IllegalArgumentException e){
                 System.out.println(e.getMessage());
            }catch(Exception e){
             System.out.println( e.getMessage());
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
        System.out.println("Enter Employee ID:");
        Long id= scanner.nextLong();
        System.out.println("Enter Employee Name:");
        String name = scanner.next();
        System.out.println("Enter Employee Salary:");
        Double salary = scanner.nextDouble();
        
        Employee employee = new Employee(id, name, salary);
        employeeService.addEmployee(employee);
        System.out.println("Employee created Succesfully");
        
    }
    public void removeEmployee(){
        System.out.println("Enter Employee ID to remome:");
        Long id=scanner.nextLong();
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
        System.out.println("Enter employee ID to update: ");
        Long id = scanner.nextLong();
        Employee employee= employeeService.getEmployeeById(id);
        if(employee==null)throw new Errors.EmployeeNotFound();
        //OJO error
        System.out.println("Enter new Employee Name: ");
        String name = scanner.next();
        System.out.println("Enter new Salary: ");
        Double salary = scanner.nextDouble();
        employee.setName(name);
        employee.setSalary(salary);
        employeeService.updateEmployee(employee);
        System.out.println("Employee Updated Succesfully");
    }
    public void searchEmployee(){
        System.out.println("Enter Employee ID to search: ");
        Long id = scanner.nextLong();
        Employee employee = employeeService.getEmployeeById(id);
        if(employee==null)throw new Errors.EmployeeNotFound();
        System.out.println(employee);
    }
}
