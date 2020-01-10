package math;

public class gcd {
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int gcb(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        //最小公倍数
        return a * b / gcb(a, b);
    }

    public static int gcdL(int a, int b, int[] arr) {
        if (a == 0) {
            arr[0] = 0;
            arr[1] = 1;
            return b;
        }
        int[] tmp = new int[2];
        int d = gcdL(b % a, a, tmp);
        arr[0] = tmp[1] - (b / a) * tmp[0];
        arr[1] = tmp[0];
        return d;
    }

    public static boolean find_any_solution(int a, int b, int c, int[] arr) {
        int g = gcdL(Math.abs(a), Math.abs(b), arr);
        if (c % g != 0) {
            return false;
        }
        arr[0] *= c / g;
        arr[1] *= c / g;
        if (a < 0) {
            arr[0] = -arr[0];
        }
        if (b < 0) {
            arr[1] = -arr[1];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[2];
        int a = 10;
        int b = 15;
        int c = 5;
        System.out.println(find_any_solution(a, b, c, arr));
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
}
