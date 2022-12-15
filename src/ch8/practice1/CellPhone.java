package ch8.practice1;

public class CellPhone {
    private String model;
    private double battery = 0d;

    public CellPhone(String model) {
        this.model = model;
    }

    public void call(int time) throws IllegalArgumentException{
        if (time < 0) throw new IllegalArgumentException("통화시간 입력 오류");
        System.out.println(String.format("통화 시간 : %d분", time));
        battery = battery - time * 0.5d > 0 ? battery - time * 0.5d : 0;
    }

    public void charge(int time) throws IllegalArgumentException{
        if (time < 0) throw new IllegalArgumentException("충전시간 입력 오류");
        System.out.println(String.format("충전 시간 : %d분", time));
        battery = battery + time * 3 < 100 ? battery + time * 3d : 100;
    }

    public void printBattery(){
        System.out.println(String.format("배터리 잔량 : %.1f", battery));
    }

    public boolean isSame(CellPhone cellphone) {
        if (this == cellphone) return true;
        return model.equals(cellphone.model);
    }
}
