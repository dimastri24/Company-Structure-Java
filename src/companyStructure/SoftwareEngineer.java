package companyStructure;

public class SoftwareEngineer extends TechnicalEmployee{
    private boolean codeAccess;
    private int codeCheckIns;
    private boolean approved;

    public SoftwareEngineer(String name) {
        // start without access to code and with 0 code check ins
        super(name);
        this.codeAccess = false;
        this.codeCheckIns = 0;
        this.approved = false;
    }

    // return yes or no software engineer has access to make change
    public boolean getCodeAccess() {
        return codeAccess;
    }

    // allow an external piece code to update software engineer code
    public void setCodeAccess(boolean access) {
        this.codeAccess = codeAccess;
    }

    public void isApproved(boolean approved) {
        this.approved = approved;
    }

    public int getSuccessCheckIns() {
        return this.codeCheckIns;
    }

    public boolean checkInCode() {
        // check if manager approve their check in
        // if approve the count increase and go true
        if (this.approved) {
            this.codeCheckIns++;
            return true;
        } else {
            this.codeAccess = false;
            return false;
        }
    }
}
