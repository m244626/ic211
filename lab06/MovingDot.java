import java.util.Random;


/**

MovingDot class extends Dot class. 
Gives Dot the ability to move via step()

@author Nguyen, Kenneth
*/
public class MovingDot extends Dot{
    
    protected int row, col, direction;
    protected Random rnd;
    
    
    
    /**
    Constructor for Moving Dot
    
    @param r Int row value
    @param c Int col value
    */
    
    public MovingDot(int r, int c){
        super(r, c);
        
        this.direction = 0;
        
        this.rnd = new Random();
        
    }

    /**
    Method to allow MovingDot to step in any direction
    */
    public void step(){
        
        //Movement in X-direction
            //Right
        if (0 < this.direction && this.direction < 4)
            this.incCol();
            //Left
        if (4 < this.direction && this.direction < 8)
            this.decCol();
           
        
        //Movement in y-direction
            //Down
        if (2 < this.direction && this.direction < 6)
            this.decRow();
            //Up
        if ( (0 <= this.direction && this.direction <= 1) || (6 < this.direction && this.direction < 8) )
            this.incRow();
    
    }
    
    
}