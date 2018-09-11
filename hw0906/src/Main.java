/*
Myles
COSC 311 Homework 9/6/2018
URL:             https://github.com/hmyles/COSC311
URL for project: https://github.com/hmyles/COSC311/tree/master/hw0906
URL for file:    https://github.com/hmyles/COSC311/tree/master/hw0906/src



 */


public class Main {

    public static int[] repeat(int[] a, int factor){

        if(factor <= 0)
            return new int[0];

        int[] retArr = new int[a.length * factor];

        for(int i = 0; i < retArr.length;i++)
            retArr[i] = a[i%a.length];

        return retArr;
    }

    public static void printArray(int[] array){

        for(int i = 0; i < array.length; i++)
            System.out.print(" " + array[i] + " ");
    }

    public static void report(int[] a, int[] b, int factor){

        System.out.print("a = {");
        printArray(a);
        System.out.println("}");

        System.out.println("factor = " + factor);
        System.out.println();

        System.out.print("repeat(a, factor) --> {");
        printArray(b);
        System.out.println("}");
        System.out.println();

    }

    public static void main(String[] args){


        int[] a = {1, 2, 3};
        int factor = 1;
        int[] b = repeat(a, factor);
        report(a, b, factor);


        factor = 2;
        b = repeat(a, factor);
        report(a, b, factor);



        factor = -2;
        b = repeat(a, factor);
        report(a, b, factor);




    }

}
