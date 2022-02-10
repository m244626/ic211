/**
This RandomWordLitRhyme extends RandomWordLit, which extends RandomWord.
next() only return words that start with the same letter and final 2 chars

@author Nguyen, Kenneth
*/
public class RandomWordLitRhyme extends RandomWordLit{
    
    char penultimateLetter = '\0';
    char lastLetter = '\0';
    
    /**
    RandomWordLitRhyme constructor. 
    Utilizes the super class's constructor to seed randnum generator
    
    @param seed Long value used for seeding the randnum generator
    */
    public RandomWordLitRhyme(long seed){
        super(seed);
    }
    
    /**
    Overloaded version of RandomWordLit's next()
    Only returns words that have the same first letter and same last 2 letters
    
    @return String String that have the same first letter and same last 2 letters
    */
    public String next(){
        
        //Get random word from RandomWordLit (word starts with the same letter)
        String temp = super.next();
        
        //Gets length of temp
        int length = temp.length();
        
        //if letter is null, set first char 
        if (this.penultimateLetter == '\0') {
            this.penultimateLetter = temp.charAt( length-2 );
            this.lastLetter = temp.charAt( length - 1);
        } 
        
        //While temp doesn't end with the last 2, get a new one
        while (temp.charAt( length-2 ) != this.penultimateLetter ||
            temp.charAt( length-1 ) != this.lastLetter){
            
            //Get a new random Word
            temp = super.next();
            
            //Gets length of temp
            length = temp.length();
        }
        
        return temp;
    }
    
    
}