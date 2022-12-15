package ch8.practice1;

public class Runner {
    public static void main(String[] args) {
        CellPhone myPhone = new CellPhone("GALAXY-7");

        try{
            myPhone.charge( 20 ); //20분간 충전을 한다.
            myPhone.printBattery();
            myPhone.call( 300 ); //300분간 통화를 한다.
            myPhone.printBattery();
            myPhone.charge( 50 ); //50분간 충전을 한다.
            myPhone.printBattery();
            myPhone.call( 40 ); //40분간 통화를 한다.
            myPhone.printBattery();
            myPhone.call( -20 ); //통화시간입력오류
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        CellPhone yourPhone = new CellPhone("galaxy-7");if( myPhone.isSame(yourPhone) ) {
            System.out.println("동일 모델입니다.");
        } else {
            System.out.println("다른 모델입니다.");
        }

    }
}
