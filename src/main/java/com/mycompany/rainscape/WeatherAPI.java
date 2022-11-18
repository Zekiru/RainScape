/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/**
 *
 * @author Ezekiel
 */
public class WeatherAPI {
    
    public static String default_area = "Manila"; // Default New Account Area
    public static String current_area = "";
    
    public static String location, temp, status; // Variables for Basic Weather Forecast
    
    public static void autoUpdate() {
        System.out.println("WeatherAPI AutoUpdate Initialized");
        
        while (true) {
            boolean access = RainScape.access;
            
            try {
                Thread.sleep(100); // While loop time buffer, Default 0.1 second
            } catch (InterruptedException ie) {
                System.out.println("Interrupted Exception: " + ie);
            }

            while (access) {
                try {
                    Thread.sleep(600000); // While loop time buffer, Default 10 minutes
                } catch (InterruptedException ie) {
                    System.out.println("Interrupted Exception: " + ie);
                }
                
                WeatherAPI.fetch(currentUserArea());
                WeatherAPI.setValues();

                // System.out.println("WeatherAPI Updated");
            }
        }
    }
    
    public static String currentUserArea() {
        String area;
        
        if (current_area == "") {
            area = defaultUserArea();
        } else {
            area = current_area;
        }
        
        return area;
    }
    
    public static String defaultUserArea() {
        String user = RainScape.username;
        String area = default_area;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
            String sql;

            sql = "select * from rs_preferences where username=?";

            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setString(1, user);

            ResultSet rs = psmt.executeQuery();
            rs.next();

            area = rs.getString("area");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return area;
    }
    
    public static void fetch(String area) {        
        try {
            String api_url = "https://weatherapi-com.p.rapidapi.com/current.json?q=" + area;

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                .url(api_url)
                .get()
                .addHeader("X-RapidAPI-Key", "d2cd26e50fmshb105523acf4dea8p15c5eejsn5766f55f0f75")
                .addHeader("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .build();

            Response response = client.newCall(request).execute();

            JSONObject jsonAPI = new JSONObject(response.body().string());
            JSONObject jsonLocation = new JSONObject(jsonAPI.get("location").toString());
            JSONObject jsonCurrent = new JSONObject(jsonAPI.get("current").toString());
            JSONObject jsonCondition = new JSONObject(jsonCurrent.get("condition").toString());

            // Below are the fetched variables:

            if (jsonLocation.get("name").toString().equals(jsonLocation.get("region").toString()))
                location = jsonLocation.get("region").toString() + ", " + jsonLocation.get("country").toString(); // e.g. Manila, Philippines
            else
                location = jsonLocation.get("name").toString() + ", " + jsonLocation.get("region").toString(); // e.g. Makati, Manila

            temp = jsonCurrent.get("temp_c").toString() + "°"; // e.g. 30°
            status = jsonCondition.get("text").toString(); // e.g. Partly cloudy

            // System.out.println("\n"+location+"\n"+temp+"\n"+status+"\n"); // Print Basic Weather Forecast to Console

            // System.out.println("WeatherAPI Data Fetched");
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
    
    public static void setValues() {
        try {
            MainGUI.location.setText(location);
            MainGUI.temp.setText(temp);
            MainGUI.status.setText(status);

            // System.out.println("WeatherAPI Data Set");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    
}
