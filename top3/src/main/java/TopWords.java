import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TopWords {

    public static List<String> top3(String s) {
        if (s.isBlank()) {
            return Collections.emptyList();
        }
        return Arrays.stream(s.split(",")).map(String::toLowerCase).limit(3).collect(Collectors.toList());
    }
}