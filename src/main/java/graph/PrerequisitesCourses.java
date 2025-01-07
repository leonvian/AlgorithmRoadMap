package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PrerequisitesCourses {

    public static void main(String[] args) {
        int expected = 6;
        int[][] courses = new int[][]{
                {1,0},{0,3}, {0,2}, {3,2},
                {2,5},
                {4,5},
                {5,6},
                {2,4}
        };

        System.out.println(canFinishCourse(courses, expected));
    }

    private static boolean canFinishCourse(int[][] courses, int expected) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < expected; i ++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] course : courses) {
            map.get(course[0]).add(course[1]);
        }

        HashSet<Integer> allCourses = new HashSet<>(map.keySet());
        for (int course : allCourses) {
            if (!doCourse(map, course, new HashSet<>())) {
                return false;
            }
        }

        return true;
    }
    private static boolean doCourse(
            HashMap<Integer, List<Integer>> map,
            int course,
            HashSet<Integer> visited
    ) {
        if (visited.contains(course)) {
            return false;
        }
        if (!map.containsKey(course) || map.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);
        List<Integer> dependencies = map.get(course);
        for (int dependency : dependencies) {
            boolean success = doCourse(map, dependency, visited);
            if (!success) {
                return false;
            }
        }
        map.remove(course);
        visited.remove(course);

        return true;
    }

}
