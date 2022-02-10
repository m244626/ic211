/**
RandomWordLit class extends RandomWord.
next() only return words that start with the same letter

@author Nguyen, Kenneth
*/

public class RandomWordLit extends RandomWord {
    
    char letter = '\0';
    
    /**
    RandomWordLit constructor. 
    Utilizes the super class's constructor to seed randnum generator
    
    @param seed Long value used for seeding the randnum generator
    */
    public RandomWordLit(long seed){
        super(seed);
    }
    
    /**
    Overloaded version of RandomWord's next()
    Only returns words that start with the same letter as the first created word
    
    @return String String that starts with same letter as first word
    */
    public String next(){
        
        //Get random word from RandomWord
        String temp = super.next();
        
        //if letter is null, set first char 
        if (this.letter == '\0') {
            this.letter = temp.charAt(0);
        } 
        
        //While temp doesn't start with the letter, get a new one
        while (temp.charAt(0) != this.letter){
            temp = super.next();
        }
        
        return temp;
    }
    
}