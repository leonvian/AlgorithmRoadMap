package arraysandhashing;

public class ConstructKPalindromeStrings {

    public static void main(String[] args) {

        System.out.println(canConstruct("messi", 3));
    }

    public static boolean canConstruct(String s, int k) {
            if (k == 0 || s.length() == k) return true;

            int[] alpha = new int[26];
            for (char c : s.toCharArray()) {
                int pos = c - 'a';
                alpha[pos] += 1;
            }

            //int pairs = 0; // 1
            int single = 0; // 4

            for (int i = 0; i < 26; i ++) {
                if (alpha[i] == 0) continue;

                //pairs += alpha[i] / 2;
                single += alpha[i] % 2;
            }

            int max = s.length();
            int min = Math.max(single, 1);;

            return k >= min && k <= max;

    }

}
