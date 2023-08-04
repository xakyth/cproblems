package leetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cp139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        class TrieNode {
            private HashMap<Character, TrieNode> children;
            private boolean isWord;

            public TrieNode() {
                this.children = new HashMap<>(26);
            }
            public void insert(String word) {
                TrieNode current = this;
                for (char c : word.toCharArray()) {
                    current = current.children.computeIfAbsent(c, a -> new TrieNode());
                }
                current.isWord = true;
            }
            public boolean find(String word) {
                TrieNode current = this;
                for (char c : word.toCharArray()) {
                    TrieNode node = current.children.get(c);
                    if (node == null)
                        return false;
                    current = node;
                }
                return current.isWord;
            }
        }
        TrieNode trie = new TrieNode();
        for (String word : wordDict)
            trie.insert(word);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                String t = s.substring(i-1, j);
                if (dp[i-1] && trie.find(t)) {
                    dp[j] = true;
                }
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        cp139 c = new cp139();
        List<String> input = new ArrayList<>();
        input.add("cats");
        input.add("dog");
        input.add("sand");
        input.add("and");
        input.add("cat");
        
        String s = "catsandog";
        System.out.println(c.wordBreak(s, input));
    }
}
