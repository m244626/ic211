import java.util.*;

public class HW3{
    public static void main(String args[]){
        
        //Creates scanner object
         Scanner sc = new Scanner(System.in);
        
        //Asks for number of mids
        System.out.print("How many mids? ");
        int n = sc.nextInt();
        
        //Creates an array to store mids
        Mid[] MidArray = new Mid[n];
        
        //Creates as many mids as need
        for (int i = 0; i < n; i++){
            MidArray[i] = createMid(sc);   
        }
        
        //Asks for company
        System.out.print("What company would you like to print out? ");
        int c = sc.nextInt();
        
        //For all mids, compare company to c
        for (int i = 0; i < n; i++ ){
            
            //If Mid's company matches
            if (MidArray[i].company == c){
                printMid(MidArray[i]);
            }
        }
        
    }
    
    public static Mid createMid(Scanner sc){
        Mid temp = new Mid();
        
        //Alpha
        System.out.print("Alpha? ");
        temp.alpha = sc.next();
        
        //First name
        System.out.print("First name? ");
        temp.firstName = sc.next();
        
        //Last name
        System.out.print("Last name? ");
        temp.lastName = sc.next();
        
        //Company
        System.out.print("Company? ");
        temp.company = sc.nextInt();
        
        return temp;
    }
    
    public static void printMid(Mid midshipman){
        
        System.out.println(midshipman.alpha + " " + midshipman.lastName + " " + midshipman.firstName + " " + midshipman.company);
        
    }
    
}