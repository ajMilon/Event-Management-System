import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyDatabaseHandler {
    Connection connect = null;
   public String val="my";
   public String val2="ut";
   
   public MyDatabaseHandler(){
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
    
  /*   public void insertData(String firstName,String lastName,int phoneNum,String email,String userName,String password,String address){
        // Connection connect= null;
                  //   connect = DriverManager.getConnection("jdbc:mysql://localhost/event_db","root","");

                 
      //   inser.connectDatabase();
        try{
            String query1 = "INSERT INTO registration(FirstName,LastName,PhoneNo,Email,UserName,Password,Address) values(?,?,?,?,?,?,?)";
            PreparedStatement pStatement=connect.prepareStatement(query1);
            pStatement.setString(1, firstName);
            pStatement.setString(2, lastName);
            pStatement.setInt(3, phoneNum);
            pStatement.setString(4, email);
            pStatement.setString(5, userName);
            pStatement.setString(6, password);
           // pStatement.setString(7, dob);
            pStatement.setString(7, address);
            
           
            pStatement.executeUpdate();
            
            System.out.println("Successfully Insert..");
            
            
        }catch(Exception e){
            System.out.println("Error in inserting");
            e.printStackTrace();
        }
    } */
    
    
    
    
    
    
    
   
    
    
}
    


