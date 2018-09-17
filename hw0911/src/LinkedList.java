public class LinkedList {

    private Node head;

    public LinkedList(double[] arr){

        for(int i = 0; i < arr.length; i++)
            insert(arr[i]);

    }

    private Node endOfList(){

        Node stepNode = head;
        Node pNode = head;

        while(stepNode != null) {
            pNode = stepNode;
            stepNode = stepNode.next();
        }

        return pNode;

    }

    public void insert(double num){

        if(head == null){
            head = new Node(num);
            return;
        }

        Node node = endOfList();

        node.setNext(new Node(num));

    }

    public boolean delete(double num){

        Node currNode = head;
        Node pNode = null;

        while(currNode != null) {

            if(currNode.getData() == num){

                if(currNode.next() == null){
                    head = null;
                    return true;
                }

                pNode.setNext(currNode.next());
                return true;
            }

            pNode = currNode;
            currNode = currNode.next();

        }

        return true;
    }

    public Node getNode(){
        return head;
    }

    public String toString(){

        String s = new String();
        s += "{";

        Node step = head;

        while(step != null) {

            s += step.toString();

            if(step.next() != null)
                s += ", ";

            step = step.next();
        }

        s += "}";
        return s;
    }
}
