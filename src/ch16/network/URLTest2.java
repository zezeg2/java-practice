package ch16.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLTest2 {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        try {
            URL url = new URL("https://www.google.com/index.html");
            InputStream inputStream = url.openStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(reader);
            while (true){
                String line = br.readLine();
                if (line == null) break;
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
