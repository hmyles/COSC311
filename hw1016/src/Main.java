import controllers.Driver;
import simulation_display.SimulationDisplayManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

/*
 * Myles
 * HW 1016
 * URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
 */

public class Main {


    public static void main(String args[]){

        PrintStream verbose = null, terse = null;

        try {
            verbose = new PrintStream(new File("verboseOutput.txt"));
            terse = new PrintStream(new File("terseOutput.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SimulationDisplayManager dm = new SimulationDisplayManager(System.out, terse, verbose);
        Driver logicDriver = new Driver(dm);

        logicDriver.simulate(100);

        verbose.close();
        terse.close();

    }



}
