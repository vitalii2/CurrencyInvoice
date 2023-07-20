package org.example;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        GUI g = new GUI("Exchange");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(250,200);
        g.setResizable(false);
        g.setLocationRelativeTo(null);
        String currency1 = "EUR";
        String currency2 = "ILS";
        URL url = new URL("https://api.exchangerate.host/convert?from="+ currency1 +"&to=" + currency2);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Chrome");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null){
            response.append(inputLine);
           System.out.println(response);
        }
        Pattern p = Pattern.compile("\\d{1,}\\.\\d{1,}");
        Matcher m = p.matcher(response);
        String rate = "";
        while (m.find()){
            rate = m.group().toString();
        }
        Pattern p1 = Pattern.compile("\\d{1,}-\\d{1,}-\\d{1,}");
        Matcher m1 = p1.matcher(response);
        String date = "";
        while (m1.find()){
            date = m1.group().toString();
        }
        System.out.println(date + " " + rate);
        Currency currency = new Currency(date, rate);

        System.out.println(currency);
        currency.getInvoice();
    }
}