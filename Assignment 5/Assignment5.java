import java.util.Scanner;
import java.util.Random;

public class Assignment5 //Rock, Paper, or Scissors Game
{

   public static void main (String[] args)
   {
      Scanner in = new Scanner (System.in);
      Random r = new Random ();
      
      int numGames = 0; //number of games user wishes to play
      String userGuess = "";
      int random = 0;
      String cpuGuess = "";
      int userWins = 0;
      int cpuWins = 0;
      
      // Introduction and user input for the number of games to be played
      System.out.println("Welcome to Rock, Paper, Scissors!");
      System.out.println("Please enter the number of rounds you would like to play:");
      numGames = in.nextInt();
      
      // Checking for valid input of an odd number of games
      while (numGames % 2 == 0)
      {
         System.out.println("Sorry, you need to enter an odd number. Please try again.");
         numGames = in.nextInt();
      }      
      
      // Flush the buffer
      in.nextLine();
      
      // Play the game for the number of times stated
      for (int i = 0; i < numGames; i++)
      {
         System.out.println();
         System.out.println("Rock, Paper, or Scissors?");
         userGuess = in.next();
         
         // Validate user input
         while (!userGuess.equalsIgnoreCase("rock") && !userGuess.equalsIgnoreCase("paper") && !userGuess.equalsIgnoreCase("scissors") && !userGuess.equalsIgnoreCase("spock"))
         {
            System.out.println("Sorry, " + "\"" + userGuess + "\"" + " is not a valid entry.");
            System.out.println("Please pick Rock, Paper, or Scissors");
            userGuess = in.nextLine();
         }
         
         // Generate random guess
         random = r.nextInt(3);
         
         if (random == 0)
         {
            cpuGuess = "rock";
         }
         if (random == 1)
         {
            cpuGuess = "paper";
         }
         if (random == 2)
         {
            cpuGuess = "scissors";
         }
         
         System.out.println("The computer's guess was: " + cpuGuess);
         
         //Calculate round winner based off user choosing rock or Spock
         if (userGuess.equalsIgnoreCase("rock") && (cpuGuess.equals("scissors")))
         {            
            System.out.println("You win!");
            userWins++;            
         }
         if (userGuess.equalsIgnoreCase("rock") && (cpuGuess.equals("paper")))
         {
            System.out.println("You lose.");
            cpuWins++;
         }
         if (userGuess.equalsIgnoreCase("rock") && (cpuGuess.equals("rock")))
         {
            System.out.println("It's a tie.");
            i--;
         }
         if (userGuess.equalsIgnoreCase ("Spock"))
         {
            System.out.println("Spock is ultimate, but maintains an unfair advantage and is, therefore, not allowed.");
            i--;
         }
         
         //Calculate round winner based off user choosing paper
         if (userGuess.equalsIgnoreCase("paper") && (cpuGuess.equals("rock")))
         {
            System.out.println("You win!");
            userWins++;
         }
         if (userGuess.equalsIgnoreCase("paper") && (cpuGuess.equals("paper")))
         {
            System.out.println("It's a tie.");
            i--;
         }
         if (userGuess.equalsIgnoreCase("paper") && (cpuGuess.equals("scissors")))
         {
            System.out.println("You lose.");
            cpuWins++;
         }
         
         //Calculate round winner based off user choosing scissors
         if (userGuess.equalsIgnoreCase("scissors") && (cpuGuess.equals("rock")))
         {
            System.out.println("You lose.");
            cpuWins++;
         }
         if (userGuess.equalsIgnoreCase("scissors") && (cpuGuess.equals("paper")))
         {
            System.out.println("You win!");
            userWins++;
         }
         if (userGuess.equalsIgnoreCase("scissors") && (cpuGuess.equals("scissors")))
         {
            System.out.println("It's a tie.");
            i--;
         }
         
      } //end of for
      
  //Determine overall winner
      System.out.println();
      System.out.println("User wins: " + userWins);
      System.out.println("Computer wins: " + cpuWins);
      System.out.println();
         
      if (userWins > cpuWins)
      {
         System.out.println("User wins the game!");
      }
      if (userWins < cpuWins)
      {
         System.out.println("Computer wins the game.");
      }
   } //end of main

} //end of class