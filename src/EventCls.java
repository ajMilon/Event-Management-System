import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class EventCls extends javax.swing.JFrame {

    Connection connect=null;
    String userNameF;
    String eventName;
    String venue;
    String date;
    int guestNo;
    String cake;
    int totalCost;
    String costA;
  
    public EventCls() {
        initComponents();
        connectDatabase();
    }
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
    
    public void getDataBooking(){
        userNameF=userNameF_txt.getText();
        eventName=eventName_cb.getSelectedItem().toString();
        venue=venue_cb.getSelectedItem().toString();
        date=date_dc.getDate().toString();
        guestNo=Integer.parseInt(person_cb.getSelectedItem().toString());
        cake=cake_txt.getText();
        //totalCost=Integer.parseInt(cost_txt.getText());
    }
    
    public void insertDataBooking(String userNameF,String eventName,String venue,String date,int guestNo,String cake,int totalCost){
        PreparedStatement ps1;
        String query2="Insert Into event(UserName,EventName,venue,Date,NoOfGuest,Cake,Cost) values(?,?,?,?,?,?,?)";
        try {
            ps1=connect.prepareStatement(query2);
            ps1.setString(1, userNameF);
            ps1.setString(2, eventName);
            ps1.setString(3, venue);
            ps1.setString(4, date);
            ps1.setInt(5, guestNo);
            ps1.setString(6, cake);
            ps1.setInt(7, totalCost);
            
            ps1.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Booking Confirmed", "Successful", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(EventCls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void calculateCost() 
    {
      
        
        String query5="SELECT cost From payment where person=?";
        
        PreparedStatement ps2;
        try {
            ps2 = connect.prepareStatement(query5);
            ps2.setInt(1, guestNo);
            ResultSet rs2=ps2.executeQuery();
            while(rs2.next()){
                 costA=rs2.getString("cost");
                cost_txt.setText(costA);
                totalCost=Integer.parseInt(costA);
                
            }
            
            
          
            
        } catch (SQLException ex) {
            Logger.getLogger(EventCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
            
            
            
            
            
            

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        eventName_lbl = new javax.swing.JLabel();
        eventName_cb = new javax.swing.JComboBox<>();
        place_lbl = new javax.swing.JLabel();
        venue_cb = new javax.swing.JComboBox<>();
        guest_lbl = new javax.swing.JLabel();
        cake_lbl = new javax.swing.JLabel();
        person_cb = new javax.swing.JComboBox<>();
        cake_txt = new javax.swing.JTextField();
        showCost_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userNameF_txt = new javax.swing.JTextField();
        cost_txt = new javax.swing.JTextField();
        conBooking_btn = new javax.swing.JButton();
        cancelBooking_btn = new javax.swing.JButton();
        date_lbl = new javax.swing.JLabel();
        date_dc = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 26, 64));

        eventName_lbl.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        eventName_lbl.setText("Event Name");

        eventName_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Birthday", "wedding", "party", "Anniversary", "Conferences", "Reunion", "" }));

        place_lbl.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        place_lbl.setText("Venue");

        venue_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ICCB", "BashunDhara", "KIB", "Firmgate", "Sea Shell", "Uttara", "IEB", "Shahbag", "TCB", "KawranBazar", "" }));
        venue_cb.setMinimumSize(new java.awt.Dimension(65, 20));
        venue_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venue_cbActionPerformed(evt);
            }
        });

        guest_lbl.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        guest_lbl.setText("No of guest");

        cake_lbl.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        cake_lbl.setText("cake");

        person_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000" }));

        cake_txt.setBackground(new java.awt.Color(204, 204, 204));
        cake_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cake_txtActionPerformed(evt);
            }
        });

        showCost_btn.setBackground(new java.awt.Color(102, 255, 255));
        showCost_btn.setText("Show Cost");
        showCost_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCost_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("User Name");

        userNameF_txt.setBackground(new java.awt.Color(204, 204, 204));
        userNameF_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameF_txtActionPerformed(evt);
            }
        });

        cost_txt.setBackground(new java.awt.Color(153, 153, 153));
        cost_txt.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        cost_txt.setText("Tk:");

        conBooking_btn.setBackground(new java.awt.Color(102, 0, 0));
        conBooking_btn.setText("Confirm Booking");
        conBooking_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conBooking_btnActionPerformed(evt);
            }
        });

        cancelBooking_btn.setBackground(new java.awt.Color(102, 0, 0));
        cancelBooking_btn.setText("Home");
        cancelBooking_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBooking_btnActionPerformed(evt);
            }
        });

        date_lbl.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        date_lbl.setText("Date");

        date_dc.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(userNameF_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(eventName_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(eventName_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(place_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(venue_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(date_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(date_dc, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(guest_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(person_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cake_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(cake_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(showCost_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(cost_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(conBooking_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(cancelBooking_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameF_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(eventName_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eventName_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(place_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(venue_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(date_lbl))
                    .addComponent(date_dc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(guest_lbl))
                    .addComponent(person_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(cake_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cake_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(showCost_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cost_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(conBooking_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cancelBooking_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cake_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cake_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cake_txtActionPerformed

    private void showCost_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCost_btnActionPerformed
       
       getDataBooking();
            calculateCost();
      
    }//GEN-LAST:event_showCost_btnActionPerformed

    private void conBooking_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conBooking_btnActionPerformed
         getDataBooking();
        insertDataBooking(userNameF,eventName,venue,date,guestNo,cake,totalCost);
        
        
    }//GEN-LAST:event_conBooking_btnActionPerformed

    private void cancelBooking_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBooking_btnActionPerformed
        Home_page home=new Home_page();
        home.setVisible(true);
                
    }//GEN-LAST:event_cancelBooking_btnActionPerformed

    private void userNameF_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameF_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameF_txtActionPerformed

    private void venue_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venue_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_venue_cbActionPerformed

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
            java.util.logging.Logger.getLogger(EventCls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventCls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventCls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventCls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventCls().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cake_lbl;
    private javax.swing.JTextField cake_txt;
    private javax.swing.JButton cancelBooking_btn;
    private javax.swing.JButton conBooking_btn;
    private javax.swing.JTextField cost_txt;
    private com.toedter.calendar.JDateChooser date_dc;
    private javax.swing.JLabel date_lbl;
    private javax.swing.JComboBox<String> eventName_cb;
    private javax.swing.JLabel eventName_lbl;
    private javax.swing.JLabel guest_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> person_cb;
    private javax.swing.JLabel place_lbl;
    private javax.swing.JButton showCost_btn;
    private javax.swing.JTextField userNameF_txt;
    private javax.swing.JComboBox<String> venue_cb;
    // End of variables declaration//GEN-END:variables
}
