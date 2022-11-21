/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ezekiel
 */
public class Account {
    
    public static boolean login(boolean login, String username, String password) {
        
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
                JOptionPane.showMessageDialog(null, "Fill in the empty fields.");
            else
                if (rs.next()==true)
                    if (login && RainScape.access == false) {
                        // Login Success
                        RainScape.username = username;
                        MainGUI.main(null);
                        pass = true;
                    } else {
                        JOptionPane.showMessageDialog(null,"Username Already Exists.");
                    }
                else
                    if (login) {
                        JOptionPane.showMessageDialog(null,"Login Failed.");
                    } else {
                        create(username, password);
                        pass = true;
                    }
        } catch (HeadlessException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
        }
        return pass;
    }
    
    public static void create(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db","root","");
            String sql = "insert into rs_accounts value ( ?, ? )";
            
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt = conn.prepareStatement(sql);

            psmt.setString(1, username);
            psmt.setString(2, password);
            

            psmt.executeUpdate();
            
            sql = "insert into rs_preferences value ( ?, ?, ?, ? )";
            
            psmt = conn.prepareStatement(sql);
            
            psmt.setString(1, username);
            psmt.setString(2, MySQL.default_area);
            psmt.setString(3, MySQL.default_temp_scale);
            psmt.setBoolean(3, MySQL.default_mode);
            
            psmt.executeUpdate();
            
            RainScape.username = username;
            MainGUI.main(null);
            
            JOptionPane.showMessageDialog(null, "Account Created.");
        } catch (HeadlessException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
        }
    }
    
}
