import arraysandhashing.EncodeDecode271;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode271Tests {


    @Test
    public void test_case_1() {
        EncodeDecode271.Codec codec = new EncodeDecode271.Codec();

        List<String> data = new ArrayList<>();
        data.add("Hello");
        data.add("world");

        String encoded = codec.encode(data);
        Assert.assertEquals("5,5;Helloworld", encoded);

        List<String> decoded = codec.decode(encoded);
        Assert.assertEquals(data, decoded);
    }

}
