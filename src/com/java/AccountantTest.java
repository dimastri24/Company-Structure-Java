package com.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountantTest {

    @Test // no 3
        // Accountant can approve bonus? req $20000000. expect false
    void approveBonusFalse() {
        Accountant accountant = new Accountant("Test Accountant");
        SoftwareEngineer softwareEngineer= new SoftwareEngineer("Test Software Engineer");
        TechnicalLead technicalLead = new TechnicalLead("Test Technical Lead");

        technicalLead.addReport(softwareEngineer);
        accountant.supportTeam(technicalLead);

        assertFalse(accountant.approveBonus(20000000));
    }

    @Test // no 4
        // Accountant can approve bonus? req $1000. expect true
    void approveBonusTrue() {
        Accountant accountant = new Accountant("Test Accountant");
        SoftwareEngineer softwareEngineer= new SoftwareEngineer("Test Software Engineer");
        TechnicalLead technicalLead = new TechnicalLead("Test Technical Lead");

        technicalLead.addReport(softwareEngineer);
        accountant.supportTeam(technicalLead);

        assertTrue(accountant.approveBonus(1000));
    }
}