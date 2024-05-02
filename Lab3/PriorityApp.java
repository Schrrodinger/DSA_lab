import java.util.EmptyStackException;
import java.util.Random;

public class PriorityApp {
    private int size;
    private long[] arr;
    private int nItems;


    public PriorityApp(int s)
    {
        size = s;
        arr = new long[size];
        nItems = 0;
    }


    public void insert(long item)
    {
        int j;

        if (nItems == 0)
        {
            arr[nItems++] = item;
        } else // if items,
        {
            for (j = nItems - 1; j >= 0; j--)
            {
                if (item > arr[j])
                {
                    arr[j + 1] = arr[j];
                } else // if smaller,
                {
                    break;
                }
            }  // end for
            arr[j + 1] = item;
            nItems++;
        }
    }

    public long remove() // remove minimum item
    {
        if(isEmpty()) throw new EmptyStackException();
        return arr[--nItems];
    }


    public long peekMin() // peek at minimum item
    {
        return arr[nItems - 1];
    }


    public boolean isEmpty() // true if queue is empty
    {
        return (nItems == 0);
    }


    public boolean isFull() // true if queue is full
    {
        return (nItems == size);
    }

    public void display() {
        for (int i = 0; i < nItems; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        PriorityApp priorityQ = new PriorityApp(20);
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            long n = rand.nextInt(50);

            priorityQ.insert(n);
        }
        priorityQ.display();
    }
}
