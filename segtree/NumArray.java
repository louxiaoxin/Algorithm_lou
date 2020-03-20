package Algorithm_lou.segtree;

import java.util.Arrays;

/**
 * 树状数组
 */
public class NumArray {
    private int[] data;
    private int[] sums;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        data = new int[n];
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            data[i] = nums[i];
            renewal(i + 1, nums[i]);
        }
    }

    private int lowbit(int x) {
        return x & (-x);
    }

    private void renewal(int i, int delta) {
        while (i <= n) {
            sums[i] += delta;
            i += lowbit(i);
        }
    }

    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += sums[i];
            i -= lowbit(i);
        }
        return sum;
    }

    public void update(int i, int a) {
        renewal(i + 1, a - data[i]);
        data[i] = a;
    }

    public int sumRange(int i, int j) {
        return query(j + 1) - query(i);
    }

    public static void main(String[] args) {
        String str="Intelligent Connected Vehicle Queue Control and State Estimation under Cyber Attack";
        System.out.println(str.toUpperCase());
    }
}
