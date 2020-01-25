import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;




public class ClientRegistration extends javax.swing.JFrame {
    
   Connection connect=null;
    
  
    
    
    String firstName;
    String lastName;
    String email;
    int    phoneNum;
    int    numLen;
    String userName;
    String password;
    String conPassword;
    String dob;
    String address;
     

    
    public ClientRegistration() {
        
     
        initComponents();
        connectDatabase();
        
    }
    public void connectDatabase(){
        try{

            connect = DriverManager.getConnection("jdbc:mysql://localhost/event_db","root","");
            System.out.println("Successfully Connected to Mysql");

        }catch(Exception e){
            System.out.println("Not Connected..");
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    
    public void getInfo(){
        firstName=firstName_txt.getText();
        lastName=lastName_txt.getText();
        email=email_txt.getText();
       
        phoneNum=Integer.parseInt(phoneNum_txt.getText());
        
         numLen=phoneNum_txt.getText().length();
        userName=userName_txt.getText();
        password=password_txt.getText();
        conPassword=conPassword_txt.getText();
        dob=dob_txt.getDate().toString();
        address=address_txtArea.getText();
        
      
        
        
        
        
    }
    
    public void insertData(String firstName,String lastName,int phoneNum,String email,String userName,String password,String dob,String address){
       
        try{
            String query1 = "INSERT INTO client(FirstName,LastName,PhoneNo,Email,UserName,Password,DateOfBirth,Address) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pStatement=connect.prepareStatement(query1);
            pStatement.setString(1, firstName);
            pStatement.setString(2, lastName);
            pStatement.setInt(3, phoneNum);
            pStatement.setString(4, email);
            pStatement.setString(5, userName);
            pStatement.setString(6, password);
            pStatement.setString(7, dob);
            pStatement.setString(8, address);
            
           
            pStatement.executeUpdate();
            
           
            
            
        }catch(Exception e){
            System.out.println("Error in inserting");
            e.printStackTrace();
        }
    }
    
     
    
    
       
            
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        resisterForm_Panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        form = new javax.swing.JPanel();
        firstName_lbl = new javax.swing.JLabel();
        firstName_txt = new javax.swing.JTextField();
        lastName_lbl = new javax.swing.JLabel();
        lastName_txt = new javax.swing.JTextField();
        email_lbl = new javax.swing.JLabel();
        userName_lbl = new javax.swing.JLabel();
        conPassword_lbl = new javax.swing.JLabel();
        dob_lbl = new javax.swing.JLabel();
        email_txt = new javax.swing.JTextField();
        password_txt = new javax.swing.JPasswordField();
        conPassword_txt = new javax.swing.JPasswordField();
        address_lbl = new javax.swing.JLabel();
        dob_txt = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        address_txtArea = new javax.swing.JTextArea();
        cancel_btn = new javax.swing.JButton();
        register_button = new javax.swing.JButton();
        login_lbl = new javax.swing.JLabel();
        phoneNum_lbl = new javax.swing.JLabel();
        phoneNum_txt = new javax.swing.JTextField();
        password_lbl = new javax.swing.JLabel();
        userName_txt = new javax.swing.JTextField();

        jTextField4.setText("jTextField4");

        jTextField6.setText("jTextField6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resisterForm_Panel.setBackground(new java.awt.Color(255, 255, 102));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Registration  Form  for Client");

        javax.swing.GroupLayout resisterForm_PanelLayout = new javax.swing.GroupLayout(resisterForm_Panel);
        resisterForm_Panel.setLayout(resisterForm_PanelLayout);
        resisterForm_PanelLayout.setHorizontalGroup(
            resisterForm_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resisterForm_PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        resisterForm_PanelLayout.setVerticalGroup(
            resisterForm_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resisterForm_PanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        form.setBackground(new java.awt.Color(51, 0, 102));
        form.setLayout(null);

        firstName_lbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        firstName_lbl.setText("First Name");
        form.add(firstName_lbl);
        firstName_lbl.setBounds(70, 70, 94, 23);

        firstName_txt.setBackground(new java.awt.Color(108, 122, 137));
        firstName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstName_txtActionPerformed(evt);
            }
        });
        form.add(firstName_txt);
        firstName_txt.setBounds(170, 69, 250, 30);

        lastName_lbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lastName_lbl.setText("Last name");
        form.add(lastName_lbl);
        lastName_lbl.setBounds(72, 112, 94, 17);

        lastName_txt.setBackground(new java.awt.Color(108, 122, 137));
        form.add(lastName_txt);
        lastName_txt.setBounds(170, 109, 248, 30);

        email_lbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        email_lbl.setText("Email");
        form.add(email_lbl);
        email_lbl.setBounds(90, 150, 50, 20);

        userName_lbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        userName_lbl.setText("User name");
        form.add(userName_lbl);
        userName_lbl.setBounds(60, 230, 80, 20);

        conPassword_lbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        conPassword_lbl.setText("Confirm Password");
        form.add(conPassword_lbl);
        conPassword_lbl.setBounds(20, 320, 130, 20);

        dob_lbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        dob_lbl.setText("Date Of Birth");
        form.add(dob_lbl);
        dob_lbl.setBounds(60, 370, 90, 20);

        email_txt.setBackground(new java.awt.Color(108, 122, 137));
        email_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_txtActionPerformed(evt);
            }
        });
        form.add(email_txt);
        email_txt.setBounds(170, 150, 248, 30);

        password_txt.setBackground(new java.awt.Color(108, 122, 137));
        password_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_txtActionPerformed(evt);
            }
        });
        form.add(password_txt);
        password_txt.setBounds(170, 270, 248, 30);

        conPassword_txt.setBackground(new java.awt.Color(108, 122, 137));
        form.add(conPassword_txt);
        conPassword_txt.setBounds(170, 310, 248, 30);

        address_lbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        address_lbl.setText("Address ");
        form.add(address_lbl);
        address_lbl.setBounds(70, 430, 60, 20);

        dob_txt.setBackground(new java.awt.Color(108, 122, 137));
        form.add(dob_txt);
        dob_txt.setBounds(170, 370, 248, 26);

        address_txtArea.setBackground(new java.awt.Color(108, 122, 137));
        address_txtArea.setColumns(20);
        address_txtArea.setRows(5);
        jScrollPane1.setViewportView(address_txtArea);

        form.add(jScrollPane1);
        jScrollPane1.setBounds(170, 430, 248, 79);

        cancel_btn.setBackground(new java.awt.Color(255, 51, 51));
        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });
        form.add(cancel_btn);
        cancel_btn.setBounds(150, 530, 80, 30);

        register_button.setBackground(new java.awt.Color(0, 153, 255));
        register_button.setText("Register");
        register_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_buttonActionPerformed(evt);
            }
        });
        form.add(register_button);
        register_button.setBounds(310, 530, 90, 30);

        login_lbl.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        login_lbl.setText("Click here to login");
        login_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_lblMouseClicked(evt);
            }
        });
        form.add(login_lbl);
        login_lbl.setBounds(190, 570, 222, 28);

        phoneNum_lbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        phoneNum_lbl.setText("Phone Number ");
        form.add(phoneNum_lbl);
        phoneNum_lbl.setBounds(50, 190, 110, 20);

        phoneNum_txt.setBackground(new java.awt.Color(108, 122, 137));
        form.add(phoneNum_txt);
        phoneNum_txt.setBounds(170, 190, 250, 30);

        password_lbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        password_lbl.setText("password");
        form.add(password_lbl);
        password_lbl.setBounds(60, 280, 80, 20);

        userName_txt.setBackground(new java.awt.Color(108, 122, 137));
        form.add(userName_txt);
        userName_txt.setBounds(170, 230, 250, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resisterForm_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(resisterForm_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstName_txtActionPerformed
        
        
       
    }//GEN-LAST:event_firstName_txtActionPerformed

    private void login_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_lblMouseClicked
        // TODO add your handling code here:
          LoginClient lg = new LoginClient();
        lg.setVisible(true);
        lg.pack();
        lg.setLocationRelativeTo(null);
        //reg.setDefaultCloseOperation(JFrame.EXIT_ON _CLOSE);
        this.dispose();
        
        
    }//GEN-LAST:event_login_lblMouseClicked

    private void email_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_txtActionPerformed

                }//GEN-LAST:event_email_txtActionPerformed

    private void register_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_buttonActionPerformed
          getInfo();
         
      
      
        if(firstName.equals("")){
         JOptionPane.showMessageDialog(null, "Please enter a firstName", "Error", JOptionPane.ERROR_MESSAGE);    
        }
         else if(lastName.equals("")){
         JOptionPane.showMessageDialog(null, "Please enter a lastName", "Error", JOptionPane.ERROR_MESSAGE);    
         }
         
    else if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", email_txt.getText()))) {

            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
     }
     
            
           
    else   if (!(Pattern.matches("^[0]+[1]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]", phoneNum_txt.getText())))
       {
           
           
           JOptionPane.showMessageDialog(null, "Please enter a valid Phone number ", "Errorx ", JOptionPane.ERROR_MESSAGE);
           
       
       }
    else if(userName.equals("")){
         JOptionPane.showMessageDialog(null, "Please enter a UserName", "Error", JOptionPane.ERROR_MESSAGE);    
        
    }
     else if(password.equals("")){
         JOptionPane.showMessageDialog(null, "Please enter a Password", "Error", JOptionPane.ERROR_MESSAGE);
         }
      else if(!(password.equals(conPassword))){
         JOptionPane.showMessageDialog(null, "Password doesnt Match", "Error", JOptionPane.ERROR_MESSAGE);
         }
     
     
     else if(dob.equals("")){
         JOptionPane.showMessageDialog(null, "Please enter Date Of Birth", "Error", JOptionPane.ERROR_MESSAGE);    
         }
     else if(address.equals("")){
         JOptionPane.showMessageDialog(null, "Please enter Address", "Error", JOptionPane.ERROR_MESSAGE);    
         }
    
     

