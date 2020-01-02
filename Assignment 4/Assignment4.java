import java.util.Scanner;

public class Assignment4
{

   public static void main (String[] args)
   {
      Scanner in = new Scanner (System.in);
      
      String userInput = ""; //English word
      String pigLatin = ""; //Pig Latin word      
      
      //Greeting and user input
      System.out.println("Welcome to the Pig Latin Translator!");
         
      do
      {
         System.out.print("Please enter a word (or press Q to quit): ");
         userInput = in.nextLine();
         userInput = userInput.toUpperCase();
         translation(userInput); 
                        
      } while (!userInput.equalsIgnoreCase("Q"));
   
   }
   
   public static void translation (String input) //Translation method for users English word to Pig Latin word
   {
   
      String originalWord = input; //users entered word
      String consonants = ""; //string of characters up to the first vowel
      String leftover = ""; //characters from initial vowel to the end
      String translatedWord = ""; //Pig Latin translation
      
      
      //if statement that places "way" at the end if a word that begins with a vowel
      if (originalWord.charAt(0) == 'A'||
         originalWord.charAt(0) == 'E' ||
         originalWord.charAt(0) == 'I' ||
         originalWord.charAt(0) == 'O' ||
         originalWord.charAt(0) == 'U')
      {
      System.out.println(originalWord + "WAY");
      }
      
      
      // if word doesn't start with vowel, re-arrange word and store in variable
      else
      {
      
         for (int i = 0; i < originalWord.length(); i++)
         {
            if (originalWord.charAt(i) == 'A'||
               originalWord.charAt(i) == 'E' ||
               originalWord.charAt(i) == 'I' ||
               originalWord.charAt(i) == 'O' ||
               originalWord.charAt(i) == 'U')
            {   
            leftover = originalWord.substring(i);
            consonants = originalWord.substring(0,i); 
            translatedWord = leftover.concat(consonants).concat("AY");    
            
            System.out.println(translatedWord);   
            return;
               }      
         } //for
      } //else
   } // Translation Method
} //class