import java.util.*;

/**
This class is centered around Cartesians points, which have a x,y value.
@author Nguyen, Kenneth
*/

public class Point{
    private double x;
    private double y;
    
    /**
    Point constructor. It creates a point when given x,y double values.
    
    @param x x-value for Point
    @param y y-value for Point
    */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    /**
    Method that reads in an x, y value via scanner and returns a point
    
    @param sc Scanner used to read in keyboard input
    @return Point Point with an user-inputted x,y value
    */
    public static Point read(Scanner sc){
        double inputX = sc.nextDouble();
        double inputY = sc.nextDouble();
        
        return new Point(inputX, inputY);
    }
    
    /**
    Utilizes default Java toString() command to return Point as a String
    
    @return String returns the given point as a string
    */
    public String toString(){
        return this.x + " " + this.y;
    }
    
    /**
    Returns the x-value of Point
    
    @return Double returns x-value of Point
    */
    public double getX(){
        return this.x;
    }
    
    /**
    Returns the y-value of Point
    
    @return Double returns y-value of Point
    */
    public double getY(){
        return this.y;
    }
    
    public static void main(String[] args){
        
        //Makes a point
        Point A = new Point(1.0, 2.0);
        
        //Creates Scanner
        Scanner sc = new Scanner(System.in);
        
        //Uses Scanner to read in point
        System.out.print("Add ");
        Point B = read(sc);
        
        //Prints points
        System.out.println("A: " + A);
        System.out.println("B: " + B);
    }
}