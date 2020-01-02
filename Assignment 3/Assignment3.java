import java.util.Scanner; //Import utility for user input

import java.util.Random; //Import utility for random generated number

public class Assignment3 //Title
{

   public static void main (String [] args) //Method
   {
   
      //Creating instances of the Java utilites
      Scanner in = new Scanner (System.in);
      Random r = new Random(); 
      
      //Setting up variables
      int guess = 0;
      int random = 0;
      int total = 0;
      
      //Generate the random number
      random = r.nextInt(100) + 1;
            
         
      //Getting user input
      System.out.println("Welcome to the Higher/Lower game! Try to guess the number between 1 and 100.");
      System.out.println("Enter your guess:");
      guess = in.nextInt();
         
      do
      {   
         //Check for valid input
         while (guess <0 || guess >100)
         {
            System.out.println("Sorry, the guess needs to be a number between 1 and 100. Please try again:");
            guess = in.nextInt();
         }
         
         //Determine if guess is lower & count the number of guesses       
         if (random > guess)
         {
            total++;
            System.out.println("The number is higher.");
            System.out.println("Enter your guess:");
            guess = in.nextInt();
         }
         
         //Determine if the guess is higher & count the number of guesses
         if (random < guess)
         {
            total++;
            System.out.println("The number is lower.");
            System.out.println("Enter your guess:");
            guess = in.nextInt();
         }    
      }while(guess != random);
      
      //Print results
      total++;
      System.out.println("The number was " + random + "! You guessed correctly! It took you " + total + " tries.");
    
   } 
}