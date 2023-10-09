import org.junit.Assert;
import org.junit.Test;
import stack.ValidParentheses20;

public class ValidParentheses20Tests {

    @Test
    public void testCase1() {
        Assert.assertTrue(ValidParentheses20.isValid("()[]{}"));
    }

    @Test
    public void testCase2() {
        Assert.assertFalse(ValidParentheses20.isValid("(]"));
    }

    @Test
    public void testCase3() {
        Assert.assertFalse(ValidParentheses20.isValid("([)]"));
    }

}
