package ch16.io;

import java.io.*;

public class IOTimeDiffTest {
    public static void main(String[] args) throws IOException {
        long start;
        FileReader reader = new FileReader("src/ch16/module1-integrated.pdf");
        FileWriter writer = new FileWriter("src/ch16/result.pdf");

        start = System.currentTimeMillis();
        while (true) {
            int data = reader.read();
            if (data == -1) {
                System.out.println(System.currentTimeMillis() - start);
                reader.close();
                writer.close();
                break;
            }
            writer.write(data);
        }

        FileReader readerWithBuffer = new FileReader("src/ch16/module1-integrated.pdf");
        FileWriter writerWithBuffer = new FileWriter("src/ch16/result-withBuffer.pdf");
        BufferedReader br = new BufferedReader(readerWithBuffer, 5);
        BufferedWriter bw = new BufferedWriter(writerWithBuffer, 5);

        start = System.currentTimeMillis();
        while (true) {
            String data = br.readLine();
            if (data == null) {
                System.out.println(System.currentTimeMillis() - start);
                readerWithBuffer.close();
                writerWithBuffer.close();
                break;
            }
            bw.write(data);
        }

    }
}
