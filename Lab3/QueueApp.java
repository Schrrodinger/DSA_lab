public class QueueApp {
    private int[] arr;
    private int size;
    private int front, rear;
    int count=0;

    public QueueApp(int size){
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    private boolean isFull(){
        if(front == 0 && rear == size-1){
            return true;
        }
        return false;
    }

    private boolean isFullCircular(){
        if(count>0 && rear == front){
            return true;
        }
        return false;
    }

    private boolean isEmpty(){
        if (front == -1){
            return true;
        }
        return false;
    }

    private boolean isEmptyCircular(){
        if (front > rear){
            return true;
        }
        return false;
    }

    public void Enqueue(int value){
        if(front == -1){
            front = 0;
        }
        if (isFull()){
            throw new Error("The queue is full");
        }
        rear = (rear+1)%size;
        arr[rear]=value;

        if(front>rear){
            count++;
        }
    }
    public void Dequeue(){
        if (count ==0 && isEmpty()){
            throw new Error("The queue is empty");
        }
        int element = arr[front];
        if (front == rear && count == 0){
            front = -1 ;
            rear = -1;
        }
        else {
            front++;
        }
        if (count != 0 && isFullCircular() ){
            throw new Error("The circular queue is empty");
        }
    }


    public int DeQueue() {
        int element;
        if (isEmpty()) {
            throw new Error("The queue is empty");
        }

        element = arr[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        System.out.println("Deleted -> " + element);
        return (element);
    }

    public void display(){
        if (count == 0){
            System.out.println("The queue array is: ");
            for (int i = front ; i<= rear ; i++){
                System.out.println(arr[i]);
            }
            System.out.println("Front: " + front);
            System.out.println("Rear: " +  rear);
        }

        else {
            System.out.println("The wrapped around queue array is: ");
            for (int i = 0 ; i<= size -1 ; i++){
                System.out.println(arr[i]);
            }
            System.out.println("Front: " + front);
            System.out.println("Rear: " + rear);
        }

    }

    public void Remove(int value) {
        int Track=0;
        for (int i = 0; i <= size - 1; i++) {
            if (arr[i] == value) {
                Track = i;
            }
        }
        front = Track + 1;

    }

    public static void main(String[] args) {
        QueueApp q = new QueueApp(5);
        q.Enqueue(1);
        q.Enqueue(2);
        q.Enqueue(3);
        q.Enqueue(4);
        q.Enqueue(5);
        q.display();
        System.out.println("\n");
        q.Remove(1);
        q.display();
        System.out.println("\n");
        q.Enqueue(6);
        q.Enqueue(7);
        q.Enqueue(8);
        q.display();
        System.out.println("\n");
        q.DeQueue();
        q.display();




    }
}


