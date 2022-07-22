package com.java;

import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee implements Manager {
    public int headCount;
    public ArrayList<SoftwareEngineer> directReports;
    public BusinessLead lead;
    public Accountant support;

    public TechnicalLead(String name) {
        // base salary 1.3 times
        // default head count is 4
        super(name);
        this.baseSalary = this.getBaseSalary() * 1.3;
        this.headCount = 4;
        this.directReports = new ArrayList<>();
        this.lead = null;
    }


    @Override
    public boolean hasHeadCount() {
        return this.directReports.size() < headCount;
    }

    @Override
    public boolean addReport(SoftwareEngineer e) {
        // reference from SE object
        // if head count left, add to their direct report
        // if success return true
        int left = this.directReports.size() - this.headCount;
        if (left != 0) {
            this.directReports.add(e);
            e.manager = this;
            return true;
        }
        return false;
    }

    // check if both the employee and manager true
    public boolean approveCheckIn(SoftwareEngineer e) {
        for(SoftwareEngineer se : this.directReports) {
            if(se.getEmployeeID() == e.getEmployeeID() && e.codeAccess) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean requestBonus(Employee e, double bonus) {
        // check if the support bonus req is approved
        // if yes return true
        this.lead = (BusinessLead) this.support.getManager();
        if(this.lead.approveBonus(e, bonus) ) {
            e.bonusBudget += bonus;
            return true;
        }
        return false;
    }

    public String getTeamStatus() {
        String managing = "";
        for (SoftwareEngineer member: this.directReports) {
            managing += " - " + member.employeeStatus() + '\n';
        }
        return this.employeeStatus() + " and is managing: \n" + managing;
    }
}
