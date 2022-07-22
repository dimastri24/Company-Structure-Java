package companyStructure;

import java.util.ArrayList;
import java.util.Arrays;

public class TechnicalLead extends TechnicalEmployee{

    private int headCount;
    private BusinessLead bLead;
    private ArrayList<SoftwareEngineer> directReports;

    public TechnicalLead(String name) {
        // tech lead base salary is 1.3 times
        // default head count 4
        super(name);
        this.headCount = 4;
        this.setBaseSalary(this.getBaseSalary() * 1.3);
        this.directReports = new ArrayList<>();
        this.bLead = null;
    }

    public boolean hasHeadCount() {
        // return if number direct report less than the head count
        if (this.directReports.size() < this.headCount) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addReport(SoftwareEngineer e) {
        // accept reference software engineer object, and if techLead has head count left should add this
        // employee to their direct report. if success will return
        if (hasHeadCount()) {
            this.directReports.add(e);
            e.setManager(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean approveCheckIns(SoftwareEngineer e) {
        // see if the report passed to the manager and if their code access is true.
        // if both true then return
        if (this.directReports.contains(e) && e.getCodeAccess()) {
            e.isApproved(true);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<SoftwareEngineer> getDirectReports() {
        return this.directReports;
    }

    public boolean requestBonus(Employee employee, double bonus) {
        // check if bonus amount requested would be approved by businessLead supporting techLead
        // if got bonus return true
        if (this.bLead.requestBonus(employee, bonus)) {
            return true;
        } else {
            return false;
        }
    }

    public String getTeamStatus() {
        if (this.directReports.size() == 0) {
            return this.employeeStatus() + "and no direct reports yet.";
        } else {
            String teamStatus[] = new String[directReports.size()];
            for (int i = 0; i < this.directReports.size(); i++) {
                teamStatus[i] = this.directReports.get(i).employeeStatus() + "\n";
            }
            String finished = "";
            for (int i = 0; i < teamStatus.length; i++) {
                finished += teamStatus[i];
            }

            String x =  this.employeeStatus() + " and is managing: \n" + Arrays.toString(teamStatus);
            x = x.replace("[", "");
            x = x.replace("]","");
            x = x.replace(",","");
            String finalString = x.trim();
            return finalString;
        }
    }

    public BusinessLead getBusinessLead() {
        return this.bLead;
    }

    public void setBusinessLead(BusinessLead bLead) {
        this.bLead = bLead;
    }

}
