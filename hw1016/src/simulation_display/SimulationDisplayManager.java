package simulation_display;

import controllers.Driver;
import controllers.Server;
import customer_models.Customer;
import customer_models.GhostCustomer;
import customer_models.QueueCustomer;
import data_structures_customer.CustomerQueue;
import simulation_enums.PrintType;
import simulation_enums.StreamType;

import java.io.PrintStream;

/*
 * Myles
 * HW 1016
 * URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
 */

public class SimulationDisplayManager {

    private PrintStream ps[];
    private final int consoleIndex = 0, terseIndex = 1, verboseIndex = 2;

    public SimulationDisplayManager(PrintStream console, PrintStream terse, PrintStream verbose, PrintStream ... ps){

        int defaultStreamsSize = 3;

        this.ps = new PrintStream[ps.length + defaultStreamsSize];

        this.ps[consoleIndex] = console;
        this.ps[terseIndex] = terse;
        this.ps[verboseIndex] = verbose;

        int i = defaultStreamsSize;

        for(PrintStream p : ps)
            this.ps[i++] = p;

    }

    private String getIndent(PrintType pt){

        String tabs = "";
        int indent = 0;

        switch (pt){

            case simulationTick: indent = 2; break;
            case simulation: indent = 4; break;
            case simulationStatus: indent = 6; break;

            case server: indent = 8; break;

            case customer: indent = 14; break;
            case customerExperience: indent = 16; break;

            case debug: indent = 20; break;

            default:
                break;

        }

        for(int i = 0; i < indent; i++)
            tabs += "\t";

        return tabs;

    }

    public void printToStreams(String msg){

        for(PrintStream p : ps)
            p.println(msg);

    }

    private void printToStreams(String msg, PrintType pt){

       printToStreams(getIndent(pt) + msg);

    }

    private void printToSpecificStream(String msg, PrintType pt, StreamType... st){

        for(StreamType type : st)

            switch(type){

                case all:
                    printToStreams(msg, pt);
                    break;

                case console:
                    ps[consoleIndex].println(getIndent(pt) + msg);
                    break;
                case terse:
                    ps[terseIndex].println(getIndent(pt) + msg);
                    break;
                case verbose:
                    ps[verboseIndex].println(getIndent(pt) + msg);
                    break;
            }



    }

    private void printHeader(String title, PrintType pt){

        String tabs = getIndent(pt);

        printToStreams(String.format("%s%25s%-40s", tabs, "" , title).replace(' ', '-'));

    }

    private void printHeader(String title, PrintType pt, StreamType st){

        printToSpecificStream(String.format("%25s%-40s", "" , title).replace(' ', '-'), pt, st);

    }

    private void printSimulationSpacer(){

        printToStreams(String.format("%80s", "").replace(' ', '='));

    }

    public void printSimulationStart(int ticks) {

        printToStreams("Simulation starting: doing " + ticks + " ticks.");
        printSimulationSpacer();

    }

    public void printSimulationTickStart(Driver d){

        printHeader("SimulationTick " + d.getTicks(), PrintType.simulationTick);
    }

    public void printServerEndService(Server s){

        printToStreams(s.getName() + " ending service: " + s.getCustomer().getId(), PrintType.simulation);

    }

    public void printCustomerArrivals(int arrivals1, int arrivals2) {

        printToStreams("arrivals(" + arrivals1 + ", " + arrivals2 + ")", PrintType.simulation);

    }

    public void printServerStartService(Server s){

        printToStreams(s.getName() + " starting service: " + s.getCustomer().getId(), PrintType.simulation);

    }

    public void printSimulationMessage(Driver d){

        printCommonSimulationMessages(d);
        printTerseSimulationMessage(d);
        printVerboseSimulationMessage(d);

    }

    public void printVerboseServerMessage(Server s){

        printToStreams("", PrintType.server);

        printToStreams(s.getName(), PrintType.server);
        printToStreams("status: " + s.getStatus(), PrintType.server);


    }

    private void printCommonSimulationMessages(Driver d){

        printToStreams("", PrintType.simulationStatus);
    }

    public void printTerseSimulationMessage(Driver d){

        CustomerQueue[] queues = d.getCustomerQueues();

        printToSpecificStream("Queue lengths: ", PrintType.simulationStatus, StreamType.terse);

        for(int i = 0; i < queues.length; i++)

            printToSpecificStream(queues[i] + ": " + queues[i].getSize(), PrintType.simulationStatus, StreamType.terse);

    }

    public void printVerboseSimulationMessage(Driver d){

        CustomerQueue[] queues = d.getCustomerQueues();
        int pos = 0;

        for(Server s: d.getServers()) {

            printVerboseServerMessage(s);

            for(int i = 0; i < queues[pos].getSize(); i++)
                printVerboseCustomerMessage(queues[pos].getCustomerAt(i));

            pos++;

        }

    }

    public void printSimulationTickEnd(Driver d){

        printHeader("EndSimulationTick " + d.getTicks(), PrintType.simulationTick);
    }

    public void printSimulationEnd(){

        printSimulationSpacer();
        printToStreams("Simulation ending");

    }

    public void printTerseCustomerMessage(QueueCustomer c){

        printCustomerMessage(c, PrintType.customer, StreamType.terse);

    }

    public void printVerboseCustomerMessage(QueueCustomer c){

        printCustomerMessage(c, PrintType.customer, StreamType.verbose);

    }

    public void printCustomerMessage(QueueCustomer c, PrintType pt, StreamType st){


        printHeader("Customer", pt, st);

        printToSpecificStream(String.format("%15s: %-15d", "id", c.getId()), pt, st);
        printToSpecificStream(String.format("%15s: %-15d", "wait_time", c.getWaitTime()), pt, st);

        if(c.getClass().equals(Customer.class)){

            String q = "";

            if(((Customer)c).getGhost() == null)
                q = c.getQueue().toString();
            else
                q = ((Customer)c).getGhost().getQueue().toString();

            printToSpecificStream(String.format("%15s: %-15s", "original_queue", q), pt, st);
            printToSpecificStream(String.format("%15s: %-15s", "current_queue", c.getQueue()), pt, st);

        } else {

            printToSpecificStream(String.format("%15s: %-15s", "original_queue", c.getQueue()), pt, st);
            printToSpecificStream(String.format("%15s: %-15s", "current_queue", ((GhostCustomer)c).getSelf().getQueue()), pt, st);

        }

        printHeader("EndCustomer", pt, st);

    }

    public void printCustomerSwitchingQueues(QueueCustomer c){

        printToStreams(c.getId() + " has switched", PrintType.simulation);

    }

    private void printCustomerExperience(QueueCustomer c){

        printHeader("CustomerExperience", PrintType.customerExperience);

        printVerboseCustomerMessage(c);
        printTerseCustomerMessage(c);

        if(c.getClass().equals(Customer.class)){

            if(((Customer)c).getGhost() != null) {

                int wait_time = ((Customer) c).getGhost().getWaitTime() - c.getWaitTime();
                printToStreams("Wait time if hadn't switched: " + wait_time, PrintType.customerExperience);

            }
        }

        printHeader("EndCustomerExperience", PrintType.customerExperience);

    }

    public void printCustomerWaitTime(QueueCustomer c) {

        printCustomerExperience(c);

    }

}
