import java.util.*;
/**
 * @author Luis Rivas
 * 2365948
 * lrivas@chapman.edu
 * CPSC 231-03
 * Mastery Project 3: Modern War(fare) - Deck
 * The purpose of this program is to create a Deck class containing a LinkedList of 52 Cards
 * and also deal a random card from the deck, removing it from the LinkedList and returning the Card
 * @version 1.0
 */
public class Deck {
   /** A LinkedList to hold all the cards in the Deck */
   private LinkedList <Card> deck = new LinkedList<Card>();

   /** Default constructor filling the LinkedList deck with all the cards in a deck. Loops through all suits and numbers to initialize each card. */
   public Deck() {
     for (int intSuit = 0; intSuit < 4; ++intSuit) {
       String suit;
       if (intSuit == 0) {
         suit = "hearts";
       } else if (intSuit == 1) {
         suit = "diamonds";
       } else if (intSuit == 2) {
         suit = "spades";
       } else {
         suit = "clubs";
       }
       for (int value = 2; value <= 14; ++value) {
         deck.add(new Card(value, suit));
       }
     }
   }

   /**
     * Method that removes a random Card from the LinkedList deck and returns that Card.
     * @return a Card
     */
   public Card deal() { 
     int random = (int)(Math.random()*deck.size());
     Card temp = new Card(deck.get(random));
     deck.remove(random);
     return temp;
   }
}
