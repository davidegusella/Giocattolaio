/*
 * Esercizio Java per Giocattolaio (Senza DB)
   Descrizione: Implementare un'applicazione Java per gestire l'inventario 
   e le vendite di un negozio di giocattoli.

Task:
Definizione delle Classi:
1) Crea una classe Giocattolo con campi come id, nome, prezzo e età consigliata.
   Crea una classe Cliente con campi come id, nome e indirizzo email.
   Crea una classe Vendita che registra gli acquisti dei clienti.
2) Gestione dell'Inventario:
   Implementa una classe Inventario che tiene traccia dei giocattoli disponibili 
      e che possa essere aggiornata da un o specifico admin.
   Processo di Vendita:
   Implementa una classe ASTRATTA RegistroVendite che gestisce le vendite dei giocattoli 
      ai clienti e che deve contenere SOLO metodi.
3) Interfaccia Utente:
   Crea un'interfaccia utente semplice in console per interagire con l'utente, 
      permettendo loro di acquistare giocattoli e visualizzare le vendite.
*/

import java.util.ArrayList;

class Giocattolaio 
{
   public static void main(String[] args) 
   {
      // ArrayList di Cliente e Giocattolo
      ArrayList<Cliente> cliente = new ArrayList<Cliente>();
      ArrayList<Giocattolo> giocattolo = new ArrayList<Giocattolo>();

      Vendita vendita = new Vendita(cliente, giocattolo);

      // Registrazione Cliente 1
      vendita.registraCliente();

      // Registrazione Cliente 2
      vendita.registraCliente();

      // Visualizzazione Clienti Registrati
      vendita.visualizzaClientiRegistrati();

      // Se l'utente ha il permesso può registrare un giocattolo
      // (Esempio: Il cliente con id 1 ha il permesso di registrare un giocattolo)
      if(cliente.get(0).getId() == 1)
      {
         // Registrazione Giocattolo 1
         vendita.registraGiocattolo();

         // Registrazione Giocattolo 2
         vendita.registraGiocattolo();

         // Visualizzazione Giocattoli disponibili
         vendita.visualizzaGiocattoliDisponibili();

         // Vendita Giocattolo
         vendita.VendiGiocattolo();

         // Visualizzazione Giocattoli disponibili dopo l'eliminaizione
         vendita.visualizzaGiocattoliDisponibili();
      }
      else
      {
         System.out.println("Non hai i permessi");
      }
   }
}

