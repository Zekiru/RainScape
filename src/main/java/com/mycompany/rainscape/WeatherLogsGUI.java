/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rainscape;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ezekiel
 */
public class WeatherLogsGUI extends javax.swing.JFrame {
    
    public static Connection conn = MySQL.conn;

    /**
     * Creates new form WeatherLogsGUI
     */
    public WeatherLogsGUI() {
        initComponents();
        
        conn = RainScape.mySqlHandler();
        
        DisplayTable();
    }
    
    private void DisplayTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select * from rs_weatherlogs where username=? order by date_time desc";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, RainScape.username);
            ResultSet rs = psmt.executeQuery();
            jTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content_box = new javax.swing.JPanel();
        weatherlogs_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        back = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        search_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Weather Logs");
        setName("weatherlogs_frame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(820, 550));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        content_box.setBackground(new java.awt.Color(51, 51, 51));
        content_box.setMaximumSize(new java.awt.Dimension(820, 550));
        content_box.setMinimumSize(new java.awt.Dimension(820, 550));

        weatherlogs_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        weatherlogs_label.setForeground(new java.awt.Color(231, 246, 242));
        weatherlogs_label.setText("Weather Data Logs:");

        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(720, 400));

        jTable.setAutoCreateRowSorter(true);
        jTable.setBackground(new java.awt.Color(59, 64, 64));
        jTable.setForeground(new java.awt.Color(255, 255, 255));
        jTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setFocusable(false);
        jTable.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable);

        back.setBackground(new java.awt.Color(0, 102, 102));
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.setFocusable(false);
        back.setPreferredSize(new java.awt.Dimension(180, 30));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(255, 255, 255));
        refresh.setForeground(new java.awt.Color(0, 102, 102));
        refresh.setText("Search / Refresh");
        refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refresh.setFocusable(false);
        refresh.setPreferredSize(new java.awt.Dimension(180, 30));
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        search_field.setBackground(new java.awt.Color(59, 64, 64));
        search_field.setForeground(new java.awt.Color(255, 255, 255));
        search_field.setPreferredSize(new java.awt.Dimension(180, 30));
        search_field.setRequestFocusEnabled(false);
        search_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_fieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout content_boxLayout = new javax.swing.GroupLayout(content_box);
        content_box.setLayout(content_boxLayout);
        content_boxLayout.setHorizontalGroup(
            content_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content_boxLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(content_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weatherlogs_label)
                    .addGroup(content_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(content_boxLayout.createSequentialGroup()
                            .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45))
        );
        content_boxLayout.setVerticalGroup(
            content_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content_boxLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(weatherlogs_label)
                .addGap(25, 25, 25)
                .addGroup(content_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(content_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(content_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void queryLogs() {
        try {           
            if (search_field.getText().equals("")) {
                DisplayTable();
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                String sql = "select * from rs_weatherlogs where username=? and date_time like ? or username=? and area like ? order by date_time desc";

                PreparedStatement psmt = conn.prepareStatement(sql);

                psmt.setString(1, RainScape.username);
                psmt.setString(2, "%" + search_field.getText() + "%");
                psmt.setString(3, RainScape.username);
                psmt.setString(4, "%" + search_field.getText() + "%");

                ResultSet rs = psmt.executeQuery();
                
                jTable.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_formWindowLostFocus

    private void search_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_fieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10)
            queryLogs();
    }//GEN-LAST:event_search_fieldKeyPressed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        queryLogs();
    }//GEN-LAST:event_refreshActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            BufferedImage img = ImageIO.read(new File("images/rainscape_logo2.png"));
            setIconImage(img);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the FlatLaf Dark look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Look and Feel Exception: " + e);
        }
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherLogsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JPanel content_box;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField search_field;
    private javax.swing.JLabel weatherlogs_label;
    // End of variables declaration//GEN-END:variables
}
