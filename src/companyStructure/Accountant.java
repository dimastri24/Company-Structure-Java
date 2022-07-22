package companyStructure;

public class Accountant extends BusinessEmployee{

    private TechnicalLead tech;

    public Accountant(String name) {
        super(name);
        this.tech = null;
    }

    public TechnicalLead getTeamSupported() {
        return this.tech;
    }

    public void supportTeam(TechnicalLead lead) {
        this.tech = lead;
        for (int i=0; i<this.tech.getDirectReports().size(); i++){
            double newBudget = this.getBonusBudget() + this.tech.getDirectReports().get(i).getBaseSalary();
            this.setBonusBudget(newBudget);
        }

        this.setBonusBudget(this.getBonusBudget() + (this.getBonusBudget()*.1));
    }

    public boolean approveBonus(double bonus) {
        if (bonus > this.getBonusBudget()) {
            return false;
        } else if (this.tech == null) {
            return false;
        } else {
            return true;
        }
    }

    public String employeeStatus() {
        if (this.tech == null){
            return this.toString() + " with a budget of " + this.getBonusBudget() + " is not currently supporting a Technical Lead.";
        } else {
            return this.toString() + " with a budget of " + this.getBonusBudget() + " is supporting " + this.tech.getName();
        }
    }
}
