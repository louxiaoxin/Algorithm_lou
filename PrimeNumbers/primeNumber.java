package PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class primeNumber {
    public static List<Integer> primeNumber(int n) {
        boolean[] is_prime = new boolean[n + 1];
        Arrays.fill(is_prime, true);
        is_prime[0] = is_prime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (is_prime[i] && i * i < n) {
                for (int j = i * i; j <= n; j += i) {
                    is_prime[j] = false;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (is_prime[i]) {
                res.add(i);
            }
        }
        return res;
    }

    public static List<Integer> primeNumberImprove(int n) {
        List<Integer> res = new ArrayList<>();
        boolean[] is_prime = new boolean[n + 1];
        Arrays.fill(is_prime, true);
        is_prime[0] = is_prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (is_prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    is_prime[i] = false;
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (is_prime[i]) {
                res.add(i);
            }
        }
        return res;
    }

//    public static List<Integer> blockPrimeNumber(int n) {
//        List<Integer> res = new ArrayList<>();
//        boolean[] is_prime = new boolean[]
//    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            List<Integer> res1 = primeNumber(10000);
        }
        long mid = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            List<Integer> res2 = primeNumberImprove(10000);
        }
        long end = System.currentTimeMillis();
        System.out.println(mid - start);
        System.out.println(end - mid);
    }
}
