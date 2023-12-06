package math;

public class MoneyInLeetcodeBank {

    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        if (n <= 7) {
            return help(n);
        }

        int weekSum = 28;
        int result = 0;
        int numberOfWeeks = n / 7;
        int i = 0;
        for (; i < numberOfWeeks; i ++) {
            result += (i * 7) + weekSum;
        }

        // 42
        result += help(n % 7) + ( i * (n % 7));

        return result;
    }

    private static int help(int n) {
        if (n == 0) return 0;

        return help(n - 1) + n;
    }
}
