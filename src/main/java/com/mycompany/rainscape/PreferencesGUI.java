/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rainscape;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
        bg_img.setIcon(MainGUI.background_image.getIcon());
        
        MySQL.setPreferences();
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
        banner_bg = new javax.swing.JPanel();
        bg_img = new javax.swing.JLabel();
        preferences_box = new javax.swing.JPanel();
        username_label = new javax.swing.JLabel();
        default_area = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        defaultarea_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        address_change = new javax.swing.JButton();
        password_change = new javax.swing.JButton();
        tempscale_label = new javax.swing.JLabel();
        fahrenheit_checkbox = new java.awt.Checkbox();
        celsius_checkbox = new java.awt.Checkbox();
        delete_account = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preferences");
        setResizable(false);
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
        content_box.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        banner_bg.setBackground(new java.awt.Color(225, 230, 236));
        banner_bg.setPreferredSize(new java.awt.Dimension(600, 150));

        javax.swing.GroupLayout banner_bgLayout = new javax.swing.GroupLayout(banner_bg);
        banner_bg.setLayout(banner_bgLayout);
        banner_bgLayout.setHorizontalGroup(
            banner_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_img, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        banner_bgLayout.setVerticalGroup(
            banner_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_img, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        content_box.add(banner_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        preferences_box.setBackground(new java.awt.Color(59, 64, 64));
        preferences_box.setPreferredSize(new java.awt.Dimension(500, 390));

        username_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        username_label.setForeground(new java.awt.Color(231, 246, 242));
        username_label.setText("Username:");

        default_area.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        default_area.setForeground(new java.awt.Color(255, 255, 255));
        default_area.setText("[Area]");

        username.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("[Username]");

        defaultarea_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        defaultarea_label.setForeground(new java.awt.Color(231, 246, 242));
        defaultarea_label.setText("Default Area:");

        password_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        password_label.setForeground(new java.awt.Color(231, 246, 242));
        password_label.setText("Password");

        address_change.setBackground(new java.awt.Color(91, 91, 91));
        address_change.setForeground(new java.awt.Color(255, 255, 255));
        address_change.setText("Edit");
        address_change.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        address_change.setFocusable(false);
        address_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_changeActionPerformed(evt);
            }
        });

        password_change.setBackground(new java.awt.Color(91, 91, 91));
        password_change.setForeground(new java.awt.Color(255, 255, 255));
        password_change.setText("Edit");
        password_change.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        password_change.setFocusable(false);
        password_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_changeActionPerformed(evt);
            }
        });

        tempscale_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tempscale_label.setForeground(new java.awt.Color(231, 246, 242));
        tempscale_label.setText("Temperature Scale:");

        fahrenheit_checkbox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fahrenheit_checkbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fahrenheit_checkbox.setForeground(new java.awt.Color(231, 246, 242));
        fahrenheit_checkbox.setLabel("°F");
        fahrenheit_checkbox.setPreferredSize(new java.awt.Dimension(38, 25));
        fahrenheit_checkbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fahrenheit_checkboxMouseClicked(evt);
            }
        });

        celsius_checkbox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        celsius_checkbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        celsius_checkbox.setForeground(new java.awt.Color(231, 246, 242));
        celsius_checkbox.setLabel("°C");
        celsius_checkbox.setPreferredSize(new java.awt.Dimension(40, 25));
        celsius_checkbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                celsius_checkboxMouseClicked(evt);
            }
        });

        delete_account.setBackground(new java.awt.Color(255, 102, 102));
        delete_account.setForeground(new java.awt.Color(255, 255, 255));
        delete_account.setText("Delete Account");
        delete_account.setToolTipText("");
        delete_account.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_account.setFocusable(false);
        delete_account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_accountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout preferences_boxLayout = new javax.swing.GroupLayout(preferences_box);
        preferences_box.setLayout(preferences_boxLayout);
        preferences_boxLayout.setHorizontalGroup(
            preferences_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preferences_boxLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(preferences_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(preferences_boxLayout.createSequentialGroup()
                        .addComponent(username_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete_account))
                    .addComponent(default_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preferences_boxLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(preferences_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preferences_boxLayout.createSequentialGroup()
                                .addComponent(tempscale_label)
                                .addGap(183, 183, 183)
                                .addComponent(celsius_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(fahrenheit_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preferences_boxLayout.createSequentialGroup()
                                .addComponent(password_label)
                                .addGap(292, 292, 292)
                                .addComponent(password_change))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preferences_boxLayout.createSequentialGroup()
                                .addComponent(defaultarea_label)
                                .addGap(266, 266, 266)
                                .addComponent(address_change)))))
                .addGap(30, 30, 30))
        );
        preferences_boxLayout.setVerticalGroup(
            preferences_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preferences_boxLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(preferences_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username_label)
                    .addComponent(delete_account, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username)
                .addGap(50, 50, 50)
                .addGroup(preferences_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defaultarea_label)
                    .addComponent(address_change, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(default_area)
                .addGap(50, 50, 50)
                .addGroup(preferences_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_label)
                    .addComponent(password_change, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(preferences_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tempscale_label)
                    .addComponent(celsius_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fahrenheit_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        content_box.add(preferences_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        back.setBackground(new java.awt.Color(0, 102, 102));
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.setFocusable(false);
        back.setPreferredSize(new java.awt.Dimension(150, 40));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        content_box.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, 500, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(content_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content_box, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void celsius_checkboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_celsius_checkboxMouseClicked
        // TODO add your handling code here:
        MySQL.changeTempScale(true);
    }//GEN-LAST:event_celsius_checkboxMouseClicked

    private void fahrenheit_checkboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fahrenheit_checkboxMouseClicked
        // TODO add your handling code here:
        MySQL.changeTempScale(false);
    }//GEN-LAST:event_fahrenheit_checkboxMouseClicked

    private void password_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_changeActionPerformed
        // TODO add your handling code here:
        MySQL.changePassword();
    }//GEN-LAST:event_password_changeActionPerformed

    private void address_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_changeActionPerformed
        // TODO add your handling code here:
        MySQL.changeDefaultArea();
    }//GEN-LAST:event_address_changeActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_formWindowLostFocus

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void delete_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_accountActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Delete Your Account?") == 0) {
            MySQL.deleteAccount();
            JOptionPane.showMessageDialog(null, "Account Deleted.");
            System.exit(0);
        } else {
            main(null);
        }
    }//GEN-LAST:event_delete_accountActionPerformed

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
    private javax.swing.JButton address_change;
    private javax.swing.JButton back;
    private javax.swing.JPanel banner_bg;
    private javax.swing.JLabel bg_img;
    public static java.awt.Checkbox celsius_checkbox;
    private javax.swing.JPanel content_box;
    public static javax.swing.JLabel default_area;
    private javax.swing.JLabel defaultarea_label;
    private javax.swing.JButton delete_account;
    public static java.awt.Checkbox fahrenheit_checkbox;
    private javax.swing.JButton password_change;
    private javax.swing.JLabel password_label;
    private javax.swing.JPanel preferences_box;
    private javax.swing.JLabel tempscale_label;
    public static javax.swing.JLabel username;
    private javax.swing.JLabel username_label;
    // End of variables declaration//GEN-END:variables
}
