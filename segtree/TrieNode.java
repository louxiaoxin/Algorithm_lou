package segtree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean wordEnd;
    int count;

    public TrieNode() {
        children = new HashMap<>();
        wordEnd = false;
        count = 0;
    }
}
