package companyStructure;

public abstract class Employee {
    private String name;
    private double baseSalary;
    private static int IDcount = 1;
    private int employeeID = 0;
    private Employee manager;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.employeeID = IDcount++;
        this.manager = null;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double salary) {
        this.baseSalary = salary;
    }

    public String getName() {
        return name;
    }

    // return employee id and should be issued on behalf they are constructed. The first should have id 1 and so on
    public int getEmployeeID() {
        return employeeID;
    }

    // return reference to employee object that represent this manager
    // business lead = accountant's manager, technical lead = software engineer's manager
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public boolean equals(Employee other) {
        //Should return true if the two employee IDs are the same, false otherwise
        if (this.employeeID == other.employeeID) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        // return representation of the employee
        return employeeID + " " + name;
    }

    // for implemented on every subclass different
    abstract String employeeStatus();

}
