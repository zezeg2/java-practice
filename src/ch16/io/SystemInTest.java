package ch16.io;

import java.io.*;
import java.util.Scanner;

public class SystemInTest {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        while (true){
            int data = System.in.read();
            if (data == 'q') return;
            System.out.print((char)data);
//            InputStreamReader reader = new InputStreamReader(System.in);
//            while (true){
//                int data = reader.read();
//                if (data == 'q') return;
//                System.out.print((char) data);
//            }
//            String s = sc.nextLine();
//            System.out.println(s);
        }
    }
}
