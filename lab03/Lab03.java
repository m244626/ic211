import java.util.*;

/**
This is the Lab03 class. This utlizes Point and Box classes to create bounds and points

@author Nguyen, Kenneth
*/

public class Lab03{
    public static void main(String[] args){
        
        //Creates Scanner
        Scanner sc = new Scanner(System.in);
        
        //First point
        boolean defined = false;
        
        //Creates mainBox, command and initilize them in case of error
        Box mainBox = new Box( new Point(0,0) );
        String command = "";
        
        //While loop until done is inputted
        while ( !(command.equals("done")) ){
            //Get user input
            command = sc.next();
            
            //Commands
                //add
            if (command.equals("add") ){
                
                //Gets user input
                Point temp = Point.read(sc);
                
                //If mainBox hasn't been initalized, initalize it
                if  (defined == false){
                    mainBox = new Box(temp);
                    defined = true;
                }
                //If mainBox has been initalized, add to it
                else if (defined == true){
                    mainBox.growBy(temp);
                }
                
            }

                //box
            else if ( command.equals("box") ){
                
                //If mainBox has been initalized, print it
                if (defined == true ){
                    System.out.println(mainBox);
                }
                //Else, do not print
                else{
                    System.out.println("Error: box is not defined.");
                }
            }
            
                //map
            else if ( command.equals("map") ){
                //Gets user input
                Point temp = Point.read(sc);
                
                //See if user Point is valid
                temp = mainBox.mapIntoUnitSquare(temp);
                
                //If temp is null, error
                if (temp == null){
                    System.out.println("error");
                }
                //Else, print unit Point   
                else{
                    System.out.println(temp);
                }
            }
            
            //Command not listed above or "done" = Unregistered command, output Error
            else if ( !(command.equals("done")) ){
                System.out.println("Error! Unknown command \"" + command + "\"!");
            }
        }
            
        
    }
    
    
}