import arraysandhashing.GroupAnagrans49;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GroupAnagrans49Tests {

    @Test
     public void assertGroup() {
         GroupAnagrans49.Solution sol = new GroupAnagrans49.Solution();
         List<List<String>> result =
         sol.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

         Assert.assertEquals(3, result.size());
     }

}
