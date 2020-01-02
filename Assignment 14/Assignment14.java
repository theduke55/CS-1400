import java.util.*;

public class Assignment14
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner (System.in);
      Random r = new Random();
      int number = r.nextInt(37);
      Roulette R = new Roulette();
      R.betOnce(in, number);
      
      
   }//end of main
}//end of class