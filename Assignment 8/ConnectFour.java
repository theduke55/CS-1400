import java.util.*;
import java.lang.Throwable;

public class ConnectFour
{
   static char [][] gameBoard = new char[6][7];
   static Scanner in = new Scanner (System.in);
   static boolean noWinner = true; //variable for error handling  
   static int userFlag = 0;
   
   public static void printBoard()//setting up the board layout
         {
          for(int row = 0; row < 6; row++) //6 rows
          { 
            System.out.print("|");
            for(int column = 0; column < 7; column++) //7 columns
            {
               
               System.out.print(" " + gameBoard[row][column] + " |");
         
            }
            System.out.println();
          }
                     
         }//printBoard
         
         
   public static void main(String[] args)
   {
      String name = " ";//userInput variable      
      
      //clearing the board with empty spaces
      for(int row = 0; row < 6; row++)
         { 
            for(int column = 0; column < 7; column++)
            {
               
               gameBoard[row][column] = ' ';
            
            }
         }
      
      
      //Get user info
      System.out.println("Please enter your name:");
      name = in.nextLine();
      
      printBoard();
      while (noWinner == true)
      {            
         try //Error handling
         {         
            userInput();
               if(checkRows() || checkColumns() || checkDiagonals())
               {
                  System.out.println(name + " Wins!");
                  noWinner = false;               
               }
               else
               {
                  computerInput();
                     if(checkRows() || checkColumns() || checkDiagonals())
                     {
                        System.out.println("Computer Wins.");
                        noWinner = false;
                     }
               } 
         }           
         catch (InputMismatchException e)//inputs are anything other than an integer
         {
            System.out.println("Error: Please input a valid entry using a number.");
            in.nextLine();//Flush the buffer
            continue;//go back to try
         }
         catch (ArrayIndexOutOfBoundsException e)//inputs are integers outside of the range
         {
            System.out.println("Error: Please input a valid range between 1-7.");
            continue;
         }
                  
         printBoard();
         
      }//while      
   }// main
   
      
   public static void userInput()
   {
      int userColumn = 0;
      boolean validInput = false;
            
      while(validInput == false)
      {
         System.out.println("Enter the column number to drop a tile (1-7)");
         userColumn = in.nextInt();
         
         if(gameBoard[0][userColumn -1] == ' ')//checking top row for an empty spot in the user selected column        
         {  
            int row = 5;
            while (gameBoard[row][userColumn -1] != ' ' && row > 0)
            {
               row--;
            }  
            gameBoard[row][userColumn -1] = 'r';      
            validInput = true;
         }
         else
         {
            System.out.println("Error: Please select an empty column.");
         }
      }  
   }//userInput
   
   public static void computerInput()
   {
   
      Random r = new Random();
      int aiGuess = 0;
      boolean validInput = false;
      
      while(validInput == false)
      {
         aiGuess = r.nextInt(7);//generating a random number between 0 and 6 for the column selection
         if(gameBoard[0][aiGuess] == ' ')//checking top row for an empty spot        
            {  
               int row = 5;
               
               while (row > 0 && gameBoard[row][aiGuess] != ' ')//checking full column for empty space
               {
               row--;//increase each row by 1 until finding a filled space
               }
               gameBoard[row][aiGuess] = 'b';
               
               validInput = true;          
            }
         else
            {
               continue;
            }
      }      
         
   }//computerInput  
   
   public static boolean checkRows()//Horizontal checking
   {  
      boolean isWinner = false;
      
      for (int row = 0; row < 6; row++)//checking rows 0 to 5
      {
         for (int column = 0; column < 4; column++)//checking columns 0 to 3
         {
            //System.out.println("row: " + row + ", column: " + column);
            if(gameBoard[row][column] != ' ' && (gameBoard[row][column] == gameBoard[row][column+1] && gameBoard[row][column] == gameBoard[row][column+2] && gameBoard[row][column] == gameBoard[row][column+3]))
            {   
            return isWinner = true;   
            }  
         }
      }
      return false;
   }//checkRows
   
   public static boolean checkColumns()//Vertical checking
   {
      boolean isWinner = false;
      
      for (int row = 0; row < 3; row++)//checking rows 0 to 2
      {
         for (int column = 0; column < 6; column++)//checking columns 0 to 6
         {
            if (gameBoard[row][column] != ' ' && (gameBoard[row][column] == gameBoard[row+1][column] && gameBoard[row][column] == gameBoard[row+2][column] && gameBoard[row][column] == gameBoard[row+3][column]))
            {
               return isWinner = true;
            }
         }
      }
      return false;
   }//checkColumns 
   
   public static boolean checkDiagonals()
   {
      boolean isWinner = false;
      
      //checking left to right
      for (int row = 0; row < 3; row++)//checking rows 0 to 2
      {
         for (int column = 0; column < 4; column++)//checking columns 0 to 3
         {
            if (gameBoard[row][column] != ' ' && (gameBoard[row][column] == gameBoard[row+1][column+1] && gameBoard[row][column] == gameBoard[row+2][column+2] && gameBoard[row][column] == gameBoard[row+3][column+3]))
            {
               return isWinner = true;
            }
         }
      }
      
      //checking right to left
      for (int row = 0; row < 3; row++)//checking rows 0 to 2
      {
         for (int column = 3; column < 7; column++)//checking columns 3 to 6
         {
            if (gameBoard[row][column] != ' ' && (gameBoard[row][column] == gameBoard[row+1][column-1] && gameBoard[row][column] == gameBoard[row+2][column-2] && gameBoard[row][column] == gameBoard[row+3][column-3]))
            {
               return isWinner = true;
            }
         }
      }
      return false;
   }//checkDiagonals 
   
}//class
