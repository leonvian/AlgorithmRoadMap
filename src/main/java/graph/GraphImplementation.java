package graph;

import java.util.*;

public class GraphImplementation {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.populate(new char[][] {
                {'A','B'},
                {'A','C'},
                {'A', 'D'},
                {'B', 'C'},
                {'C', 'D'},
                {'D', 'A'},
                {'D', 'E'},
        });

        System.out.println(graph.bfs('B', 'A'));
        System.out.println(graph.dps('B', 'E'));
    }

    private static class Graph {
        HashMap<Character, List<Character>> graph = new HashMap<>();

        public boolean bfs(char origin, char dst) {
            HashSet<Character> visited = new HashSet<>();
            Queue<Character> queue = new LinkedList<>();
            visited.add(origin);
            queue.add(origin);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i  = 0; i < size; i ++) {
                    char current = queue.poll();
                    if (current == dst) return true;
                    List<Character> child = graph.get(current);
                    for (Character currentChild : child) {
                        if (!visited.contains(currentChild)) {
                            visited.add(currentChild);
                            queue.add(currentChild);
                        }
                    }
                }
            }

            return false;
        }

        public boolean dps(char origin, char dst) {
            return dpsHelper(origin, dst, new HashSet<Character>());
        }

        private boolean dpsHelper(char origin, char dst, HashSet<Character> visited) {
            if (origin == dst) return true;
            if (visited.contains(origin)) return false;

            visited.add(origin);
            List<Character> children = graph.get(origin);
            for (Character child : children) {
                if (dpsHelper(child, dst, visited)) {
                    return true;
                }
            }

            return false;
        }

        public void populate(char[][] edges) {
            for (char[] edge : edges) {
                char origin = edge[0];
                char dst = edge[1];
                if (!graph.containsKey(dst)) {
                    graph.put(dst, new ArrayList<>());
                }

                if (!graph.containsKey(origin)) {
                    graph.put(origin, new ArrayList<>());
                }

                graph.get(origin).add(dst);
            }
        }


    }
}
