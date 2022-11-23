/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ezekiel
 */
public class WeatherAPI {
    public static String location, temp, status, icon_url; // Variables for Basic Weather Forecast
    public static String[][] forecast = {{null, null, null}, {null, null, null}, {null, null, null}, {null, null}}; // Variables for Weather Dashboard
    
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
            // Weather API Call Request:
            String api_url = "https://weatherapi-com.p.rapidapi.com/forecast.json?q=" + area + "&days=3";

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
            
            // Arranged Data Into Callable JSONObjects:
            
            JSONObject jsonAPI = new JSONObject(response.body().string());

            if (jsonAPI.has("location")) {
                JSONObject jsonLocation = new JSONObject(jsonAPI.get("location").toString());
                JSONObject jsonCurrent = new JSONObject(jsonAPI.get("current").toString());
                JSONObject jsonCurrentCondition = new JSONObject(jsonCurrent.get("condition").toString());
                
                JSONArray jsonForecastDay = new JSONArray((new JSONObject(jsonAPI.get("forecast").toString())).get("forecastday").toString());
                
                JSONObject[] jsonForecastArray = {
                    new JSONObject(jsonForecastDay.get(0).toString()),
                    new JSONObject(jsonForecastDay.get(1).toString()),
                    new JSONObject(jsonForecastDay.get(2).toString())
                };
                
                JSONObject[] jsonForecastConditionArray = {
                    new JSONObject((new JSONObject(jsonForecastArray[0].get("day").toString())).get("condition").toString()),
                    new JSONObject((new JSONObject(jsonForecastArray[1].get("day").toString())).get("condition").toString()),
                    new JSONObject((new JSONObject(jsonForecastArray[2].get("day").toString())).get("condition").toString())
                };

                // Fetching of Data:
                
                if (jsonLocation.getString("name").equals(jsonLocation.getString("country")))
                    location = jsonLocation.getString("name"); // e.g. Makati (Makati, Manila, PH)
                else
                    if (jsonLocation.getString("country").equals("United States of America") || jsonLocation.getString("country").equals("USA United States of America")) // OHIO
                        location = jsonLocation.getString("name") + ", USA";
                    else
                        location = jsonLocation.getString("name") + ", " + jsonLocation.getString("country"); // e.g. Makati, Philippines (Makati, Manila, PH)
                
                if (!RainScape.temp_scale.equals("celsius"))
                    temp = jsonCurrent.getInt("temp_f") + "°F"; // e.g. 86°
                else
                    temp = jsonCurrent.getInt("temp_c") + "°C"; // e.g. 30°
                
                status = jsonCurrentCondition.getString("text"); // e.g. Partly cloudy
                icon_url = "https:" + jsonCurrentCondition.getString("icon"); // e.g. //cdn.weatherapi.com/weather/64x64/day/116.png
                
                forecast[0][0] = jsonForecastArray[0].getString("date");
                forecast[1][0] = jsonForecastArray[1].getString("date");
                forecast[2][0] = jsonForecastArray[2].getString("date");
                
                if (!RainScape.temp_scale.equals("celsius")) {
                    forecast[0][1] = new JSONObject(jsonForecastArray[0].get("day").toString()).getInt("avgtemp_f")  + "°F";
                    forecast[1][1] = new JSONObject(jsonForecastArray[1].get("day").toString()).getInt("avgtemp_f")  + "°F";
                    forecast[2][1] = new JSONObject(jsonForecastArray[2].get("day").toString()).getInt("avgtemp_f")  + "°F";
                } else {
                    forecast[0][1] = new JSONObject(jsonForecastArray[0].get("day").toString()).getInt("avgtemp_c")  + "°C";
                    forecast[1][1] = new JSONObject(jsonForecastArray[1].get("day").toString()).getInt("avgtemp_c")  + "°C";
                    forecast[2][1] = new JSONObject(jsonForecastArray[2].get("day").toString()).getInt("avgtemp_c")  + "°C";
                }
                
                forecast[0][2] = "https:" + jsonForecastConditionArray[0].getString("icon");
                forecast[1][2] = "https:" + jsonForecastConditionArray[0].getString("icon");
                forecast[2][2] = "https:" + jsonForecastConditionArray[0].getString("icon");
                
                forecast[3][0] = jsonCurrent.get("cloud").toString();
                forecast[3][1] = jsonCurrent.get("humidity").toString();
                
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
            System.out.println("Connection Error.");
            
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
            MainGUI.current_icon.setIcon(new ImageIcon(ImageIO.read(new URL(RainScape.getFinalURL(icon_url))).getScaledInstance(MainGUI.current_icon.getWidth(), MainGUI.current_icon.getHeight(), Image.SCALE_SMOOTH)));
            
            MainGUI.forecast0_date.setText(forecast[0][0]);
            MainGUI.forecast0_temp.setText(forecast[0][1]);
            MainGUI.forecast0_icon.setIcon(new ImageIcon(ImageIO.read(new URL(RainScape.getFinalURL(forecast[0][2]))).getScaledInstance(MainGUI.forecast0_icon.getWidth(), MainGUI.forecast0_icon.getHeight(), Image.SCALE_SMOOTH)));
            
            MainGUI.forecast1_date.setText(forecast[1][0]);
            MainGUI.forecast1_temp.setText(forecast[1][1]);
            MainGUI.forecast1_icon.setIcon(new ImageIcon(ImageIO.read(new URL(RainScape.getFinalURL(forecast[1][2]))).getScaledInstance(MainGUI.forecast0_icon.getWidth(), MainGUI.forecast0_icon.getHeight(), Image.SCALE_SMOOTH)));
            
            MainGUI.forecast2_date.setText(forecast[2][0]);
            MainGUI.forecast2_temp.setText(forecast[2][1]);
            MainGUI.forecast2_icon.setIcon(new ImageIcon(ImageIO.read(new URL(RainScape.getFinalURL(forecast[2][2]))).getScaledInstance(MainGUI.forecast0_icon.getWidth(), MainGUI.forecast0_icon.getHeight(), Image.SCALE_SMOOTH)));
            
            MainGUI.cloud_label.setText("Clouds - " + forecast[3][0] + "%");
            MainGUI.cloud_progressbar.setValue(Integer.parseInt(forecast[3][0]));
            
            MainGUI.humidity_label.setText("Humidity - " + forecast[3][1] + "%");
            MainGUI.humidity_progressbar.setValue(Integer.parseInt(forecast[3][1]));
            
            MySQL.logWeather();
            
            // System.out.println("WeatherAPI Data Set");
        } catch (Exception e) {
            try {
                MainGUI.location.setText(location);
                MainGUI.temp.setText(temp);
                MainGUI.status.setText(status);

                MainGUI.forecast0_date.setText("");
                MainGUI.forecast0_temp.setText("");
                MainGUI.forecast1_date.setText("");
                MainGUI.forecast1_temp.setText("");
                MainGUI.forecast2_date.setText("");
                MainGUI.forecast2_temp.setText("");
                
                MainGUI.forecast0_icon.setIcon(null);
                MainGUI.forecast1_icon.setIcon(null);
                MainGUI.forecast2_icon.setIcon(null);

                MainGUI.cloud_label.setText("Clouds - 0%");
                MainGUI.humidity_label.setText("Humidity - 0%");

                MainGUI.cloud_progressbar.setValue(0);
                MainGUI.humidity_progressbar.setValue(0);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(null, "Connection Error.");
       }
    }
    
}
