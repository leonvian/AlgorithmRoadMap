package arraysandhashing;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/encode-and-decode-strings/description/
 *
 */
public class EncodeDecode271 {

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> data = new ArrayList<>();
        data.add("Hello");
        data.add("world");
        String encoded = codec.encode(data);
        List<String> decoded = codec.decode(encoded);

        System.out.println(encoded);
    }

    public static class Codec {

        public String encode(List<String> strs) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strs.size(); i ++) {
                stringBuilder.append(strs.get(i).length());
                if (i != strs.size() -1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append(";");

            for (String str : strs) {
                stringBuilder.append(str);
            }

            return stringBuilder.toString();
        }

        public List<String> decode(String target) {
            int end = target.indexOf(';');
            String sizesStr = target.substring(0, end);
            String[] sizeArray = sizesStr.split(",");
            int startBody = end + 1;
            String body = target.substring(startBody);
            List<String> result = new ArrayList<>();
            startBody = 0;
            for (String sizeStr : sizeArray) {
                int size = Integer.parseInt(sizeStr);
                String newString = body.substring(startBody, startBody + size);
                result.add(newString);
                startBody = startBody + size;
            }

            return result;
        }
    }

}
