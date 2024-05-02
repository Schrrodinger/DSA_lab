import java.util.*;
public class Problem_8 {
    public static void PrintSubset (int n){
        String nStr = String.valueOf(n); // convert int to String
        PrintSubset(nStr, "");
    }
    private static void PrintSubset (String nStr, String subset){
        if (nStr.isEmpty()){
            System.out.println(subset);
            return;
        }
        PrintSubset(nStr.substring(1),subset +nStr.charAt(0));
        PrintSubset(nStr.substring(1),subset);
    }

    public static void main (String [] args){
        PrintSubset(345);
    }
}
