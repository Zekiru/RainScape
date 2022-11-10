/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.rainscape;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ezekiel
 */
public class RainScape {

    public static void main(String[] args) {
        System.out.println("Running Project...");
        try {
            LoginGUI.main(args);
            System.out.println("Project Launched.");
        } catch (Exception e) {
            System.out.println("Project Not Launched.");
            System.out.println("Exception: " + e);
        }
    }
    
    public static boolean loginProcess(boolean login, String username, String password) {
        boolean pass = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db","root","");
            String sql;
            
            if (login)
                sql ="select * from rs_accounts where username=? and password=?";
            else
                sql ="select * from rs_accounts where username=?";
            
            PreparedStatement psmt = conn.prepareStatement(sql);
            
            if (login)
                psmt.setString(2, password);
            
            psmt.setString(1, username);
            
            ResultSet rs = psmt.executeQuery();
            
            if (username.equals("") || password.equals(""))
                JOptionPane.showMessageDialog(null,"Fill In The Empty Fields.");
            else
                if (rs.next()==true)
                    if (login) {
                        // Call next GUI here:
                        MainGUI.main(null);
                        pass = true;
                    } else {
                        JOptionPane.showMessageDialog(null,"Username Already Exists.");
                    }
                else
                    if (login) {
                        JOptionPane.showMessageDialog(null,"Login Failed.");
                    } else {
                        createAccount(username, password);
                    }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        if (pass)
            return true;
        else
            return false;
    }
    
    public static void createAccount(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db","root","");
            String sql = "insert into rs_accounts value ( ?, ? )";
            
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt = conn.prepareStatement(sql);

            psmt.setString(1, username);
            psmt.setString(2, password);

            psmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Account Created.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
