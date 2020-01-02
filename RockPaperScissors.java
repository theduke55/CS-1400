import javax.swing.*;
import java.util.*;

public class RockPaperScissors
{
   public String getUserChoice()
   {
      String userChoice = "";
      boolean isValid = false;
      
      do
      {
         isValid = true;//reseting to false
         
         userChoice = JOptionPane.showInputDialog("Please input your choice (rock, paper, scissors):");
         
         if(!(userChoice.equalsIgnoreCase("rock") || userChoice.equalsIgnoreCase("paper") || userChoice.equalsIgnoreCase("scissors")))
         {
            JOptionPane.showMessageDialog(null,"Sorry, \"" + userChoice + "\" is not a valid entry.");//Error handling
            isValid = false;        
         }
      }while(!isValid);
   return userChoice;         
   }//end getUserChoice
   
   public String getCPUChoice()
   {
      String cpuChoice = "";
      int random = 0;
      
      Random r = new Random();
      random = r.nextInt(3);
      
      if (random == 0)
         {
            cpuChoice = "Rock";
         }
         if (random == 1)
         {
            cpuChoice = "Paper";
         }
         if (random == 2)
         {
            cpuChoice = "Scissors";
         }
   
   return cpuChoice;
   }
      
   public String pickWinner(String userGuess, String cpuGuess)
   {
      String winner = "";
      
      //Calculate round winner based off user choosing Rock
         if (userGuess.equalsIgnoreCase("rock") && (cpuGuess.equalsIgnoreCase("scissors")))
         {            
            winner = "User";            
         }
         if (userGuess.equalsIgnoreCase("rock") && (cpuGuess.equalsIgnoreCase("paper")))
         {
            winner = "Computer";
         }
         if (userGuess.equalsIgnoreCase("rock") && (cpuGuess.equalsIgnoreCase("rock")))
         {
            winner = "Tie";
         }
         
         //Calculate round winner based off user choosing paper
         if (userGuess.equalsIgnoreCase("paper") && (cpuGuess.equalsIgnoreCase("rock")))
         {
            winner = "User";
         }
         if (userGuess.equalsIgnoreCase("paper") && (cpuGuess.equalsIgnoreCase("paper")))
         {
            winner = "Tie";
         }
         if (userGuess.equalsIgnoreCase("paper") && (cpuGuess.equalsIgnoreCase("scissors")))
         {
            winner = "Computer";
         }
         
         //Calculate round winner based off user choosing scissors
         if (userGuess.equalsIgnoreCase("scissors") && (cpuGuess.equalsIgnoreCase("rock")))
         {
            winner = "Computer";
         }
         if (userGuess.equalsIgnoreCase("scissors") && (cpuGuess.equalsIgnoreCase("paper")))
         {
            winner = "User";
         }
         if (userGuess.equalsIgnoreCase("scissors") && (cpuGuess.equalsIgnoreCase("scissors")))
         {
            winner = "Tie";
         }
   return winner;
   }
   
}//end class