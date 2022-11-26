/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Ezekiel
 */
public class ResponsiveBG {
    public static void setCondition() {
        try {
            String str = WeatherAPI.status;
            int x = -1, y = -1;
            
            File[][] img_file = {
                {new File("images/RM.jpg"), new File("images/RE.jpg"), new File("images/TH.jpg")}, 
                {new File("images/CLM.jpg"), new File("images/CLE.jpg")}, 
                {new File("images/CM.jpg"), new File("images/CE.jpg")}, 
                {new File("images/OM.jpg"), new File("images/OE.jpg")}
            };
            
            BufferedImage buff_img = ImageIO.read(img_file[1][0]);

            String[] keywords = {"Thundery", "thunder", "rain", "cloudy", "Cloudy", "Sunny", "Clear", "Overcast"};
        
            while (x <= 0) {
                y++;
                x = str.indexOf(keywords[y]);
                
                if (x > 0 || str.equals(keywords[y])) {
                    if (keywords[y].equals(keywords[0]) || keywords[y].equals(keywords[1])) {
                        buff_img = ImageIO.read(img_file[0][2]);
                    } else if (keywords[y].equals(keywords[2])) {
                        if (DateTime.localTimeOfDay().equals("Morning") || DateTime.localTimeOfDay().equals("Afternoon"))
                            buff_img = ImageIO.read(img_file[0][0]);
                        else
                            buff_img = ImageIO.read(img_file[0][1]);
                    } else if (keywords[y].equals(keywords[3]) || keywords[y].equals(keywords[4])) {
                        if (DateTime.localTimeOfDay().equals("Morning") || DateTime.localTimeOfDay().equals("Afternoon"))
                            buff_img = ImageIO.read(img_file[1][0]);
                        else
                            buff_img = ImageIO.read(img_file[1][1]);
                    } else if (keywords[y].equals(keywords[5]) || keywords[y].equals(keywords[6])) {
                        if (DateTime.localTimeOfDay().equals("Morning") || DateTime.localTimeOfDay().equals("Afternoon"))
                            buff_img = ImageIO.read(img_file[2][0]);
                        else
                            buff_img = ImageIO.read(img_file[2][1]);
                    } else if (keywords[y].equals(keywords[7])) {
                        if (DateTime.localTimeOfDay().equals("Morning") || DateTime.localTimeOfDay().equals("Afternoon")) {
                            buff_img = ImageIO.read(img_file[3][0]);
                        } else
                            buff_img = ImageIO.read(img_file[3][1]);
                    } else {
                        buff_img = ImageIO.read(img_file[1][0]);
                    }
                    break;
                }
            }
            MainGUI.background_image.setIcon(iconResize(buff_img));
        } catch (Exception e) {
            try {
                MainGUI.background_image.setIcon(iconResize(ImageIO.read(new File("images/CLM.jpg"))));
                // e.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
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
    
    public static ImageIcon iconResize(BufferedImage bi) {
        Image img = bi.getScaledInstance(MainGUI.background_image.getWidth(), MainGUI.background_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon bg = new ImageIcon(img);
        return bg;
    }
}
