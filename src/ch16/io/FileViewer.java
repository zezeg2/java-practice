package ch16.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileViewer {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src\\ch16\\hello.html");
        while (true){
            int data = fis.read();
            if (data == -1) {
                break;
            }
            System.out.print((char)data);
        }
    }
}
