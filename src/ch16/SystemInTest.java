package ch16;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest {
    public static void main(String[] args) throws IOException {
        while (true){
//            int data = System.in.read();
//            if (data == 'q') return;
//            System.out.print((char)data);
            InputStreamReader reader = new InputStreamReader(System.in);
            while (true){
                int data = reader.read();
                if (data == 'q') return;
                System.out.print((char) data);
            }
        }
    }
}
