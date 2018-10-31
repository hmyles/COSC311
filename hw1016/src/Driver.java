/*
Myles
HW 1016
URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src


 */


import java.util.Random;

public class Driver {

    private Queue queue1, queue2;
    private int tick;
    private double poisson_mean;
    private int simulationNumber;


    public Driver(Queue q1, Queue q2){

        poisson_mean = 0.25;
        queue1 = q1;
        queue2 = q2;
        tick = 0;

    }


    /* ************************************************* */
    // Logic functions

    public void simulation(){

        if(queue1 == null || queue2 == null){
            System.out.println("Simulation stopped - Queue null");
            return;
        }

        while(tick < simulationNumber){

            removeFinishedCustomers();
            updateTimes();
            simulateArrivals();
            printSimulationInfo();

            tick++;
        }

    }

    public void removeFinishedCustomers(){


    }

    // Update the customers wait times
    public void updateTimes(){

        updateCustomerTimes(queue1);
        updateCustomerTimes(queue2);

    }

    // Helper for updateTimes()
    private void updateCustomerTimes(Queue q){

        int size = q.getSize();

        for(int i = 0; i < size; i++){
            q.getCustomerAt(i).getCustomer().incrementWaitTime();
        }

    }

    public void simulateArrivals(){

        int arrivals1 = getPoissonRandom(poisson_mean);
        int arrivals2 = getPoissonRandom(poisson_mean);


        System.out.println(" ******  ******  ******  ******  ****** ");
        System.out.println("Simulation - Arrivals: ");
        System.out.println("Simulation - Queue 1: " + arrivals1);
        System.out.println("Simulation - Queue 2: " + arrivals2);
        System.out.println(" ******  ******  ******  ******  ****** ");

        assignNewArrivals(arrivals1, queue1);
        assignNewArrivals(arrivals2, queue2);

    }

    public void assignNewArrivals(int n, Queue q){

        for(int i = 0; i < n; i++)
            q.insert(new Customer());

    }

    /*

    Following function (getPoissonRandom()) is from:

    https://stackoverflow.com/questions/9832919/generate-poisson-arrival-in-java
    http://en.wikipedia.org/wiki/Poisson_distribution#Generating_Poisson-distributed_random_variables

    which gives David Knuth's algorithm as:

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

    public int getSimulationNumber() { return simulationNumber; }

    public void setSimulationNumber(int simulationNumber) { this.simulationNumber = simulationNumber; }

    // End getters and setters
    /* ************************************************* */

    /* ************************************************* */
    // Print functions

    private void printSimulationInfo() {

        System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
        System.out.println("Printing simulation tick info\n\n");
        queue1.printQueue();
        queue2.printQueue();
        System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \n\n");

    }

    // End Print functions
    /* ************************************************* */
}
