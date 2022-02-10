import java.io.*;
import java.util.*;

/**
WordRead is a class that allows user to input a filename via commandlind.
The file is read and converted to a linklist and list.

@author Nguyen
*/
public class WordRead{
    
    /**
    Given a file, reads in String from file, adds Strings to linked list, and converts linked list to String[].
    
    @param fname Filename
    @return String[] Array of strings read in from file
    */
    public static String[] get(String fname) {
        
        //Creates a scanner
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(fname));
        } catch(IOException e) {
            e.printStackTrace(); System.exit(1);
        }
        
        //Creates initial linked list
        StringNode linkedList = null; 
        
        //While there are strings, add string to linked list
        while ( sc.hasNext() ){
            String temp = sc.next();
            linkedList = ListStuff.addToFront(temp, linkedList);
        }
        
        //Flips the linked list
        StringNode linkedListFliped = null;
        for (StringNode t = linkedList; t != null; t = t.next){
            linkedListFliped = ListStuff.addToFront(t.data, linkedListFliped);
        }
        
        //Returns linkedList as String[]
        return ListStuff.listToArray(linkedListFliped);
    }

    public static void main(String[] args){
        //Reads in filename, return contents as String[]
        String[] A = get("nouns.txt");
        
        //Prints String[], outputted to look like a list
        System.out.print("[ ");
        for(int i = 0; i < A.length-1; i++) {
            System.out.print(A[i] + " , ");
        }
        System.out.print(A[A.length-1]+" ]");
        System.out.println("");
    }
}