import java.util.*;

/**
This is Rotor Class. 
It's values consists of the Rotor's alphabet and when to rotate.
The methods can: return a char given an index; return an index given a char; rotate a gear

@author Nguyen, Kenneth
*/

public class Rotor{
    
    private String Gear;
    private final char rotateOn;
    
    /**
    This is the Rotor Constructor. 
    
    @param Gear String of 27 characters, consisting of A to Z and #
    @param c Char c; used to set the index value
    */ 
    public Rotor(String Gear, char c){
        
        //Sets String Gear
        this.Gear = Gear.substring( Gear.indexOf(c) ) + Gear.substring( 0, Gear.indexOf(c) );
        
        //Remembers what letter the gear started on
        this.rotateOn = c;
       
    }
    
    /**
    Instance method that returns char if given an index
    
    @param int   Index: location of char wanted
    @return char Char that the Rotor is on
    */ 
    public char getChar(int i){
        return this.Gear.charAt(i);
    }
    
    /**
    Instance method that returns int of given char
    
    @param char Char: Desired char
    @return int index: returns index of char
    */ 
    public int getIndex(char c){
        return this.Gear.indexOf(c);
    }
    
    
    /**
    Instance method that rotates the Rotor by -1.
    
    @param decrement if the function is true.
    @return bool Returns false is not rotated; Returns true if rotated.
    */
    public boolean rotateByOne( boolean decrement ){
        
        //If decrement is true, rotate gear
        if (decrement){
            
            //Moves last char to front
            this.Gear = this.Gear.charAt(26) + this.Gear.substring(0, 26);
            
            //If gear is on the letter it started on, tell next gear to increment
            if (this.Gear.charAt(0) == rotateOn ){
                return true;
            }
        }
        
        //Default is false
        return false;
    }
    
    public static void main(String[] args){
        
        //Makes Rotor
        Rotor Rotor1 = new Rotor("#ABCDEFGHIJKLMNOPQRSTUVWXYZ", 'Z');
        
        //Prints Gear Value
        System.out.println(Rotor1.Gear);
        
        //For Loop to test Rotate
        for (int i = 0; i < 30; i++){
            Rotor1.rotateByOne(true);
            System.out.println(Rotor1.Gear);
        }   
    }   
}
    