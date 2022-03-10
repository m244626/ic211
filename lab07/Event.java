import java.util.*;
import java.io.*;
/**
Event class. This is the parent class for Income, Expenses, Probability, Payments classes.

This class stores the frequency, nextOccurance, name

@author Nguyen, Kenneth
*/
public class Event{

    private int frequency;
    private String frequencyType, name;
    private MyDate nextOccurence;

    /**
    Event constructor
    
    @param freq int, frequency
    @param freqType String: days, months, years
    @param nextOcc String: DD/MM/YYYY
    @param n String, name of Event
    */
    public Event(int freq, String freqType, String nextOcc, String n){
        this.frequency = freq;
        this.frequencyType = freqType;
        this.name = n;
        
        this.nextOccurence = parseDate( nextOcc );
        
        
    }
    
    /**
    Converts String date into a MyDate object
    
    @param date String: DD/MM/YYYY
    @return MyDate input String converted to MyDate class
    */
    private MyDate parseDate(String date){
        
        //Splits date by /
        String[] parts = date.split("/");
        
        //Parses for day, month, year
        int month = Integer.parseInt( parts[0] );
        
        int day = Integer.parseInt( parts[1] );
        
        int year = Integer.parseInt( parts[2] );
        
        //Creates a MyDate
        MyDate output = new MyDate( year, month, day );
        
        //Returns output
        return output;
    }


    /**
    Increments the date by frequency
    */
    public void incrementDate(){
        
        //Day
        if (this.frequencyType.equals("days")){
            this.nextOccurence.incDay( this.frequency );
            
        //Months
        } else if (this.frequencyType.equals("months")){
            this.nextOccurence.incMonth( this.frequency );
            
        //Years
        }else if (this.frequencyType.equals("years")){
            this.nextOccurence.incYear( this.frequency );
            
        }
        
        return;
    }
    
    /**
    Check occurence
    
    @param today MyDate of the day's date
    @return bool True if instance equals today; else, false
    */
    public boolean checkNextOccurence(MyDate today){
        if (this.nextOccurence.daysUntil(today) == 0)
            return true;
        return false;
        
    }
    
    /**
    toString
    
    @return name
    */
    public String toString(){
        return this.name;
    }
    
    /**
    Read a file in and creates a list of polymorphed Event classes
    
    @param sc Scanner of file to be read in
    @param n  Number of lines in file
    @param rand Random Number Generator object
    @return Event[]
    */
    public static Event[] readEvents(Scanner sc, int n, Random rand){
        Event[] Events = new Event[n];
        
        for (int i = 0; i < n; i++){
            //Reads the line, split on spaces
            String line = sc.nextLine();
            
            //Move all of this into a static Event.java method --------------------------------------------------------
            String[] Line = line.split(" ");   
            
            //Line[0] = every
            //Line[1] = int : frequency
            int frequency = Integer.parseInt( Line[1] );
            
            //Line[2] = String : frequencyType
            String frequencyType  = Line[2];
            
            //Line[3] = String : "start" or "for"
            String startOrFor = Line[3];
            
            //Start -> Income, Expense, Probability
            if (startOrFor.equals("start")){ 
                
                //Line[4] = String : Date DD/MM/YYYY
                String date = Line[4];
                
                //Line[5] = income / expense / prob
                String type = Line[5];
                
                    //income or expense
                if (type.equals("income") || type.equals("expense")){
                    //Line[6+] = name
                    String name = Line[6];
                    for (int j = 7; j < Line.length; j++)
                        name += " " + Line[j];
                        
                    //Creates Event class
                    Events[i] = new Event( frequency, frequencyType, date, name );   
                }
                
                    //prob
                else if (type.equals("prob") ){
                    //Line[6] = Double probability
                    double prob = Double.parseDouble(Line[6]);
                    
                    //Line[7] = expense, ignore
                    
                    //Line[8+] = name
                    String name = Line[8];
                    for (int j = 9; j < Line.length; j++)
                        name += " " + Line[j];
                        
                    //Creates Probability class
                    Events[i] = new Probability( frequency, frequencyType, date, name, prob, rand );
                    
                }
                
                
            }
            //For -> Payment
            else if (startOrFor.equals("for")){
                //Line[4] = int : duration
                int duration = Integer.parseInt( Line[4] ) ;
                
                //Line[5] = String : "start"
                
                //Line[6] = String : date
                String date = Line[6];
                
                //Line[7] = String : "expense"
                
                //Line[8+] = name
                String name = Line[8];
                for (int j = 9; j < Line.length; j++)
                    name += " " + Line[j];
                    
                //Creates Payment class
                Events[i] = new Payment( frequency, frequencyType, date, name, duration);
            }
           
        }
        return Events;
        
    }
    
    
}