package arraysandhashing;

import java.util.HashMap;
import java.util.HashSet;

/**
 In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

 If the town judge exists, then:

 The town judge trusts nobody.
 Everybody (except for the town judge) trusts the town judge.
 There is exactly one person that satisfies properties 1 and 2.
 You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

 Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */
public class FindTheJudge {

    public static void main(String[] args) {
       int res =  findJudge(2, new int[][] { {1,2} } );
       System.out.println(res);
    }

    public static int findJudge(int n, int[][] trust) {
        if (trust.length == 0) return -1;

        HashMap<Integer, HashSet<Integer>> people = new HashMap();
        for (int[] pair : trust) {
            HashSet<Integer> trusters = null;
            if (people.containsKey(pair[0])) {
                trusters = people.get(pair[0]);
            } else {
                trusters = new HashSet();
            }
            trusters.add(pair[1]);
            people.put(pair[0], trusters);
        }

        for (int[] pair : trust) {
            if (!people.containsKey(pair[1]) && people.containsValue(pair[1]))
                return pair[1];
        }

        return -1;
    }
}
