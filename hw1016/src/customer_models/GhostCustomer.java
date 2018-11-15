package customer_models;

/*
Myles
HW 1016
URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
*/

public class GhostCustomer extends QueueCustomer {

    private Customer self;

    public GhostCustomer(){

        super();

    }

    public GhostCustomer(Customer c){

        super();
        self = c;
        c.setGhost(this);
        this.setId();


    }

    @Override
    protected void setId() { this.id = self.id; }

    public Customer getSelf() {
        return self;
    }

    @Override
    public String toString() {

        return super.toString();

    }

}
