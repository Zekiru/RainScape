/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rainscape;

import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/**
 *
 * @author ADMIN
 */
public class PreferencesGUI extends javax.swing.JFrame {

    /**
     * Creates new form preferences
     */
    public PreferencesGUI() {
        initComponents();
        
        username.setText(RainScape.username);
        address.setText(MySQL.defaultUserArea());
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
            String sql;

            sql = "select * from rs_preferences where username=? and temp_scale=?";

            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setString(1, RainScape.username);
            psmt.setString(2, "celsius");

            ResultSet rs = psmt.executeQuery();
            rs.next();

            if (!rs.next()) {
                celsius_checkbox.setEnabled(true);
                celsius_checkbox.setState(false);
                
                fahrenheit_checkbox.setEnabled(false);
                fahrenheit_checkbox.setState(true);
                System.out.println("F");
            } else {
                fahrenheit_checkbox.setEnabled(true);
                fahrenheit_checkbox.setState(false);

                celsius_checkbox.setEnabled(false);
                celsius_checkbox.setState(true);
                System.out.println("C");
            }
        } catch (Exception e) {
            // e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        username = new java.awt.TextField();
        address = new java.awt.TextField();
        dressadd = new javax.swing.JButton();
        passwordchange = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        checkbox1 = new java.awt.Checkbox();
        fahrenheit_checkbox = new java.awt.Checkbox();
        celsius_checkbox = new java.awt.Checkbox();
        changepassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(57, 91, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel1.setForeground(new java.awt.Color(231, 246, 242));
        jLabel1.setText("Username:");

        jLabel2.setForeground(new java.awt.Color(231, 246, 242));
        jLabel2.setText("Address:");

        jLabel3.setForeground(new java.awt.Color(231, 246, 242));
        jLabel3.setText("Password:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        username.setBackground(new java.awt.Color(231, 246, 242));

        address.setBackground(new java.awt.Color(231, 246, 242));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addressKeyTyped(evt);
            }
        });

