/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Ezekiel
 */
public class TropicalCyclone {
    public static BufferedImage tca = null;
    public static Image tca_resize, tc2021, tc2020, tc2019, tc2018, tc2017 = null;
    
    public static void fetch() {
        //create a callable for each method
        Callable callable1 = () -> {
            try {
                tc2017 = ImageIO.read(new URL(getFinalURL("https://pubfiles.pagasa.dost.gov.ph/tamss/weather/tc2017.png"))).getScaledInstance(700, 3000, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                System.out.println("Cannot Load tc2017");
            }
            return null;
        };
        Callable callable2 = () -> {
            try {
                tc2018 = ImageIO.read(new URL(getFinalURL("https://pubfiles.pagasa.dost.gov.ph/tamss/weather/tc2018.png"))).getScaledInstance(700, 3000, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                System.out.println("Cannot Load tc2018");
            }
            return null;
        };
        Callable callable3 = () -> {
            try {
                tc2019 = ImageIO.read(new URL(getFinalURL("https://pubfiles.pagasa.dost.gov.ph/tamss/weather/tc2019.png"))).getScaledInstance(700, 3000, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                System.out.println("Cannot Load tc2019");
            }
            return null;
        };
        Callable callable4 = () -> {
            try {
                tc2020 = ImageIO.read(new URL(getFinalURL("https://pubfiles.pagasa.dost.gov.ph/tamss/weather/tc2020.png"))).getScaledInstance(700, 3000, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                System.out.println("Cannot Load tc2020");
            }
            return null;
        };
        Callable callable5 = () -> {
            try {
                tc2021 = ImageIO.read(new URL(getFinalURL("https://pubfiles.pagasa.dost.gov.ph/tamss/weather/tc2021.png"))).getScaledInstance(700, 3000, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                System.out.println("Cannot Load tc2021");
            }
            return null;
        };
        Callable callable6 = () -> {
            try {
                tca = ImageIO.read(new URL(getFinalURL("https://pubfiles.pagasa.dost.gov.ph/tamss/weather/tca.png")));
                tca_resize = tca.getScaledInstance(MainGUI.typhoon_image.getWidth(), MainGUI.typhoon_image.getHeight(), Image.SCALE_SMOOTH);
            } catch (IOException e) {
                System.out.println("Cannot Load tca");
            }
            return null;
        };

        ArrayList taskList = new ArrayList();
        taskList.add(callable1);
        taskList.add(callable2);
        taskList.add(callable3);
        taskList.add(callable4);
        taskList.add(callable5);
        taskList.add(callable6);

        ExecutorService executor = Executors.newFixedThreadPool(6);
        
        try {
            //start the threads and wait for them to finish
            executor.invokeAll(taskList);
        } catch (InterruptedException ie) {
            System.out.println("Failed to Fetch Data from PAGASA\nInterrupted Exception: " + ie);
        }
    }
    
    public static void setValues() {
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
    
    public static void openBigTCA() {
        try {
            JFrame frame = new JFrame("Latest Tropical Cyclone Advisory (PAGASA)");
            JPanel panel = new JPanel();
            JLabel image = new JLabel();

            frame.add(panel);
            panel.add(image);
            panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);

            image.setPreferredSize(new Dimension((int) (MainGUI.typhoon_image.getWidth() * 1.75), (int) (MainGUI.typhoon_image.getHeight() * 1.75)));

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
            JOptionPane.showMessageDialog(null, "Failed to Fetch Data from PAGASA");
        }
    }

    public static void openOtherTCA(Image img) {
        try{
            JFrame frame = new JFrame("Tropical Cyclone Records (PAGASA)");
            JLabel image = new JLabel();
            JScrollPane scrollpane = new JScrollPane(image);

            frame.add(scrollpane);
            image.setCursor(new Cursor(Cursor.HAND_CURSOR));

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);

            scrollpane.setPreferredSize(new Dimension(714, 800));
            image.setPreferredSize(new Dimension(700, 3000));

            image.setIcon(new ImageIcon(img));

            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);

            scrollpane.getVerticalScrollBar().setValue(scrollpane.getVerticalScrollBar().getMinimum());
            scrollpane.getVerticalScrollBar().setUnitIncrement(16);
            scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

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
            JOptionPane.showMessageDialog(null, "Failed to Fetch Data from PAGASA");
        }
    }
}
