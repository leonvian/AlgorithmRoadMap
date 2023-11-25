package unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RedundantConnection {


        public int[] findRedundantConnection(int[][] edges) {
            HashSet<Integer> values = new HashSet<Integer>();
            for (int[] edge : edges) {
                values.add(edge[0]);
                values.add(edge[1]);
            }

            UnionFind finder = new UnionFind(values);

            for (int[] edge : edges) {
                finder.isUnited(edge[0],edge[1]);
            }

            return null;
        }

        private class UnionFind {
            private HashMap<Integer, Integer> data = new HashMap();
            private HashMap<Integer, Integer> rank = new HashMap();

            public UnionFind(Set<Integer> values) {
                for (Integer value : values) {
                    data.put(value, value);
                }
            }

            public int find(int value) {
                int currentParent = data.get(value);
                if (currentParent != value) {
                    return find(currentParent);
                } else {
                    return currentParent;
                }
            }

            public void union(int value1, int value2) {
                data.put(find(value1), find(value2));
            }

            public boolean isUnited(int value1, int value2) {
                return find(value1) == find(value2);
            }

        }
}
