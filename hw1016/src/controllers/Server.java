package controllers;

import simulation_enums.CustomerStatus;
import simulation_enums.ServerStatus;
import customer_models.Customer;
import customer_models.QueueCustomer;

/*
 * Myles
 * HW 1016
 * URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
 */

public class Server {

    private static int server_ptr = 1;


    private ServerStatus status;
    private String name;

    private Customer customer;

    private int serviceTicks;

    private int tick;


    public Server(){

        name = "Server" + server_ptr;
        server_ptr++;


        serviceTicks = 1;
        status = ServerStatus.waiting;

    }

    public void simulationTick(){

        if(status == ServerStatus.waiting)
            return;

        if(serviceTicks <= 0)
            status = ServerStatus.idle;

        if(status == ServerStatus.busy)
            serviceTicks--;

    }

    public void startService(Customer c, int ticks){

        customer = c;
        status = ServerStatus.busy;
        serviceTicks = ticks;

    }

    public Customer endService(){

        customer.updateStatus(CustomerStatus.finished);

        Customer c = customer;

        customer = null;

        return c;


    }

    public String getName() { return name; }

    public ServerStatus getStatus() { return status; }

    public void setTick(int tick) { this.tick = tick; }

    public QueueCustomer getCustomer() { return customer; }

}
