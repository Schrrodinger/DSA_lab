import org.w3c.dom.Node;

public class LinkedList {
    Node head = null;
    private  int count = 0;

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }

        public String toString(){
            return ("{  " + data + " }");
        }

    }

    public void Insertfirst(int data){
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
        count++;
    }


    public void display(){
        Node current = head;
        while (current != null){
            System.out.print(current.toString() + " \t");
            current = current.next;
        }
    }

    public int getFirst(){
        return head.data;
    }

    public int getLast(){
        Node last = head;
        while (last.next != null){
            last = last.next;
        }
        return last.data;
    }

    public static void main (String [] args){
        LinkedList LL = new LinkedList();
        LL.Insertfirst(1);
        LL.Insertfirst(13);
        LL.Insertfirst(15);
        LL.Insertfirst(10);
        LL.Insertfirst(17);
        LL.display();
        System.out.println("\nThe first Node is: ");
        System.out.println(LL.getFirst());
        System.out.println("\nThe last Node is: ");
        System.out.println(LL.getLast());
    }

}


