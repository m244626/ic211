/**
This class creates a linked lists and uses functions to modify 
the linked list and convert thhe linked list to an array

@author Tabler, Nguyen
*/

public class ListStuff{
    
    /**
    addToFront creates a Node with the data s and adds the node to the front of a StringNode list Nold
    
    @param s the String value being added to front
    @param Nold linked list being modified
    @return StringNode with a new node with data String s at the front of Nold
    */
    public static StringNode addToFront(String s, StringNode Nold) {
     
        //Creates a StringNode 
        StringNode temp = new StringNode();
      
        //Gives temp the value s and next of Nold
        temp.data = s;
        temp.next = Nold;
        
        //Returns temp
        return temp;
      
    }
    
    /**
    listToArray(N) returns a reference to an array containing the same strings as in the list N (in order)
    
    @param N input StringNode wanted to be converted to a String[]
    @return a String[] filled with linked list data
    */
    
    public static String[] listToArray(StringNode N) {
    
        //Count number of Nodes
        int number = 0;
            //Loop through linked list
        for (StringNode temp = N; temp != null; temp = temp.next ){
            number++;
        }
           
        //Create String[]
        String[] outputArray = new String[number];
        
        
        
        //Loop through linked list
        int counter = 0;
            //Add each node to String[]
        for (StringNode temp = N; temp != null; temp = temp.next ){
            outputArray[counter] = temp.data;
            counter++;
        }    
             
        //Return String[]
        return outputArray;
    }
        
        
    public static void main(String[] args){
        StringNode N = null;      // at this point N *is* an empty list
        N = addToFront("rat",N);  // at this point N *is* the list ("rat")
        N = addToFront("dog",N);  // at this point N *is* the list ("dog","rat")
        N = addToFront("pig",N);  // at this point N *is* the list ("pig","dog","rat")
        
        String[] A = listToArray(N);
        
        for(int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}