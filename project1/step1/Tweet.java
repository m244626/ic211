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
    Tweet Constructor
    
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
    Given a filename, readFile creates a Tweet[], size 33, filled with Tweet objects
    
    @param path Filename of document with tweet
    */
    public static Tweet[] readFile(String path) {
        
 
        //If file exists, do everything
        try{
            Scanner sc = new Scanner(new File(path));

            //Creates a Tweet[] with 33 Tweets
            Tweet[] tweetList = new Tweet[33];

            //Reads in Tweet values
            for (int i = 0; i < 33; i++){
                
                //Reads textfile by line
                String line = sc.nextLine();
                
                //Splits line by \t
                String[] values = line.split("\t");
                
                //Reads in by \t
                String newtext = values[0];
                String newuser = values[1];
                String newdate = values[2];
                
                //Constructs tweet
                tweetList[i] = new Tweet(newtext, newuser, newdate);
                
            }

            return tweetList;
            
        }catch(Exception e){ 
            System.out.println("ERROR: Invalid File Name \"" + path + "\"");
            System.exit(1);
        }
        
        return null;
        
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