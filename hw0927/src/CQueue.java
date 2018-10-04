public class CQueue {

    private int[] data;
    private int current_size, max_size, head, tail;


    public CQueue(int size){

        emptyQueue();
        max_size = size;
    }

    public void emptyQueue(){

        data = new int[999999999];
        head = 0;
        tail = 0;
        current_size = 0;
    }

    public boolean isFull(){
        return (current_size + 1) == max_size;
    }

    public boolean isEmpty(){
        return current_size == 0;
    }

    public boolean push(int x){

        if(isFull())
            return false;

        data[tail] = x;
        tail++;
        current_size++;

        tail = tail % max_size;

        return true;
    }

    public boolean pop(){

        if(isEmpty())
            return false;

        head++;
        head = head % max_size;
        current_size--;

        return true;
    }

    @Override
    public String toString() {
        String display = "";
        int  h_temp = head;

        for(int i = 0; i < current_size; i++)
            display += data[h_temp++%max_size] + ", ";

        return display;
    }
}
