package Algorithm_lou;

class Solution {
    class TrieNode{
        private TrieNode[] children=new TrieNode[2];
    }

    TrieNode root=new TrieNode();

    public void insert(int num){
        TrieNode cur=root;
        for(int i=31;i>=0;i--){
            int t = (num & (1 << i)) >> i;
            if(cur.children[t]==null){
                cur.children[t]=new TrieNode();
            }
            cur=cur.children[t];
        }
    }

    int res=0;

    private void dfs(TrieNode node1, TrieNode node2, int sum, int k) {
        if (node1.children[0]==null&&node1.children[1]==null&&node2.children[0]==null&&node2.children[1]==null) {
            res = Math.max(sum, res);
            return;
        }
        if (node1 == null) {
            dfs(node2.children[0], node2.children[1], sum, k - 1);
        } else if (node2 == null) {
            dfs(node1.children[0], node1.children[1], sum, k - 1);
        } else {
            if (node1.children[0] != null && node2.children[1] != null) {
                dfs(node1.children[0], node2.children[1], (sum | (1 << k)), k - 1);
            }
            if (node1.children[1] != null && node2.children[0] != null) {
                dfs(node1.children[1], node2.children[0], (sum | (1 << k)), k - 1);
            }
        }
    }

    public int findMaximumXOR(int[] nums) {
        for(int num:nums){
            insert(num);
        }
        dfs(root.children[0], root.children[1], 0, 31);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3, 10, 5, 25, 2, 8};
        System.out.println(solution.findMaximumXOR(arr));
    }
}