package ch7.employee;

public class Manager extends Employee{
    private int executiveAllowance;

    public Manager(int id, String name, int baseSalary, int additionalAllowance, int executiveAllowance) {
        super(id, name, baseSalary, additionalAllowance);
        this.executiveAllowance = executiveAllowance;
    }

    @Override
    public void countTotalSalary() {
        super.countTotalSalary();
        this.totalSalary += executiveAllowance;
    }
}
