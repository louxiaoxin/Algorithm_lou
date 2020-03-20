package Algorithm_lou.math;

public class ExtendedEuclideanAlgorithm {
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b - b / a * a, a);
    }

    public static int[] helper(int a, int b) {
        if (a == 0) {
            return new int[]{0, 1};
        }
        int[] res = new int[2];
        int[] tmp = helper(b - b / a * a, a);
        res[0] = tmp[1] - b / a * tmp[0];
        res[1] = tmp[0];
        return res;
    }

    /**
     * 小于x的整数mod x 的逆元
     * @param x 输入为一个素数
     * @return
     */
    public static int[] modInv(int x) {
        int[] inv = new int[x];
        inv[1] = 1;
        for (int i = 2; i < x; i++) {
            inv[i] = (x - (x / i) * inv[x % i] % x) % x;//前面加x是为了确保该逆元为正
        }
        return inv;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(60000).length());
    }
}
