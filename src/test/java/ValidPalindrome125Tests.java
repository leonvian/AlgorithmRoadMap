import org.junit.Assert;
import org.junit.Test;
import twopointers.ValidPalindrome125;

public class ValidPalindrome125Tests {

    @Test
    public void testValidPalindrome() {
        Assert.assertTrue(ValidPalindrome125.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertTrue(ValidPalindrome125.isPalindromeFinal("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testInvalidPalindrome() {
        Assert.assertFalse(ValidPalindrome125.isPalindrome("Race a car"));
        Assert.assertFalse(ValidPalindrome125.isPalindromeFinal("Race a car"));
    }

}
