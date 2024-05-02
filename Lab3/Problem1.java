public class Problem1 {
    private int arr[];
    private int size;
    private int count = 0;
    private int top;

    public Problem1(int size){
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public void push (int value){
        if (isFull()){
            grown();
        }
        arr[++top] = value;
    }

    public boolean isFull(){
        return top == size-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int Pop() {
        if (isEmpty()) {
            System.exit(1);
        }
        return arr[top--];
    }

    public void grown (){
        int temp [] = new int [size+size/2];
        for (int i = 0; i <= size-1;i++){
            temp[i] = arr[i];
        }
        arr=temp;
        size =size +size/2;
    }

    public void Convert(int number){
        int octal;
        while (number > 0){
            octal  = number % 8;
            push(octal );
            number = number / 8;
        }
        for (int i = top ; i >= 0  ; i--){
            System.out.print(arr[i]);
        }
    }

    public void print(){
        for (int i = 0 ; i<= size-1 ; i++){
            System.out.println(arr[i]);
        }}

    public int getSize(){
        return size;
    }

    public static Problem1 Concencate(Problem1 stack1, Problem1 stack2) {
        int size1 = stack1.top + 1;
        int size2 = stack2.top + 1;
        Problem1 mergedStack = new Problem1(size1 + size2);
        for (int i = 0; i < size1; i++) {
            mergedStack.push(stack1.Pop());
        }
        for (int i = 0; i < size2; i++) {
            mergedStack.push(stack2.Pop());
        }
        return mergedStack;
    }

    ;public boolean CheckIdentical( Problem1 stack1 , Problem1 stack2){
        boolean identical = false;
        if (stack1.top != stack2.top){
            System.out.println("Two stack are not identical");
            return identical;
        }
        else{
            while (!stack1.isEmpty()){
                int a = stack1.Pop();
                int b = stack2.Pop();
                if (a == b){
                    identical = true;
                }
                else{
                    identical = false;
                    break;
                }
            }
        }
        return identical;
    }


    public static void main (String[]args){
        Problem1 stack = new Problem1(100);
        Problem1 stack2 = new Problem1(100);
        Problem1 stack3 = new Problem1(100);
        System.out.println("The result of the convertion is: ");
        stack3.Convert(221);
        System.out.println("  ");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack2.push(1);
        stack2.push(2);
        stack2.push(5);

        Problem1 mergeStack = Problem1.Concencate(stack,stack2);
        System.out.println("Stack after concencate is: ");
        mergeStack.print();
        Problem1 Check = new Problem1(100);
        if (!Check.CheckIdentical(stack,stack2)){
            System.out.println("Two stack are not identical");
        }
        else {
            System.out.println("Two stack are  identical");
        }
        System.out.println("Print the convert ");
        stack.Convert(221);


    }
}
