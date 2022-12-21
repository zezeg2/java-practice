package ch16;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("src\\ch16\\using-bf.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
        for (byte i = (byte) 'A'; i <= (byte) 'z'; i++) {
            bos.write(i);
        }
    }
}
