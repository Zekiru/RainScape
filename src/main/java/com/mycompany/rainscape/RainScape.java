/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.rainscape;

import com.formdev.flatlaf.FlatDarkLaf;
import static com.mycompany.rainscape.MySQL.conn;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ezekiel
 */
public class RainScape extends MySQL{
    
    public static String username, temp_scale = null;
    public static boolean access, dark_mode = false;
    
    public static String search_area = "";

    public static void main(String[] args) { 
        runThreads();
    }
    
    public static void start() {
        System.out.println("Project Initializing");
        try {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } catch (UnsupportedLookAndFeelException e) {
                System.out.println("Look and Feel Exception: " + e);
            }
            
            // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db","root","");
            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/ikKSSAVuHj","ikKSSAVuHj","r2kJmQaXMS");
            
            LoginGUI.main(null);
            System.out.println("Project Launched");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to the Database.");
            
            e.printStackTrace();
            
            System.out.println("Project Not Launched");
            System.exit(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Launch RainScape.");
            
            e.printStackTrace();
            
            System.out.println("Project Not Launched");
            System.exit(0);
        }
    }
    
    public static void runThreads() {
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
        
        ArrayList taskList = new ArrayList();
        taskList.add(callable1);
        taskList.add(callable2);
        taskList.add(callable3);
        
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            executor.invokeAll(taskList);
        } catch (InterruptedException ie) {
            System.out.println("Interrupted Exception: " + ie);
        }
    }
    
    public static String currentSearchArea() {
        String area;

        if (search_area.equals("")) {
            area = MySQL.defaultUserArea();
        } else {
            area = search_area;
        }

        return area;
    }
    
    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (IOException | URISyntaxException e) {
            System.out.println("Exception: " + e);
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
    
    public static void openRainScapePNG() {
        try {
            JFrame frame = new JFrame("RainScape");
            JPanel panel = new JPanel();
            JLabel image = new JLabel();

            frame.add(panel);
            panel.add(image);
            panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);

            image.setPreferredSize(new Dimension(540, 900));
            image.setSize(image.getPreferredSize());
            
            BufferedImage buff_img = ImageIO.read(new File("images/rainscape_infographic.png"));
            Image img = buff_img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
            
            image.setIcon(new ImageIcon(img));

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

            image.addMouseListener(new MouseListener() {
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
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Failed to Fetch RainScape PNG.");
            e.printStackTrace();
        }
    }
    
}
