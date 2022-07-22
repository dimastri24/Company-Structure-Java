package com.java;

public class BusinessEmployee extends Employee {
    public BusinessEmployee(String name) {
        super(name, 50000);     // default salary
    }

    public double bonusBudget;

    public double getBonusBudget() {
        return this.bonusBudget;
    }

    @Override
    public String employeeStatus() {
        return this.toString() + " with a budget of " + this.getBonusBudget();
    }
}
