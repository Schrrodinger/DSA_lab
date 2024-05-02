import java.util.Scanner;
public class Josephus_problem { //Circular Linked List
    Node last = null;
    Node head = null;

    private int Peoplenumb, Countoff, Start;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Scanner sc = new Scanner(System.in);

    public void getInfor() {
        System.out.print("Enter the number of people in the circle: ");
        Peoplenumb = sc.nextInt();
        System.out.print("Enter the number used for counting off: ");
        Countoff = sc.nextInt();
        System.out.print("Enter the number used for : ");
        Start = sc.nextInt();

    }

    public void InsertLast() {
        for (int i = 1; i <= Peoplenumb; i++) {
            Node newnode = new Node(i);
            if (head == null) {
                last = newnode;
                head = newnode;
            } else {
                last.next = newnode;
                last = newnode;
            }
        }
        last.next = head;
    }


    public void display() {
        Node temp = head;
        if (head != null) {

            // Keep printing nodes till we reach the first node again
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
    }


    public void EliminationOrder() {
        int count = 0;
        Node current = head;
        System.out.println("Elimination order: ");
        while (count < Start - 1) {
            current = current.next;
            count++;
        }

        while (current != current.next) {

            for (int i = 0; i < Countoff - 1; i++) {
                current = current.next;
            }
            System.out.print(current.data + " ");

            head = current.next;
            Node temp = head;
            while (temp.next != current) {
                temp = temp.next;
            }

            temp.next = head;
            current = head;
        }
        Node temp = head;

        System.out.println("\nThe last person standing is: " + head.data);
    }

    public static void main(String[] args) {
        Josephus_problem circularLinklist = new Josephus_problem();
        circularLinklist.getInfor();
        circularLinklist.InsertLast();
        System.out.println("\n");
        circularLinklist.EliminationOrder();
    }
}
