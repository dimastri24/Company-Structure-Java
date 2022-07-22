package companyStructure;

import com.java.Accountant;
import com.java.SoftwareEngineer;
import com.java.TechnicalLead;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountantTest {
    @Test
        // no 3
        // Accountant can approve bonus? req $20000000. expect false
    void approveBonusFalse() {
        com.java.Accountant accountant = new Accountant("Test Accountant");
        com.java.SoftwareEngineer softwareEngineer= new SoftwareEngineer("Test Software Engineer");
        com.java.TechnicalLead technicalLead = new TechnicalLead("Test Technical Lead");

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