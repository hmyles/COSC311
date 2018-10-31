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

    /* ************************************************* */
    // Logic functions

    // End Logic functions
    /* ************************************************* */

    /* ************************************************* */
    // Getters and setters

    public void setNextNode(QueueNode node){  next_node = node; }

    public Customer getCustomer(){ return customer; }


    public void setCustomer(Customer customer){ this.customer = customer; }

    // End getters and setters
    /* ************************************************* */

    @Override
    public String toString(){

        return customer.toString();

    }
}
