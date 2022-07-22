package companyStructure;

import com.java.Accountant;
import com.java.BusinessLead;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoftwareEngineerTest {

    @Test
        // no 1
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
        com.java.SoftwareEngineer engineer = new com.java.SoftwareEngineer("Test Engineer");
        engineer.setCodeAccess(true);

        com.java.TechnicalLead technicalLead = new com.java.TechnicalLead("Test Technical Lead");
        technicalLead.addReport(engineer);

        assertTrue(engineer.checkInCode());
    }

    @Test // no 5
        // Software Engineer can get bonus? req $20000000. expect false
    void approveBonusFalse() {
        com.java.Accountant accountant = new Accountant("Test Accountant");
        com.java.SoftwareEngineer softwareEngineer= new com.java.SoftwareEngineer("Test Software Engineer");
        com.java.TechnicalLead technicalLead = new com.java.TechnicalLead("Test Technical Lead");
        com.java.BusinessLead businessLead = new BusinessLead("Test Business Lead");

        technicalLead.addReport(softwareEngineer);
        accountant.supportTeam(technicalLead);
        businessLead.addReport(accountant, technicalLead);

        assertFalse(softwareEngineer.getManager().requestBonus(softwareEngineer,20000000));
    }

    @Test // no 6
        // Software Engineer can get bonus? req $1000. expect true
    void approveBonusTrue() {
        Accountant accountant = new Accountant("Test Accountant");
        com.java.SoftwareEngineer softwareEngineer= new com.java.SoftwareEngineer("Test Software Engineer");
        com.java.TechnicalLead technicalLead = new com.java.TechnicalLead("Test Technical Lead");
        BusinessLead businessLead = new BusinessLead("Test Business Lead");

        technicalLead.addReport(softwareEngineer);
        accountant.supportTeam(technicalLead);
        businessLead.addReport(accountant, technicalLead);

        assertTrue(softwareEngineer.getManager().requestBonus(softwareEngineer,1000));
    }

}