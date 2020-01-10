package Algorithm_lou.union_set;

/**
 * 并查集：可用于病毒感染等问题，其中kruskal算法中也用到并查集判断环的生成
 */
public class unionSetHigh {
    int[] f;
    int[] rank;

    public int findRoot(int p) {
        while (p != f[p]) {
            f[p] = f[f[p]];
            p = f[p];
        }
        return p;
    }

    public void union(int a, int b) {
        int aR = findRoot(a);
        int bR = findRoot(b);
        if (aR == bR) {
            return;
        }
        if (rank[aR] < rank[bR]) {
            f[aR] = f[bR];
        } else if (rank[aR] > rank[bR]) {
            f[bR] = f[aR];
        }else{
            f[aR] = f[bR];
            rank[bR]++;
        }
    }
}
