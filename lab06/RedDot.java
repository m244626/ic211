/**
RedDot class is a MovingDot but is colored Red
Every step, it changes direction to the left, right, or straight

@author Nguyen, Kenneth
*/
public class RedDot extends MovingDot{
    
    /**
    RedDot constructor.
    
    @param r Int row value
    @param c Int col value
    */
    public RedDot(int r, int c){
        super(r, c);
        
    }
    
    /**
    Method to allow RedDot to step in any direction
    
    Red dot random changes direction each step
    */
    public void step(){
        
        //Movement
        super.step();
             
        //Changes direction
        int temp = rnd.nextInt();
        temp = temp%3;
        
        //Changes direction
        
            //Gets Random Number between 0-2
        if (temp == 1)
            this.direction++;
        else if (temp == 2)
            this.direction--;
        
            //Ensures direction is [0,7]
        if (this.direction == -1)
            this.direction = 7;
        else if (this.direction == 8)
            this.direction = 0;
        
        
    }

    /**
    toString() method to return Dot as String
    */
    public String toString(){
        return (super.toString() + " r");
    }
}