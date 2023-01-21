import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObservedPin {

    private static final Map<String, List<String>> keypadAdjacentMap = buildKeypadAdjacentMap();

    public static List<String> getPINs(String entered) {
        if (entered.equals("0")) {
            return keypadAdjacentMap.get(entered);
        }

        if (entered.equals("1")) {
            return List.of("1", "2", "4");
        }

        if (entered.equals("7")) {
            return List.of("7", "8", "4");
        }

        if (entered.equals("9")) {
            return List.of("9", "8", "6");
        }

        return List.of(entered);
    }

    private static Map<String, List<String>> buildKeypadAdjacentMap() {
        Map<String, List<String>> keypadAdjacentMap = new HashMap<>();
        keypadAdjacentMap.put("0", List.of("0", "8"));
        return keypadAdjacentMap;
    }
}
