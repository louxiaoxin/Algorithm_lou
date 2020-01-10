package PrimeNumbers;

import java.util.ArrayList;
import java.util.List;

public class linearPrimeNumber {
    public static List<Integer> lpn(int n) {
        int[] lp = new int[n + 1];
        List<Integer> pr = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                pr.add(i);
            }
            for (int j = 0; j < pr.size() && pr.get(j) <= lp[i] && i * pr.get(j) <= n; j++) {
                lp[i * pr.get(j)] = pr.get(j);
            }
        }
        return pr;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
