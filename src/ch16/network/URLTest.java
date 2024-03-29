package ch16.network;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        URL url = new URL("https://www.google.com/index.html");
        System.out.println("url.getAuthority()  => " + url.getAuthority());
        System.out.println("url.getDefaultPort()  => " + url.getDefaultPort());
        System.out.println("url.getPort()  => " + url.getPort());
        System.out.println("url.getHost()  => " + url.getHost());
        System.out.println("url.getProtocol()  => " + url.getProtocol());
        System.out.println("url.getQuery()  => " + url.getQuery());
        System.out.println("url.toURI()  => " + url.toURI());
    }
}
