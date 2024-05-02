import java.util.EmptyStackException;
public class StackApp {
    private int size;
    private long[] arr;
    private int Top;

    public StackApp(int size){
        this.size = size;
        arr = new long [size];
        Top = -1;
    }

    public void push(long j)
    {
        if (isFull() && !grow()) {
            return;
        }

        arr[++Top] = j;

    }
//--------------------------------------------------------------

    public long pop() // take item from top of stack
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[Top--];
    }


    public long peek()
    {
        return arr[Top];
    }


    public boolean isEmpty()
    {
        return (Top == -1);
    }


    public boolean isFull() // true if stack is full
    {
        return (Top == size - 1);
    }

    protected boolean grow() {
        int max1 = size + size / 2;
        long[] a1 = new long[max1];
        if (a1 == null) {
            return (false);
        }
        for (int i = 0; i <= Top; i++) {
            a1[i] = arr[i];
        }
        arr = a1;
        return (true);
    }

    public static void main(String[] args) {
        StackApp theStack = new StackApp(10);  // make new stack
        theStack.push(13);               // push items onto stack
        theStack.push(34);
        theStack.push(98);
        theStack.push(89);
        int i = 1;
        while (!theStack.isEmpty())
        {
            long value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println(" ");
    }
}
