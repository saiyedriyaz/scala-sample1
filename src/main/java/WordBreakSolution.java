import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakSolution {

    private Set<String> wordList;

    WordBreakSolution(Set<String> wordList) {
        this.wordList = wordList;
    }

    /**
     * arg[0] = comma separated word list for dictionary e.g. what,an,nice,day
     * arg[1] = word to be searched against dictionary e.g. whataniceday
     *
     * @param args program arguments
     */
    public static void main(String[] args) {
        String searchString;
        WordBreakSolution wordBreakSolution;
        if (args != null && args.length == 2) {
            wordBreakSolution = new WordBreakSolution(new HashSet<>(Arrays.asList(args[0].split(","))));
            searchString = args[1];
        }
        // run with sample/default test case
        else {
            wordBreakSolution = new WordBreakSolution(new HashSet<>(Arrays.asList("what,an,nice,day".split(","))));
            searchString = "what";
        }

        boolean found = wordBreakSolution.wordBreak(searchString);
        System.out.println("found all=" + found);
    }

    /**
     * Returns true if the word can be represented as token that each token is part of dictionary
     *
     * @param word work to be searched against the dictionary
     * @return true or false
     */
    boolean wordBreak(String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 1; i <= word.length(); i++) {
            if (wordList.contains(word.substring(0, i)) && wordBreak(word.substring(i))) {
                return true;
            }
        }
        return false;
    }
}
