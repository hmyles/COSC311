/*
Myles
HW 1016
URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src


 */


public class QueueNode {

    private QueueNode next_node;
    private Customer customer;



    public QueueNode(QueueNode node, Customer customer){

        setNextNode(node);
        setCustomer(customer);

    }

    public QueueNode getNextNode() {

        return next_node;

    }

    public void setNextNode(QueueNode node){

        next_node = node;

    }

    public void setCustomer(Customer customer){

        this.customer = customer;

    }

    public String toString(){

        return customer.toString();

    }
}
