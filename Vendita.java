import java.util.ArrayList;
import java.util.Scanner;

public class Vendita 
{
   public ArrayList<Cliente> cliente;
   public ArrayList<Giocattolo> giocattolo;
   Scanner input;

   Vendita(ArrayList<Cliente> cliente, ArrayList<Giocattolo> giocattolo) 
   {
      this.cliente = cliente;
      this.giocattolo = giocattolo;
      input = new Scanner(System.in);
   }

   /**
    * Metodo in grado di registrare un nuovo cliente
    */
   public void registraCliente() 
   {
      System.out.print("Inserisci il Nome del Cliente: ");
      String nomeCliente = input.nextLine();

      System.out.print("Inserisci l'Email del Cliente: ");
      String emailCliente = input.nextLine();

      // Nuovo cliente
      Cliente c = new Cliente(cliente.size() + 1, nomeCliente, emailCliente);
      
      // Registrazione nuovo utente
      cliente.add(c);
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
   }
}
