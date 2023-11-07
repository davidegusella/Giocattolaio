import java.util.ArrayList;
import java.util.Scanner;

public class Vendita extends RegistroVendite
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

   /**
    * Metodo in grado di registrare un nuovo giocattolo
    */
   public void registraGiocattolo() 
   {
      System.out.print("Inserisci il Nome del Giocattolo: ");
      String nomeGiocattolo = input.next();

      System.out.print("Inserisci il Prezzo del Giocattolo: ");
      double PrezzoCliente = input.nextDouble();

      System.out.print("Inserisci il Età consigliata del Giocattolo: ");
      int etaConsigliata = input.nextInt();

      // Nuovo Giocattolo
      Giocattolo g = new Giocattolo(giocattolo.size() + 1, nomeGiocattolo, PrezzoCliente, etaConsigliata);
      
      // Registrazione nuovo Giocattolo
      giocattolo.add(g);
   }

   /**
    * Metodo in grado di visualizzare i clienti registrati
    */
   public void visualizzaGiocattoliDisponibili() 
   {
      System.out.println("Elenco giocattoli disponibili:");
      for (Giocattolo g : giocattolo) 
      {
         System.out.println("ID: " + g.getId() + " Nome: " + g.getNome() + " Prezzo: " + g.getPrezzo() + " Età consigliata: " + g.getEtaConsigliata());
      }
   }

   /**
    * Metodo in grado di vendere un giocattolo
    */
   @Override
   public void VendiGiocattolo()
   {
      System.out.println("Inserisci l'id del giocattolo da vendere: ");
      int idGiocattolo = input.nextInt();

      // Eliminazione giocattolo
      for(int i = 0; i < giocattolo.size(); i++)
      {
         if(giocattolo.get(i).getId() == idGiocattolo)
         {
            giocattolo.remove(i);
         }
      }
   }
}
