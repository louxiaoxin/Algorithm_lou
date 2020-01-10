package Algorithm_lou.segtree;

/**
 * 指针形式的前缀树
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.wordEnd = false;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = new Character(word.charAt(i));
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        boolean found = true;
        for (int i = 0; i < word.length(); i++) {
            Character c = new Character(word.charAt(i));
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return found;
    }

    public boolean startWith(String prefix) {
        TrieNode node = root;
        boolean found = true;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = new Character(prefix.charAt(i));
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return found;
    }

    public static void main(String[] args) {
        System.out.println(25^8);
        System.out.println(Integer.toBinaryString(25));
    }
}
