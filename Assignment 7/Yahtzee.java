import java.util.Random;
import java.util.Scanner;

public class Yahtzee
{

   public static void main (String[] args)
   {
   
      Random r = new Random();
      Scanner in = new Scanner (System.in);
      int[] dice = new int[5]; //variable for the 5 dice
      String userInput = "";
      int userCheat = 0;
      
      //Cheat Mode
      System.out.println("Would you like to enter Cheat Mode?");
      userInput = in.nextLine();
      if (userInput.equalsIgnoreCase("yes"))
      {
         System.out.println("Enter the value for the 1st die");
         dice[0] = in.nextInt();
         
         System.out.println("Enter the value for the 2nd die");
         dice[1] = in.nextInt();
         
         System.out.println("Enter the value for the 3rd die");
         dice[2] = in.nextInt();
         
         System.out.println("Enter the value for the 4th die");
         dice[3] = in.nextInt();
         
         System.out.println("Enter the value for the 5th die");
         dice[4] = in.nextInt();
                  
      }else
      {  
         //Generate random dice values and print the dice rolls
         for (int i = 0; i < dice.length; i++)
         {      
            dice[i] = r.nextInt(6) + 1;
            System.out.print(dice[i] + " ");      
         }
         
         System.out.println(); //Flush the buffer
         
         //Setting up rounds to re-roll
         for (int j = 0; j < 2; j++)
         {
           for (int i = 0; i < 5; i++)
            {
               System.out.println("Would you like to reroll the " + (dice[i]) + "? (yes/no)");
               userInput = in.nextLine();
               
               if (userInput.equalsIgnoreCase("yes"))
               {
                  dice[i] = r.nextInt(6) + 1;
               }         
            
            }
            for (int i = 0; i < dice.length; i++)
            {
               System.out.print(dice[i] + " ");
            }
         }
      }
      
      //Create a counts array, set all values to zero.
      int[] counts = new int[6];
      for (int i = 0; i < 6; i++)
      {
      counts[i] = 0;
      }
      
      //count up the values
      for (int i = 0; i < 5; i++) 
      {
      /* diceIndex will hold the value of the dice location
      minus one. This is so it can be placed in the 0th
      based array, in the correct location.*/
      int diceIndex = dice[i] - 1;
      /* This will go to the location reserved for the dice and
      increment its value by 1.
      For example, if the value of the die was 4, the diceIndex value would be 3. This would increment counts[3] by one. Now it’s easy to tell how many 4s there are, because each time there is a 4, it will increment the count[3] location by one again.*/
      counts[diceIndex]++;
      }
      
      /* This prints out how many of each number there is. COMMENT IT OUT WHEN YOU ARE DONE WITH IT. */
      System.out.println();
      for (int i = 0; i < 6; i++)
      {
      //System.out.println("The number of " + (i+1) + "s is : " + counts[i]);
      
       //Calculate values of dice
      if (counts[i] == 5)
      {
         System.out.println("Yahtzee");
      }
      else if (counts[i] == 4)
      {
         System.out.println("Four of a Kind");
      }
      else if (counts[i] == 3 && (counts[0] == 2 || counts [1] == 2 || counts[2] == 2 || counts[3] == 2 || counts[4] == 2 || counts[5] == 2))
      {
         System.out.println("Full House");
      }
      else if (counts[i] == 3)
      {
         System.out.println("Three of a Kind");
      }
      }
      
      if ((counts[1] == 1 && counts[2] == 1 && counts[3] == 1 && counts[4] == 1) && (counts[0] == 1 || counts[5] == 1))//2,3,4,5 and either 1 or 6
      {
         System.out.println("Large Straight");
      }
      else if ((counts[2] == 1 && counts[3] == 1 && counts[4] == 1) && (counts[1] == 1 || counts[5] == 1))//3,4,5 and either 2 or 6
      {
         System.out.println("Small Straight");
      }
      else if ((counts[1] >= 1 && counts[2] >= 1 && counts[3] >= 1) && (counts[0] >= 1 || counts[4] >= 1))//2,3,4 and either 1 or 5
      {
         System.out.println("Small Straight");
      }
         
   }//main

}//class