package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GoogleTranslate {
    private static final String ENG_LANG = "en";
    private static final String VIE_LANG = "vi";

    // API translate
    public static String translate(String text) throws IOException {

        String urlStr = "https://mymemory.translated.net/en/English/Vietnamese/" +
                "?q=" + URLEncoder.encode(text, StandardCharsets.UTF_8).replace("&", "%26") +
                "&target=" + URLEncoder.encode(VIE_LANG, StandardCharsets.UTF_8).replace("&", "%26") +
                "&source=" + URLEncoder.encode(ENG_LANG, StandardCharsets.UTF_8).replace("&", "%26");

        String responseBody = "";
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            responseBody = response.toString();

        }
        conn.disconnect();
        //System.out.println(responseBody);
        return responseBody;
    }

}