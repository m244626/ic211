import java.util.*;
/**
Probability class extends Event

This Event occures every (frequency) (frequencyType) at a probabilty of (probability)

@author Nguyen, Kenneth
*/
public class Probability extends Event{

    private double probability;
    private Random rand;
    
    /**
    Probability constructor

    @param freq int, frequency
    @param freqType String: days, months, years
    @param nextOcc String: DD/MM/YYYY
    @param n String, name of Event
    @param prob double, probability of event happening
    @param r Random, Random number object
    
    */
    public Probability(int freq, String freqType, String nextOcc, String n, double prob, Random r){
        
        super(freq, freqType, nextOcc, n);
        this.probability = prob;
        this.rand = r;
        
    }
    
    /**
    Overrides checkNextOccurence()
    
    If the days match, make a random number and see if the event happens.
        If the event does not happen due to probability, increment day, false
    
    */
    public boolean checkNextOccurence(MyDate today){
        
        if (super.checkNextOccurence(today)){
        
            //Uses RNG to make a double between 0.0 and 1.0
            double num = this.rand.nextDouble();
            
            //Checks if RNG is less than probabilty, skip today
            if (num > this.probability){
                
                //Increments date for next event
                super.incrementDate();
                
                //Return false is event didn't happen
                return false;
                
            }
            
            //Return true if probabilty is good
            return true;
            
            
        }
        //Return false if next occurence is not today
        return false;    
        
        
        
        
    }
    
}