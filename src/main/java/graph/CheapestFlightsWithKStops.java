package graph;

import java.util.*;

/**
 * There are n cities connected by some number of flights.
 * You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 * <p>
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 */
public class CheapestFlightsWithKStops {

    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };

        int[][] flights2 =  {
                { 0, 1, 4 },
                {0,2, 6},
                {1,3, 5},
                {2,3, 1},
                {1,2, 2}
        };


        HashMap<Integer, List<Edge>> graph = createGraph(flights2);
        List<Integer> results = new ArrayList<>();
        dpsBacktracking(graph, new HashSet<>(), 0, 3, 0, results);
        for (Integer res : results) {
            System.out.println(res);
        }

    }

    public static int findAllPaths(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<Edge>> graph = createGraph(flights);
        List<Integer> results = new ArrayList<>();
        dps(graph, new HashSet<>(), src, dst, 0, results);
        for (Integer res : results) {
            System.out.println(res);
        }

        return 0;
    }

    private static void bfs(
            HashMap<Integer, List<Edge>> graph,
            int src,
            int dst,
            HashSet<Integer> visited,
            List<Integer> res
    ) {
        int currentSum = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);

        LinkedList<Integer> newQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                int key = queue.poll();
                visited.add(src);
                List<Edge> edges = graph.get(key);
                for (Edge edge : edges) {
                    if (visited.contains(edge.dest)) continue;

                    currentSum += edge.dest;
                    if (edge.dest == dst) {
                        res.add(currentSum);
                    } else {
                        newQueue.add(edge.dest);
                    }
                }
            }
            queue = newQueue;
        }
    }

    private static void dps(HashMap<Integer, List<Edge>> graph,
                            HashSet<Integer> visited,
                            int src,
                            int dst,
                            int currentSum,
                            List<Integer> res) {

        if (graph.containsKey(src)) {
            visited.add(src);
            List<Edge> edges = graph.get(src);
            for (Edge edge : edges) {
                if (visited.contains(edge.dest)) continue;
                currentSum += edge.price;

                if (edge.dest == dst) {
                    res.add(currentSum);
                } else {
                    dps(graph, visited, edge.dest, dst, currentSum, res);
                }
            }
        }
    }

    private static void dpsBacktracking(HashMap<Integer, List<Edge>> graph,
                            HashSet<Integer> visited,
                            int src,
                            int dst,
                            int currentSum,
                            List<Integer> res) {

        if (graph.containsKey(src)) {
            visited.add(src);
            List<Edge> edges = graph.get(src);
            for (Edge edge : edges) {
                if (visited.contains(edge.dest)) continue;
                currentSum += edge.price;

                if (edge.dest == dst) {
                    res.add(currentSum);
                } else {
                    dpsBacktracking(graph, visited, edge.dest, dst, currentSum, res);
                }
                currentSum -= edge.price;
            }
            visited.remove(src);
        }
    }

    private static HashMap<Integer, List<Edge>> createGraph(int[][] flights) {
        HashMap<Integer, List<Edge>> graph = new HashMap<Integer, List<Edge>>();
        for (int[] flight : flights) {
            int origin = flight[0];
            int dest = flight[1];
            int price = flight[2];
            List<Edge> edges = null;
            if (graph.containsKey(origin)) {
                edges = graph.get(origin);
            } else {
                edges = new ArrayList<>();
            }
            edges.add(new Edge(dest, price));

            graph.put(origin, edges);
        }

        return graph;
    }

    private static class Edge {

        int dest;
        int price;

        public Edge(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }

        @Override
        public String toString() {
            return dest + " - " + price;
        }
    }

}
