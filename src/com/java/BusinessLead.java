package com.java;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {
    public int headCount;
    public ArrayList<Accountant> directReports;

    public BusinessLead(String name) {
        // base salary twice
        // default head count is 10
        super(name);
        this.baseSalary = this.getBaseSalary() * 2.0;
        this.headCount = 10;
        this.directReports = new ArrayList<>();
    }

    public boolean hasHeadCount() {
        return this.directReports.size() < this.headCount;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        // reference accountant object
        // if head count left, add to their direct report
        // if success return true
        // each report added, got bonus 1.1 times
        if (this.hasHeadCount()) {
            this.directReports.add(e);
            this.bonusBudget = this.getBonusBudget() + (e.getBaseSalary() * 1.1);

            // update accountant's support team
            e.supportTeam(supportTeam);
            e.manager = this;

            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus < this.getBonusBudget()) {    //check if there is budget from here
            e.bonusBudget += bonus;     // employee got bonus
            this.bonusBudget -= bonus;  // business lead employee bonus got reduced
            return true;
        }
        return false;
    }

    public boolean approveBonus(Employee e, double bonus) {
        int techLeadID = e.getManager().getEmployeeID();
        for (Accountant accountant: this.directReports) {
            // find tech lead employee
            if (accountant.getTeamSupported().getEmployeeID() == techLeadID) {
                // check if can bonus
                if (accountant.approveBonus(bonus)) {
                    // yes
                    this.requestBonus(accountant, bonus);
                    return true;
                }
            }
        }
        return false;
    }

    public String getTeamStatus() {
        String managing = "";
        for (Accountant member: this.directReports) {
            managing += " - " + member.employeeStatus() + '\n';
        }
        return this.employeeStatus() + " and is managing: \n" + managing;
    }
}
