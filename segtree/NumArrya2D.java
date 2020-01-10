package Algorithm_lou.segtree;

import java.util.Arrays;

/**
 * 二维树状数组
 */
public class NumArrya2D {
    int[][] data;
    int[][] sums;
    int m;
    int n;

    public NumArrya2D(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        data = new int[m][n];
        sums = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = matrix[i][j];
                renewal(i + 1, j + 1, data[i][j]);
            }
        }
    }

    private int lowbit(int x) {
        return x & (-x);
    }

    private void renewal(int a, int b, int delta) {
        for (int i = a; i <= m; i += lowbit(i)) {
            for (int j = b; j <= n; j += lowbit(j)) {
                sums[i][j] += delta;
            }
        }
    }

    private void update(int a, int b, int val) {
        renewal(a + 1, b + 1, val - data[a][b]);
        data[a][b] = val;
    }

    private int query(int a, int b) {
        int s = 0;
        for (int i = a; i > 0; i -= lowbit(i)) {
            for (int j = b; j > 0; j -= lowbit(j)) {
                s += sums[i][j];
            }
        }
        return s;
    }

    public int sumRange(int a, int b, int c, int d) {
        return query(c + 1, d + 1) + query(a, b) - query(c + 1, b) - query(a, d + 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumArrya2D numArrya2D = new NumArrya2D(matrix);
        for (int[] tmp : numArrya2D.data) {
            System.out.println(Arrays.toString(tmp));
        }
        System.out.println(numArrya2D.sumRange(1, 2, 3, 4));
    }
}
