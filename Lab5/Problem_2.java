public class Problem_2 {
    double sum (int n){
        if (n < 1)
            return 0;
        return (((double)1/n)+sum(n-1));
    }
    public static void main(String[] args){
        Problem_2 sum = new Problem_2();
        System.out.println(sum.sum(6));
    }
}
