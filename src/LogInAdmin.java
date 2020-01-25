
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LogInAdmin extends javax.swing.JFrame {

    String userA;
    String passwordA;
     Connection connect=null;
      PreparedStatement psl=null;
    
  
    public LogInAdmin() {
        initComponents();
        connectDatabase();
    }
    
    public void getDataAdmin(){
        userA=userA_txt.getText();
        passwordA=passwordA_txt.getText();
    }

    @SuppressWarnings("unchecked")
     public void connectDatabase(){
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/event_db","root","");
            System.out.println("Successfully Connected to Mysql");

        }catch(Exception e){
            System.out.println("Not Connected..");
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userA_txt = new javax.swing.JTextField();
        passwordA_txt = new javax.swing.JPasswordField();
        loginA_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(userA_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 310, 30));
        getContentPane().add(passwordA_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 310, 30));

        loginA_btn.setBackground(new java.awt.Color(0, 102, 102));
        loginA_btn.setText("Log In");
        loginA_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginA_btnActionPerformed(evt);
            }
        });
        getContentPane().add(loginA_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 110, 40));

        jLabel3.setBackground(new java.awt.Color(0, 153, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(247, 12, 12));
        jLabel3.setText("User Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 130, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(253, 14, 14));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 120, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(251, 8, 8));
        jLabel4.setText("      Login  as  Admin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 470, 50));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 100, 40));

        jLabel1.setBackground(new java.awt.Color(102, 0, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background.jpg"))); // NOI18N
        jLabel1.setText("User Name ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-810, -470, 1730, 1050));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginA_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginA_btnActionPerformed
        
        getDataAdmin();
      /*  if(userA.equals("admin")&& passwordA.equals("admin"))
        {
            EventDetails eventdetails= new EventDetails();
            eventdetails.setVisible(true);
        }
        else{
             JOptionPane.showMessageDialog(null, "Log In Error.Please enter valid details", "Error", JOptionPane.ERROR_MESSAGE);
        }
        */
      String query4 = "SELECT UserNameA,PasswordA FROM admin WHERE UserNameA =? AND PasswordA =?";
        try {
            psl=connect.prepareStatement(query4);
             psl.setString(1, userA);
            psl.setString(2, passwordA);
            ResultSet result=psl.executeQuery();
              if(result.next()){
                   EventDetails eventdetails= new EventDetails();
                   eventdetails.setVisible(true);
                   this.dispose();
              }
              else {
                   JOptionPane.showMessageDialog(null, "Log In Error.Please enter valid details", "Error", JOptionPane.ERROR_MESSAGE);
                  
              }
                
                
                
                
                
                
            
        } catch (SQLException ex) {
            Logger.getLogger(LogInAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_loginA_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Home_page hm = new Home_page ();
        hm.setVisible(true);
        this.dispose();
      
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginA_btn;
    private javax.swing.JPasswordField passwordA_txt;
    private javax.swing.JTextField userA_txt;
    // End of variables declaration//GEN-END:variables
}
