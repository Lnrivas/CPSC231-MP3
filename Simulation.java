import java.util.*;
/**
 * @author Luis Rivas
 * 2365948
 * lrivas@chapman.edu
 * CPSC 231-03
 * Mastery Project 3: Modern War(fare) - Simulation
 * The purpose of this program is to contain all the Statistics for all the games,
 * It contains a method to play however many games are required to be played
 * It contains a method to finish calculating the stats
 * It contains a method to neatly print all the stats
 * It contains the main method, which reads the number of games from the command line, and calls the other methods to run. 
 * @version 1.0
 */
public class Simulation {
  /** An int representing number of games that will be played, which is passed in through the command line */
  private int numOfGames;

  /** A double representing Average number of battles per game */
  private double avgNumOfBattles;

  /** A double representing Average number of wars per game */
  private double avgNumOfWars;

  /** A double representing Average number of double wars per game */
  private double avgNumOfDoubleWars;

  /** An int representing Max number of battles in a game */
  private int maxNumOfBattles;

  /** An int representing Min number of	battles in a game */
  private int minNumOfBattles;

  /** An int representing Max number of	wars in a game */
  private int maxNumOfWars;

  /** An int representing Min number of	wars in a game */
  private int minNumOfWars;

  /** An int that will count the amount of games that have been played */
  private int gameNumber;

  /** Default constructor initializing all stats to 0 */
  public Simulation() {
    numOfGames = 0;
    avgNumOfBattles = 0;
    avgNumOfWars = 0;
    avgNumOfDoubleWars = 0;
    maxNumOfBattles = 0;
    minNumOfBattles = 0;
    maxNumOfWars = 0;
    minNumOfWars = 0;
    gameNumber = 0;
  }

  /** Construcor that takes the number of games to simulate */
  public Simulation(int games) {
    numOfGames = games;
  }

  /**
   * method that plays the specified number of games
   * method repeats itself until all games have been played
   * makes a game and calls the play() method from Game on it to play the actual game
   * checks who won game for use in WarLogger
   * increments avgNumOfBattles, avgNumOfWars, and avgNumOfDoubleWars after each game
   * calcualte the min and max number of battles and wars
   * decriment numOfGames to count down how many games are left to be played
   * increment gameNumber to count how many games have been played so far
   */
  public void simulate() {
    while (numOfGames > 0) {
      Game g = new Game();
      g.play();
      if (g.gameWinner() == 1) {
        WarLogger.getInstance().logGameOutcome(gameNumber, WarLogger.P1);
      } else if (g.gameWinner() == 2) {
        WarLogger.getInstance().logGameOutcome(gameNumber, WarLogger.P2);
      }
      avgNumOfBattles += g.getNumOfBattles();
      avgNumOfWars += g.getNumOfWars();
      avgNumOfDoubleWars += g.getNumOfDoubleWars();
      if (gameNumber == 0) {
        minNumOfBattles = g.getNumOfBattles();
        minNumOfWars = g.getNumOfWars();
      }
      if(g.getNumOfBattles() > maxNumOfBattles) {
        maxNumOfBattles = g.getNumOfBattles();
      }
      if (g.getNumOfBattles() < minNumOfBattles) {
        minNumOfBattles = g.getNumOfBattles();
      }
      if (g.getNumOfWars() > maxNumOfWars) {
        maxNumOfWars = g.getNumOfWars();
      }
      if (g.getNumOfWars() < minNumOfWars) {
        minNumOfWars = g.getNumOfWars();
      }
      numOfGames--;
      gameNumber++;
    }
  }

  /** computes the aggregate statistics from all games */
  public void calculate() {
    avgNumOfBattles /= gameNumber;
    avgNumOfWars /= gameNumber;
    avgNumOfDoubleWars /= gameNumber;
  }

  /** prints the required statistics to the screen in a nicely-formatted manner */
  public void report() {
    System.out.println("Average numbber of battles: " + avgNumOfBattles +
    "\nAverage number of wars: " + avgNumOfWars +
    "\nAverage number of double wars: " + avgNumOfDoubleWars +
    "\nMax number of battles: " + maxNumOfBattles +
    "\nMin number of Battles: " + minNumOfBattles +
    "\nMax number of wars: " + maxNumOfWars +
    "\nMin number of wars: " + minNumOfWars);
  }

  /**
  * The main method for this project
  * @param args an array of Strings from the command line, the first String representing the number of games to be played
  * Create a new Simulation passing games as an argument to get the numOfGames
  * call the simulate method to initialize all the stats variables to 0
  * call the calculate method to finish calculating the average battles, wars, and double wars.
  * call the report method to print all the stats neatly
  */
  public static void main(String[] args) {
    int games = Integer.parseInt(args[0]);
    Simulation s = new Simulation(games);
    s.simulate();
    s.calculate();
    s.report();
    WarLogger.getInstance().release();
  }
}
