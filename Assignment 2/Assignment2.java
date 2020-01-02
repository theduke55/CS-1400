import java.util.Scanner;

public class Assignment2
{

   public static void main (String[] args)
   {
   
        Scanner in = new Scanner (System.in);
        
        //Setting up my variables
        String month = "";
        int day = 0;
        int year = 0;
        
        //Requesting Users DOB
        System.out.println("Enter the month were you born: ");
        month = in.nextLine();
        
        System.out.println("Enter the day were you born: ");
        day = in.nextInt();
        
        System.out.println("Enter the year were you born:");
        year = in.nextInt();
        
        
        //Calculating retirement year
        year = year + 67;
        
        
        //Printing results
        System.out.println("You will retire on " + month + " " + day + ", " + year + ".");
        
   
   
   
   }


}