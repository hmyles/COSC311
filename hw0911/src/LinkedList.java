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

    public void delete(double num){

        Node currNode = head;
        Node pNode = null;

        while(currNode != null) {

            if(currNode.getData() == num){

                if(pNode == null) {

                    head = head.next();
                    return;
                }

                pNode.setNext(currNode.next());
                return;
            }

            pNode = currNode;
            currNode = currNode.next();

        }

        return;
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
