public class Problem_4 {
    public int findmin(int a[], int n){
        if (n == 1){
            return a[n-1];
    }
    int min = findmin(a,n-1);
    if (min < a[n-1]){
        return min;
    } else {
        return a[n-1];
    }

}
    public int findsum (int a[], int n){
        if (n == 1){
            System.out.println(a[n-1]);
            return a[n-1];
        }
        System.out.println(a[n-1]);
        return a[n-1] + findsum(a, n-1);
    }

    public static void main (String [ ]args){
        int a[] = {1,8,7,0,5};
        int n = a.length;
        Problem_4 findmin = new Problem_4();
        Problem_4 findsum = new Problem_4();
        System.out.println("Min: " +findmin.findmin(a,n));
        System.out.println("Sum: "+ findsum.findsum(a,n));
    }
}
