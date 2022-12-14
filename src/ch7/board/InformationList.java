package ch7.board;

import java.util.Arrays;

public class InformationList {
    private int length;
    private int count;
    private Information[] informationList;

    public InformationList(int length) {
        this.length = length;
        informationList = new Information[length];
    }
    public void add(Information information) {
        if (count >= length) {
            return;
        }
        informationList[count++] = information;
//        count++;
    }

    public void read(){
        Arrays.stream(informationList).forEach(info -> {
            System.out.println(info.print());
        });
    }


}
