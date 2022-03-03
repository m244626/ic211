import java.util.*;
import java.io.File;

/**
This is Tweet Class
This is a linked list node that contains Strings text, user, and date of a tweet
*/


public class Tweet{
    
    private String text, user;
    private int year, month, day;
    
    /**
    Tweet Constructor if given 3 String values
    
    @param newtext String of Tweet's text value
    @param newuser String of Tweet's user
    @param newdate String of Tweet's date in YEAR-MO-DA form
    */
    public Tweet(String newtext, String newuser, String newdate) {
        
        //Assigns string values
        this.text = newtext;
        this.user = newuser;
        
        //Converts date to int
            //Splits newdate by '-'
        String[] date = newdate.split("-");
        
            //Converts each part of newdate to int and save
        this.year  = Integer.parseInt( date[0] );
        this.month = Integer.parseInt( date[1] );
        this.day   = Integer.parseInt( date[2] ); 
    }
    
    /**
    Given a tweet as a single String, return a Tweet
    
    @param String Tweet as one String
    @return Tweet Tweet String converted to a Tweet
    */
    public static Tweet makeTweet(String line){
       
        //Splits line by \t
        String[] values = line.split("\t");
        
        //Reads in by \t
        String newtext = values[0];
        String newuser = values[1];
        String newdate = values[2];
        
        //Return
        return new Tweet(newtext, newuser, newdate);
    }
    
    /**
    Given a filename, readFile creates a Tweet[], size 33, filled with Tweet objects
    
    @param path Filename of document with tweet
    */
    public static Queue readFile(String path) {
        
 
        //If file exists, make queue, read in data, make Nodes, return queue
        try{
            Scanner sc = new Scanner(new File(path));
            
            Queue tweetList = new Queue();
            
            //While lines can be read in
            while (sc.hasNextLine()){      
                //Read in one line
                String line = sc.nextLine();

                //If the line is blank
                if (line.equals("\n") || line.equals("")){
                    break;
                }  
                
                //Make tweet and add to queue
                tweetList.enqueue( Tweet.makeTweet(line) ); 
                
                
            }
            
            //Return Queue
            return tweetList;
        
        //Error catch for scanner
        }catch(Exception e){ 
            System.out.println("ERROR: " + e);
            System.exit(1);
        }
        
        return null;
        
    }
    
    /**
    Method checks to see if the tweet's text contains keyword
    
    @param keyword String contained in tweet
    @return boolean True if keyword is in text; False if keyword is not in text
    */
    boolean containsKeyword(String keyword){
        //Converts text to lowercase and checks if keyword is in it
        return ( this.text.toLowerCase() ).contains( keyword.toLowerCase() );
        
    }
    
    
    
    /**
    Default Java conversion to String.
    Converts instance Tweet to String
    
    @return String Tweet values as one String
    */
    public String toString(){
        
        return  text + "\t[" + user + "]\t" + month + "/" + day + "/" + year;
        
    }

}