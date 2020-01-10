package segtree;

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
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 2, 5, 10, 0, 5, 4, 8, 6, 145, 15};
        NumArray numArray = new NumArray(nums);
        System.out.println(Arrays.toString(numArray.data));
        System.out.println(Arrays.toString(numArray.sums));
        System.out.println(numArray.sumRange(1, 5));
    }
}
