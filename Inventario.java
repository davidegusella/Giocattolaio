import java.util.ArrayList;
import java.util.Scanner;

public class Inventario extends RegistroVendite
{
   // Attributi 
   public ArrayList<Giocattolo> giocattolo;
   Scanner input;

   // Costruttore
   Inventario(ArrayList<Giocattolo> giocattolo) 
   {
      this.giocattolo = giocattolo;
      input = new Scanner(System.in);
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
      System.out.println();
   }

   /**
    * Metodo in grado di registrare un nuovo giocattolo
    */
   public boolean registraGiocattolo() 
   {
      // Inizializzazione pessimistica
      boolean ris = false;

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

      // Aggiorno il flag
      ris = true;

      return ris;
   }

   /**
    * Metodo in grado di vendere un giocattolo
    */
   @Override
   public boolean vendiGiocattolo()
   {
      visualizzaGiocattoliDisponibili();

      // Inizializzazione pessimistica
      boolean ris = false;

      System.out.println("Inserisci l'id del giocattolo da vendere: ");
      int idGiocattolo = input.nextInt();

      // Eliminazione giocattolo
      for(int i = 0; i < giocattolo.size(); i++)
      {
         if(giocattolo.get(i).getId() == idGiocattolo)
         {
            giocattolo.remove(i);

            // Aggiorno il flag
            ris = true;
         }
      }

      return ris;
   }
}
