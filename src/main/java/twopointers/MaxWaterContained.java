package twopointers;

public class MaxWaterContained {

    /**
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * <p>
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * <p>
     * Return the maximum amount of water a container can store.
     * <p>
     * Notice that you may not slant the container.
     */

        public int maxArea(int[] height) {

            int start = 0;
            int end = height.length - 1;
            int maxArea = 0;
            while (start < end) {
                int distance = end - start;
                int currentArea = Math.min(height[start], height[end]) * distance;
                maxArea = Math.max(maxArea, currentArea);

                if (height[start] < height[end]) {
                    start++;
                } else {
                    end--;
                }
            }

            return maxArea;

    /*  Brute force
        int maxArea = 0;
        for (int i = 0; i < height.length; i ++) {
            for (int j = i +1; j < height.length; j ++) {
                int distance = j - i;
                int currentArea = Math.min(height[i], height[j]) * distance;
                maxArea = Math.max(maxArea, currentArea);
            }
        }

        return maxArea; */
        }


}
