package count_work_use_Map;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CountWord {
    public static void main(String[] args) {
        String word = "Hello hello word";
        String lowerWord = word.toLowerCase(Locale.ROOT);
        String[] arr = lowerWord.split(" ");
        Map<String, Integer> mapWord = new HashMap<>();
        for (String s : arr) {
            if (mapWord.containsKey(s)) {
                Integer value = mapWord.get(s);
                value++;
                mapWord.replace(s, value);
            } else {
                mapWord.put(s, 1);
            }
        }
        System.out.println(mapWord);
    }
}
