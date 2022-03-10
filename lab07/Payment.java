/**
Payment class extends Event
Allows for the Event to only happen (length) amount of times

@author Nguyen, Kenneth
*/

public class Payment extends Event{
    
    private int length;

    /**
    Payment constructor

    @param freq int, frequency
    @param freqType String: days, months, years
    @param nextOcc String: DD/MM/YYYY
    @param n String, name of Event
    @param l int, number of times event can occur
    */
    public Payment(int freq, String freqType, String nextOcc, String n, int l){
        
        super(freq, freqType, nextOcc, n);
        this.length = l;
        
    }
    
    /**
    Overrides incrementDate()
    Adds the ability to track number of Event occurences
    
    Reduces length by one each time
    */
    public void incrementDate(){
        super.incrementDate();
        length --;
    }
    
    /**
    Overrides checkNextOccurence
    
    Check occurence
    If length is 0, checkNextOccurence() no longer works.
        Thus Event is no longer printed
        
    @param today MyDate of the day's date
    @return bool True if instance equals today; else, false
    */
    public boolean checkNextOccurence(MyDate today){
        if (this.length > 0 && super.checkNextOccurence(today))
            return true;
        return false;
        
    }
    
    
}