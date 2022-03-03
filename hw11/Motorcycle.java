public class Motorcycle extends Vehicle{

    public Motorcycle(String type, String model, int mpg) {
        
        super(type, model, mpg);
        
        this.canfly = false;
        this.numWheels = 2;
        
    }

    protected String noise(){
        return "errrrrrm";
    }
}