package Algorithm_lou.segtree;

public class SegTreement {
    private int[] arr;
    private SegTree[] segTreeNode;

    public SegTreement(int[] arr) {
        this.arr = arr;
        segTreeNode = new SegTree[arr.length * 2 - 1];
        for (int i = 0; i < segTreeNode.length; i++) {
            segTreeNode[i] = new SegTree();
        }
        buildTree(0,0,arr.length-1);
    }

    public void buildTree(int root, int start, int end) {
        if (start == end) {
            segTreeNode[root].val = arr[start];
            return;
        }
        int min = (start + end) / 2;
        buildTree(root * 2 + 1, start, min);
        buildTree(root * 2 + 2, min + 1, end);
        segTreeNode[root].val = segTreeNode[root * 2 + 1].val + segTreeNode[root * 2 + 2].val;
    }

    public int query(int start, int end) {
        if (end < 0 || start > arr.length - 1) {
            return 0;
        }
        if (end > arr.length - 1) {
            end = arr.length - 1;
        }
        if (start < 0) {
            start = 0;
        }
        return query(0, 0, arr.length - 1, start, end);
    }

    private int query(int root, int start, int end, int qstart, int qend) {
        if (start == qstart && end == qend) {
            return segTreeNode[root].val;
        }
        int mid = (start + end) / 2;
        if (qstart >= mid + 1) {
            return query(root * 2 + 2, mid + 1, end, qstart, qend);
        } else if (mid >= qend) {
            return query(root * 2 + 1, start, mid, qstart, qend);
        }
        int a = query(root * 2 + 1, start, mid, qstart, mid);
        int b = query(root * 2 + 2, mid + 1, end, mid + 1, qend);
        return a + b;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 9, 3, 7,8};
        SegTreement segTreement = new SegTreement(arr);
        for (int i = 0; i < segTreement.segTreeNode.length; i++) {
            System.out.print(segTreement.segTreeNode[i].val + " ");
        }
        System.out.println();
        System.out.println(segTreement.query(30,100));
    }
}

class SegTree{
    int val;
}