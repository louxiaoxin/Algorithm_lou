package string;

import java.util.Arrays;

public class Manacher {
    int j = 2;
    char[] s_new;
    char[] s;
    int[] p;

    public void init(String str){
        int n = str.length();
        s_new = new char[2 * n + 3];
        p = new int[2 * n + 3];
        s = str.toCharArray();
        s_new[0] = '$';
        s_new[1] = '#';
        for (int i = 0; i < s.length; i++) {
            s_new[j++] = s[i];
            s_new[j++] = '#';
        }
    }

    public int manacher(String str) {
        init(str);
        int max_len = -1;
        int id = 0;
        int mx = 0;
        for (int i = 1; i < j; i++) {
            if (i < mx) {
                p[i] = Math.min(p[2 * id - i], mx - i);
            }else{
                p[i] = 1;
            }
            while (s_new[i - p[i]] == s_new[i + p[i]]) {
                p[i]++;
            }
            if (mx < i + p[i]) {
                id = i;
                mx = i + p[i];
            }
            max_len = Math.max(max_len, p[i] - 1);
        }
        return max_len;
    }

    public static void main(String[] args) {
        Manacher manacher = new Manacher();
        System.out.println(manacher.manacher("abavcbahfioahfeiowabgoidahgioawberfiudshagviaoaivnefoawhguiadhfiwebgiudashvbiabefihaiofgaebcf"));
        System.out.println(Arrays.toString(manacher.s_new));
        System.out.println(Arrays.toString(manacher.p));
    }
}
