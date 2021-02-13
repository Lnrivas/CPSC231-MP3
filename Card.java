/**
 * @author Luis Rivas
 * 2365948
 * lrivas@chapman.edu
 * CPSC 231-03
 * Mastery Project 3: Modern War(fare) - Card
 * The purpose of this program is to create a Card class containing it's value and suit.
 * includes accessors for returning the card value and card suit
 * includes a toString to return the info of the Card neatly
 * Note: jack has the value 11, queen has the value 12, king has the value 13, and ace has the value 14
 * @version 1.0
 */
public class Card {
  /** The value of the card, ranging from 2-14 (jack is 11, queen is 12, king is 13, ace is 14) */
  private int m_value;

  /** The suit of the card (hearts, spaces, clubs, diamonds) */
  private String m_suit;

  /** Default constructor initializing m_value to 2 and m_suit to hearts */
  public Card() {
    m_value = 2;
    m_suit = "hearts";
  }

  /**
    * Overloaded constuctor initializing m_value to value and m_suit to suit
    * @param value value of the card
    * @param suit the suit of the card
    */
  public Card(int value, String suit) {
    m_value = value;
    m_suit = suit;
  }

  /**
    * Copy constuctor initializing all fields of this card to the fields of the passed in Card
    * @param value value of the card
    */
  public Card(Card card) {
    this.m_value = card.m_value;
    this.m_suit = card.m_suit;
  }

  /**
    * Accessor method returning m_value.
    * @return an int value m_value, the numeric value of the card
    */
  public int getValue() {
    return m_value;
  }

  /**
    * Accessor method returning m_suit.
    * @return a String value m_suit, the suit of the card
    */
  public String getSuit() {
    return m_suit;
  }

  /**
    * toString() method neatly returning all Card information as a String.
    * prints card values of 11,12,13,14 as J,Q,K,A
    * @return a String value neatly showing all Card information (m_value and m_suit).
    */
  public String toString() {
    if (m_value == 11) {
      return "J of " + m_suit;
    } else if (m_value == 12) {
      return "Q of " + m_suit;
    } else if (m_value == 13) {
      return "K of " + m_suit;
    } else if (m_value == 14) {
      return "A of " + m_suit;
    } else {
      return m_value + " of " + m_suit;
    }
  }
}
