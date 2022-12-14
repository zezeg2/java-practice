package ch4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ForAssignRunner {

    static void assign1(int n){
        for (int i = 0; i < n; i++){
            for (int j = n - i; j >= 0; j--){
                System.out.printf(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++){
                System.out.printf("*");
            }
            System.out.printf("\n");
        }
    }
    static void assign2(String[] arr){
        if (arr.length < 5 || arr.length > 10) throw new RuntimeException("Array length have to be from 5 to 10");
        int[] intArr = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i< arr.length - 1; i++){
            for (int j = 0; j< arr.length - 1; j++){
                int f = intArr[j];
                int s = intArr[j+1];
                if (f > s){
                    intArr[j] = s;
                    intArr[j+1] = f;
                }
            }
        }
        System.out.println(Arrays.toString(intArr));
    }
    public static void main(String[] args) {
        assign1(20);
        assign2(new String[] {"23","12","5","54","11","1","3","98"});
        assign2(new String[] {"23","12"});
    }

}
