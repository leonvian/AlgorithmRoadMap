package recursion;

public class Fibonacci {

    public static int fib(int target) {
        if (target <= 1) {
            return target;
        }

        return fib(target - 1) + fib(target - 2);
    }

    public static int fibLoop(int target) {
       int num1 = 0;
       int num2 = 1;
       int result = 0;

       for (int i = 2; i <= target; i ++) {
           result = num1 + num2;
           num1 = num2;
           num2 = result;
       }

       return result;
    }

}
