/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rainscape;

import java.awt.Color;

/**
 *
 * @author Ezekiel
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        content_box_scroll.getVerticalScrollBar().setUnitIncrement(16); // Scroll Speed
        sidebar_box.setVisible(false);
        
        WeatherAPI.fetch(WeatherAPI.currentUserArea());
        
        WeatherAPI.setValues();
        DateTime.setValues();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content_box_scroll = new javax.swing.JScrollPane();
        content_box = new javax.swing.JPanel();
        mainBanner = new javax.swing.JPanel();
        basicforecast_box = new javax.swing.JPanel();
        status = new javax.swing.JLabel();
        temp = new javax.swing.JLabel();
        localdate = new javax.swing.JLabel();
        location = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        menuBar = new javax.swing.JPanel();
        localtime = new javax.swing.JLabel();
        searchbar_bg = new javax.swing.JPanel();
        searchbar = new javax.swing.JTextField();
        searchbutton = new javax.swing.JButton();
        hamburger_box = new javax.swing.JPanel();
        line1 = new javax.swing.JPanel();
        line2 = new javax.swing.JPanel();
        line3 = new javax.swing.JPanel();
        sidebar_box = new javax.swing.JPanel();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RainScape");
        setMaximumSize(new java.awt.Dimension(1200, 675));
        setMinimumSize(new java.awt.Dimension(1200, 675));
        setName(""); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 675));

        content_box_scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        content_box_scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        content_box_scroll.setFocusable(false);
        content_box_scroll.setPreferredSize(new java.awt.Dimension(1200, 675));
        content_box_scroll.setRequestFocusEnabled(false);

        content_box.setBackground(new java.awt.Color(51, 51, 51));
        content_box.setForeground(new java.awt.Color(0, 0, 0));
        content_box.setPreferredSize(new java.awt.Dimension(1188, 925));

        mainBanner.setBackground(new java.awt.Color(153, 204, 255));

        basicforecast_box.setBackground(new java.awt.Color(51, 51, 51));
        basicforecast_box.setForeground(new java.awt.Color(51, 51, 51));
        basicforecast_box.setFocusable(false);

        status.setBackground(new java.awt.Color(237, 249, 244));
        status.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        status.setForeground(new java.awt.Color(237, 249, 244));
        status.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        status.setText("Xxxxx xxxxxx");

        temp.setBackground(new java.awt.Color(237, 249, 244));
        temp.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        temp.setForeground(new java.awt.Color(237, 249, 244));
        temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp.setText("XX.X°");

        localdate.setBackground(new java.awt.Color(237, 249, 244));
        localdate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        localdate.setForeground(new java.awt.Color(237, 249, 244));
        localdate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        localdate.setText("XX/XX/XXXX");

        location.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        location.setForeground(new java.awt.Color(237, 249, 244));
        location.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        location.setText("XXXXXX, XXXXXX");

        javax.swing.GroupLayout basicforecast_boxLayout = new javax.swing.GroupLayout(basicforecast_box);
        basicforecast_box.setLayout(basicforecast_boxLayout);
        basicforecast_boxLayout.setHorizontalGroup(
            basicforecast_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basicforecast_boxLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(basicforecast_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(location, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(localdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        basicforecast_boxLayout.setVerticalGroup(
            basicforecast_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicforecast_boxLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(basicforecast_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basicforecast_boxLayout.createSequentialGroup()
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainBannerLayout = new javax.swing.GroupLayout(mainBanner);
        mainBanner.setLayout(mainBannerLayout);
        mainBannerLayout.setHorizontalGroup(
            mainBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainBannerLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(basicforecast_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainBannerLayout.setVerticalGroup(
            mainBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainBannerLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(basicforecast_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        body.setBackground(new java.awt.Color(225, 230, 236));
        body.setForeground(new java.awt.Color(225, 230, 236));
        body.setPreferredSize(new java.awt.Dimension(1188, 675));

        menuBar.setBackground(new java.awt.Color(0, 51, 51));

        localtime.setBackground(new java.awt.Color(237, 249, 244));
        localtime.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        localtime.setForeground(new java.awt.Color(237, 249, 244));
        localtime.setText("XX:XX:XX XX");

        searchbar_bg.setBackground(new java.awt.Color(16, 27, 25));
        searchbar_bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        searchbar_bg.setMaximumSize(new java.awt.Dimension(322, 44));
        searchbar_bg.setMinimumSize(new java.awt.Dimension(322, 44));
        searchbar_bg.setPreferredSize(new java.awt.Dimension(380, 22));

        searchbar.setBackground(new java.awt.Color(16, 27, 25));
        searchbar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchbar.setForeground(new java.awt.Color(255, 255, 255));
        searchbar.setBorder(null);
        searchbar.setCaretColor(new java.awt.Color(255, 255, 255));
        searchbar.setOpaque(true);
        searchbar.setSelectionColor(new java.awt.Color(0, 153, 153));
        searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchbarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout searchbar_bgLayout = new javax.swing.GroupLayout(searchbar_bg);
        searchbar_bg.setLayout(searchbar_bgLayout);
        searchbar_bgLayout.setHorizontalGroup(
            searchbar_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchbar_bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbar, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );
        searchbar_bgLayout.setVerticalGroup(
            searchbar_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchbar)
        );

        searchbutton.setBackground(new java.awt.Color(0, 204, 204));
        searchbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchbutton.setForeground(new java.awt.Color(255, 255, 255));
        searchbutton.setText("Search");
        searchbutton.setBorder(null);
        searchbutton.setNextFocusableComponent(searchbar);
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        hamburger_box.setBackground(new java.awt.Color(0, 0, 0));
        hamburger_box.setForeground(new java.awt.Color(0, 0, 0));
        hamburger_box.setOpaque(false);
        hamburger_box.setPreferredSize(new java.awt.Dimension(36, 35));
        hamburger_box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hamburger_boxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hamburger_boxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hamburger_boxMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hamburger_boxMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hamburger_boxMouseReleased(evt);
            }
        });

        line1.setBackground(new java.awt.Color(255, 255, 255));
        line1.setForeground(new java.awt.Color(255, 255, 255));
        line1.setPreferredSize(new java.awt.Dimension(22, 5));

        javax.swing.GroupLayout line1Layout = new javax.swing.GroupLayout(line1);
        line1.setLayout(line1Layout);
        line1Layout.setHorizontalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        line1Layout.setVerticalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        line2.setBackground(new java.awt.Color(255, 255, 255));
        line2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout line2Layout = new javax.swing.GroupLayout(line2);
        line2.setLayout(line2Layout);
        line2Layout.setHorizontalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );
        line2Layout.setVerticalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        line3.setBackground(new java.awt.Color(255, 255, 255));
        line3.setForeground(new java.awt.Color(255, 255, 255));
        line3.setPreferredSize(new java.awt.Dimension(32, 5));

        javax.swing.GroupLayout line3Layout = new javax.swing.GroupLayout(line3);
        line3.setLayout(line3Layout);
        line3Layout.setHorizontalGroup(
            line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        line3Layout.setVerticalGroup(
            line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout hamburger_boxLayout = new javax.swing.GroupLayout(hamburger_box);
        hamburger_box.setLayout(hamburger_boxLayout);
        hamburger_boxLayout.setHorizontalGroup(
            hamburger_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hamburger_boxLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(hamburger_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(line2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(line3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        hamburger_boxLayout.setVerticalGroup(
            hamburger_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hamburger_boxLayout.createSequentialGroup()
                .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(line3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(localtime, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270)
                .addComponent(searchbar_bg, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hamburger_box, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(localtime, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hamburger_box, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(searchbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchbar_bg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidebar_box.setBackground(new java.awt.Color(255, 255, 255));
        sidebar_box.setPreferredSize(new java.awt.Dimension(180, 620));

        logout.setBackground(new java.awt.Color(0, 204, 204));
        logout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Log Out");
        logout.setBorder(null);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logout.setFocusable(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebar_boxLayout = new javax.swing.GroupLayout(sidebar_box);
        sidebar_box.setLayout(sidebar_boxLayout);
        sidebar_boxLayout.setHorizontalGroup(
            sidebar_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebar_boxLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        sidebar_boxLayout.setVerticalGroup(
            sidebar_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebar_boxLayout.createSequentialGroup()
                .addContainerGap(542, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(118, 1008, Short.MAX_VALUE)
                .addComponent(sidebar_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                .addComponent(menuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(sidebar_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout content_boxLayout = new javax.swing.GroupLayout(content_box);
        content_box.setLayout(content_boxLayout);
        content_boxLayout.setHorizontalGroup(
            content_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        content_boxLayout.setVerticalGroup(
            content_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_boxLayout.createSequentialGroup()
                .addComponent(mainBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        content_box_scroll.setViewportView(content_box);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content_box_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(content_box_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void searchProcess(String area) {
        if (area.equals("")) {
            WeatherAPI.current_area = "";
            WeatherAPI.fetch(WeatherAPI.currentUserArea());
        } else if (WeatherAPI.current_area.equals(area) == false){
            WeatherAPI.current_area = area;
            WeatherAPI.fetch(WeatherAPI.currentUserArea());
        }
        
        WeatherAPI.setValues();
    }
    
    private void hamburgerToggle(boolean active) {
        if (active) {
            line1.setBackground(Color.lightGray);
            line2.setBackground(Color.lightGray);
            line3.setBackground(Color.lightGray);
        } else {
            line1.setBackground(Color.white);
            line2.setBackground(Color.white);
            line3.setBackground(Color.white);
        }
    }
    
    int x = 0;
    private void sidebarToggle() {
        if (sidebar_box.isVisible()) {
            sidebar_box.setVisible(false);
        } else if (!sidebar_box.isVisible()) {
            sidebar_box.setVisible(true);
        }
    }
    
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        LoginGUI.main(null);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void searchbarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            searchProcess(searchbar.getText());
        }
    }//GEN-LAST:event_searchbarKeyPressed

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        // TODO add your handling code here:
        searchProcess(searchbar.getText());
        searchbutton.nextFocus();
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void hamburger_boxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hamburger_boxMouseEntered
        // TODO add your handling code here:
        hamburgerToggle(true);
    }//GEN-LAST:event_hamburger_boxMouseEntered

    private void hamburger_boxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hamburger_boxMouseExited
        // TODO add your handling code here:
        hamburgerToggle(false);
    }//GEN-LAST:event_hamburger_boxMouseExited

    private void hamburger_boxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hamburger_boxMousePressed
        // TODO add your handling code here:
        hamburgerToggle(false);
    }//GEN-LAST:event_hamburger_boxMousePressed

    private void hamburger_boxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hamburger_boxMouseReleased
        // TODO add your handling code here:
        hamburgerToggle(true);
    }//GEN-LAST:event_hamburger_boxMouseReleased

    private void hamburger_boxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hamburger_boxMouseClicked
        // TODO add your handling code here:
        sidebarToggle();
    }//GEN-LAST:event_hamburger_boxMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        
        //</editor-fold>
        
        RainScape.access = true;
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basicforecast_box;
    private javax.swing.JPanel body;
    private javax.swing.JPanel content_box;
    private javax.swing.JScrollPane content_box_scroll;
    private javax.swing.JPanel hamburger_box;
    private javax.swing.JPanel line1;
    private javax.swing.JPanel line2;
    private javax.swing.JPanel line3;
    public static javax.swing.JLabel localdate;
    public static javax.swing.JLabel localtime;
    public static javax.swing.JLabel location;
    private javax.swing.JButton logout;
    private javax.swing.JPanel mainBanner;
    private javax.swing.JPanel menuBar;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbar_bg;
    private javax.swing.JButton searchbutton;
    private javax.swing.JPanel sidebar_box;
    public static javax.swing.JLabel status;
    public static javax.swing.JLabel temp;
    // End of variables declaration//GEN-END:variables
}
