import java.util.Scanner;
public class Problem_6 {
    public int FindLargestDivisor ( int p, int q){ //Uoc chung lon nhat
        if (q == 0){
            return p;
        }
        return FindLargestDivisor(q, p%q);
    }

    public static void main (String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st number: ");
        int p = sc.nextInt();
        System.out.println("Enter 2nd number: ");
        int q = sc.nextInt();

        Problem_6 divisor = new Problem_6();
        System.out.println("The largest divisor of 2 number is: "+divisor.FindLargestDivisor(p,q));
    }
}

