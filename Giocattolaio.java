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
import java.util.Scanner;

class Giocattolaio 
{
   public static void main(String[] args) 
   {
      // Istanza struttura dati Clienti e Giocattolo
      ArrayList<Cliente> cliente = new ArrayList<Cliente>();
      ArrayList<Giocattolo> giocattolo = new ArrayList<Giocattolo>();
      System.out.println("Hello Brach Main");

      // Istanza oggetti gestione vendita e inventario
      Vendita vendita = new Vendita(cliente, giocattolo);
      Inventario inventario = new Inventario(giocattolo);

      // Istanza oggetto input
      Scanner input = new Scanner(System.in);

      // Menu
      int scelta = 0;
      do
      {
         System.out.println();
         System.out.println("Menu Principale:");
         System.out.println("1. Registrazione Nuovo Cliente");
         System.out.println("2. Visualizzazione clienti registrati");
         System.out.println("3. Registrazione Nuovo Giocattolo");
         System.out.println("4. Visualizzazione giocattoli disponibili");
         System.out.println("5. Vendi Giocattolo");
         System.out.println("6. Esci");

         // Inserimento scelta
         System.out.print("Inserisci la tua scelta: ");
         scelta = input.nextInt();

         // Appoggio per controllare il risultato delle funzioni
         boolean flag = false;

         // Esegue l'azione corrispondente alla scelta
         switch (scelta) 
         {
            case 1:
                  flag = vendita.registraCliente();
                  if(flag)
                  {
                     System.out.println("Registrazione effettuata con successo.");
                  }
                  else
                  {
                     System.out.println("Registrazione non effettuata.");
                  }
               break;

            case 2:
                  vendita.visualizzaClientiRegistrati();
               break;

            case 3:
                  flag = vendita.checkCliente();
                  if(flag)
                  {
                     flag = inventario.registraGiocattolo();
                     if(flag)
                     {
                        System.out.println("Registrazione effettuata con successo.");
                     }
                     else
                     {
                        System.out.println("Registrazione non effettuata.");
                     }     
                  }
                  else
                  {
                     System.out.println("Utente non Admin oppure Utente NON esistente.");
                  }
               break;

            case 4:
                  flag = vendita.checkCliente();
                  if(flag)
                  {
                     inventario.visualizzaGiocattoliDisponibili();
                  }
                  else
                  {
                     System.out.println("Utente non Admin oppure Utente NON esistente.");
                  }
               break;

            case 5:
                  flag = vendita.checkCliente();
                  if(flag)
                  {
                     flag = inventario.vendiGiocattolo();
                     if(flag)
                     {
                        System.out.println("Vendita effettuata con successo.");
                     }
                     else
                     {
                        System.out.println("Id Giocattolo inesistente.");
                     }
                  }
                  else
                  {
                     System.out.println("Utente non Admin oppure Utente NON esistente.");
                  }
               break;

            default:
                  System.out.println("Scelta non valida.");
         }

      }while(scelta != 6);
   }
}

