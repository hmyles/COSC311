/*

Myles
hw0911
url: https://github.com/hmyles/COSC311/blob/master/hw0911/src/

 */


public class Main {

    double[] input1, input2, input3;
    LinkedList ll1, ll2, ll3;
    public void createLinkedLists(){

        input1 = new double[]{100.0};
        input2 = new double[]{10.0, 100.0, 10.0};
        input3 = new double[]{100.0, 10.0, 15.0, 20.0, 200.0, 30.0, 40.0, 300.0};

        ll1 = new LinkedList(input1);
        ll2 = new LinkedList(input2);
        ll3 = new LinkedList(input3);

    }

    public void reportLinkedLists(){

        System.out.println("List 1: " + ll1);
        System.out.println("List 2: " + ll2);
        System.out.println("List 3: " + ll3);


    }

    public void deleteAndAverage(){

        double average = 0.0;
        double count = 0;

        





    }

    public static void main(String[] args){

        Main test = new Main();

        test.createLinkedLists();
        test.reportLinkedLists();

        test.deleteAndAverage();
        test.reportLinkedLists();


    }

}