        dressadd.setBackground(new java.awt.Color(185, 210, 210));
        dressadd.setForeground(new java.awt.Color(0, 0, 0));
        dressadd.setText("Change Address");
        dressadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dressaddActionPerformed(evt);
            }
        });

        passwordchange.setBackground(new java.awt.Color(185, 210, 210));
        passwordchange.setForeground(new java.awt.Color(0, 0, 0));
        passwordchange.setText("Change Password");
        passwordchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordchangeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(231, 246, 242));
        jLabel4.setText("©Rainscape2022");

        jLabel5.setForeground(new java.awt.Color(231, 246, 242));
        jLabel5.setText("Temperature Preference:");

        checkbox1.setLabel("checkbox1");
        checkbox1.setVisible(false);

        fahrenheit_checkbox.setForeground(new java.awt.Color(231, 246, 242));
        fahrenheit_checkbox.setLabel("°F");
        fahrenheit_checkbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fahrenheit_checkboxMouseClicked(evt);
            }
        });

        celsius_checkbox.setForeground(new java.awt.Color(231, 246, 242));
        celsius_checkbox.setLabel("°C");
        celsius_checkbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                celsius_checkboxMouseClicked(evt);
            }
        });

        changepassword.setBackground(new java.awt.Color(231, 246, 242));
        changepassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                changepasswordKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dressadd)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(changepassword))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordchange)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(celsius_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)
                                                .addComponent(fahrenheit_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5))))))
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(changepassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(passwordchange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fahrenheit_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(celsius_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dressadd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void changepasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changepasswordKeyTyped
        // TODO add your handling code here:
        if (changepassword.getText().equals("")) {
            passwordchange.setEnabled(false);
        } else {
            passwordchange.setEnabled(true);
        }
    }//GEN-LAST:event_changepasswordKeyTyped

    private void addressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyTyped
        // TODO add your handling code here:
        if (address.getText().equals("")) {
            dressadd.setEnabled(false);
        } else {
            dressadd.setEnabled(true);
        }
    }//GEN-LAST:event_addressKeyTyped

    private void passwordchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordchangeActionPerformed
        // TODO add your handling code here:
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db","root","");
            String sql ="Update rs_accounts set password=? where username=?";

            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,changepassword.getText());
            psmt.setString(2, RainScape.username);
            
            psmt.executeUpdate();
            
            changepassword.setText("");
            
            JOptionPane.showMessageDialog(null, "Password Changed.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_passwordchangeActionPerformed

    private void dressaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dressaddActionPerformed
        // TODO add your handling code here:
        try {
            String api_url = "https://weatherapi-com.p.rapidapi.com/forecast.json?q=" + address.getText();

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                .url(api_url)
                .get()
                // <editor-fold defaultstate="collapsed" desc="RainScape WeatherAPI Key">
                    .addHeader("X-RapidAPI-Key", "d2cd26e50fmshb105523acf4dea8p15c5eejsn5766f55f0f75")
                    .addHeader("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                    // </editor-fold>
                .build();

            Response response = client.newCall(request).execute();

            // Arranged Data Into Callable JSONObjects:
            JSONObject jsonAPI = new JSONObject(response.body().string());

            JSONObject jsonLocation = new JSONObject(jsonAPI.get("location").toString());
            
            String location = jsonLocation.getString("name");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db","root","");
            String sql ="Update rs_preferences set area=? where username=?";

            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, location);
            psmt.setString(2, RainScape.username);
            
            psmt.executeUpdate();
            
            WeatherAPI.fetch(RainScape.currentSearchArea());
            WeatherAPI.setValues();
            
            address.setText("");
            
            JOptionPane.showMessageDialog(null, "Area Changed.");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Area.");
        }
    }//GEN-LAST:event_dressaddActionPerformed

    private void celsius_checkboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_celsius_checkboxMouseClicked
        // TODO add your handling code here:
        if (!celsius_checkbox.getState()) {
            celsius_checkbox.setEnabled(false);
            fahrenheit_checkbox.setEnabled(true);
            fahrenheit_checkbox.setState(false);
        } else {
            celsius_checkbox.setEnabled(true);
            fahrenheit_checkbox.setEnabled(false);
            celsius_checkbox.setEnabled(true);
            celsius_checkbox.setState(false);
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
            String sql = "Update rs_preferences set temp_scale=? where username=?";

            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, "celsius");
            psmt.setString(2, RainScape.username);

            psmt.executeUpdate();

            WeatherAPI.fetch(RainScape.currentSearchArea());
            WeatherAPI.setValues();
            
            JOptionPane.showMessageDialog(null, "Temperature Scale Changed.");
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }//GEN-LAST:event_celsius_checkboxMouseClicked

    private void fahrenheit_checkboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fahrenheit_checkboxMouseClicked
        // TODO add your handling code here:
        if (!fahrenheit_checkbox.getState()) {
            fahrenheit_checkbox.setEnabled(false);
            celsius_checkbox.setEnabled(true);
            celsius_checkbox.setState(false);
        } else {
            fahrenheit_checkbox.setEnabled(true);
            celsius_checkbox.setEnabled(false);
            fahrenheit_checkbox.setEnabled(true);
            fahrenheit_checkbox.setState(false);
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
            String sql = "Update rs_preferences set temp_scale=? where username=?";

            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, "fahrenheit");
            psmt.setString(2, RainScape.username);

            psmt.executeUpdate();

            WeatherAPI.fetch(RainScape.currentSearchArea());
            WeatherAPI.setValues();
            
            JOptionPane.showMessageDialog(null, "Temperature Scale Changed.");
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }//GEN-LAST:event_fahrenheit_checkboxMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
                new PreferencesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField address;
    private java.awt.Checkbox celsius_checkbox;
    private javax.swing.JPasswordField changepassword;
    private java.awt.Checkbox checkbox1;
    private javax.swing.JButton dressadd;
    private java.awt.Checkbox fahrenheit_checkbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton passwordchange;
    private java.awt.TextField username;
    // End of variables declaration//GEN-END:variables
}
