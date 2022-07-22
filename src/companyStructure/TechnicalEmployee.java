package companyStructure;

public class TechnicalEmployee extends Employee{
    private int codeCheckIns;

    public TechnicalEmployee(String name) {
        //Has a default base salary of 75000
        super(name, 75000);
        this.codeCheckIns = codeCheckIns;
    }

    public String employeeStatus() {
        return this.toString() + " has " + this.codeCheckIns + " successful check ins";
    }
}
