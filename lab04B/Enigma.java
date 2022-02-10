import java.util.*;

/**
This is Enigma Class.
This class consists of 3 rotors, created from 5 possible alphabet sets.
The methods can encrypt or decyrpt a message after properly constructed.

@author Nguyen, Kenneth
*/

public class Enigma{
    
    private Rotor Rotor1;
    private Rotor Rotor2;
    private Rotor Rotor3;
    
    /**
    This is the Engima Constructor. Takes 3 Gear IDs and a String, defines 3 Rotors.
    
    @param id1 Int; Picks Gear for Rotor 1
    @param id2 Int; Picks Gear for Rotor 2
    @param id3 Int; Picks Gear for Rotor 3
    @param set String of 3 chars; used to set each Rotor to a specific value
    */ 
    
    public Enigma(int id1, int id2, int id3, String set){
        //Defining the 5 Possible Rotors (0-4)
        final String[] GEARS = {"#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV", "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE", "#TGOWHLIFMCSZYRVXQABUPEJKND" };
        
        //Constructing Rotors
            //Gear[id-1] gets a String from GEAR
            //set.charAt(0) gets the char from set
        this.Rotor1 = new Rotor( GEARS[id1-1], set.charAt(0) );
        this.Rotor2 = new Rotor( GEARS[id2-1], set.charAt(1) );
        this.Rotor3 = new Rotor( GEARS[id3-1], set.charAt(2) );
        
    }
    
    /**
    Encyrpts a message via Enigma
    
    @param message String to be encrypted
    @return String Encrypted message
    */
    public String encrypt(String message){
        
        //Encrypted Message
        String encrypted = "";
        
        //For each char
        for (int i = 0; i < message.length(); i++){
            
            
            //Gets the current char
            char c = message.charAt(i);
            
            //Get index of inner
            int index1 = Rotor1.getIndex(c);
            
            //Use index of inner to get outer char
            char char3 = Rotor3.getChar(index1);
            
            //Use Outer char to find index in Middle
            int index2 = Rotor2.getIndex(char3);
            
            //Use Middle index to get char in outer
            char char3B = Rotor3.getChar(index2);
            
            
            //Set char in message
            encrypted += char3B;
            
            //Rotates all the Rotors
            Rotor3.rotateByOne( Rotor2.rotateByOne( Rotor1.rotateByOne(true) ) ); 
        }
        
        //Returns encrypted message
        return encrypted;
    } 
    
    public String decrypt(String message){
        
        //Decrypted Message
        String decrypted = "";
        
        //For each char
        for (int i = 0; i < message.length(); i++){
            
            //Gets the current char
            char c = message.charAt(i);
            
            //Use given char to get middle index.
            int index2 = Rotor3.getIndex(c);
            
            //Use middle index to get outer char
            char char3 = Rotor2.getChar(index2);
            
            //Use outer char to get index of inner
            int index1 = Rotor3.getIndex(char3);
            
            //Use index of inner to get char
            char output = Rotor1.getChar(index1);
            
            //Set char in message
            decrypted += output;
            
            //Rotates all the Rotors
            Rotor3.rotateByOne( Rotor2.rotateByOne( Rotor1.rotateByOne(true) ) ); 
            
        }
        
        //Returns encrypted message
        return decrypted;
    } 
    
    
}