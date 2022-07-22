package companyStructure;

public abstract class BusinessEmployee extends Employee {
    private double bonusBudget;

    public BusinessEmployee(String name) {
        super(name, 50000);
        this.bonusBudget = 0;
    }

    public double getBonusBudget() {
        return this.bonusBudget;
    }

    public void setBonusBudget(double budget) {
        this.bonusBudget = budget;
    }

    @Override
    abstract String employeeStatus();
}
