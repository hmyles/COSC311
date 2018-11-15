package data_structures_customer;


import customer_models.QueueCustomer;
import data_structures.QueueNode;

public class SwitchableCustomerQueue extends CustomerQueue{

    public SwitchableCustomerQueue(){

        super();

    }

    /* ************************************************* */
    // Logic functions

    public QueueCustomer leaveQueue(QueueCustomer c){

        int pos = findCustomer(c);

        if(pos == -1)
            return null;




        return null;
    }

    public int findCustomer(QueueCustomer c){

        for(int i = 0; i < size; i++)
            if(getCustomerAt(i).getId() == c.getId())
                return i;

        return -1;

    }

    /* Puts a customer at index */
    public void setCustomerAt(int index, QueueCustomer c){

        if(c == null)
            return;

        QueueNode temp = head;
        QueueNode prev = temp;

        if(index > size - 1)
            return;

        QueueNode n = new QueueNode<QueueCustomer>(c);

        if(index == 0){

            n.setNextNode(head.getNextNode());
            head = n;

        }


        for(int i = 0; i < index; i++) {
            prev = temp;
            temp = temp.getNextNode();
        }



        n.setNextNode(temp.getNextNode());

        prev.setNextNode(n);

    }

    // End Logic functions
    /* ************************************************* */

}
