package data_structures_customer;

import customer_models.QueueCustomer;
import data_structures.QueueNode;

/*
 * Myles
 * HW 1016
 * URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
 */

public class CustomerNode extends QueueNode<QueueCustomer> {

    public CustomerNode(QueueCustomer customer){

        super(customer);

    }

    /* ************************************************* */
    // Logic functions
    // End Logic functions
    /* ************************************************* */

    /* ************************************************* */
    // Getters and setters
    // End getters and setters
    /* ************************************************* */

    @Override
    public String toString(){

        return "NYI";

    }
}
