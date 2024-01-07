package arraysandhashing;

import java.util.Arrays;

public class JobScheduling {

    public static void main(String[] args) {

        System.out.println( jobScheduling(
                        new int[] { 1,2,3,4,6 },
                        new int[] { 3,5,10,6,9 },
                        new int[] { 20,20,100,70,60}
                )
        );
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        Job[] jobs = new Job[profit.length];
        for (int i = 0; i < profit.length; i ++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs[i] = job;
        }

        Arrays.sort(jobs);

        int[] dp = new int[jobs.length];
        int last = jobs.length - 1;
        dp[last] = jobs[last].profit;
        int result = jobs[last].profit;

        for (int i = last-1; i >= 0; i --) {
            int max = 0;
            int j = i;
            while (j +1 <= last) {
                if (jobs[i].end <= jobs[j+1].start) {
                    max = Math.max(max, dp[j+1]);
                }
                j ++;
            }

            dp[i] = max + jobs[i].profit;
            result = Math.max(dp[i], result);
        }

        return result;
    }


    static class Job implements Comparable {

        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        public int compareTo(Object obj) {
            Job other = (Job) obj;
            return Integer.compare(start, other.start);
        }

    }

}

/*

--- Right approach with binary search


 public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.end - b.end);
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int profitIncludingCurrent = jobs[i].profit;
            int index = binarySearch(jobs, i);
            if (index != -1) {
                profitIncludingCurrent += dp[index];
            }
            dp[i] = Math.max(dp[i - 1], profitIncludingCurrent);
        }

        return dp[n - 1];
    }

    private static int binarySearch(Job[] jobs, int index) {
        int start = 0, end = index - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static class Job {
        int start, end, profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
 */
