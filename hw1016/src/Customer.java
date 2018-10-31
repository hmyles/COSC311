public class Customer {

    private int id;
    private static int id_ptr = 0;
    private int wait_time;
    private Queue original_queue, current_queue;
    private CustomerStatus status;


    public Customer(){

        id = id_ptr;
        id_ptr++;
        wait_time = 0;
        original_queue = null;
        current_queue = null;
        status = CustomerStatus.waiting;

    }



    /* ************************************************* */
    // Getters and setters

    public Queue getOriginalQueue() {
        return original_queue;
    }

    public void setOriginalQueue(Queue original_queue) {
        this.original_queue = original_queue;
    }

    public Queue getCurrentQueue() {
        return current_queue;
    }

    public void setCurrentQueue(Queue current_queue) {
        this.current_queue = current_queue;
    }

    public int getId(){

        return id;

    }

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
