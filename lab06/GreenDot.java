/**
Green class is a MovingDot but is colored Green
Moves diagonally and changes direction in 90 degree angles

@author Nguyen, Kenneth
*/
public class GreenDot extends MovingDot{

    private int stepCount;

    /**
    GreenDot constructor.
    
    @param r Int row value
    @param c Int col value
    */
    public GreenDot(int r, int c){
        super(r, c);
        
        this.direction = 1;
        this.stepCount = 0;
    }
    
    /**
    Method to allow Greendot to step in any direction
    
    Red dot random changes direction every 5th step
    */
    public void step(){
        
        //Movement
        super.step();
             
        //Changes direction
        this.stepCount++;
        if (this.stepCount == 7){
            this.stepCount = 0;
            
            //Gets Random Number between 0-2
            int temp = rnd.nextInt();
            temp = temp%3;
            
            //Changes direction
            if (temp == 1)
                this.direction += 2;
            else if (temp == 2)
                this.direction -= 2;
            
            //Ensures direction is [0,7]
            if (this.direction <= 0)
                this.direction = 7;
            else if (this.direction >= 8)
                this.direction = 1;
        }
        
        
    }
    /**
    toString() method to return Dot as String
    */
    public String toString(){
        return (super.toString() + " g");
    }

}