package ch7.employee;

public class Employee {
    protected int id;
    protected String name;
    protected int baseSalary;
    protected int additionalAllowance;
    protected int totalSalary;

    public Employee(int id, String name, int baseSalary, int additionalAllowance) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.additionalAllowance = additionalAllowance;
    }

    public void countTotalSalary() {
        totalSalary = baseSalary + additionalAllowance;
    }

    public void printSalary() {
        countTotalSalary();
        System.out.println(
                """
                        사번  |이름  |본봉  |총급여
                        %4d%5s%6d%7d    
                        """.formatted(id, name, baseSalary, totalSalary)
        );
    }
}
