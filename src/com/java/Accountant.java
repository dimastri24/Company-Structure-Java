package com.java;

public class Accountant extends BusinessEmployee {
    public TechnicalLead teamSupporting;

    public Accountant(String name) {
        // start without access and 0 check ins
        super(name);
        this.teamSupporting = null;
    }

    // return accountant that supporting
    // if not assigned return null
    public TechnicalLead getTeamSupported() {
        return this.teamSupporting;
    }

    public void supportTeam(TechnicalLead lead) {
        // allow reference from techLead and saved. Once happen accountant got 10% bonus budget for
        // each SE base salary that report to techLead
        this.teamSupporting = lead;
        double totalSalary = 0;
        for (SoftwareEngineer member: lead.directReports) {
            totalSalary = totalSalary + member.getBaseSalary();
        }
        lead.support = this;
        this.bonusBudget = totalSalary + (totalSalary * 0.10);
    }

    public boolean approveBonus(double bonus) {
        // check if there enough room in the budget
        // if not supporting return false
        if (this.teamSupporting == null) {
            return false;
        }
        // if bonus greater than budget return false
        if( bonus > this.bonusBudget) {
            return false;
        }
        return true;
    }

    public String employeeStatus() {
        return super.employeeStatus() + " is supporting" + this.teamSupporting.getName();
    }
}