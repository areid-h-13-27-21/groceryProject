import java.io.FileNotFoundException;

public class GroceryTester {
    public static void main (String [] args ) throws FileNotFoundException {
        //testing both add methods
       GroceryList list = new GroceryList ();
       list.add("eggs");
       System.out.println(list);
       list.add(0, "milk");
       System.out.println(list);
       //testing size method
       System.out.println(list.size());
       //testing remove
       list.remove(1);
       System.out.println(list);
       //Add more items to list
       list.add("ketchup");
       list.add("cookies");
       list.add("steak");
       //testing getGroceryMap
       System.out.println(list.getGroceryMap());
       //testing getCost
       System.out.println(list.getCost());
       //test all test cases for budget
       System.out.println(list.budget(20.00));
       System.out.println(list.budget(19.96));
       System.out.println(list.budget(10.00));


    }
}
