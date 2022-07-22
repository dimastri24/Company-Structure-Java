package companyStructure;

import java.util.ArrayList;
import java.util.Arrays;

public class BusinessLead extends BusinessEmployee{

    private int headCount;
    private Accountant act;
    private ArrayList<Accountant> directReports;

    public BusinessLead(String name) {
        // business lead base salary twice
        // default head count 10
        super(name);
        this.setBaseSalary(this.getBaseSalary()*2);;
        this.headCount = 10;
        this.directReports = new ArrayList<>();
    }

    public boolean hasHeadCount() {
        // return if number direct report less than the head count
        if (this.directReports.size() < this.headCount) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        this.act = e;
        if (this.hasHeadCount()) {
            this.directReports.add(e);
            e.setManager(this);
            double newBudget = this.getBonusBudget() + (1.1 * e.getBaseSalary());
            this.setBonusBudget(newBudget);
            e.supportTeam(supportTeam);
            supportTeam.setBusinessLead(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee employee, double bonus) {
        if (bonus <= this.getBonusBudget()) {
            this.setBonusBudget(this.getBonusBudget() - bonus);
            approveBonus(employee, bonus);
            return true;
        } else {
            return false;
        }
    }

    public boolean approveBonus(Employee employee, double bonus) {
        boolean approved = false;
        for (int i = 0; i < this.directReports.size(); i++) {
            if (this.directReports.get(i).getTeamSupported().getName().equals(employee.getManager())) {
                if (bonus <= this.getBonusBudget()) {
                    approved = true;
                } else {
                    approved = false;
                }
            } else {
                approved = false;
            }
        }
        return approved;
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

            String x = this.employeeStatus() + " and is managing: \n" + Arrays.toString(teamStatus);
            x = x.replace("[", "");
            x = x.replace("]", "");
            x = x.replace(",", "");
            String finalString = x.trim();
            return finalString;
        }
    }

    public String employeeStatus() {
        return this.toString() + " with a budget of " + this.getBonusBudget();
    }
}
