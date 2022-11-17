/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rainscape;

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
        this.setLocationRelativeTo(null);
        content_box_scroll.getVerticalScrollBar().setUnitIncrement(16); // Scroll Speed
        
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
        content_box_bg = new javax.swing.JPanel();
        logout = new javax.swing.JButton();
        mainBanner = new javax.swing.JPanel();
        basicforecast_box = new javax.swing.JPanel();
        status = new javax.swing.JLabel();
        temp = new javax.swing.JLabel();
        localdate = new javax.swing.JLabel();
        location = new javax.swing.JLabel();
        menuBar = new javax.swing.JPanel();
        localtime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RainScape");
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 675));

        content_box_scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        content_box_scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        content_box_scroll.setFocusable(false);
        content_box_scroll.setPreferredSize(new java.awt.Dimension(960, 540));

        content_box_bg.setBackground(new java.awt.Color(225, 230, 236));
        content_box_bg.setForeground(new java.awt.Color(0, 0, 0));

        logout.setBackground(new java.awt.Color(0, 204, 204));
        logout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Log Out");
        logout.setBorder(null);
        logout.setFocusable(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        mainBanner.setBackground(new java.awt.Color(153, 204, 255));

        basicforecast_box.setBackground(new java.awt.Color(51, 51, 51));
        basicforecast_box.setForeground(new java.awt.Color(51, 51, 51));
        basicforecast_box.setFocusable(false);

        status.setBackground(new java.awt.Color(237, 249, 244));
        status.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        status.setForeground(new java.awt.Color(237, 249, 244));
        status.setText("XXXXXX XXXXXX");

        temp.setBackground(new java.awt.Color(237, 249, 244));
        temp.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        temp.setForeground(new java.awt.Color(237, 249, 244));
        temp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp.setText("XX°");

        localdate.setBackground(new java.awt.Color(237, 249, 244));
        localdate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        localdate.setForeground(new java.awt.Color(237, 249, 244));
        localdate.setText("XX/XX/XXXX");

        location.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        location.setForeground(new java.awt.Color(237, 249, 244));
        location.setText("XXXXXXXXXXX, XXXXXXXXXXX");

        javax.swing.GroupLayout basicforecast_boxLayout = new javax.swing.GroupLayout(basicforecast_box);
        basicforecast_box.setLayout(basicforecast_boxLayout);
        basicforecast_boxLayout.setHorizontalGroup(
            basicforecast_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basicforecast_boxLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(basicforecast_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(localdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        basicforecast_boxLayout.setVerticalGroup(
            basicforecast_boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicforecast_boxLayout.createSequentialGroup()
                .addGap(28, 28, 28)
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
                .addContainerGap(684, Short.MAX_VALUE))
        );
        mainBannerLayout.setVerticalGroup(
            mainBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainBannerLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(basicforecast_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        menuBar.setBackground(new java.awt.Color(0, 51, 51));

        localtime.setBackground(new java.awt.Color(237, 249, 244));
        localtime.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        localtime.setForeground(new java.awt.Color(237, 249, 244));
        localtime.setText("XX:XX:XX XX");

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(localtime, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(localtime, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout content_box_bgLayout = new javax.swing.GroupLayout(content_box_bg);
        content_box_bg.setLayout(content_box_bgLayout);
        content_box_bgLayout.setHorizontalGroup(
            content_box_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_box_bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        content_box_bgLayout.setVerticalGroup(
            content_box_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_box_bgLayout.createSequentialGroup()
                .addComponent(mainBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 486, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        content_box_scroll.setViewportView(content_box_bg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(content_box_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(content_box_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        LoginGUI.main(null);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

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
    private javax.swing.JPanel content_box_bg;
    private javax.swing.JScrollPane content_box_scroll;
    public static javax.swing.JLabel localdate;
    public static javax.swing.JLabel localtime;
    public static javax.swing.JLabel location;
    private javax.swing.JButton logout;
    private javax.swing.JPanel mainBanner;
    private javax.swing.JPanel menuBar;
    public static javax.swing.JLabel status;
    public static javax.swing.JLabel temp;
    // End of variables declaration//GEN-END:variables
}
