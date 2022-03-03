public class Plane extends Vehicle{

    public Plane(String type, String model, int mpg) {
        
        super(type, model, mpg);
        
        this.canfly = true;
        this.numWheels = 3;
        
    }

    protected String noise(){
        return "woooosh";
    }
}