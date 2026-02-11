public class Node {
    //protected variables
    protected String data;
    protected Node next;


    //three constructors
    public Node (String data) {
        this.data = data;
        this.next = null;
    }

    public Node () {
        this.data = null;
        this.next = null;
    }

    public Node (String data, Node previous) {
        this.data = data;
        previous.next = this.next;
    }

    //get next method
   public Node getNext() {
        return this.next;
    }

    //get data method
    public String getData() {
        return this.data;
    }


}
