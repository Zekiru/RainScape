/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JOptionPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ezekiel
 */
public class WeatherAPI {
    public static String location, temp, status, icon_url; // Variables for Basic Weather Forecast
    
    public static void autoUpdate() {
        System.out.println("WeatherAPI AutoUpdate Initialized");
        
        while (true) {
            boolean access = RainScape.access;
            
            try {
                Thread.sleep(100); // While loop time buffer, Default 100 milliseconds
            } catch (InterruptedException ie) {
                System.out.println("Interrupted Exception: " + ie);
            }

            if (access) {
                try {
                    Thread.sleep(600000); // While loop time buffer, Default 10 minutes
                } catch (InterruptedException ie) {
                    System.out.println("Interrupted Exception: " + ie);
                }
                
                if (access) {
                    WeatherAPI.fetch(RainScape.currentSearchArea());
                    WeatherAPI.setValues();

                    TropicalCyclone.fetch();
                    TropicalCyclone.setValues();
                    
                    // System.out.println("WeatherAPI Updated");
                }
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="RAINSCAPE EXCUSIVE DATA">
    
    /* WARNING: This Part Contains Data Exclusively for RainScape Application Use Only.
    The Data in particular is the API KEY, If you are planning to copy from this code,
    Refrain from using this Java Application's API KEYon your own Project. You can sign
    up for your own API key with the link below:

    https://rapidapi.com/weatherapi/api/weatherapi-com

    Viewing, Running, Even Copying the rest of this project's code is still allowed, but
    since the API has a limited amount of uses I typed this down as a precaution. That is
    all, and if you are still reading, how's the weather there? */
    
    public static void fetch(String area) {
        MySQL.fetch();
        
        try {
            String api_url = "https://weatherapi-com.p.rapidapi.com/current.json?q=" + area;

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                .url(api_url)
                .get()
                // <editor-fold defaultstate="collapsed" desc="RainScape WeatherAPI Key">
                .addHeader("X-RapidAPI-Key", "d2cd26e50fmshb105523acf4dea8p15c5eejsn5766f55f0f75")
                .addHeader("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                // </editor-fold>
                .build();

            Response response = client.newCall(request).execute();
            
            JSONObject jsonAPI = new JSONObject(response.body().string());

            if (jsonAPI.has("location")) {
                JSONObject jsonLocation = new JSONObject(jsonAPI.get("location").toString());
                JSONObject jsonCurrent = new JSONObject(jsonAPI.get("current").toString());
                JSONObject jsonCondition = new JSONObject(jsonCurrent.get("condition").toString());

                // Below are the fetched variables:
                
                if (jsonLocation.get("name").toString().equals(jsonLocation.get("country").toString()))
                    location = jsonLocation.get("name").toString(); // e.g. Makati (Makati, Manila, PH)
                else
                    if (jsonLocation.get("country").toString().equals("United States of America") || jsonLocation.get("country").toString().equals("USA United States of America")) // OHIO
                        location = jsonLocation.get("name").toString() + ", USA";
                    else
                        location = jsonLocation.get("name").toString() + ", " + jsonLocation.get("country").toString(); // e.g. Makati, Philippines (Makati, Manila, PH)
                
                if (!RainScape.temp_scale.equals("celsius"))
                    temp = jsonCurrent.get("temp_f").toString() + "°"; // e.g. 86°
                else
                    temp = jsonCurrent.get("temp_c").toString() + "°"; // e.g. 30°
                
                status = jsonCondition.get("text").toString(); // e.g. Partly cloudy
                icon_url = jsonCondition.get("icon").toString(); // e.g. //cdn.weatherapi.com/weather/64x64/day/116.png

                // System.out.println("\n"+location+"\n"+temp+"\n"+status+"\n"); // Print Basic Weather Forecast to Console
                
                // System.out.println("WeatherAPI Data Fetched");
            } else if (jsonAPI.has("error")) {
                JSONObject jsonError = new JSONObject(jsonAPI.get("error").toString());
                String message = jsonError.get("message").toString();

                JOptionPane.showMessageDialog(null, message);

                // System.out.println("WeatherAPI Data Fetch Error");
            } else {
                JOptionPane.showMessageDialog(null, "Weather Fetch Error.");
                System.out.println(response.body().string());
            }
        } catch (HeadlessException | JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Connection Error.");
            
            location = "Running Offline";
            status = "Not Connected";
            temp = "N/A";
        }
    } // </editor-fold>
    
    public static void setValues() {
        try {
            MainGUI.location.setText(location);
            MainGUI.temp.setText(temp);
            MainGUI.status.setText(status);
            
            // System.out.println("WeatherAPI Data Set");
        } catch (Exception e) {
            e.printStackTrace(); 
       }
    }
    
}
