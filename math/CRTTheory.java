package Algorithm_lou.math;

/**
 * 中国剩余定理
 */
public class CRTTheory {
    /**
     * 求解中国剩余定理
     * @param a 余数数组
     * @param m mod数组
     * @param n 同余方程个数
     * @return
     */
    public static int CRT(int[] a, int[] m, int n) {
        int M = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            M *= m[i];
        }
        for (int i = 0; i < n; i++) {
            int Mi = M / m[i];
            int[] res = exgcd(Mi, m[i]);
            ans = (ans + a[i] * Mi * res[0]) % M;
        }
        return (ans + M) % M;
    }

    /**
     * 同余方程ax+by=c的解
     * @param a
     * @param b
     * @return
     */
    private static int[] exgcd(int a, int b) {
        if (a == 0) {
            return new int[]{0, 1};
        }
        int[] tmp = exgcd(b - b / a * a, a);
        int[] res = new int[2];
        res[0] = tmp[1] - b / a * tmp[0];
        res[1] = tmp[0];
        return res;
    }

    public static void main(String[] args) {
        int[] a = {0, 1};
        int[] m = {2, 7};
        System.out.println(CRT(a, m, 2));
    }
}
