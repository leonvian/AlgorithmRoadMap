package math;

public class StringToNumber {

    public static void main(String[] args) {
        String target = "394";

        int sum = 0;
        int charIndex = 0;
        for (int i = target.length()-1; i >= 0; i --) {
            int dividend = (int)Math.pow(10, i);
            int currentChar = target.charAt(charIndex) - '0';
            charIndex++;
            sum += currentChar * dividend;
        }
        print(sum);
    }

    private static void print(int val) {
        System.out.println(val);
    }

    private static void print(Double val) {
        System.out.println(val);
    }

    private static void print(String val) {
        System.out.println(val);
    }
}
