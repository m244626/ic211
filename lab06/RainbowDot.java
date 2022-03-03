/**
RainbowDot class is a MovingDot but changes color
Moves similarly to red dot, changing directions only to the left, right, or straight

@author Nguyen, Kenneth
*/
public class RainbowDot extends MovingDot{

    private int stepCount;
    
    private int color;
    private static final String[] colors = {"r", "o", "y", "g", "b", "m"};
    

    /**
    RainbowDot constructor.
    
    @param r Int row value
    @param c Int col value
    */
    public RainbowDot(int r, int c){
        super(r, c);
        
        this.direction = 1;
        this.color = 0;
        this.stepCount = 0;
    }
    
    /**
    Method to allow Rainbow to step in any direction
    
    Rainbow dot random changes direction every 3th step
    Addtionally, every step, change color
    */
    public void step(){
        
        //Movement
        super.step();
             
        //Changes color
        this.color ++;
        if (color > 5)
            color = 0;
             
        //Changes direction
        this.stepCount++;
        if (this.stepCount == 3){
            this.stepCount = 0;
            
            
            int temp = rnd.nextInt();
            temp = temp%3;
            
            
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
        
        
    }
    /**
    toString() method to return Dot as String
    */
    public String toString(){
        return (super.toString() + " " + colors[color]);
    }

}