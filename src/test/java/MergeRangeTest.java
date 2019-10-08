import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MergeRangeTest {

    private MergeRange mergeRange = new MergeRange();

    @Test
    public void test1() {
        List<MergeRange.Range> mergedList = mergeRange.merge(new int[][]{{2, 6}, {8, 10}, {1, 3}, {15, 18}, {18, 21}});
        Assert.assertEquals(3, mergedList.size());
    }

    @Test
    public void test2() {
        List<MergeRange.Range> mergedList = mergeRange.merge(new int[][]{{2, 6}, {8, 10}, {1, 3}, {15, 18}, {18, 21}, {3, 15}});
        Assert.assertEquals(1, mergedList.size());
    }
}
