/**
BlackDot class is a MovingDot but is colored Black
Moves similarly to RedDot, but teleports every 10

@author Nguyen, Kenneth
*/
public class BlackDot extends MovingDot{
    
    private int stepCount;
    
    /**
    BlackDot constructor.
    
    @param r Int row value
    @param c Int col value
    */
    public BlackDot(int r, int c){
        super(r, c);
        
        this.stepCount = 0;
    }
    
    /**
    Method to allow Black to step in any direction
    
    Black dot random changes direction each step
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
        
        //Every 10 steps, teleport forward a random amount between 5-10
        this.stepCount++;
        if (this.stepCount == 10){
            
            temp = rnd.nextInt();
            temp = temp%5 + 5;
            
            for (int i = 0; i < temp; i++)
                super.step();
            
           this.stepCount = 0;
        }
        
    }

    /**
    toString() method to return Dot as String
    */
    public String toString(){
        return (super.toString() + " k");
    }
}