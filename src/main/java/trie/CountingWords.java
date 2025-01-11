package trie;

import java.util.HashMap;
import java.util.HashSet;

public class CountingWords {

    public static void main(String[] args) {
       // String[] words = {"lewsmb","lewrydnve","lewqqm","lewec","lewn","lewb","lewedb"};
        //System.out.println(prefixCount(words, "lew"));

      //  int mod = 4 % 2;

        String[] case2 = {"sxyjellhlh","sxyjellhlh"};
        System.out.println(prefixCount(case2, "sxyjellhlh"));
    }


    public  int prefixCount2(String[] words, String pref) {
        int index = 0;
        HashSet<String> ignore = new HashSet();
        while (index < pref.length()) {
            for (String word : words) {
                if (ignore.contains(word))  {
                    continue;
                }

                if (word.length() < pref.length()) {
                    ignore.add(word);
                    continue;
                }


                if (word.charAt(index) != pref.charAt(index)) {
                    ignore.add(word);
                    continue;
                }
            }

            index++;
        }

        return words.length - ignore.size();
    }

    public static int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        int count = trie.count(pref);
        return count;

    }

    private static class Trie {
        TrieNode root = new TrieNode('*');

        public void add(String word) {
            TrieNode node = root;
            word = word.concat("*");
            for (char c : word.toCharArray()) {
                if (node.contains(c)) {
                    node.count++;
                    node = node.getNext(c);
                } else {
                    node = node.add(c);
                }
            }
        }

        public int count(String prefix) {
            TrieNode node = root;

            for (char c : prefix.toCharArray()) {
                if (node.contains(c)) {
                    node = node.getNext(c);
                }  else {
                    return 0;
                }
            }

            return node.count;
        }

    }

    private static class TrieNode {
        int count;
        char key;
        HashMap<Character, TrieNode> child = new HashMap();

        public TrieNode(char key) {
            this.key = key;
        }

        public boolean contains(Character c) {
            return child.containsKey(c);
        }

        public TrieNode getNext(Character node) {
            return child.get(node);
        }

        public TrieNode add(char c) {
            TrieNode node = new TrieNode(c);
            count ++;
            child.put(c, node);

            return node;
        }

        public int hashCode() {
            return 7 * key;
        }

        public boolean equals(Object o) {
            if (o == null) return false;
            if (o == this) return true;
            if (!(o instanceof TrieNode)) {
                return false;
            }

            return key == ((TrieNode)o).key;
        }

    }
}
