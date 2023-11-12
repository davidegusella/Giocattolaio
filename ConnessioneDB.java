import java.sql.*;
public class ConnessioneDB 
{
   // Variabile di appoggio per effettuare la connessione
   private Connection conn;

   ConnessioneDB()
   {
      String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
      String DB_URL  = "jdbc:mysql://localhost:3306/giocattolaio";
      String DB_USERNAME_USER = "root";
      String DB_PASSWORD_USER = "root";

      // Carico il Driver
      try 
      {
         // Caricamento Driver
         Class.forName(DB_DRIVER);

         // Tento la connessione
         conn = DriverManager.getConnection(DB_URL, DB_USERNAME_USER, DB_PASSWORD_USER);

         // Controllo la connessione
         if (conn!= null)
            System.out.println("Connessione riuscita");
         else 
            System.out.println("Connessione fallita");
      } 
      catch (Exception e) 
      {    
         e.printStackTrace(); 
      }
   }


   /**
    * @brief
    * Lettura dati
    */
   public void letturaDati()
   {
      // Oggetto "Statement per effettuare la query"
      Statement st = null;

      // Oggetto "ResultSet per ottenere i dati della query"
      ResultSet rs = null;

      try
      {
         // Inizializzo un oggetto Statement
         st = conn.createStatement();

         // Query per memorizzare tutti i dati all'interno della tabella "prova"
         String sql = "SELECT id,nome,prezzo FROM prova ORDER BY id";

         // Eseguo la query
         rs = st.executeQuery(sql);

         // Ciclo di scorrimento per leggere i dati
         while(rs.next())
         {
            int id = rs.getInt(1);
            String nome = rs.getString(2);
            double prezzo = rs.getDouble(3);
            System.out.println("ID: " + id + " Nome: " + nome + " Prezzo: " + prezzo);
         }

      }
      catch(SQLException e)
      {
         System.out.println("LETTURA DATI NON RIUSCITA");
      }
      finally
      {
         // chiudo lo Statement se esiste
         if( st != null )
         {
            try 
            { 
               st.close(); 
            } 
            catch(SQLException e) 
            {
            }
         }

         // Chiudo il ResultSet se esiste
         if(rs != null)
         {
             try 
            { 
                rs.close(); 
            } 
            catch(SQLException e) 
            {
            }
         }
      }
      
   }
}