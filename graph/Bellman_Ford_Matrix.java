package Algorithm_lou.graph;

import java.util.Arrays;

/**
 * 基于邻接矩阵实现Bellman_Ford算法
 */
public class Bellman_Ford_Matrix {
    static int[][] adjMatrix;
    static int n;
    static int[] path;
    static int[] dist;

    public static int[] BellmanFord(int u){
        dist = new int[n];
        path = new int[n];
        Arrays.fill(path, -1);
        Arrays.fill(dist, 1000000000);
        dist[u] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (adjMatrix[j][k] != 1000000000 && dist[k] > dist[j] + adjMatrix[j][k]) {
                        dist[k] = dist[j] + adjMatrix[j][k];
                        path[k] = j;
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        n = 5;
        adjMatrix = new int[n][n];
        for (int[] tmp : adjMatrix) {
            Arrays.fill(tmp, 1000000000);
        }
        adjMatrix[0][1] = 6;
        adjMatrix[0][3] = 7;
        adjMatrix[1][3] = 8;
        adjMatrix[1][2] = 5;
        adjMatrix[2][1] = -2;
        adjMatrix[1][4] = -4;
        adjMatrix[3][2] = -3;
        adjMatrix[3][4] = 9;
        adjMatrix[4][0] = 2;
        adjMatrix[4][2] = 7;
        System.out.println(Arrays.toString(BellmanFord(0)));
        System.out.println(Arrays.toString(path));
    }
}
