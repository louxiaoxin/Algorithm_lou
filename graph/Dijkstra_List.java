package Algorithm_lou.graph;

import javafx.util.Pair;

import java.util.*;

/**
 * 基于邻接表实现Dijkstra算法
 */
public class Dijkstra_List {
    static List<List<Edge>> e;
    static int[] dist;
    static int n;
    static int[] path;

    public static int[] dijkstra(int s){
        dist = new int[n];
        path = new int[n];
        Arrays.fill(path, -1);
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        Queue<Pair<Integer,Integer>> heap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        dist[s] = 0;
        for (int i = 0; i < n; i++) {
            heap.offer(new Pair<>(dist[i], i));
        }
        while (!heap.isEmpty()) {
            Pair<Integer, Integer> tmp = heap.poll();
            int dis = tmp.getKey();
            int u = tmp.getValue();
            if (dis > dist[u]) {
                continue;
            }
            for (int i = 0; i < e.get(u).size(); i++) {
                int next = e.get(u).get(i).to;
                int cost = e.get(u).get(i).cost;
                if (dist[next] > dist[u] + cost) {
                    dist[next] = dist[u] + cost;
                    path[next] = u;
                    heap.offer(new Pair<>(dist[next], next));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        e = new ArrayList<>();
        n = 6;
        for (int i = 0; i < n; i++) {
            e.add(new ArrayList<>());
        }
        e.get(0).add(new Edge(2, 5));
        e.get(2).add(new Edge(1, 15));
        e.get(1).add(new Edge(0, 2));
        e.get(0).add(new Edge(3, 30));
        e.get(2).add(new Edge(5, 7));
        e.get(5).add(new Edge(3, 10));
        e.get(5).add(new Edge(4, 18));
        e.get(4).add(new Edge(3, 4));
        e.get(1).add(new Edge(4, 8));
        System.out.println(Arrays.toString(dijkstra(0)));
        System.out.println(Arrays.toString(path));
    }
}
