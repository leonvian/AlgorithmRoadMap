package trie;

import java.util.HashMap;

public class ImplementTrie {

    class Trie {

        private Node head = new Node();

        public void insert(String word) {
            Node node = head;
            for (char target : word.toCharArray()) {
                if (node.map.containsKey(target)) {
                    node = node.map.get(target);
                } else {
                    Node next = new Node();
                    node.map.put(target, next);
                    node = next;
                }
            }
            node.map.put('*', new Node());
        }

        public boolean search(String word) {
            Node node = head;
            for (char target : word.toCharArray()) {
                if (node.map.containsKey(target)) {
                    node = node.map.get(target);
                } else {
                    return false;
                }
            }

            return node.map.containsKey('*');
        }

        public boolean startsWith(String prefix) {
            Node node = head;
            for (char target : prefix.toCharArray()) {
                if (node.map.containsKey(target)) {
                    node = node.map.get(target);
                } else {
                    return false;
                }
            }

            return true;
        }


        private class Node {
            HashMap<Character, Node> map = new HashMap();
        }
    }

}
