/*
Myles
hw1011





 */
import java.util.Random;

public class Main {

    CQueue queue;
    Random gen;

    public Main(){

        queue = new CQueue(10);
        gen = new Random(3);

    }

    public void doInsert(int x){

        for(int i = 0; i < x; i ++) {

            int a = gen.nextInt(99);
            queue.insert(a);

        }

    }

    public void doDelete(int x){

        for(int i = 0; i < x; i++)
            queue.delete();

    }

    public void printQueue(){

        if(queue.isEmpty())
            System.out.println("Empty queue");
        else
            System.out.println(queue);

    }

    public void doLogic(){

        int x = gen.nextInt(4) + 1;
        doInsert(x);

        int y = gen.nextInt(4) + 1;
        doDelete(y);

        printQueue();

    }


    public static void main(String args[]){

        Main main = new Main();
        main.doLogic();

    }
}
