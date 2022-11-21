/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ezekiel
 */
public class DateTime {
    
    public static void autoUpdate() {
        System.out.println("DateTime AutoUpdate Initialized");
        
        while (true) {
            boolean access = RainScape.access;
            
            try {
                Thread.sleep(100); // While loop time buffer, Default 100 milliseconds
            } catch (InterruptedException ie) {
                System.out.println("Interrupted Exception: " + ie);
            }

            if (access) {
                DateTime.setValues();
                    
                // System.out.println("DateTime Updated");
            }
        }
    }
    
    public static String localTimeOfDay() {
        Calendar c = Calendar.getInstance();
        int time = c.get(Calendar.HOUR_OF_DAY);

        if (time >= 3 && time < 12)
            return "Morning";
        else if (time >= 12 && time < 18)
            return "Afternoon";
        else if (time >= 18 && time < 24 || time >= 0 && time < 3)
            return "Evening";
        else
            return "Day";
    }
    
    public static String localTime() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
        Date date = new Date();
        
        String time = dateFormat.format(date);
        
        time = time.replace('a', 'A');
        time = time.replace('p', 'P');
        time = time.replace('m', 'M');
        
        if (time.charAt(0) != '0') {
            return time;
        } else {
            return time.substring(1);
        }
    }
    
    public static String localDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        return dateFormat.format(date);
    }
    
    public static void setValues() {
        String greeting = "Good " + localTimeOfDay() + ", " + RainScape.username + ".";
        
        if (!greeting.equals(MainGUI.weather_label.getText())) {
            MainGUI.weather_label.setText(greeting);
            
            // System.out.println("Time Of Day Updated");
        }
        
        if (!localTime().equals(MainGUI.localtime.getText())){
            MainGUI.localtime.setText(localTime());
            
            // System.out.println("Time Updated");
        }
        
        if (!localDate().equals(MainGUI.localdate.getText())) {
            MainGUI.localdate.setText(localDate());
            
            // System.out.println("Date Updated");
        }
    }
}
