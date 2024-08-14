/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jhonattanamagua.employeemanagementsystem.exception;

/**
 *
 * @author PC Master
 */
public class Errors {
    public static final String EMPLOYEE_ALREADY_EXIST = "Employee already exist.";
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found.";
    public static final String INVALID_EMPLOYEE_NAME = "Invalid employee name.";
    public static final String INVALID_EMPLOYEE_SALARY = "Invalid employee salary.";
    public static final String INVALID_CHOICE="Invalid choice";
    public static final String INVALID_FORMAT="Invalid format";

    public static class EmployeeNotFound extends ArgumentedException {
        public EmployeeNotFound() {
            super(EMPLOYEE_NOT_FOUND);
        }
    }

    public static class InvalidEmployeeName extends ArgumentedException {
        public InvalidEmployeeName() {
            super(INVALID_EMPLOYEE_NAME);
        }
    }

    public static class InvalidEmployeeSalary extends ArgumentedException {
        public InvalidEmployeeSalary() {
            super(INVALID_EMPLOYEE_SALARY);
        }
    }


}
