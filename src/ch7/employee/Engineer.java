package ch7.employee;

public class Engineer extends Employee {
    private int engineeringAllowance;
    private int eligibilityAllowance;

    public Engineer(int id, String name, int baseSalary, int additionalAllowance, int engineeringAllowance, int eligibilityAllowance) {
        super(id, name, baseSalary, additionalAllowance);
        this.engineeringAllowance = engineeringAllowance;
        this.eligibilityAllowance = eligibilityAllowance;
    }

    @Override
    public void countTotalSalary() {
        super.countTotalSalary();
        this.totalSalary += engineeringAllowance + eligibilityAllowance;
    }

    @Override
    public void printSalary() {
        countTotalSalary();
        System.out.println(
                """
                        사번  |이름  |본봉  |기술수당  |자격수당  |총급여
                        %4d%5s%6d%6d%9d%11d
                        """.formatted(id, name, baseSalary, engineeringAllowance, eligibilityAllowance, totalSalary)
        );
    }
}
