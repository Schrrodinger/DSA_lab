package LinkedQueueApp;

import org.w3c.dom.Node;

public class LinkedQueue {
    Node head = null;
    Node last = null;

    static class Node{
        int data;
        Node next;

        public Node (int data){
            this.data = data;
            next = null;
        }
    }

    public void InsertLast(int data){
        Node newNode = new Node(data);
        if (head == null){
            newNode.next = head;
            head = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
    }

    public int Delete(){
        if (head == null){
            throw new RuntimeException("The deleted number is larger than the size of list");
        }
        if (head == last){
            last = null;
        }
        Node current = head;
        head = current.next;
        return current.data;
    }
    public void display(){
        Node current = head;
        while (current != null){
            System.out.print(current.data);
            current = current.next;
        }
    }
    public void InsertFirst (int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
}
