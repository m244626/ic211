import java.util.*;

/**
This is Rotor Class.

@author Nguyen, Kenneth
*/

public class Rotor{
    
    private String Gear;
    private int index;
    
    private char set;
    
    /**
    This is the Rotor Constructor. 
    
    @param Gear String of 27 characters, consisting of A to Z and #
    @param c Char c; used to set the index value
    */ 
    public Rotor(String Gear, char c){
        
        //Sets String Gear
        //this.Gear = Gear.substring( Gear.indexOf(c) ) + Gear.substring( 0, Gear.indexOf(c) );
        
        //Sets index by finding index of char
        this.index = Gear.indexOf(c);
        private char set
        
    }
    
    /**
    Instance method that returns char if given an index
    
    @param int   Index: location of char wanted
    @return char Char that the Rotor is on
    */ 
    public char getChar(int i){

        //Gets char At (desired location + rotation) while staying within 0-26
        
        //return this.Gear.charAt(0);
        
        return this.Gear.charAt( (i+this.index)%27 );

    }
    
    /**
    Instance method that returns int of given char
    
    @param char Char: Desired char
    @return int index: returns index of char
    */ 
    public int getIndex(char c){
        
        //return this.Gear.indexOf(c);

        //Finds location of c, accounts for rotation, stay within 0-26
        return ((27-this.index) + this.Gear.indexOf(c) + account)%27;
    }
    
    
    /**
    Instance method that rotates the Rotor by one.
    
    @param increment if the function is true.
    @return bool Returns false is not rotated; Returns true if rotated.
    */
    
    public boolean rotateByOne( boolean increment ){
        
        if (increment){
            
            //Increment index by 1
            this.index++;
            
            //this.Gear = this.Gear.charAt(26) + this.Gear.substring(0, 26);
            
            //Checks if index is  27
            if (this.index >= 27){
                
                //Sets index back to 0; Returns true
                this.index = 0;
                return true;
            }
        }
        
        //Default is false
        return false;
    }
    
    /**
    Instance method that rotates the Rotor by -1.
    
    @param decrement if the function is true.
    @return bool Returns false is not rotated; Returns true if rotated.
    */
    
    public boolean reverseByOne( boolean decrement ){
        
        if (decrement){
            
            //Decrement index by 1
            this.index -= 1;
            
            //this.Gear = this.Gear.charAt(26) + this.Gear.substring(0, 26);
            
            //Checks if index is less than 1
            if (this.index < 0){
                
                //Sets index forward to 26; Returns true
                this.index = 26;
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
        System.out.println("I: " + Rotor1.index + " " + Rotor1.getChar(0) );
        for (int i = 0; i < 30; i++){
            Rotor1.rotateByOne(true); 
            System.out.println("I: " + Rotor1.index + " " + Rotor1.getChar(0) + " " + Rotor1.getIndex('A') );
        }   
    }   
    
    
    
    
    public void outputGear(){
        System.out.println(this.Gear + " : " + this.index + " - " + this.Gear.charAt(this.index) );
    }
    
    
}