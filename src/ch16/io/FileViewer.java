package ch16.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileViewer {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\user\\IdeaProjects\\java-practice\\src\\ch16\\io\\hello.html");
        InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
        BufferedReader bf = new BufferedReader(reader);
        while (true){
            int data = bf.read();
            if (data == -1) {
                break;
            }
            System.out.print((char)data);
        }
    }
}
