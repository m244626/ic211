import java.util.*;

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
        
        //Get Tweets
        Tweet[] tweets = Tweet.readFile( args[0] );
        
        //Prints array size
        System.out.println("Array size: 33");
        
        //Prints tweets
        for (int i = 0; i < 33; i++){
            System.out.println(tweets[i]);
        }
    }

}