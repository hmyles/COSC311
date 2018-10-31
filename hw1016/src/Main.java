/*
Myles
HW 1016
URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src


 */


public class Main {


    public static void testQueue(){

        Queue queue = new Queue();

        queue.insert(new Customer());
        queue.insert(new Customer());
        queue.insert(new Customer());
        queue.insert(new Customer());
        printQueue(queue);

        queue.delete();
        queue.delete();
        queue.insert(new Customer());
        queue.insert(new Customer());
        printQueue(queue);



    }


    public static void printQueue(Queue q){

        System.out.println("Printing Queue:");
        System.out.println("****************************");
        q.printQueue();
        System.out.println("****************************");


    }


    public static void main(String args[]){

        /* Testing */

        testQueue();



        /* End Testing */


        Driver logicDriver = new Driver();

        logicDriver.simulation();





    }
}
