/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rainscape;

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
public class MySQL {
    public static String default_area = "Manila"; // Default New Account Area
    public static String default_temp_scale = "celsius"; // Default New Account Area
    public static boolean default_mode = false; // Default New Account Area
    
    public static String defaultUserArea() {
        String user = RainScape.username;
        String area = default_area;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
            String sql;

            sql = "select * from rs_preferences where username=?";

            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setString(1, user);

            ResultSet rs = psmt.executeQuery();
            rs.next();

            area = rs.getString("area");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception: " + e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
        }
        return area;
    }
    
    public static void fetch() {
        String user = RainScape.username;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainscape_db", "root", "");
            String sql;

            sql = "select * from rs_preferences where username=?";

            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setString(1, user);

            ResultSet rs = psmt.executeQuery();
            rs.next();

            RainScape.temp_scale = rs.getString("temp_scale");
            RainScape.dark_mode = rs.getBoolean("dark_mode");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception: " + e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Not Connected to the SQL Server.");
        }
    }
}
