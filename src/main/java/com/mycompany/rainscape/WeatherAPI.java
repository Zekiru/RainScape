/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/**
 *
 * @author Ezekiel
 */
public class WeatherAPI {
    
    public static void fetch() {
        try {
            String city = "Manila";
            String url = "https://weatherapi-com.p.rapidapi.com/forecast.json?q=" + city;
            
            OkHttpClient client = new OkHttpClient();
            
            Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", "d2cd26e50fmshb105523acf4dea8p15c5eejsn5766f55f0f75")
                .addHeader("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .build();
            
            Response response = client.newCall(request).execute();
            
            JSONObject jsonAPI = new JSONObject(response.body().string());
            
            JSONObject jsonLocation = new JSONObject(jsonAPI.get("location").toString());
            JSONObject jsonCurrent = new JSONObject(jsonAPI.get("current").toString());
            JSONObject jsonCondition = new JSONObject(jsonCurrent.get("condition").toString());
            
            System.out.println(jsonLocation.get("region"));
            System.out.println(jsonLocation.get("country"));
            
            System.out.println(jsonCurrent.get("temp_c") + " Celsius");
            
            System.out.println(jsonCondition.get("text"));
            System.out.println(jsonLocation.get("localtime"));
            
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
