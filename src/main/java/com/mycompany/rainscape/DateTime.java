/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ezekiel
 */
public class DateTime {
    
    public static void autoUpdate() { // Run along with project
        System.out.println("DateTime Auto Update Initialized");
        
        while (true) {
            boolean access = RainScape.access;
            
            if (access) {
                try {
                    Thread.sleep(1000); // Fetch ms intervals, Default = 1 second
                } catch (InterruptedException ie) {
                    System.out.println("Interrupted Exception: " + ie);
                }
                
                if (access) {
                    setValues();
                    
                    // System.out.println("Date Updated");
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
    
    public static String localTime() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
        Date date = new Date();
        
        if (dateFormat.format(date).charAt(1) == '0')
            return dateFormat.format(date);
        else
            return dateFormat.format(date).substring(1);
    }
    
    public static String localDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        return dateFormat.format(date);
    }
    
    public static void setValues() {
        MainGUI.localdate.setText(localDate());
        MainGUI.localtime.setText(localTime());
    }
}
