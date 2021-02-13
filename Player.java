import java.util.*;
/**
 * @author Luis Rivas
 * 2365948
 * lrivas@chapman.edu
 * CPSC 231-03
 * Mastery Project 3: Modern War(fare) - Player
 * The purpose of this program is to create a Player class containing a player number and a LinkedList of cards owned by the Player
 * It also has a method to remove and return the card from the front of the players hand of cards,
 * and a method to add the cards picked up to the back of the players hand in a random order,
 * and a method to check if this player has won yet,
 * and a method to get how many cards this Player owns. 
 * @version 1.0
 */
 public class Player {
   /** A number, 1 or 2, that will represent player 1 or player 2 */
   private int m_player;

   /** LinkedList of cards owned by the Player */
   private LinkedList <Card> m_ownedCards = new LinkedList<Card>();

   /** Default constructor filling the LinkedList ownedCards with 26 cards from the deck, aka giving this player half the deck */
   public Player() {
     for (int i = 0; i < 26; ++i) {
       Deck d = new Deck();
       m_ownedCards.add(d.deal());
     }
   }

   /**
     * Method that removes a Card from the begining of the LinkedList ownedCards and returns that Card. (aka setting a card down during the game)
     * @return a Card
     */
   public Card flip() {
     Card temp = new Card(m_ownedCards.get(0));
     m_ownedCards.remove(0);
     return temp;
   }

   /**
     * Method that makes this player collect all the cards on the table (all the cards he won) and add them to his hand in a randomm order.
     * To do this it shuffles the LinkedList of cards, then loops through it adding each card to the Player's m_ownedCards
     * @param cards a LinkedList of Cards picked up from battle
     */
   public void collect(LinkedList <Card> cards) {
     Collections.shuffle(cards);
     for (int i = 0; i < cards.size(); ++i) {
       m_ownedCards.add(cards.get(i));
     }
   }

   /**
     * Method that returns true if the player has all 52 Cards.
     * @return a boolean
     */
   public boolean hasWon() {
     return (m_ownedCards.size() >= 52);
   }

   /**
     * Method that returns the amount of cards this Player has in their hand
     * @return an int representing the amount of cards this Player has in their hand.
     */
   public int getOwnedCardsSize() {
     return m_ownedCards.size();
   }
 }
