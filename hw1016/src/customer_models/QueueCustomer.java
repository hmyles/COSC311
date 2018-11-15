package customer_models;

import simulation_enums.CustomerStatus;
import data_structures_customer.CustomerQueue;

/*
 * Myles
 * HW 1016
 * URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
 */

public abstract class QueueCustomer {

    protected int id;
    protected static int id_counter = 0;

    private int wait_time;
    private CustomerQueue queue;


    private CustomerStatus status;


    public QueueCustomer(){

        wait_time = 0;

        status = CustomerStatus.waiting;

    }

    public QueueCustomer(CustomerQueue q){

        this();
        queue = q;

    }

    public void updateStatus(CustomerStatus status){

        this.status = status;

    }

    public void incrementWaitTime(){

        wait_time++;

    }

    protected abstract void setId();

    public int getId(){ return id; }

    public int getWaitTime(){ return wait_time; }

    public CustomerStatus getStatus() { return status; }

    public CustomerQueue getQueue() { return queue; }

    public void setQueue(CustomerQueue queue) { this.queue = queue; }

    @Override
    public String toString() {

        return Integer.toString(id);

    }

}
