package Algorithm_lou.graph;

import java.util.Arrays;

public class Floyd {
    static int n;
    static int[][] adjMatrix;
    static int[][] dist;
    static int[][] path;

    public static void floyd(){
        dist = new int[n][n];
        path = new int[n][n];
        for (int[] tmp : dist) {
            Arrays.fill(tmp, 1000000000);
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = adjMatrix[i][j];
                if (i != j && adjMatrix[i][j] < 1000000000) {
                    path[i][j] = i;
                }else{
                    path[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dist[j][i] + dist[i][k] < dist[j][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                        path[j][k] = path[i][k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        n = 5;
        adjMatrix = new int[n][n];
        for (int[] tmp : adjMatrix) {
            Arrays.fill(tmp, 1000000000);
        }
        for (int i = 0; i < n; i++) {
            adjMatrix[i][i] = 0;
        }
        adjMatrix[0][1] = 3;
        adjMatrix[0][2] = 8;
        adjMatrix[0][4] = -4;
        adjMatrix[1][3] = 1;
        adjMatrix[1][4] = 7;
        adjMatrix[2][1] = 4;
        adjMatrix[3][0] = 2;
        adjMatrix[3][2] = -5;
        adjMatrix[4][3] = 6;
        floyd();
        for (int[] tmp : dist) {
            System.out.println(Arrays.toString(tmp));
        }
        System.out.println("###############################");
        for (int[] tmp : path) {
            System.out.println(Arrays.toString(tmp));
        }
    }
}
