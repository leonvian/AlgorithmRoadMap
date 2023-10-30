package strings;

import java.util.ArrayList;
import java.util.List;

/**
    Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

"Thisisanexample"
     */
public class TextJustification {

    public static void main(String[] args) {
        System.out.println(
                fullJustify(
                        new String[]{
                                "ask", "not", "what", "your", "country",
                                "can", "do", "for", "you", "ask", "what",
                                "you", "can", "do", "for", "your", "country"
                        }, 16));


    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList();

        int availableWidth = maxWidth;
        List<String> nextLineWords = new ArrayList<String>();
        int lineCharCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (availableWidth >= words[i].length()) {
                nextLineWords.add(words[i]);
                lineCharCount += words[i].length();
                availableWidth = availableWidth - (words[i].length() + 1);
            } else {
                result.add(createLine(nextLineWords, lineCharCount, maxWidth));
                nextLineWords.clear();
                lineCharCount = 0;
                availableWidth = maxWidth;
                i--;
            }
        }

        result.add(createLastLine(nextLineWords, lineCharCount, maxWidth));

        return result;
    }

    private static String createLine(List<String> nextLineWords, int totalSize, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int spots = 1;
        if (nextLineWords.size() > 1) {
            spots = nextLineWords.size() - 1;
        }
        int spaces = maxWidth - totalSize;
        int spacesPerSpot = spaces / spots;
        int remaining = spaces  % spots;

        for (String target : nextLineWords) {
            if (spaces < spacesPerSpot) {
                spacesPerSpot = spaces;
            }
            sb.append(target);
            for (int i = 0; i < spacesPerSpot; i++) {
                sb.append(" ");
                spaces --;
            }

            if (remaining > 0) {
                sb.append(" ");
                remaining --;
                spaces --;
            }
        }

        return sb.toString();
    }

    private static String createLastLine(List<String> nextLineWords, int totalSize, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int spaces = maxWidth - totalSize;

        for (String target : nextLineWords) {
            sb.append(target);
            if (spaces > 0) {
                sb.append(" ");
                spaces--;
            }

        }

        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }

}
