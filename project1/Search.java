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
        
        //Make a Queue
        Queue queue = Tweet.readFile( args[0] );

        //Prints array size
        System.out.println("Queue size: " + queue.length() );
        
        //Prints tweets
        queue.printAll();
        
    }

}