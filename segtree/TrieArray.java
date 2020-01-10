package segtree;

public class TrieArray {
    int max = 50500;
    int[][] trie = new int[max][30];
    int tot = 0;
    boolean[] flag = new boolean[5555555];

    public void insert(String a) {
        int root = 0;
        int id;
        for (int i = 0; i < a.length(); i++) {
            id = a.charAt(i) - 'a';
            if (trie[root][id] == 0) {
                trie[root][id] = ++tot;
            }
            root = trie[root][id];
        }
        flag[root]=true;
    }

    public boolean search(String a) {
        int root=0;
        int id;
        for (int i = 0; i < a.length(); i++) {
            id = a.charAt(i) - 'a';
            if (trie[root][id] == 0) {
                return false;
            }
            root = trie[root][id];
        }
        return flag[root];
    }

    public static void main(String[] args) {
        int num = 0;
    }
}
