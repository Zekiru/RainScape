/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/**
 *
 * @author Ezekiel
 */
public class MySQL {
    public static String default_area = "Manila"; // Default New Account Area
    public static String default_temp_scale = "celsius"; // Default New Account Area
    public static boolean default_mode = false; // Default New Account Area
    
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
        } catch (ClassNotFoundException e) {
            System.out.println("Exception: " + e);
        } catch (SQLException e) {
            // JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
        }
        return area;
    }
    
    public static void fetch() {
        String user = RainScape.username;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
            
            String sql;

            sql = "select * from rs_preferences where username=?";

            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setString(1, user);

            ResultSet rs = psmt.executeQuery();
            rs.next();

            RainScape.temp_scale = rs.getString("temp_scale");
            RainScape.dark_mode = rs.getBoolean("dark_mode");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception: " + e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
        }
    }
    
    public static void logWeather() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
            String sql = "insert into rs_weatherlogs value ( ?, ?, ?, ?, ?, ?, ?, ? )";

            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt = conn.prepareStatement(sql);
            
            psmt.setString(1, RainScape.username);
            psmt.setString(2, dateFormat.format(date));
            psmt.setString(3, WeatherAPI.location);
            psmt.setString(4, WeatherAPI.status);
            psmt.setString(5, RainScape.temp_scale);
            psmt.setString(6, WeatherAPI.temp);
            psmt.setString(7, WeatherAPI.forecast[3][0]);
            psmt.setString(8, WeatherAPI.forecast[3][1]);

            psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void setPreferences() {
        try {
            PreferencesGUI.username.setText(RainScape.username);
            PreferencesGUI.default_area.setText(MySQL.defaultUserArea());
            
            if (!RainScape.temp_scale.equals("celsius")) {
                PreferencesGUI.celsius_checkbox.setEnabled(true);
                PreferencesGUI.celsius_checkbox.setState(false);

                PreferencesGUI.fahrenheit_checkbox.setEnabled(false);
                PreferencesGUI.fahrenheit_checkbox.setState(true);
            } else {
                PreferencesGUI.fahrenheit_checkbox.setEnabled(true);
                PreferencesGUI.fahrenheit_checkbox.setState(false);

                PreferencesGUI.celsius_checkbox.setEnabled(false);
                PreferencesGUI.celsius_checkbox.setState(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
        }
    }
    
    public static void changePassword() {
        String newpass = JOptionPane.showInputDialog("Input New Password:");
        
        if (newpass != null)
            if (newpass.equals(""))
                JOptionPane.showMessageDialog(null, "Fill in the empty fields.");
            else
                try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
                String sql = "Update rs_accounts set password=? where username=?";

                PreparedStatement psmt = conn.prepareStatement(sql);
                psmt.setString(1, newpass);
                psmt.setString(2, RainScape.username);

                psmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Password Changed.");
                
                PreferencesGUI.main(null);
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
            }
    }
    
    public static void changeDefaultArea() {
        String newarea = JOptionPane.showInputDialog("Input New Default Area:");
        
        if (newarea != null)
            try {
                String api_url = "https://weatherapi-com.p.rapidapi.com/forecast.json?q=" + newarea;

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

                JSONObject jsonLocation = new JSONObject(jsonAPI.get("location").toString());

                String location = jsonLocation.getString("name");

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
                String sql = "Update rs_preferences set area=? where username=?";

                PreparedStatement psmt = conn.prepareStatement(sql);
                psmt.setString(1, location);
                psmt.setString(2, RainScape.username);

                psmt.executeUpdate();

                WeatherAPI.fetch(RainScape.currentSearchArea());
                WeatherAPI.setValues();

                JOptionPane.showMessageDialog(null, "Default Area Changed.");
                
                PreferencesGUI.main(null);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
            }
    }
    
    public static void changeTempScale(boolean is_celsius) {
        String scale = default_temp_scale;
        
        try {
            if (is_celsius) {
                PreferencesGUI.fahrenheit_checkbox.setEnabled(true);
                PreferencesGUI.fahrenheit_checkbox.setState(false);

                PreferencesGUI.celsius_checkbox.setEnabled(false);
                PreferencesGUI.celsius_checkbox.setState(true);
                
                scale = "celsius";
            } else {
                PreferencesGUI.celsius_checkbox.setEnabled(true);
                PreferencesGUI.celsius_checkbox.setState(false);

                PreferencesGUI.fahrenheit_checkbox.setEnabled(false);
                PreferencesGUI.fahrenheit_checkbox.setState(true);
                
                scale = "fahrenheit";
            }

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
            String sql = "Update rs_preferences set temp_scale=? where username=?";

            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, scale);
            psmt.setString(2, RainScape.username);

            psmt.executeUpdate();

            WeatherAPI.fetch(RainScape.currentSearchArea());
            WeatherAPI.setValues();
            
            JOptionPane.showMessageDialog(null, "Temperature Scale Changed.");
            
            PreferencesGUI.main(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
        }
    }
}
