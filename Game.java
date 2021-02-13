import java.util.*;
/**
 * @author Luis Rivas
 * 2365948
 * lrivas@chapman.edu
 * CPSC 231-03
 * Mastery Project 3: Modern War(fare) - Game
 * The purpose of this program is to Create a Game class which keeps track of the number of battles, the number of wars, and the number of double wars,
 * and contains a LinkedList cardsOnTable which is all the cards both players put down.
 * It handles how the game actually works, along with what happens during a tie.
 * @version 1.0
 */
public class Game {
  /** A Player representing player one */
  private Player p1;

  /** A Player representing player two */
  private Player p2;

  /** A LinkedList representing all the cards flipped over (aka the cards played each round) */
  private LinkedList <Card> cardsOnTable = new LinkedList<Card>();

  /** An int representing the number of battles in the game */
  private int numOfBattles;

  /** An int representing number of wars in the game */
  private int numOfWars;

  /** An int representing the number of double wars in a game */
  private int numOfDoubleWars;

  /** A Card to represent the first Card Player 1 flips over in a battle */
  private Card firstP1;

  /** A Card to represent the second Card Player 1 flips over in a battle */
  private Card secondP1;

  /** A Card to represent the third Card Player 1 flips over in a battle */
  private Card thirdP1;

  /** An int to represent the median value of the cards Player 1 flips over */
  private int midP1;

  /** A Card to represent the first Card Player 2 flips over in a battle */
  private Card firstP2;

  /** A Card to represent the second Card Player 2 flips over in a battle */
  private Card secondP2;

  /** A Card to represent the third Card Player 2 flips over in a battle */
  private Card thirdP2;

  /** An int to represent the median value of the cards Player 2 flips over */
  private int midP2;

  /** An array of Cards containing all the Cards player 1 flips over in a battle (ONLY USED FOR THE WarLogger) */
  private Card [] p1Hand = new Card [3];

  /** An array of Cards containing all the Cards player 2 flips over in a battle (ONLY USED FOR THE WarLogger) */
  private Card [] p2Hand = new Card [3];

  /** A Card to represent any Card Player 1 flips over in a war */
  private Card fourthP1;

  /** A Card to represent any Card Player 2 flips over in a war */
  private Card fourthP2;


  /** Default constructor initializing Player p1, Player p2, numOfBattles, numOfWars, and numOfDoubleWars */
  public Game() {
    p1 = new Player();
    p2 = new Player();
    numOfBattles = 0;
    numOfWars = 0;
    numOfDoubleWars = 0;
  }

  /**
    * Accessor method returning numOfBattles.
    * @return an int value numOfBattles, the number of battles in the game
    */
  public int getNumOfBattles() {
    return numOfBattles;
  }

  /**
    * Accessor method returning numOfWars.
    * @return an int value numOfWars, the number of wars in the game
    */
  public int getNumOfWars() {
    return numOfWars;
  }

  /**
    * Accessor method returning numOfDoubleWars.
    * @return an int value numOfDoubleWars, the number of double wars in the game
    */
  public int getNumOfDoubleWars() {
    return numOfDoubleWars;
  }

