package union_set;

/**
 * 并查集：可用于病毒感染等问题，其中kruskal算法中也用到并查集判断环的生成
 */
public class unionSetSize {
    int[] f;
    int[] sz;

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
        if (sz[aR] < sz[bR]) {
            f[aR] = f[bR];
            sz[aR] += sz[bR];
        } else {
            f[bR] = f[aR];
            sz[bR] += sz[aR];
        }
    }
}
