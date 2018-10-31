/*
Myles
HW 1016
URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src


 */

public class Customer {

    private int id;
    private static int id_ptr = 0;
    private int wait_time;
    private int original_wait_time;
    private boolean switched;
    private Queue original_queue, current_queue;
    private CustomerStatus status;


    public Customer(){

        id = id_ptr;
        id_ptr++;
        wait_time = 0;
        original_wait_time = 0;
        switched = false;
        original_queue = null;
        current_queue = null;
        status = CustomerStatus.waiting;

    }


    /* ************************************************* */
    // Logic functions

    public void incrementWaitTime(){

        wait_time++;

    }

    // End Logic functions
    /* ************************************************* */

    /* ************************************************* */
    // Getters and setters

    public int getId(){ return id; }

    public int getWaitTime(){ return wait_time; }

    public Queue getOriginalQueue() { return original_queue; }

    public void setOriginalQueue(Queue original_queue) { this.original_queue = original_queue; }

    public Queue getCurrentQueue() {  return current_queue; }

    public void setCurrentQueue(Queue current_queue) { this.current_queue = current_queue; }

    // End getters and setters
    /* ************************************************* */



    @Override
    public String toString() {

        String retVal = "";

        retVal += "id: " + id + "\n";
        retVal += "wait time: " + wait_time + "\n";
        retVal += "original queue: " + original_queue + "\n";
        retVal += "current queue: " + current_queue + "\n";
        retVal += "Status: " + status + "\n";

        return retVal;

    }
}
