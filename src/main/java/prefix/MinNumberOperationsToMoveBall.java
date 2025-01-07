package prefix;

public class MinNumberOperationsToMoveBall {

    public static void main(String[] args) {
        int[] res = minOperations("110");
        for(int var : res) {
            System.out.print(var);
        }
    }

    private static int[] minOperations(String boxes) {
        char[] array = boxes.toCharArray();
        int[] prefix = new int[boxes.length()];
        int sum = 0;
        int balls = 0;
        for (int i = 0; i < array.length; i ++) {
            int value = Character.getNumericValue(array[i]);
            if (value == 0) continue;

            balls ++;
            sum += i;
        }

        prefix[0] = sum;
        for (int i = 1; i < array.length; i ++) {
            int ballsLeft = Character.getNumericValue(array[i-1]);
            balls -= ballsLeft;
            prefix[i] = prefix[i-1] - balls;
        }

        int[] sufix = new int[boxes.length()];
        sum = 0;
        balls = 0;
        for (int i = array.length -1; i >= 0; i --) {
            int value = Character.getNumericValue(array[i]);
            if (value == 0) continue;

            balls ++;
            sum += (array.length -1) - i;
        }
        sufix[array.length -1] = sum;

        for (int i = array.length - 2; i > 0; i --) {
            int ballsLeft = Character.getNumericValue(array[i+1]);
            balls -= ballsLeft;
            sufix[i] = sufix[i+1] - balls;
        }

        int[] ans = new int[boxes.length()];
        for (int i = 0; i < ans.length; i ++) {
            ans[i] = prefix[i] + sufix[i];
        }

        return ans;

    }
}
