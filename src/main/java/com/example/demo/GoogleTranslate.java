package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GoogleTranslate {
    private static final String ENG_LANG = "en";
    private static final String VIE_LANG = "vi";

    // API translate
    public static String translate(String text) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbxueKM8M8EMiiQYoYEmTZZR3L-TQ61S65DVeNvUo5DaxWbFUgw5/exec" +
                "?q=" + URLEncoder.encode(text, StandardCharsets.UTF_8) +
                "&target=" + VIE_LANG +
                "&source=" + ENG_LANG;

        // Use the URI constructor to create a URL
        URI uri = URI.create(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}

