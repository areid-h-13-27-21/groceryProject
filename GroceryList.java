import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroceryList extends Node {
    private Node head;


    //make two constructors
    //constructor with no parameter
    public GroceryList () {
        this.head = null;
    }

    //one parameter construtor
    public GroceryList (Node head) {
        this.head = head;
    }
    
    //add method with only String
    //adds to the end of the list
    public void add(String data) {
        
        Node incoming = new Node(data);
        //if first item in the list, add to the front
        if (this.head == null) {
            this.head = incoming;
        } 
        else {
            //find the end of the list, and add the item there
            Node current = this.head;
            while (current.next != null) {
            current = current.next;
            }
            current.next = incoming;

        }
        
    }

    //add method with index
    public void add(int index, String data) {
        Node incoming = new Node(data);

        if (this.head == null) {
            this.head = incoming;
        }
        //find if valid
        else if (index >= 0 && index <= size()) {
            //index is 0,add at the beginning
            if (index == 0) {
                incoming.next = this.head;
                this.head = incoming;
            }
            //find index, and add there
            else {
                Node curr = head;
                for (int i = 0; i < index-1; i ++) {
                    curr = curr.next;
                }
                    incoming.next = curr.next;
                    curr.next = incoming;
                    
            }
        }

    }

    //remove method using index
    public void remove(int index) {
         if (head != null && index>=0 && index<size()) {
            if (index == 0) {
                head = head.next;
            }
            else {
                Node curr = head;
                for (int i = 0; i <index -1; i ++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
            }
        }

        
    }
    //size of list method
    public int size() {
        int count = 0;
        Node curr = head;
        //while the next node is still there, add one to the list
        while (curr != null) {
            count ++;
            curr = curr.next;
        }
        return count;
    }

    //grocery map. ,athod to get list
    public Map<String,Double> getGroceryMap () throws FileNotFoundException  {
        Map<String,Double> toRet = new HashMap<>();
        //import file
        File f = new File("/Users/areid/Desktop/CS_SEMINAR/groceryProject/groceryItems.txt");
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int spaceIndex = 0;
            for (int i = 0; i <line.length(); i ++) {
                if (line.charAt(i) == ' ') {
                    spaceIndex = i;
                }
            }
            String item = line.substring(0, spaceIndex);
            item = item.replace("\"", "");
            String priceStr = line.substring(spaceIndex + 1);
            Double cost = Double.parseDouble(priceStr);
            if (IndexOf(item) !=  -1) {
                toRet.put(item,cost);
            }
        }
        sc.close();
        return toRet;
    }


    //IndexOf method for a helper method
    public int IndexOf(String item) {
        Node head1 = head;
        for (int i = 0; i < size(); i ++) {
            if (item.equals(head1.getData())) {
                return i;
            
            }
            head1 = head1.getNext();
        }
        return -1;
    }



    //cost method using grocery map
    public Double getCost() throws FileNotFoundException {
        Double toRet = 0.0;
        Map<String,Double> groceries = getGroceryMap();
        for (Double val : groceries.values()) {
            toRet += val;
        }
        return toRet;
    }

    //toString method
    @Override
    public String toString()  {
        String toRet = "";
        Double cost;
        try {
            cost = getCost();
            
        } catch (Exception e) {
            cost=0.0;
            e.printStackTrace();
        }
       
        Node current = head;
            while (current != null) {
                toRet+= (current.getData() + " ");
                current = current.getNext();
            }
        return "You have bought " + toRet + "and it costs " + cost;
    }

    //finding out if they spent above, below, or their exact budget
    public String budget(Double budget) {
        Double cost;
        try {
            cost = getCost();
            
        } catch (Exception e) {
            cost=0.0;
            e.printStackTrace();
        }
        if (cost > budget) {
            Double over = cost - budget;
            return String.format("You are $%.2f over your budget!", over);
        }
        else if (cost < budget) {
            Double under = budget - cost;
            return String.format("You are $%.2f under your budget!", under);
        }
        else {
            return "You have spent your exact budget!";
        }


    }



    
}
