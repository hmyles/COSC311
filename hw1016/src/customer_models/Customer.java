package customer_models;

import data_structures_customer.CustomerQueue;

/*
 * Myles
 * HW 1016
 * URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
 */

public class Customer extends QueueCustomer {

    private GhostCustomer ghost;

    public Customer(){

        super();
        this.setId();

    }

    public Customer(CustomerQueue q){

        super(q);
        this.setId();
    }



    /* ************************************************* */
    // Logic functions
    // End Logic functions
    /* ************************************************* */

    @Override
    protected void setId() { this.id = id_counter++; }

    public GhostCustomer getGhost() {
        return ghost;
    }

    public void setGhost(GhostCustomer ghost) {
        this.ghost = ghost;
    }

    /* ************************************************* */
    // Getters and setters
    // End getters and setters
    /* ************************************************* */


    /* ************************************************* */
    // Print functions


    @Override
    public String toString() {

       return super.toString();

    }

    // End Print functions
    /* ************************************************* */

}
