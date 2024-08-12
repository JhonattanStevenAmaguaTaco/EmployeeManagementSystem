/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jhonattanamagua.employeemanagementsystem.model;

/**
 *
 * @author Jhona
 */
public class Employee {
    private Long id;
    private String name;
    private double Salary;

    public Employee(Long id, String name, double Salary) {
        this.id = id;
        this.name = name;
        this.Salary = Salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", Salary=" + Salary + '}';
    }
    
}
