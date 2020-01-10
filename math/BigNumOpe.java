package math;

/**
 * 大数操作：分别有大数乘法，大数加法， 大数阶乘以及大数阶乘的位数
 */
public class BigNumOpe {
    public static String add(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int n1 = ch1.length;
        int n2 = ch2.length;
        int n = Math.max(n1, n2);
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 0; i < n1; i++) {
            a[i] = ch1[n1 - i - 1] - '0';
        }
        for (int i = 0; i < n2; i++) {
            b[i] = ch2[n2 - i - 1] - '0';
        }
        for (int i = 0; i < n; i++) {
            if (a[i] + b[i] >= 10) {
                int tmp = a[i] + b[i];
                a[i] = tmp % 10;
                a[i + 1] += tmp / 10;
            }else{
                a[i] += b[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        if (a[n] != 0) {
            sb.append(a[n]);
        }
        for (int i = n - 1; i >= 0; i--) {
            sb.append(a[i]);
        }
        return sb.toString();
    }

    public static String mul(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int n1 = ch1.length;
        int n2 = ch2.length;
        int[] a = new int[n1];
        int[] b = new int[n2];
        int[] c = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            a[i] = ch1[n1 - i - 1] - '0';
        }
        for (int i = 0; i < n2; i++) {
            b[i] = ch2[n2 - i - 1] - '0';
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                c[i + j] += a[i] * b[j];
            }
        }
        for (int i = 0; i < n1 + n2 - 1; i++) {
            if (c[i] >= 10) {
                c[i + 1] += c[i] / 10;
                c[i] %= 10;
            }
        }
        int i;
        for (i = n1 + n2 - 1; i >= 0; i--) {
            if (c[i] != 0) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (; i >= 0; i--) {
            sb.append(c[i]);
        }
        return sb.toString();
    }

    public static int factorialDigit(int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.log10(i + 1);
        }
        return (int) sum + 1;
    }

    public static String bigFactorial(int n) {
        int[] ans = new int[10000001];
        int digit = 1;
        ans[0] = 1;
        for (int i = 2; i <= n; i++) {
            int num = 0;
            for (int j = 0; j < digit; j++) {
                int temp = ans[j] * i + num;
                ans[j] = temp % 10;
                num = temp / 10;
            }
            while (num != 0) {
                ans[digit] = num % 10;
                num /= 10;
                digit++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = digit - 1; i >= 0; i--) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(factorialDigit(20000));
        System.out.println(bigFactorial(20000));
    }
}
