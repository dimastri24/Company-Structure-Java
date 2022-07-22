package com.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoftwareEngineerTest {

    @Test // no 1
            // can SE check in code? expect false
    void setCodeAccessCheckInsFalse() {
        SoftwareEngineer engineer = new SoftwareEngineer("Test Engineer");
        engineer.setCodeAccess(false);

        TechnicalLead technicalLead = new TechnicalLead("Test Technical Lead");
        technicalLead.addReport(engineer);

        assertFalse(engineer.checkInCode());
    }

    @Test // no 2
            // can SE check in code? expect true
    void setCodeAccessCheckInsTrue() {
        SoftwareEngineer engineer = new SoftwareEngineer("Test Engineer");
        engineer.setCodeAccess(true);

        TechnicalLead technicalLead = new TechnicalLead("Test Technical Lead");
        technicalLead.addReport(engineer);

        assertTrue(engineer.checkInCode());
    }

    @Test // no 5
        // Software Engineer can get bonus? req $20000000. expect false
    void approveBonusFalse() {
        Accountant accountant = new Accountant("Test Accountant");
        SoftwareEngineer softwareEngineer= new SoftwareEngineer("Test Software Engineer");
        TechnicalLead technicalLead = new TechnicalLead("Test Technical Lead");
        BusinessLead businessLead = new BusinessLead("Test Business Lead");

        technicalLead.addReport(softwareEngineer);
        accountant.supportTeam(technicalLead);
        businessLead.addReport(accountant, technicalLead);

        assertFalse(softwareEngineer.getManager().requestBonus(softwareEngineer,20000000));
    }

    @Test // no 6
        // Software Engineer can get bonus? req $1000. expect true
    void approveBonusTrue() {
        Accountant accountant = new Accountant("Test Accountant");
        SoftwareEngineer softwareEngineer= new SoftwareEngineer("Test Software Engineer");
        TechnicalLead technicalLead = new TechnicalLead("Test Technical Lead");
        BusinessLead businessLead = new BusinessLead("Test Business Lead");

        technicalLead.addReport(softwareEngineer);
        accountant.supportTeam(technicalLead);
        businessLead.addReport(accountant, technicalLead);

        assertTrue(softwareEngineer.getManager().requestBonus(softwareEngineer,1000));
    }
}