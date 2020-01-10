package graph;

import java.util.*;

/**
 * 基于邻接矩阵实现Dijkstra算法
 */
public class Dijkstra_Matrix {
    static int[] path;
    static int[][] adjMatrix;
    static int n;
    static int[] dist;

    public static int[] dijkstra(int u) {
        n = adjMatrix.length;
        path = new int[n];
        dist = new int[n];
        boolean[] used = new boolean[n];
        Arrays.fill(path, -1);
        for (int i = 0; i < n; i++) {
            if (i != u) {
                dist[i] = adjMatrix[u][i];
                path[i] = u;
            }
        }
        used[u] = true;
        for (int i = 1; i < n; i++) {
            int min = 0x3f3f3f3f;
            int k = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && min > dist[j]) {
                    k = j;
                    min = dist[j];
                }
            }
            used[k] = true;
            for (int j = 0; j < n; j++) {
                if (!used[j]&& dist[j] > min + adjMatrix[k][j]) {
                    dist[j] = min + adjMatrix[k][j];
                    path[j] = k;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        adjMatrix = new int[6][6];
        for (int[] tmp : adjMatrix) {
            Arrays.fill(tmp, 0x3f3f3f3f);
        }
        adjMatrix[0][2] = 5;
        adjMatrix[2][1] = 15;
        adjMatrix[1][0] = 2;
        adjMatrix[0][3] = 30;
        adjMatrix[2][5] = 7;
        adjMatrix[5][3] = 10;
        adjMatrix[5][4] = 18;
        adjMatrix[4][3] = 4;
        adjMatrix[1][4] = 8;
        System.out.println(Arrays.toString(dijkstra(0)));
        System.out.println(Arrays.toString(path));
    }
}
