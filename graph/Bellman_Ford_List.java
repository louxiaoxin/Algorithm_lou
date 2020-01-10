package Algorithm_lou.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基于邻接表实现BellmanFord算法
 * 可用于判断负环，即当第n论后还存在松弛，即有负环
 */
public class Bellman_Ford_List {
    static List<List<Edge>> e = new ArrayList<>();
    static int n;
    static int[] dist;
    static int[] path;

    public static int[] BellmanFord(int u) {
        dist = new int[n];
        path = new int[n];
        Arrays.fill(path, -1);
        Arrays.fill(dist, 1000000000);
        dist[u] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Edge> tmp = e.get(j);
                for (Edge t : tmp) {
                    if (dist[t.to] > dist[j] + t.cost) {
                        dist[t.to] = dist[j] + t.cost;
                        path[t.to] = j;
                    }
                }
            }
        }
        return dist;
    }

    //判断图中是否存在负环，存在问题：从原点到目标地点是否经过该负环
    public static boolean negativeRing(int u) {
        boolean flag = false;
        dist = new int[n];
        path = new int[n];
        Arrays.fill(path, -1);
        Arrays.fill(dist, 1000000000);
        dist[u] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Edge> tmp = e.get(j);
                for (Edge t : tmp) {
                    if (dist[t.to] > dist[j] + t.cost) {
                        dist[t.to] = dist[j] + t.cost;
                        path[t.to] = j;
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            List<Edge> tmp = e.get(j);
            for (Edge t : tmp) {
                if (dist[t.to] > dist[j] + t.cost) {
                    flag=true;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        n = 5;
        for (int i = 0; i < n; i++) {
            e.add(new ArrayList<>());
        }
        e.get(0).add(new Edge(1, 6));
        e.get(0).add(new Edge(3, 7));
        e.get(1).add(new Edge(2, 5));
        e.get(1).add(new Edge(3, 8));
        e.get(1).add(new Edge(4, -4));
        e.get(2).add(new Edge(1, -2));
        e.get(3).add(new Edge(2, -3));
        e.get(3).add(new Edge(4, 9));
        e.get(4).add(new Edge(0, 2));
        e.get(4).add(new Edge(2, 7));
        System.out.println(negativeRing(0));
    }
}
