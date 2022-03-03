import java.util.*;
import java.io.File;

/**
Search Class.
This is the main program.

This utilizes the Tweet.java file
*/

public class Search{
    
    
    
    public static void main(String[] args){
        
        //Checks if valid input is put in command line
        if ( args.length != 1 ){
            System.out.println("usage: java Search <tweets-file>");
            System.exit(1);
        }
        
        //Make a Queue via file input
        Queue queue = Tweet.readFile( args[0] );

        //Prints array size
        //System.out.println("Queue size: " + queue.length() );
        
        //Prints tweets
        //
        
        //Makes a scannner and input variable
        Scanner sc = new Scanner(System.in);
        String input = "";
        Queue filteredQueue = queue;
        
        
        //While input is not !quit
        while ( !(input.equals("!quit")) ){
            
            //Prints array size
            System.out.println("Queue size: " + filteredQueue.length() );
            
            //Asks User for input
            System.out.print("? ");
            input = sc.next();
            
            //Commands
            
                //!dump -> prints queue
            if (input.equals("!dump")){
                filteredQueue.printAll();
            }
            
                //!reset -> sets filtered Queue to original Queue
            else if (input.equals("!reset")){
                filteredQueue = queue;
            }
        
                //!quit -> prints goodbye and quits
            else if (input.equals("!quit")){
                System.out.println("Goodbye!");
                break;
            }
            
                //If first char of input is -, filter for not keyword
            else if (input.charAt(0) == '-'){
                //Only filter the input without the tack "-" at index 0
               filteredQueue = filteredQueue.filterForNotKeyword( input.substring(1) );
            }
            
            //If first char of input is +, filter for date
            else if (input.charAt(0) == '+'){
                //Only filter the input without the tack "-" at index 0
               filteredQueue = filteredQueue.filterForDate( input.substring(1) );
            }
                //Else, filter for not keyword
            else{
                filteredQueue = filteredQueue.filterForKeyword(input);
            }
            
        }
    }

}