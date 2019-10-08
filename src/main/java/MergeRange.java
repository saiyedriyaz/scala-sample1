import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class MergeRange {

    static class Range implements Comparable<Range> {
        private Integer fromNum;
        private Integer toNum;

        Range(Integer fromNum, Integer toNum) {
            this.fromNum = fromNum;
            this.toNum = toNum;
        }

        @Override
        public int compareTo(Range o) {
            return this.fromNum.compareTo(o.fromNum);
        }

        @Override
        public String toString() {
            return "[" + this.fromNum + "," + this.toNum + "]";
        }

        public int[] toIntArray() {
            return new int[]{this.fromNum, this.toNum};
        }
    }

    public static void main(String[] args) {
        MergeRange mergeArray = new MergeRange();
        //mergeArray.merge(new int[][]{{2, 5}, {13, 14}, {1, 2}});
        List<Range> rangeSet = mergeArray.merge(new int[][]{{2, 6}, {8, 10}, {1, 3}, {15, 18}, {18, 21}});
    }

    List<Range> merge(int[][] intervals) {
        Set<Range> rangeSet = new TreeSet<>();

        for (int[] interval : intervals) {
            rangeSet.add(new Range(interval[0], interval[1]));
        }

        System.err.println("Before Merge:" + rangeSet);

        Stack<Range> rangeStack = new Stack<>();
        for (Range range : rangeSet) {
            if (rangeStack.isEmpty()) {
                rangeStack.push(range);
            } else {
                Range peek = rangeStack.peek();
                if (peek != null) {
                    Range merged = mergeRange(peek, range);
                    if (merged != null) {
                        rangeStack.pop();
                        rangeStack.push(merged);
                    } else {
                        rangeStack.push(range);
                    }
                }
            }
        }
        System.err.println("After Merge:" + rangeStack);
        return new ArrayList<>(rangeStack);
    }

    private Range mergeRange(Range one, Range two) {
        if (one != null && two != null && isOverlap(one.fromNum, one.toNum, two.fromNum)) {
            return new Range(one.fromNum, one.toNum < two.toNum ? two.toNum : one.toNum);
        }
        return null;
    }

    private boolean isOverlap(Integer left, Integer right, Integer comparing) {
        return left <= comparing && comparing <= right;
    }
}
