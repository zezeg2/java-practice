package ch6;

public class Trainee {
    private final String name;
    private final String course;
    static final String institution = "Seoul Sesac Software Academy";
    private int trainFee;
    static int VAT = 5000;
    private double refund;
    public Trainee(String name, String course, int trainFee) {
        this.name = name;
        this.course = course.toLowerCase();
        this.trainFee = trainFee;
    }
    public void calc() {
        this.refund = switch (course) {
            case "java" -> (trainFee * 0.2) + VAT;
            case "jsp" -> (trainFee * 0.15) + 2 * VAT;
            case "spring" -> (trainFee * 0.1) + VAT;
            default -> throw new RuntimeException("Not Enrolled Course");
        };
    }
    public String getName() {
        return name;
    }
    public String getCourse() {
        return course;
    }
    public int getTrainFee() {
        return trainFee;
    }
    public double getRefund() {
        return refund;
    }

    @Override
    public String toString() {
        return """
                Trainee Information
                ----------------------
                Name     : %s
                Course   : %s
                TrainFee : %d￦
                Refund   : %.1f￦
                ----------------------
                """.formatted(name, course, trainFee, refund);
    }
}
