/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.rainscape;

/**
 *
 * @author Ezekiel
 */
public class RainScape {

    public static void main(String[] args) {
        System.out.println("Project Initializing.");
        try {
            LoginGUI.main(args);
            System.out.println("Project Launched.");
        } catch (Exception e) {
            System.out.println("Project Not Launched.");
            System.out.println("Exception: " + e);
        }
        
        WeatherAPI.fetch();
        
        while (true) {
            System.out.println(DateTime.localDate());
            System.out.println(DateTime.localTime());
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception: " + e);
            }
        }
    }
    
}
