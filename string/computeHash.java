package Algorithm_lou.string;

import java.util.HashSet;
import java.util.Set;

public class computeHash {
    public int computHash(String string) {
        int p = 31;
        int m = (int)1e9 + 9;
        long hash_value = 0;
        int p_pow = 1;
        for (char c : string.toCharArray()) {
            hash_value = (hash_value + (c - 'a' + 1) * p_pow) % m;
            p_pow = (p_pow * p) % m;
        }
        return (int) hash_value;
    }

    public int count_unique_substrings(String str){
        int n=str.length();
        int p = 31;
        int m = (int) 1e9 + 9;
        int[] p_pow = new int[n];
        p_pow[0] = 1;
        for (int i = 1; i < n; i++) {
            p_pow[i] = (p_pow[i - 1]) * p % m;
        }
        int[] hash = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] + (str.charAt(i) - 'a' + 1) * p_pow[i]) % m;
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            Set<Integer> hs = new HashSet<>();
            for (int j = 0; j <= n - i; j++) {
                int cur_h = (hash[i + 1] + m - hash[i]) % m;
                cur_h = (cur_h * p_pow[n - i - 1]) % m;
                hs.add(cur_h);
            }
            cnt += hs.size();
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
