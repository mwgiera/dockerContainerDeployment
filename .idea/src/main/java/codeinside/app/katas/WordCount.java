package codeinside.app.katas;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static Map<String, Integer> count(String text) {
        Map<String, Integer> out = new HashMap<>();
        if (text == null) return out;

        String trimmed = text.trim();
        if (trimmed.isEmpty()) return out;

        String[] parts = trimmed.split("\\s+");
        for (String p : parts) {
            out.put(p, out.getOrDefault(p, 0) + 1);
        }
        return out;
    }
}
