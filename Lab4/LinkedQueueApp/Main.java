package LinkedQueueApp;

    public class Main {
        public static void main(String[] args) {
            Queue queue = new Queue();
            queue.Enqueue(1);
            queue.Enqueue(2);
            queue.Enqueue(3);
            queue.Enqueue(4);
            queue.Enqueue(5);
            System.out.println("The initial queue is: ");
            queue.Display();
            System.out.println("\n");
            queue.Remove(3);
            queue.Enqueue(6);
            queue.Enqueue(7);
            queue.Enqueue(8);
            queue.Enqueue(9);
            queue.Enqueue(10);
            queue.Enqueue(11);
            System.out.println("\nThe queue after add element: ");
            queue.Display();
            System.out.println("\n");
            queue.Remove(2);





        }
    }

