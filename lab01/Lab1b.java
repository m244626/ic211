import java.util.*;

public class Lab1b{
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        //Gets name
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        
        //Gets n
        System.out.print("Please input an integer: ");
        int n = in.nextInt();
        
        //Gets k
        System.out.print("Please input a second integer: ");
        int k = in.nextInt();
        
        System.out.println("The two ints were " + n + " and " + k);
        
        
        //Calculates numerator: n!/ (n-k)!
            //Note: Needs to be a double to prevent overflow error 
            
        //Factorial for n
        double nFact = 1;
        for (int temp = 1; temp <= n; temp++){
            nFact *= temp;
        }
        
        //Factorial for n-k
        int nkFact = 1;
        for (int temp = 1; temp <= n-k; temp++){
            nkFact *= temp;
        }
        
        double numerator = nFact / nkFact ;
        
        System.out.println("numerator = " + (int) numerator);
        
        //Calculates denominator: k!
        int denominator = 1;
        for (int temp = 1; temp <= k; temp++){
            denominator *= temp;
        }
        
        System.out.println("denominator = " + denominator);
        
        
        //Calculates odds
        double odds = numerator / denominator;
        
        System.out.println("odds = 1 in " + (int) odds + " = " + (1.0/odds) );
        
        //Prints goodbye name
        System.out.println("Goodbye " + name + ".");
    }
}