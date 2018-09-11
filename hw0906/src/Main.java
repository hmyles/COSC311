/*
Myles
COSC 311 Homework 9/6/2018
URL:



 */


public class Main {

    public static int[] repeat(int[] a, int factor){

        if(factor <= 0)
            return new int[0];

        int[] retArr = new int[a.length * factor];
        int arrSize = a.length;

        for(int i = 0; i < retArr.length;i++)
            retArr[i] = a[i%a.length];

        return retArr;
    }

    public static void printArray(int[] array){

        for(int i = 0; i < array.length; i++)
            System.out.print(" " + array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args){

        int[] a = {1, 2, 3, 4};
        int[] b = repeat(a,2);

        printArray(b);

    }

}