  /**
    * Method that makes both players flip over three cards, and add them to array p1Hand or p2Hand to use in the WarLogger.
    * checks the middle value of each player's three cards, having different code to do this depending if a Player has 3, 2, or 1 Card
    * adds all 6 cards to the LinkedList cardsOnTable,
    * compares the middle card of each player and the winner picks up all cards in a random order.
    * if both middle values are equal, call the war() method to settle the tie.
    * increase the numOfBattles count whenever a Player collects the cardsOnTable
    * increase the numOfWars count whenever theres a tie and the war() method is called
    * check often throughout method to see any palyer has won yet.
    */
  public void play() {
    while (!p1.hasWon() && !p2.hasWon()) {
      if (p1.getOwnedCardsSize() >= 3) {
        firstP1 = p1.flip();
        secondP1 = p1.flip();
        thirdP1 = p1.flip();
        cardsOnTable.add(firstP1);
        cardsOnTable.add(secondP1);
        cardsOnTable.add(thirdP1);
        p1Hand[0] = firstP1;
        p1Hand[1] = secondP1;
        p1Hand[2] = thirdP1;
        if(firstP1.getValue() < secondP1.getValue() && firstP1.getValue() > thirdP1.getValue()) {
          midP1 = firstP1.getValue();
        } else if (secondP1.getValue() < firstP1.getValue() && secondP1.getValue() > thirdP1.getValue()) {
          midP1 = secondP1.getValue();
        } else {
          midP1 = thirdP1.getValue();
        }
      } else if (p1.getOwnedCardsSize() == 2) {
        firstP1 = p1.flip();
        secondP1 = p1.flip();
        cardsOnTable.add(firstP1);
        cardsOnTable.add(secondP1);
        p1Hand[0] = firstP1;
        p1Hand[1] = secondP1;
        if (firstP1.getValue() < secondP1.getValue()) {
          midP1 = secondP1.getValue();
        }
      } else if (p1.getOwnedCardsSize() == 1){
        firstP1 = p1.flip();
        cardsOnTable.add(firstP1);
        p1Hand[0] = firstP1;
        midP1 = firstP1.getValue();
      } else {
        break;
      }

      if (p2.getOwnedCardsSize() >= 3) {
        firstP2 = p2.flip();
        secondP2 = p2.flip();
        thirdP2 = p2.flip();
        cardsOnTable.add(firstP2);
        cardsOnTable.add(secondP2);
        cardsOnTable.add(thirdP2);
        p2Hand[0] = firstP2;
        p2Hand[1] = secondP2;
        p2Hand[2] = thirdP2;
        if(firstP2.getValue() < secondP2.getValue() && firstP2.getValue() > thirdP2.getValue()) {
          midP2 = firstP2.getValue();
        } else if (secondP2.getValue() < firstP2.getValue() && secondP2.getValue() > thirdP2.getValue()) {
          midP2 = secondP2.getValue();
        } else {
          midP2 = thirdP2.getValue();
        }
      } else if (p2.getOwnedCardsSize() == 2) {
        firstP2 = p2.flip();
        secondP2 = p2.flip();
        cardsOnTable.add(firstP2);
        cardsOnTable.add(secondP2);
        p1Hand[0] = firstP1;
        p1Hand[1] = secondP1;
        if (firstP2.getValue() < secondP2.getValue()) {
          midP2 = secondP2.getValue();
        }
      } else if (p2.getOwnedCardsSize() == 1){
        firstP2 = p2.flip();
        cardsOnTable.add(firstP2);
        p1Hand[0] = firstP1;
        midP2 = firstP2.getValue();
      } else {
        break;
      }
      Collections.shuffle(cardsOnTable);
      if (midP1 > midP2) {
        p1.collect(cardsOnTable);
        WarLogger.getInstance().logBattleOutcome(numOfBattles, WarLogger.P1);
        cardsOnTable.clear();
        numOfBattles++;
      } else if (midP2 > midP1) {
        p2.collect(cardsOnTable);
        WarLogger.getInstance().logBattleOutcome(numOfBattles, WarLogger.P2);
        cardsOnTable.clear();
        numOfBattles++;
      } else {
        numOfWars++;
        numOfBattles++;
        war().collect(cardsOnTable);
        WarLogger.getInstance().logBattleOutcome(numOfBattles, WarLogger.WAR);
        cardsOnTable.clear();
      }
      WarLogger.getInstance().logBattle(numOfBattles,WarLogger.P1, p1Hand);
      WarLogger.getInstance().logBattle(numOfBattles,WarLogger.P2, p2Hand);
    }
  }

  /**
    * Method that settles ties by having each player flip another card,
    * comparing their values, and return the player whose card value was higher. If they are equal, flip another card and compare them until a Player wins the war.
    * increase numOfDoubleWars whenever the tiebreaker cards are equal and another card has to be placed down
    * @return a Player, the Player who won the war
    */
  public Player war() {
    if (p1.getOwnedCardsSize() > 1 && p2.getOwnedCardsSize() == 1){
      fourthP1 = p1.flip();
      cardsOnTable.add(fourthP1);
      WarLogger.getInstance().logWarOutcome(numOfWars, WarLogger.P1); //CHECK
      return p1;
    } else if (p1.getOwnedCardsSize() > 1 && p2.getOwnedCardsSize() == 1) {
      fourthP2 = p2.flip();
      cardsOnTable.add(fourthP2);
      WarLogger.getInstance().logWarOutcome(numOfWars, WarLogger.P2); //CHECK
      return p2;
    }
    if (p1.getOwnedCardsSize() > 1 && p2.getOwnedCardsSize() > 1) {
      fourthP1 = p1.flip();
      fourthP2 = p2.flip();
      cardsOnTable.add(fourthP1);
      cardsOnTable.add(fourthP2);
    if (fourthP1.getValue() > fourthP2.getValue()) {
      WarLogger.getInstance().logWarOutcome(numOfWars, WarLogger.P1); //CHECK
      return p1;
    } else if (fourthP2.getValue() > fourthP1.getValue()) {
      WarLogger.getInstance().logWarOutcome(numOfWars, WarLogger.P2); //CHECK
      return p2;
    } else {
      WarLogger.getInstance().logWarOutcome(numOfWars, WarLogger.WAR); //CHECK
      if (p1.getOwnedCardsSize() > 0 && p2.getOwnedCardsSize() > 0) {
        boolean same = true;
        while (same && p1.getOwnedCardsSize() > 0 && p2.getOwnedCardsSize() > 0) {
          numOfDoubleWars++;
          fourthP1 = p1.flip();
          fourthP2 = p2.flip();
          cardsOnTable.add(fourthP1);
          cardsOnTable.add(fourthP2);
          if (fourthP2.getValue() != fourthP1.getValue()) {
            same = false;
          }
        }
        if (fourthP1.getValue() > fourthP2.getValue()) {
          return p1;
        } else if (fourthP2.getValue() > fourthP1.getValue()) {
          return p2;
        }
      }
    }
  }
    return p1;
  }

  /**
    * Method that checks which player won the Game.
    * @return an int, the number of the Player who won the Game
    */
  public int gameWinner() {
    if (p1.hasWon()) {
      return 1;
    }
    return 2;
  }
}
