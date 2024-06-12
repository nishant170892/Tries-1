// Time Complexity : O(L)  l is length of the word
// Space Complexity : O(no of words * length of each word)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Problem: https://leetcode.com/problems/implement-trie-prefix-tree/


class Trie {

    TrieNode root;

    class TrieNode {
        boolean isEnd;
        TrieNode children[];

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;
        for(char c: word.toCharArray()) {

            if(curr.children[c -'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }

            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null){
                return false;
            }

            curr = curr.children[c-'a'];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(char c: prefix.toCharArray()) {
            if(curr.children[c-'a'] == null){
                return false;
            }

            curr = curr.children[c-'a'];
        }

        return true;
    }
}

