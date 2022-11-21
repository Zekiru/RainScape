/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.rainscape;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ezekiel
 */
public class RainScape {
    
    public static String username = null;
    public static boolean access = false;

    public static void main(String[] args) {
        runThreads();
    }
    
    public static void start() {
        System.out.println("Project Initializing");
        try {
            LoginGUI.main(null);
            System.out.println("Project Launched");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Launch RainScape.");

            System.out.println("Project Not Launched");
            System.exit(0);
        }

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Look and Feel Exception: " + e);
        }
    }
    
    public static void runThreads() {

        //create a callable for each method
        Callable callable1 = () -> {
            WeatherAPI.autoUpdate();
            return null;
        };

        Callable callable2 = () -> {
            DateTime.autoUpdate();
            return null;
        };
        
        Callable callable3 = () -> {
            start();
            return null;
        };
        
        //add to a list
        ArrayList taskList = new ArrayList();
        taskList.add(callable1);
        taskList.add(callable2);
        taskList.add(callable3);

        //create a pool executor with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            //start the threads and wait for them to finish
            executor.invokeAll(taskList);
        } catch (InterruptedException ie) {
            //do something if you care about interruption;
            System.out.println("Interrupted Exception: " + ie);
        }
    }
    
    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (IOException | URISyntaxException e) {
            System.out.println("Exception: " + e);
        }
    }
    
}
