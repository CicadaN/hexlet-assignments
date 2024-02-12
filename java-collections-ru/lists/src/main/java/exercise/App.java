package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String abc, String word) {
        abc = abc.toLowerCase();
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (abc.indexOf(ch) == -1) {
                return false;
            }
            abc = abc.substring(0, abc.indexOf(ch)) + abc.substring(abc.indexOf(ch) + 1);
        }
        return true;
    }
}
//END

