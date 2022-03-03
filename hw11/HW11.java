import java.util.Scanner;
import java.io.*;

public class HW11 {

  /**
   * Main method, requires one arg (file path)
   */
  public static void main(String[] args) {
    if( args.length != 1 ) {
      System.out.println("HW11 <file>");
      System.exit(1);
    }

    Vehicle[] vs = Vehicle.readFile(args[0]);
    
    for( int i = 0; i < vs.length; i++ )
      System.out.println(vs[i]);
    }
    
}
