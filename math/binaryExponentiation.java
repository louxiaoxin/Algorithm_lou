package Algorithm_lou.math;

public class binaryExponentiation {
    /**
     * 快速幂（非递归）
     * @param a,b 求解a^b
     * @return
     */
    public int binPow(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= a;
            }
            a *= a;
            b >>= 1;
        }
        return res;
    }

    /**
     * 快速幂取模
     * @param a,b,m 求解a^b%m
     * @return
     */
    public int binPowMod(int a, int b, int m) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= a % m;
            }
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }

    static int k;

    public static int[] to_bin(String str) {
        int n = str.length();
        int[] input = new int[n];
        int[] output = new int[(int) (Math.log10(Math.pow(10, n + 1)) / Math.log10(2))];
        for (int i = 0; i < n; i++) {
            input[i] = str.charAt(i) - '0';
        }
        int sum = 1, d;
        while (sum > 0) {
            sum = 0;
            for (int i = 0; i < n; i++) {
                d = input[i] / 2;
                sum += d;
                if (i == (n - 1)) {
                    output[k++] = input[i] % 2;
                } else {
                    input[i + 1] += (input[i] % 2) * 10;
                }
                input[i] = d;
            }
        }
        return output;
    }

    public static long binPowBigNum(long a, String str, int p) {
        long res = 1;
        int[] output = to_bin(str);
        for (int i = 0; i < k; i++) {
            if (output[i] == 1) {
                res *= a % p;
            }
            a *= a % p;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(binPowBigNum(2, "999", 3));
    }
}
