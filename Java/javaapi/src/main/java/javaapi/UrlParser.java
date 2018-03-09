package javaapi;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlParser {
    public String readHost(String url){
        URL aURL;
        try {
            aURL= new URL(url);

        }
        catch (MalformedURLException mfue) {
            throw new IllegalArgumentException("Invalid url: " + url);
        }
        return aURL.getHost();
    }

}
