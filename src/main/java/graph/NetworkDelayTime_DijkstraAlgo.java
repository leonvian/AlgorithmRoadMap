package graph;

import java.util.*;

public class NetworkDelayTime_DijkstraAlgo {

    public static void main(String[] args) {
        int result = networkDelayTime(new int[][] {
                { 2, 1, 1},
                { 2, 3, 1},
                { 3, 4, 1}
        }, 4, 2);

        System.out.println(result);
    }


    private static int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] tripData : times) {
            int source = tripData[0];
            int target = tripData[1];
            int weight = tripData[2];

            List<Edge> edges = null;
            if (graph.containsKey(source)) {
                edges = graph.get(source);
            } else {
                edges = new ArrayList<>();
            }

            edges.add(new Edge(target, weight));
            graph.put(source, edges);
        }

        Comparator<Edge> comparator = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        };

        PriorityQueue<Edge> heap = new PriorityQueue<>(comparator);
        heap.add(new Edge(k, 0));

        HashMap<Integer, Integer> tableResult = new HashMap<>();

        while (!heap.isEmpty()) {
            Edge current = heap.poll();

            if (tableResult.containsKey(current.target)) continue;

            tableResult.put(current.target, current.weight);

            if (!graph.containsKey(current.target)) continue;

            List<Edge> edges = graph.get(current.target);
            for (Edge edge : edges) {

                if (tableResult.containsKey(edge.target)) continue;

                int updatedWeight = edge.weight + current.weight;
                heap.add(new Edge(edge.target, updatedWeight));
            }
        }

        if (tableResult.size() < n) return -1; // Not all nodes are acessibile;

        int max = 0;
        for (int key : tableResult.keySet()) {
            max = Math.max(max, tableResult.get(key));
        }

        return max;
    }


     static class Edge {

        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

         @Override
         public String toString() {
             return target +" W -> "+ weight;
         }
     }


}
