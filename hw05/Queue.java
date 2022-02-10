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
        public String data;
        public Node next;
        
        /**
        Node Constructor
        
        @param String data value
        @param Node next node
        */
        public Node(String d, Node n) {
            data = d;
            next = n;
        }
    }
   
    /**
    * adds s to the back of the queue
    */
    public void enqueue(String s) {
        
        //If list is empty, set node to head and tail
        //                  set next value to null
        if ( this.head == null ){
          
            //Creates node and adds to back
            this.head = new Node( s, null);
            this.tail = head;            
        }

        //Else, list is not empty (at least 1)
        else{
            
            //Gets temp = end node by iterating through linked list 
                //  until node.next is null (end node has next value of null)
            Node temp;
            for ( temp = this.head; temp.next != null; temp = temp.next){
                //Pass
            }

            //Adds a new node to end Node temp
            temp.next = new Node( s, null );;

            //Sets tail to the node
            this.tail = temp.next;
        }
        
    }

    /**
    * removes and returns string from the front of the queue
    */
    public String dequeue() {
        //If head is not empty
        if (this.head != null){
            
            //Get data value from Node
            String output = this.head.data;
            
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
    * returns true if the queue is empty
    */
    public boolean empty() {
        
        //If head is null, linked list is empty (true)
        if (this.head == null){
            return true;
        }
        //Else, return false
        return false;
        
    }
}


