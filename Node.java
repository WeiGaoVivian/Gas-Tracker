import java.util.ArrayList;
public class Node{
   private ArrayList<receipt> taxi;
   private Node next;
   //Inserting Strings and their nodes
   public Node(taxi t, Node n){ 
      taxi = t; 
      next = n; 
   } 
   //Getters
   public String getTaxiData(){ return info;} 
   public Node getNext(){ return next;}
   //Setters
   public void setTaxiData(String d){ info = d;}
   public void setNext(Node n){ next = n; } 
   //printing out data from Linked List
   public String toString() {
	   return info;
   }
} 
