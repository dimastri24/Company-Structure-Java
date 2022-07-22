package com.java;

import com.sun.deploy.security.WSeedGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    static TechnicalLead CTO;
    static BusinessLead CFO;
    static Accountant actA;
    static Accountant actB;
    static SoftwareEngineer seA;
    static SoftwareEngineer seB;
    static SoftwareEngineer seC;
    static SoftwareEngineer seD;
    static SoftwareEngineer seE;
    static SoftwareEngineer seF;
    static SoftwareEngineer seG;

    @BeforeAll
    static void setUp() {
        System.out.println("Running before Test Case");
        CTO = new TechnicalLead("Satya Nadella");
        seA = new SoftwareEngineer("Kasey");
        seB = new SoftwareEngineer("Breana");
        seC = new SoftwareEngineer("Eric");
        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);

        CTO = new TechnicalLead("Bill Gates");
        seD = new SoftwareEngineer("Winter");
        seE = new SoftwareEngineer("Libby");
        seF = new SoftwareEngineer("Gizan");
        seG = new SoftwareEngineer("Zaynah");
        CTO.addReport(seD);
        CTO.addReport(seE);
        CTO.addReport(seF);
        CTO.addReport(seG);

        CFO = new BusinessLead("Amy Hood");
        actA = new Accountant("Nicky");
        actB = new Accountant("Andrew");
        CFO.addReport(actA, CTO);
        CFO.addReport(actB, CTO);
    }

    @Test
    void testSoftwareEngineerCanCheckInCode() {
        seA.setCodeAccess(false);
        assertEquals(false, seA.getCodeAccess());
//        System.out.println("Test Pass");

        seA.setCodeAccess(true);
        assertEquals(true, seA.getCodeAccess());
    }

    @Test  //Test Case 2
    void testAccountantCanApproveBonus() {
        ////Accountant can approve bonus? true or false
        assertFalse(actA.approveBonus(20000000)); //false --> Test pass
        assertTrue(actA.approveBonus(1000));  //Its is limit return true  --> test pass
    }

    @Test  //Test Case 3
    void testCanSoftwareEnginnerGetBonus() {
        assertEquals(false, CFO.approveBonus(seA, 2000000)); // retrun false --> test pass
        assertEquals(true, CFO.approveBonus(seA, 1000));    //retrun true -->test pass
    }

}