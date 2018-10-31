/*
Myles
HW 1016
URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src


 */


public class Queue {

    private QueueNode head, tail;
    private String name;
    private static int queue_ptr = 1;
    private int size;

    public Queue(){
        name = "queue" + queue_ptr;
        queue_ptr++;
        size = 0;
    }

    /* ************************************************* */
    // Logic functions

    public void insert(Customer c){

        QueueNode temp = new QueueNode(null, c);
        size++;

        if(c.getOriginalQueue() == null)
            c.setOriginalQueue(this);

        c.setCurrentQueue(this);

        if(head == null) {
            head = temp;
            tail = temp;
            return;
        }

        tail.setNextNode(temp);
        tail = temp;

    }

    public QueueNode delete(){

        if(head == null)
            return null;

        size--;

        QueueNode retVal = head;

        head = head.getNextNode();

        return retVal;

    }

    public QueueNode leaveQueue(Customer c){

        return null;

    }

    public QueueNode getCustomerAt(int index){

        QueueNode temp = head;

        if(head == null)
            return null;

        for(int i = 0; i < index; i++)
            temp = temp.getNextNode();

        return temp;

    }

    // End Logic functions
    /* ************************************************* */


    /* ************************************************* */
    // Getters and setters

    public int getSize(){ return size; }

    // End getters and setters
    /* ************************************************* */

    /* ************************************************* */
    // Print functions

    public void printQueue(){

        String retVal = "";

        retVal += "Queue name: " + name + "\n";
        retVal += "Number in queue: " + size + "\n";
        // Server status (idle/busy)
        retVal += "------------------------\n";

        QueueNode temp = head;

        while(temp != null) {
            retVal += temp.toString() + "\n";
            temp = temp.getNextNode();
        }


        System.out.println(retVal);

    }

    // End Print functions
    /* ************************************************* */

    @Override
    public String toString(){

        return name;

    }

}
