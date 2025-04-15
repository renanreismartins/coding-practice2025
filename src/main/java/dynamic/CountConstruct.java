package dynamic;

import java.util.List;

public class CountConstruct {

    static int canConstruct(String sentence, List<String> words) {
        if (sentence.isEmpty()) return 1;

        int r = 0;
        for (String word : words) {
            if (sentence.indexOf(word) == 0) {
                r += canConstruct(sentence.substring(word.length()), words);
            }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println("canConstruct(abcdef, [ab, abc, cd, def, abcd]) = 1 = " + canConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
    }
}
