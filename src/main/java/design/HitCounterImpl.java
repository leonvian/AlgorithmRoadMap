package design;

import utils.Checker;

import java.util.HashMap;

public class HitCounterImpl {

    public static void main(String[] args) {
        //testCase1();
        testCase3();
    }

    private static void testCase3() {
        /*
        ["HitCounter","hit","hit","hit","getHits","getHits","getHits"]
        [[],          [100],[101],[202], [310],    [400],     [401]]
        expected:                         3          2         1

         */

        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(100);
        hitCounter.hit(101);
        hitCounter.hit(202);
        Checker.checkEquals(3, hitCounter.getHits(310));
        Checker.checkEquals(2, hitCounter.getHits(400));
        Checker.checkEquals(1, hitCounter.getHits(401));
    }

    private static void testCase1() {
        /*
        ["HitCounter","hit","hit","hit","getHits","getHits","getHits","getHits","getHits","hit","getHits"]
          [[],         [2],  [3],   [4],  [300],   [301],    [302],    [303],     [304],   [501], [600]]
         */
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(2);
        hitCounter.hit(3);
        hitCounter.hit(4);
        Checker.checkEquals(3, hitCounter.getHits(300));
        Checker.checkEquals(3, hitCounter.getHits(301));
        Checker.checkEquals(2, hitCounter.getHits(302));
        Checker.checkEquals(1, hitCounter.getHits(303));
        Checker.checkEquals(0, hitCounter.getHits(304));
        hitCounter.hit(501);
        Checker.checkEquals(1, hitCounter.getHits(600));

        //[null,null,null,null,3,3,2,1,0,null,1]
    }


    private static class HitCounter {
        HashMap<Integer, int[]> map = new HashMap();

        public HitCounter() {

        }

        public void hit(int timestamp) {
            int block = timestamp / 300;
            int unity = timestamp % 300;
            initializeIfNot(block);
            map.get(block)[unity]++;
        }

        public int getHits(int timestamp) {
            int block = timestamp / 300;
            int unity = timestamp % 300;
            int count = 0;
            initializeIfNot(block);
            initializeIfNot(block-1);

            for (int i = 0; i <= unity; i++) {
                count += map.get(block)[i];
            }
            if (block > 0) {
                int end = 300 - (unity + 1);
                int start = 300 - end;
                for (int i = start; i <= 299; i++) {
                    count += map.get(block - 1)[i];
                }
            }

            return count;
        }

        private void initializeIfNot(int block) {
            if (block < 0) return;

            if (!map.containsKey(block)) {
                map.put(block, new int[300]);
            }
        }
    }

}
