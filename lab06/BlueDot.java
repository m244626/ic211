/**
BlueDot class is a MovingDot but is colored Blue
It changed direction only at right angles

@author Nguyen, Kenneth
*/
public class BlueDot extends MovingDot{

    private int stepCount;

    /**
    BlueDot constructor.
    
    @param r Int row value
    @param c Int col value
    */
    public BlueDot(int r, int c){
        super(r, c);
        
        
        this.direction = 0;
        
        this.stepCount = 0;
    }
    
    /**
    Method to allow Blue to step in any direction
    
    Blue dot random changes direction every 10th step
    */
    public void step(){
        
        //Movement
        super.step();
             
        //Changes direction
        this.stepCount++;
        if (this.stepCount == 10){
            this.stepCount = 0;
            
            //Gets Random Number between 0-2
            int temp = rnd.nextInt();
            temp = temp%3;
            
            //Changes direction
            if (temp == 1)
                this.direction += 2;
            else if (temp == 2)
                this.direction -= 2;
            
            //Ensures direction is [0,6]
            if (this.direction <= -1)
                this.direction = 6;
            else if (this.direction >= 8)
                this.direction = 0;
        }
        
        
    }
    /**
    toString() method to return Dot as String
    */
    public String toString(){
        return (super.toString() + " b");
    }

}