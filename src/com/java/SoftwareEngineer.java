package com.java;

public class SoftwareEngineer extends TechnicalEmployee {
    public boolean codeAccess;
    public TechnicalLead manager;

    public SoftwareEngineer(String name) {
        // start without access and 0 check ins
        super(name);
        this.codeAccess = false;
        this.checkIns = 0;
        this.manager = null;
    }

    public void setCodeAccess(boolean access) { //check true or false in technical lead
        this.codeAccess = access;
    }

    public boolean getCodeAccess() {
        return this.codeAccess;
    }

    public int getSuccessfulCheckIns(){
        return this.checkIns;
    }

    public TechnicalLead getManager(){
        return this.manager;
    }

    public boolean checkInCode() {
        // if approve the checkin increase
        if(manager.approveCheckIn(this)) {
            this.checkIns++;
            return true;
        }
        return false;
    }
}
