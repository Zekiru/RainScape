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
    
    public static String location, temp, status; // Variables for Basic Weather Forecast
    
    public static void autoFetch() { // Run along with project
        System.out.println("Auto Fetch Running");
        
        while (true) {
            boolean access = RainScape.access;
            
            if (access) {
                WeatherAPI.fetch(RainScape.username);
                
                try {
                    Thread.sleep(60000); // Fetch intervals (Default 60 seconds)
                } catch (InterruptedException ie) {
                    System.out.println("Interrupted Exception: " + ie);
                }
            } else {
                try {
                    Thread.sleep(500); // While loop time buffer
                } catch (InterruptedException ie) {
                    System.out.println("Interrupted Exception: " + ie);
                }
            }
        }
    }
    
    public static void fetch(String username) {
        System.out.println("WeatherAPI Fetch Initializing.");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db","root","");
            String sql;
            
            sql ="select * from rs_preferences where username=?";
            
            PreparedStatement psmt = conn.prepareStatement(sql);
            
            psmt.setString(1, username);
            
            ResultSet rs = psmt.executeQuery();
            rs.next();
            
            String area = rs.getString("area");
                
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

                location = jsonLocation.get("region").toString() + ", " + jsonLocation.get("country").toString(); // e.g. Manila, Philippines
                temp = jsonCurrent.get("temp_c").toString() + "°"; // e.g. 30°
                status = jsonCondition.get("text").toString(); // e.g. Partly cloudy

                // System.out.println("\n"+location+"\n"+temp+"\n"+status+"\n"); // Print Basic Weather Forecast to Console

                System.out.println("WeatherAPI Fetch Successful.");
            } catch (IOException e) {
                System.out.println("Exception: " + e);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    
}
