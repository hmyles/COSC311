/*
 *  Myles
 *  COSC 341
 *  HW 1129
 *
 *  URL:
 */

public class Main {

    private static int[][] arrays;
    private static int[] num_elements;

    public static void main(String[] args){

        initializeTestCases();

        for(int i = 0; i < arrays.length; i++){

            int result = checkPriorityQueue(num_elements[i], arrays[i]);

            if(result >= 0)
                System.out.println("Test case #" + (i + 1) + " Invalid - fails at index " + result + ".");
            else
                System.out.println("Test case #" + (i + 1) + " Valid");

        }

    }

    public static int checkPriorityQueue(int size, int[] array){

        int i = (size - 1) / 2;

        if(i < 0)
            return i;

        int left = 2 * i + 1;
        int right = left + 1;

        if(left < array.length && (array[i] > array[left] || array[left] == 0))
            return left;

        if(right < array.length && (array[i] > array[right] || array[right] == 0))
            return right;

        return checkPriorityQueue(size - 1, array);

    }

    public static void initializeTestCases() {

        num_elements = new int[7];

        num_elements[0] = 5;
        num_elements[1] = 5;
        num_elements[2] = 6;
        num_elements[3] = 8;
        num_elements[4] = 7;
        num_elements[5] = (int)Math.pow(2, 10) - 1;
        num_elements[6] = num_elements[5];

        arrays = new int[7][];

        arrays[0] = new int[]{1, 2, 3, 4, 5};
        arrays[1] = new int[]{1, 1, 0, 1, 1};
        arrays[2] = new int[]{1, 5, 1, 2, 5, 6};
        arrays[3] = new int[]{1, 2, 2, 3, 2, 2, 17, 4};
        arrays[4] = new int[]{1, 2, 2, 0, 2, 2, 17, 4};
        arrays[5] = createLargeTests();
        arrays[6] = createLargeTests();
        arrays[6][500] = 1;

    }

    public static int[] createLargeTests(){

        int size = (int)Math.pow(2, 10) - 1;
        int[] array = new int[size];

        int k = 0;
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < (int)Math.pow(2, i); j++){

                array[k] = (int)Math.pow(2,i);
                k += 1;

            }

        return array;

    }

}
