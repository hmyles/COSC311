package data_structures;

/*
Myles
HW 1016
URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
*/

public class QueueNode<T> {

    private T data;
    private QueueNode<T> next_node;



    public QueueNode(T data){

        this.data = data;
        next_node = null;

    }

    /* ************************************************* */
    // Logic functions
    // End Logic functions
    /* ************************************************* */

    /* ************************************************* */
    // Getters and setters

    public void setData(T data){ this.data = data; }

    public T getData(){ return data; }

    public void setNextNode(QueueNode<T> next_node){ this.next_node = next_node; }

    public QueueNode<T> getNextNode(){ return next_node; }

    // End getters and setters
    /* ************************************************* */

    public String toString(){

        return "A node";

    }

}
