import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class TopWords {

    public static List<String> top3(String s) {
        if (s.isBlank()) {
            return Collections.emptyList();
        }
        return Arrays.stream(s.split("[, ]")).map(String::toLowerCase)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue, Integer::sum))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(3).collect(Collectors.toList());
    }
}