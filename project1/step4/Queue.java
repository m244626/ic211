import java.util.*;


/**
This is the Queue class

*/
public class Queue{    

    private Node head = null;
    private Node tail = null;
   
    /**
    This is a linked-list Node class
    */
    private class Node {
        public Tweet data;
        public Node next;
        
        /**
        Node Constructor
        
        @param String data value
        @param Node next node
        */
        public Node(Tweet t, Node n) {
            data = t;
            next = n;
        }
    }
   
    /**
    Adds Tweet T to the back of the Queue
    
    @param Tweet tweet to be added to back of Queue
    */
    public void enqueue(Tweet t) {
        
        //If list is empty, set node to head and tail
        //                  set next value to null
        if ( this.head == null ){
          
            //Creates node and adds to back
            this.head = new Node( t, null);
            this.tail = head;            
        }

        //Else, list is not empty (at least 1)
        else{
            
            //Makes the node
            Node temp = new Node( t, null);
            
            //Adds the Node to end
            this.tail.next = temp;
            
            //Sets Node to be the tail
            this.tail = temp;
        }
        
    }

    /**
    * removes and returns string from the front of the queue
    */
    public Tweet dequeue() {
        //If head is not empty
        if (this.head != null){
            
            //Get data value from Node
            Tweet output = this.head.data;
            
            //Checks if head is not the last node
            if (this.head != this.tail){
                //If they aren't the same... 
                    //Remove head Node by setting it to next node
                this.head = this.head.next;
                
                //Returns desired output
                return output;
            }
            
            //If head is the last node
            this.head = null;
            this.tail = null;
            
            //Returns desired output
            return output;
        }
        
        //If head is empty, return nothing
        return null;
        
        
    }

    /**
    Returns true if the Queue is empty
    
    @return boolean true is Queue is empty; else, false
    */
    public boolean empty() {
        
        //If head is null, linked list is empty (true)
        if (this.head == null){
            return true;
        }
        //Else, return false
        return false;
        
    }
    
    /**
    Iterates through the Queue and counts length
    
    @return int Length of Queue's linked list
    */
    public int length(){
        
        //Counter to store number of nodes
        int count = 1;
        
        //Iterates through every node
        for (Node temp = this.head; temp.next != null; temp = temp.next){
            count ++;
        }
        
        //Return number of nodes
        return count;
    }
    
    /**
    Iterates through the queue and prints all tweets
    */
    public void printAll(){
        
        //Iterates through every node and prints each Tweet
        for (Node temp = this.head; temp != null; temp = temp.next){
            System.out.println(temp.data);
        }
        
        
    }
    
    /**
    Traverses a Queue (via instanc) and 
    makes a new Queue that contains tweets with String keyword
    
    @param keyword String that new Queue's tweets must contain
    @return Queue New Queue with tweets that contain keyword
    */
    Queue filterForKeyword(String keyword){
        
        //Makes a new Queue
        Queue outputQueue = new Queue();
        
        //Iterates through the instance queue
        for (Node temp = this.head; temp != null; temp = temp.next){
            
            //If tweet contains keyword
            if (temp.data.containsKeyword(keyword) ){
                
                //Add the tweet to the outputQueue
                outputQueue.enqueue(temp.data);
            }
        }
        
        //Returns Queue
        return outputQueue;
        
    }
    
    /**
    Traverses a Queue (via instanc) and 
    makes a new Queue that does not contain tweets with String keyword
    
    @param keyword String that new Queue's tweets must not contain
    @return Queue New Queue with tweets that contain keyword
    */
    Queue filterForNotKeyword(String keyword){
        
        //Makes a new Queue
        Queue outputQueue = new Queue();
        
        //Iterates through the instance queue
        for (Node temp = this.head; temp != null; temp = temp.next){
            
            //If tweet does not contains keyword
            if (! (temp.data.containsKeyword(keyword)) ){
                
                //Add the tweet to the outputQueue
                outputQueue.enqueue(temp.data);
            }
        }
        
        //Returns Queue
        return outputQueue;
    
    }
    
    
}


