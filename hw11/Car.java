public class Car extends Vehicle{

    public Car(String type, String model, int mpg) {
        
        super(type, model, mpg);
        
        this.canfly = false;
        this.numWheels = 4;
        
    }

    protected String noise(){
        return "vroom";
    }
}