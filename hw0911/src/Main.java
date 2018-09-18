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

    public double getAverage(LinkedList list){

        double average = 0.0;
        double count = 0.0;
        Node currentNode = list.getNode();

        while(currentNode != null){

            average += currentNode.getData();
            count += 1.0;

            currentNode = currentNode.next();
        }

        if(count != 0)
            average = average / count;

        return average;
    }

    public void removeNodesBelowAverage(LinkedList list, double average){

        Node currentNode = list.getNode();

        while(currentNode != null){

            if(currentNode.getData() > average)
                list.delete(currentNode.getData());

            currentNode = currentNode.next();
        }
    }

    public void deleteBelowAverage(){

        double average = 0.0;

        average = getAverage(ll1);
        removeNodesBelowAverage(ll1, average);

        average = getAverage(ll2);
        removeNodesBelowAverage(ll2, average);

        average = getAverage(ll3);
        removeNodesBelowAverage(ll3, average);
    }

    public void reportAverages(){

        double average = 0.0;

        average = getAverage(ll1);

        System.out.println("List 1 average: " + average);

        average = getAverage(ll2);

        System.out.println("List 2 average: " + average);

        average = getAverage(ll3);

        System.out.println("List 3 average: " + average);
    }

    public static void main(String[] args){

        Main test = new Main();

        System.out.println("Starting lists");
        test.createLinkedLists();
        test.reportLinkedLists();
        System.out.println();


        System.out.println("Averages");
        test.reportAverages();
        System.out.println();

        System.out.println("Ending Lists");
        test.deleteBelowAverage();
        test.reportLinkedLists();
    }

}
