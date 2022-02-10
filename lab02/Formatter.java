/**
Intake a positive int and an array of strings. Print out the strings with spaces
in a line with less than int amount of chars.
@author Tabler, Samuel
*/
import java.util.*;

public class Formatter
{
  /**
  takes an array A of strings and a positive int "cols" and prints the strings
  from A out, in order, separated by spaces, but never using more than "cols"
  characters (including spaces!) in a line.
  @param A, array of strings
  @param cols, postive integer
  */
  public static void writeInColumns(String[] A, int cols)
  {
      
    //Stores words
    String output = "";
      
    //Counts chars in output
    int j = 0;
    
    
    
    for (int i = 0; i < A.length; i++){
      //Adds word length to j
      j += A[i].length();
      
      //If j is now too big, don't add word
      if(j > cols)
        {
          //Removes ending space
          output = output.substring(0, output.length()-1);
          
          //Prints output
          System.out.println(output);
          
          j = 0;
          output = A[i] + " ";
          j++;
          j += A[i].length();
        }
      
      //Else, add word to output
      else if (j <= cols)
      {
        output += A[i] + " ";
        j++; //space
      }
    }
    
    //Prints last line
        //Removes ending space
    output = output.substring(0, output.length()-1);
    
        //Prints output
    System.out.println(output);
  }

  public static void main(String[] args)
  {
    String[] A = new String[8];
    A[0] = "These";
    A[1] = "are";
    A[2] = "the";
    A[3] = "times";
    A[4] = "that";
    A[5] = "try";
    A[6] = "men's";
    A[7] = "souls.";

    writeInColumns(A, 15);

    return ;

  }
}