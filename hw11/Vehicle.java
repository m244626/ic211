import java.util.Scanner;
import java.io.*;

public class Vehicle {
  protected String type;  // truck, car, motorcycle, plane
  protected String model;
  protected int mpg;
  protected int numWheels;
  protected boolean canfly;

  
  public Vehicle(String type, String model, int mpg) {
      
    this.type = type;
    this.model = model;
    this.mpg = mpg;
   
    }

  public boolean doesItFly() { return canfly; }

  /**
   * Open a file and read its vehicles. Assume 10 in the file.
   */
  public static Vehicle[] readFile(String path) {
    Scanner sc = null;
    try {
      sc = new Scanner(new BufferedReader(new FileReader(path)));
    }
    catch(FileNotFoundException fe) {
      System.out.println("File " + path + " not found!");
      return null;
    }

    Vehicle[] vehicles = new Vehicle[10];
    int i = 0;
    String tempType = "";
    while( sc.hasNext() ){
      
      //Reads in type
      tempType = sc.next();
      
      if (tempType.equals("truck"))
        vehicles[i++] = new Truck(tempType, sc.next(), sc.nextInt());
        
      else if (tempType.equals("car"))
        vehicles[i++] = new Car(tempType, sc.next(), sc.nextInt());
        
      else if (tempType.equals("plane"))
        vehicles[i++] = new Plane(tempType, sc.next(), sc.nextInt());
        
      else if (tempType.equals("motorcycle"))
        vehicles[i++] = new Motorcycle(tempType, sc.next(), sc.nextInt());
      else{
        vehicles[i++] = new Vehicle(tempType, sc.next(), sc.nextInt());
      }
          
    }
    
    return vehicles;
  }

  protected String noise() {
      return "hmmmm";
  }

  
  public String toString() {
    return model + " " + noise() + " does" + (doesItFly() ? "" : " not") + " fly with " + numWheels + " wheels.";
  }
  
}
