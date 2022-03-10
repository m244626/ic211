import java.util.*;

public class HW09 {
  public static void main(String[] args) {
    boolean verbose = args.length > 0 && args[0].equals("-v");
    Scanner sc      = new Scanner(System.in);

    if (verbose) {
      System.out.print("Enter x, k, m: ");
    }
    
    int x = 0, k = 0, m = 0;
    try{
        x = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
    }catch(Exception e){
        
        if (verbose){
            System.out.println("Error in HW09! invalid input.");
        }
        
        System.exit(1);

        
    }
    
    int r = MyMath.modexp(x, k, m);

    if (verbose) {
      System.out.print(x + "^" + k + " % " + m + " = ");
    }
    System.out.println(r);
  }
}