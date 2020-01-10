package Algorithm_lou.graph;

import java.util.*;

public class SPFA {
    static int n;
    static int[] dist;
    static int[] path;
    static List<List<Edge>> e = new ArrayList<>();

    public static int[] SPFA(int u) {
        dist = new int[n];
        path = new int[n];
        Arrays.fill(dist,1000000000);
        Arrays.fill(path, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[u] = 0;
        q.offer(u);
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Edge> tmp = e.get(cur);
            for (Edge t : tmp) {
                if (dist[t.to] > dist[cur] + t.cost) {
                    dist[t.to] = dist[cur] + t.cost;
                    path[t.to] = cur;
                    if (!q.contains(t.to)) {
                        q.offer(t.to);
                    }
                }
            }
        }
        return dist;
    }

    //判断图中是否存在负环，存在问题：从原点到目标地点是否经过该负环
    public static boolean negativeRing(int u) {
        dist = new int[n];
        path = new int[n];
        boolean flag = false;
        int[] arr = new int[n];
        Arrays.fill(dist,1000000000);
        Arrays.fill(path, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[u] = 0;
        q.offer(u);
        arr[u]++;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (arr[cur] > n) {
                flag = true;
                break;
            }
            List<Edge> tmp = e.get(cur);
            for (Edge t : tmp) {
                if (dist[t.to] > dist[cur] + t.cost) {
                    dist[t.to] = dist[cur] + t.cost;
                    path[t.to] = cur;
                    if (!q.contains(t.to)) {
                        q.offer(t.to);
                        arr[t.to]++;
                    }
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
        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(path));
    }
}
