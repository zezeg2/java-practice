package ch7.employee;

public class Secretary extends Employee{
    private int secretaryAllowance;

    public Secretary(int id, String name, int baseSalary, int additionalAllowance, int secretaryAllowance) {
        super(id, name, baseSalary, additionalAllowance);
        this.secretaryAllowance = secretaryAllowance;
    }

    @Override
    public void countTotalSalary() {
        super.countTotalSalary();
        this.totalSalary += secretaryAllowance;
    }
}
