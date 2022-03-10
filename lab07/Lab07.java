/**
This is the main class driver for IC211 Lab07.

Given a file of events, create a financial calendar for input days
usage: java Lab07 <infilename> <numDays>

@author Nguyen, Kenneth
*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class Lab07{
    
    /**
    Main method for Lab07
    
    Takes CL input, parses through infilename, creates Events, output days with events
    
    @param args Command-Line input
    */
    public static void main(String[] args){
        
        //Validating CL input
        if ( args.length != 2 && args.length != 3) {
            System.out.println("usage: java Lab07 <infilename> <numDays>");
            System.exit(1);
        }
        
        //Creates random seed from input / random value
        Random rand;
        if (args.length == 3)
            rand = new Random( Long.parseLong( args[2] ) );
        else
            rand = new Random(System.currentTimeMillis());
        
        //Gets how many lines file is
        int n = -1;
        try{
            n = FileLineCounter.countLines( args[0] );
        }catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }
        
        //Creates a scanner for file
        Scanner sc = null;
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        
        //Creates Events: as many as input file
        Event[] Events = Event.readEvents(sc, n, rand);
        
        //Set today to 1/1/2017
        MyDate today = new MyDate(2017,1,1);
        
        //Simulates Days: as many as input num
        int simulatedDays = Integer.parseInt( args[1] );
        for( int j = 0; j < simulatedDays; j++){
            
            //Records if anything is printed for that day
            boolean firstPrinted = true;
            
            //For each event,
            for (int i = 0; i < n; i++){

                //Ask each event whether they have something going on today                
                if ( Events[i].checkNextOccurence( today ) ){
                    
                    //Prints the first without comma
                    if (firstPrinted){
                        System.out.print(today + ": ");
                        System.out.print(Events[i]);
                        firstPrinted = false;
                    }//Prints the rest with commas
                    else{
                        System.out.print(", " + Events[i]);
                    }
                    
                    //Increments date
                    Events[i].incrementDate();
                    
                }
            }
            
            if (!firstPrinted)
                System.out.print("\n");
            
            //Increments day
            today.incDay(1);
            
        } 
    }
}