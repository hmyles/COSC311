/*
Myles
HW 1016
URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src


 */


public class Queue {

    private QueueNode head, tail;
    private String name;
    private static int queue_ptr = 0;
    private int count;


    public Queue(){
        name = "queue" + queue_ptr;
        queue_ptr++;
        count = 0;
    }

    public void insert(Customer c){

        QueueNode temp = new QueueNode(null, c);
        count++;

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

        count--;

        QueueNode retVal = head;

        head = head.getNextNode();

        return retVal;


    }

    public QueueNode leaveQueue(Customer c){


        return null;

    }

    public void printQueue(){

        String retVal = "";

        retVal += "Queue name: " + name + "\n";
        retVal += "Number in queue: " + count + "\n";
        // Server status (idle/busy)
        retVal += "------------------------\n";

        QueueNode temp = head;

        while(temp != null) {
            retVal += temp.toString() + "\n";
            temp = temp.getNextNode();
        }


        System.out.println(retVal);

    }

    public String toString(){

        return name;

    }



}
