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
