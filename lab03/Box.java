import java.lang.Math;

/**
This class is centered around the Box object, which is the bounding area created by Points
@author Nguyen, Kenneth
*/

public class Box {
    
    double min_x, max_x, min_y, max_y;
    
    
    /**
    Constructor for Box that consists of a single point
    
    @param p Point P, which will be used for both min and max bounds
    */
    public Box(Point p) {
        //Defines x bounds as x-value of p
        this.min_x = p.getX();
        this.max_x = p.getX();
        
        //Defines y bounds as y-value of p
        this.min_y = p.getY();
        this.max_y = p.getY();
    }

    /**
    Constructor for the Box containing two initial points
    
    @param a Point a
    @param b point b
    */
    public Box(Point a, Point b) {
        //Defines x bounds
            //min
        this.min_x = Math.min( a.getX(), b.getX() );
            //max
        this.max_x = Math.max( a.getX(), b.getX() );
        
        //Defines y bounds
            //min
        this.min_y = Math.min( a.getY(), b.getY() );
            //max
        this.max_y = Math.max( a.getY(), b.getY() );
        
    }
    
    /**
    growBy(p) expands the bounding box (if needed) to include point p
    
    @param p Point p, used to expand the box
    */ 
    public void growBy(Point p) {
        //Compares current values to point p's values
        
        //x bounds
            //min
        this.min_x = Math.min( this.min_x, p.getX() );
            //max
        this.max_x = Math.max( this.max_x, p.getX() );
        
        //y bounds
            //min
        this.min_y = Math.min( this.min_y, p.getY() );
            //max
        this.max_y = Math.max( this.max_y, p.getY() );
        
    }
    
    /**
    Given point p in the bounding box, returns associated point in the
    Unit square (see notes); returns null if p is not inside the bounding box.
    
    @param p Point being checked
    */
    public Point mapIntoUnitSquare(Point p) {
        
        //Checks if point is in bounds
        if ( ( this.min_x < p.getX() && p.getX() < this.max_x ) && ( this.min_y < p.getX() && p.getY() < this.max_y )){
            
            //Calcuates unit vector
            double new_x = (p.getX()-this.min_x)/ (this.max_x-this.min_x);
            double new_y = (p.getY()-this.min_y)/ (this.max_y-this.min_y);
            
            return new Point(new_x, new_y);
            
        }

        //If no returns happened, Point is out of bounds
        return null;
    }
    
    /**
    Utilizes default Java toString() command to return Box as a String
    returns string representation like: 2.0 < x < 9.0, 3.0 < y < 7.0
    
    @return String returns the given point as a string
    */
    public String toString() {
        return this.min_x + " < x < " + this.max_x + ", " + this.min_y + " < y < " + this.max_y;
    }
    
    public static void main(String[] args){
        Point p = new Point(3,5);
        Box B = new Box(p);
        
        System.out.println("B: " + B);
        
    }
}