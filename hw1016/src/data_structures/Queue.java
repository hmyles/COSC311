package data_structures;

/*
Myles
HW 1016
URL: https://github.com/hmyles/COSC311/tree/master/hw1016/src
*/

public class Queue<T> {

    protected QueueNode<T> head, tail;
    protected int size;

    public Queue(){

        head = null;
        tail = null;
        size = 0;

    }

    public boolean isEmpty(){ return size == 0; }

    public void insert(T data){

        QueueNode<T> node = new QueueNode<T>(data);
        size++;

        if(head == null){

            head = node;
            tail = node;
            return;

        }

        tail.setNextNode(node);
        tail = node;

    }

    public T delete(){

        if(head == null)
            return null;

        size--;

        QueueNode<T> retVal = head;

        head = head.getNextNode();

        return retVal.getData();

    }

    public int getSize(){ return size; }

}
