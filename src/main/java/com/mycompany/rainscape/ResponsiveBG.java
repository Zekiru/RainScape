/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Ezekiel
 */
public class ResponsiveBG {
    public static void setCondition() {
        try {
            ImageIcon[][] bgs = {
                {new ImageIcon("RS.jpg"), new ImageIcon("RN.jpg"), new ImageIcon("TH.jpg")}, 
                {new ImageIcon("CM.jpg"), new ImageIcon("CA.jpg"), new ImageIcon("CN.jpg")}, 
                {new ImageIcon("SA.jpg"), new ImageIcon("SCM.jpg"), new ImageIcon("SCA.jpg")}
            };

            String[] keywords = {"Thundery", "thunder", "rain", "cloudy", "Cloudy", "Sunny", "Clear", "Overcast"};

            String str = WeatherAPI.status;
            int x = -1, y = -1;
        
            while (x <= 0) {
                y++;
                x = str.indexOf(keywords[y]);
                
                if (x > 0 || str.equals(keywords[y])) {
                    if (keywords[y].equals(keywords[0]) || keywords[y].equals(keywords[1])) {
                        MainGUI.background_image.setIcon(bgs[0][2]);
                    } else if (keywords[y].equals(keywords[2])) {
                        if (DateTime.localTimeOfDay().equals("Morning") || DateTime.localTimeOfDay().equals("Afternoon"))
                            MainGUI.background_image.setIcon(bgs[0][0]);
                        else if (DateTime.localTimeOfDay().equals("Evening")) {
                            MainGUI.background_image.setIcon(bgs[0][1]);
                        } else {
                            MainGUI.background_image.setIcon(bgs[2][1]);
                        }
                    } else if (keywords[y].equals(keywords[3]) || keywords[y].equals(keywords[4])) {
                        if (DateTime.localTimeOfDay().equals("Morning"))
                            MainGUI.background_image.setIcon(bgs[1][0]);
                        else if (DateTime.localTimeOfDay().equals("Afternoon"))
                            MainGUI.background_image.setIcon(bgs[1][1]);
                        else if (DateTime.localTimeOfDay().equals("Evening")) {
                            MainGUI.background_image.setIcon(bgs[1][2]);
                        } else {
                            MainGUI.background_image.setIcon(bgs[2][1]);
                        }
                    } else if (keywords[y].equals(keywords[5])) {
                        if (DateTime.localTimeOfDay().equals("Morning"))
                            MainGUI.background_image.setIcon(bgs[2][1]);
                        else if (DateTime.localTimeOfDay().equals("Afternoon"))
                            MainGUI.background_image.setIcon(bgs[2][0]);
                        else if (DateTime.localTimeOfDay().equals("Evening")) {
                            MainGUI.background_image.setIcon(bgs[1][2]);
                        } else {
                            MainGUI.background_image.setIcon(bgs[2][1]);
                        }
                    } else if (keywords[y].equals(keywords[6])) {
                        if (DateTime.localTimeOfDay().equals("Morning") || DateTime.localTimeOfDay().equals("Afternoon"))
                            MainGUI.background_image.setIcon(bgs[2][1]);
                        else if (DateTime.localTimeOfDay().equals("Evening")) {
                            MainGUI.background_image.setIcon(bgs[1][2]);
                        } else {
                            MainGUI.background_image.setIcon(bgs[2][1]);
                        }
                    } else if (keywords[y].equals(keywords[7])) {
                        if (DateTime.localTimeOfDay().equals("Morning"))
                            MainGUI.background_image.setIcon(bgs[1][0]);
                        else if (DateTime.localTimeOfDay().equals("Afternoon"))
                            MainGUI.background_image.setIcon(bgs[1][1]);
                        else if (DateTime.localTimeOfDay().equals("Evening")) {
                            MainGUI.background_image.setIcon(bgs[1][2]);
                        } else {
                            MainGUI.background_image.setIcon(bgs[2][1]);
                        }
                    } else {
                        MainGUI.background_image.setIcon(bgs[2][1]);
                    }
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("default");
        } catch (Exception e) {
            //e.printStackTrace();
        }

        /*String str = "This sentance contains find me string";
        System.out.println(str);
        // find word in String
        String find = "find me";
        int i = str.indexOf(find);
        if(i>0)
            System.out.println(str.substring(i, i+find.length()));
        else 
            System.out.println("string not found");*/
    }
}
