import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CodeWarsTests
{
    @Test
    public void reverseWordsTest()
    {
        Assertions.assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", CodeWars.reverseWords("The quick brown fox jumps over the lazy dog."));
        Assertions.assertEquals("elppa", CodeWars.reverseWords("apple"));
        Assertions.assertEquals("a b c d", CodeWars.reverseWords("a b c d"));
        Assertions.assertEquals("elbuod  decaps  sdrow", CodeWars.reverseWords("double  spaced  words"));
    }

    @Test
    public void mexicanWaveTest()
    {
        Assertions.assertArrayEquals(CodeWars.mexicanWave("hello"),
                new String[] { "Hello", "hEllo", "heLlo", "helLo", "hellO" });

        Assertions.assertArrayEquals(CodeWars.mexicanWave("codewars"),
                new String[] { "Codewars", "cOdewars", "coDewars", "codEwars", "codeWars", "codewArs", "codewaRs", "codewarS" });

        Assertions.assertArrayEquals(CodeWars.mexicanWave(""),
                new String[] { });

        Assertions.assertArrayEquals(CodeWars.mexicanWave("two words"),
                new String[] { "Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS" });

        Assertions.assertArrayEquals(CodeWars.mexicanWave(" gap "),
                new String[] { " Gap ", " gAp ", " gaP " });
    }

    @Test
    public void validPhoneNumberTest()
    {
        Assertions.assertTrue(CodeWars.validPhoneNumber("(123) 456-7890"));
        Assertions.assertFalse(CodeWars.validPhoneNumber("(1111)555 2345"));
        Assertions.assertFalse(CodeWars.validPhoneNumber("(098) 123 4567"));
    }

    @Test
    public void cleanStringTest()
    {
        Assertions.assertEquals("de", CodeWars.cleanString("a#bc##de"));
        Assertions.assertEquals("ac", CodeWars.cleanString("abd##cdd##"));
    }

    @Test
    public void productFibTest()
    {
        Assertions.assertArrayEquals(new long[] {55, 89, 1}, CodeWars.productFib(4895));
        Assertions.assertArrayEquals(new long[] {89, 144, 0}, CodeWars.productFib(5895));
    }

    @Test
    public void ipsBetweenTest()
    {
        Assertions.assertEquals(50, CodeWars.ipsBetween("10.0.0.0", "10.0.0.50"));
        Assertions.assertEquals(256, CodeWars.ipsBetween("10.0.0.0", "10.0.1.0"));
        Assertions.assertEquals(246, CodeWars.ipsBetween("20.0.0.10", "20.0.1.0"));
    }
}
