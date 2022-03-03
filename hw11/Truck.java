public class Truck extends Vehicle{

    public Truck(String type, String model, int mpg) {
        
        super(type, model, mpg);
        
        this.canfly = false;
        this.numWheels = 4;
        
    }

    protected String noise(){
        return "bumbumbum";
    }
    
}