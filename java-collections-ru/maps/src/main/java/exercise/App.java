package exercise;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();

        String[] words = sentence.split(" ");

        for (String word : words) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 1);
            }
            else {
                int count = wordCount.get(word);
                wordCount.put(word, count + 1);
            }
        }
        return wordCount;
    }

    public static String toString(Map<String, Integer> wordCount) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            result.append("  ");
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        result.append("}");

        return result.toString();
    }
}
//END