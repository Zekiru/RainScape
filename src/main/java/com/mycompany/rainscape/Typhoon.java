/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ezekiel
 */
public class Typhoon {
    public static BufferedImage tca = null;
    public static Image tca_resize = null;
    
    public static void fetchTCA() {
        try {
            tca = ImageIO.read(new URL(getFinalURL("https://pubfiles.pagasa.dost.gov.ph/tamss/weather/tca.png")));
            
            if (tca != null) {
                tca_resize = tca.getScaledInstance(MainGUI.typhoon_image.getWidth(), MainGUI.typhoon_image.getHeight(), Image.SCALE_SMOOTH);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (tca_resize != null) {
            MainGUI.typhoon_image.setIcon(new ImageIcon(tca_resize));
        }
    }
    
    public static String getFinalURL(String url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setInstanceFollowRedirects(false);
        con.connect();
        con.getInputStream();

        if (con.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM || con.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
            String redirectUrl = con.getHeaderField("Location");
            return getFinalURL(redirectUrl);
        }
        return url;
    }
    
    public static JFrame frame = new JFrame("Latest Tropical Cyclone Advisory (PAGASA)");
    public static JPanel panel = new JPanel();
    public static JLabel image = new JLabel();
    
    public static void openBigTCA() {
        frame.add(panel);
        panel.add(image);
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        image.setPreferredSize(new Dimension((int) (MainGUI.typhoon_image.getWidth() * 1.75), (int) (MainGUI.typhoon_image.getHeight() * 1.75)));
        image.setSize(image.getPreferredSize());

        image.setIcon(new ImageIcon(tca.getScaledInstance((int) (MainGUI.typhoon_image.getWidth() * 1.75), (int) (MainGUI.typhoon_image.getHeight() * 1.75), Image.SCALE_SMOOTH)));

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        frame.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }
            @Override
            public void focusLost(FocusEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}
