package controllers;

import customer_models.GhostCustomer;
import customer_models.QueueCustomer;
import simulation_display.SimulationDisplayManager;
import simulation_enums.ServerStatus;
import data_structures_customer.CustomerQueue;
import data_structures_customer.SwitchableCustomerQueue;
import customer_models.Customer;
import data_structures.Queue;

import java.util.Random;

/*
* Myles
* HW 1016
* URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
*/

public class Driver {

    private SwitchableCustomerQueue queue1;
    private CustomerQueue queue2;
    private Server server1, server2;

    private int tick;
    private double poisson_mean;

    private SimulationDisplayManager out;

    private Random random;

    public Driver(SimulationDisplayManager dm){

        poisson_mean = 0.25;

        queue1 = new SwitchableCustomerQueue();
        queue2 = new CustomerQueue();
        server1 = new Server();
        server2 = new Server();

        tick = 1;

        this.out = dm;

        random = new Random(3);

    }


    /* ************************************************* */
    // Logic functions
    
    public void simulate(int ticks){

        out.printSimulationStart(ticks);

        while(tick <= ticks){

            out.printSimulationTickStart(this);
            simulationTick();
            out.printSimulationTickEnd(this);

            tick++;

        }

        out.printSimulationEnd();

    }

    private void simulationTick(){

        serverTick();

        removeFinishedCustomers(server1);
        removeFinishedCustomers(server2);

        updateTimes();

        simulateArrivals();
        simulateServer();

        out.printSimulationMessage(this);

    }

    /********************************************************************************************************/

    private void serverTick(){

        server1.setTick(tick);
        server2.setTick(tick);

        server1.simulationTick();
        server2.simulationTick();

    }

    private void removeFinishedCustomers(Server s){

        if(s.getStatus() == ServerStatus.idle && s.getCustomer() != null) {

            out.printServerEndService(s);
            Customer c = s.endService();

            reportCustomerExperience(c);

        }

    }

    private void updateTimes(){

        updateCustomerTimes(queue1);
        updateCustomerTimes(queue2);

    }

    private void simulateArrivals(){

        int arrivals1 = getPoissonRandom(poisson_mean);
        int arrivals2 = getPoissonRandom(poisson_mean);

        out.printCustomerArrivals(arrivals1, arrivals2);

        assignArrivalsToSwitchableQueue(arrivals1);
        assignArrivalsToQueue(arrivals2, queue2);

    }

    public void simulateServer(){

        assignCustomersToServer(server1, queue1);
        assignCustomersToServer(server2, queue2);

    }

    public void assignCustomersToServer(Server s, CustomerQueue q){

        clearGhostCustomers();

        if((s.getStatus() == ServerStatus.idle || s.getStatus() == ServerStatus.waiting) && !q.isEmpty()){

            s.startService((Customer)q.delete(), random.nextInt(5) + 1);

            out.printServerStartService(s);

        }

    }

    private void clearGhostCustomers(){

        do{

            QueueCustomer c = queue1.getCustomerAt(0);

            if(c == null)
                break;

            if(c.getClass().equals(GhostCustomer.class)){

                reportCustomerExperience(queue1.delete());

            }
            else
                break;

        } while (true);


    }

    private void reportCustomerExperience(QueueCustomer c){

        if(queue1.hasCustomer(c) || queue2.hasCustomer(c))
            return;

        out.printCustomerWaitTime(c);

    }

    /********************************************************************************************************/

    private void updateCustomerTimes(CustomerQueue q){

        int size = q.getSize();

        for(int i = 0; i < size; i++)
            q.getCustomerAt(i).incrementWaitTime();

    }

    private void assignArrivalsToSwitchableQueue(int n){


        for(int i = 0; i < n; i++){

            //50 50 for switching
            if((random.nextInt(100) + 1) <= 50){

                Customer c = new Customer(queue1);

                out.printCustomerSwitchingQueues(c);

                GhostCustomer gc = new GhostCustomer(c);

                c.setQueue(queue2);

                queue1.insert(gc);
                queue2.insert(c);

            }
            else
                assignArrivalsToQueue(1, queue1);


        }

    }

    public void assignArrivalsToQueue(int n, CustomerQueue q){

        for(int i = 0; i < n; i++)

            q.insert(new Customer(q));

    }




    /*
    * Following function (getPoissonRandom()) is from:
    *
    * https://stackoverflow.com/questions/9832919/generate-poisson-arrival-in-java
    * http://en.wikipedia.org/wiki/Poisson_distribution#Generating_Poisson-distributed_random_variables
    *
    *  which gives David Knuth's algorithm as:
    */
    public int getPoissonRandom(double mean){

        Random r = new Random();
        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;
        do {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }

    // End Logic functions
    /* ************************************************* */

    /* ************************************************* */
    // Getters and setters

    public int getTicks() { return tick; }

    public Server[] getServers() { return new Server[]{server1, server2}; }

    public CustomerQueue[] getCustomerQueues(){ return new CustomerQueue[]{queue1, queue2}; }

    // End getters and setters
    /* ************************************************* */

    /* ************************************************* */
    // Print functions
    // End Print functions
    /* ************************************************* */
}
