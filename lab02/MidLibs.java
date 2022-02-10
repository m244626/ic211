/**
The program takes a filename and prints the words in that file within 35 columns. 
The input filename will come as a command-line argument

@author Nguyen
*/
import java.util.*;

public class MidLibs 
{
    
    public static void main(String[] args){
        
        //Checks for valid user input
        if ( args.length == 0 ){
            System.out.println("usage: java MidLibs <filename>");
            return;
        }
        
        String[] words = WordRead.get(args[0]);
        
        //Read in nouns.txt, verbs.txt, adjectives.txt
        String[] nounList = WordRead.get( "nouns.txt" );
        String[] verbList = WordRead.get( "verbs.txt" );
        String[] adjectiveList = WordRead.get( "adjectives.txt" );
        
        //Sets up random
        Random rand = new Random(890);
        
        //For loop to iterate through words
        for (int i = 0; i < words.length; i++){
            
            //If word[i] equals @noun, @nounp, @verb, @adjective, swap them out
                //@verb
            if (words[i].equals("@verb")){
                int myrand = rand.nextInt( verbList.length );
                words[i] = verbList[ myrand];
            }
                //@noun
            else if (words[i].equals("@noun")){
                int myrand = rand.nextInt( nounList.length );
                words[i] = nounList[ myrand];
            }
                //@nounp
            else if (words[i].equals("@nounp")){
                int myrand = rand.nextInt( nounList.length );
                words[i] = nounList[ myrand] + "s";
            }
                //@adjective
            else if (words[i].equals("@adjective")){
                int myrand = rand.nextInt( adjectiveList.length );
                words[i] = adjectiveList[ myrand];
            }

        }
        
        Formatter.writeInColumns(words, 35);
        
    }
}