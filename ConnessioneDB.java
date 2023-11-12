import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB 
{
   String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
   String DB_URL = "jdbc:mysql://localhost:3306";
   String DB_USERNAME = "root";
   String DB_PASSWORD = "root";
   Connection conn = null;
   ConnessioneDB()
   {
      try 
      {
         // Register the JDBC driver.
         Class.forName(DB_DRIVER);

         // Open the connection
         conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
         if (conn!= null)
            System.out.println("Successfully connected.");
         else 
            System.out.println("Failed to connect.");
      } 
      catch (Exception e) 
      {    
         e.printStackTrace(); 
      }
      finally
      {
         try
         {
            if(conn != null)
               conn.close();
         }
         catch(SQLException se)
         {
            se.printStackTrace();
         }
      }
   }
}