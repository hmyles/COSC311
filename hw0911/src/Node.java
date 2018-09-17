public class Node {

    private Node next;
    private double data;

    public Node(double num){
        data = num;
    }

    public Node next(){
        return next;
    }

    public double getData(){
        return data;
    }

    public void setNext(Node n){
        next = n;
    }

    public String toString(){
        return Double.toString(data);
    }

}
