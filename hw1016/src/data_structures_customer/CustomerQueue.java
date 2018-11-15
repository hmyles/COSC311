package data_structures_customer;

import data_structures.Queue;
import customer_models.QueueCustomer;
import data_structures.QueueNode;

/*
Myles
HW 1016
URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
*/

public class CustomerQueue extends Queue<QueueCustomer> {

    private static int queue_id_counter = 1;
    private String queue_name;

    public CustomerQueue(){

        super();
        queue_name = "Queue" + queue_id_counter;
        queue_id_counter++;

    }

    public void insert(QueueCustomer c){

        super.insert(c);
        c.setQueue(this);

    }

    public boolean hasCustomer(QueueCustomer c){

        for(int i = 0; i < size; i++){

            if(getCustomerAt(i).getId() == c.getId())
                return true;

        }

        return false;

    }

    public QueueCustomer getCustomerAt(int index){

        if(index >= size || head == null)
            return null;

        QueueNode temp = head;

        for(int i = 0; i < index; i++)
            temp = temp.getNextNode();

        return (QueueCustomer) temp.getData();

    }

    @Override
    public String toString(){

        return queue_name;

    }

}
