import java.util.*;

public class Roulette
{
   public void betOnce (Scanner in,int randomNumber)
   {
      int usersBet = 0;
      boolean error = true;
      
      do
      {
         error = false;
         try
         {
         //Gathering users data
         System.out.println("Do you want to bet on 1) low or 2) high?");
         usersBet = in.nextInt();
         
         //Error Handling
         while(usersBet != 1 && usersBet != 2)
         {
            System.out.println("Please enter 1 for a low bet or 2 for a high bet.");
            usersBet = in.nextInt();
            error = true;
         }//end of while
         }//end of try
         catch(InputMismatchException e)
         {
            System.out.println("Invalid entry: Please enter 1 for a low bet or 2 for a high bet.");
            in.nextLine();//flush the buffer
            error = true;
         }//end of catch
      }while(error == true);//end of do/while
      
      System.out.println("The number was: " + randomNumber);
      
      if((usersBet == 1 || usersBet == 2) && randomNumber == 0)//if random falls on zero
      {
         System.out.println("You lose");
      }
      else if(usersBet == 1 && randomNumber <= 18)//if guess is low and number is low
      {
         System.out.println("You Win");
      }
      else if(usersBet == 2 && randomNumber <= 18)//if guess is high and number is low
      {
         System.out.println("You lose");
      }
      else if(usersBet == 2 && randomNumber >= 19)//if guess is high and number is high
      {
         System.out.println("You Win");
      }
      else if(usersBet == 1 && randomNumber >= 19)//if guess is low and number is high
      {
         System.out.println("You lose");
      } 
      
   }// end of betOnce
}// end of Roulette