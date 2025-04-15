package dynamic;

import java.util.List;

public class CanConstruct {

    static boolean canConstruct(String sentence, List<String> words) {
        if (sentence.isEmpty()) return true;

        for (String word : words) {
            if (sentence.indexOf(word) == 0) {
                if (canConstruct(sentence.substring(word.length()), words)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("canConstruct(a, [a]) = true = " + canConstruct("a", List.of("a")));
        System.out.println("canConstruct(aa, [a]) = true = " + canConstruct("aa", List.of("a")));
        System.out.println("canConstruct(ab, [a, b]) = true = " + canConstruct("ab", List.of("a", "b")));
        System.out.println("canConstruct(abcdef, [ab, abc, cd, def, abcd]) = true = " + canConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
        System.out.println("canConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]) = true = " + canConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
    }
}
