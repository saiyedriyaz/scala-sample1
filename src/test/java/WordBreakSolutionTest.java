import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class WordBreakSolutionTest {

    @Test
    public void test1() {
        WordBreakSolution wordBreakSolution = new WordBreakSolution(new HashSet<>(Arrays.asList("a,ab,bc".split(","))));
        boolean foundAll = wordBreakSolution.wordBreak("abc");
        Assert.assertTrue(foundAll);
    }

    @Test
    public void test2() {
        WordBreakSolution wordBreakSolution = new WordBreakSolution(new HashSet<>(Arrays.asList("leet,code".split(","))));
        boolean foundAll = wordBreakSolution.wordBreak("leetcode");
        Assert.assertTrue(foundAll);
    }

    @Test
    public void test3() {
        WordBreakSolution wordBreakSolution = new WordBreakSolution(new HashSet<>(Arrays.asList("cats,dog,sand,and,cat".split(","))));
        boolean foundAll = wordBreakSolution.wordBreak("catsandog");
        Assert.assertFalse(foundAll);
    }

    @Test
    public void test4() {
        WordBreakSolution wordBreakSolution = new WordBreakSolution(new HashSet<>(Arrays.asList("a,what,an,nice,day".split(","))));
        boolean foundAll = wordBreakSolution.wordBreak("dawhaty");
        Assert.assertFalse(foundAll);
    }
}
