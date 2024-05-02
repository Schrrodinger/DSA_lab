public class Problem_1 {
    int puzzle(int base, int limit) {
        if (base > limit)
            return -1;
        else if (base == limit)
            return 1;
        else return base * puzzle(base + 1, limit);
    }


    public static void main(String[] args) {
        Problem_1 puzzle = new Problem_1();
        System.out.println("Question 1: " );
        System.out.println("In the function puzzle(), there are 2 base cases: base> limit and base = limit");
        System.out.println("Question 2: " );
        System.out.println("In the function puzzle(), the recursive case is: base * puzzle (base+1, limit");
        System.out.println("Question 3: ");
        System.out.println("puzzle(14,10): "+puzzle.puzzle(14,10));
        System.out.println("puzzle(4,7): "+puzzle.puzzle(4,7));
        System.out.println("puzzle(0,0): "+puzzle.puzzle(0,0));
    }
}