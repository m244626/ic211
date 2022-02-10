import java.util.*;

public class Lab1c{
    public static void main(String[] args){
        
        //Creates utilities
        Scanner in = new Scanner(System.in);
        Random rand = new Random(42);
        
        //Random rand = new Random(System.currentTimeMillis());
        
        //Generates int between 0 and 11 (inclusive, exclusive)
        int number = rand.nextInt(11);
        
        //Declares guess, count
        int guess = -1;
        int counter = 1;
        
        System.out.println("Guess a number between 0 and 10: ");
        guess = in.nextInt();
        
        //While guess is wrong, keep playing
        while (guess != number){
            
            System.out.println("<Insert Snarky Message> Guess again: ");
            guess = in.nextInt();
            
            counter += 1;
        }
        
        //If guess == number
        System.out.println("Right after " + counter + " guesses!");
        
    }
}