else{
         insertData(firstName, lastName, phoneNum, email, userName, password,dob, address);
      JOptionPane.showMessageDialog(null,"Registration Successful","",JOptionPane.INFORMATION_MESSAGE); 
     LoginClient  login = new LoginClient();
     login.setVisible(true);
     this.dispose();
        
        }   
       


        
   
    }//GEN-LAST:event_register_buttonActionPerformed

    private void password_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_txtActionPerformed

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        LoginClient log=new LoginClient();
        log.setVisible(true);
    }//GEN-LAST:event_cancel_btnActionPerformed

    
     
   
    public static void main(String args[]) {
   
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientRegistration().setVisible(true);
                ClientRegistration oj= new ClientRegistration();

                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address_lbl;
    private javax.swing.JTextArea address_txtArea;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JLabel conPassword_lbl;
    private javax.swing.JPasswordField conPassword_txt;
    private javax.swing.JLabel dob_lbl;
    private com.toedter.calendar.JDateChooser dob_txt;
    private javax.swing.JLabel email_lbl;
    private javax.swing.JTextField email_txt;
    private javax.swing.JLabel firstName_lbl;
    private javax.swing.JTextField firstName_txt;
    private javax.swing.JPanel form;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lastName_lbl;
    private javax.swing.JTextField lastName_txt;
    private javax.swing.JLabel login_lbl;
    private javax.swing.JLabel password_lbl;
    private javax.swing.JPasswordField password_txt;
    private javax.swing.JLabel phoneNum_lbl;
    private javax.swing.JTextField phoneNum_txt;
    private javax.swing.JButton register_button;
    private javax.swing.JPanel resisterForm_Panel;
    private javax.swing.JLabel userName_lbl;
    private javax.swing.JTextField userName_txt;
    // End of variables declaration//GEN-END:variables
}

