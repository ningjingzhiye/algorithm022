import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private char[] geneCharArray = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(bank));
        if (wordSet.size() == 0 || !wordSet.contains(end)) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Set<String> beginVisited = new HashSet<>();
        Set<String> endVisited = new HashSet<>();
        beginVisited.add(start);
        endVisited.add(end);
        int step = 0;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                Set<String> tmp = beginVisited;
                beginVisited = endVisited;
                endVisited = tmp;
            }
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                    return step + 1;
                }
            }
            //原来的beginVisited废弃，从nextLevelVisited开始新的双向BFS
            beginVisited = nextLevelVisited;
            step++;
        }
        return -1;
    }

    private boolean changeWordEveryOneLetter(String word, Set<String> endVisited, Set<String> visited, Set<String> wordSet, Set<String> nextLevelVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char originChar = charArray[i];
            for (char c : geneCharArray) {
                if (originChar == c) {
                    continue;
                }
                charArray[i] = c;
                String nexWord = String.valueOf(charArray);
                if (wordSet.contains(nexWord)) {
                    if (endVisited.contains(nexWord)) {
                        return true;
                    }
                    if (!visited.contains(nexWord)) {
                        nextLevelVisited.add(nexWord);
                        visited.add(nexWord);
                    }
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }

}
