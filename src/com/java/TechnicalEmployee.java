package com.java;

public class TechnicalEmployee extends Employee {
    public TechnicalEmployee(String name) {
        super(name, 75000);     // default salary
        this.checkIns = 0;
    }

    public int checkIns;

    public int getCheckIns() {
        return this.checkIns;
    }

    @Override
    public String employeeStatus() {
        return this.toString() + " has "+ this.getCheckIns() + "successful check ins";
    }
}
