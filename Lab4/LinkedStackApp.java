public class LinkedStackApp {
    Node head = null;
    int Top = 0;

    static class Node {
        int idata;
        double ddata;
        Node next = null;

        public Node(int id) {
            this.idata = id;
            next = null;
        }

        public void displaylist() {
            System.out.print("{ " + idata + " }" + "\t");
        }
    }

    public void InsertFirst(int idata) {
        Node newnode = new Node(idata);
        newnode.next = head;
        head = newnode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int DeleteFirst() {
        if (isEmpty()) {
            System.exit(1);
        }
        Node current = head;
        head = head.next;
        return head.idata;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            current.displaylist();
            current = current.next;
        }
    }

    public Node getFirst(){
        return head;
    }



    public static class Stack{
        LinkedStackApp linkStack = new LinkedStackApp();
        public void Push(int data) {
            linkStack.InsertFirst(data);
        }

        public void Pop(){
            linkStack.DeleteFirst();
        }

        public boolean isEmpty()       // true if stack is empty
        {
            return ( linkStack.isEmpty() );
        }

        public void Display(){
            linkStack.display();
        }

        public void Reverse(){
            Node current = linkStack.head;
            LinkedStackApp newStack = new LinkedStackApp();
            while (current != null){
                newStack.InsertFirst(current.idata);
                current = current.next;
            }
            newStack.display();

        }

    }

    public static void main (String []args){
        LinkedStackApp LS = new LinkedStackApp();
        LinkedStackApp.Stack stack = new LinkedStackApp.Stack();
        stack.Push(1);
        stack.Push(22);
        stack.Push(31);
        stack.Push(47);
        stack.Push(5);
        stack.Display();

        stack.Pop();
        stack.Pop();
        stack.Push(6);
        stack.Push(17);
        System.out.println("\nStack: ");
        stack.Display();
        System.out.println("\nStack after reverse: ");
        stack.Reverse();

    }


}
