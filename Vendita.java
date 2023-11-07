import java.util.ArrayList;
import java.util.Scanner;

public class Vendita
{
   // Attributi
   public ArrayList<Cliente> cliente;
   public ArrayList<Giocattolo> giocattolo;
   Scanner input;

   // Costruttore
   Vendita(ArrayList<Cliente> cliente, ArrayList<Giocattolo> giocattolo) 
   {
      this.cliente = cliente;
      this.giocattolo = giocattolo;
      input = new Scanner(System.in);
   }

   /**
    * Metodo in grado di registrare un nuovo cliente
    */
   public boolean registraCliente() 
   {
      // Inizializzazione pessimistica
      boolean ris = false;

      System.out.print("Inserisci il Nome del Cliente: ");
      String nomeCliente = input.next();

      System.out.print("Inserisci l'Email del Cliente: ");
      String emailCliente = input.next();

      // Nuovo cliente
      Cliente c = new Cliente(cliente.size() + 1, nomeCliente, emailCliente);
      
      // Registrazione nuovo utente
      cliente.add(c);

      // Aggiorno il flag
      ris = true;

      return ris;
   }

   /**
    * Metodo in grado di visualizzare i clienti registrati
    */
   public void visualizzaClientiRegistrati() 
   {
      System.out.println("Elenco clienti registrati:");
      for (Cliente c : cliente) 
      {
         System.out.println("ID: " + c.getId() + " Nome: " + c.getNome() + " Email: " + c.getEmail());
      }
      System.out.println();
   }

   /**
    * Metodo in grado di controllare se un cliente è registrato
    */
   public boolean checkCliente()
   {
      visualizzaClientiRegistrati();

      System.out.print("Inserisci l'id del cliente: ");
      int idCliente = input.nextInt();

      // Controllo se l'id inserito è presente
      boolean flag = false;
      for(int i = 0; i < cliente.size(); i++)
      {
         // Suppongo che il cliente "Admin" sia colui che abbia id = 1
         if(cliente.get(i).getId() == idCliente && cliente.get(i).getId() == 1) 
         {
            // Aggiorno il flag
            flag = true;
         }
      }

      return flag;
   }
}
