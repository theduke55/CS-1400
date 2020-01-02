import java.util.*;

public class Assignment11
{
   private static boolean isError = false;
   private static double money = 0.0;
   
   static Scanner in = new Scanner (System.in);
   
   public static void main (String[] args)
   {
      String userName = "";
      int userInput = 0;
      
      
      
      //Greeting and collection of users name
      System.out.println("Welcome to the Bank of Trevor");
      System.out.println("Please enter your name to create an account:");
      userName = in.nextLine();
      
      BankAccount ba = new BankAccount(userName, 12345);
      
      //Collecting users choice      
      do
      {
         System.out.println("Press 1 to make a deposit");
         System.out.println("Press 2 to make a withdrawal");
         System.out.println("Press 3 to get account information");
         System.out.println("Press 4 to quit");
         
         do
         {  
            isError = false;
                
            try
            {
               userInput = in.nextInt();
               if(userInput < 1 || userInput > 4)//checking for number outside of bounds
               {
                  System.out.println("Invalid choice, please enter a number between 1 and 4.");
                  isError = true;
               }
            }
            catch(InputMismatchException e)//checking for other char's
            {
               System.out.println("Invalid choice, please enter a number between 1 and 4.");
               isError = true;
               in.nextLine();//Flush the buffer
            }
            
         }//error handling do statement
         while(isError == true);
         
         switch(userInput)
               {
                  case 1:
                     System.out.println("Please enter the amount to deposit: ");
                     CheckMoney();
                     ba.deposit(money);
                     break;
                  
                  case 2:
                     System.out.println("Please enter the amount of the withdrawal: ");
                     CheckMoney();
                     while(money > ba.getBalance())
                     {
                        System.out.println("Insufficient funds - Account currently has: " + ba.getBalance());
                        System.out.println("Please enter a new amount to withdraw.");
                        CheckMoney();
                     }
                     ba.withdraw(money);
                     break;
                     
                  case 3:
                     System.out.println("Name: " + ba.getName() + " Account #: " + ba.getAccountNum() + " Balance: " + ba.getBalance());
                     break;         
               }
               
      }//user's choice do statement
      while(userInput != 4);
         
      System.out.println("Thank you come again");
   }//end main
   
   public static void CheckMoney()
   {      
      do
         {  
            isError = false;
                
            try
            {
               money = in.nextDouble();
               if(money <= 0)//checking for number outside of bounds
               {
                  System.out.println("Invalid choice, please enter an amount greater than zero.");
                  isError = true;
               }
            }
            catch(InputMismatchException e)//checking for other char's
            {
               System.out.println("Invalid choice, please enter a positive number.");
               isError = true;
               in.nextLine();//Flush the buffer
            }
            
         }//error handling do statement
         while(isError == true);
   }
}//end class