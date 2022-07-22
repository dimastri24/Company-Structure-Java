package com.java;

public abstract class Employee {
    public String name;
    public double baseSalary;
    public static int counter;
    public int ID;
    public Employee manager;
    public double bonusBudget;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        counter++;  // id counting
        this.ID = counter;
    }

    public String getName() {
        return this.name;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public int getEmployeeID() {
        return this.ID;
    }

    public Employee getManager() {
        return this.manager;
    }

    public boolean equals(Employee other) {     //check if employee id not same
        return this.getEmployeeID() == other.getEmployeeID();
    }

    public String toString() {
        return this.getEmployeeID() + "" + this.getName();
    }

    public abstract String employeeStatus();    //for override in business and technical employee
}
