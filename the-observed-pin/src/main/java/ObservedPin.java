import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObservedPin {

    private static final Map<String, List<String>> keypadAdjacentMap = buildKeypadAdjacentMap();

    public static List<String> getPINs(String entered) {
        return keypadAdjacentMap.get(entered);
    }

    private static Map<String, List<String>> buildKeypadAdjacentMap() {
        Map<String, List<String>> keypadAdjacentMap = new HashMap<>();
        keypadAdjacentMap.put("0", List.of("0", "8"));
        keypadAdjacentMap.put("1", List.of("1", "2", "4"));
        keypadAdjacentMap.put("2", List.of("1", "2", "3", "5"));
        keypadAdjacentMap.put("3", List.of("3", "2", "6"));
        keypadAdjacentMap.put("7", List.of("7", "8", "4"));
        keypadAdjacentMap.put("9", List.of("9", "8", "6"));
        return keypadAdjacentMap;
    }
}
