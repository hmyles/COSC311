/*
Myles
HW 0927
URL: https://github.com/hmyles/COSC311/tree/master/hw0927/src

 */

import java.util.Random;

public class Main {

    public static CQueue getQueue(int n){

        return new CQueue(n);
    }

    public static int[] getOperations(int k){
        Random r = new Random();
        int[] operations = new int[k];

        for(int i = 0; i < k; i++)
            operations[i] = r.nextInt(2);

        return operations;

    }
    public static long doOperations(int k, CQueue q){

        int[] operations = getOperations(k);
        long start_time = System.currentTimeMillis();

        for(int i = 0; i < k; i++)
            if(operations[i] == 0)
                q.push(5);
            else
                q.pop();

        long end_time = System.currentTimeMillis();

        return end_time - start_time;
    }

    public static void runTest(int n, int k, CQueue q){

        long time = doOperations(k, q);

        System.out.println("N = " + n);
        System.out.println("K = " + k);
        System.out.println("Took " + time/100.0 + " seconds.");
    }


    public static void main(String[] args){

        int times_to_test = 6;
        int n = 999999999;
        int k = 999999999;


        for(int i = 0; i < times_to_test; i++){

            System.out.println("Running test: " + (i + 1));

            CQueue q = getQueue(n);
            runTest(n, k, q);
            n /= 2;

            System.out.println("----------");
        }
    }
}
