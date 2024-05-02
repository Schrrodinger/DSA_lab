package LinkedQueueApp;

public class Queue {
    LinkedQueue LQ = new LinkedQueue();
    private int count = 0;
    public void Enqueue(int x){
        LQ.InsertLast(x);
        count++;
    }
    public void Remove(int N){
        for (int i = 0; i <=N-1;i++){
            LQ.Delete();
            count--;
        }
        System.out.println("The queue after remove is: ");
        LQ.display();
        }
    public void Display(){
        LQ.display();
    }
    public int size(){
        return count;
    }
}
