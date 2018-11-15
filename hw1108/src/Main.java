/*
 * Myles
 * HW 1108
 * URL: https://github.com/hmyles/COSC311/tree/master/hw1108/src
 */

import java.util.Random;

public class Main {

    private static Random randomGen;
    private static int seed = 97;

    private static int inputPoolSize = 40;
    private static int inputSetSize = 20;


    public static int[] genInput(){

        int[] inputSet = new int[inputSetSize];
        int[] inputPool = new int[inputPoolSize];

        for(int i = 0; i < inputPoolSize; i++)
            inputPool[i] = i + 11;

        int i = 0;

        while(i < inputSetSize){

            int rand = randomGen.nextInt(inputPoolSize);

            if(inputPool[rand] == 0)
                continue;

            inputSet[i++] = inputPool[rand];

            inputPool[rand] = 0;

        }

        return inputSet;

    }

    public static void printArray(int[] arr){

        for(int i = 0; i < arr.length; i++)
            System.out.print(String.format("%-4d", arr[i]));

        System.out.println();

    }


    public static int hashItem(int data, int size){

        return data % size;

    }

    public static void insert(int x, int[] table){

        int index = hashItem(x, table.length);

        do{

            if(table[index] == 0){
                table[index] = x;
                return;
            }

            index++;

        }while(true);

    }


    public static void main(String[] args){

        randomGen = new Random(seed);

        int[] input = genInput();

        System.out.print("input data: ");
        printArray(input);

        int hashSize = 8;
        int[] hashTable = new int[hashSize];
        int count = 0;

        for(int i = 0; i < inputSetSize; i++){

            int key = input[i];

            if(count < hashTable.length - 1) {
                insert(key, hashTable);
                count++;
            }

            if( (double)count / (double)hashTable.length > 0.75) {
                hashSize *= 2;
                int[] newTable = new int[hashSize];

                for(int j = 0; j < hashTable.length; j++){

                    if(hashTable[j] != 0)
                        insert(hashTable[j], newTable);

                }

                hashTable = newTable;

            }

            printArray(hashTable);

        }


        System.out.println("Result of operations: ");
        printArray(hashTable);

    }

}
